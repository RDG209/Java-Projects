import java.util.*;
import java.io.*;

// TestPortfolioManager
public class TestPortfolioManager {
  public static void main(String[] args) throws IOException {

    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter the name of your Portfolio: ");
    String portfolioName = keyboard.nextLine();

    System.out.print("Enter a randomizing seed: ");
    int seed = keyboard.nextInt();
    keyboard.nextLine();

    Portfolio newPortfolio = new Portfolio(portfolioName, seed);

    newPortfolio.initializePortfolio(); // calls for input file and populates portfolio

    System.out.print("Enter the number of months to model: ");
    int months = keyboard.nextInt();
    keyboard.nextLine();

    newPortfolio.modelPortfolio(months);
    newPortfolio.generatePortfolioReport(months);    
  }
  
}