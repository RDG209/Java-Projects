
public abstract class Investment {
  private String type;
  private String name;
  private double investmentValue;
  
  public Investment() {
    type = "none";
    name = "none";
  }
  public Investment(String newType, String name) {
    setName(name);
    setType(newType);
  }

  public void setType(String newType) {
    type = newType;
  }
  public String getType() {
    return type;
  }
  public void setName(String newName) {
    name = newName;
  }
  public String getName() {
    return name;
  }
  public void setInvestVal(double newInvestVal) {
    investmentValue = newInvestVal;
  }
  public double getInvestVal() {
    return investmentValue;
  }

  public String toString() {
    return ("Investment: " + getType() + " Name: " + getName());
  }
  
}