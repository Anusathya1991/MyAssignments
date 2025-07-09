package week3.Assignment1;

public class Intersection {

	public static void main(String[] args) {
	        // Declare the arrays
	        int[] array1 = {3, 2, 11, 4, 6, 7};
	        int[] array2 = {1, 2, 8, 4, 9, 7};

	        // Outer loop to iterate over array1
	        for (int i = 0; i < array1.length; i++) {
	            // Inner loop to iterate over array2
	            for (int j = 0; j < array2.length; j++) {
	                // Compare elements from both arrays
	                if (array1[i] == array2[j]) {
	                    // Print the matching element
	                    System.out.println("Matching element: " + array1[i]);
	                }
	            }
	        }
	    }
}
