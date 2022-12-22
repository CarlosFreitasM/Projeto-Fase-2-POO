public class Cheetah extends Felidae implements Acynonyx{
    public String espName;

    public Cheetah(){
        
    }

    public Cheetah(String name, Integer age){
        super(name, age);
        this.espName="Cheetah";
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::";
        return text;
    }
}
