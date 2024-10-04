
public class Stock extends Investment {
  private double pricePerShare;
  private double numSharesOwned;
  private double dividendsEarnedToDate;

  public Stock() {
    super();
  }
  public Stock(String name, double PPS, double numShares) {
    super("Stock", name);
    setPPS(PPS);
    setNumShares(numShares);

    double totalVal = getPPS() * getNumShares();
    setInvestVal(totalVal);
    
  }

  public void setPPS(double price) {
    pricePerShare = price;
  }
  public double getPPS() {
    return pricePerShare;
  }
  public void setNumShares(double num) {
    numSharesOwned = num;
  }
  public double getNumShares() {
    return numSharesOwned;
  }
  public void setDividends(double num) {
    dividendsEarnedToDate = num;
  }
  public double getDividends() {
    return dividendsEarnedToDate;
  }

  public void calcStockTotalInvestmentValue(double priceChangePercent, double dividendPercent) {
    double priceChange = (pricePerShare * priceChangePercent) / 100;
    setPPS(pricePerShare + priceChange);

    double currentTotalDividend = (pricePerShare*numSharesOwned*(dividendPercent/100));
    dividendsEarnedToDate += currentTotalDividend;

    numSharesOwned += (currentTotalDividend/pricePerShare);

    double newValue = numSharesOwned * pricePerShare;
    setInvestVal(newValue);
  }

  public String toString() {
    return String.format("%s\nPrice per Share: %.2f Num of Shares: %.2f\nCurrent Value: %.2f Investment Earnings to date: %.2f", super.toString(), pricePerShare, numSharesOwned, getInvestVal(), dividendsEarnedToDate);
  }
  
}