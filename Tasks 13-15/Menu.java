import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void showMainMenu() {
        System.out.println("Введите цифру необходимого действия: \n" +
                "1. Показать весь питомник\n" +
                "2. Показать только выбранный вид животных\n" +
                "3. Увидеть список команд, выполняемых животным\n" +
                "4. Обучить животное новым командам\n" +
                "5. Завести новое животное");
    }


    public void printOnlySelectedClass(Set<Animals> homeAnimalsList, Set<Animals> packAnimalsList) {
        System.out.println("Выберите вид животных: \n" +
                "1. Домашние\n" +
                "2. Вьючные");
        int userSelect = scanner.nextInt();
        switch (userSelect) {
            case 1:
                System.out.println(homeAnimalsList);
                break;
            case 2:
                System.out.println(packAnimalsList);
                break;
        }
    }

    public void showComands(Set<Animals> homeAnimalsList, Set<Animals> packAnimalsList){
        System.out.println("Выберите тип животных: \n" +
                "1. Домашние\n" +
                "2. Вьючные");
        int userSelectedClass = scanner.nextInt();
        int userSelected;
        switch (userSelectedClass) {    
            case 1:
                System.out.println("Выберите вид животных: \n" +
                "1. Кошки\n" +
                "2. Собаки\n" +
                "3. Хомяки\n");
                userSelected = scanner.nextInt();
                Set<Animals> cats = new HashSet<>();
                Set<Animals> dogs = new HashSet<>();
                Set<Animals> hamsters = new HashSet<>();
                for (Animals animal : homeAnimalsList) {
                    if (animal.getClass() == Cat.class) {
                        cats.add(animal);
                    }
                    else if (animal.getClass() == Dog.class) {
                        dogs.add(animal);
                    }
                    else {
                        hamsters.add(animal);
                    }
                }
                switch (userSelected) {
                    case 1:
                        for (Animals animal : cats) {
                            System.out.println(animal.getName() + " умеет " + animal.commands);
                        }
                        break;
                    case 2:
                        for (Animals animal : dogs) {
                            System.out.println(animal.getName() + " умеет " + animal.commands);
                        }
                        break;
                    case 3:
                        for (Animals animal : hamsters) {
                            System.out.println(animal.getName() + " умеет " + animal.commands);
                        }
                        break;
                    }
            break;
            case 2:
                System.out.println("Выберите вид животных: \n" +
                "1. Верблюды\n" +
                "2. Ослы\n" +
                "3. Лошади\n");
                userSelected = scanner.nextInt();
                Set<Animals> camels = new HashSet<>();
                Set<Animals> donkeys = new HashSet<>();
                Set<Animals> horses = new HashSet<>();
                for (Animals animal : packAnimalsList) {
                    if (animal.getClass() == Camel.class) {
                        camels.add(animal);
                    }
                    else if (animal.getClass() == Donkey.class) {
                        donkeys.add(animal);
                    }
                    else {
                        horses.add(animal);
                    }
                }
                switch (userSelected) {
                    case 1:
                        for (Animals animal : camels) {
                            System.out.println(animal.getName() + " умеет " + animal.commands);
                        }
                        break;
                    case 2:
                        for (Animals animal : donkeys) {
                            System.out.println(animal.getName() + " умеет " + animal.commands);
                        }
                        break;
                    case 3:
                        for (Animals animal : horses) {
                            System.out.println(animal.getName() + " умеет " + animal.commands);
                        }
                        break;
                    }
            break;
            }
    }

    public void newComand(Animals animal){
        System.out.println("Какой команде обучить?");
        String command = scanner.next();
        animal.commands.add(command);
        System.out.println(animal.getName() + " умеет " + animal.commands);
    }

    public Animals newAnimal() {
        Animals animal = new Animals(0, null, null, null);
        System.out.println("Введите ID животного: ");
        int animal_id = scanner.nextInt();
        System.out.println("Введите имя животного: ");
        String animal_name = scanner.next();
        System.out.println("Введите дату рождения животного: ");
        String animal_bdate = scanner.next();
        ArrayList<String> commands = new ArrayList<>();
        System.out.println("Выберите тип животных: \n" +
                "1. Домашние\n" +
                "2. Вьючные");
        int userSelectedClass = scanner.nextInt();
        int userSelected;
        switch (userSelectedClass) {    
            case 1:
                System.out.println("Выберите вид животных: \n" +
                "1. Кошки\n" +
                "2. Собаки\n" +
                "3. Хомяки\n");
                userSelected = scanner.nextInt();
                switch (userSelected) {
                    case 1:
                        Cat cat = new Cat(animal_id, animal_name, animal_bdate, commands);
                        animal = cat;
                        break;
                    case 2:
                        Dog dog = new Dog(animal_id, animal_name, animal_bdate, commands);
                        animal = dog;
                        break;
                    case 3:
                        Hamster hamster = new Hamster(animal_id, animal_name, animal_bdate, commands);
                        animal = hamster;
                        break;
                    }
            break;
            case 2:
                System.out.println("Выберите вид животных: \n" +
                "1. Верблюды\n" +
                "2. Ослы\n" +
                "3. Лошади\n");
                userSelected = scanner.nextInt();
                switch (userSelected) {
                    case 1:
                        Camel camel = new Camel(animal_id, animal_name, animal_bdate, commands);
                        animal = camel;
                        break;
                    case 2:
                        Donkey donkey = new Donkey(animal_id, animal_name, animal_bdate, commands);
                        animal = donkey;
                        break;
                    case 3:
                        Horse horse = new Horse(animal_id, animal_name, animal_bdate, commands);
                        animal = horse;
                        break;
                    }
            break;
            }
        return animal;
    }
}
