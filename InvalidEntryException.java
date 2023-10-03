package finalTermProject;

public class InvalidEntryException extends RuntimeException{
	public InvalidEntryException()
	{
		super("Invalid entry");
	}
	public InvalidEntryException(String m)
	{
		super(m);
	}
}
