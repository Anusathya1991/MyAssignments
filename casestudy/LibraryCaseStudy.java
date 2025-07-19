package casestudy;

public class LibraryCaseStudy {
		    // Variables declaration
	    int bookId;
	    String title;
	    String author;
	    boolean isAvailable;

	    // Method to borrow the book
	    void borrowBook() {
	        if (isAvailable)
	        {
	            isAvailable = false;
	            System.out.println("Book has been borrowed.");
	        } 
	        else 
	        {
	            System.out.println("Book is currently not available.");
	        }
	    }

	    // Method to return the book
	    void returnBook() 
	    {
	        if (!isAvailable) 
	        {
	            isAvailable = true;
	            System.out.println("Book has been returned.");
	        } 
	        else 
	        {
	            System.out.println("Book was not borrowed.");
	        }
	    }

	    // Method to display book details
	    void displayDetails() 
	    {
	        System.out.println("Book ID: " + bookId);
	        System.out.println("Title  : " + title);
	        System.out.println("Author : " + author);
	        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
	        System.out.println("------------------------------");
	    }


	    public static void main(String[] args) {
	        // Creating a single object manually
	        LibraryCaseStudy book = new LibraryCaseStudy();

	        // Assigning values directly
	        book.bookId = 1001;
	        book.title = "Agni Siragugal";
	        book.author = "Dr.A.P.J Abdulkalam";
	        book.isAvailable = true;

	        // Display book details
	        book.displayDetails();

	        // Borrow the book
	        book.borrowBook();
	        book.displayDetails();

	        // Try borrowing again
	        book.borrowBook();

	        // Return the book
	        book.returnBook();
	        book.displayDetails();

	        // Try returning again
	        book.returnBook();
	    }
	}
			
