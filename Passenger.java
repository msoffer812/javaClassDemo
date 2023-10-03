package finalTermProject;

public class Passenger extends Person{
	private String passportID;
	private int luggagePieces;
	
	//Constructors
	public Passenger(String f, String l, Gender g, Address addr, String birthdate, String passportID, int luggage)
	{
		super(f, l, g, addr, birthdate);
		this.passportID = passportID;
		if(luggage<0)
		{
			throw new InvalidEntryException();
		}
		else
		{
			luggagePieces = luggage;
		}
	}
	//copy constructor
	public Passenger(Passenger p)
	{
		super(p);
		passportID = p.passportID;
		luggagePieces = p.luggagePieces;
	}
	public Passenger()
	{
		super();
		passportID = "";
		luggagePieces = 0;
	}
	
	//toString
	@Override
	public String toString()
	{
		StringBuilder line = new StringBuilder(super.toString());
		line.append("Passport ID: " + passportID);
		line.append("\n" + "Amount of Luggage Pieces: " + luggagePieces + "\n");
		return line.toString();
	}
	
	//equals method
	@Override
	public boolean equals(Object o)
	{ 	
		if(o instanceof Passenger)
		{
			Passenger p = (Passenger) o;
			if(passportID.equals(p.passportID))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
}
