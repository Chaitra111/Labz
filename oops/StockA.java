package com.bridgelabz.oops;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.Utility.Utility;

public class StockA {
	
	static String symbol;
	static int numberOfShares, price;
	static long shares;
	static UserDetails userInfo = new UserDetails();
	static List<CompanyShares> list = new ArrayList<CompanyShares>();
	static ObjectMapper map = new ObjectMapper();
	static File FILEPATH = new File("/home/bridgeit/Documents/Docs/StockAccount.json");
	static CompanyShares companyShares;

	public static void getUserInfo() throws JsonGenerationException, JsonMappingException, IOException {
		List<UserDetails> list = new ArrayList<UserDetails>();
		System.out.println("enter your name");
		String name = Utility.getString();
		userInfo.setName(name);
		System.out.println("give your phone number");
		long number = Utility.getlong();
		userInfo.setNumber(number);
		list.add(userInfo);
	}

	public StockA(String filename) throws IOException {
		if (FILEPATH.createNewFile()) {
			System.out.println("File is created!");
		} else {
			System.out.println("File already exists.");
		}
	}

	public static void getCompanyShares() throws JsonGenerationException, JsonMappingException, IOException {
		getUserInfo();
		System.out.println("Enter how many shares you want?");
		int value = Utility.getInteger();

		for (int i = 0; i < value; i++) {
			companyShares = new CompanyShares();
			System.out.println("Enter company symbol");
			symbol = Utility.getString();
			companyShares.setSymbol(symbol);
			System.out.println("enter number of shares");
			numberOfShares = Utility.getInteger();
			companyShares.setNumberOfShares(numberOfShares);
			System.out.println("enter price of shares");
			price = Utility.getInteger();
			companyShares.setPrice(price);
			list.add(companyShares);
		}
	}

	/**
	 * @return
	 */
	private static JSONObject toJsonObject() {
		JSONObject obj = new JSONObject();

		obj.put("symbol", symbol);
		obj.put("numberOfShares", numberOfShares);
		obj.put("price", price);
		return obj;
	}

	public static JSONArray toJavaObject() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(FILEPATH));
		JSONArray jarray = (JSONArray) obj;
		for (int i = 0; i < jarray.size(); i++) {
			JSONObject object = (JSONObject) jarray.get(i);
		}
		return jarray;

	}

	public static int search() {
		System.out.println(list);
		System.out.println("Enter symbol to be searched");
		String symbol = Utility.getString();
		for (int i = 0; i != list.size(); i++) {
			if (list.get(i).getSymbol().equals(symbol)) {

				return i;
			}
		}
		System.out.println("not found");
		return -1;
	}

	public static void main(String[] args)throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		System.out.println("enter the file path where u need to create account");
		String filename = "/home/administrator/Desktop/stock";
		StockA a = new StockA(filename);
		// System.out.println("get user info");
		// getUserInfo();
		// JSONObject object = toJsonObject();
		// map.writeValue(FILEPATH, list);
		System.out.println("get company info");
		getCompanyShares();
		JSONObject object1 = toJsonObject();
		map.writeValue(FILEPATH, list);
		System.out.println("Enter amount ");
		int amount =Utility.getInteger();
		System.out.println("enter symbol");
		String symbol = Utility.getString();
		System.out.println("---Enter option---");
		System.out.println("1] Buy share \n2] sell share");
		int option = Utility.getInteger();
		switch (option) {
		case 1:
			buy(amount, symbol);
			break;
		case 2:
			sell(amount, symbol);
			break;
		}
	}

	/**
	 * @param amount
	 * @param symbol
	 * @throws ParseException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void sell(int amount, String symbol) throws FileNotFoundException, IOException, ParseException {
		int index = search();
		shares = amount / price;
		if (list.get(index).getNumberOfShares() > shares) {
			JSONArray array = toJavaObject();
			JSONObject obj = (JSONObject) array.get(index);
			amount -= shares * (double) obj.get("price");
			shares = (long) obj.get("numberOfShares") - shares;
			System.out.println("total amount after buying shares->" + amount);
			System.out.println("total number of shares are ->" + shares);
		}
	}

	/**
	 * @param amount
	 * @param symbol
	 * @throws ParseException
	 * @throws IOException
	 * @throws FileNotFoundException
	 *             
	 */
	private static void buy(int amount, String symbol) throws FileNotFoundException, IOException, ParseException {
		int index = search();
		shares = amount / price;
		JSONArray array = toJavaObject();
		JSONObject obj = (JSONObject) array.get(index);
		amount += (double) obj.get("price");
		shares += (long) obj.get("numberOfShares");
		System.out.println("total amount after buying shares->" + amount);
		System.out.println("total number of shares are ->" + shares);
	}

}