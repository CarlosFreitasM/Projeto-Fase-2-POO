public class Lion extends Felidae implements Pantherae{
    public double percBeingFemale;
    public String espName;

    public Lion(){
        this.espName="Lion";
    }

    public Lion(String name, Integer age, double percBeingFemale){
        super(name, age);
        this.espName="Lion";
        this.percBeingFemale= percBeingFemale;
    }

    public double getPercBeingFemale(){
        return percBeingFemale;
    }

    public void growl(){
        System.out.println("Leao rugiu!");
    }
}
