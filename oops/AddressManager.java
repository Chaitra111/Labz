package com.bridgelabz.oops;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.bridgelabz.Utility.Utility;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose :
 */
public class AddressManager {
	
	static Addressbook ab=new  Addressbook();
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		System.out.println("Select an action..");
		System.out.println("1. Add a person");
		System.out.println("2. Edit details of a person");
		System.out.println("3. Delete a person");
		System.out.println("4. Search a person");
		System.out.println("5. Sort by name");
		System.out.println("6. Sort by zipcode");


		int choice = Utility.getInteger();
		switch (choice) {
		case 1:
				ab.add();
				System.out.println("\n");
				break;
		case 2:
				System.out.print("Enter first and last name of the person to edit the contact: ");
				ab.commonPart(choice);
				System.out.println("\n");
				break;
		case 3:
				System.out.print("Enter first and last name of the person to delete the contact: ");
				ab.commonPart(choice);
				System.out.println("\n");
				break;
		case 4:
				System.out.print("Enter first and last name of the person to search: ");
				ab.commonPart(choice);
				System.out.println("\n");
				break;
		case 5:
				ab.sortByName();
				break;
		case 6:
				ab.sortByZip();
				break;
		}
	}
}
