import java.util.*;

public class WorkerMultiSortComparator implements Comparator<Worker> {
  public int compare(Worker first, Worker second) {

    int result = first.getJobTitle().compareTo(second.getJobTitle());
    if (result == 0) {
      int length1 = first.getName().length();
      int length2 = second.getName().length();
      result = Integer.compare(length1, length2);
      return result;
    } else {
      result = first.getJobTitle().compareTo(second.getJobTitle());
      return result;
    }
    
  }
}