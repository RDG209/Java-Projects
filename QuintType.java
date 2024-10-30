

public class QuintType<F, S, T, U, V> {
  private F first;
  private S second;
  private T third;
  private U fourth;
  private V fifth;

  public QuintType(F first, S second, T third, U fourth, V fifth) {
    setFirst(first);
    setSecond(second);
    setThird(third);
    setFourth(fourth);
    setFifth(fifth);
  }
  public F getFirst() {
    return first;
  }
  public void setFirst(F newFirst) {
    this.first = newFirst;
  }
  public S getSecond() {
    return second;
  }
  public void setSecond(S newSecond) {
    this.second = newSecond;
  }
  public T getThird() {
    return third;
  }
  public void setThird(T newThird) {
    this.third = newThird;
  }
  public U getFourth() {
    return fourth;
  }
  public void setFourth(U newFourth) {
    this.fourth = newFourth;
  }
  public V getFifth() {
    return fifth;
  }
  public void setFifth(V newFifth) {
    this.fifth = newFifth;
  }
  public String toString() {
    return String.format("<%s, %s, %s, %s, %s>", this.first, this.second, this.third, this.fourth, this.fifth);
  }
  
}