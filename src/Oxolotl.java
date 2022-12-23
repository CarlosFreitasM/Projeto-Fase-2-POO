import java.util.ArrayList;

public class Oxolotl extends Amphibia implements Ambystoma{
    public String espName;

    public Oxolotl(){
        
    }

    public Oxolotl(String name, Integer age, ArrayList<String> mutationList){
        super(name, age, mutationList);
        this.espName="Oxolotl";
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::\n";
        return text;
    }
}
