import java.util.ArrayList;

public class Firesalamandre extends Amphibia implements Salamandre{
    public String espName;

    public Firesalamandre(){
        
    }

    public Firesalamandre(String name, Integer age, ArrayList<String> mutationList){
        super(name, age, mutationList);
        this.espName="Firesalamandre";
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::\n";
        return text;
    }
}
