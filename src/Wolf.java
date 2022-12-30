import java.util.ArrayList;

public class Wolf extends Canidae implements Canis{
    public String espName;

    public Wolf(){
        super.setAdultAge(30);
        super.setLifeExpectancy(138);
        super.setAnimalsDeathAge(calcAnimalsDeath(age, getLifeExpectancy()));
    }

    public Wolf(String name, Integer age, Double appeal, ArrayList<String> mutationList, Integer ageOfDeath){
        super(name, age, appeal, mutationList, ageOfDeath);
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
