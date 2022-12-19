import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Animal {

  // https://stackoverflow.com/questions/24305830/java-auto-increment-id

  // Animal ->
  // Espécie (cada espécie tem características definidas)

  private static final AtomicInteger count = new AtomicInteger(-1);
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

  public Animal() {
    this.id = count.incrementAndGet();
    this.name =
      artisticNames[Rand.getRandomNumberInRange(0, artisticNames.length - 1)];
    //this.mutation = mutationList[Objects.hash(this.id, this.name, this.mutation)]
    // Objects.hash(this.id, this.name, this.mutation);
    System.out.println("NEW ANIMAL");
    System.out.println("NAME: " + name);
    System.out.println("ID: " + id);
    // System.out.println("MUTATION: " + mutation);
  }

  public void sleep() {
    System.out.println("zZzZz...");
  }

  // GETTERS

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
}
