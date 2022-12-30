import java.util.ArrayList;

public abstract class Felidae extends Animal{
    private String animalFamily, espName;

    private final String[] animalName = {
        "Lion",
        "Tiger",
        "Cheetah",
        "Couger",
        "Leopard",
      };

    public Felidae(){
        
    }

    public Felidae(String name, Integer age, Double appeal, ArrayList<String> mutationList, Integer ageOfDeath){
        super(name, age, appeal, mutationList, ageOfDeath);
        this.id = super.getId();
        this.animalFamily= "Felidae";
    }

    public String getEspName(){
        return this.espName;
    }

    public String getFamily(){
        return animalFamily;

    }
    // Animals of the Canidae have a 2 times boost to their appeal
    public double calcAppealBuying(){
        return baseAppeal*2;
    }

    public void setAppeal(){
        this.appeal=baseAppeal*2;
    }

    public int getAdultAge(){
        return adultAge;
    }
    
}
