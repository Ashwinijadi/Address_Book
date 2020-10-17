package address;

import java.util.List;

public class AddressBookFile {
	public enum IOService {
		FILE_IO
	}

	private List<Contacts> contacts;

	public AddressBookFile() {

	}

	public AddressBookFile(List<Contacts> contact) {
		this.contacts = contact;
	}

	public void writePersonsData(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO))
			new AddressBookFileIOService().writeData(contacts);
	}

	public List<Contacts> readPersonsData(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO))
			this.contacts = new AddressBookFileIOService().readData();
		return contacts;
	}

}
