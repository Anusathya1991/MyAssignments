package week1.day2;

public class IsPrime1 
{

	public static void main(String[] args)
	{
		int n=7;
		
		for(int i=2; i<n; i++) 
		{
			if(n % i == 0)
			{
				System.out.println("Not prime number");
				return;
			}
		}
      System.out.println("prime number");
		}
}

