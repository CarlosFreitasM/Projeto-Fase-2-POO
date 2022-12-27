import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import javax.lang.model.util.ElementScanner6;
import javax.swing.WindowConstants;

public class Zoo {

  private int balance;
  private TreeMap<Integer, Animal> inventory;
  private ArrayList<Settlement> settlementList = new ArrayList<Settlement>();
  private ArrayList<Animal> typeanimals = new ArrayList<>();

  private boolean running = true;
  private String choice;
  private Double totalAppeal;
  private Animal chooseAni;
  Scanner in = new Scanner(System.in);
  Menu menu = new Menu();

  public Zoo() {
    balance = 20000;
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

      /* 
      PRINT SETTLEMENT LIST

      for (int i = 0; i < settlementList.size(); i++) System.out.println(
        "SETTLEMENT: " +
        "\ncap: " +
        settlementList.get(i).capacity +
        "\nprice: " +
        settlementList.get(i).price
      );
      */

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
      getAppealOfAnimal(animal1) +
      " | Mutations: " +
      animal1.mutationList +
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
      getAppealOfAnimal(animal2) +
      " | Mutations: " +
      animal2.mutationList +
      " |\n" +
      "----------------------------------\n\n" +
      "|                            |\n" +
      "| (3) Name: " +
      animal3.name +
      "| Espicies Name: " +
      animal3.getClass().getSimpleName() +
      " | Age: " +
      animal3.age +
      " | Appeal: " +
      getAppealOfAnimal(animal3) +
      " | Mutations: " +
      animal3.mutationList +
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
        Animal ani1 = createNewAnimal(
          animal1.getClass().getSimpleName(),
          animal1.name,
          animal1.age,
          getAppealOfAnimal(animal1),
          animal1.mutationList
        );
        addAnimal(ani1);
        System.out.println(choice);
        break;
      case "2":
        Animal ani2 = createNewAnimal(
          animal2.getClass().getSimpleName(),
          animal2.name,
          animal2.age,
          getAppealOfAnimal(animal2),
          animal2.mutationList
        );
        addAnimal(ani2);
        System.out.println("GENETIC FEATURE");
        break;
      case "3":
        Animal ani3 = createNewAnimal(
          animal3.getClass().getSimpleName(),
          animal3.name,
          animal3.age,
          getAppealOfAnimal(animal3),
          animal3.mutationList
        );
        addAnimal(ani3);
        System.out.println("GENETIC CHAR");
        break;
      default:
        System.out.println(
          "Please enter a valid option which animal to choose."
        );
    }
  }

  private void buildSettlement() {
    Settlement proposal1 = new Settlement();
    Settlement proposal2 = new Settlement();
    Settlement proposal3 = new Settlement();

    Console.clear();
    System.out.println(
      "-------BUILD-NEW-SETTLEMENT-------\n" +
      "| Balance: " +
      this.balance +
      " euros            |\n" +
      "|                                |\n" +
      "| Choose one of the proposals.   |\n" +
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
        if (buy(proposal1.price)) settlementList.add(proposal1);
        break;
      case "2":
        Console.clear();
        if (buy(proposal2.price)) settlementList.add(proposal2);
        break;
      case "3":
        Console.clear();
        if (buy(proposal3.price)) settlementList.add(proposal3);
        break;
      default:
        System.out.println("Please enter a valid option.");
    }
  }

  private boolean buy(int price) {
    if (getBalance() > price) {
      addBalance(-price);
      System.out.println("Purchase Successful.");
      return true;
    }
    System.out.println("You don't have enough money.");
    return false;
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
        System.out.println(showAllAnimals() + "\n");
        System.out.println("Enter option:\n");
        Integer temp = in.nextInt();
        System.out.println(showAnimalById(temp));
        String wait = in.next();
        break;
      default:
        System.out.println("Please enter a valid option to verify .");
    }
  }

  private TreeMap<Integer, Animal> showAllAnimals() {
    return inventory;
  }

  private String showAnimalById(int id) {
    try {
      return inventory.get(id).name;
    } catch (NullPointerException e) {
      System.out.println("A posição que tentou aceder tem valor null!");
      return "";
    }
  }

  private void addAnimal(Animal a) {
    inventory.put(a.getId(), a);
  }

  private Animal instanceRandomAnimal() {
    int i = new Random().nextInt(10);
    switch (i) {
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
        chooseAni = new Cheetah();
        break;
      case 4:
        chooseAni = new Cougar();
        break;
      case 5:
        chooseAni = new Wolf();
        break;
      case 6:
        chooseAni = new Coyote();
        break;
      case 7:
        chooseAni = new Fox();
        break;
      case 8:
        chooseAni = new Firesalamandre();
        break;
      case 9:
        chooseAni = new Oxolotl();
        break;
    }
    return chooseAni;
  }

  private Double getAppealOfAnimal(Animal a) {
    switch (a.getClass().getSimpleName()) {
      case "Lion":
        totalAppeal = ((Lion) a).calcAppealBuying();
        break;
      case "Tiger":
        totalAppeal = ((Tiger) a).calcAppealBuying();
        break;
      case "Leopard":
        totalAppeal = ((Leopard) a).calcAppealBuying();
        break;
      case "Cheetah":
        totalAppeal = ((Cheetah) a).calcAppealBuying();
        break;
      case "Cougar":
        totalAppeal = ((Cougar) a).calcAppealBuying();
        break;
      case "Wolf":
        totalAppeal = ((Wolf) a).calcAppealBuying();
        break;
      case "Coyote":
        totalAppeal = ((Coyote) a).calcAppealBuying();
        break;
      case "Fox":
        totalAppeal = ((Fox) a).calcAppealBuying();
        break;
      case "Firesalamandre":
        totalAppeal = ((Firesalamandre) a).calcAppealBuying();
        break;
      case "Oxolotl":
        totalAppeal = ((Oxolotl) a).calcAppealBuying();
        break;
    }
    return Math.floor(totalAppeal * 100) / 100;
  }

  private Animal createNewAnimal(
    String animalType,
    String artName,
    int age,
    Double appeal,
    ArrayList<String> mutations
  ) {
    switch (animalType) {
      case "Lion":
        chooseAni = new Lion(artName, age, appeal, mutations);
        break;
      case "Tiger":
        chooseAni = new Tiger(artName, age, appeal, mutations);
        break;
      case "Leopard":
        chooseAni = new Leopard(artName, age, appeal, mutations);
        break;
      case "Cheetah":
        chooseAni = new Cheetah(artName, age, appeal, mutations);
        break;
      case "Cougar":
        chooseAni = new Cougar(artName, age, appeal, mutations);
        break;
      case "Wolf":
        chooseAni = new Wolf(artName, age, appeal, mutations);
        break;
      case "Coyote":
        chooseAni = new Coyote(artName, age, appeal, mutations);
        break;
      case "Fox":
        chooseAni = new Fox(artName, age, appeal, mutations);
        break;
      case "Firesalamandre":
        chooseAni = new Firesalamandre(artName, age, appeal, mutations);
        break;
      case "Oxolotl":
        chooseAni = new Oxolotl(artName, age, appeal, mutations);
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
