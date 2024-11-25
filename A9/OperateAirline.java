import java.io.*;
import java.util.*;

public class OperateAirline {
    public static void main(String[] args) throws Exception {
        ArrayList<Flight> flightList = new ArrayList<Flight>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.print("Please enter the Flight Name: ");
            String flightName = scanner.nextLine();

            System.out.print("Please enter an integer seed from 1 to 50: ");
            int seed = scanner.nextInt();
            scanner.nextLine(); // newline character

            flightList.add(new Flight(flightName, seed));
        }

        System.out.print("Please enter the name of the output file: ");
        String outputFileName = scanner.nextLine();

        PrintWriter outputWriter = new PrintWriter(new FileWriter(outputFileName));
        for (Flight flight : flightList) {
                flight.sellSeats();
                flight.lineUpCall();
                flight.boarding(outputWriter);
                outputWriter.println();
                outputWriter.println();
        }

        System.out.println("Boarding details written to " + outputFileName);
      outputWriter.close();
    }
}
