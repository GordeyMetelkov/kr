import java.util.ArrayList;

public class HomeAnimals extends Animals{

    
    public HomeAnimals(int id, String name, String bdate, ArrayList<String> commands) {
        super(id, name, bdate, commands);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Тип животного: %s\n", "Домашние");
    }
    
}
