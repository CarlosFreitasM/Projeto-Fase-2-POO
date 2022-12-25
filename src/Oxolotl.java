import java.util.ArrayList;

public class Oxolotl extends Amphibia implements Ambystoma{
    public String espName;

    public Oxolotl(){
        super.setAdultAge(12);
    }

    public Oxolotl(String name, Integer age, Double appeal, ArrayList<String> mutationList){
        super(name, age, appeal, mutationList);
        this.id = super.getId();
        this.espName="Oxolotl";
    }

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
