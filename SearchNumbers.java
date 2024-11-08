import java.util.*;

public class SearchNumbers {
  public static void main(String[] args) {

    List<Integer> nums = new ArrayList<Integer>();
    Random randy = new Random();
    Scanner keyboard = new Scanner(System.in);

    for (int i = 0; i < 75; i++) {
      int randInt = randy.nextInt(10, 61);
      nums.add(randInt);
      System.out.print(randInt);
    }

    Collections.sort(nums);

    boolean exit = false;

    while (!exit) {
      System.out.print("\nPlease enter the value of the query between 10 and 60. Enter negative to exit: ");
      int inNum = keyboard.nextInt();
      int index = nums.indexOf(inNum);

      if (inNum < 0) {
        exit = true;
        break;
      }
      
      if (index >= 0) {
        System.out.print("\n" + inNum + " found at index - " + index);
      } else {
        System.out.print("\n" + inNum + " has not been found :( ");
      }
    }
    
  }
}