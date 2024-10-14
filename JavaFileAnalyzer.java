package myProjects;
import java.util.*;
import java.io.*;
import java.util.regex.*;

// JavaFileAnalyzer
//
public class JavaFileAnalyzer {

  public static void main(String[] args) throws IOException {
	  
	  Scanner keyboard = new Scanner(System.in);
	  
	  System.out.print("Enter a java file name: ");
	  String filename = keyboard.nextLine();
	  File file = new File(filename);
	  
	  countCodeBlocks(file);
	  countKeywords(file);
	  
	  keyboard.close();

  }

  public static void countKeywords(File file) throws IOException {

    int forCount = 0;
    int ifCount = 0;
    int whileCount = 0;
    int publicCount = 0;
    int classCount = 0;

    Pattern keywordCheck = Pattern.compile("\\b(for|if|while|public|class)\\b");

    Scanner scan = new Scanner(file);

    while (scan.hasNext()) {
      String line = scan.nextLine();
      Matcher matcher = keywordCheck.matcher(line);

      while (matcher.find()) {
        String current = matcher.group();

        switch (current) {
          case "for":
        	  forCount++;
        	  break;
          case "if":
        	  ifCount++;
        	  break;
          case "while":
        	  whileCount++;
        	  break;
          case "public":
        	  publicCount++;
        	  break;
          case "class":
        	  classCount++;
        	  break;

        }
      }

    }
    
    scan.close();
    System.out.println("\nKeyword Counts: ");
    System.out.printf("For Count: %d\nIf Count: %d\nWhile Count: %d\nPublic Count: %d\nClass Count: %d", forCount, ifCount, whileCount, publicCount, classCount);

  }
  public static void countCodeBlocks(File file) throws IOException {
	  
	  Pattern classCheck = Pattern.compile("\\bclass\\b");
	  Pattern methodCheck = Pattern.compile("\\b(public|private|protected)?\\s+[\\w<>]+\\s+\\w+\\s*\\([^)]*\\)\\s*\\{");
	  Pattern loopCheck = Pattern.compile("\\b(for|while)\\b");
	  Pattern conCheck = Pattern.compile("\\b(if|else if|else)\\b");
	  
	  int classCount = 0;
	  int methodCount = 0;
	  int loopCount = 0;
	  int conCount = 0;
	  
	  Scanner scan = new Scanner(file);
	  
	  while (scan.hasNext()) {
		  String line = scan.nextLine();
		  
		  Matcher classMatcher = classCheck.matcher(line);
		  Matcher methodMatcher = methodCheck.matcher(line);
		  Matcher loopMatcher = loopCheck.matcher(line);
		  Matcher condMatcher = conCheck.matcher(line);
		  
		  if (classMatcher.find()) {
			  classCount++;
		  }
		  if (methodMatcher.find()) {
			  methodCount++;
		  }
		  if (loopMatcher.find()) {
			  loopCount++;
		  }
		  if (condMatcher.find()) {
			  conCount++;
		  }
		  
	  }
	  
	  System.out.println("\nCode Block COunts: ");
	  System.out.printf("Class Count: %d\nMethod Count: %d\nLoop Count: %d\nConditional Count: %d", classCount, methodCount, loopCount, conCount);
	  scan.close();
	  
  }
  
}
