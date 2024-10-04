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
      
      while (scnr.hasNext()) {
        type = scnr.next();
        name = scnr.next();
        if (type == "CheckingAccount" || type == "SavingsAccount") {
          accountNumber = scnr.next();
          initialDepot = scnr.nextDouble();
          annualInterestRatePercentage = scnr.nextDouble();
          if (type == "CheckingAccount") {
            minCheckFreeBalance = scnr.nextDouble();
            checkCharge = scnr.nextDouble();

            CheckingAccount newChecking = new CheckingAccount(name, accountNumber, initialDepot, annualInterestRatePercentage, minCheckFreeBalance, checkCharge);
            portfolioInvestments.add(newChecking);
          } else {

            SavingsAccount newSavings = new SavingsAccount(name, accountNumber, initialDepot, annualInterestRatePercentage);
            portfolioInvestments.add(newSavings);
          }
        } else if (type == "Stock") {
          pricePerStock = scnr.nextDouble();
          numShares = scnr.nextDouble();

          Stock newStock = new Stock(name, pricePerStock, numShares);
          portfolioInvestments.add(newStock);
          
        } else if (type == "Bond") {
          pricePerBond = scnr.nextDouble();
          numBonds = scnr.nextInt();
          annualPercent = scnr.nextDouble();

          Bond newBond = new Bond(name, pricePerBond, numBonds, annualPercent);
          portfolioInvestments.add(newBond);
        }

        
        
        scnr.nextLine();
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
        }
      }
    }
  }
}