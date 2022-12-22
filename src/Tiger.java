public class Tiger extends Felidae implements Pantherae{
    public String espName;

    public Tiger(){
        
    }

    public Tiger(String name, Integer age){
        super(name, age);
        this.espName="Tiger";
    }

    public void growl(){
        System.out.println("Tigre rugiu!");
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::";
        return text;
    }
}
