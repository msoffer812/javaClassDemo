package finalTermProject;
import java.time.*;
public class Person {
	private String firstName;
	private String lastName;
	private Gender gender;
	private LocalDate birthdate;
	private Address address;
	
	//constructors
	public Person()
	{
		firstName = "Nothing";
		lastName = "Nothing";
		gender = Gender.F;
		birthdate = LocalDate.of(2000, 1, 1);
		address = new Address();
	}
	
	public Person(String f, String l, Gender g, Address add, String birthdate)
	{
		firstName = f;
		lastName = l;
		gender = g;
		address = new Address(add);
		this.birthdate = LocalDate.parse(birthdate);
	}
	public Person(String f, String l, Gender g, String s, String c, String state, String zip, String birthdate)
	{
		firstName = f;
		lastName = l;
		gender = g;
		address = new Address(s , c, state, zip);
		this.birthdate = LocalDate.parse(birthdate);
	}
	public Person(String f, String l, Gender g, Address add, LocalDate birthdate)
	{
		firstName = f;
		lastName = l;
		gender = g;
		address = new Address(add);
		this.birthdate = LocalDate.parse(birthdate.toString());
	}
	
	//copy constructor
	public Person(Person p)
	{
		firstName = p.firstName;
		lastName = p.lastName;
		gender = p.gender;
		address = new Address(p.address);
		birthdate = LocalDate.parse(p.birthdate.toString());
	}
	
	
	//getters
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public Gender getGender()
	{
		return gender;
	}
	public LocalDate getBirthdate()
	{
		return LocalDate.parse(birthdate.toString());
	}
	public Address getAddress()
	{
		return new Address(address);
	}
	
	//setters
	public void setLastName(String last)
	{
		lastName = last;
	}
	public void setAddress(Address addr)
	{
		address = new Address(addr);
	}
	
	//toString
	@Override
	public String toString()
	{
		StringBuilder line = new StringBuilder("First Name: " + firstName);
		line.append("\n" + "Last Name: " + lastName);
		line.append("\n" + "Gender: " + gender);
		line.append("\n" + "Address: " + address.toString());
		line.append("\n" + "Date of Birth: " + birthdate + "\n");
		return line.toString();
	}
	
	//equal
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Person)
		{
			Person p = (Person) o;
				if(firstName.equals(p.firstName) && lastName.equals(p.lastName) && birthdate.equals(p.birthdate))
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
