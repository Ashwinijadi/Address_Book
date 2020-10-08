package address;

import java.util.ArrayList;

public class Contacts {
	private ArrayList<String> contacts = new ArrayList<>();

	public void printContacts() {
		System.out.println("You have " + contacts.size() + " contacts.");
		for (int i = 0; i < contacts.size(); i++) {
			System.out.println((i + 1) + ". " + contacts.get(i));
		}
	}

	private String lastName;
	private String firstName;
	private String addressCity;
	private String State;
	private String phoneNumber;
	private String email;
	private String zip;

	public Contacts(String lastName, String firstName, String addressCity, String State, String phoneNumber,
			String email, String zip) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressCity = addressCity;
		this.State = State;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.zip = zip;
	}

	public String getfirstName() {
		return firstName;
	}

	public String setfirstName() {
		return (this.firstName = firstName);
	}

	public String getlastName() {
		return lastName;
	}

	public String setlastName() {
		return (this.lastName = lastName);
	}

	public String getaddressCity() {
		return addressCity;
	}

	public String setaddressCity() {
		return (this.addressCity = addressCity);
	}

	public String getState() {
		return State;
	}

	public String setState() {
		return (this.State = State);
	}

	public String getemail() {
		return email;
	}

	public String setemail() {
		return (this.email = email);
	}

	public String getphoneNumber() {
		return phoneNumber;
	}

	public String setphoneNumber() {
		return (this.phoneNumber = phoneNumber);
	}

	public String getzip() {
		return zip;
	}

	public String setzip() {
		return (this.zip = zip);
	}

	public void editContact(String replacedContact, String newContact) {
		int index = findContact(replacedContact);
		if (index >= 0) {
			contacts.set(findContact(replacedContact), newContact);
		} else {
			System.out.println("No such contact found to update");
		}
	}

	public int findContact(String contact) {
		return contacts.indexOf(contact);
	}
}
