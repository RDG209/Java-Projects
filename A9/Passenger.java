public class Passenger {
    private String passengerID;
    private String ticketClass;
    private int ticketNumber;
    private static int ticketCounter = 0;

    public Passenger(String ticketClass) {
        setTicketNumber();
        setTicketClass(ticketClass);
        setPassengerID();
    }
    public void setTicketNumber() {
        ticketCounter++;
        ticketNumber = ticketCounter;
    }
    public int getTicketNumber() {
        return ticketNumber;
    }
    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }
    public String getTicketClass() {
        return ticketClass;
    }
    public void setPassengerID() {
        passengerID = "PID_" + ticketClass + " " + ticketNumber;
    }
    public String getPassengerID() {
        return passengerID;
    }
    public String toString() {
        return passengerID;
    }
}
