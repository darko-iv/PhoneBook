package Example;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Registry {

	PhoneBook book = new PhoneBook();
	ArrayList<PhoneBookEntry> calls = new ArrayList<PhoneBookEntry>();
	HashMap<PhoneBookEntry, Integer> frequency = new HashMap<>();

	public Registry(PhoneBook book) {
		this.book = book;
	}

	public void registerCall(PhoneBookEntry call) {

		calls.add(call);

	}

	public void getMostCalled(int number) {

		for (PhoneBookEntry entry : calls) {
			if (frequency.containsKey(entry)) {
				frequency.put(entry, frequency.get(entry) + 1);
			} else {
				frequency.put(entry, 1);
			}
		}
		TreeMap m = (TreeMap) sortByValues(frequency);
		for (int i = 0; i < number; i++) {
			System.out.println((m.keySet().toArray()[i]));
		}
		calls.clear();
	}

	public <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> frequency) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = frequency.get(k2).compareTo(frequency.get(k1));
				if (compare == 0)
					return 1;
				else
					return compare;
			}
		};
		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(frequency);
		return sortedByValues;
	}

}