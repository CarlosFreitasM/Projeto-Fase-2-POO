public abstract class Canidae extends Animal{
    public String animalFamily, espName;

    private final String[] animalName = {
        "Wolf",
        "Coyote",
        "Fox",
      };

    public Canidae(){
        
    }

    public Canidae(String name, Integer age){
        super(name, age);
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
