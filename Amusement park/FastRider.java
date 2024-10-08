
public class FastRider extends Rider implements TicketPrice {
  static double totalGate;
  private double ticketPrice;

  public FastRider() {
    
  }
  public FastRider(int time) {
     super(time);
    setTicketPrice();
    setTotalGate();
  }

  public static double getTotalGate() {
    return totalGate;
  }
  public void setTotalGate() {
    totalGate += ticketPrice;
  }
  public double getTicketPrice() {
    return this.ticketPrice;
  }
  public void setTicketPrice() {
    this.ticketPrice = BASEPRICE * 1.4;
  }
}