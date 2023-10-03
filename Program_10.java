package finalTermProject;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.io.*;

public class Program_10 {
	public static void main(String[] args)
	{
		Ship ship;
		FishingBoat boat;
		CruiseShip cShip;
		Person person;
		Passenger passenger;
		Address address;
		int option1,option2,option3,option4;
		ArrayList<Ship> ships = new ArrayList<>();
		ArrayList<CruiseShip> cruiseShips = new ArrayList<>();
		ArrayList<FishingBoat> fishingBoats = new ArrayList<>();
		ArrayList<Person> people = new ArrayList<>();
		ArrayList<Passenger> passengers = new ArrayList<>();
		ArrayList<Address> addresses = new ArrayList<>();
		
		option2 = 0;
		option3 = 0;
		option4 = 1;
		
		displayMainMenu(7);
		option1 = menuInputValidation(7);
		
		 while (option1 != 7)
		 {
			displayMainMenu(2);
			option2 = menuInputValidation(3);
			
			switch(option1)
			{
			case 1:
				switch(option2)
				{
				case 1:
					do 
					{
						ship = findShip(ships);
						displayMainMenu(3);
						option3 = menuInputValidation(3);
						if (option3 == 1)
						{
							editShip(ship);
							displayMainMenu(4);
							option4 = menuInputValidation(2);
						}
					} while(option4 == 1 && option3 != 3);
					break;
				case 2:
					do 
					{
						ship = createShip(ships);
						displayMainMenu(6);
						option4 = menuInputValidation(2);
					}while(option4 == 1);
					break;
				case 3:
					displayShips(ships);
					break;
				}
				break;
			case 2:
				switch(option2)
				{
				case 1:
					option4 =1;
					option3 = 2;
					while(option4 == 1 && option3 != 3)
					{
						boat = findFishingBoat(fishingBoats);
						displayMainMenu(3);
						option3 = menuInputValidation(3);
						if (option3 == 1)
						{
							editFishingBoat(boat);
							displayMainMenu(4);
							option4 = menuInputValidation(2);
						}
					} 
					break;
				case 2:
					do 
					{
						boat = createFishingBoat(fishingBoats);
						displayMainMenu(6);
						option4 = menuInputValidation(2);
					}while(option4 == 1);
					break;
				case 3:
					displayFishingBoats(fishingBoats);
					break;	
				}
				break;
			case 3:
				switch(option2)
				{
				case 1:
					option4 =1;
					option3 = 2;
					while(option4 == 1 && option3 != 3)
					{
						cShip = findCruiseShip(cruiseShips);
						displayMainMenu(3);
						option3 = menuInputValidation(3);
						if (option3 == 1)
						{
							editCruiseShip(cShip, passengers, people, addresses);
							displayMainMenu(4);
							option4 = menuInputValidation(2);
						}
					}
					break;
				case 2:
					option4 = 1;
					while(option4 == 1)
					{
						cShip = createCruiseShip(cruiseShips);
						displayMainMenu(6);
						option4 = menuInputValidation(2);
					}
					break;
				case 3:
					displayCruiseShips(cruiseShips);
					break;	
				}
				break;
			case 4:
				switch(option2)
				{
				case 1:
					option4 =1;
					option3 = 2;
					while(option4 == 1 && option3 != 3)
					{
						passenger = findPassenger(passengers, people, addresses);
						displayMainMenu(3);
						option3 = menuInputValidation(8);
						if (option3 == 1)
						{
							duplicatePassenger(passenger);
							displayMainMenu(4);
							option4 = menuInputValidation(2);
						}
					} 
					break;
				case 2:
					do 
					{
						passenger = createPassenger(people, addresses, passengers);
						displayMainMenu(6);
						option4 = menuInputValidation(2);
					}while(option4 == 1);
					break;
				case 3:
					displayPassengers(passengers);
					break;
				}
				break;
			case 5:
				switch(option2)
				{
				case 1:
					option4 =1;
					option3 = 2;
					while(option4 == 1 && option3 != 3)
					{
						person = findPerson(people, addresses);
						displayMainMenu(3);
						option3 = menuInputValidation(3);
						if (option3 == 1)
						{
							editPerson(person, addresses);
							displayMainMenu(4);
							option4 = menuInputValidation(2);
						}
					} 
					break;
				case 2:
					do 
					{
						person = createPerson(people, addresses);
						displayMainMenu(6);
						option4 = menuInputValidation(2);
					}while(option4 == 1);
					break;
				case 3:
					displayPeople(people);
					break;
				}
				break;
			case 6:
				switch(option2)
				{
				case 1:
					option4 =1;
					option3 = 2;
					while(option4 == 1 && option3 != 3)
					{
						address = findAddress(addresses);
						displayMainMenu(3);
						option3 = menuInputValidation(8);
						if (option3 == 1)
						{
							duplicateAddress(address);
							displayMainMenu(4);
							option4 = menuInputValidation(2);
						}
					} 
					break;
				case 2:
					do 
					{
						address = createAddress(addresses);
						displayMainMenu(6);
						option4 = menuInputValidation(2);
					}while(option4 == 1);
					break;
				case 3:
					displayAddresses(addresses);
					break;
				}
			    break;	
			}
			displayMainMenu(7);
			option1 = menuInputValidation(7);
			
		}
		
		System.out.println("Goodbye!");
		System.exit(0);
	}
	
