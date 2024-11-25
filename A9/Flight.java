import java.util.*;
import java.io.*;

public class Flight {
    private String flightName;
    private int seats;
    private int seatsSold;
    private Random randy;
    private LinkedList<Passenger> passBooked = new LinkedList<Passenger>();
    private PriorityQueue<Passenger> boardingQueue = new PriorityQueue<Passenger>(new PassengerComparator());

    public Flight(String flightName, int seed) {
        setFlightName(flightName);
        randy = new Random(seed);
        setSeats();
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public void setSeats() {
        seats = randy.nextInt(75, 151);
    }

    public void sellSeats() {
        seatsSold = seats/2 + randy.nextInt(0, 1 + seats/2);
        for (int i = 0; i < seatsSold; i++) {
            if (randy.nextInt(5) == 0) {
                passBooked.add(new FirstClassPassenger());
            } else {
                passBooked.add(new CoachPassenger());
            }
        }
    }

    public void lineUpCall() {
        boardingQueue.addAll(passBooked);
    }

    public void boarding(PrintWriter outputWriter) {
        outputWriter.printf("The boarding order for Flight %s with %d seats and %d seats sold is:%n", flightName, seats, seatsSold);
        int count = 0;
        while (!boardingQueue.isEmpty()) {
            outputWriter.printf("%-15s", boardingQueue.poll());
            count++;
            if (count % 3 == 0) {
                outputWriter.println();
            }
        }
        outputWriter.println();
    }
}
