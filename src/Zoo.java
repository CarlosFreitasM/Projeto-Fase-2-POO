import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Zoo {

  private int balance;
  private TreeMap<Integer, Animal> inventory;
  private ArrayList<Settlement> settlementList = new ArrayList<Settlement>();
  private boolean running = true;
  private String choice;
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
    System.out.println(choice);
    switch (choice) {
      case "0":
        Console.clear();
        return;
      case "1":
        Console.clear();
        getRandomAnimal();
        System.out.println(choice);
        break;
      case "2":
        System.out.println("GENETIC FEATURE");
        break;
      default:
        System.out.println("Please enter a valid option.");
    }
  }

  private void getRandomAnimal() {
    Animal animal1 = new aniTiger();
    Animal animal2 = new aniTiger();
    Animal animal3 = new aniTiger();
    //Console.clear();
    System.out.println(
      "-------GET-RANDOM-ANIMAL------\n" +
      "| Choose one of the animals. |\n" +
      "|                            |\n" +
      "| (1) Name: " +
      animal1.name +
      " | Age: " +
      animal1.age +
      " | Appeal: " +
      animal1.appeal +
      " |\n" +
      "----------------------------------\n\n" +
      "|                            |\n" +
      "| (2) Name: " +
      animal2.name +
      " | Age: " +
      animal2.age +
      " | Appeal: " +
      animal2.appeal +
      " |\n" +
      "----------------------------------\n\n" +
      "|                            |\n" +
      "| (3) Name: " +
      animal3.name +
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
        Animal ani1 = new aniTiger(animal1.name, animal1.age);
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
        System.out.println("Please enter a valid option.");
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
        System.out.println("Please enter a valid option.");
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
        System.out.println("ALL ANIMALS");
        System.out.println(showAllAnimals());
        
        break;
      case "2":
        System.out.println("GENETIC FEATURE");
        break;
      case "3":
        System.out.println("MUTATION");
        break;
      default:
        System.out.println("Please enter a valid option.");
    }
  }

  public TreeMap<Integer, Animal> showAllAnimals(){
    return inventory;

  } 

  public void addAnimal(Animal a){
    inventory.put(a.getId(), a);
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
