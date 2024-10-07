
public abstract class Rider {
  private int startOnlineTime;
  private int endOnlineTime;
  private int timeOnLine;

  public Rider() {
    // does nothing
  }
  public Rider(int startTime) {
    setStartOnlineTime(startTime);
  }
  public int getStartOnlineTime() {
    return startOnlineTime;
  }
  public void setStartOnlineTime( int time) {
    startOnlineTime = time;
  }
  public int getEndOnlineTime() {
    return endOnlineTime;
  }
  public void setEndOnlineTime(int time) {
    endOnlineTime = time;
    timeOnLine = endOnlineTime - startOnlineTime;
  }
  public int getTimeOnLine() {
    return timeOnLine;
  }

  // abstract
  public abstract void setTotalGate();
}