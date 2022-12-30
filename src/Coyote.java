import java.util.ArrayList;

public class Coyote extends Canidae implements Canis{
    public String espName;

    public Coyote(){
        super.setAdultAge(168);
    }

    public Coyote(String name, Integer age, Double appeal, ArrayList<String> mutationList, Integer ageOfDeath){
        super(name, age, appeal, mutationList, ageOfDeath);
        this.id = super.getId();
        this.espName="Coyote";
    }


    public double calcAppealBuying(){

        return ((super.calcAppealBuying()*1.4)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public void setAppeal(){
        
        this.appeal=((calcAppealBuying()*1.4)+super.calcAppealMultipler())*super.getAgeDeduction();
    }

    public int getAdultAge(){
        return this.adultAge;
    }

    public void howl(){
        System.out.println("Coyote howled!");
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::\n";
        return text;
    }
}
