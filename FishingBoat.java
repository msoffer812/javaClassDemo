package finalTermProject;

public class FishingBoat extends Ship{
	private double rentalPrice;
	
	//Constructors
	public FishingBoat()
	{
		super();
		rentalPrice = 0.0;
	}
	public FishingBoat(double p)
	{
		super();
		if(p<0)
		{
			throw new InvalidEntryException();
		}
		else
		{
			rentalPrice = p;
		}
	}
	public FishingBoat(String nm, int yr, double p)
	{
		super(nm, yr);
		if(p<0)
		{
			throw new InvalidEntryException();
		}
		else
		{
			rentalPrice = p;
		}
	}
	//Copy Constructor
	public FishingBoat(FishingBoat f)
	{
		super(f);
		this.rentalPrice = f.rentalPrice;
	}
	
	//Setter
	public void setRentalPrice(double p)
	{
		if(p<0)
		{
			throw new InvalidEntryException();
		}
		else
		{
			rentalPrice = p;
		}
	}
	//Getter
	public double getRentalPrice()
	{
		return rentalPrice;
	}
	
	@Override
	public String toString()
	{
		String r = String.format("Rental Price: $ %,.2f", rentalPrice);
		String str = super.toString(); 
		StringBuilder line = new StringBuilder(str);
		line.append("\n" + r);
		return line.toString();
	}
}