	//option receiver and returner
	public static int intInput()
	{
		Scanner in;
		int num = 0;
		int i = 0;
		while (i == 0 || num < 0)
		{
			try
			{
				in = new Scanner(System.in);
				num = in.nextInt();
				if(num < 0)
				{
					System.out.println("Invalid input, please reenter");
				}	
				i=1;
			} catch (InputMismatchException e)
			{
				System.out.println("Invalid input, please reenter");
				i = 0;
			}
		}
		return num;
	}
	public static double doubleInput()
	{
		Scanner in;
		double num = 0.0;
		int i = 0;
		while (i == 0 || num < 0)
		{
			try
			{
				in = new Scanner(System.in);
				num = in.nextDouble();
				if(num < 0)
				{
					System.out.println("Invalid input, please reenter");
				}	
				i=1;
			} catch (InputMismatchException e)
			{
				System.out.println("Invalid input, please reenter");
				i = 0;
			}
		}
		return num;
	}
	public static int menuInputValidation(int option)
	{
		int answer = intInput();
		while (answer > option)
		{
			System.out.println("Invalid selection, please reenter");
			answer = intInput();	
		}
		return answer;
	}
	public static String stringInput()
	{
		String word ="";
		Scanner in;
		do
		{
			in = new Scanner(System.in);
			word = in.nextLine();
			if(word.length()<1)
			{
				System.out.println("Invalid input. Please reenter");
			}
		}
		while (word.length()<1);
		return word;
	}
	public static Gender genderInput()
	{
		int input;
		Gender g = Gender.F;
		
		personMenu("gender");
		input = menuInputValidation(2);
			
		if(input == 1)
		{
			g = Gender.M;
		}
		return g;
	}
	public static LocalDate dateInput()
	{
		String input="";
		boolean check = false;
		LocalDate birthdate=LocalDate.now();
		while (check == false)
		{
			try
			{
				check = true;
				personMenu("birthdate");
				input = stringInput();
				birthdate = LocalDate.parse(input);
			}
			catch(DateTimeParseException e)
			{
				System.out.println("Invalid format, please reenter: ");
				check = false;
			}
		}
		return birthdate;
	}
	public static int inputYearValidation()
	{
		int yr = 0;
		int i = 0;
		while(i == 0)
		{
			try
			{
				yr = intInput();
				i = 1;
			} catch(InvalidEntryException e)
			{
				System.out.println("Invalid input, please reenter");
				i=0;
				
			}	
		}
		
		return yr;
	}
	
