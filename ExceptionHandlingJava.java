import java.util.Scanner;

public class ExceptionHandlingJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numerator = 0;
        int denominator = 0;

        try {
            // Input for the numerator
            System.out.print("Enter numerator: ");
            numerator = Integer.parseInt(scanner.nextLine()); // May throw NumberFormatException

            // Input for the denominator
            System.out.print("Enter denominator: ");
            denominator = Integer.parseInt(scanner.nextLine()); // May throw NumberFormatException

            // Perform division and handle potential division by zero
            int result = numerator / denominator; // May throw ArithmeticException
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a valid integer.");
        } finally {
            System.out.println("Operation completed.");
            scanner.close();  // It's a good practice to close the scanner in the finally block
        }
    }
}
