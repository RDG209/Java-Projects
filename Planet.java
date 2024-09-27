import java.util.*;

public class Planet {
  static Random randyPlanet = new Random(9);
  private String planetName;
  private int planetTons;

  public Planet() {
    planetName = "unknown";
  }
  public Planet(String name) {
    setPlanetName(name);
    setPlanetTons(randyPlanet.nextInt(80000000)+10000000);
  }
  public void setPlanetName(String name) {
    planetName = name;
  }
  public String getPlanetName() {
    return planetName;
  }
  public void setPlanetTons(int ton) {
    planetTons = ton;
  }
  public int getPlanetTons() {
    return planetTons;
  }
  public String toString() {
    return ("The planet named " + planetName + " weighs " + planetTons + " tons.");
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null) {
      return false;
    }
    if (!(o instanceof Planet)) {
      return false;
    }

    Planet other = (Planet) o;

    if (other.planetName.equals(this.planetName)) {
      if (other.planetTons == this.planetTons) {
        return true;
      }
    }

    return false;
    
  }
  
}