	//Displays the menus
	public static void displayMainMenu(int option)
	{
		String str="";
		switch (option)
		{
		case 1:
			str = "\n" + "Pick an option:" + "\n" + "1.Stam Ship"+"\n" + "2.Fishing Boat" + "\n" + "3.Cruise Ship" + "\n" + "4.Passenger" + "\n" + "5.Person" + "\n" + "6.Address";
			break;
		case 2:
			str = "\n" + "Pick an option:\n1.Look up\n2.Create new\n3.Print all";
			break;
		case 3:
			str = "\n" + "1.Edit" + "\n" + "2.Look up another" + "\n" + "3.Exit";
			break;
		case 4:
			str = "\n" + "Would you like to look up anything else?" + "\n" + "1.Yes\n2.No";
			break;
		case 5:	
			str = "\n" + "Would you like to edit anything else?" + "\n" + "1.Yes\n2.No";
			break;
		case 6:
			str = "\n" + "1.Create another" + "\n" + "2.Exit";
			break;
		case 7:
			str = "\n" + "Pick an option:" + "\n" + "1.Stam Ship"+"\n" + "2.Fishing Boat" + "\n" + "3.Cruise Ship" + "\n" + "4.Passenger" + "\n" + "5.Person" + "\n" + "6.Address" + "\n" + "7.Exit";
			break;	
		case 8:
			str = "\n" + "1.Print a duplicate" + "\n" + "2.Look up another" + "\n" + "3.Exit";
			break;	
		default:
			str = "You made a mistake in the menu selection code";
		}
		
		System.out.println(str);
	}
	public static void shipMenu(String option)
	{
		String str = "";
		switch (option)
		{
		case "name":
			str = "\n" + "Enter the ship's name:";
			break;
		case "year":
			str ="\n" + "Enter the year built";
			break;
		case "genMenu":
			str = "\n" + "Pick an option:" + "\n" + "1.Change name" + "\n" + "2.Change Year Built" + "\n" + "3.Print a duplicate ship" + "\n" + "4.Exit";
			break;
		default:
			str = "You made a mistake in the menu selection code";	
		}
		System.out.println(str);
			
	}
	public static void cruiseShipMenu(String option)
	{
		String str="";
		switch(option)
		{
		case "genMenu":
			str = "\n" + "1.Change maximum amount of passengers" +"\n"+"2.Add passenger" + "\n" + "3.Print a duplicate ship" + "\n" + "4.Exit";
			break;
		case "name":
			str = "\n" + "Enter name:";
			break;
		case "year":
			str = "\n" + "Enter year";
			break;
		case "maxpass":
			str = "\n" + "Enter maximum amount of passengers";
			break;
		case "addPassMenu":
			str = "\n" + "Pick an option:\n1.Add previously created passenger\n2.Create new passenger to add";
			break;
		default:
			str = "You made a mistake in the menu selection code";	
		}
		System.out.println(str);
	}
	public static void fishingBoatMenu(String option)
	{
		String str="";
		switch(option)
		{
		case "genMenu":
			str = "\n" + "Pick an option:" + "\n" + "1.Change rental price" + "\n" + "2.Print a duplicate fishing boat" + "\n" + "3.Exit";
			break;
		case "name":
			str = "\n" + "Enter fishing boat's name:";
			break;
		case "year":
			str = "\n" + "Enter year built:";
			break;
		case "price":
			str = "\n" + "Enter rental price";
			break;	
		default:
			str = "You made a mistake in the menu selection code";	
		}
		System.out.println(str);
	}
	public static void personMenu(String option)
	{
		String str = "";
		switch(option)
		{
		case "genMenu":
			str = "\n" + "Pick an option:" + "\n" + "1.Change last name"+"\n" + "2.Change address"  + "\n" + "3.Print a duplicate person" + "\n" + "4.Exit";
			break;
		case "gender":
			str = "\n" + "Enter person's gender:" + "\n" + "1. Male" + "\n" + "2.Female";
			break;
		case "firstName":
			str = "\n" + "Enter person's first name:";
			break;
		case "lastName":
			str = "\n" + "Enter person's last name:";
			break;
		case "birthdate":
			str = "\n" + "Enter person's birthdate in the format 'yyyy-mm-dd':";
			break;
		case "address":
			str = "\n" + "Pick an option:\n1.Add previously created address\n2.Create new address to add";
			break;
		default:
			str = "You made a mistake in the menu selection code";	
		}
		System.out.println(str);	
		}
	public static void passengerMenu(String option)
	{
		String str = "";
		switch(option)
		{
		case "genMenu":
			str = "\n" + "1.Duplicate" + "\n" + "2.Exit";
			break;
		case "passportID":
			str = "\n" + "Enter passport ID:";
			break;
		case "luggageAmount":
			str = "\n" + "Amount of pieces of luggage:";
			break;
		default:
			str = "You made a mistake in the menu selection code";	
		}
		System.out.println(str);
	}
	public static void addressMenu(String option)
	{
		String str = "";
		switch(option)
		{
		case "street":
			str = "\n" + "Enter street:";
			break;
		case "city":
			str = "\n" + "Enter city:";
			break;
		case "state":
			str = "\n" + "Enter state:";
			break;
		case "zip":
			str = "\n" + "Enter zipcode:";
			break;	
		default:
			str = "You made a mistake in the menu selection code";	
		}
		System.out.println(str);
	}
	
