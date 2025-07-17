package alert.setassignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingNumbers {

	public static void main(String[] args) {
	
	        // Declare the array
	        Integer[] arr = {1, 2, 3, 4, 10, 6, 8};

	        // Convert array to List
	        List<Integer> numbers = new ArrayList<>();
	        Collections.addAll(numbers, arr);

	        // Sort the list in ascending order
	        Collections.sort(numbers);

	        System.out.println("Sorted list: " + numbers);
	        System.out.println("Missing numbers:");

	        // Loop through the list and find missing numbers
	        for (int i = 0; i < numbers.size() - 1; i++) {
	            int current = numbers.get(i);
	            int next = numbers.get(i + 1);

	            // Check for gap
	            if (next != current + 1) {
	                for (int missing = current + 1; missing < next; missing++) {
	                    System.out.println(missing);
	                }
	            }
	        }
	    }
	}
