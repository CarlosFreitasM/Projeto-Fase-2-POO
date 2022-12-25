import java.util.ArrayList;

public class Wolf extends Canidae implements Canis{
    public String espName;

    public Wolf(){
        super.setAdultAge(30);
    }

    public Wolf(String name, Integer age, Double appeal, ArrayList<String> mutationList){
        super(name, age, appeal, mutationList);
        this.id = super.getId();
        this.espName="Wolf";
    }

    public double calcAppealBuying(){

        return ((super.calcAppealBuying()*1.7)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public void setAppeal(){
        
        this.appeal=((calcAppealBuying()*1.7)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public int getAdultAge(){
        return this.adultAge;
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
