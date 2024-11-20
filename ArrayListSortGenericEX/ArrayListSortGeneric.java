import java.util.*;

public class ArrayListSortGeneric<T extends Comparable<T>>
{
	
	public ArrayListSortGeneric() {
		
	}
	
	public void insertionSort(ArrayList<T> list)
	{ 
		for (int i = 1; i < list.size(); i++) {
			T current = list.get(i);
			int prevIndex = i - 1;

			while (prevIndex >= 0 && list.get(prevIndex).compareTo(current) > 0) {
				list.set(prevIndex+1, list.get(prevIndex));
				prevIndex--;
			}

			list.set(prevIndex+1, current);
		}
	}
	public void insert(ArrayList<T> list, int i)
	{
		// place x[i] in its proper place among sorted values x[0], x[1]...x[i􏰎1]
		T temp = list.get(i); // save the value
		int j = i-1;
		while (j >= 0 && list.get(j).compareTo(temp) > 0) // determine where to place temp 
		{
			T one = list.get(j);
			list.add(j+1, one);
			j--; 
		}
		list.add(j+1, temp);
	}
	
}