import java.util.*;

public class NullsTestDriver {
  public static void main(String[] args) {
    Random randy = new Random(5);
    List<Integer> first = new ArrayList<Integer>();

    for (int i = 0; i < 9; i++) { // populate
      first.add(randy.nextInt(5, 16));
    }

    System.out.println("It is " + TestForNulls.hasNoNulls(first) + " that intArrayL has no null value");

    first.add(null);

    System.out.println("It is " + TestForNulls.hasNoNulls(first) + " that intArrayL has no null value");
    
    System.out.printf("[%s, %s, %s, %s, %s, %s, %s, %s, %s, %s]", first.get(0), first.get(1), first.get(2), first.get(3), first.get(4), first.get(5), first.get(6), first.get(7), first.get(8), first.get(9));

    System.out.println("\n");
    
    List<String> second = new ArrayList<String>();

    for (int i = 0; i < 9; i++) { // populate
      second.add("wxy" + randy.nextInt(9, 28));
    }
    
    System.out.println("It is " + TestForNulls.hasNoNulls(second) + " that intArrayL has no null value");

    second.add(3, null);
    
    System.out.println("It is " + TestForNulls.hasNoNulls(second) + " that intArrayL has no null value");
    
    System.out.printf("[%s, %s, %s, %s, %s, %s, %s]", second.get(0), second.get(1), second.get(2), second.get(3), second.get(4), second.get(5), second.get(6));
    
  }

}