import java.util.ArrayList;

public class Cheetah extends Felidae implements Acynonyx{
    private String espName;

    public Cheetah(){
        super.setAdultAge(22);
        super.setLifeExpectancy(108);
        super.setAnimalsDeathAge(calcAnimalsDeath(age, getLifeExpectancy()));
    }

    public Cheetah(String name, Integer age, Double appeal, ArrayList<String> mutationList, Integer ageOfDeath){
        super(name, age, appeal, mutationList, ageOfDeath);
        super.setAdultAge(22);
        this.id = super.getId();
        this.espName="Cheetah";
    }
    //Cheetah's appeal is boosted further by 1.3 time, but every animal has a 0%-30% deduction to their profits based on age of the animal until they turn into an adult
    //New born have a 0% penalty (Age:0)
    //Adults have a 30% penalty (Cheetah is and adult at 22 months)
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
