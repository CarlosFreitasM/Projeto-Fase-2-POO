import java.util.ArrayList;

public abstract class Canidae extends Animal{
    private String animalFamily, espName;

    private final String[] animalName = {
        "Wolf",
        "Coyote",
        "Fox",
      };

    public Canidae(){
        
    }

    public Canidae(String name, Integer age, Double appeal, ArrayList<String> mutationList, Integer ageOfDeath){
        super(name, age, appeal, mutationList, ageOfDeath);
        this.id = super.getId();
        this.animalFamily= "Canidae";
    }

    public String getEspName(){
        return this.espName;
    }

    public String getFamily(){
        return animalFamily;

    }
    // Animals of the Canidae have a 1.7 times boost to their appeal
    public double calcAppealBuying(){
        return baseAppeal*1.7;
    }

    public void setAppeal(){
        this.appeal=baseAppeal*1.7;
    }

    public int getAdultAge(){
        return adultAge;
    }
}
