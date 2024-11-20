import java.util.*;
public class ArrayListSortGenericTester
{
	public static void main(String[] args) 
	{	
		long timeStart, timeEnd, totalTime;
		Scanner keyboard = new Scanner(System.in);
		ArrayListSortGeneric<Integer> insertSortInteger = new ArrayListSortGeneric<Integer>();
		ArrayListSortGeneric<String> insertSortString = new ArrayListSortGeneric<String>();
		System.out.print("Enter the size of the array: ");
		int size = keyboard.nextInt();
		ArrayList<Integer> numList = new ArrayList<Integer>(size);
		// Create the integers
		Random randy = new Random();
		for (int i = 0; i < size; i++) {
			numList.add(randy.nextInt(2000));
		}
		System.out.printf("\n");
		timeStart = System.currentTimeMillis();
		insertSortInteger.insertionSort(numList);
		timeEnd = System.currentTimeMillis();
		totalTime = timeEnd - timeStart;
		System.out.printf("The total time for the sort is %d millisecs\n", totalTime);
		System.out.printf("Sorted: ");
		for (int i = 0; i < size; i++){ 
			System.out.printf("%s ", numList.get(i)); 
		}
		System.out.printf("\n");

		//Strings

		ArrayList<String> stringList = new ArrayList<String>(size);
		for (int i = 0; i < size; i++) {
			StringBuilder sb = new StringBuilder(3);
			for (int j = 0; j < 3 ; j++) {
				sb.append((char) ('A' + randy.nextInt(0, 26)));
			}
			stringList.add(sb.toString());
		}

		System.out.printf("\n");
		timeStart = System.currentTimeMillis();
		insertSortString.insertionSort(stringList);
		timeEnd = System.currentTimeMillis();
		totalTime = timeEnd - timeStart;
		System.out.printf("The total time for the sort is %d millisecs\n", totalTime);
		System.out.printf("Sorted: ");
		for (int i = 0; i < size; i++){ 
			System.out.printf("%s ", stringList.get(i)); 
		}
		System.out.printf("\n");
		
	}
}