package myProjects;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class BarLength {

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        Random rand = new Random();

        // Get the filename from user input via a dialog box
        String filename;
        filename = JOptionPane.showInputDialog("Enter a filename in .txt format: ");

        // Initialize FileWriter and PrintWriter to append to the file
        FileWriter fw = new FileWriter(filename, true);
        PrintWriter output = new PrintWriter(fw);

        // Generate random numbers and write to file
        for (int i = 1; i < 10; i++) {
            int num = rand.nextInt(9) + 1;
            output.printf("%d) [%d] ", i, num);

            // Print asterisks corresponding to the random number
            for (int e = 0; e < num; e++) {
                output.print("*");
            }
            output.println("");
        }

        // Close the output and file writer
        output.close();
        fw.close();
        keyboard.close();
    }
}
