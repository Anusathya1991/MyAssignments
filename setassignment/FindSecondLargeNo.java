package alert.setassignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSecondLargeNo
	{

	public static void main(String[] args) 
	{
		int[] arr = {3, 2, 11, 4, 6, 7};
		
		//int array has been assigned to list
		List<Integer> list = new ArrayList<>();
		
		//for each loop to iterate all the values of the array and store in a list
		for (int num : arr) 
		{
			list.add(num);
		}
		//to sort the elements in list in assending order
		Collections.sort(list);
		
		//print the sorted list
		System.out.println(list);
		
		//print the second largest element in the list
		System.out.println(list.get(list.size()-2));
		}
	}
