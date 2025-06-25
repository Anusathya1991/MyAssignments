package week1.day2;

public class Fibonacci {

	public static void main(String[] args) {
		int n = 8;
		int n1 = 0;
		int n2 = 1;
		System.out.println("Fibonacci  Series");
		for(int i=1; i<=n; i++)
		{
			System.out.println(n1 +" "); 
			int n3=n1+n2;
			n1 = n2;
			n2 = n3;
		}
		}
	}


