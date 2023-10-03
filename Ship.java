package finalTermProject;
import java.time.LocalDate;

public class Ship{
	private String name;
	private int year;
	
	//Constructors
	public Ship()
	{
		name = "No name";
		year = 0;
	}
	public Ship(String nm, int yr)
	{
		name = nm;
		if(yr<0 || yr> LocalDate.now().getYear())
		{
			throw new InvalidEntryException();
		}
		else
		{
			year = yr;
		}
		
	}
	//Copy Constructor
	public Ship(Ship s)
	{
		name = s.name;
		year = s.year;
	}
	
	//Setters
	public void setName(String nm)
	{
		name = nm;
	}
	public void setYear(int yr)
	{
		if(yr<1000 || yr> LocalDate.now().getYear())
		{
			throw new InvalidEntryException();
		}
		else
		{
			year = yr;
		}
	}
	
	//Getters
	public String getName()
	{
		return name;
	}
	public int getYear()
	{
		return year;
	}
	
	//toString method
	@Override
	public String toString()
	{
		StringBuilder line = new StringBuilder("Name: " + name);
		line.append("\n" +"Year Built: " + year);
		return line.toString();
	}
	
}
