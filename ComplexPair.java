
public class ComplexPair {
  private Complex first, second;

  public ComplexPair(Complex one, Complex two) {
    setFirst(one);
    setSecond(two);
  }

  public void setFirst(Complex one) {
    first = one;
  }

  public Complex getFirst() {
    return first;
  }

  public void setSecond(Complex two) {
    second = two;
  }

  public Complex getSecond() {
    return second;
  }

  public String toString() {
    return ("first: " + first + ", second: " + second);
  }
  public boolean equals(Object o) {
    if (!(o instanceof Complex)) {
      return false;
    }

    ComplexPair other = (ComplexPair) o;

    if (other.first != first) {
      return false;
    } else if (other.second != second) {
      return false;
    } else {
      return true;
    }
  }
}