import java.util.*;
import java.io.*;

public class TestPrintQueueSimulation { 
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter the number of printers for the simulation: ");
    int numberOfPrinters = scanner.nextInt();

    System.out.println("Please enter the number of print jobs for the simulation: ");
    int numberOfJobs = scanner.nextInt();

    System.out.println("Please enter a random number seed for the simulation: ");
    int seed = scanner.nextInt();

    PrintQueueSimulation simulation = new PrintQueueSimulation(numberOfJobs, numberOfPrinters, seed);
    simulation.simulate();
    simulation.displayStatistics();
  }
}