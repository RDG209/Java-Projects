public class MediumPackage extends Package {
    private String packageSize;
    
    public MediumPackage(int packageArrivalTime) {
        super(packageArrivalTime);
        setPackageSize();
    }
    public void setPackageSize() {
        this.packageSize = "Medium";
    }
    public String getPackageSize() {
        return packageSize;
    }
    @Override
    public String toString() {
        return "The *Medium size package with priority " + getPriority() + " with ID " + getPackageID() + " waited " + getWaitTime() + " minutes before start of delivery";
    }
}
