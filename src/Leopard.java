import java.util.ArrayList;

public class Leopard extends Felidae implements Pantherae{
    public String espName;

    public Leopard(){
        
    }

    public Leopard(String name, Integer age, ArrayList<String> mutationList){
        super(name, age, mutationList);
        this.espName="Leopard";
    }

    public void growl(){
        System.out.println("Leopardo rugiu!");
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::\n";
        return text;
    }
}
