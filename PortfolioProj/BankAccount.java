
public abstract class BankAccount extends Investment {
  private String accountNumber;

  public BankAccount() {
    super();
    setAccountNumber("none");
  }
  public BankAccount(String newType, String newName, String newNum) {
    super(newType, newName);
    setAccountNumber(newNum);
  }
  public void setAccountNumber(String num) {
    accountNumber = num;
  }
  public String getAccountNumber() {
    return accountNumber;
  }
  public String toString() {
    return (super.toString() + " Account Number: " + accountNumber);
  }
}