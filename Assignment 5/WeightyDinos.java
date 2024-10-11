import java.util.*;
import java.io.*;

// WeightyDinos
public class WeightyDinos {
  public static void main(String[] args) throws IOException {
    ArrayList<Dinosaur> dinoList = new ArrayList<Dinosaur>();

    Random randy = new Random(4);

    int limit = 12;
    for (int i = 0; i < limit; i++) {
      Dinosaur newDino = new Dinosaur(randy.nextInt(50000, 200001));
      dinoList.add(newDino);
    }

    Collections.sort(dinoList);

    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter output file name: ");
    String filename = keyboard.nextLine();

    Iterator iterator = dinoList.iterator();

    PrintWriter writer = new PrintWriter(new FileWriter(filename));

    writer.printf("\n\n%-10s %-10s\n", "NAME", "WEIGHT");
    while (iterator.hasNext()) {
      writer.println(iterator.next());
    }

    writer.close();
    keyboard.close();
  }

  
}