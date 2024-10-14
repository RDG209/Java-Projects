package myProjects;

//RICARDO GAETA, CSC#123-07, Assignment 7, 3/7/2024

import java.util.*;
import java.io.*;

public class StringArray {
 public static Scanner scnr;
 public static int arraySize;

 public static void main(String[] args) throws IOException {
     scnr = new Scanner(System.in);
     arraySize = 5;

     String[] myStrings = new String[arraySize];
     myStrings = createStringArray();
     myStrings = populateArray(arraySize);

     for (String word : myStrings) {
         System.out.println(word);
     }

     double avg = findAverageLength(myStrings);
     System.out.println("The average length of the strings: " + avg);
 }

 public static String[] createStringArray() {
     String[] newStrings = new String[arraySize];
     return newStrings;
 }

 public static String[] populateArray(int arraySize) throws IOException {
     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     String[] newString = new String[arraySize];

     for (int i = 0; i < arraySize; ++i) {
         System.out.print("Enter string " + (i + 1) + " : ");
         newString[i] = reader.readLine();
     }

     return newString;
 }

 public static double findAverageLength(String[] myArr) {
     int sum = 0;
     double avg = 0;

     for (int i = 0; i < myArr.length; ++i) {
         sum += myArr[i].length();
     }

     avg = (double) sum / myArr.length;
     return avg;
 }
}

