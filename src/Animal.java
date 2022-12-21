import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Animal {

  // https://stackoverflow.com/questions/24305830/java-auto-increment-id

  // Animal ->
  // Espécie (cada espécie tem características definidas)

  private static final AtomicInteger count = new AtomicInteger(-1);
  private static final AtomicInteger newMethod = new AtomicInteger(-1);
  public int id, age, appeal;
  public String name, mutation;
  HashMap<String, Double> mutationList = Mutations.createHashMap();
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

  public abstract void interact();

  public Animal(){
    Random rand = new Random();
    this.id = count.incrementAndGet();
    this.name =
      artisticNames[Rand.getRandomNumberInRange(0, artisticNames.length - 1)];
    age = rand.nextInt(30);
    //this.mutation = mutationList[Objects.hash(this.id, this.name, this.mutation)]
    // Objects.hash(this.id, this.name, this.mutation);
    System.out.println("NEW ANIMAL");
    System.out.println("NAME: " + name);
    System.out.println("ID: " + id);
    // System.out.println("MUTATION: " + mutation);
  }

  // De forma a fazer com que os animais que entram no zoo nao têm o ID separa por causa da criação de 3 animais de cada vez que se tenta obter quais 3 animais escolher
  // Assim, os animais que forem adicionados ao zoo têm um ID consistente e linear
  public Animal(String name, Integer age) {
    this.id = newMethod.incrementAndGet();
    this.name = name;
    this.age=age;
  }

  public void sleep() {
    System.out.println("zZzZz...");
  }

  

  // GETTERS
 
  public int getId() {
    return this.id;
  }
  public int getAge() {
    return this.age;
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
    text+="Idade: "+age+"::";
    return text;
  }
}
