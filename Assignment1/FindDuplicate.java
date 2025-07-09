package week3.Assignment1;

public class FindDuplicate {

	public static void main(String[] args)
	{
		 	    String text = "We learn Java basics as part of java sessions in java week1";
		        String[] words = text.split(" ");
		        int count;

		        for (int i = 0; i < words.length; i++) 
		        {
		            count = 1;
		            for (int j = i + 1; j < words.length; j++)
		            {
		                if (words[i].equalsIgnoreCase(words[j]) && ! words[i].equals("")) {
		                    
		                	count++;
		                	words[j] = ""; // Remove duplicate
		                    
		                }
		            }
		       
		        // Print the array
		        if(count>1)
		        {
		            System.out.print(words[i] + "is the duplicate word ");
		        }
		    }
System.out.println("Result");
   for(String word:words) {
	   if(!word.equals(""))
	   {
		   System.out.print(word+"");
	   }
   }

	}	
	}

