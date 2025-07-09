package week3.Assignment1;

public class RevereseStringOddPosition
{
	public static void main(String[] args)
	{
		String test="I am a software tester";
		String[] words=test.split(" ");
		System.out.println("Result is:");
		for(int i=0; i< words.length; i++)
		{
			if(i %2 != 0) 
			{
				char[] charArray = words[i].toCharArray();
				for(int j=charArray.length-1; j>=0; j--)

			{
					System.out.print(charArray[j]);
					
					}
			}
			else
				System.out.print(words[i]);
		}
		System.out.print("  ");
		}
		}