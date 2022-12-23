import java.util.ArrayList;

public abstract class Amphibia extends Animal{
    public String animalFamily, espName;

    private final String[] animalName = {
        "Fire Salamandre",
        "Oxolotl",
      };

    public Amphibia(){
        
    }

    public Amphibia(String name, Integer age, ArrayList<String> mutationList){
        super(name, age, mutationList);
        this.id = super.getId();
        this.animalFamily= "Amphibia";
    }

    public String getEspName(){
        return this.espName;
    }

    public String getFamily(){
        return animalFamily;

    }
    
}
