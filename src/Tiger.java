import java.util.ArrayList;

public class Tiger extends Felidae implements Pantherae{
    public String espName;

    public Tiger(){
        super.setAdultAge(48);
        super.setLifeExpectancy(108);
        super.setAnimalsDeathAge(calcAnimalsDeath(age, getLifeExpectancy()));
    }

    public Tiger(String name, Integer age, Double appeal, ArrayList<String> mutationList, Integer ageOfDeath){
        super(name, age, appeal, mutationList, ageOfDeath);
        this.id = super.getId();
        this.espName="Tiger";
    }

    //Calculate animal's appeal when buying an animal
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
