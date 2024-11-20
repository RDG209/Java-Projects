import java.util.*;

public class InfixToPostfixConverter {
  public static void main(String[] args) {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    System.out.print("Enter infix expression: ");
    String infix = scanner.nextLine();

    String postfix = convertToPostfix(infix);

    System.out.println("Postfix expression: " + postfix);
  }

  public static String convertToPostfix(String infix) {
    Stack<Character> charStack = new Stack<Character>();
    StringBuilder postfixExpression = new StringBuilder();

    infix += ")";
    charStack.push('(');

    for (int i = 0; i < infix.length(); i++) {
      char currentChar = infix.charAt(i);

      if (Character.isDigit(currentChar)) {
        postfixExpression.append(currentChar).append(" ");
      } else if (currentChar == '(') {
        charStack.push(currentChar);
      } else if (isOperator(currentChar)) {
        while (!charStack.isEmpty() && isOperator(charStack.peek()) && precedence(charStack.peek(), currentChar)) {
            postfixExpression.append(charStack.pop()).append(" ");
        }
        charStack.push(currentChar);
      } else if (currentChar == ')') {
        while (!charStack.isEmpty() && charStack.peek() != '(') {
          postfixExpression.append(charStack.pop()).append(" ");
        }
        charStack.pop();
      }
    }
    return postfixExpression.toString().trim();

  }
  public static boolean precedence(char op1, char op2) {
    int pre1 = getPrecedence(op1);
    int pre2 = getPrecedence(op2);

    if (op1 == '^' && op2 == '^') {
      return false;
    }

    return pre1 <= pre2;
  }
  public static int getPrecedence(char op) {
    switch (op) {
      case '^':
        return 3;
      case '*':
      case '/':
      case '%':
        return 2;
      case '+':
      case '-':
        return 1;
      default:
        return -1; // non
    }
  }
  public static boolean isOperator(char x) {
    return (x == '^' || x == '*' || x == '/' || x == '%' || x == '+' || x == '-');
  }

}