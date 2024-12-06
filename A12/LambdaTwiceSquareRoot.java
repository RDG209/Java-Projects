package lambda;
import java.util.*;

public class LambdaTwiceSquareRoot{

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		TwiceSquareRoot e1 = (x) -> {
			double result = Math.sqrt(x) * 2;
			System.out.printf("Without return double the square root is %.3f\n", result);
			return result;
		};
		
		TwiceSquareRoot e2 = (x) -> {
			return Math.sqrt(x) *2;
		};
		
		System.out.print("Please enter the value as a type double: ");
        double value = keyboard.nextDouble();

        e1.twiceSquareRoot(value);
        
        System.out.print("Please enter the value as a type double: ");
        value = keyboard.nextDouble();

        System.out.printf("With return double the square root is %.3f\n", e2.twiceSquareRoot(value));
		
	}

}
