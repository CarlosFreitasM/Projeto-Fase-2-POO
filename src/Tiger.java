import java.util.ArrayList;

public class Tiger extends Felidae implements Pantherae{
    public String espName;

    public Tiger(){
        super.setAdultAge(48);
    }

    public Tiger(String name, Integer age, Double appeal, ArrayList<String> mutationList){
        super(name, age, appeal, mutationList);
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
