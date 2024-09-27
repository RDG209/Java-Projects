import java.util.*;
import java.io.*;

// BIG BANG CLASS
public class BigBang {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("Enter the name of the Solar System: ");
    String systemName = keyboard.nextLine();

    System.out.print("Enter the name of the Sun: ");
    String sunName = keyboard.nextLine();

    SolarSystem system = new SolarSystem(systemName, sunName);
    System.out.println(system.toString());

    Planet first = system.getPlanet(0);
    Planet last = system.getPlanet(system.getNumPlanets() - 1);

    for (int i = 1; i < system.getNumPlanets(); i++) {
      if (first.equals(system.getPlanet(i))) {
        Planet equal = system.getPlanet(i);
        equal.toString();
      } else {
        System.out.println("There is no planet that matches the first planet.");
      }
    }

    last.setPlanetName(first.getPlanetName());
    last.setPlanetTons(first.getPlanetTons());

    if (first.equals(last)) {
      System.out.println("The planet named " + last.getPlanetName() + " weighs " + last.getPlanetTons()
          + " tons equals the first planet in the ArrayList.");
    } else {
      System.out.println("There are no planets to compare.");
    }
    keyboard.close();
  }
}