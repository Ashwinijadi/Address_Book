package address;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import com.google.gson.Gson;

public class AddressBook {
	public static ArrayList<Contacts> addressBook = new ArrayList<Contacts>();
	private static final String CSV_FILE = "/Users/Dell/eclipse-workspace/address/src/AddressBook_CSV.csv";
	private static final String JSON_FILE = "/Users/Dell/eclipse-workspace/address/src/AddressBook_JSON.json";

	public static ArrayList<Contacts> getAddress() {
		return addressBook;
	}

	public void setAddress(ArrayList<Contacts> addressBook) {
		AddressBook.addressBook = addressBook;
	}

	public void addContacts(Contacts cobj) {
		addressBook.add(cobj);
	}

	private static Scanner input = new Scanner(System.in);
	private static AddressBook address = new AddressBook();

	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to AddressBookSystem");
		AddressBook address = new AddressBook();
		AddressBookSystem addressBookSystem = new AddressBookSystem();
		while (true) {
			System.out.println("[1]AddressBook \n[2]Enter the city name to search person "
					+ "\n[3]Enter state name to search person \n[4]sort by person name alphabetically"
					+ "\n[5]sort by city\n[6]sort by state\n[7]sort by zip  "
					+ "\n[8]Read JSON \n[9]Write JSON \n[10]Exit \nEnter Choice");
			int ch = input.nextInt();
			if (ch == 1) {
				System.out.println("Enter the name of address book");
				String aBName = input.nextLine();
				input.nextLine();
				addressBookSystem.addAddressBook(aBName, address);
				int choice = 0;
				do {
					System.out.println("\n[1] Add contact \n[2] edit contacts \n[3] delete all contacts\n[4] Quit");
					System.out.print("Choose the choice : ");
					choice = input.nextInt();

					switch (choice) {
					case 1:
						AddressBook.addContact();
						break;
					case 2:
						AddressBook.editContacts();
						break;
					case 3:
						AddressBook.deleteContact();
						break;
					case 4:
						System.out.println("Thanks for Entering");
						break;
					default:
						System.out.println("Invalid option,please Enter valid option");
						break;
					}

				} while (choice == 4);
			}
			if (ch == 2) {
				AddressBook.search_ForPersonIn_City();
			}
			if (ch == 3) {
				AddressBook.searchForPersonInState();
			}
			if (ch == 4) {
				AddressBook.sortByPersonNameAlphabetically();
			}
			if (ch == 5) {
				AddressBook.sortByCityNameAlphabetically();
			}
			if (ch == 6) {
				AddressBook.sortByStateNameAlphabetically();
			}
			if (ch == 7) {
				AddressBook.sortByZip();
			}
			if (ch == 8) {
				AddressBook.readDataJson();

			}
			if (ch == 9) {
				AddressBook.writeDataJson();
			}
		}
	}

	public static void addContact() throws IOException {
		String firstName;
		String lastName;
		String addressCity;
		String city;
		String State;
		long phoneNumber;
		String email;
		long zip;
		AddressBook address = new AddressBook();
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
			System.out.print("city: ");
			city = input.nextLine();
			System.out.print("State: ");
			State = input.nextLine();
			System.out.print("E-mail address: ");
			email = input.nextLine();
			System.out.print("Phone number: ");
			phoneNumber = input.nextLong();
			System.out.print("zip:");
			zip = input.nextLong();
			input.nextLine();
			boolean duplicate_Check = (address.getAddress()).stream()
					.noneMatch(Contacts -> Contacts.getfirstName().equalsIgnoreCase(firstName)
							&& Contacts.getlastName().equalsIgnoreCase(lastName));

			if (duplicate_Check) {
				Contacts contact = new Contacts(firstName, lastName, addressCity, city, State, phoneNumber, email, zip);
				address.addContacts(contact);
			} else
				System.out.println("Name already exists");
		}
	}

	public static ArrayList<Contacts> editContact(String firstName) {
		ArrayList<Contacts> obj = new ArrayList<Contacts>();
		for (int contactSearch = 0; contactSearch < addressBook.size(); contactSearch++) {
			if (addressBook.get(contactSearch).getfirstName().contains(firstName)) {
				obj.add(addressBook.get(contactSearch));
			}
		}
		return obj;
	}

	public static void deleteContact() {
		System.out.println("enter first name of contact to delete");
		String fname = input.nextLine();
		input.nextLine();
		if (AddressBook.removeContact(fname)) {
			System.out.println("Successfully deleted");
		} else {
			System.out.println("contact is not available");
		}
	}

	public static boolean removeContact(String first) {
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

	public static Contacts editContacts() throws IOException {
		ArrayList<Contacts> contactlist = new ArrayList<Contacts>();
		AddressBook address = new AddressBook();
		Contacts contact = null;
		if (contactlist == null)
			System.out.println("The list is empty");
		else {
			System.out.println("Enter the First Name to update : ");
			String first = input.nextLine();
			input.nextLine();
			contactlist = AddressBook.editContact(first);
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
				case 4:
					String city1 = input.nextLine();
					input.nextLine();
					obj2.setaddressCity(city1);
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
					long phone1 = input.nextLong();
					obj2.setphoneNumber(phone1);
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

	@SuppressWarnings("static-access")
	public static void search_ForPersonIn_City() {
		System.out.println("Enter the City Name to Search for Persons :");
		input.nextLine();
		String citySearch = input.nextLine();
		long count = 0;
		List<Contacts> search = new ArrayList<>();
		search = (address.getAddress()).stream().filter(Contact -> Contact.getCity().equals(citySearch))
				.collect(Collectors.toList());
		count = search.stream().count();
		for (Contacts c : search)
			System.out.println(c + " count of person is " + count);
		for (Contacts p : search)
			System.out.println("person name " + p.getfirstName() + " " + p.getlastName());
	}

	@SuppressWarnings("static-access")
	public static void searchForPersonInState() {
		System.out.println("Enter the State Name to Search for Persons :");
		input.nextLine();
		String stateSearch = input.nextLine();
		long count = 0;
		List<Contacts> searchByState = new ArrayList<>();
		searchByState = (address.getAddress()).stream().filter(Contact -> Contact.getState().equals(stateSearch))
				.collect(Collectors.toList());
		count = searchByState.stream().count();
		for (Contacts c : searchByState)
			System.out.println(c + "count of person is " + count);
		for (Contacts person : searchByState)
			System.out.println(person + "person name " + person.getfirstName() + " " + person.getlastName());
	}

	public static void sortByPersonNameAlphabetically() {
		long count = 0;
		List<Contacts> searchByName = new ArrayList<>();
		searchByName = (address.getAddress()).stream().sorted(Comparator.comparing(Contacts::getfirstName))
				.collect(Collectors.toList());
		count = searchByName.stream().count();
		System.out.println("count of person is " + count);
		// filter(Contact -> Contact.getfirstName().equals(stateSearch))
		for (Contacts p2 : searchByName)
			System.out.println(p2 + "person name " + p2.getfirstName() + " " + p2.getlastName());
	}

	public static void sortByCityNameAlphabetically() {
		long count = 0;
		List<Contacts> sortByCity = new ArrayList<>();
		sortByCity = (address.getAddress()).stream().sorted(Comparator.comparing(Contacts::getCity))
				.collect(Collectors.toList());
		count = sortByCity.stream().count();
		System.out.println("count of person is " + count);
		// filter(Contact -> Contact.getfirstName().equals(stateSearch))
		for (Contacts p1 : sortByCity)
			System.out.println("City name sorted order" + p1 + " " + p1.getCity());
	}

	@SuppressWarnings("static-access")
	public static void sortByStateNameAlphabetically() {
		long count = 0;
		List<Contacts> sortByState = new ArrayList<>();
		sortByState = (address.getAddress()).stream().sorted(Comparator.comparing(Contacts::getState))
				.collect(Collectors.toList());
		count = sortByState.stream().count();
		System.out.println("count of person is " + count);
		// filter(Contact -> Contact.getfirstName().equals(stateSearch))
		for (Contacts p3 : sortByState)
			System.out.println("State name sorted order:" + p3 + " " + p3.getState());
	}

	public static void sortByZip() {
		long count = 0;
		List<Contacts> sortByZip = new ArrayList<>();
		sortByZip = (address.getAddress()).stream().sorted(Comparator.comparing(Contacts::getzip))
				.collect(Collectors.toList());
		count = sortByZip.stream().count();
		System.out.println("count of person is " + count);
		// filter(Contact -> Contact.getfirstName().equals(stateSearch))
		for (Contacts p4 : sortByZip)
			System.out.println("State name sorted order:" + p4 + " " + p4.getzip());
	}

	// reading data
	public static void readDataJson() throws IOException, NullPointerException {
		List<Contacts> read = new ArrayList<Contacts>();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(JSON_FILE));
			System.out.println(read.addAll(Arrays.asList(new Gson().fromJson(reader, Contacts[].class))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// writing data into file
	public static void writeDataJson() throws IOException {
		Writer writer = Files.newBufferedWriter(Paths.get(JSON_FILE));
		List<Contacts> write = new ArrayList<>();
		write = (address.getAddress()).stream().collect(Collectors.toList());
		new Gson().toJson(write, writer);
		writer.close();
	}
}
