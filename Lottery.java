package myProjects;

import java.util.Random;
import java.util.Scanner;

public class Lottery {

    private int[] lotto = new int[8];
    private int[] user = new int[8];

    public void Lotto() {
        Scanner keyboard = new Scanner(System.in);
        Random rand = new Random();

        // Generate random lotto numbers
        for (int i = 0; i < 8; i++) {
            lotto[i] = rand.nextInt(10);
        }

        // Get user input for lotto numbers
        for (int i = 0; i < 8; i++) {
            System.out.print("Enter the next lotto number: ");
            user[i] = keyboard.nextInt();
        }

        int match = 0;

        // Count how many numbers match
        for (int i = 0; i < 8; i++) {
            if (lotto[i] == user[i]) {
                match++;
            }
        }

        // Display lotto numbers and user's numbers
        System.out.print("\nLotto Numbers: ");
        for (int i = 0; i < 8; i++) {
            System.out.print(lotto[i] + " | ");
        }

        System.out.print("\nYour Numbers: ");
        for (int i = 0; i < 8; i++) {
            System.out.print(user[i] + " | ");
        }

        // Check if the user won
        if (match == 5) {
            System.out.println("\nCONGRATULATIONS YOU WON!");
        } else {
            System.out.println("\nOops, you only got " + match + " correct out of 5. Try again!");
        }
    }
}