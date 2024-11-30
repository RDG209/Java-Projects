import java.util.*;

public abstract class Package {
  private static int packageIDCounter = 0;
  private int priority, packageArrivalTime, startDeliveryTime, deliveryDuration, waitTime, totalTime;
  private String packageID;
  private DeliveryTruck deliveryTruck;
  private static Random randy = new Random(5);

  public Package(int arriveTime) {
      setPriority();
      setPackageID();
      setPackageArrivalTime(arriveTime);
  }
  public int getPriority() {
    return priority;
  }
  public void setPriority() {
    this.priority = randy.nextInt(1, 51);
  }
  public int getPackageArrivalTime() {
    return packageArrivalTime;
  }
  public void setPackageArrivalTime(int packageArrivalTime) {
    this.packageArrivalTime = packageArrivalTime;
  }
  public int getStartDeliveryTime() {
    return startDeliveryTime;
  }
  public void setStartDeliveryTime(int startDeliveryTime) {
    this.startDeliveryTime = startDeliveryTime;
    this.waitTime = startDeliveryTime - packageArrivalTime;
  }
  public int getDeliveryDuration() {
    return deliveryDuration;
  }
  public int getWaitTime() {
    return waitTime;
  }
  public int getTotalTime() {
    return totalTime;
  }
  public void setTotalTime(int endTime) {
    this.totalTime = endTime - packageArrivalTime;
  }
  public String getPackageID() {
    return packageID;
  }
  public void setPackageID() {
    packageIDCounter++;
    this.packageID = "Package" + packageIDCounter;
  }
  public int getDeliveryTruckIDNumber() {
    return deliveryTruck.getDeliveryTruckIDNumber();
  }
  public void setDeliveryTruck(DeliveryTruck deliveryTruck) {
    this.deliveryTruck = deliveryTruck;
  }
  public void setDeliveryDuration(int deliveryDuration) {
    this.deliveryDuration = deliveryDuration;
  }
  public abstract void setPackageSize();
  public abstract String getPackageSize();
  public static int getIDCounter() {
    return packageIDCounter;
  }
}