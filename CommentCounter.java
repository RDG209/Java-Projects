import java.util.*;
import java.io.*;

public class CommentCounter {
  public static void main(String[] args) throws IOException {

    int singleLineCount = 0;
    int multiLineCount = 0;
    int docCommentCount = 0;
    boolean insideMultiLine = false;
    boolean insideDocComment = false;

    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter the name of the file: ");
    String fileName = keyboard.nextLine();

    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    String line;

    while ((line = reader.readLine()) != null) {

      boolean insideString = false;  // strings within the line

      for (int i = 0; i < line.length(); i++) { // same line check
        char curr = line.charAt(i);

        if (curr == '\"' && (i == 0 || line.charAt(i - 1) != '\\')) {
          insideString = !insideString;
          continue;
        }

        if (!insideString) { // outside string

          if (insideDocComment) {
            if (curr == '*' && i + 1 < line.length() && line.charAt(i + 1) == '/') { // check end of Doc
              insideDocComment = false;
              docCommentCount++;
              i++; // Skip '/'
              continue;
            }
          } else if (insideMultiLine) {
            if (curr == '*' && i + 1 < line.length() && line.charAt(i + 1) == '/') { // check end of multi
              insideMultiLine = false;
              multiLineCount++;
              i++; // Skip '/'
              continue;
            }
          } else {
            if (curr == '/' && i + 1 < line.length() && line.charAt(i + 1) == '/') { // check single starter after doc+multi
              singleLineCount++;
              break; // Ignore the rest of the line
            }

            if (curr == '/' && i + 1 < line.length() && line.charAt(i + 1) == '*') { // check starters
              if (i + 2 < line.length() && line.charAt(i + 2) == '*') {
                insideDocComment = true; // confirm doc
              } else {
                insideMultiLine = true;  // confirm multi
              }
              i++;
              continue;
            }
          }
        }
      }

      //  multiple lines check
      if (insideMultiLine || insideDocComment) {
        if (line.contains("*/")) { // find end
          if (insideDocComment) {
            docCommentCount++;
          } else {
            multiLineCount++;
          }
          insideMultiLine = false;
          insideDocComment = false;
        }
      }
    }

    reader.close();

    System.out.printf("Single: %d   Multi: %d   Doc: %d%n", singleLineCount, multiLineCount, docCommentCount);
  }
}
