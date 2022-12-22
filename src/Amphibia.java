public abstract class Amphibia extends Animal{
    public String animalFamily, espName;

    private final String[] animalName = {
        "Fire Salamandre",
        "Oxolotl",
      };

    public Amphibia(){
        
    }

    public Amphibia(String name, Integer age){
        super(name, age);
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
