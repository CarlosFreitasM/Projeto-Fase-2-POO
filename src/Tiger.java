import java.util.ArrayList;

public class Tiger extends Felidae implements Pantherae{
    public String espName;

    public Tiger(){
        
    }

    public Tiger(String name, Integer age, ArrayList<String> mutationList){
        super(name, age, mutationList);
        this.espName="Tiger";
    }

    public void growl(){
        System.out.println("Tigre rugiu!");
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::\n";
        return text;
    }
}
