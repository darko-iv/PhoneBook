package Example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {

	public PhoneBook(String path) {

		String line;
		BufferedReader in;

		try {
			in = new BufferedReader(new FileReader(path));
			line = in.readLine();
			while (line != null) {

				String[] data = line.split(",");
				if (isValidNumber(data[1])) {

					table.put(data[0], data[1]);

				}
				line = in.readLine();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PhoneBook() {
	}

	private Map<String, String> table = new TreeMap<String, String>();

	public static boolean isValidNumber(String number) {
		if (number.matches("\\+3598[7-9][2-9]\\d{6}") || number.matches("08[7-9][2-9]\\d{6}")
				|| number.matches("00359[7-9][2-9]\\d{7}")) {
			return true;
		}
		return false;
	}

	public void viewContact() {
		printMap(table);

	}

	public <K, V> void printMap(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "," + entry.getValue());
		}
	}

	public void add(String name, String number) {

		if (isValidNumber(number)) {

			table.put(name, number);

		}
	}

	public void delete(String name) {

		if (table.containsKey(name)) {
			table.remove(name);

		}

	}

	public String find(String name) {

		String number = table.get(name);
		return name + "," + number;

	}

}