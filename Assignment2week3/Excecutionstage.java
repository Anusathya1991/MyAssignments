package week3.Assignment2week3;

public class Excecutionstage {
	public static void main(String[] args) 
	{
        // Create an object of superclass
        Testdatasuperclass td = new Testdatasuperclass();
        td.enterCredentials();
        td.navigateToHomePage();
        
        // Create an object of subclass
        Logindata ld = new Logindata();
        ld.enterCredentials();       // from TestData_superclass
        ld.navigateToHomePage();     // from TestData_superclass
        ld.enterUsername();          // in Logindata_subclass
        ld.enterPassword();          // in Logindata_subclass
        }
	

}