	//prints out arraylists
	public static void displayShips(ArrayList<Ship> o)
	{
		System.out.println("Ships:\n");
		for(int i = 0; i<o.size(); i++)
		{
			System.out.println("Ship " + (i+1) + ":");
			System.out.println(o.get(i).toString());
			System.out.println("\n");
		}
	}
	public static void displayCruiseShips(ArrayList<CruiseShip> o)
	{
		System.out.println("Cruise Ships:\n");
		for(int i = 0; i<o.size(); i++)
		{
			System.out.println("Cruise Ship " + (i+1) + ":");
			System.out.println(o.get(i).toString());
			System.out.println("\n");
		}
	}
	public static void displayFishingBoats(ArrayList<FishingBoat> o)
	{
		System.out.println("Fishing Boats:\n");
		for(int i = 0; i<o.size(); i++)
		{
			System.out.println("Boat " + (i+1) + ":");
			System.out.println(o.get(i).toString());
			System.out.println("\n");
		}
	}
	public static void displayPeople(ArrayList<Person> o)
	{
		System.out.println("People:\n");
		for(int i = 0; i<o.size(); i++)
		{
			System.out.println("Person " + (i+1) + ":");
			System.out.println(o.get(i).toString());
			System.out.println("\n");
		}
	}
	public static void displayPassengers(ArrayList<Passenger> o)
	{
		System.out.println("Passengers:\n");
		for(int i = 0; i<o.size(); i++)
		{
			System.out.println("Passenger " + (i+1) + ":");
			System.out.println(o.get(i).toString());
			System.out.println("\n");
		}
	}
	public static void displayAddresses(ArrayList<Address> o)
	{
		System.out.println("Addresses:\n");
		for(int i = 0; i<o.size(); i++)
		{
			System.out.println("Address " + (i+1) + ":");
			System.out.println(o.get(i).toString());
			System.out.println("\n");
		}
	}
	
	
	//Creating the objects and adding them to an arrayList
	public static Ship createShip(ArrayList<Ship> ships)
	{
		Ship s = new Ship();
		int i = 0;
		cruiseShipMenu("name");
		String n = stringInput();
		
		cruiseShipMenu("year");
		int yr = inputYearValidation();
		while (i == 0)
		{
			try 
			{
			s = new Ship(n, yr);
			i=1;
			}catch(InvalidEntryException e)
			{
				System.out.println("Invalid year, please reenter: ");
				yr = inputYearValidation();
				i=0;
			}	
		}
		ships.add(s);
		System.out.println(s.toString());
		return s;
	}
	
