import java.util.ArrayList;

public class Wolf extends Canidae implements Canis{
    public String espName;

    public Wolf(){
        
    }

    public Wolf(String name, Integer age, ArrayList<String> mutationList){
        super(name, age, mutationList);
        this.espName="Wolf";
    }

    public void howl(){
        System.out.println("Wolf howled!");
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::\n";
        return text;
    }
}
