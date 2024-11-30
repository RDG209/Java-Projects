public class LargePackage extends Package {
    private String packageSize;

    public LargePackage(int packageArrivalTime) {
        super(packageArrivalTime);
        setPackageSize();
    }
    public void setPackageSize() {
        this.packageSize = "Large";
    }
    public String getPackageSize() {
        return packageSize;
    }
    @Override
    public String toString() {
        return "The Large size package with priority " + getPriority() + " with ID " + getPackageID() + " waited " + getWaitTime() + " minutes before start of delivery";
    }
}