	public static CruiseShip createCruiseShip(ArrayList<CruiseShip> cruiseShips)
	{
		int yr;
		int i = 0;
		CruiseShip s = new CruiseShip();
		cruiseShipMenu("name");
		String n = stringInput();
		
		cruiseShipMenu("maxpass");
		int max = intInput();
		
		cruiseShipMenu("year");
		yr = inputYearValidation();
		
		while (i == 0)
		{
			try 
			{
				s = new CruiseShip(n, yr, max);	
				i=1;
			}catch(InvalidEntryException e)
			{
				System.out.println("Invalid year, please reenter: ");
				yr = inputYearValidation();
				i=0;
			}	
		}
		
		cruiseShips.add(s);
		System.out.println(s.toString());
		
		return s;
	}
	public static FishingBoat createFishingBoat(ArrayList<FishingBoat> fishingBoats)
	{
		int yr=0;
		FishingBoat b = new FishingBoat();
		int i =0;
		double price;
		fishingBoatMenu("name");
		String n = stringInput();
		
		fishingBoatMenu("price");
		price = doubleInput();
		
		fishingBoatMenu("year");
		yr = inputYearValidation();
		
		while (i == 0)
		{
			try 
			{
				b = new FishingBoat(n, yr, price);
				i=1;
			}catch(InvalidEntryException e)
			{
				System.out.println("Invalid year, please reenter: ");
				yr = inputYearValidation();
				i=0;
			}	
		}
		
		System.out.println(b.toString());
		fishingBoats.add(b);
		
		return b;
	}
	public static Address createAddress(ArrayList<Address> addresses)
	{
		String street;
		String city;
		String state;
		String zipcode="00000";
		Address addr = new Address();
		int a=0;
		
		addressMenu("street");
		street = stringInput();
		
		addressMenu("city");
		city = stringInput();
		
		addressMenu("state");
		state = stringInput();
		
		addressMenu("zip");
		while(a == 0)
		{
			try
			{
				zipcode = stringInput();
				addr = new Address(street, city, state, zipcode);
				a=1;
			}catch(InvalidEntryException e)
			{
				System.out.println("Invalid input, please reenter zipcode: ");
				a=0;
			}
		}
		System.out.println(addr.toString());
		
		addresses.add(addr);
		return addr;
	}
	public static Person createPerson(ArrayList<Person> people, ArrayList<Address> addresses)
	{
		String firstName;
		String lastName;
		Gender g;
		Address addr = new Address();
		LocalDate birthdate;
		Person p;
		int input;
		
		personMenu("firstName");
		firstName = stringInput();
		
		personMenu("lastName");
		lastName = stringInput();
		
		g = genderInput();
		
		personMenu("address");
		input = menuInputValidation(2);	
		switch(input)
		{
		case 1:
			addr = findAddress(addresses);
			break;
		case 2:
			addr = createAddress(addresses);
			break;
		}
		
		birthdate = dateInput();
		
		p = new Person(firstName, lastName, g, addr, birthdate);
		people.add(p);
		
		return p;
	}
	public static Passenger createPassenger(ArrayList<Person> people, ArrayList<Address> addresses, ArrayList<Passenger> passengers)
	{
		int amount;
		String id;
		Passenger passenger;
		Person person = createPerson(people, addresses);
		
		passengerMenu("passportID");
		id = stringInput();
		
		passengerMenu("luggageAmount");
		amount = intInput();
		
		passenger = new Passenger(person.getFirstName(), person.getLastName(), person.getGender(), person.getAddress(), person.getBirthdate().toString(), id, amount);
		System.out.println(passenger.toString());
		for(int i=0; i<passengers.size(); i++)
		{
			if(passengers.get(i).equals(passenger))
			{
				System.out.println("Passenger already exists, invalid ID. Will delete Object.");
				passenger = null;
			}
		}
		if(passenger != null)
		{
			passengers.add(passenger);
		}
		return passenger;
	}
	
	
	//finds and returns a specific classes
	public static Ship findShip (ArrayList<Ship> ships)
	{
		String input;
		int i, answer;
		Ship ship = new Ship();
		shipMenu("name");
		input = stringInput();
		
		
		for(i=0;i<ships.size();i++)
		{
			if(ships.get(i).getName().toLowerCase().equals(input.toLowerCase()))
			{
				System.out.println(ships.get(i).toString());
				System.out.println("Is this the correct ship? Select:" + "\n" + "1.Yes" + "\n" + "2.No");
				answer = menuInputValidation(2);
				if(answer == 1)
				{
					ship = ships.get(i);
					return ship;
				}
			}
		}
		System.out.println("Ship does not exist; Please create new.");
		ship = createShip(ships);
		return ship;
	}
	public static CruiseShip findCruiseShip (ArrayList<CruiseShip> ships)
	{
		String input;
		int i, answer;
		CruiseShip ship = new CruiseShip();
		shipMenu("name");
		input = stringInput();
		
		for(i=0;i<ships.size();i++)
		{
			if(ships.get(i).getName().toLowerCase().equals(input.toLowerCase()))
			{
				System.out.println(ships.get(i).toString());
				System.out.println("Is this the correct cruise ship? Select:" + "\n" + "1.Yes" + "\n" + "2.No");
				answer = menuInputValidation(2);
				if(answer == 1)
				{
					ship = ships.get(i);
					return ship;
				}
			}
		}
		System.out.println("Ship does not exist; Please create new.");
		ship = createCruiseShip(ships);
		return ship;
	}
	public static FishingBoat findFishingBoat (ArrayList<FishingBoat> boats)
	{
		String input;
		int i, answer;
		FishingBoat b = new FishingBoat();
		fishingBoatMenu("name");
		input = stringInput();
		
		for(i=0;i<boats.size();i++)
		{
			if(boats.get(i).getName().toLowerCase().equals(input.toLowerCase()))
			{
				System.out.println(boats.get(i).toString());
				System.out.println("Is this the correct fishing boat? Select:" + "\n" + "1.Yes" + "\n" + "2.No");
				answer = menuInputValidation(2);
				if(answer == 1)
				{
					b = boats.get(i);
					return b;
				}
			}
		}
		System.out.println("Boat does not exist; Please create new.");
		b = createFishingBoat(boats);
		return b;
	}
	public static Address findAddress(ArrayList<Address> addresses)
	{
		String input;
		int i, answer;
		Address addr = new Address();
		
		addressMenu("street");
		input = stringInput();
		
		for(i=0;i<addresses.size();i++)
		{
			if(addresses.get(i).getStreet().toLowerCase().equals(input.toLowerCase()))
			{
				System.out.println(addresses.get(i).toString());
				System.out.println("Is this the correct address? Select:" + "\n" + "1.Yes" + "\n" + "2.No");
				answer = menuInputValidation(2);
				if(answer == 1)
				{
					addr = addresses.get(i);
					return addr;
				}
			}
		}
		System.out.println("Address does not exist; Please create new.");
		addr = createAddress(addresses);
		return addr;
	}
	public static Person findPerson(ArrayList<Person> people, ArrayList<Address> addresses)
	{
		String input;
		int i, answer;
		Person person = new Person();
		
		personMenu("firstName");
		input = stringInput();
		
		for(i=0;i<people.size();i++)
		{
			if(people.get(i).getFirstName().toLowerCase().equals(input.toLowerCase()))
			{
				System.out.println(people.get(i).toString());
				System.out.println("Is this the correct person? Select:" + "\n" + "1.Yes" + "\n" + "2.No");
				answer = menuInputValidation(2);
				if(answer == 1)
				{
					person = people.get(i);
					return person;
				}
			}
		}
		System.out.println("Person does not exist; Please create new.");
		person = createPerson(people, addresses);
		return person;
	}
	public static Passenger findPassenger(ArrayList<Passenger> passengers, ArrayList<Person> people, ArrayList<Address>addresses)
	{
		int i, answer, luggage=0;
		String f="", l="", input; 
		Gender g = Gender.F; 
		Address addr= new Address(); 
		String birthdate="2002-01-01"; 
		Passenger p = new Passenger();
		 
		passengerMenu("passportID");
		input = stringInput();
		p = new Passenger(f,l,g,addr,birthdate,input,luggage);
		
		for(i=0;i<passengers.size();i++)
		{
			if(passengers.get(i).equals(p))
			{
				System.out.println(passengers.get(i).toString());
				System.out.println("Is this the correct passenger? Select:" + "\n" + "1.Yes" + "\n" + "2.No");
				answer = menuInputValidation(2);
				if(answer == 1)
				{
					return passengers.get(i);
				}
			
			}
		}
	
		System.out.println("Passenger does not exist; Please create new.");
		p = createPassenger(people, addresses, passengers);
		return p;
	}
	
