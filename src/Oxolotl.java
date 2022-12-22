public class Oxolotl extends Amphibia implements Ambystoma{
    public String espName;

    public Oxolotl(){
        
    }

    public Oxolotl(String name, Integer age){
        super(name, age);
        this.espName="Oxolotl";
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", " + getFamily() + "::";
        return text;
    }
}
