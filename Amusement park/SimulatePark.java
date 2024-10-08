import java.io.*;
import java.util.*;

// SimulatePark
public class SimulatePark {
  public static void main(String[] args) throws IOException {

    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter Park Name: ");
    String name = keyboard.nextLine();

    System.out.print("Enter the number of Attractions beween 3 and 10 inclusively but not 7: " );
    int num = keyboard.nextInt();
    while (num < 3 || num > 10 || num == 7) {
      System.out.print("Enter the number of Attractions beween 3 and 10 inclusively but not 7: " );
      num = keyboard.nextInt();
    }

    AmusementPark newPark = new AmusementPark(name, num);

    System.out.print("Enter the duration of the simulation, atleast 60 minutes: ");
    int time = keyboard.nextInt();
    if (time < 60) {
      System.out.print("Enter the duration of the simulation, atleast 60 minutes: ");
      time = keyboard.nextInt();
    }

    newPark.runThePark(time);

    keyboard.nextLine();

    System.out.print("Enter the name of the output file: ");
    String filename = keyboard.nextLine();

    PrintWriter writer = new PrintWriter(new FileWriter(filename));

    newPark.printParkStatistics(writer);

    writer.close();
    
  }
}