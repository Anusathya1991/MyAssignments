package alert.setassignment;

public class Polymorphism_overload_APIClient {
	
	    // To Create a method with single argument
		public void sendRequest(String endpoint) 
		{
			System.out.println(endpoint);
		}
		
		//To Create method with multiple arguments
		public void sendRequest(String endpoint, String requestBody,boolean requestStatus)
		{
			System.out.println(endpoint);
			System.out.println(requestBody);
			System.out.println(requestStatus);
		}

		public static void main(String[] args) {
			//Creating object to call the methods
			Polymorphism_overload_APIClient obj = new Polymorphism_overload_APIClient();
			obj.sendRequest("Welcome");
			obj.sendRequest("Hi", "Have a Good Day!!!", true);

		}


}
