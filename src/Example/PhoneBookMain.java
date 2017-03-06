package Example;

public class PhoneBookMain {

	public static void main(String[] args) {
		PhoneBook book = new PhoneBook(
				"C:\\Users\\darko.ivanovski\\workspace\\ExampleTest\\bin\\Example\\infophonebook.txt");

		book.add("Mirjana", "+359878123457");
		book.add("Vasko", "+359878148975");
		book.add("Viktorija", "+359892123478");
		book.add("Boban", "0878123964");
		book.add("Mirjana", "00359885123249");

		book.delete("Nikola");

		System.out.println(book.find("Marjan"));
		System.out.println();

		book.viewContact();

		Registry registry = new Registry(book);
		registry.registerCall(new PhoneBookEntry("Boban", "Stanko"));
		registry.registerCall(new PhoneBookEntry("Boban", "Stanko"));
		registry.registerCall(new PhoneBookEntry("Damjan", "Milosh"));
		registry.registerCall(new PhoneBookEntry("Darko", "Nikola"));
		registry.registerCall(new PhoneBookEntry("Ljupcho", "Davor"));
		registry.registerCall(new PhoneBookEntry("Damjan", "Milosh"));
		registry.registerCall(new PhoneBookEntry("Darko", "Nikola"));
		registry.registerCall(new PhoneBookEntry("Boban", "Stanko"));
		registry.registerCall(new PhoneBookEntry("Mirjana", "Marko"));
		registry.registerCall(new PhoneBookEntry("Damjan", "Milosh"));
		registry.registerCall(new PhoneBookEntry("Boban", "Stanko"));

		System.out.println();

		registry.getMostCalled(5);
		registry.registerCall(new PhoneBookEntry("Boban", "Stanko"));
		registry.registerCall(new PhoneBookEntry("Boban", "Stanko"));
		registry.registerCall(new PhoneBookEntry("Darko", "Nikola"));
		registry.registerCall(new PhoneBookEntry("Darko", "Nikola"));

		System.out.println();
		registry.getMostCalled(3);

	}

}
