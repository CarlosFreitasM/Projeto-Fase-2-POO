public class Leopard extends Felidae implements Pantherae{
    public String espName;

    public Leopard(){
        
    }

    public Leopard(String name, Integer age){
        super(name, age);
        this.espName="Leopard";
    }

    public void growl(){
        System.out.println("Leopardo rugiu!");
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::";
        return text;
    }
}
