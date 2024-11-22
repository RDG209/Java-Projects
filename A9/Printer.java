
public class Printer {
  private Job printJob;
  private String printerName;
  private int startIdleTime;
  private int startInUseTime;
  private int totalIdleTime;
  private int totalInUseTime;
  private int totalJobsProcessed;

  public Printer() {}
  public Printer(String name) {
    setPrinterName(name);
  }
  public String getPrinterName() {
    return printerName;
  }
  public void setPrinterName(String newName) {
    this.printerName = newName;
  }
  public Job getPrintJob() {
    return printJob;
  }
  public void setPrintJob(Job newJob) {
    this.printJob = newJob;
  }
  public void setStartInUseTime(int newTime) {
    this.totalJobsProcessed++;
    this.startInUseTime = newTime;
  }
  public void setStartIdleTime(int newTime) {
    this.totalInUseTime += newTime - this.startIdleTime;
    this.startIdleTime = newTime;
  }
  public int getTotalIdleTime(int currentTime) {
    this.totalIdleTime += currentTime - this.startIdleTime;
    return this.totalIdleTime;
  }
  public int getTotalInUseTime() {
    return this.totalInUseTime;
  }
  public int getTotalJobsProcessed() {
    return totalJobsProcessed;
  }
}