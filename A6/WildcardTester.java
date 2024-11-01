import java.util.*;

public class WildcardTester {
  public static void main(String[] args) {
    List<Pet> petList = new ArrayList<Pet>();
    List<Parrot> parrotList = new ArrayList<Parrot>();

    addBird(petList, "Tweety");
    addBird(parrotList, "Talkie");
    addBird(parrotList, "Polly");
    addBird(parrotList, "Echo");

    System.out.println("\nList of Pets");
    printAll(petList);
    System.out.println("\nList of Parrots");
    printAll(parrotList);
    deleteBird(parrotList, "Talkie");
    System.out.println("\nNew Parrot List");
    printAll(parrotList);
  }
  public static void addBird(List<? super Parrot> birdList, String name) {
    Parrot newBird = new Parrot();
    newBird.setName(name);
    birdList.add(newBird);
    System.out.println("Birdie named " + name + " was added ");
  }
  public static void deleteBird(List<? extends Bird> birdList, String name) {
    for (Bird bird : birdList) {
      if (bird.getName().equals(name)) {
        birdList.remove(bird);
        System.out.println("\n\nBirdie named " + name + " was removed ");
        break;
      }
    }
  }
  public static void printAll(List<?> list) {
    for (Object bird : list) {
      System.out.print(bird.toString() + " ");
    }
  }
}