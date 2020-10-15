package address;

import java.util.TreeMap;

public class AddressBookSystem {

	private TreeMap<String, AddressBook> addressBookSystem = new TreeMap<String, AddressBook>();

	public TreeMap<String, AddressBook> getAddressBookSystem() {
		return addressBookSystem;
	}

	public void setAddressBookSystem(TreeMap<String, AddressBook> addressBookSystem) {
		this.addressBookSystem = addressBookSystem;
	}
	
	public void addAddressBook(String addressBookName,AddressBook addressBook) {
		addressBookSystem.put(addressBookName, addressBook);
	}
}
