import java.util.ArrayList;

public class Coyote extends Canidae implements Canis{
    public String espName;

    public Coyote(){
        
    }

    public Coyote(String name, Integer age, ArrayList<String> mutationList){
        super(name, age, mutationList);
        this.espName="Coyote";
    }

    public void howl(){
        System.out.println("Coyote howled!");
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::\n";
        return text;
    }
}
