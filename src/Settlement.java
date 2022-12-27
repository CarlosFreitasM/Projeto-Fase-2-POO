import java.util.ArrayList;

// Maybe delete capacity and get animal list size instead

public class Settlement {

  private int capacity, price;
  private final int MIN_CAPACITY = 10, MAX_CAPACITY = MIN_CAPACITY * 2;
  private Animal[] animalList;

  public Settlement() {
    // Generate capacity between 10 and 20
    this.capacity = Rand.getRandomNumberInRange(MIN_CAPACITY, MAX_CAPACITY);
    this.animalList = new Animal[capacity];
    // Generate price between 1000 and 3000.
    this.price =
      Rand.getRandomNumberInRange(
        this.capacity * 100,
        this.capacity * 100 + 1000
      );

    System.out.println("NEW SETTLEMENT");
    System.out.println("CAPACITY: " + capacity);
    System.out.println("PRICE: " + price);
  }

  // GETTERS

  public int getCapacity() {
    return this.capacity;
  }

  public int getPrice() {
    return this.price;
  }

  public Animal[] getAnimalList() {
    return this.animalList;
  }

  public int getAnimalCount() {
    int animalCount = 0;
    for (Animal animal : this.animalList) {
      if (animal != null) {
        animalCount++;
      }
    }
    return animalCount;
  }

  public ArrayList<Animal> getAnimals() {
    ArrayList<Animal> animals = new ArrayList<Animal>();
    for (Animal animal : this.animalList) {
      if (animal != null) {
        animals.add(animal);
      }
    }
    return animals;
  }

  // SETTERS

  public void setAnimalList(Animal[] newAnimalList) {
    this.animalList = newAnimalList;
  }
}
