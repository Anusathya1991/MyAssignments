package week3.Assignment1;

import java.util.Arrays;

public class Anagram {

	public static boolean areAnagrams(String str1, String str2) {
	
		str1=str1.replaceAll("\\s", "").toLowerCase();
		str2=str2.replaceAll("\\s", "").toLowerCase();
		
		if (str1.length() != str2.length())
		{
		System.out.println("Lengths mismatch, therefore the strings are not an Anagram");
		return false;
		}
		char[] charArray1=str1.toCharArray();
		char[] charArray2=str2.toCharArray();
	
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		
		return Arrays.equals(charArray1, charArray2);
	}

	public static void main(String[] ars) {
		String s1="stops";
		String s2="posts";
		 if(areAnagrams(s1,s2))
		 {
			 System.out.println("The given strings are Anagram");
		 }
		 else
		 {
			 System.out.println("The given strings are not Anagram");
			 
		 }
	

	}

}

