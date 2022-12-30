import java.util.ArrayList;

public class Fox extends Canidae implements Vulpes{
    private String espName;

    public Fox(){
        super.setAdultAge(10);
        super.setLifeExpectancy(48);
        super.setAnimalsDeathAge(calcAnimalsDeath(age, getLifeExpectancy()));
    }

    public Fox(String name, Integer age, Double appeal, ArrayList<String> mutationList, Integer ageOfDeath){
        super(name, age, appeal, mutationList, ageOfDeath);
        super.setAdultAge(10);
        this.id = super.getId();
        this.espName="Fox";
    }
    // Animals of the Vulpes genetic/genus can and are proficient in burrowing
    public void burrow(){
        System.out.print("Fox went to it's burrow!");
    }
    //Fox's appeal is boosted further by 1.6 time, but every animal has a 0%-30% deduction to their profits based on age of the animal until they turn into an adult
    //New born have a 0% penalty (Age:0)
    //Adults have a 30% penalty
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
