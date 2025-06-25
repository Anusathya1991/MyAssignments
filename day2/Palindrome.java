package week1.day2;

public class Palindrome {

	public static void main(String[] args) {
		int input=12121;
		int output=0;
		int a;
		int b=input;
		while(input>0)
		{
			a=input % 10;
			output = (output*10)+a;
			input = input/10;
			
		}
         if(b == output)
         {
        	 System.out.println("The number " +b+ " is palindrome");
        	 
         }
	    else
	{
             System.out.println("The number " +b+ " is not palindrome");
}
}
}