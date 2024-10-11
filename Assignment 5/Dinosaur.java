import java.util.*;

public class Dinosaur implements Comparable<Dinosaur> {
  private static int dinoCounter = 1;
  private String dinoName;
  private int dinoWeight;

  public Dinosaur() {
    dinoName = "Barney";
  }
  public Dinosaur(int weight) {
    setWeight(weight);
    dinoName = "DINO" + dinoCounter;
    dinoCounter += 1;
  }
  public void setWeight(int weight) {
    dinoWeight = weight;
  }
  public int getWeight() {
    return dinoWeight;
  }
  public String toString() {
    return String.format("%-10s %-10s",dinoName, dinoWeight);
  }

  public int compareTo(Dinosaur other) {
    return Integer.compare(this.dinoWeight, other.dinoWeight);
  }
}