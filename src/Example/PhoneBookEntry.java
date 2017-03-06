package Example;

import java.util.Objects;

public class PhoneBookEntry {

	private String from;
	private String to;

	public PhoneBookEntry(String from, String to) {
		this.setFrom(from);
		this.setTo(to);
	}

	public String toString() {
		return "" + from + " " + to;
	}

	public int hashCode() {
		return Objects.hashCode(this.from) + Objects.hashCode(this.to);

	}

	public boolean equals(Object obj) {

		if (obj instanceof PhoneBookEntry) {
			PhoneBookEntry pp = (PhoneBookEntry) obj;
			return (pp.from.equals(this.from) && pp.to.equals(this.to));
		} else {
			return false;
		}
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
}
