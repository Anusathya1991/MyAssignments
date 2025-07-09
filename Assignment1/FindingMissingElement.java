package week3.Assignment1;

import java.util.Arrays;

public class FindingMissingElement {

	public static void main(String[] args) {
		int[] arr = {1, 4, 3, 2, 8, 6, 7};

        // Sort the array
        Arrays.sort(arr);

        // Loop through the array and check for the missing number
        for (int i = 0; i < arr.length - 1; i++) {
            // If the next number is not current + 1, missing number found
            if (arr[i + 1] != arr[i] + 1) {
                System.out.println("Missing number: " + (arr[i] + 1));
                break;
            }
        }
    }
}