package finalTermProject;

//Custom exception for duplicate insertion of customers
public class PassengerExistsException extends RuntimeException{
	
	//constructors
	public PassengerExistsException()
	{
		super("Passenger already exists.");
	}
	public PassengerExistsException(String message)
	{
		super(message);
	}
	
}
