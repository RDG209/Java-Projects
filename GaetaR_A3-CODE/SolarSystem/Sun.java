import java.util.*;

public class Sun {
  private String sunName;
  private int sunAge;
  Random randy = new Random(12);

  public Sun() {
    sunName = "unknown";
  }
  public Sun(String name) {
    setSunName(name);
    setSunAge(randy.nextInt(1000000000)+1000000001);
  }
  public void setSunName(String name) {
    sunName = name;
  }
  public String getSunName() {
    return sunName;
  }
  public void setSunAge(int age) {
    sunAge = age;
  }
  public String getSunAge() {
    return sunName;
  }
  public String toString() {
    return ("The sun named " + sunName + " is " + sunAge + "years old");
  }
  
}