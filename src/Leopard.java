public class Leopard extends Felidae implements Pantherae{
    public double percBeingFemale;
    public String espName;

    public Leopard(){
        this.espName="Lion";
    }

    public Leopard(String name, Integer age, double percBeingFemale){
        super(name, age);
        this.espName="Leopard";
        this.percBeingFemale= percBeingFemale;
    }

    public double getPercBeingFemale(){
        return percBeingFemale;
    }

    public void growl(){
        System.out.println("Leopardo rugiu!");
    }
}
