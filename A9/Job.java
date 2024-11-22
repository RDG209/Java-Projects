
public class Job implements Comparable<Job> {
  private int id;
  private int arrivalTime;
  private int timeForJob;
  private int priority;
  private int startTime;
  private int waitTime;
  private int endTime;
  private static int idCounter = 1;
  public Job(){
    
  }
  public Job(int arrivalTimeNew, int timeForJobNew, int priorityNew) {
    setID();
    setArrivalTime(arrivalTimeNew);
    setTimeForJob(timeForJobNew);
    setPriority(priorityNew);
  }
  public int getID() {
    return this.id;
  }
  public void setID() {
    this.id = idCounter;
    idCounter++;
  }
  public int getStartTime() {
    return this.startTime;
  }
  public void setStartTime(int newTime) {
    this.startTime = newTime;
    this.waitTime = startTime - arrivalTime;
  }
  public int getArrivalTime() {
    return this.arrivalTime;
  }
  public void setArrivalTime(int newTime) {
    this.arrivalTime = newTime;
  }
  public int getTimeForJob() {
    return this.timeForJob;
  }
  public void setTimeForJob(int newTime) {
    this.timeForJob = newTime;
  }
  public int getPriority() {
    return this.priority;
  }
  public void setPriority(int newTime) {
    this.priority = newTime;
  }
  public int getEndTime() {
    return this.arrivalTime;
  }
  public void setEndTime(int newTime) {
    this.endTime = newTime;
  }
  public int getWaitTime() {
    return this.arrivalTime;
  }
  public int compareTo(Job other) {
    return Integer.compare(this.priority, other.priority);
  }
}