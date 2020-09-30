package address;
public class Data {
		private  String lastName;
		private  String firstName;
		private  String addressCity;
		private  String State;
		private  String phoneNumber;
		private  String email;
		private  String zip;

		public Data(String lastName,String firstName,String addressCity,String State, String phoneNumber,String email,String zip){ 	
		    this.firstName=firstName;
		    this.lastName=lastName;
		    this.addressCity=addressCity;
		    this.State=State;
		    this.phoneNumber=phoneNumber;
		    this.email=email;
		    this.zip=zip;}
public String getfirstName(){ 	
		    return firstName;
		}
public String getlastName(){
    return lastName;
}
public String setfirstName(){
    return (this.firstName = firstName);
}
public String setlastName(){
    return (this.lastName = lastName);
}
public String getaddressCity() {
    return this.addressCity;   
}
public String setaddressCity(){
    return (this.addressCity = addressCity);
}
public String getemail() {
    return this.email;
}
public String setemail(){
    return (this.email = email);
}
public String getphoneNumber() {
    return this.phoneNumber;
}
public String setphoneNumber(){
    return (this.phoneNumber =phoneNumber);
}
public String getzip() {
    return zip;}

public String setzip() {
    return (this.zip=zip);}
}





