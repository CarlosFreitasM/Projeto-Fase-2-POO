import java.lang.Math;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Animal implements Mutation {

  // https://stackoverflow.com/questions/24305830/java-auto-increment-id

  // Animal ->
  // Espécie (cada espécie tem características definidas)

  private static final AtomicInteger count = new AtomicInteger(-1);
  private static final AtomicInteger newMethod = new AtomicInteger(-1);
  protected int id, adultAge, age;
  private int multipler, addAppeal, ageOfDeath, lifeExpectancy;
  public final Double baseAppeal = 100.0;
  public Double appeal;
  private String name;
  public ArrayList<String> mutationList = new ArrayList<String>();
  private boolean isAlbino, isLeucism, isMelanism, isHeteroch;
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

  public Animal() {
    Random rand = new Random();
    this.id = count.incrementAndGet();
    this.name =
      artisticNames[Rand.getRandomNumberInRange(0, artisticNames.length - 1)];
    this.age = rand.nextInt(30);
    this.addAppeal = 0;
    this.adultAge = 10;
    this.appeal = 100.0;
    this.lifeExpectancy = 50;
    multipler = 1;
    isAlbino = calcAlbinism(multipler);
    if (isAlbino == true) {
      mutationList.add("Albinism");
    }
    multipler *= 100;
    isLeucism = calcLeucism(multipler);
    if (isLeucism == true) {
      mutationList.add("Leucism");
    }
    multipler *= 100;
    isMelanism = calcMelanism(multipler);
    if (isMelanism == true) {
      mutationList.add("Melanism");
    }
    multipler *= 100;
    isHeteroch = calcHeterochromia(multipler);
    if (isHeteroch == true) {
      mutationList.add("Heterochromia");
    }
    //this.mutation = mutationList[Objects.hash(this.id, this.name, this.mutation)]
    // Objects.hash(this.id, this.name, this.mutation);
    System.out.println("NEW ANIMAL");
    System.out.println("NAME: " + name);
    System.out.println("ID: " + id);

    System.out.println("MUTATIONS: ");
    for (int j = 0; j < mutationList.size(); j++) {
      if (mutationList.size() == 0) {
        System.out.println("This animal has no mutations!");
      }
      System.out.println("Has " + mutationList.get(j));
    }
    // System.out.println("MUTATION: " + mutation);
  }

  // De forma a fazer com que os animais que entram no zoo nao têm o ID separa por causa da criação de 3 animais de cada vez que se tenta obter quais 3 animais escolher
  // Assim, os animais que forem adicionados ao zoo têm um ID consistente e linear
  public Animal(
    String name,
    Integer age,
    Double appeal,
    ArrayList<String> mutationList,
    Integer ageOfDeath
  ) {
    this.id = newMethod.incrementAndGet();
    this.name = name;
    this.age = age;
    this.appeal = appeal;
    this.mutationList = mutationList;
    this.ageOfDeath=ageOfDeath;
  }

  public void sleep() {
    System.out.println("zZzZz...");
  }

  //CALCULATION TO SEE IF THE ANIMAL HAS MUTATIONS
  public boolean calcAlbinism(Integer m) {
    Boolean chanc = Math.abs((Objects.hash(id, name, age) / m) % 100) < 25;
    return chanc;
  }

  public boolean calcLeucism(Integer m) {
    Boolean chanc = Math.abs((Objects.hash(id, name, age) / m) % 100) < 20;
    return chanc;
  }

  public boolean calcHeterochromia(Integer m) {
    Boolean chanc = Math.abs((Objects.hash(id, name, age) / m) % 100) < 25;
    return chanc;
  }

  public boolean calcMelanism(Integer m) {
    Boolean chanc = Math.abs((Objects.hash(id, name, age) / m) % 100) < 15;
    return chanc;
  }

  //Add to the appeal of the animal's list of mutations
  public int calcAppealMultipler() {
    this.addAppeal = 0;
    for (int j = 0; j < mutationList.size(); j++) {
      switch (mutationList.get(j)) {
        case "Albinism":
          this.addAppeal += 200;
          break;
        case "Leucism":
          this.addAppeal += 250;
          break;
        case "Melanism":
          this.addAppeal += 300;
          break;
        case "Heterochromia":
          this.addAppeal += 150;
          break;
      }
    }
    return addAppeal;
  }
  //Returns at what age the animal will die
  public int calcAnimalsDeath(int currentAge, int lifeExpectancyA){
    int ageUntilDeath = currentAge;
    double lifeExpecFormula;
    while(true){
      try{
        lifeExpecFormula = ((((lifeExpectancyA+ (double) ageUntilDeath)/lifeExpectancyA)/2));
      }
      catch (ArithmeticException a)
      {
        lifeExpecFormula = 0;
      }
      double probRandMorrer = new Random().nextDouble(100);  
      if(probRandMorrer<lifeExpecFormula){
        return ageUntilDeath;
      }
      ageUntilDeath++;
    }
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

  public ArrayList<String> getMutations() {
    return this.mutationList;
  }

  public double getAppeal() {
    return this.appeal;
  }

  public double getAgeDeduction() {
    System.out.println(age + "::" + adultAge);
    if ((1 - ((double) (age / adultAge) * 0.3)) <= 0.7) {
      return 0.7;
    } else {
      return 1 - (double) (age * 0.3 / adultAge);
    }
  }

  public int getAnimalsDeath(){
    return this.ageOfDeath;
  }

  public int getLifeExpectancy(){
    return this.lifeExpectancy;
  }

  // SETTERS

  public void setAdultAge(int adultAge) {
    this.adultAge = adultAge;
  }
  
  public void setLifeExpectancy(int lifeExpectancy){
    this.lifeExpectancy=lifeExpectancy;
  }

  public void setAnimalsDeathAge(int ageOfDeath){
    this.ageOfDeath = ageOfDeath;
  }

  public void setAge(int amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("aging amount must be positive");
    }
    this.age += amount;
  }

  public String toString() {
    String text;
    text = "Code: " + id + ", ";
    text += "Name: " + name + ", ";
    text += "Age: " + age + ", ";
    text += "List of Mutations: " + mutationList + ", ";
    text += "Appeal of: " + appeal + ", ";
    return text;
  }
}
