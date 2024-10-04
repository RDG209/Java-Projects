
public class SavingsAccount extends BankAccount {
  private double annualInterestRatePercent;
  private double monthlyRate;
  private double totalInterestEarned;

  public SavingsAccount() {
    super();
  }
  public SavingsAccount(String name, String accountNumber, double initialDeposit, double IRP) {
    super("SavingsAccount", name, accountNumber);
    setInvestVal(initialDeposit);
    setAnnualIRP(IRP);
  }

  public void setAnnualIRP(double aIRP) {
    annualInterestRatePercent = aIRP;
    monthlyRate = (aIRP/(100*12));
  }
  public double getAnnualIRP() {
    return annualInterestRatePercent;
  }
  public void setTotalInterestEarned(double interest) {
    totalInterestEarned = interest;
  }
  public double getTotalInterestEarned() {
    return totalInterestEarned;
  }
  public void makeDeposit(double deposit) {
    setInvestVal(getInvestVal() + deposit);
  }
  public boolean makeWithdrawl(double withdraw) {
    if (withdraw > getInvestVal()) {
      System.out.println("Insufficient Funds");
      return false;
    } else {
      setInvestVal(getInvestVal() - withdraw);
      return true;
    }
  }
  public void calcValue() {
    double monthInterest = getInvestVal() * monthlyRate;
    totalInterestEarned += monthInterest;
    setInvestVal(getInvestVal() + monthInterest); // "Whcih adds the interest for this MONTH to the investment Value"
  }
  public String toString() {
    return (super.toString() + "\nCurrent value: " + getInvestVal() + " Interest Earned: " + totalInterestEarned);
  }
}