
public class Main {
  public static void main(String[] args) {
    // for loop
    for (int i = 1; i <= 5; i++) {
      if (i % 2 == 0) {
        System.out.println(i + " is even");
      } else {
        System.out.println(i + " is odd");
      }
    }

    // overload and type conversion
    printNumber(42);
    printNumber(3.14);

    // Type conversion: int - double
    int num = 10;
    double converted = (double) num;
    System.out.println("Converted int to double: " + converted);

    // double - int
    double pi = 3.14159;
    int truncated = (int) pi;
    System.out.println("Converted double to int: " + truncated);
    
  }

  public static void printNumber(int num) {
    System.out.println("Integer: " + num);
  }

  public static void printNumber(double num) {
    System.out.println("Double: " + num);
  }
}