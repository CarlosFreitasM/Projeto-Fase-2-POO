import java.util.ArrayList;

public class Firesalamandre extends Amphibia implements Salamandre{
    private String espName;

    public Firesalamandre(){
        super.setAdultAge(3);
        super.setLifeExpectancy(240);
        super.setAnimalsDeathAge(calcAnimalsDeath(age, getLifeExpectancy()));
    }

    public Firesalamandre(String name, Integer age, Double appeal, ArrayList<String> mutationList, Integer ageOfDeath){
        super(name, age, appeal, mutationList, ageOfDeath);
        super.setAdultAge(3);
        this.id = super.getId();
        this.espName="Firesalamandre";
    }
    //Fire salamandre's appeal is boosted further by 1.2 time, but every animal has a 0%-30% deduction to their profits based on age of the animal until they turn into an adult
    //New born have a 0% penalty (Age:0)
    //Adults have a 30% penalty
    public double calcAppealBuying(){

        return ((super.calcAppealBuying()*1.2)+super.calcAppealMultipler())*super.getAgeDeduction();
    }


    public void setAppeal(){
        
        this.appeal=((calcAppealBuying()*1.2)+super.calcAppealMultipler())*super.getAgeDeduction();
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
