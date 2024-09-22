package myProjects;

import java.util.Scanner;

public class Sub100Calc {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        double first;
        double second;
        String operator;

        // Get the first number from the user
        System.out.print("Enter the first number: ");
        first = keyboard.nextDouble();

        // Validate the first number
        while (first < 0 || first > 100) {
            System.out.println("OVERFLOW! First number must be between 0 and 100.");
            System.out.print("Enter the first number: ");
            first = keyboard.nextDouble();
        }

        // Clear the buffer
        keyboard.nextLine();

        // Get the operator from the user
        System.out.print("Enter an operator (+, -, *, /): ");
        operator = keyboard.nextLine();

        // Get the second number from the user
        System.out.print("Enter the second number: ");
        second = keyboard.nextDouble();

        // Validate the second number
        while (second < 0 || second > 100) {
            System.out.println("OVERFLOW! Second number must be between 0 and 100.");
            System.out.print("Enter the second number: ");
            second = keyboard.nextDouble();
        }

        // Close the scanner
        keyboard.close();

        // Perform the operation based on the operator provided
        switch (operator) {
            case "+":
                double sum = first + second;
                if (sum < 100) {
                    System.out.println("OVERFLOW! Result is less than 100.");
                } else {
                    System.out.println("Sum: " + sum);
                }
                break;

            case "-":
                double difference = first - second;
                if (difference < 100) {
                    System.out.println("OVERFLOW! Result is less than 100.");
                } else {
                    System.out.println("Difference: " + difference);
                }
                break;

            case "/":
                if (second == 0) {
                    System.out.println("DIVISION BY ZERO NOT POSSIBLE");
                } else {
                    double quotient = first / second;
                    if (quotient < 100) {
                        System.out.println("OVERFLOW! Result is less than 100.");
                    } else {
                        System.out.println("Quotient: " + quotient);
                    }
                }
                break;

            case "*":
                double product = first * second;
                if (product < 100) {
                    System.out.println("OVERFLOW! Result is less than 100.");
                } else {
                    System.out.println("Product: " + product);
                }
                break;

            default:
                System.out.println("Invalid operator. Please enter +, -, *, or /.");
                break;
        }
    }
}

