package week3.InterfaceAssignment;

public abstract class Mysqlconnection implements Databaseconnection {
	public void excecutequery()
	{
    System.out.println("Query was Executed");
}
}