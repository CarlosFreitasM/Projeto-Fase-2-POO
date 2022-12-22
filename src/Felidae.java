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

    public Felidae(String name, Integer age){
        super(name, age);
        this.id = super.getId();
        this.animalFamily= "Felidae";
    }

    public String getEspName(){
        return this.espName;
    }

    public String getFamily(){
        return animalFamily;

    }
}
