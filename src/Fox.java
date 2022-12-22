public class Fox extends Canidae implements Vulpes{
    public String espName;

    public Fox(){
        
    }

    public Fox(String name, Integer age){
        super(name, age);
        this.espName="Fox";
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::";
        return text;
    }
}
