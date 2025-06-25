package week1.day2;

public class Browser {
    public String launchbrowser(String Browsername) {
    	System.out.println("Browser loaded successfully");
    	return Browsername;
    }
    void loadUrl() {
    	System.out.println("Application loaded successfully");
    }
	public static void main(String[] args) {
		Browser Bro = new Browser();
		System.out.println(Bro.launchbrowser("Chrome"));
		Bro.loadUrl();

	}

}
