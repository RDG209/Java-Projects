

public class RectangleZ {
  private static int rectID = 0;
  private String name;
  private int length;
  private int width;

  public RectangleZ() {

  }
  public RectangleZ(int length, int width) {
    setLength(length);
    setWidth(width);
    setName();
  }
  public String getName() {
    return name;
  }
  public void setName() {
    rectID++;
    this.name = "Rect" + rectID;
  }
  public int getLength() {
    return this.length;
  }
  public void setLength(int l) {
    this.length = l;
  }
  public int getWidth() {
    return this.width;
  }
  public void setWidth(int w) {
    this.width = w;
  }

  public int calArea(int length, int width) {
    return length*width;
  }
  public String toString() {
    return String.format("RectangleZ %-10s has area %-10d length %-10d and width %-10d", this.name, this.calArea(this.length, this.width), this.length, this.width); 
  }
}