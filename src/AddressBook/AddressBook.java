package AddressBook;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class AddressBook {
	//name instance variables
	private int count = 0;
	private Contact[] contacts;
	private String fileName = "Address.txt";

	//create constructor
	public AddressBook(String fileName){
		this.fileName = fileName;
		contacts = new Contact[100]; //fill array with 100 contacts with type Contact		
	}
	
	public boolean add(Contact C){
		if(count > 100){
			System.out.println("You have exceeded the 100 contact limit");
			return false;
		}
		else{
			contacts[count] = C;  //identify item in array as a new contact object
			count++;
			return true;
		}
	}
	
	public boolean remove(String fullName){
		String lines[] = fullName.split(" "); // split first and last name with 
		String first = lines[0];
		String last = lines[1];
		
		int target = -1;  //this means word has not been found
		
		for(int i = 0; i<count; i++){
			if(first.toUpperCase().equals(contacts[i].getFirstName().toUpperCase())){
				if(last.toUpperCase().equals(contacts[i].getLastName().toUpperCase())){
					target = i;
					break;  
				}
			}
		}
		
		if(target == -1){
			System.out.print("Contact not found");
			return false;  //nothing to remove
		}
		
		//starts at item that is going to be removed
		for(int i=target; i<count-1; i++){//count;i++){
			contacts[i] = contacts[i+1];  //move to the left
		}
		count--;
		return true;
	}
	
	public Contact search(String fullName){
		String lines[] = fullName.split(" "); // split first and last name with 
		String first = lines[0];
		String last = lines[1];
		
		for(int i = 0; i<count; i++){
			if(first.toUpperCase().equals(contacts[i].getFirstName().toUpperCase())){
				if(last.toUpperCase().equals(contacts[i].getLastName().toUpperCase())){
					//split phone number based on "-"
					String num[] = contacts[i].getPhone().split("-");
					String one = num[0];
					String two = num[1];
					String three = num[2];
					System.out.println("Name" + "\t\t\tPhone Number");
					System.out.println("--------------------------------------");
					System.out.println((contacts[i].getFirstName()) + " " 
							+ (contacts[i].getLastName())+ "\t\t" 
							+ "(" + one + ")" + " " + two + "-" + three);
					System.out.println("--------------------------------------");
					return contacts[i];}			
			}	
		}
		return null;
	}
	
	public Contact searchAlt(String fullName){
		String lines[] = fullName.split(" "); // split first and last name with 
		String first = lines[0];
		String last = lines[1];
		
		for(int i = 0; i<count; i++){
			if(first.toUpperCase().equals(contacts[i].getFirstName().toUpperCase())){
				if(last.toUpperCase().equals(contacts[i].getLastName().toUpperCase())){					
					return contacts[i];
				}			
			}	
		}			
		return null;
	}
	
	public boolean load() throws FileNotFoundException{
		File file = new File("Address.txt");
		Scanner s = new Scanner(file);
		while(s.hasNext()){ //while there is something populating the next line
			String line = s.nextLine();
			String[] array = line.split(":");
			add(new Contact(array[0], array[1], array[2]));
		}		
		s.close();
		return true;
	}	
	
	public boolean save(){
		String file = "Address.txt";
		try{
			FileWriter writer = new FileWriter(new File(file));
			for(int i=0; i<count;i++){
				writer.write(contacts[i] + "\n");
			}			
			writer.close();
			return true;
		}		
		catch(IOException e){
			e.printStackTrace();
		}
		return false;
	}
	
	void display(){			
		System.out.println("Name" + "\t\t\tPhone Number");
		System.out.println("--------------------------------------");
			
		for(int i=0; i<count;i++){
			String num[] = contacts[i].getPhone().split("-");
			String one = num[0]; //area code
			String two = num[1]; //middle three digits
			String three = num[2]; //last four digits
			System.out.println((contacts[i].getFirstName()) + " " 
					+ (contacts[i].getLastName())+ "\t\t" 
					+ "(" + one + ")" + " " + two + "-" + three);
		}
		System.out.println("--------------------------------------");
	}
	
	public boolean contains(String fullName){
		Contact C = searchAlt(fullName);
		if(C == null){
			return false;}
		else{
			return true;}
	}
}//end AddressBook