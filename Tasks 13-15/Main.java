import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Main {
    
    public static void main(String[] args) {
        Set<Animals> homeAnimalsList = new HashSet<>();
        Set<Animals> packAnimalsList = new HashSet<>();
        AnimalBase ab = new AnimalBase();
        ArrayList<String> commands = new ArrayList<>();
        ArrayList<String> commands2 = new ArrayList<>();
        Camel verblud = new Camel(0, "Dfcz", "19.02.2000", commands);
        Camel verblud2 = new Camel(1, "Vasya", "19.02.2000", commands2);
        verblud.commands.add("Go");
        verblud2.commands.add("Sit");
        verblud2.commands.add("Down");
        ab.addPackAnimal(verblud, packAnimalsList);
        ab.addPackAnimal(verblud2, packAnimalsList);
        Menu menu = new Menu();
        Animals animal = menu.newAnimal();
        if (
            animal.getClass() == Camel.class ||
            animal.getClass() == Donkey.class ||
            animal.getClass() == Horse.class
            ) {
            ab.addPackAnimal(animal, packAnimalsList);
        }
        else {
            ab.addHomeAnimal(animal, homeAnimalsList);
        }
    }
}
