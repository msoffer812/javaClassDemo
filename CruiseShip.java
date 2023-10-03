package finalTermProject;
import java.util.ArrayList;

public class CruiseShip extends Ship{
	private int maxPass;
	private ArrayList<Passenger> passengers;
	
	//Constructors
	public CruiseShip()
	{
		super();
		maxPass = 0;
		passengers = new ArrayList<Passenger>();
	}
	public CruiseShip(int m)
	{
		super();
		if(m<0)
		{
			throw new InvalidEntryException();
		}
		else
		{
			maxPass = m;	
		}
		passengers = new ArrayList<Passenger>();
	}
	public CruiseShip(String nm, int yr, int m)
	{
		super(nm, yr);
		if(m<0)
		{
			throw new InvalidEntryException();
		}
		else
		{
			maxPass = m;	
		}
		passengers = new ArrayList<Passenger>();
	}
	//Copy Constructor
	public CruiseShip(CruiseShip s)
	{
		super(s);
		maxPass = s.maxPass;
		passengers = copyPassengers(s.passengers);
	}
		
	//Setter
	public void setMaximumPassenger(int m)
	{
		if(m<0)
		{
			throw new InvalidEntryException();
		}
		else
		{
			maxPass = m;	
		}
	}
	
	//Getters
	public int getMaximumPassenger()
	{
		return maxPass;
	}
	public ArrayList<Passenger> getPassengerList()
	{
		ArrayList<Passenger> p = copyPassengers(this.passengers); 
		return p;
	}
	
	//Deep Copying the passenger arraylist
	public ArrayList<Passenger> copyPassengers(ArrayList<Passenger> a)
	{
		ArrayList<Passenger> p = new ArrayList<Passenger>();
		for (int i=0; i<passengers.size(); i++)
		{
			Passenger z = new Passenger(passengers.get(i));
			p.add(z);
		}
		return p;
	}
	
	//toString method
	@Override
	public String toString()
	{
		StringBuilder line = new StringBuilder(super.toString());
		line.append("\n" + "Maximum Amount of Passengers: " + maxPass);
		line.append("\n" + "Passengers: " + passengers + "\n");
		return line.toString();
	}
	
	//adding passenger method
	public void addPassenger(Passenger p)
	{
		if (passengers.contains(p))
		{
			throw new PassengerExistsException();
		}
		else if(passengers.size() >= maxPass)
		{
			throw new OutOfSpaceException();
		}
		else
		{
			passengers.add(p);
		}
	}
		
	
}
