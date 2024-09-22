package myProjects;

public class CheckingAccount {
    private String name;
    private double balance;
    private int number;

    public CheckingAccount(int num, String nam, double bal) {
        name = nam;
        number = num;
        balance = bal;
    }

    public double processDeposit(double amount) {
        balance += amount;
        System.out.println("Deposit Processed, Current Balance is: " + balance);
        return balance;
    }

    public void processCheck(double amount) {
        if (balance > -1000) {
            balance -= amount;
            if (balance < 0) {
                System.out.println("OVERDRAFT");
                System.out.println("Balance: " + balance);
            }
        } else {
            System.out.println("Too poor");
        }
    }

    public void withdraw(double amount) {
        processCheck(amount);
    }

    public void setName(String nombre) {
        name = nombre;
    }

    public String getName() {
        return name;
    }

    public void setBalance(double amount) {
        balance = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(int num) {
        number = num;
    }

    public int getAccountNumber() {
        return number;
    }
}



