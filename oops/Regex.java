package com.bridgelabz.oops;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelabz.Utility.Utility;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose :
 */
public class Regex {

	static String string = "Hello <<name>>, We have your full name as <<full name>> \n"
			+ "in our system your contact number is 91­xxxxxxxxxx.\n"
			+ "Please,let us know in case of any clarification. Thank you BridgeLabz 01/01/2016";

	static String name = " ", fullname = " ", mobNo = " ", date = " ";

	public static String wordsRelpace(String string, String regex, String replace) {
		Pattern pat = Pattern.compile(regex);
		Matcher match = pat.matcher(string);
		return string = match.replaceAll(replace);
	}

	public static void details() {
		System.out.println("enter name:");
		name = Utility.getString();
		System.out.println("enter full name:");
		fullname = Utility.getString();
		System.out.println("enter mobile number");
		mobNo = Utility.getString();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		Date datenew = new Date();
		date = (String) dateFormat.format(datenew);
	}

	public static void main(String[] args) {

		details();

		String regex_name = "<<name>>";
		String regex_fullname = "<<full name>>";
		String regex_mobNo = "xxxxxxxxxx";
		String regex_date = "01/01/2016";

		string = wordsRelpace(string, regex_name, name);
		string = wordsRelpace(string, regex_fullname, fullname);
		string = wordsRelpace(string, regex_mobNo, mobNo);
		string = wordsRelpace(string, regex_date, date);
		System.out.println(string);
	}
}
