
public class Pet {
  private String name;
  
  public Pet() {
    setName("Unnamed");
  }
  public void setName(String newName) {
    name = newName;
  }
  public String getName() {
    return name;
  }
  public String toString() {
    return this.name;
  }
}