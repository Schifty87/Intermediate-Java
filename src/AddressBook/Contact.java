package AddressBook;

public class Contact {
	//name instance variables
	private String firstName, lastName, phone;
		
	//create constructor
	public Contact(String firstName, String lastName, String phone){
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}	
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public String getPhone(){
		return phone;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
		
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	//checks to see if object is an instance within Contacts class
	public boolean equals(Object o){
		if(!(o instanceof Contact)){
			return false;		
		}
		if (((Contact) o).getFirstName().equals(this.firstName) && 
				((Contact) o).getLastName().equals(this.getLastName())){
			return true;
		}
		return false;		
	}//end equals()
		
	@Override
	public String toString(){
		return (firstName + ":" + lastName + ":" + phone);
	}
}
