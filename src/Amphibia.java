import java.util.ArrayList;

public abstract class Amphibia extends Animal{
    public String animalFamily, espName;

    private final String[] animalName = {
        "Fire Salamandre",
        "Oxolotl",
      };

    public Amphibia(){
        
    }

    public Amphibia(String name, Integer age, Double appeal, ArrayList<String> mutationList, Integer ageOfDeath){
        super(name, age, appeal, mutationList, ageOfDeath);
        this.id = super.getId();
        this.animalFamily= "Amphibia";
    }

    public String getEspName(){
        return this.espName;
    }

    public String getFamily(){
        return animalFamily;

    }

    public double calcAppealBuying(){
        return baseAppeal*1.2;
    }

    public void setAppeal(){
        this.appeal=baseAppeal*1.2;
    }

    public int getAdultAge(){
        return adultAge;
    }
    
}
