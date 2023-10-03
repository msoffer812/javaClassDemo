package finalTermProject;

public class OutOfSpaceException extends RuntimeException{
	//constructors
	public OutOfSpaceException()
	{
		super("Out of space, cannot add");
	}
	//can personalize message
	public OutOfSpaceException(String message)
	{
		super(message);
	}
}
