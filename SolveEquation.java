/* SolveEquation Class, Quadratic and ComplexPair Client
Anderson, Franceschi
Modified by Rosenthal
*/
public class SolveEquation {
  public static void main(String[] args) {
    Quadratic q1 = new Quadratic(0, -8, 2);
    System.out.printf("Quadratic equation #1: %s\n", q1);
    ComplexPair c1 = q1.solveQuadratic();
    System.out.printf("%s\n", q1.getComment());
    if (q1.getA() == 0) {
      double value = (double) (-q1.getC()) / q1.getB();
      System.out.printf("Single solution is %4.2f\n\n", value);
    } else
      System.out.printf("Solutions: %s\n\n", c1);
    Quadratic q2 = new Quadratic(-2, 4, -2);
    System.out.printf("Quadratic equation #2: %s\n", q2);
    ComplexPair c2 = q2.solveQuadratic();
    System.out.printf("%s\n", q2.getComment());
    if (q2.getA() == 0) {
      double value = (double) (-q2.getC()) / q2.getB();
      System.out.printf("Single solution is %4.2f\n\n", value);
    } else
      System.out.printf("Solutions: %s\n\n", c2);
    Quadratic q3 = new Quadratic(1, -3, -10);
    System.out.printf("Quadratic equation #3: %s\n", q3);
    ComplexPair c3 = q3.solveQuadratic();
    System.out.printf("%s\n", q3.getComment());
    if (q3.getA() == 0) {
      double value = (double) (-q3.getC()) / q3.getB();
      System.out.printf("Single solution is %4.2f\n\n", value);
    } else
      System.out.printf("Solutions: %s\n\n", c3);
    Quadratic q4 = new Quadratic(-1, 2, -5);
    System.out.printf("Quadratic equation #4: %s\n", q4);
    ComplexPair c4 = q4.solveQuadratic();
    System.out.printf("%s\n", q4.getComment());
    if (q4.getA() == 0) {
      double value = (double) (-q4.getC()) / q4.getB();
      System.out.printf("Single solution is %4.2f\n\n", value);
    } else
      System.out.printf("Solutions: %s\n\n", c4);
    Quadratic q5 = new Quadratic(1, 0, 9);
    System.out.printf("Quadratic equation #5: %s\n", q5);
    ComplexPair c5 = q5.solveQuadratic();
    System.out.printf("%s\n", q5.getComment());
    if (q5.getA() == 0) {
      double value = (double) (-q5.getC()) / q5.getB();
      System.out.printf("Single solution is %4.2f\n\n", value);
    } else
      System.out.printf("Solutions: %s\n\n", c5);
  }
}