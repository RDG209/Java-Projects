public class DeliveryTruck {
    private static int deliveryTruckIDCounter = 0;
    private int deliveryTruckIDNumber, totalPackagesDeliveredByDeliveryTruck, timeRemainingForCurrentPackageDelivery;
    private Package assignedPackage;

    public DeliveryTruck() {
        setDeliveryTruckIDNumber();
    }
    public int getDeliveryTruckIDNumber() {
        return deliveryTruckIDNumber;
    }
    public void setDeliveryTruckIDNumber() {
        deliveryTruckIDCounter++;
        this.deliveryTruckIDNumber = deliveryTruckIDCounter;
    }
    public int getTotalPackagesDeliveredByDeliveryTruck() {
        return totalPackagesDeliveredByDeliveryTruck;
    }

    public int getTimeRemainingForCurrentPackageDelivery() {
        return timeRemainingForCurrentPackageDelivery;
    }
    public void setTimeRemainingForCurrentPackageDelivery(int time) {
        this.timeRemainingForCurrentPackageDelivery = time;
    }
    public Package getAssignedPackage() {
        return assignedPackage;
    }
    public void setAssignedPackage(Package assignedPackage) {
        this.assignedPackage = assignedPackage;
    }
    public Package removeAssignedPackage() {
        Package tempPackage = this.assignedPackage;
        this.assignedPackage = null;
        totalPackagesDeliveredByDeliveryTruck++;
        return tempPackage;
    }
    public void decrementTimeRemainingForCurrentPackageDelivery() {
        this.timeRemainingForCurrentPackageDelivery--;
    }
    @Override
    public String toString() {
        return "Delivery Truck " + deliveryTruckIDNumber + " delivered " + totalPackagesDeliveredByDeliveryTruck + " packages !";
    }
}
