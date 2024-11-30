import java.util.*;
import java.io.*;

public class PackageDeliveryCenter {
    private Random randyX;
    private PriorityQueue<Package> pkgWaitingQ;
    private ArrayList<DeliveryTruck> deliveryTruckAvailableList;
    private ArrayList<DeliveryTruck> deliveryTruckBusyList;
    private ArrayList<Package> deliveredPackages;
    private String delivCenterName;
    private int currentTime;

    public PackageDeliveryCenter(String name, int seed) {
        this.delivCenterName = name;
        this.randyX = new Random(seed);
        this.pkgWaitingQ = new PriorityQueue<Package>(new PackagePriority());
        this.deliveryTruckAvailableList = new ArrayList<DeliveryTruck>();
        this.deliveryTruckBusyList = new ArrayList<DeliveryTruck>();
        this.deliveredPackages = new ArrayList<Package>();
        this.currentTime = 0;
    }

    public void initializePackageDeliveryCenter(int numDeliveryTrucks) {
        for (int i = 0; i < numDeliveryTrucks; i++) {
            deliveryTruckAvailableList.add(new DeliveryTruck());
        }

        for (int i = 0; i < 15; i++) {
            int randGen = randyX.nextInt(1, 11);
            if (randGen <= 5) {
                pkgWaitingQ.add(new SmallPackage(currentTime));
            } else if (randGen <= 9) {
                pkgWaitingQ.add(new MediumPackage(currentTime));
            } else {
                pkgWaitingQ.add(new LargePackage(currentTime));
            }
        }
        currentTime = 1;
    }
    public void operatePackageDeliveryCenter(int durationOfModelArrivals) {
        int randGen;
        int deliveryDuration;
        int endArrivalsTime = currentTime + durationOfModelArrivals;
        Package tempPackage;
        DeliveryTruck tempDeliveryTruck;

        while (deliveredPackages.size() < Package.getIDCounter() || currentTime < endArrivalsTime) {
            if (currentTime < endArrivalsTime) {
                for (int i = 0; i < 5; i++) {
                    randGen = randyX.nextInt(1, 11);
                    if (randGen <= 4) {
                        pkgWaitingQ.add(new SmallPackage(currentTime));
                    } else if (randGen <= 8) {
                        pkgWaitingQ.add(new MediumPackage(currentTime));
                    } else {
                        pkgWaitingQ.add(new LargePackage(currentTime));
                    }
                }
            }

            for (int i = 0; i < deliveryTruckBusyList.size(); i++) {
                tempDeliveryTruck = deliveryTruckBusyList.get(i);
                tempDeliveryTruck.decrementTimeRemainingForCurrentPackageDelivery();

                if (tempDeliveryTruck.getTimeRemainingForCurrentPackageDelivery() == 0) {
                    tempPackage = tempDeliveryTruck.removeAssignedPackage();
                    deliveredPackages.add(tempPackage);
                    tempPackage.setTotalTime(currentTime);
                    deliveryTruckBusyList.remove(i);
                    deliveryTruckAvailableList.add(tempDeliveryTruck);
                    i--;
                }
            }
            while (!deliveryTruckAvailableList.isEmpty() && !pkgWaitingQ.isEmpty()) {
                tempPackage = pkgWaitingQ.poll();
                tempPackage.setStartDeliveryTime(currentTime);

                tempDeliveryTruck = deliveryTruckAvailableList.remove(0);
                tempDeliveryTruck.setAssignedPackage(tempPackage);
                deliveryTruckBusyList.add(tempDeliveryTruck);

                tempPackage.setDeliveryTruck(tempDeliveryTruck);

                if (tempPackage instanceof SmallPackage) {
                     deliveryDuration = randyX.nextInt(10, 16);
                } else if (tempPackage instanceof MediumPackage) {
                    deliveryDuration = randyX.nextInt(20, 31);
                } else {
                    deliveryDuration = randyX.nextInt(25, 41);
                }

                tempPackage.setDeliveryDuration(deliveryDuration);
                tempDeliveryTruck.setTimeRemainingForCurrentPackageDelivery(deliveryDuration);
            }
                currentTime++;   
        }
    }
    public void generatePackageDeliveryCenterResults(String outputFilename) throws IOException {
        PrintWriter writer = new PrintWriter(outputFilename);
        writer.printf("Data For Package Delivery Center %s%n%n", delivCenterName);
        // 1st
        writer.println("Summary Data by DeliveryTruck");
        for (DeliveryTruck truck : deliveryTruckAvailableList) {
            writer.printf("Delivery Truck %d delivered %d packages%n", truck.getDeliveryTruckIDNumber(), truck.getTotalPackagesDeliveredByDeliveryTruck());
        }
        writer.println();

        // 2nd
        writer.println("Average Delivery Times");
        int smallCount = 0, mediumCount = 0, largeCount = 0;
        int smallTotalTime = 0, mediumTotalTime = 0, largeTotalTime = 0;

        for (Package pkg : deliveredPackages) {
            int totalTime = pkg.getTotalTime();
            if (pkg instanceof SmallPackage) {
                smallCount++;
                smallTotalTime += totalTime;
            } else if (pkg instanceof MediumPackage) {
                mediumCount++;
                mediumTotalTime += totalTime;
            } else if (pkg instanceof LargePackage) {
                largeCount++;
                largeTotalTime += totalTime;
            }
        }

        int totalPackages = deliveredPackages.size();
        int totalTime = smallTotalTime + mediumTotalTime + largeTotalTime;

        if (smallCount > 0) {
            writer.printf("The average total time for %d Small Packages is %.2f minutes\n", smallCount, ((double) smallTotalTime) / smallCount);
        } else {
            writer.printf("The average total time for %d Small Packages is %.2f minutes\n", smallCount, 0.0);
        }
        if (mediumCount > 0) {
            writer.printf("The average total time for %d Medium Packages is %.2f minutes\n",mediumCount, ((double) mediumTotalTime) / mediumCount);
        } else {
            writer.printf("The average total time for %d Medium Packages is %.2f minutes\n", mediumCount, 0.0);
        }
        if (largeCount > 0) {
            writer.printf("The average total time for %d Large Packages is %.2f minutes\n", largeCount, ((double) largeTotalTime) / largeCount);
        } else {
            writer.printf("The average total time for %d Large Packages is %.2f minutes\n", largeCount, 0.0);
        }
        if (totalPackages > 0) {
            writer.printf("The average total time for %d Total Packages is %.2f minutes\n\n",totalPackages, (double) totalTime / totalPackages);
        } else {
            writer.printf("The average total time for %d Total Packages is %.2f minutes\n\n", totalPackages, 0.0);
        }

        writer.println("Detailed Data On Package Delivery");
        writer.printf("%-15s %-10s %-20s %-10s %-15s %-10s %-20s %-20s %-10s%n",
                "PACKAGE ID", "PRIORITY", "DELIVERY TRUCK ID", "SIZE", "ARRIVAL TIME",
                "WAIT TIME", "START DELIVERY TIME", "DELIVERY DURATION", "TOTAL TIME");

        // Use an iterator to loop through deliveredPackages
        Iterator<Package> iterator = deliveredPackages.iterator();

        while (iterator.hasNext()) {
            Package pkg = iterator.next();

            writer.printf("%-15s %-10d %-20d %-10s %-15d %-10d %-20d %-20d %-10d%n", pkg.getPackageID(), pkg.getPriority(), pkg.getDeliveryTruckIDNumber(), pkg.getPackageSize(), pkg.getPackageArrivalTime(), pkg.getWaitTime(), pkg.getStartDeliveryTime(), pkg.getDeliveryDuration(), pkg.getTotalTime());
        }
    }


}