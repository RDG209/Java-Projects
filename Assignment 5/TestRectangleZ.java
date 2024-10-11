
import java.util.*;
import java.io.*;

// TestRectangleZ
//
public class TestRectangleZ {
  public static void main(String[] args) throws IOException {
    Scanner keyboard = new Scanner(System.in);
    ArrayList<RectangleZ> myRects = new ArrayList<RectangleZ>();

    System.out.print("Enter a random int for a seed: ");
    int seed = keyboard.nextInt();
    keyboard.nextLine();

    Random randy = new Random(seed);

    RectangleZ tempRect;

    int limit = 100;
    for (int i = 0; i < limit; i++) {
      tempRect = new RectangleZ(randy.nextInt(1, 11), randy.nextInt(1, 6));
      myRects.add(tempRect);
    }

    Collections.sort(myRects, new ComparatorRectangleZ());

    System.out.print("Enter the name of the output file: ");
    String filename = keyboard.nextLine();

    PrintWriter writer = new PrintWriter(new FileWriter(filename));
    writer.printf("%-10s %-10s %-10s %-10s\n", "Name", "Area", "Length", "Width");
    Iterator iterator = myRects.iterator();

    while (iterator.hasNext()) {
      RectangleZ rect = (RectangleZ) iterator.next();
      writer.println("");
      writer.printf("%-10s %-10d %-10d %-10d", rect.getName(), rect.calArea(rect.getLength(), rect.getWidth()), rect.getLength(), rect.getWidth());
    }
    writer.close();
    keyboard.close();

  }
}