import java.util.concurrent.Semaphore;

public class TicketBookingSystem {

    private static final int TOTAL_TICKETS = 5;
    private static int ticketsLeft = TOTAL_TICKETS;

    private static final Semaphore semaphore = new Semaphore(TOTAL_TICKETS);

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Thread userThread = new Thread(new User("User-" + i));
            userThread.start();
        }
    }

    static class User implements Runnable {
        private final String userName;

        public User(String userName) {
            this.userName = userName;
        }

        @Override
        public void run() {
            try {
                if (semaphore.tryAcquire()) {
                    bookTicket();
                    semaphore.release();
                } else {
                    System.out.println(userName + " could not acquire the semaphore and left.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        private synchronized void bookTicket() {
            if (ticketsLeft > 0) {
                ticketsLeft--;
                System.out.println(userName + " successfully booked a ticket! Tickets left: " + ticketsLeft);
            } else {
                System.out.println(userName + " could not book a ticket. Tickets are sold out.");
            }
        }
    }
}
