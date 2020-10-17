package address;

import java.util.Arrays;
import org.junit.Test;

import address.AddressBookFile.IOService;

public class AddressBookFileTest {

	@Test
	public void writePayrollOnFile() {
		Contacts[] arrayOfPersons = {
				new Contacts("Ashwini", "Jadi", "kukatpally", "Hyderabad", "TS",965531635, "aish@gmail.com", 541652),
				new Contacts("sweety", "J", "DSK", "Hyd", "TS", 986004509, "sweety@gmail.com", 545216) };
		AddressBookFile personsContact = new AddressBookFile();
		personsContact = new AddressBookFile(Arrays.asList(arrayOfPersons));
		personsContact.writePersonsData(IOService.FILE_IO);
	}

	@Test
	public void givenFileOnReadingFileShouldMatchEmployeeCount() {
		AddressBookFile personsContact = new AddressBookFile();
		personsContact.readPersonsData(IOService.FILE_IO);
	}
}
