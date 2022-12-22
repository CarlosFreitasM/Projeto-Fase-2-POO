public class Tiger extends Felidae implements Pantherae{
    public double percBeingFemale;

    public Tiger(){
        this.espName="Tiger";
    }

    public Tiger(String name, Integer age, double percBeingFemale){
        super(name, age);
        this.espName="Tiger";
        this.percBeingFemale= percBeingFemale;
    }

    public void growl(){
        System.out.println("Tigre rugiu!");
    }
}
