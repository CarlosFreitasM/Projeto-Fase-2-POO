import java.util.ArrayList;
import java.util.Random;

public class Lion extends Felidae implements Pantherae{
    public String gender;
    public String espName;

    public Lion(){
        super.setAdultAge(24);
        super.setLifeExpectancy(168);
        super.setAnimalsDeathAge(calcAnimalsDeath(age, getLifeExpectancy()));
    }

    public Lion(String name, Integer age, Double appeal, ArrayList<String> mutationList, Integer ageOfDeath){
        super(name, age, appeal, mutationList, ageOfDeath);
        this.id = super.getId();
        this.espName="Lion";
        this.gender=getGender();
    }

    public String getGender(){
        int i = new Random().nextInt(100);
        if(i<30)
            return "Male";
       else
            return "Female";
    }


    public double calcAppealBuying(){

        return ((super.calcAppealBuying()*1.5)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public void setAppeal(){
        
        this.appeal=((calcAppealBuying()*1.5)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public int getAdultAge(){
        return this.adultAge;
    }


    public void growl(){
        System.out.println("Leao rugiu!");
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", ";
        text+="Gender: "+gender+", " + getFamily() + "::\n";
        return text;
    }
}
