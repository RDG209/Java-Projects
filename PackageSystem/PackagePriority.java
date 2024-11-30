import java.util.*;

public class PackagePriority implements Comparator<Package> {

    public int compare(Package p1, Package p2) {
        if (p1.getPackageSize().equals(p2.getPackageSize())) {
            if (p1.getPriority() == p2.getPriority()) {
                return p1.getPackageArrivalTime() - p2.getPackageArrivalTime();
            }
            return p1.getPriority() - p2.getPriority();
        }
        return -p1.getPackageSize().compareTo(p2.getPackageSize());
    }
}
