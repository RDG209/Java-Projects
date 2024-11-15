import java.util.*;

public class AsListWithWrapperClass {
  public static void main(String[] args) {
    Integer[] array = new Integer[4];

    array[0] = 1;
    array[1] = 2;
    array[2] = 3;
    array[3] = 4;

    for (int i = 0; i < 4; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.print("\n");

    List<Integer> list = Arrays.asList(array);
    for (Integer num : list) {
      System.out.print(num);
    }
    System.out.print("\n");

    list.set(1, 99);

    for (Integer num : list) {
      System.out.print(num);
    }

  }
}