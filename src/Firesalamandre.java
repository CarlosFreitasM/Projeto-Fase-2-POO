import java.util.ArrayList;

public class Firesalamandre extends Amphibia implements Salamandre{
    public String espName;

    public Firesalamandre(){
        super.setAdultAge(3);
    }

    public Firesalamandre(String name, Integer age, Double appeal, ArrayList<String> mutationList){
        super(name, age, appeal, mutationList);
        this.id = super.getId();
        this.espName="Firesalamandre";
    }

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
