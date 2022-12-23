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

    public Felidae(String name, Integer age, ArrayList<String> mutationList){
        super(name, age, mutationList);
        this.id = super.getId();
        this.mutationList=super.getMutations();
        this.animalFamily= "Felidae";
    }

    public String getEspName(){
        return this.espName;
    }

    public String getFamily(){
        return animalFamily;

    }

    
}
