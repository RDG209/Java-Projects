import java.util.*;

public class TestForNulls {
  public static boolean hasNoNulls(List<?> list) {
    for (Object element : list) {
      if (element == null) {
        return false;
      }
    }
    return true;
  }
}