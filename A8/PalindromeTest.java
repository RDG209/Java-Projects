import java.util.*;

public class PalindromeTest {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("Enter an String: ");
    String first = keyboard.nextLine();

    if (isPalindrome(first)) {
      System.out.println("The input String is a Palindrome :)");
    } else {
      System.out.println("The input String is NOT a Palindrome!!!");
    }

    System.out.print("Enter an String: ");
    String second = keyboard.nextLine();

    if (isPalindrome(second)) {
      System.out.println("The input String is a Palindrome :)");
    } else {
      System.out.println("The input String is NOT a Palindrome!!!");
    }

    System.out.print("Enter an String: ");
    String third = keyboard.nextLine();

    if (isPalindrome(third)) {
      System.out.println("The input String is a Palindrome :)");
    } else {
      System.out.println("The input String is NOT a Palindrome!!!");
    }

    System.out.print("Enter an String: ");
    String fourth = keyboard.nextLine();

    if (isPalindrome(fourth)) {
      System.out.println("The input String is a Palindrome :)");
    } else {
      System.out.println("The input String is NOT a Palindrome!!!");
    }
    
  }
  public static boolean isPalindrome(String original) {
    String cleanWord = cleanString(original);

    Stack<Character> stack = new Stack<Character>();

    for (char letter : cleanWord.toCharArray()) {
      stack.push(letter);
    }

    StringBuilder reverse = new StringBuilder();

    while (!stack.isEmpty()) {
      reverse.append(stack.pop());
    }

    return cleanWord.equals(reverse.toString());
    
  }
  public static String cleanString(String original) {
    String result = original.toLowerCase();
    result = result.replaceAll("[\\p{Punct}\\s+]", "");
    return result;
  }
}