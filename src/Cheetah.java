import java.util.ArrayList;

public class Cheetah extends Felidae implements Acynonyx{
    public String espName;

    public Cheetah(){
        
    }

    public Cheetah(String name, Integer age, ArrayList<String> mutationList){
        super(name, age, mutationList);
        this.espName="Cheetah";
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::\n";
        return text;
    }
}
