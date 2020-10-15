package address;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	public ArrayList<Contacts> addressBook = new ArrayList<Contacts>();

	public ArrayList<Contacts> getAddress() {
		return addressBook;
	}

	public static AddressBook address = new AddressBook();

	public void setAddress(ArrayList<Contacts> addressBook) {
		this.addressBook = addressBook;
	}

	public void addContacts(Contacts cobj) {
		addressBook.add(cobj);
	}

	private static Scanner input = new Scanner(System.in);
	public static AddressBook list = new AddressBook();

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to AddressBookSystem");
		AddressBookSystem addressBookSystem = new AddressBookSystem();
		System.out.println("1.AddressBook \n2Exit\nEnter Choice");
		int ch = input.nextInt();
		if (ch == 1) {
			System.out.println("Enter the name of address book");
			String aBName=input.nextLine();
			input.nextLine();
			addressBookSystem.addAddressBook(aBName,address);
			int choice = 0;
			do {
				System.out.println("\n[1] Add contact");
				System.out.println("[2] edit contacts");
				System.out.println("[3] delete all contacts");
				System.out.println("[4] Quit");
				System.out.print("Choose the choice : ");
				choice = input.nextInt();

				switch (choice) {
				case 1:
					list.addContact();
					break;
				case 2:
					list.editContacts();
					break;
				case 3:
					list.deleteContact();
					break;
				case 4:
					System.out.println("Thanks for Entering");
					break;
				default:
					System.out.println("Invalid option,please Enter valid option");
					break;
				}

			} while (choice != 4);
		}
		if(ch!=1) {
			System.exit(0);
		}
	}

	public void addContact() throws IOException {
		String firstName;
		String lastName;
		String addressCity;
		String State;
		long phoneNumber;
		String email;
		long zip;
		System.out.println("Please enter Specify the contact type (1) Personal or (2) Business: ");
		int contactType = input.nextInt();
		if (contactType == 1) {
			System.out.print("First Name: ");
			firstName = input.nextLine();
			input.nextLine();
			System.out.print("Last Name: ");
			lastName = input.nextLine();
			System.out.print("Address: ");
			addressCity = input.nextLine();
			System.out.print("State: ");
			State = input.nextLine();
			System.out.print("E-mail address: ");
			email = input.nextLine();
			System.out.print("Phone number: ");
			phoneNumber = input.nextLong();
			System.out.print("zip:");
			zip = input.nextLong();
			input.nextLine();
			Contacts contact = new Contacts(firstName, lastName, addressCity, State, phoneNumber, email, zip);
			address.addContacts(contact);
    
		}
	}
	
	public ArrayList<Contacts> editContact(String firstName) {
		ArrayList<Contacts> obj = new ArrayList<Contacts>();
		for (int contactSearch = 0; contactSearch < addressBook.size(); contactSearch++) {
			if (addressBook.get(contactSearch).getfirstName().contains(firstName)) {
				obj.add(addressBook.get(contactSearch));
			}
		}
		return obj;
	}

	public void deleteContact() {
		System.out.println("enter first name of contact to delete");
		String fname = input.nextLine();
		input.nextLine();
		if (address.removeContact(fname)) {
			System.out.println("Successfully deleted");
		} else {
			System.out.println("contact is not available");
		}
	}

	public boolean removeContact(String first) {
		int val = 0;
		for (Contacts obj : getAddress()) {
			if (obj.getfirstName().equals(first)) {
				addressBook.remove(obj);
			}
			val = 1;
			break;
		}
		if (val == 1) {
			return true;
		} else {
			return false;
		}
	}

	public Contacts editContacts() throws IOException {
		ArrayList<Contacts> contactlist = new ArrayList<Contacts>();
		Contacts contact = null;
		if (contactlist == null)
			System.out.println("The list is empty");
		else {
			System.out.println("Enter the First Name to update : ");
			String first = input.nextLine();
			input.nextLine();
			contactlist = address.editContact(first);
			System.out.println("Select the detail to be updated : ");
			System.out.println("1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip\n7.Phone Number\n8.Email");
			int c = input.nextInt();
			for (Contacts obj2 : contactlist) {
				switch (c) {
				case 1:
					String fn1 = input.nextLine();
					input.nextLine();
					obj2.setfirstName(fn1);
					break;
				case 2:
					String ln1 = input.nextLine();
					input.nextLine();
					obj2.setlastName(ln1);
					break;
				case 3:
					String add1 = input.nextLine();
					input.nextLine();
					obj2.setaddressCity(add1);
					break;
				case 5:
					String state1 = input.nextLine();
					input.nextLine();
					obj2.setState(state1);
					break;
				case 6:
					int zip1 = input.nextInt();
					obj2.setzip(zip1);
					break;
				case 7:
					long ph1 = input.nextLong();
					obj2.setphoneNumber(ph1);
					break;
				case 8:
					String email1 = input.nextLine();
					input.nextLine();
					obj2.setemail(email1);
					break;
				}
				contact = obj2;
			}
		}
		return contact;
	}
}
