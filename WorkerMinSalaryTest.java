import java.util.*;

public class Main {
  public static void main(String[] args) {
    List<Worker> workerList = new ArrayList<Worker>();
    workerList.add(new Worker(10, "Maya", 25000, "Engineer"));
    workerList.add(new Worker(120, "Jose", 45000, "Programmer"));
    workerList.add(new Worker(210, "Abdul", 14000, "Analyst"));
    workerList.add(new Worker(150, "Elissa", 24000, "Manager"));

    Collections.sort(workerList);

    System.out.println("Worker with min salary: " + workerList.get(3).toString());
  }

}