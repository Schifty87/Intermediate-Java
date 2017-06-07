/*
This program allows the user to load and save an addressbook with names (first and last) and phone numbers
Program Name:  Main.java (addressbook)
Author:  Ryan J Schiferl
CS 220 Section 2
*/
package AddressBook;

import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		//create scanner and initialize
		Scanner s = new Scanner(System.in);
		int choice;
		String fullName;

		//create new instance of AddressBook
		AddressBook A = new AddressBook("Address.txt");
		
		//load file
		A.load();
		
		System.out.println("Welcome. Address book is loaded");

		do{

			//ask user what he/she would like to do
			System.out.print("\nWhat would you like to do?" + "\n1) Display all "
					+ "contacts" + "\n2) Add a contact" + "\n3) Remove a contact" 
					+ "\n4) Search for a contact" + "\n5) Modify contact" 
					+"\n6) Save and exit" 
					+ "\nYour choice: ");
			choice = s.nextInt();
	
			//display
			if(choice ==1){
				System.out.println();
				A.display();
			}
			
			//add a contact
			if(choice ==2){
				System.out.print("First name ");
					String firstName = s.next();
				System.out.print("Last name ");
					String lastName = s.next();
				System.out.print("Phone number ");
					String phone = s.next();
				fullName = (firstName + " " + lastName);
				
				if(A.contains(fullName)==true){
					System.out.println("\ncontact already exists");
					continue;
					
				}
				
				else{
				A.add(new Contact(firstName, lastName, phone));
				}
			}
			
			//Remove a contact
			if(choice ==3){
				System.out.print("Full name of contact to remove: ");
				s.nextLine();
				fullName = s.nextLine();
				if(A.remove(fullName)==false){
					System.out.println("\nContact not found");
				}
				else{
				A.remove(fullName);
				}
			}
			
			//Search for contact
			if(choice ==4){
				System.out.print("Full name to search: ");
				s.nextLine();
				fullName = s.nextLine();
				System.out.println();
				if(A.searchAlt(fullName)==null){
					System.out.println("Contact not found");
				}
				else{
					A.search(fullName);
				}
			}
			
			//alter contact
			if(choice ==5){							
				System.out.print("Full name to update: ");
				s.nextLine();
				fullName = s.nextLine();
				int decision;
				System.out.println();
				
				//end alter contact if name not found
				if(A.search(fullName)==null){
					System.out.println("Contact not found");
					continue;
				}
				
				System.out.print("\nWhat part of the contact would you like to modify?" 
						+ "\n1) First name" + "\n2) Last name" + "\n3) Phone" 
						+ "\n4) Do nothing" + "\nYour decision? ");
				decision = s.nextInt();
					
				if(decision == 1){							
					System.out.print("First name: ");
					String first = s.next();
					A.searchAlt(fullName).setFirstName(first);
				}
					
				if(decision == 2){								
					System.out.print("Last name: ");
					String last = s.next();
					A.searchAlt(fullName).setLastName(last);
				}
					
				if(decision == 3){					
					System.out.print("Phone: ");
					String phone = s.next();
					A.searchAlt(fullName).setPhone(phone);
				}
					
				if(decision == 4){
					continue;				
				}				
			}//end contact modification
			
			//kill loop
			if(choice ==6){
				break;
			}
			
		}while(choice !=6);

		//save text file under same name
		A.save();
		
		//sign off
		System.out.println("\nAddress book is saved to file" + "\n\nAuf Wiedersehen");
	}

}
