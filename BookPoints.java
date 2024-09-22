package myProjects;

import java.util.Scanner;

public class BookPoints {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int books;

        // Prompt user for the number of books purchased
        System.out.print("Enter the amount of books purchased this month: ");
        books = keyboard.nextInt();

        // Determine points earned based on the number of books
        if (books == 1) {
            System.out.print("You have earned 10 points! :)");
        } else if (books == 2) {
            System.out.print("You have earned 20 points! :)");
        } else if (books >= 3) {
            System.out.print("You have earned 30 points! :)");
        } else {
            System.out.print("Invalid number of books.");
        }

        // Close the scanner
        keyboard.close();
    }
}
