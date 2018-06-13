package com.bridgelabz.oops;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.Utility.Utility;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose :
 */
public class Addressbook {
		
	ObjectMapper map = new ObjectMapper();
	// gets users info 
	static void add() {
		System.out.print("Enter first and last name: ");
		String firstName = Utility.getString();
		String lastName = Utility.getString();

		System.out.print("Enter complete address: ");
		String address = Utility.getString();

		System.out.print("Enter city, state and zip: ");
		String city = Utility.getString();
		String state = Utility.getString();
		String zip = Utility.getString();

		System.out.println("Enter phone number: ");
		String phoneNumber = Utility.getString();

		AdressDetails person = new AdressDetails(firstName, lastName, address, city, state, zip, phoneNumber);
		JSONObject jsonObject = person.toJsonObject();
		writeBook(jsonObject);
	}

	// Edits a persons information 
	static void edit(JSONObject jsonObject, JSONArray bookArray, int i) {
		System.out.println("What do you want to edit?");
		System.out.println("1. Address");
		System.out.println("2. Phone Number");

		int choice = Utility.getInteger();
		switch (choice) {
		case 1:
			System.out.print("Enter address: ");
			String address = Utility.getString();
			System.out.print("Enter city, state and zip: ");
			String city = Utility.getString();
			String state = Utility.getString();
			String zip = Utility.getString();

			jsonObject.put("Address", address);
			jsonObject.put("City", city);
			jsonObject.put("State", state);
			jsonObject.put("Zip", zip);
			break;

		case 2:
			System.out.println("Enter phone number: ");
			String phoneNumber = Utility.getString();
			jsonObject.put("Phone Number", phoneNumber);
			break;
		}

		bookArray.remove(i);
		bookArray.add(i, jsonObject);
		printWriter(bookArray);
		System.out.println("Contact updated successfully");
	}

	// Deletes a person's information 
	static void delete(JSONArray bookArray, int i) {
		//bookArray.sort(i);
		bookArray.remove(i);

		printWriter(bookArray);
		System.out.println("Contact deleted successfully");
	}

	// Displays person's record 
	static void search(JSONObject jsonObject) {
		System.out.println("Name:\n" + jsonObject.get("First Name") + " " + jsonObject.get("Last Name"));
		System.out.println("Address:\n" + jsonObject.get("Address"));
		System.out.print(jsonObject.get("City") + ", ");
		System.out.print(jsonObject.get("State") + " - ");
		System.out.println(jsonObject.get("Zip"));
		System.out.println("Phone Number:\n" + jsonObject.get("Phone Number"));
	}

	// Updates Address book 
	static void writeBook(JSONObject jsonObject) {
		JSONParser parser = new JSONParser();
		JSONArray bookArray = null;

		File file = new File("/home/bridgeit/Documents/addressbook.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			bookArray = new JSONArray();
		} else {
			try {
				bookArray = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Documents/Docs/addressbook.json"));
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		}
		bookArray.add(jsonObject);
		printWriter(bookArray);
		System.out.println("Contact added successfully");
	}

	// Reads json file and adds information to json array 
	static void commonPart(int choice) {
		JSONParser parser = new JSONParser();
		String firstName = Utility.getString();
		String lastName = Utility.getString();
		JSONArray bookArray = null;

		try {
			bookArray = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Documents/Docs/addressbook.json"));
		} catch (IOException | ParseException e) {
			((Throwable) e).printStackTrace();
		}

		Iterator iterator = bookArray.iterator();
		int i = 0;
		boolean b = false;
		outer: while (iterator.hasNext()) {
			JSONObject jsonObject = (JSONObject) iterator.next();
			if (jsonObject.get("First Name").equals(firstName) && jsonObject.get("Last Name").equals(lastName)) {
				b = true;
				switch (choice) {
				case 2:
					edit(jsonObject, bookArray, i);
					break outer;
				case 3:
					delete(bookArray, i);
					break outer;
				case 4:
					search(jsonObject);
					break outer;
				}
			}
			i++;
		}
		if (!b) {
			System.out.println("\nSorry!!! Person not found...");
		}
	}

	public static String[] getName() throws FileNotFoundException, IOException, ParseException {
		String[] b = new String[10];
		JSONParser parser = new JSONParser();
		JSONArray bookArray = null;
		bookArray = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Documents/Docs/addressbook.json"));
		Iterator iterator = bookArray.iterator();
		// System.out.println(jsonObject.get("Last Name"));
		for (int i = 0; i < bookArray.size(); i++) {
			JSONObject jsonObject = (JSONObject) iterator.next();
			b[i] = (String) jsonObject.get("First Name");
			// System.out.println(b[i]);

		}
		return b;
	}
	public static void sortByName() throws FileNotFoundException, IOException, ParseException {
		String[] str = getName();
		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				if (str[i].compareTo(str[j]) > 0) {
					String temp = str[i];
					str[i] = str[j];
					str[j] = temp;
				}
			}
		}
		for (int i = 0; i < 6; i++) {
			System.out.println(str[i]);
		}
	}
	public static String[] getZip() throws FileNotFoundException, IOException, ParseException {
		String[] b1 = new String[10];
		JSONParser parser = new JSONParser();
		JSONArray bookArray = null;
		bookArray = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Documents/Docs/addressbook.json"));
		Iterator iterator = bookArray.iterator();
		for (int i = 0; i < bookArray.size(); i++) {
			JSONObject jsonObject = (JSONObject) iterator.next();
			b1[i] = (String) jsonObject.get("Zip");
			// System.out.println(b1[i]);
		}
		return b1;
	}
	public static void sortByZip() throws FileNotFoundException, IOException, ParseException {
		String[] str = getZip();
		for (int i = 0; i < 2; i++) {
			for (int j = i + 1; j < 2; j++) {
				if (str[i].compareTo(str[j]) > 0) {
					String temp = str[i];
					str[i] = str[j];
					str[j] = temp;
				}
			}
		}
		for (int i = 0; i < 6; i++) {
			System.out.println(str[i]);
		}
	}

	// Writes all the data to a file 
	static void printWriter(JSONArray bookArray) {
		try {
			PrintWriter printWriter = new PrintWriter("/home/bridgeit/Documents/Docs/addressbook.json");
			printWriter.write(bookArray.toJSONString());
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
