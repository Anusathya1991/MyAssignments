package alert.setassignment;

public class Overridding_Subclass_LoginPage extends Overridding_Basepage
{
	public void  performCommonTasks()
    {
    //System.out.println("perform commontask from----->Baseclass");	
    System.out.println("perform comman task override from baseclass via subclass");
    }
	public static void main(String[] args)
	{
		Overridding_Subclass_LoginPage obj=new Overridding_Subclass_LoginPage();
		obj.performCommonTasks();
		obj.findElement();
		obj.enterText();
		obj.clickElement();
	}
}