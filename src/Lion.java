import java.util.Random;

public class Lion extends Felidae implements Pantherae{
    public String gender;
    public String espName;

    public Lion(){
        
    }

    public Lion(String name, Integer age){
        super(name, age);
        this.id = super.getId();
        this.espName="Lion";
        this.gender=getGender();
    }

    public String getGender(){
        int i = new Random().nextInt(100);
        if(i<30)
            return "Male";
       else
            return "Female";
    }

    public void growl(){
        System.out.println("Leao rugiu!");
    }

    public String toString(){
        String text = super.toString();
        text+="Da espécie: "+espName+", ";
        text+="Gender: "+gender+", " + getFamily() + "::";
        return text;
    }
}
