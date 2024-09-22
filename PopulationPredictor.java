package myProjects;
import java.util.Scanner;

public class PopulationPredictor {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        double size;
        int increase;
        int days;

        // Get the starting population size
        System.out.print("Enter the starting size of the population: ");
        size = keyboard.nextInt();
        
        // Ensure the population size is at least 2
        while (size < 2) {
            System.out.println("There can be no less than 2 starting population.");
            System.out.print("Enter the starting size of the population: ");
            size = keyboard.nextDouble();
        }

        // Get the growth percentage per day
        System.out.print("Enter the growth percentage per day (as a whole number): ");
        increase = keyboard.nextInt();
        
        // Ensure the growth percentage is non-negative
        while (increase < 0) {
            System.out.println("There cannot be negative growth.");
            System.out.print("Enter the growth percentage per day (as a whole number): ");
            increase = keyboard.nextInt();
        }

        // Get the duration in days
        System.out.print("Enter the duration in days: ");
        days = keyboard.nextInt();
        
        // Ensure there is at least 1 day of growth
        while (days < 1) {
            System.out.println("There can be no less than 1 day of growth.");
            System.out.print("Enter the duration in days: ");
            days = keyboard.nextInt();
        }

        // Close the scanner
        keyboard.close();

        // Calculate and display population growth
        for (int i = 1; i <= days; i++) {
            size = size * (1 + (increase / 100.0));
            System.out.printf("Day %d: The population is now %.2f\n", i, size);
        }
    }
}
