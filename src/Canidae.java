import java.util.ArrayList;

public abstract class Canidae extends Animal{
    public String animalFamily, espName;

    private final String[] animalName = {
        "Wolf",
        "Coyote",
        "Fox",
      };

    public Canidae(){
        
    }

    public Canidae(String name, Integer age, ArrayList<String> mutationList){
        super(name, age, mutationList);
        this.id = super.getId();
        this.animalFamily= "Canidae";
    }

    public String getEspName(){
        return this.espName;
    }

    public String getFamily(){
        return animalFamily;

    }
}
