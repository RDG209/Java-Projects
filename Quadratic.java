
public class Quadratic {
  private int a;
  private int b;
  private int c;
  private String comment; // no specifics in the instructions for default?

  public Quadratic(int A, int B, int C) {
    setA(A);
    setB(B);
    setC(C);
    setComment();

  }

  public int getA() {
    return a;
  }

  public void setA(int newA) {
    a = newA;
  }

  public int getB() {
    return b;
  }

  public void setB(int newB) {
    b = newB;
  }

  public int getC() {
    return c;
  }

  public void setC(int newC) {
    c = newC;
  }

  public String getComment() {
    return comment;
  }

  public void setComment() {

    if (a == 0) {
      comment = "Lonear equation: one real root";
    } else if (discriminant() == 0) {
      comment = "Quadratic with one real root";
    } else if (discriminant() > 0) {
      comment = "Two distinct real roots";
    } else {
      comment = "Two distinct complex roots";
    }
  }

  public int discriminant() {
    int discriminant = ((b * b) - (4 * a * c));
    return discriminant;
  }

  public String toString() {

    StringBuilder equation = new StringBuilder();

    if (a != 0) {
      equation.append("(" + a + ")x^2 +");
    } else {
      equation.append("");
    }

    if (b != 0) {
      equation.append("(" + b + ")x +");
    } else {
      equation.append("");
    }

    if (c != 0) {
      equation.append("(" + c + ")");
    } else {
      equation.append("");
    }
    String equationReturn = equation.toString();

    return equationReturn;
  }

  public boolean equals(Object o) {
    if (!(o instanceof Quadratic)) {
      return false;
    }

    Quadratic other = (Quadratic) o;

    if (other.a != a) {
      return false;
    } else if (other.b != b) {
      return false;
    } else if (other.c != c) {
      return false;
    } else {
      return true;
    }
  }

  public ComplexPair solveQuadratic() {
    ComplexPair result;
    Complex firstRoot, secondRoot;
    int discrim = discriminant();

    if (a == 0) {
      firstRoot = new Complex(-c / b, 0);
      result = new ComplexPair(firstRoot, firstRoot);
    } else if (discrim == 0) {
      firstRoot = new Complex(-b / (2 * a), 0);
      result = new ComplexPair(firstRoot, firstRoot);
    } else if (discrim > 0) {
      firstRoot = new Complex((-b + Math.sqrt(discrim)) / (2 * a), 0);
      secondRoot = new Complex((-b - Math.sqrt(discrim)) / (2 * a), 0);
      result = new ComplexPair(firstRoot, secondRoot);
    } else {
      firstRoot = new Complex(-b / (2 * a), Math.sqrt(-discrim) / (2 * a));
      secondRoot = new Complex(-b / (2 * a), -Math.sqrt(-discrim) / (2 * a));
      result = new ComplexPair(firstRoot, secondRoot);
    }
    return result;

  }

}