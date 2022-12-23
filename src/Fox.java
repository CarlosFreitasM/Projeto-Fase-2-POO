import java.util.ArrayList;

public class Fox extends Canidae implements Vulpes{
    public String espName;

    public Fox(){
        
    }

    public Fox(String name, Integer age, ArrayList<String> mutationList){
        super(name, age, mutationList);
        this.espName="Fox";
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::\n";
        return text;
    }
}
