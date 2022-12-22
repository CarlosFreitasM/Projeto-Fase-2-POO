public class Wolf extends Canidae implements Canis{
    public String espName;

    public Wolf(){
        
    }

    public Wolf(String name, Integer age){
        super(name, age);
        this.espName="Wolf";
    }

    public void howl(){
        System.out.println("Wolf howled!");
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::";
        return text;
    }
}
