import java.util.*;
import java.io.*;

public class Portfolio {
  private String portfolioName;
  private ArrayList<Investment> portfolioInvestments;
  private Random randy;
  public Scanner keyboard = new Scanner(System.in);
  
  public Portfolio() {
    portfolioName = "none";
  }
  public Portfolio(String name, int randomSeed) {
    portfolioName = name;
    portfolioInvestments = new ArrayList<Investment>();
    randy = new Random(randomSeed);
  }
  public void initializePortfolio() {
    System.out.print("Enter the name of an input file: ");
    String filename = keyboard.nextLine();

    try {
      File file = new File(filename);
      Scanner scnr = new Scanner(file);
      String type;
      String name;
      String accountNumber;
      double initialDepot;
      double annualInterestRatePercentage;
      double minCheckFreeBalance;
      double checkCharge;
      double pricePerStock;
      double numShares;
      int numBonds;
      double pricePerBond;
      double annualPercent;
      
      while (scnr.hasNext()) { // populate array
        type = scnr.next();
        name = scnr.next();
        if (type.equals("CheckingAccount") || type.equals("SavingsAccount")) {
          accountNumber = scnr.next();
          initialDepot = scnr.nextDouble();
          annualInterestRatePercentage = scnr.nextDouble();
          if (type.equals("CheckingAccount")) {
            minCheckFreeBalance = scnr.nextDouble();
            checkCharge = scnr.nextDouble();

            CheckingAccount newChecking = new CheckingAccount(name, accountNumber, initialDepot, annualInterestRatePercentage, minCheckFreeBalance, checkCharge);
            portfolioInvestments.add(newChecking);

            
          } else {

            SavingsAccount newSavings = new SavingsAccount(name, accountNumber, initialDepot, annualInterestRatePercentage);
            portfolioInvestments.add(newSavings);

            
          }
        } else if (type.equals("Stock")) {
          pricePerStock = scnr.nextDouble();
          numShares = scnr.nextDouble();

          Stock newStock = new Stock(name, pricePerStock, numShares);
          portfolioInvestments.add(newStock);
          
        } else if (type.equals("Bond")) {
          pricePerBond = scnr.nextDouble();
          numBonds = scnr.nextInt();
          annualPercent = scnr.nextDouble();

          Bond newBond = new Bond(name, pricePerBond, numBonds, annualPercent);
          portfolioInvestments.add(newBond);

          
        }

        System.out.println("Added to List: " + type + " " + name);
      }


      
      scnr.close();
      
    } catch (IOException e) {
      
    }
    
  }
  public void modelPortfolio(int numMonths) {
    for (int month = 0; month < numMonths; month++) {
      for (Investment current : portfolioInvestments) {
        if (current instanceof Stock) {
          Stock stockItem = (Stock) current;

          if (month%3 == 0) {
            double priceChangePercent = randy.nextInt(-5, 101)/10;
            double dividendPercent = randy.nextInt(0, 51)/10;
            stockItem.calcStockTotalInvestmentValue(priceChangePercent, dividendPercent);
          } 

        } else if (current instanceof Bond) {
          Bond bondItem = (Bond) current;
          bondItem.calcBondTotalInvestmentValue();
        } else if (current instanceof SavingsAccount) {
          SavingsAccount savingsItem = (SavingsAccount) current; // SAYS TO CAST AS STOCK, ASSUMING THAT IS A TYPO?

          for (int i = 0; i < 3; i++) {
            double change = randy.nextInt(-60000, 100001) /100.00;
            if (change >= 0) {
              savingsItem.makeDeposit(change);
            } else {
              savingsItem.makeWithdrawl(Math.abs(change));
            }
          }

          savingsItem.calcValue();
          
        } else if (current instanceof CheckingAccount) {
          CheckingAccount checkingItem = (CheckingAccount) current; // SAYS TO CAST AS STOCK, ASSUMING THAT IS A TYPO?

          double deposit = randy.nextInt(5000,15001)/10.0;
          checkingItem.makeDeposit(deposit);

          for (int i = 0; i < 4; i++) {
            double check = randy.nextInt(1000, 30001) /100.0;
            checkingItem.writeCheck(check);
          }

          checkingItem.calcValue();
          
        }
      }
    }
  }

  public void generatePortfolioReport(int months) throws IOException {
    System.out.print("Enter the name of the output file: ");
    String filename = keyboard.nextLine();
    PrintWriter writer = new PrintWriter(new FileWriter(filename));
    double totalVal = 0;

    writer.println("Results of the portfolio '" + portfolioName + "' over " + months + " months");
    for (Investment current : portfolioInvestments) {
      totalVal += current.getInvestVal();
      writer.println(current.toString());
      System.out.println(current.toString());

      writer.println("\n");
    }

    writer.printf("\nTotal Value of Portfolio: $%.2f", totalVal);

    writer.close();
    
  }
}