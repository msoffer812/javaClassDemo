package finalTermProject;

public class Test {
	public static void main(String[] args)
	{
		Address addr = new Address("812 Jarvis Avenue", "Far Rockaway", "NY", "11691");
		Address hi = new Address("812 Ja", "Rockaway", "Y", "111");
		Person p = new Person("hi", "boss", Gender.F, addr, "2003-01-01");
		Object o = new Person("hi", "dfja", Gender.F, addr, "2003-01-01");
		System.out.println(p.equals(o));
	}
	
}
