import java.util.*;

public class Shelter {
  private String name;
  private String location;
  private int capacity;
  private int availableBeds;
  private String contactInfo;

  public Shelter(String newName, String newLoc, int newCap, int newBed, String newCon) {
    this.name = newName;
    this.location = newLoc;
    this.capacity = newCap;
    this.availableBeds = newBed;
    this.contactInfo = newCon;
  }
  
  public int getCapacity() {
    return this.capacity;
  }
  public void setBeds(int newBed) {
    if (newBed <= capacity) {
      this.availableBeds = newBed;
    }  
    else {
      System.out.println("Not enough space :(");
    }
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Shelter)) {
      return false;
    }
    Shelter other = (Shelter) o;
    return Objects.equals(this.name, other.name);
  }
  public int hashCode() {
    return Objects.hash(name);
  }
  public String toString() {
      return String.format("Shelter: %s, Location: %s, Capacity: %d, Available Beds: %d, Contact Info: %s", name, location, capacity, availableBeds, contactInfo);
  }
}