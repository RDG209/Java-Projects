import java.util.*;
import java.io.*;

public class StartPackageDeliveryCenter {

    public static void main(String[] args) throws Exception {
 
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter the name of the Package Delivery Center: ");
        String pdcName = keyboard.nextLine();

        System.out.print("Please enter a seed value for Randy: ");
        int seed = keyboard.nextInt();
        keyboard.nextLine();

        PackageDeliveryCenter pdc = new PackageDeliveryCenter(pdcName, seed);

        System.out.print("Please enter the number of Delivery Trucks: ");
        int numDeliveryTrucks = keyboard.nextInt();

        pdc.initializePackageDeliveryCenter(numDeliveryTrucks);

        System.out.print("Please enter the number of minutes to keep Package Delivery Center operating for new Packages: ");
        int durationOfModelArrivals = keyboard.nextInt();
        pdc.operatePackageDeliveryCenter(durationOfModelArrivals);

        System.out.print("Please enter the name of the output file for results: ");
        keyboard.nextLine();
        String outputFileName = keyboard.nextLine();

        pdc.generatePackageDeliveryCenterResults(outputFileName);

        keyboard.close();
    }
}
