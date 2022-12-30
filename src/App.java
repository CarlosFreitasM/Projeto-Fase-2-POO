import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    /*
    try {
      File myObj = new File("animals.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
      */
    Zoo zoo = new Zoo();
    zoo.mainMenu();
    /*
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    */

  }
}
