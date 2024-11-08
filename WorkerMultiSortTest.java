import java.util.*;
import java.io.*;

public class WorkerMultiSortTest {
  public static void main(String[] args) throws FileNotFoundException {
    List<Worker> wrks = new ArrayList<Worker>();
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter worker file name: ");
    String filename = keyboard.nextLine();

    File workerFile = new File(filename);

    Scanner file = new Scanner(workerFile);

    while (file.hasNext()) {
      int id = file.nextInt();
      String name = file.next();
      Integer salary = file.nextInt();
      String title = file.next();

      wrks.add(new Worker(id, name, salary, title));
    }

    Collections.sort(wrks, new WorkerMultiSortComparator());

    Iterator<Worker> iter = wrks.iterator();

    while (iter.hasNext()) {
      Worker current = iter.next();
      System.out.println(current.toString());
    }
    
  }

}