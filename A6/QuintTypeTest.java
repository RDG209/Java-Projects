
import java.util.*;

// QuintTypeTest
public class QuintTypeTest {
  public static void main(String[] args) {

    QuintType<Integer, Character, String, Boolean, Double> fiveGuys = new QuintType<>(1, 'B', "twenty", false, 1.93);
    System.out.println("Original: " + fiveGuys.toString());

    fiveGuys.setFirst(25);
    fiveGuys.setSecond('H');
    fiveGuys.setThird("fifty");
    fiveGuys.setFourth(true);
    fiveGuys.setFifth(9.17);

    System.out.println("Modified: " + fiveGuys.toString());
  }

}