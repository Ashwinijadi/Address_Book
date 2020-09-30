package address;
public class AddressBook{
	//Contact Instance Variables
			private String lastName;
			private String firstName;
			private String addressCity;
			private String state;
			private String phoneNumber;
			private String email;
			private String zip;
			public void printContacts() {
				System.out.println("lastName : " + lastName + "\nfirstName :" + firstName + 
				 "\naddressCity : " + addressCity+ "\nstate :" + state+ "\nphoneNumer :" 
				  + phoneNumber+ "\nemail :" + email+ "\nzip :" +zip );
		}
	public static void main(String[] args) {
		 System.out.println("Welcome to address book program");
		 AddressBook  contacts =new AddressBook();
		 contacts.printContacts();
		  }
	}
