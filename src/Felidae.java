import java.util.ArrayList;

public abstract class Felidae extends Animal{
    public String animalFamily, espName;

    private final String[] animalName = {
        "Lion",
        "Tiger",
        "Cheetah",
        "Couger",
        "Leopard",
      };

    public Felidae(){
        
    }

    public Felidae(String name, Integer age, Double appeal, ArrayList<String> mutationList){
        super(name, age, appeal, mutationList);
        this.id = super.getId();
        this.animalFamily= "Felidae";
    }

    public String getEspName(){
        return this.espName;
    }

    public String getFamily(){
        return animalFamily;

    }

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
