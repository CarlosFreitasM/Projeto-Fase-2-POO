import java.util.ArrayList;

public class Fox extends Canidae implements Vulpes{
    public String espName;

    public Fox(){
        super.setAdultAge(10);
        super.setLifeExpectancy(48);
        super.setAnimalsDeathAge(calcAnimalsDeath(age, getLifeExpectancy()));
    }

    public Fox(String name, Integer age, Double appeal, ArrayList<String> mutationList, Integer ageOfDeath){
        super(name, age, appeal, mutationList, ageOfDeath);
        this.id = super.getId();
        this.espName="Fox";
    }

    public double calcAppealBuying(){

        return ((super.calcAppealBuying()*1.6)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public void setAppeal(){
        
        this.appeal=((calcAppealBuying()*1.6)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public int getAdultAge(){
        return this.adultAge;
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::\n";
        return text;
    }
}
