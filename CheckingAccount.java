
public class CheckingAccount extends BankAccount {
  private double annualInterestRatePercent;
  private double monthlyRate;
  private double totalInterestEarned;
  private double minimumCheckFreeBalance;
  private double checkCharge;
  private double totalCheckCharges;

  public CheckingAccount() {
    super();
  }
  public CheckingAccount(String name, String accountNumber, double initialDepot, double IRP, double minCheck, double charge) {
    super("CheckingAccount", name, accountNumber);
    setInvestVal(initialDepot);
    setAnnualIRP(IRP);
    setMinCheckFreeBalance(minCheck);
    setCheckCharge(charge);
  }

  public void setAnnualIRP(double aIRP) {
    annualInterestRatePercent = aIRP;
    monthlyRate = (aIRP/(100*12));
  }
  public double getAnnualIRO() {
    return annualInterestRatePercent;
  }
  public void setTotalInterest(double interestEarned) {
    totalInterestEarned = interestEarned;
  }
  public double getTotalInterest() {
    return totalInterestEarned;
  }
  public void setMinCheckFreeBalance(double min) {
    minimumCheckFreeBalance = min;
  }
  public double getMinCheckFreeBalance() {
    return minimumCheckFreeBalance;
  }
  public void setCheckCharge(double check) {
    checkCharge = check;
  }
  public double getCheckCharge() {
    return checkCharge;
  }
  public void setTotalCheckCharge(double totalCharge) {
    totalCheckCharges = totalCharge;
  }
  public double getTotalCheckCharge() {
    return totalCheckCharges;
  }
  public void makeDeposit(double deposit) {
    setInvestVal(getInvestVal() + deposit);
  }
  public void writeCheck(double checkValue) {
    if (getInvestVal() < checkValue) { // if not enough in account
      System.out.println("Insufficient Funds");
    } else if (getInvestVal() >= minimumCheckFreeBalance) {
      setInvestVal(getInvestVal() - checkValue);
    } else {
      setInvestVal(getInvestVal() - checkValue - checkCharge);
      setTotalCheckCharge(totalCheckCharges + checkCharge);
    }
  }
  public void calcValue() {
    if (getInvestVal() >= minimumCheckFreeBalance) {
      double monthInterest = getInvestVal() * monthlyRate;
      totalInterestEarned += monthInterest;
      setInvestVal(getInvestVal() + monthInterest); // "Whcih adds the interest for this MONTH to the investment Value"
    }
  }
  public String toString() {
    return String.format("%s\nMinimum for Free Checking: %.2f Check Charge: %.2f\nCurrent value: %.2f Interest Earned: %.2f Check Charges: %.2f",super.toString(), minimumCheckFreeBalance, checkCharge, getInvestVal(), totalInterestEarned, totalCheckCharges);
  }
}