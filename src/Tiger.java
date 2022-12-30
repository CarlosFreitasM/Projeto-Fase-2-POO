import java.util.ArrayList;

public class Tiger extends Felidae implements Pantherae{
    private String espName;

    public Tiger(){
        super.setAdultAge(48);
        super.setLifeExpectancy(108);
        super.setAnimalsDeathAge(calcAnimalsDeath(age, getLifeExpectancy()));
    }

    public Tiger(String name, Integer age, Double appeal, ArrayList<String> mutationList, Integer ageOfDeath){
        super(name, age, appeal, mutationList, ageOfDeath);
        super.setAdultAge(48);
        this.id = super.getId();
        this.espName="Tiger";
    }

    //Tiger's appeal is boosted further by 1.7 time, but every animal has a 0%-30% deduction to their profits based on age of the animal until they turn into an adult
    //New born have a 0% penalty (Age:0)
    //Adults have a 30% penalty
    public double calcAppealBuying(){
        return ((super.calcAppealBuying()*1.7)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public int getAdultAge(){
        return this.adultAge;
    }

    public void setAppeal(){

        this.appeal=((calcAppealBuying()*1.7)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public void growl(){
        System.out.println("Tigre rugiu!");
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::\n";
        return text;
    }
}