	//Editor methods
	public static void duplicateAddress(Address addr)
	{
		Address a = new Address(addr);
		System.out.println("Duplicated. New Address:");
		System.out.println(a.toString());
	}
	public static void editShip(Ship s)
	{
		int input=1, yr=0;
		String answer;
		Ship newShip = new Ship();
		
		shipMenu("genMenu");
		input = menuInputValidation(4);
		while (input != 4)
		{
			switch (input)
			{
			case 1:
				shipMenu("name");
				answer = stringInput();
				s.setName(answer);
				System.out.println("Changed!");
				break;
			case 2:
				shipMenu("year");
				yr = inputYearValidation();
				s.setYear(yr);
				System.out.println("Changed!");
				break;
			case 3:
				newShip = new Ship(s);
				System.out.println("Duplicated! New ship:");
				System.out.println(newShip.toString());
				break;
			}
			shipMenu("genMenu");
			input = menuInputValidation(4);
		}
	}
	public static void editCruiseShip(CruiseShip s, ArrayList<Passenger> passengers, ArrayList<Person> people, ArrayList<Address>addresses)
	{
		int input=1, ans=0;
		Passenger p = new Passenger();
		CruiseShip newShip = new CruiseShip();
		
		cruiseShipMenu("genMenu");
		input = menuInputValidation(4);
		
		while(input != 4)
		{
			switch (input)
			{
			case 1:
				cruiseShipMenu("maxpass");
				input = intInput();
				s.setMaximumPassenger(input);
				System.out.println("Changed!");
				break;
			case 2:
				int i = 0;
				if (s.getPassengerList().size()< s.getMaximumPassenger())
				{
					while (i == 0)
					{
						i = 1;
						cruiseShipMenu("addPassMenu");
						ans = menuInputValidation(2);
						switch (ans)
						{
						case 1:
							p = findPassenger(passengers, people, addresses);
							break;
						case 2:
							p = createPassenger(people, addresses, passengers);
							break;
						}
						try
						{
							s.addPassenger(p);
						} catch(PassengerExistsException e)
						{
							System.out.println("Passenger already exists. Please try another:");
							i = 0;
						}
					}
					System.out.println("Added!");
				}
				else
				{
					System.out.println("Cannot add, maximum amount of passengers already added");
				}
				break;
			case 3:
				newShip = new CruiseShip(s);
				System.out.println("Duplicated! New cruise ship:");
				System.out.println(newShip.toString());
				break;
			}
			cruiseShipMenu("genMenu");
			input = menuInputValidation(4);
		}
	}
	public static void editFishingBoat(FishingBoat b)
	{
		int ans = 0;
		double answer;
		FishingBoat boat = new FishingBoat();
		
		fishingBoatMenu("genMenu");
		ans = menuInputValidation(3);
		
		while(ans != 3)
		{
			switch(ans)
			{
			case 1:
				fishingBoatMenu("price");
				answer = doubleInput();
				b.setRentalPrice(answer);
				System.out.println("Changed!");
				break;
			case 2:
				boat = new FishingBoat(b);
				System.out.println("Duplicated! New Fishing Boat:");
				System.out.println(boat.toString());
				break;
			}
			fishingBoatMenu("genMenu");
			ans = menuInputValidation(3);
		}
	}
	public static void editPerson(Person p, ArrayList<Address> addresses)
	{
		Person newPerson = new Person();
		int ans = 0, choice = 0;; 
		String input = "";
		Address addr = new Address();
		
		personMenu("genMenu");
		ans = menuInputValidation(4);
		
		while(ans != 4)
		{
			switch(ans)
			{
			case 1:
				personMenu("lastName");
				input = stringInput();
				p.setLastName(input);
				System.out.println("Changed!");
				break;
			case 2:
				personMenu("address");
				choice = menuInputValidation(2);
				switch (choice)
				{
				case 1:
					addr = findAddress(addresses);
					break;
				case 2:
					addr = createAddress(addresses);
					break;
				}
				p.setAddress(addr);
				System.out.println("Changed!");
				break;
			case 3:
				newPerson = new Person(p);
				System.out.println("Duplicated! New Person:");
				System.out.println(newPerson.toString());
				break;
			}	
			personMenu("genMenu");
			ans = menuInputValidation(4);
		}
				
	}
	public static void duplicatePassenger(Passenger p)
	{
		int option;
		passengerMenu("genMenu");
		option = menuInputValidation(2);
		while(option != 2)
		{
			Passenger newPass = new Passenger(p);
			System.out.println("Duplicated. New passenger:");
			System.out.println(newPass.toString());
			passengerMenu("genMenu");
			option = menuInputValidation(2);
		}
	}
}
