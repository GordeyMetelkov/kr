import java.util.HashSet;
import java.util.Set;

public class AnimalBase {

    public void addPackAnimal(Animals animal, Set<Animals> packAnimalsList) {
        packAnimalsList.add(animal);
    }
    public void addHomeAnimal(Animals animal, Set<Animals> homeAnimalsList) {
        homeAnimalsList.add(animal);
    }
}
