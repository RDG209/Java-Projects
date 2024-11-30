public class SmallPackage extends Package {
    private String packageSize;
    public SmallPackage(int arriveTime) {
        super(arriveTime);
        setPackageSize();
    }
    public void setPackageSize() {
        this.packageSize = "Small";
    }
    public String getPackageSize() {
        return packageSize;
    }
    @Override
    public String toString() {
        return "The *Small size package with priority " + getPriority() + " with ID " + getPackageID() + " waited " + getWaitTime() + " minutes before start of delivery";
    }
}
