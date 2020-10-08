package address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	static ArrayList<Contacts> addressBook = new ArrayList<Contacts>();
	static ArrayList<String> contactsList = new ArrayList<>();
	int top = 0;
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		AddressBook list = new AddressBook();
		BufferedReader keyIn;
		keyIn = new BufferedReader(new InputStreamReader(System.in));
		String choose = " ";

		while (true) {

			System.out.println("\n[1] Add contact");
			System.out.println("[2] view contacts");
			System.out.println("[3] delete all contacts");
			System.out.println("[4] edit contacts");
			System.out.println("[5] Quit");
			System.out.print("Choose : ");
			try {
				choose = keyIn.readLine();

			} catch (IOException e) {

				System.out.println("Error");
			}
			switch (choose) {
			case "1":
				list.addContact();
				break;
			case "2":
				list.viewContacts();
				break;
			case "3":
				list.deleteContact(choose);
				break;
			case "4":
				list.editContact();
				break;
			case "5":
				System.exit(0);
				break;
			default:
				System.out.println("Error");
				break;
			}

		}
	}

	public AddressBook() {
		AddressBook.addressBook = new ArrayList<>();
	}

	public void addContact() throws IOException {
		BufferedReader keyIn;
		keyIn = new BufferedReader(new InputStreamReader(System.in));
		String firstName;
		String lastName;
		String addressCity;
		String State;
		String phoneNumber;
		String email;
		String zip;
		System.out.println("Please enter Specify the contact type (1) Personal or (2) Business: ");
		int contactType = input.nextInt();
		if (contactType == 1) {
			System.out.print("First Name: ");
			firstName = keyIn.readLine();
			System.out.print("Last Name: ");
			lastName = keyIn.readLine();
			System.out.print("Address: ");
			addressCity = keyIn.readLine();
			System.out.print("State: ");
			State = keyIn.readLine();
			System.out.print("E-mail address: ");
			email = keyIn.readLine();
			System.out.print("Phone number: ");
			phoneNumber = keyIn.readLine();
			System.out.print("zip:");
			zip = keyIn.readLine();

			PersonalContact entry;
			entry = new PersonalContact(firstName, lastName, addressCity, State, phoneNumber, email, zip);
			addressBook.add(entry);
			top++;
		}
	}

	public Contacts editContact() throws IOException {
		BufferedReader keyIn;
		keyIn = new BufferedReader(new InputStreamReader(System.in));
		String firstName;
		System.out.print("First Name: ");
		firstName = keyIn.readLine();
		for (Contacts contact : addressBook) {
			String name = contact.getfirstName() + " " + contact.getlastName();

			if (name.equals(firstName))
				return contact;
		}
		return null;
	}

	public boolean deleteContact(String fullName) {
		for (Contacts contact : addressBook) {
			String name = contact.getfirstName() + " " + contact.getlastName();
			if (name.equals(fullName))
				addressBook.remove(contact);
		}
		return true;
	}

	private void viewContacts() {
		System.out.println(addressBook);
	}

	public void view() {
		for (int index = 0; index < top; index++) {
			addressBook.get(index).printContacts();
		}
	}
}
