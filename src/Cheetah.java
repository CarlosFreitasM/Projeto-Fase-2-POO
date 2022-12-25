import java.util.ArrayList;

public class Cheetah extends Felidae implements Acynonyx{
    public String espName;

    public Cheetah(){
        super.setAdultAge(22);
    }

    public Cheetah(String name, Integer age, Double appeal, ArrayList<String> mutationList){
        super(name, age, appeal, mutationList);
        this.id = super.getId();
        this.espName="Cheetah";
    }

    public double calcAppealBuying(){

        return ((super.calcAppealBuying()*1.3)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public int getAdultAge(){
        return this.adultAge;
    }

    public void setAppeal(){

        this.appeal=((calcAppealBuying()*1.3)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::\n";
        return text;
    }
}
