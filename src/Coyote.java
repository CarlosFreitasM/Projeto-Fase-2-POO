public class Coyote extends Canidae implements Canis{
    public String espName;

    public Coyote(){
        
    }

    public Coyote(String name, Integer age){
        super(name, age);
        this.espName="Coyote";
    }

    public void howl(){
        System.out.println("Coyote howled!");
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::";
        return text;
    }
}
