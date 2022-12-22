import java.nio.channels.SelectableChannel;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Zoo {

  private int balance;
  private TreeMap<Integer, Animal> inventory;
  private ArrayList<Settlement> settlementList = new ArrayList<Settlement>();
  private ArrayList<Animal> typeanimals = new ArrayList<>();
  
  private boolean running = true;
  private String choice;
  private Animal chooseAni;
  Scanner in = new Scanner(System.in);
  Menu menu = new Menu();

  public Zoo() {

    balance = 2000;
    inventory = new TreeMap<Integer, Animal>();
    
  }

  // METHODS

  public void mainMenu() {
    //Console.clear();
    while (this.running) {
      System.out.println(
        "------------MAIN-MENU------------\n" +
        "| (1) Acquire new animal        |\n" + // -> submenu: random animal; random animal with a specific genetic feature
        "| (2) Build new settlement      |\n" +
        "| (3) Place animal              |\n" +
        "| (4) Chinese calendar          |\n" + // Boost chosen animal
        "| (5) Show animals              |\n" + // -> submenu: all animals; filter animals by genetic feature or mutation
        "| (6) Show settlements          |\n" +
        "| (7) Display zoo information   |\n" + // -> submenu: all information (current animals and their details, habitats and their current animals, obituary, history); obituary; history
        "| (8) Accounting period         |\n" +
        "| (9) Jumanji                   |\n" +
        "|                               |\n" +
        "| (0) Exit                      |\n" +
        "---------------------------------\n\n" +
        "Enter an option: "
      );
      choice = in.nextLine();
      switch (choice) {
        case "0":
          endGame();
          break;
        case "1":
          Console.clear();
          acquireAnimalMenu();
          break;
        //Console.clear();
        case "2":
          buildSettlement();
          System.out.println("get rekt");
          break;
        case "3":
          // placeAnimal();
          break;
        case "4":
          // boostAnimal();
          break;
        case "5":
          showAnimalsMenu();
          break;
        case "6":
          // showSettlements();
          break;
        case "7":
          // displayInformationMenu();
          break;
        case "8":
          // accountingPeriod();
          break;
        case "9":
          // jumanji();
          break;
        default:
          Console.clear();
          System.out.println("Please enter a valid option.");
      }
    }
    //Console.clear();
  }

  private void acquireAnimalMenu() {
    //Console.clear();
    System.out.println(
      "-------ACQUIRE-NEW-ANIMAL--------\n" +
      "| (1) Randomly                  |\n" +
      "| (2) Specify a genetic feature |\n" +
      "|                               |\n" +
      "| (0) Go back to main menu      |\n" +
      "---------------------------------\n\n" +
      "Enter an option: "
    );
    
    choice = in.nextLine();
    switch (choice) {
      case "0":
        Console.clear();
        return;
      case "1":
        Console.clear();
        getRandomAnimal();
        break;
      case "2":
        System.out.println("GENETIC FEATURE");
        break;
      default:
        System.out.println("Please enter a valid option for acquire animal.");
    }
  }

  private void getRandomAnimal() {
    Animal animal1 = instanceRandomAnimal();
    Animal animal2 = instanceRandomAnimal();
    Animal animal3 = instanceRandomAnimal();
    //Console.clear();
    System.out.println( 
      "-------GET-RANDOM-ANIMAL------\n" +
      "| Choose one of the animals. |\n" +
      "|                            |\n" +
      "| (1) Name: " +
      animal1.name +
      "| Espicies Name: " +
      animal1.getClass().getSimpleName() +
      " | Age: " +
      animal1.age +
      " | Appeal: " +
      animal1.appeal +
      " |\n" +
      "----------------------------------\n\n" +
      "|                            |\n" +
      "| (2) Name: " +
      animal2.name +
      "| Espicies Name: " +
      animal2.getClass().getSimpleName() +
      " | Age: " +
      animal2.age +
      " | Appeal: " +
      animal2.appeal +
      " |\n" +
      "----------------------------------\n\n" +
      "|                            |\n" +
      "| (3) Name: " +
      animal3.name +
      "| Espicies Name: " +
      animal2.getClass().getSimpleName() +
      " | Age: " +
      animal3.age +
      " | Appeal: " +
      animal3.appeal +
      " |\n" +
      "----------------------------------\n\n" +
      "Enter an option: "
    );
    choice = in.nextLine();
    System.out.println(choice);
    switch (choice) {
      case "0":
        Console.clear();
        return;
      case "1":
        Console.clear();
        Animal ani1 = new Lion(animal1.name, animal1.age, 10);
        addAnimal(ani1);
        System.out.println(choice);
        break;
      case "2":
        Animal ani2 = new aniTiger(animal2.name, animal2.age);
        addAnimal(ani2);
        System.out.println("GENETIC FEATURE");
        break;
      case "3":
        Animal ani3 = new aniTiger(animal3.name, animal3.age);
        addAnimal(ani3);
        System.out.println("GENETIC CHAR");
        break;
      default:
        System.out.println("Please enter a valid option which animal to choose.");
    }
  }

  private void buildSettlement() {
    Settlement proposal1 = new Settlement();
    Settlement proposal2 = new Settlement();
    Settlement proposal3 = new Settlement();

    Console.clear();
    System.out.println(
      "-------BUILD-NEW-SETTLEMENT-------\n" +
      "| Choose one of the proposals.   |\n" +
      "|                                |\n" +
      "|Balance="+balance+" euros              |\n" +
      "| (1) Capacity: " +
      proposal1.capacity +
      " | Price: " +
      proposal1.price +
      " |\n" +
      "| (2) Capacity: " +
      proposal2.capacity +
      " | Price: " +
      proposal2.price +
      " |\n" +
      "| (3) Capacity: " +
      proposal3.capacity +
      " | Price: " +
      proposal3.price +
      " |\n" +
      "|                                |\n" +
      "| (0) Go back to main menu       |\n" +
      "----------------------------------\n\n" +
      "Enter an option: "
    );

    String y = in.nextLine();
    switch (y) {
      case "0":
        Console.clear();
        return;
      case "1":
        Console.clear();
        buy(proposal1.price);
        settlementList.add(proposal1); //Bugged
        break;
      case "2":
        Console.clear();
        buy(proposal2.price);
        settlementList.add(proposal2);
        break;
      case "3":
        Console.clear();
        buy(proposal3.price);
        settlementList.add(proposal3);
        break;
      default:
        System.out.println("Please enter a valid option for proposal.");
    }
  }

  private void buy(int price) {
    if (getBalance() > price) {
      addBalance(-price);
      System.out.println("Purchase Successful.");
    } else System.out.println("You don't have enough money.");
  }

  private void showAnimalsMenu() {
    Console.clear();
    System.out.println(
      "-----------SHOW-ANIMALS----------\n" +
      "| (1) All                       |\n" +
      "|     Filter by:                |\n" +
      "| (2) Genetic feature           |\n" +
      "| (3) Mutation                  |\n" +
      "| (4) Animal by ID              |\n" +
      "|                               |\n" +
      "| (0) Go back to main menu      |\n" +
      "---------------------------------\n\n" +
      "Enter an option: "
    );

    choice = in.nextLine();
    switch (choice) {
      case "0":
        
        return;
      case "1":
        System.out.println("ALL ANIMALS");
        System.out.println(showAllAnimals());
        
        break;
      case "2":
        System.out.println("GENETIC FEATURE");
        break;
      case "3":
        System.out.println("MUTATION");
        break;
      case "4":
        System.out.println("CHOOSE ANIMAL BY ID:");
        System.out.println(showAllAnimals());
        System.out.println("Enter option:\n");
        Integer temp = in.nextInt();
        System.out.println(showAnimalById(temp));
        break;
      default:
        System.out.println("Please enter a valid option to verify .");
    }
  }

  private TreeMap<Integer, Animal> showAllAnimals(){
    return inventory;

  } 

  private String showAnimalById(int id){
    return inventory.get(id).name;
  }

  private void addAnimal(Animal a){
    inventory.put(a.getId(), a);
  }

  private Animal instanceRandomAnimal(){
    int i = new Random().nextInt(10);
    
    switch(i){
      case 0:
        chooseAni = new Lion();
        break;
      case 1:
        chooseAni = new Tiger();
        break;
      case 2:
        chooseAni = new Leopard();
        break;
      case 3:
        chooseAni = new Lion();
        break;
      case 4:
        chooseAni = new Leopard();
        break;
      case 5:
        chooseAni = new Tiger();
        break;
      case 6:
        chooseAni = new Lion();
        break;
      case 7:
        chooseAni = new Leopard();
        break;
      case 8:
        chooseAni = new Tiger();
        break;
      case 9:
        chooseAni = new Lion();
        break;
    }
    return chooseAni;
  }

  private Animal createNewAnimal(){
    int i = new Random().nextInt(10);
    
    switch(i){
      case 0:
        chooseAni = new Lion();
        break;
      case 1:
        chooseAni = new Tiger();
        break;
      case 2:
        chooseAni = new Leopard();
        break;
      case 3:
        chooseAni = new Lion();
        break;
      case 4:
        chooseAni = new Leopard();
        break;
      case 5:
        chooseAni = new Tiger();
        break;
      case 6:
        chooseAni = new Lion();
        break;
      case 7:
        chooseAni = new Leopard();
        break;
      case 8:
        chooseAni = new Tiger();
        break;
      case 9:
        chooseAni = new Lion();
        break;
    }
    return chooseAni;
  }

  private void displayInformationMenu() {}

  private void accountingPeriod() {
    // Each accounting period is equal to 4 months in time

    // Update stored animals
    //inventory.forEach(animal -> animal.setAge(4));
    // Update active animals
  }

  // GETTERS

  public boolean getRunning() {
    return this.running;
  }

  public int getBalance() {
    return this.balance;
  }

  // SETTERS

  public void endGame() {
    this.running = !this.running;
  }

  public void addBalance(int amount) {
    this.balance += amount;
  }
}
