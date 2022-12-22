public class Firesalamandre extends Amphibia implements Salamandre{
    public String espName;

    public Firesalamandre(){
        
    }

    public Firesalamandre(String name, Integer age){
        super(name, age);
        this.espName="Firesalamandre";
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::";
        return text;
    }
}
