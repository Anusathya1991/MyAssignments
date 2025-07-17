package week3.InheritanceAssignment2;

public class Excecution extends Buttonsubclass1
{
	public static void main(String[] args)
	{
		//object for subclass1
		Buttonsubclass1 button=new Buttonsubclass1();
		button.click();
		button.submit();
		
		//object for subclass2
		TextfieldSubclass2 text= new TextfieldSubclass2();
		text.setText("Welcome from Textfield Subclass2");
		text.click();
		System.out.println(text.getText());
		
		//object for additional subclass1
		
		checkboxButton check = new checkboxButton();
		check.click();
		check.clickCheckButton();
		check.submit();
		
		//object for additional subclass2
		RadioButton radio = new RadioButton();
		radio.click();
		radio.selectRadioButton();
		radio.submit();
		radio.setText("have a good day ---> Additional subclass2");
		
		//object for superclass
		Execution exe=new Execution();
		exe.click();
                exe.submit();	
		
		
	}
}
