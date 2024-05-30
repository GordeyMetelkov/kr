import java.util.ArrayList;
import java.util.Objects;

public class Animals {

    private int id;
    private String name;
    private String bdate;
    ArrayList<String> commands;
   
    public Animals(int id, String name, String bdate, ArrayList<String> commands) {
        this.id = id;
        this.name = name;
        this.bdate = bdate;
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        return this.id = id;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String getBdate() {
        return bdate;
    }

    public String setBdate(String bdate) {
        return this.bdate = bdate;
    }
  
    public ArrayList<String> getCommands() {
        return commands;
    }

    public ArrayList<String> setCommands(ArrayList<String> commands) {
        return this.commands = commands;
    }
    public void feed() {
        System.out.println(name + " сыт.");
    }
    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Animals animal = (Animals) o;
            return this.name.equals(animal.name) 
                    && this.id == animal.id 
                    && this.bdate.equals(animal.bdate)
                    && this.commands.equals((animal.commands));
        }
    @Override
        public int hashCode() {
            return Objects.hash(id, name, bdate, commands);
        }
    @Override
    public String toString() {
        return String.format("id: %d\nName: %s\nДата Рождения: %s\n", this.id, this.name, this.bdate);

    }
}