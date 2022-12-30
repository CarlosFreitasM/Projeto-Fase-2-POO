import java.util.ArrayList;

public class Oxolotl extends Amphibia implements Ambystoma{
    public String espName;

    public Oxolotl(){
        super.setAdultAge(12);
        super.setLifeExpectancy(156);
        super.setAnimalsDeathAge(calcAnimalsDeath(age, getLifeExpectancy()));
    }

    public Oxolotl(String name, Integer age, Double appeal, ArrayList<String> mutationList, Integer ageOfDeath){
        super(name, age, appeal, mutationList, ageOfDeath);
        super.setAdultAge(12);
        this.id = super.getId();
        this.espName="Oxolotl";
    }

    //Oxolotl's appeal is boosted further by 1.65 time, but every animal has a 0%-30% deduction to their profits based on age of the animal until they turn into an adult
    //New born have a 0% penalty (Age:0)
    //Adults have a 30% penalty
    public double calcAppealBuying(){

        return ((super.calcAppealBuying()*1.65)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public void setAppeal(){
        
        this.appeal=((calcAppealBuying()*1.65)+super.calcAppealMultipler())*super.getAgeDeduction();
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
