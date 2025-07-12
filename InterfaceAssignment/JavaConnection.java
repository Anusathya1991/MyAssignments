package week3.InterfaceAssignment;

public class JavaConnection implements Databaseconnection {

	@Override
	public void connect() {
		System.out.println("connected to database");
		}

	@Override
	public void disconnect() {
       System.out.println("Disconnected from database");		
		
	}

	@Override
	public void excuteupdate() {
		System.out.println("updatation was excecuted");
	}
	 public static void main(String[]arg)
	 {
		JavaConnection java=new JavaConnection();
	    java.connect();
	    java.disconnect();
	    java.excuteupdate();
	 }
}
