public class Cougar extends Felidae implements Puma{
    public String espName;

    public Cougar(){
        
    }

    public Cougar(String name, Integer age){
        super(name, age);
        this.espName="Cougar";
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::";
        return text;
    }
}
