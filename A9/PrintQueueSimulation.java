import java.util.*;
import java.io.*;

public class PrintQueueSimulation {
  private PriorityQueue<Job> waitQueue;
  private PriorityQueue<Job> finishedQueue;
  private int totalWaitTime;
  private int currentTime;
  private Printer[] printers;
  private Random randy;
  private int numberOfPrinters, numberOfPrintJobs;

  public PrintQueueSimulation(int numJobs, int numPrinter, int seed) {
    this.numberOfPrintJobs = numJobs;
    this.numberOfPrinters = numPrinter;
    this.randy = new Random(seed);
    waitQueue = new PriorityQueue<Job>(numJobs);
    finishedQueue = new PriorityQueue<Job>(numJobs);
    printers = new Printer[numPrinter];
    for (int i = 0; i < numPrinter; i++) {
      printers[i] = new Printer("Printer" + i);
    }
  }

  public void simulate() {
    int jobsMade = 0;
    boolean flagDone = false;

    while (!flagDone) {
      if (currentTime % 80 == 0 && jobsMade < numberOfPrintJobs) {
        int jobTime = randy.nextInt(10, 1101);
        int jobPriority = randy.nextInt(1, 12);
        Job job = new Job(currentTime, jobTime, jobPriority);
        waitQueue.add(job);
        jobsMade++;

      }
      for (Printer printer : printers) { // active print
        Job job = printer.getPrintJob();
        if (job != null && (job.getStartTime() + job.getTimeForJob()) <= currentTime) {
          job.setEndTime(currentTime);
          finishedQueue.add(job);
          printer.setPrintJob(null);
          printer.setStartIdleTime(currentTime);
        }
      }

      for (Printer printer : printers) { // idle print
        if (printer.getPrintJob() == null && !waitQueue.isEmpty()) {
          Job job = waitQueue.poll();
          job.setStartTime(currentTime);
          printer.setPrintJob(job);
          printer.setStartInUseTime(currentTime);
          totalWaitTime += job.getWaitTime();
        }
      }
      currentTime++;

      if (jobsMade == numberOfPrintJobs && waitQueue.isEmpty()){
        flagDone = true;
        for (Printer printer : printers) {
          if (printer.getPrintJob() != null) {
            flagDone = false;
            break;
          }
        }
      }
    }
  }

  public void displayStatistics() throws Exception {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter the naem of your output file: ");
    String outputName = keyboard.nextLine();
    PrintWriter writer = new PrintWriter(outputName);

    writer.println("Simulations Results");
    writer.printf("Simulation with %d printers lasted %d seconds and processed %d jobs\n", numberOfPrinters, currentTime, numberOfPrintJobs);
    writer.printf("The average time in the wait queue for a job is %.2f seconds\n", (double)(totalWaitTime)/numberOfPrintJobs);
    writer.println();

    writer.println("Printer Statistics");
    writer.printf("%-9s%-11s%-9s%-6s\n", "", "Jobs", "Time", "Time");
    writer.printf("%-9s%-11s%-9s%-6s\n", "Name", "Processed", "In Use", "Idle");
    for (Printer printer : printers) {
      writer.printf("%-9s%-14s%-9s%-6s\n", printer.getPrinterName(), printer.getTotalJobsProcessed(), printer.getTotalInUseTime(), printer.getTotalIdleTime(currentTime)); 
    }
    writer.println();

    writer.println("Job Statistics");
    writer.println("Job No. Priority  Wait Time Length Of Job");
    while (!finishedQueue.isEmpty()) {
        Job job = finishedQueue.poll();
        writer.printf("%-8d%-10d%-10d%-14d\n",
                job.getID(),
                job.getPriority(),
                job.getWaitTime(),
                job.getTimeForJob());
    }

    writer.close();
  }
  
}