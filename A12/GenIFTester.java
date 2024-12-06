package GenIF;
import java.util.*;

public class GenIFTester {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    GenericInterface<String> reverse = (String x)-> {
      StringBuilder base = new StringBuilder(x);
      StringBuilder reversed = new StringBuilder(base.reverse());
      return reversed.toString();
    };

    for (int i = 0; i < 3; i++) {
      System.out.print("Enter a string: ");
      String input = keyboard.nextLine();

      String reversed = reverse.func(input);
      System.out.println("\nThe entry " + input + " reversed is " + reversed);
    }
      
  }
}