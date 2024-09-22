import java.util.*;
import java.io.*;

public class Polling {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    String[] causesList = readCauses();

    System.out.printf("Enter the number for the number of those polled: ");
    int numPolled = keyboard.nextInt();
    keyboard.nextLine();

    int[][] pollResults = performSurvey(causesList, numPolled);

    int[] totalSums = calcCausesSums(pollResults);

    String[] averages = calcAverage(totalSums, numPolled);

    reportResults(causesList, pollResults, numPolled, totalSums, averages);

    keyboard.close();

  }

  public static String[] readCauses() {
    Scanner keyboard = new Scanner(System.in);
    System.out.printf("Enter file name with 5 polling options: ");
    String filename = keyboard.nextLine();

    String[] causesList = new String[5];

    try {
      File file = new File(filename);
      Scanner causes = new Scanner(file);

      int i = 0;

      while (causes.hasNext()) {
        causesList[i] = causes.nextLine();
        i++;
      }
      causes.close();
      return causesList;

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return causesList;

  }

  public static int[][] performSurvey(String[] causesList, int numPolled) {
    int[][] pollResults = new int[5][numPolled];

    Scanner keyboard = new Scanner(System.in);

    boolean valid = false;
    int poll;

    for (int i = 0; i < numPolled; i++) {
      System.out.printf("\nSurveyer #%d\n", i + 1);
      for (int j = 0; j < 5; j++) {
        do {
          System.out.printf("Rate the following cause based on importance 1-10: " + causesList[j] + " ");
          poll = keyboard.nextInt();
          keyboard.nextLine();
          if (poll >= 1 && poll <= 10) {
            valid = true;
          } else {
            valid = false;
          }
        } while (!valid);

        pollResults[j][i] = poll;

      }
    }

    return pollResults;

  }

  public static void reportResults(String[] causesList, int[][] pollResults, int numPolled, int[] totalSums, String[] averages) {

    System.out.printf("\n%15s", "Cause");

    for (int k = 0; k < numPolled; k++) {
      System.out.printf("%5s", "#" + (k+1));
    }
    System.out.printf("%5s", "Sum");
    System.out.printf("%5s", "Avg");

    for (int i = 0; i < 5; i++) {
      System.out.printf("\n%15s", causesList[i]);
      for (int j = 0; j < numPolled; j++) {
        System.out.printf("%5s", pollResults[i][j]);
      }
      System.out.printf("%5s", totalSums[i]);
      System.out.printf("%5s", averages[i]);

    }

    int max = findMaxCause(averages);
    int min = findMinCause(averages);

    System.out.printf("\nThe cause: " + causesList[max] + " is the highest average of importance.");

    System.out.printf("\nThe cause: " + causesList[min] + " is the lowest average of importance.");

  }

  public static int[] calcCausesSums(int[][] results) {
    int[] totals = new int[results.length];
    for (int i = 0; i < results.length; i++) {
      int sum = 0;
      for (int j = 0; j < results[i].length; j++) {
        sum += results[i][j];
      }
      totals[i] = sum;
    }

    return totals;

  }

  public static String[] calcAverage(int[] causesSum, int numPolled) {
    String[] average = new String[causesSum.length];

    for (int i = 0; i < causesSum.length; i++) {
      average[i] = String.format("%.2f", (double)causesSum[i] / numPolled);

    }

    return average;

  }

  public static int findMaxCause(String[] avg) {
    int max = 0;

    double[] avgF = new double[avg.length];

    for (int j = 0; j < avg.length; j++) {
      avgF[j] = Double.parseDouble(avg[j]);
    }

    for (int i = 0; i < avg.length; i++) {
      if (avgF[max] < avgF[i]) {
        max = i;
      }
    }

    return max;

  }

  public static int findMinCause(String[] avg) {
    int min = 0;

    double[] avgF = new double[avg.length];

    for (int j = 0; j < avg.length; j++) {
      avgF[j] = Double.parseDouble(avg[j]);
    }

    for (int i = 0; i < avg.length; i++) {
      if (avgF[min] > avgF[i]) {
        min = i;
      }
    }

    return min;

  }



}