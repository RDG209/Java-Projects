
public class Complex {
  private double real;
  private double imaginary;

  public Complex(double r, double i) {
    setReal(r);
    setImaginary(i);
  }

  public void setReal(double r) {
    real = r;
  }

  public double getReal() {
    return real;
  }

  public void setImaginary(double i) {
    imaginary = i;
  }

  public double getImaginary() {
    return imaginary;
  }

  public String toString() {
    if (imaginary == 0) {
      return ("" + real);
    } else if (imaginary > 0) {
      return ("" + real + " + " + imaginary + "i");
    } else {
      return ("" + real + " - " + imaginary + "i");
    }
  }
  public boolean equals(Object o) {
    if (!(o instanceof Complex)) {
      return false;
    }

    Complex other = (Complex) o;

    if (other.real != real) {
      return false;
    } else if (other.imaginary != imaginary) {
      return false;
    } else {
      return true;
    }
  }
    
}