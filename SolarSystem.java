import java.util.*;
import java.io.*;

public class SolarSystem {
  private String solSystemName;
  private Sun sol;
  private ArrayList<Planet> planetList = new ArrayList<Planet>();

  public SolarSystem() {
    setSystemName("unknown");
    sol = new Sun();
  }
  public SolarSystem(String systemName, String sunName) throws FileNotFoundException {
    setSystemName(systemName);
    sol = new Sun(sunName);
    createPlanets();
  }
  public void setSystemName(String name) {
    solSystemName = name;
  }
  public String getSystemName() {
    return solSystemName;
  }
  public void createPlanets() throws FileNotFoundException {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter filename containing planets: ");
    String filename = keyboard.nextLine();
    File file = new File(filename);

    Scanner scnr = new Scanner(file);
    while (scnr.hasNext()) {
      Planet current = new Planet(scnr.nextLine());
      planetList.add(current);
    }
    keyboard.close();
  }
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("The name of this Solar System is ").append(solSystemName).append("\n");
    result.append(sol.toString()).append("\n"); 

    for (Planet planet : planetList) {
        result.append(planet.toString()).append("\n"); 
    }

    return result.toString();
  }
  public int getNumPlanets() {
    return planetList.size();
  }
  public Planet getPlanet(int index) {
    if (index < 0 || index >= planetList.size()) {
        System.out.print("Planet doesn't exist...");
        return null;
    }
    return planetList.get(index);
  }
  
}