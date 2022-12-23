import java.util.ArrayList;

public class Cougar extends Felidae implements Puma {
    public String espName;

    public Cougar() {

    }

    public Cougar(String name, Integer age, ArrayList<String> mutationList) {
        super(name, age, mutationList);
        this.espName = "Cougar";
    }

    public String toString() {
        String text = super.toString();
        text += "Da espécie: " + espName + ", " + getFamily() + "::\n";
        return text;
    }
}
