
public class Bond extends Investment {
  private double pricePerBond;
  private double annualReturnPercentage;
  private double monthlyRate;
  private double cashEarnedToDate;
  private int numBondsOwned;
  
  
  public Bond() {
    super();
  }
  public Bond(String name, double bondPrice, int numBonds, double annualPercent) {
    super("Bond", name);
    setPPB(bondPrice);
    setNumBonds(numBonds);
    setAnnualReturnPercentage(annualPercent);

    setInvestVal(getPPB() * getNumBonds());
  }
  public void setPPB(double bond) {
    pricePerBond = bond;
  }
  public double getPPB() {
    return pricePerBond;
  }
  public void setNumBonds(int num) {
    numBondsOwned = num;
  }
  public double getNumBonds() {
    return numBondsOwned;
  }
  public double getAnnualReturnPercentage() {
    return annualReturnPercentage;
  }
  public void setAnnualReturnPercentage(double aRP) {
    annualReturnPercentage = aRP;
    monthlyRate = aRP/(100*12); // aRP divided by the product of 100 and 12
  }
  public void calcBondTotalInvestmentValue() {
    cashEarnedToDate += (pricePerBond*numBondsOwned*monthlyRate);
    setInvestVal(pricePerBond*numBondsOwned + cashEarnedToDate);
  }
  public String toString() {
    return String.format("%s\nPrice per Bond: %.2f Number of Bonds: %d\nCurrent Value: %.2f Cash on Hand to Date: %.2f",super.toString(), pricePerBond, numBondsOwned, getInvestVal(), cashEarnedToDate);
  }
}