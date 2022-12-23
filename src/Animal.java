import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.lang.Math;
import java.util.concurrent.atomic.AtomicInteger;

public class Animal implements Mutation{

  // https://stackoverflow.com/questions/24305830/java-auto-increment-id

  // Animal ->
  // Espécie (cada espécie tem características definidas)

  private static final AtomicInteger count = new AtomicInteger(-1);
  private static final AtomicInteger newMethod = new AtomicInteger(-1);
  public int id, age, appeal, multipler;
  public String name;
  public ArrayList<String> mutationList = new ArrayList<String>();
  public boolean isAlbino, isLeucism, isMelanism, isHeteroch;
  //HashMap<String, Double> mutationList = Mutations.createHashMap();
  private final String[] artisticNames = {
    "Pong",
    "Neon",
    "Cedar",
    "Oliver",
    "Grunt",
    "Quasar",
    "Jade",
    "Bagel",
    "Wendy",
    "Rapunzel",
  };
  

  //public abstract void interact();

  public Animal(){
    Random rand = new Random();
    this.id = count.incrementAndGet();
    this.name =
      artisticNames[Rand.getRandomNumberInRange(0, artisticNames.length - 1)];
    age = rand.nextInt(30);
    multipler=1;
    isAlbino=calcAlbinism(multipler);
    if(isAlbino==true){mutationList.add("Albinism");}
    multipler*=100;
    isLeucism=calcLeucism(multipler);
    if(isLeucism==true){mutationList.add("Leucism");}
    multipler*=100;
    isMelanism=calcMelanism(multipler);
    if(isMelanism==true){mutationList.add("Melanism");}
    multipler*=100;
    isHeteroch=calcHeterochromia(multipler);
    if(isHeteroch==true){mutationList.add("Heterochromia");}
    //this.mutation = mutationList[Objects.hash(this.id, this.name, this.mutation)]
    // Objects.hash(this.id, this.name, this.mutation);
    System.out.println("NEW ANIMAL");
    System.out.println("NAME: " + name);
    System.out.println("ID: " + id);

    System.out.println("MUTATIONS: ");
    for(int j=0; j<mutationList.size(); j++){
      if(mutationList.size()==0){
        System.out.println("This animal has no mutations!");
      }
      System.out.println("Has " + mutationList.get(j));
    }
    // System.out.println("MUTATION: " + mutation);
  }

  // De forma a fazer com que os animais que entram no zoo nao têm o ID separa por causa da criação de 3 animais de cada vez que se tenta obter quais 3 animais escolher
  // Assim, os animais que forem adicionados ao zoo têm um ID consistente e linear
  public Animal(String name, Integer age, ArrayList<String> mutationList) {
    this.id = newMethod.incrementAndGet();
    this.name = name;
    this.age=age;
    this.mutationList=mutationList;
  }

  public void sleep() {
    System.out.println("zZzZz...");
  }

  //CALCULATION TO SEE IF THE ANIMAL HAS MUTATIONS
  public boolean calcAlbinism(Integer m){
    Boolean chanc = Math.abs((Objects.hash(id, name, age)/m)%100)<25;
    return chanc;
  }

  public boolean calcLeucism(Integer m){
    Boolean chanc = Math.abs((Objects.hash(id, name, age)/m)%100)<20;
    return chanc;
  }

  public boolean calcHeterochromia(Integer m){
    Boolean chanc = Math.abs((Objects.hash(id, name, age)/m)%100)<25;
    return chanc;
  }

  public boolean calcMelanism(Integer m){
    Boolean chanc = Math.abs((Objects.hash(id, name, age)/m)%100)<15;
    return chanc;
  }


  // GETTERS
 
  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public ArrayList<String> getMutations(){
    return this.mutationList;
  }

  // SETTERS

  public void setAge(int amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("aging amount must be positive");
    }
    this.age += amount;
  }

  public String toString(){
    String text;
    text ="Código do animal: "+id+", ";
    text+="Nome: "+name+", ";
    text+="Idade: "+age+", ";
    return text;
  }
}
