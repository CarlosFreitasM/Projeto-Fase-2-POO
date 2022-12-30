import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
  private ArrayList<Settlement> settlementList;
  private ArrayList<String> possibleAnimals = new ArrayList<String>();
  private ArrayList<Animal> animalsOfSpecific;

  private boolean running = true;
  private String choice;
  private Double totalAppeal;
  private Animal chooseAni;
  Scanner in = new Scanner(System.in);
  Menu menu = new Menu();

  public Zoo() {
    this.balance = 20000;
    this.inventory = new TreeMap<Integer, Animal>();
    this.settlementList = new ArrayList<Settlement>();
  }

  // METHODS+

  private void fileCheck() throws IOException {
    FileReader reader = new FileReader("animals.txt");
    BufferedReader fR = new BufferedReader(reader);
    String nameAnimal = fR.readLine();
    while (nameAnimal != null) {
      possibleAnimals.add(nameAnimal);
      possibleAnimals.get(0);
      System.out.println(nameAnimal);
      nameAnimal = fR.readLine();
    }
    fR.close();
  }

  public void mainMenu() throws IOException {
    // Console.clear();
    // fileCheck();
    while (this.running) {
      System.out.println(
        "------------MAIN-MENU------------\n" +
        "| (1) Acquire new animal        |\n" + // -> submenu: random animal; random animal with a specific
        // genetic feature
        "| (2) Build new settlement      |\n" +
        "| (3) Place animal              |\n" +
        "| (4) Chinese calendar          |\n" + // Boost chosen animal
        "| (5) Show animals              |\n" + // -> submenu: all animals; filter animals by genetic feature or
        // mutation
        "| (6) Show settlements          |\n" +
        "| (7) Display zoo information   |\n" + // -> submenu: all information (current animals and their details,
        // habitats and their current animals, obituary, history);
        // obituary; history
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
        case "2":
          buildSettlement();
          break;
        case "3":
          placeAnimalInSettlement();
          break;
        case "4":
          // boostAnimal();
          break;
        case "5":
          showAnimalsMenu();
          break;
        case "6":
          showSettlements();
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
    // Console.clear();
  }

  private void acquireAnimalMenu() {
    // Console.clear();
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
        try {
          showGenetic();
        } catch (ClassNotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (InstantiationException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (IllegalAccessException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (IllegalArgumentException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (InvocationTargetException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (NoSuchMethodException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (SecurityException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        break;
      default:
        System.out.println("Please enter a valid option for acquire animal.");
    }
  }

  private void getRandomAnimal() {
    Animal animal1 = instanceRandomAnimal();
    Animal animal2 = instanceRandomAnimal();
    Animal animal3 = instanceRandomAnimal();
    // Console.clear();
    System.out.println(
      "-------GET-RANDOM-ANIMAL------\n" +
      "| Choose one of the animals. |\n" +
      "|                            |\n" +
      "| (1) Name: " +
      animal1.getName() +
      "| Espicies Name: " +
      animal1.getClass().getSimpleName() +
      " | Age: " +
      animal1.getAge() +
      " | Appeal: " +
      getAppealOfAnimal(animal1) +
      " | Mutations: " +
      animal1.getMutations() +
      " |\n" +
      "----------------------------------\n\n" +
      "|                            |\n" +
      "| (2) Name: " +
      animal2.getName() +
      "| Espicies Name: " +
      animal2.getClass().getSimpleName() +
      " | Age: " +
      animal2.getAge() +
      " | Appeal: " +
      getAppealOfAnimal(animal2) +
      " | Mutations: " +
      animal2.getMutations() +
      " |\n" +
      "----------------------------------\n\n" +
      "|                            |\n" +
      "| (3) Name: " +
      animal3.getName() +
      "| Espicies Name: " +
      animal3.getClass().getSimpleName() +
      " | Age: " +
      animal3.getAge() +
      " | Appeal: " +
      getAppealOfAnimal(animal3) +
      " | Mutations: " +
      animal3.getMutations() +
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
          animal1.getName(),
          animal1.getAge(),
          getAppealOfAnimal(animal1),
          animal1.getMutations()
        );
        addAnimal(ani1);
        System.out.println(choice);
        break;
      case "2":
        Animal ani2 = createNewAnimal(
          animal2.getClass().getSimpleName(),
          animal2.getName(),
          animal2.getAge(),
          getAppealOfAnimal(animal2),
          animal2.getMutations()
        );
        addAnimal(ani2);
        System.out.println("GENETIC FEATURE");
        break;
      case "3":
        Animal ani3 = createNewAnimal(
          animal3.getClass().getSimpleName(),
          animal3.getName(),
          animal3.getAge(),
          getAppealOfAnimal(animal3),
          animal3.getMutations()
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

  private void getSpecifAnimal(ArrayList<Animal> an) {
    Animal animal1 = an.get(0);
    Animal animal2 = an.get(1);
    Animal animal3 = an.get(2);
    // Console.clear();
    System.out.println(
      "-------GET-RANDOM-ANIMAL------\n" +
      "| Choose one of the animals. |\n" +
      "|                            |\n" +
      "| (1) Name: " +
      animal1.getName() +
      "| Espicies Name: " +
      animal1.getClass().getSimpleName() +
      " | Age: " +
      animal1.getAge() +
      " | Appeal: " +
      getAppealOfAnimal(animal1) +
      " | Mutations: " +
      animal1.getMutations() +
      " |\n" +
      "----------------------------------\n\n" +
      "|                            |\n" +
      "| (2) Name: " +
      animal2.getName() +
      "| Espicies Name: " +
      animal2.getClass().getSimpleName() +
      " | Age: " +
      animal2.getAge() +
      " | Appeal: " +
      getAppealOfAnimal(animal2) +
      " | Mutations: " +
      animal2.getMutations() +
      " |\n" +
      "----------------------------------\n\n" +
      "|                            |\n" +
      "| (3) Name: " +
      animal3.getName() +
      "| Espicies Name: " +
      animal3.getClass().getSimpleName() +
      " | Age: " +
      animal3.getAge() +
      " | Appeal: " +
      getAppealOfAnimal(animal3) +
      " | Mutations: " +
      animal3.getMutations() +
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
          animal1.getName(),
          animal1.getAge(),
          getAppealOfAnimal(animal1),
          animal1.getMutations()
        );
        addAnimal(ani1);
        System.out.println(choice);
        break;
      case "2":
        Animal ani2 = createNewAnimal(
          animal2.getClass().getSimpleName(),
          animal2.getName(),
          animal2.getAge(),
          getAppealOfAnimal(animal2),
          animal2.getMutations()
        );
        addAnimal(ani2);
        System.out.println("GENETIC FEATURE");
        break;
      case "3":
        Animal ani3 = createNewAnimal(
          animal3.getClass().getSimpleName(),
          animal3.getName(),
          animal3.getAge(),
          getAppealOfAnimal(animal3),
          animal3.getMutations()
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
      proposal1.getCapacity() +
      " | Price: " +
      proposal1.getPrice() +
      " |\n" +
      "| (2) Capacity: " +
      proposal2.getCapacity() +
      " | Price: " +
      proposal2.getPrice() +
      " |\n" +
      "| (3) Capacity: " +
      proposal3.getCapacity() +
      " | Price: " +
      proposal3.getPrice() +
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
        if (buy(proposal1.getPrice())) settlementList.add(proposal1);
        break;
      case "2":
        Console.clear();
        if (buy(proposal2.getPrice())) settlementList.add(proposal2);
        break;
      case "3":
        Console.clear();
        if (buy(proposal3.getPrice())) settlementList.add(proposal3);
        break;
      default:
        System.out.println("Please enter a valid option.");
    }
  }

  private void placeAnimalInSettlement() {
    Console.clear();

    if (inventory.isEmpty()) {
      System.out.println(
        "There are no animals in the inventory.\n\nEnter any key to return to main menu:"
      );
      String any = in.nextLine();
      return;
    }

    System.out.println(
      "--------PLACE-ANIMAL--------<\n" +
      "|\n" +
      "| Select an animal to place.\n" +
      "| Showing id, name and appeal.\n" +
      "|"
    );
    for (Map.Entry<Integer, Animal> entry : inventory.entrySet()) { // PRINTS ANIMAL INVENTORY
      System.out.println(
        "| (" +
        entry.getKey() +
        ") " +
        entry.getValue().getName() +
        ", " +
        entry.getValue().getAppeal()
      );
    }
    System.out.println(
      "|\n" +
      "| (X) Return to main menu.       \n" +
      "--------------------------<\n\n" +
      "Enter an option: "
    );

    String y = in.nextLine();
    int animalId;
    switch (y) {
      case "X":
      case "x":
        Console.clear();
        return;
      default:
        if (Utils.isNumeric(y)) {
          animalId = Integer.parseInt(y);
          Settlement settlement;
          if (settlementList.isEmpty()) {
            Console.clear();
            System.out.println(
              "There are no settlements built." +
              "\nEnter any key to return to main menu:"
            );
            String any = in.nextLine();
            return;
          }
          Console.clear();
          System.out.println(
            "-------PLACE-ANIMAL------<\n" +
            "|                       \n" +
            "| Select a settlement:"
          );
          // Print settlements
          for (int i = 0; i < settlementList.size(); i++) {
            settlement = settlementList.get(i);
            System.out.println(
              "| (" +
              i +
              ") Housing space: " +
              settlement.getAnimalCount() +
              "/" +
              settlement.getCapacity()
            );
          }
          System.out.println(
            "|\n" +
            "| (X) Return to main menu.       \n" +
            "--------------------------<\n" +
            "Enter an option:\n"
          );
          String z = in.nextLine();
          int settlementId;

          switch (z) {
            case "X":
            case "x":
              Console.clear();
              return;
            default:
              if (Utils.isNumeric(z)) {
                settlementId = Integer.parseInt(z);
                Settlement stl = settlementList.get(settlementId);

                if (stl.getAnimalCount() == stl.getCapacity()) {
                  // SETTLEMENT IS FULL; MUST REPLACE AN ANIMAL
                  ArrayList<Animal> animals = settlementList
                    .get(settlementId)
                    .getAnimals();

                  System.out.println(
                    "-------PLACE-ANIMAL-----------<\n" +
                    "|\n" +
                    "| Select animal to replace:\n" +
                    "| Showing id, name and appeal.\n" +
                    "|"
                  );
                  // PRINTS ANIMALS
                  for (int q = 0; q < animals.size(); q++) {
                    Animal ani = animals.get(q);
                    System.out.println(
                      "| (" +
                      ani.getId() +
                      ") " +
                      ani.getName() +
                      ", " +
                      ani.getAppeal()
                    );
                  }
                  System.out.println(
                    "\n| (X) Return to main menu." +
                    "|\n----------------<\n" +
                    "Enter an option:\n"
                  );
                  String w = in.nextLine();
                  int animalToReplaceId;
                  switch (w) {
                    case "X":
                    case "x":
                      Console.clear();
                      return;
                    default:
                      if (Utils.isNumeric(w)) {
                        animalToReplaceId = Integer.parseInt(w);
                        Animal[] newAnimalList = stl.getAnimalList();
                        for (int j = 0; j < newAnimalList.length; j++) {
                          if (newAnimalList[j].getId() == animalToReplaceId) {
                            Animal inventoryAnimal = inventory.get(animalId); // Gets animal from inventory
                            Animal settlementAnimal = newAnimalList[j]; // Gets animal from settlement
                            inventory.replace(animalId, settlementAnimal); // Places previous settlement animal in
                            // inventory
                            newAnimalList[j] = inventoryAnimal; // Places previous inventory animal in settlement
                            stl.setAnimalList(newAnimalList); // Sets the new animal list
                            settlementList.set(settlementId, stl); // Updates settlement
                            Console.clear();
                            System.out.println(
                              "Animal successfully placed.\n" +
                              "\nEnter any key to return to main menu:"
                            );
                            String any = in.nextLine();
                          }
                        }
                      } else {
                        System.out.println("Please enter a valid ID.");
                      }
                  }
                } else { // PLACES ANIMAL IN EMPTY SLOT
                  for (int p = 0; p < stl.getAnimalList().length; p++) {
                    if (stl.getAnimalList()[p] == null) { // Finds empty slot to place animal
                      Animal a = inventory.get(animalId); // Gets animal from inventory
                      inventory.remove(animalId); // Removes animal from inventory
                      stl.getAnimalList()[p] = a; // Places animal
                      Console.clear();
                      System.out.println(
                        "Animal successfully placed.\n" +
                        "\nEnter any key to return to main menu:"
                      );
                      String any = in.nextLine();
                      break; // Jumps out of the loop
                    }
                  }
                  settlementList.set(settlementId, stl); // Updates settlement
                }
              } else System.out.println("Please enter a valid option.");
          }
        } else System.out.println("Please enter a valid option.");
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
        showAllAnimals();

        break;
      case "2":
        System.out.println("GENETIC FEATURE");
        try {
          showByGenetics();
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        }

        break;
      case "3":
        System.out.println("MUTATION");
        showByMutations();
        break;
      case "4":
        System.out.println("CHOOSE ANIMAL BY ID:");
        // System.out.println(showAllAnimals() + "\n");
        showAllAnimals();
        System.out.println("Enter option:\n");
        Integer temp = in.nextInt();
        System.out.println(showAnimalById(temp));
        String wait = in.next();
        break;
      default:
        System.out.println("Please enter a valid option to verify .");
    }
  }

  private void showSettlements() {
    Console.clear();
    if (settlementList.isEmpty()) {
      System.out.println(
        "There are no settlements built.\n\nEnter any key to return to main menu:"
      );
      String any = in.nextLine();
      return;
    }

    Settlement settlement;
    System.out.println(
      "----------SETTLEMENTS----------<\n" +
      "|\n| Showing name, appeal and age.\n|"
    );
    for (int i = 0; i < settlementList.size(); i++) {
      settlement = settlementList.get(i);

      System.out.println(
        "| Occupation: " +
        settlement.getAnimalCount() +
        "/" +
        settlement.getCapacity() +
        "\n| Current animals:"
      );
      ArrayList<Animal> settlementAnimals = settlement.getAnimals();
      if (settlementAnimals.isEmpty()) System.out.println("| None");
      for (int j = 0; j < settlementAnimals.size(); j++) {
        Animal a = settlementAnimals.get(j);
        System.out.println(
          "| " + a.getName() + ", " + a.getAppeal() + ", " + a.getAge()
        );
      }
      System.out.println("|");
    }
    System.out.println(
      "--------------------<\n" + "\nEnter any key to return to main menu:"
    );
    String any = in.nextLine();
  }

  private void showAllAnimals() {
    System.out.println(
      "-----------INVENTORY----------<\n" +
      "| Showing id, name and appeal.\n" +
      "|"
    );
    for (Map.Entry<Integer, Animal> entry : inventory.entrySet()) { // PRINTS ANIMAL INVENTORY
      System.out.println(
        "| (" +
        entry.getKey() +
        ") " +
        entry.getValue().getName() +
        ", " +
        entry.getValue().getAppeal()
      );
    }
    System.out.println(
      "| \n" +
      "------------------------------<\n\n" +
      "Enter any key to return to main menu:"
    );
    String any = in.nextLine();
    Console.clear();
  }

  private void showByGenetics() throws ClassNotFoundException {
    System.out.println(
      "-------CHOOSE-ANIMAL-GENETIC------\n" +
      "Choose the genetics you want     |\n" +
      "|(1)Panthera                     |\n" +
      "|(2)Acynonyx                     |\n" +
      "|(3)Puma                         |\n" +
      "|(4)Canis                        |\n" +
      "|(5)Vulpes                       |\n" +
      "|(6)Salamandra                   |\n" +
      "|(7)Ambystoma                    |\n" +
      "|                                |\n" +
      "| (0) Go back to main menu       |\n" +
      "----------------------------------\n\n" +
      "Enter an option: "
    );
    int o = 0;
    int j = 0;
    String y = in.nextLine();
    switch (y) {
      case "0":
        return;
      case "1":
        System.out.println(
          "-----------INVENTORY----------<\n" +
          "| Showing id, name, appeal and species name.\n" +
          "|"
        );
        for (Map.Entry<Integer, Animal> entry : inventory.entrySet()) {
          Class c = Class.forName(entry.getValue().getClass().getSimpleName());

          if (c.getInterfaces()[0] == Pantherae.class) {
            System.out.println(
              "| (" +
              entry.getKey() +
              ") " +
              entry.getValue().getName() +
              ", " +
              entry.getValue().getAppeal() +
              ", " +
              entry.getValue().getClass().getSimpleName()
            );
          }
        }
        break;
      case "2":
        System.out.println(
          "-----------INVENTORY----------<\n" +
          "| Showing id, name, appeal and species name.\n" +
          "|"
        );
        for (Map.Entry<Integer, Animal> entry : inventory.entrySet()) {
          Class c = Class.forName(entry.getValue().getClass().getSimpleName());

          if (c.getInterfaces()[0] == Acynonyx.class) {
            System.out.println(
              "| (" +
              entry.getKey() +
              ") " +
              entry.getValue().getName() +
              ", " +
              entry.getValue().getAppeal() +
              ", " +
              entry.getValue().getClass().getSimpleName()
            );
          }
        }
        break;
      case "3":
        System.out.println(
          "-----------INVENTORY----------<\n" +
          "| Showing id, name, appeal and species name.\n" +
          "|"
        );
        for (Map.Entry<Integer, Animal> entry : inventory.entrySet()) {
          Class c = Class.forName(entry.getValue().getClass().getSimpleName());

          if (c.getInterfaces()[0] == Puma.class) {
            System.out.println(
              "| (" +
              entry.getKey() +
              ") " +
              entry.getValue().getName() +
              ", " +
              entry.getValue().getAppeal() +
              ", " +
              entry.getValue().getClass().getSimpleName()
            );
          }
        }
        break;
      case "4":
        System.out.println(
          "-----------INVENTORY----------<\n" +
          "| Showing id, name, appeal and species name.\n" +
          "|"
        );
        for (Map.Entry<Integer, Animal> entry : inventory.entrySet()) {
          Class c = Class.forName(entry.getValue().getClass().getSimpleName());

          if (c.getInterfaces()[0] == Canis.class) {
            System.out.println(
              "| (" +
              entry.getKey() +
              ") " +
              entry.getValue().getName() +
              ", " +
              entry.getValue().getAppeal() +
              ", " +
              entry.getValue().getClass().getSimpleName()
            );
          }
        }
        break;
      case "5":
        System.out.println(
          "-----------INVENTORY----------<\n" +
          "| Showing id, name, appeal and species name.\n" +
          "|"
        );
        for (Map.Entry<Integer, Animal> entry : inventory.entrySet()) {
          Class c = Class.forName(entry.getValue().getClass().getSimpleName());

          if (c.getInterfaces()[0] == Vulpes.class) {
            System.out.println(
              "| (" +
              entry.getKey() +
              ") " +
              entry.getValue().getName() +
              ", " +
              entry.getValue().getAppeal() +
              ", " +
              entry.getValue().getClass().getSimpleName()
            );
          }
        }
        break;
      case "6":
        System.out.println(
          "-----------INVENTORY----------<\n" +
          "| Showing id, name, appeal and species name.\n" +
          "|"
        );
        for (Map.Entry<Integer, Animal> entry : inventory.entrySet()) {
          Class c = Class.forName(entry.getValue().getClass().getSimpleName());

          if (c.getInterfaces()[0] == Salamandre.class) {
            System.out.println(
              "| (" +
              entry.getKey() +
              ") " +
              entry.getValue().getName() +
              ", " +
              entry.getValue().getAppeal() +
              ", " +
              entry.getValue().getClass().getSimpleName()
            );
          }
        }
        break;
      case "7":
        System.out.println(
          "-----------INVENTORY----------<\n" +
          "| Showing id, name, appeal and species name.\n" +
          "|"
        );
        for (Map.Entry<Integer, Animal> entry : inventory.entrySet()) {
          Class c = Class.forName(entry.getValue().getClass().getSimpleName());

          if (c.getInterfaces()[0] == Ambystoma.class) {
            System.out.println(
              "| (" +
              entry.getKey() +
              ") " +
              entry.getValue().getName() +
              ", " +
              entry.getValue().getAppeal() +
              ", " +
              entry.getValue().getClass().getSimpleName()
            );
          }
        }
        break;
      default:
        System.out.println("Please enter a valid Genetic option.");
    }
    System.out.println(
      "| \n" +
      "------------------------------<\n\n" +
      "Enter any key to return to main menu:"
    );
    String any = in.nextLine();
    Console.clear();
  }

  private void showByMutations() {
    System.out.println(
      "--------CHOOSE-ANIMAL-MUTATIONS-------\n" +
      "Choose the mutations you want    |\n" +
      "|(1)Albinism                     |\n" +
      "|(2)Leucism                      |\n" +
      "|(3)Melanism                     |\n" +
      "|(4)Heterochromia                |\n" +
      "|                                |\n" +
      "| (0) Go back to main menu       |\n" +
      "----------------------------------\n\n" +
      "Enter an option: "
    );

    String y = in.nextLine();
    switch (y) {
      case "0":
        return;
      case "1":
        System.out.println(
          "-----------INVENTORY----------<\n" +
          "| Showing id, name, appeal and list of mutations.\n" +
          "|"
        );
        for (Map.Entry<Integer, Animal> entry : inventory.entrySet()) {
          if (entry.getValue().getMutations().contains("Leucism")) {
            System.out.println(
              "| (" +
              entry.getKey() +
              ") " +
              entry.getValue().getName() +
              ", " +
              entry.getValue().getAppeal() +
              ", " +
              entry.getValue().getMutations()
            );
          }
        }
        break;
      case "2":
        System.out.println(
          "-----------INVENTORY----------<\n" +
          "| Showing id, name, appeal and list of mutations.\n" +
          "|"
        );
        for (Map.Entry<Integer, Animal> entry : inventory.entrySet()) {
          if (entry.getValue().getMutations().contains("Albinism")) {
            System.out.println(
              "| (" +
              entry.getKey() +
              ") " +
              entry.getValue().getName() +
              ", " +
              entry.getValue().getAppeal() +
              ", " +
              entry.getValue().getMutations()
            );
          }
        }

        break;
      case "3":
        System.out.println(
          "-----------INVENTORY----------<\n" +
          "| Showing id, name, appeal and list of mutations.\n" +
          "|"
        );
        for (Map.Entry<Integer, Animal> entry : inventory.entrySet()) {
          if (entry.getValue().getMutations().contains("Melanism")) {
            System.out.println(
              "| (" +
              entry.getKey() +
              ") " +
              entry.getValue().getName() +
              ", " +
              entry.getValue().getAppeal() +
              ", " +
              entry.getValue().getMutations()
            );
          }
        }

        break;
      case "4":
        System.out.println(
          "-----------INVENTORY----------<\n" +
          "| Showing id, name, appeal and list of mutations.\n" +
          "|"
        );
        for (Map.Entry<Integer, Animal> entry : inventory.entrySet()) {
          if (entry.getValue().getMutations().contains("Heterochromia")) {
            System.out.println(
              "| (" +
              entry.getKey() +
              ") " +
              entry.getValue().getName() +
              ", " +
              entry.getValue().getAppeal() +
              ", " +
              entry.getValue().getMutations()
            );
          }
        }
        break;
      default:
        System.out.println("Please enter a valid Mutation option.");
    }
    System.out.println(
      "| \n" +
      "------------------------------<\n\n" +
      "Enter any key to return to main menu:"
    );
    String any = in.nextLine();
    Console.clear();
  }

  private String showAnimalById(int id) {
    try {
      return inventory.get(id).getName();
    } catch (NullPointerException e) {
      System.out.println("A posição que tentou aceder tem valor null!");
      return "";
    }
  }

  private void showGenetic()
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    System.out.println(
      "-------CHOOSE-ANIMAL-GENETIC------\n" +
      "Choose the genetics you want     |\n" +
      "|(1)Panthera                     |\n" +
      "|(2)Acynonyx                     |\n" +
      "|(3)Puma                         |\n" +
      "|(4)Canis                        |\n" +
      "|(5)Vulpes                       |\n" +
      "|(6)Salamandra                   |\n" +
      "|(7)Ambystoma                    |\n" +
      "|                                |\n" +
      "| (0) Go back to main menu       |\n" +
      "----------------------------------\n\n" +
      "Enter an option: "
    );
    int o = 0;
    int j = 0;
    String y = in.nextLine();
    Class c;
    animalsOfSpecific = new ArrayList<Animal>();
    switch (y) {
      case "0":
        return;
      case "1":
        while (j < 3) {
          Animal specifAni1;
          Animal specifAni2;
          Animal specifAni3;
          o = new Random().nextInt(possibleAnimals.size());

          Object panthera;
          c = Class.forName(possibleAnimals.get(o));
          panthera = c.getDeclaredConstructor();
          if (c.getInterfaces()[0] == Pantherae.class) {
            panthera = c.getDeclaredConstructor().newInstance();
          }

          if (panthera instanceof Pantherae) {
            if (j == 0) {
              specifAni1 = (Animal) panthera;
              animalsOfSpecific.add(specifAni1);
            }
            if (j == 1) {
              specifAni2 = (Animal) panthera;
              animalsOfSpecific.add(specifAni2);
            }
            if (j == 2) {
              specifAni3 = (Animal) panthera;
              animalsOfSpecific.add(specifAni3);
            }
            j++;
          }
        }
        getSpecifAnimal(animalsOfSpecific);

        break;
      case "2":
        while (j < 3) {
          Animal specifAni1;
          Animal specifAni2;
          Animal specifAni3;
          o = new Random().nextInt(possibleAnimals.size());
          Object acynonyx;
          c = Class.forName(possibleAnimals.get(o));
          acynonyx = c.getDeclaredConstructor();
          if (c.getInterfaces()[0] == Acynonyx.class) {
            acynonyx = c.getDeclaredConstructor().newInstance();
          }

          if (acynonyx instanceof Acynonyx) {
            if (j == 0) {
              specifAni1 = (Animal) acynonyx;
              animalsOfSpecific.add(specifAni1);
            }
            if (j == 1) {
              specifAni2 = (Animal) acynonyx;
              animalsOfSpecific.add(specifAni2);
            }
            if (j == 2) {
              specifAni3 = (Animal) acynonyx;
              animalsOfSpecific.add(specifAni3);
            }
            j++;
          }
        }
        getSpecifAnimal(animalsOfSpecific);

        break;
      case "3":
        while (j < 3) {
          Animal specifAni1;
          Animal specifAni2;
          Animal specifAni3;
          o = new Random().nextInt(possibleAnimals.size());
          Object puma;
          c = Class.forName(possibleAnimals.get(o));
          puma = c.getDeclaredConstructor();
          if (c.getInterfaces()[0] == Puma.class) {
            puma = c.getDeclaredConstructor().newInstance();
          }

          if (puma instanceof Puma) {
            if (j == 0) {
              specifAni1 = (Animal) puma;
              animalsOfSpecific.add(specifAni1);
            }
            if (j == 1) {
              specifAni2 = (Animal) puma;
              animalsOfSpecific.add(specifAni2);
            }
            if (j == 2) {
              specifAni3 = (Animal) puma;
              animalsOfSpecific.add(specifAni3);
            }
            j++;
          }
        }
        getSpecifAnimal(animalsOfSpecific);

        break;
      case "4":
        while (j < 3) {
          Animal specifAni1;
          Animal specifAni2;
          Animal specifAni3;
          o = new Random().nextInt(possibleAnimals.size());
          Object canis;
          c = Class.forName(possibleAnimals.get(o));
          canis = c.getDeclaredConstructor();
          if (c.getInterfaces()[0] == Canis.class) {
            canis = c.getDeclaredConstructor().newInstance();
          }

          if (canis instanceof Canis) {
            if (j == 0) {
              specifAni1 = (Animal) canis;
              animalsOfSpecific.add(specifAni1);
            }
            if (j == 1) {
              specifAni2 = (Animal) canis;
              animalsOfSpecific.add(specifAni2);
            }
            if (j == 2) {
              specifAni3 = (Animal) canis;
              animalsOfSpecific.add(specifAni3);
            }
            j++;
          }
        }
        getSpecifAnimal(animalsOfSpecific);

        break;
      case "5":
        while (j < 3) {
          Animal specifAni1;
          Animal specifAni2;
          Animal specifAni3;
          o = new Random().nextInt(possibleAnimals.size());
          Object vulpes;
          c = Class.forName(possibleAnimals.get(o));
          vulpes = c.getDeclaredConstructor();
          if (c.getInterfaces()[0] == Vulpes.class) {
            vulpes = c.getDeclaredConstructor().newInstance();
          }

          if (vulpes instanceof Vulpes) {
            if (j == 0) {
              specifAni1 = (Animal) vulpes;
              animalsOfSpecific.add(specifAni1);
            }
            if (j == 1) {
              specifAni2 = (Animal) vulpes;
              animalsOfSpecific.add(specifAni2);
            }
            if (j == 2) {
              specifAni3 = (Animal) vulpes;
              animalsOfSpecific.add(specifAni3);
            }
            j++;
          }
        }
        getSpecifAnimal(animalsOfSpecific);

        break;
      case "6":
        while (j < 3) {
          Animal specifAni1;
          Animal specifAni2;
          Animal specifAni3;
          o = new Random().nextInt(possibleAnimals.size());
          Object salamandre;
          c = Class.forName(possibleAnimals.get(o));
          salamandre = c.getDeclaredConstructor();
          if (c.getInterfaces()[0] == Salamandre.class) {
            salamandre = c.getDeclaredConstructor().newInstance();
          }

          if (salamandre instanceof Salamandre) {
            if (j == 0) {
              specifAni1 = (Animal) salamandre;
              animalsOfSpecific.add(specifAni1);
            }
            if (j == 1) {
              specifAni2 = (Animal) salamandre;
              animalsOfSpecific.add(specifAni2);
            }
            if (j == 2) {
              specifAni3 = (Animal) salamandre;
              animalsOfSpecific.add(specifAni3);
            }
            j++;
          }
        }
        getSpecifAnimal(animalsOfSpecific);

        break;
      case "7":
        while (j < 3) {
          Animal specifAni1;
          Animal specifAni2;
          Animal specifAni3;
          o = new Random().nextInt(possibleAnimals.size());
          Object ambystoma;
          c = Class.forName(possibleAnimals.get(o));
          ambystoma = c.getDeclaredConstructor();
          if (c.getInterfaces()[0] == Ambystoma.class) {
            ambystoma = c.getDeclaredConstructor().newInstance();
          }

          if (ambystoma instanceof Ambystoma) {
            if (j == 0) {
              specifAni1 = (Animal) ambystoma;
              animalsOfSpecific.add(specifAni1);
            }
            if (j == 1) {
              specifAni2 = (Animal) ambystoma;
              animalsOfSpecific.add(specifAni2);
            }
            if (j == 2) {
              specifAni3 = (Animal) ambystoma;
              animalsOfSpecific.add(specifAni3);
            }
            j++;
          }
        }
        getSpecifAnimal(animalsOfSpecific);

        break;
      default:
        System.out.println("Please enter a valid Genetic option.");
    }
  }

  private void findClassesWithInterface() {}

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
    int profit = 0, loss = 0;

    if (!inventory.isEmpty()) {
      Animal a;
      loss += Rand.getRandomNumberInRange(50, 50 + 10); // inventory maintenance costs
      for (Map.Entry<Integer, Animal> entry : inventory.entrySet()) {
        loss += Rand.getRandomNumberInRange(200, 200 * 2); // food costs
        a = entry.getValue();
        a.setAge(4);
        entry.setValue(a);
        /*
          TODO:
          - Implement births and deaths
        */
      }
    }

    if (!this.settlementList.isEmpty()) {
      Settlement s;
      for (int i = 0; i < this.settlementList.size(); i++) {
        s = settlementList.get(i);
        if (s.getAnimalCount() > 0) {
          loss += 740; // settlement staff guy's salary
          loss += Rand.getRandomNumberInRange(100, 100 * 2); // cleaning costs
          Animal[] animals = s.getAnimalList();
          for (Animal a : animals) {
            a.setAge(4);
            loss += Rand.getRandomNumberInRange(200, 200 * 2); // food costs
            profit += (int) a.getAppeal() + a.calcAppealMultipler(); // generates profit based on appeal
            profit += 1000 / a.getAge(); // generates profit based on age
            /*
            TODO:
            - Implement births and deaths
          */
          }
        }
      }
    }
    this.addBalance(profit - loss);
    /*
      TODO:
      - Handle negative balance; possibly: in case of debt, animals will be sold if needed
    */
  }

  // Trying to know what object class is being called so it can be instacenced to
  // make a new animal of that speficif genus (PROBABLY DUMPED DOING SOMETHING
  // MORE SIMPLE)
  public static Object createObject(String className)
    throws IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    Object object = null;
    try {
      Class c = Class.forName(className);
      object = c.getDeclaredConstructor().newInstance();
    } catch (InstantiationException e) {
      System.out.println(e);
    } catch (IllegalAccessException e) {
      System.out.println(e);
    } catch (ClassNotFoundException e) {
      System.out.println(e);
    }
    return object;
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
