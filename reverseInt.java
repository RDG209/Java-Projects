import java.util.*;
import java.io.*;

public class reverseInt {

  public static void main(String[] args) throws IOException {
    Scanner keyboard = new Scanner(System.in);
    System.out.printf("\nEnter the name of the file containing integers: ");
    String filename = keyboard.nextLine();
    File integers = new File(filename);

    Scanner input = new Scanner(integers);

    ArrayList<Integer> numbers = new ArrayList<Integer>();

    while (input.hasNext()) {
      numbers.add(input.nextInt());
    }

    Collections.sort(numbers, Collections.reverseOrder());

    System.out.println("Enhanced For Loop: ");
    for (int num : numbers) {
      System.out.println(num);
    }

    System.out.println("Iteration: ");
    Iterator<Integer> iter = numbers.iterator();

    while (iter.hasNext()) {
      System.out.println(iter.next());
    }

    keyboard.close();
    input.close();

  }
}