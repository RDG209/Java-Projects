import java.util.*;

public class ComparatorRectangleZ implements Comparator<RectangleZ> {
  public int compare(RectangleZ R1, RectangleZ R2) {

    double area1 = R1.calArea(R1.getLength(), R1.getWidth());
    double area2 = R2.calArea(R2.getLength(), R2.getWidth());
    
    if (area1 != area2) {
      return Double.compare(area2, area1);
    } else if (R1.getLength() != R2.getLength()) {
      return Double.compare(R2.getLength(), R1.getLength());
    } else if (R1.getWidth() != R2.getWidth()) {
      return Double.compare(R2.getWidth(), R1.getWidth());
    } else {
      return R2.getName().compareTo(R1.getName());
    }

  }
}