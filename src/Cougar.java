import java.util.ArrayList;

public class Cougar extends Felidae implements Puma {
    public String espName;

    public Cougar() {
        super.setAdultAge(21);
    }

    public Cougar(String name, Integer age, Double appeal, ArrayList<String> mutationList) {
        super(name, age, appeal, mutationList);
        this.id = super.getId();
        this.espName = "Cougar";
    }

    public double calcAppealBuying(){

        return ((super.calcAppealBuying()*1.55)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public void setAppeal(){

        this.appeal=((calcAppealBuying()*1.55)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public int getAdultAge(){
        return this.adultAge;
    }


    public String toString() {
        String text = super.toString();
        text += "Da espécie: " + espName + ", " + getFamily() + "::\n";
        return text;
    }
}
