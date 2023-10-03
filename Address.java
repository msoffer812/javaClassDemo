package finalTermProject;

public class Address {
	private String street;
	private String city;
	private String state;
	private String zipcode;
	
	//constructor
	public Address(String street, String city, String state, String zip)
	{
		this.street = street;
		this.city = city;
		this.state = state;
		if(zip.length() == 5)
		{
			zipcode = zip;
		} else
		{
			throw new InvalidEntryException();
		}
		
	}
	public Address()
	{
		street = "";
		city = "";
		state = "";
		zipcode = "12345";
	}
	//getters
	public String getStreet()
	{
		return street;
	}
	public String getCity()
	{
		return city;
	}
	public String getState()
	{
		return state;
	}
	public String getZip()
	{
		return zipcode;
	}
	
	//Copy Constructor
	public Address(Address addr)
	{
		street = addr.street;
		city = addr.city;
		state = addr.state;
		zipcode = addr.zipcode;
	}
	
	//toString method
	@Override
	public String toString()
	{
		StringBuilder line = new StringBuilder(street + "\n");
		line.append(city + ", ");
		line.append(state + ", ");
		line.append(zipcode + "\n");
		return line.toString();
	}
}
