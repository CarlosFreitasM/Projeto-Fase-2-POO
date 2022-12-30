import java.util.ArrayList;

public class Leopard extends Felidae implements Pantherae{
    private String espName;

    public Leopard(){
        super.setAdultAge(21);
        super.setLifeExpectancy(132);
        super.setAnimalsDeathAge(calcAnimalsDeath(age, getLifeExpectancy()));
    }

    public Leopard(String name, Integer age, Double appeal, ArrayList<String> mutationList, Integer ageOfDeath){
        super(name, age, appeal, mutationList, ageOfDeath);
        super.setAdultAge(21);
        this.mutationList=super.getMutations();
        this.espName="Leopard";
    }

    //Leopard's appeal is boosted further by 1.55 time, but every animal has a 0%-30% deduction to their profits based on age of the animal until they turn into an adult
    //New born have a 0% penalty (Age:0)
    //Adults have a 30% penalty
    public double calcAppealBuying(){

        return ((super.calcAppealBuying()*1.55)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public void setAppeal(){
        this.appeal=((super.calcAppealBuying()*1.55)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public int getAdultAge(){
        return this.adultAge;
    }



    public void growl(){
        System.out.println("Leopardo rugiu!");
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::\n";
        return text;
    }
}
