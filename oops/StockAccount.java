package com.bridgelabz.oops;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
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
public class StockAccount {

	static String name;
	static double balance;
	static File f;
	static UserDetails userDetails = new UserDetails();
	static CompanyShares comshare = new CompanyShares();
	static String customerData = "";
	static String currentcustomerData = "";
	static String shareStockData = "";
	static String currentShareStockData = "";
	long numOfSharesAvailable = 30;
	String stockName[] = { "apple", "bat", "cat", "doll" };
	int[] shareRate = { 50, 40, 30, 10 };

	public StockAccount(String filename) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper map = new ObjectMapper();
		map.writeValue(new File("/home/bridgeit/Documents/Docs/StockAccount.json"), comshare);
	}

	public double valueOf() {
		return balance;
	}

	public UserDetails customerDetails() {

		System.out.println("Enter your Name");
		String firstName = Utility.getString();
		String name = firstName;
		userDetails.setName(name);
		currentcustomerData = currentcustomerData + "Share Holder Name : " + name + "\n";
		System.out.println("Enter your mobile number");
		long mobileNum = Utility.getlong();
		userDetails.setNumber(mobileNum);
		currentcustomerData = currentcustomerData + "Holder's Mob Num : " + mobileNum + "\n";
		customerData = customerData + " " + currentcustomerData + " ";
		System.out.println("Give your share details you want to purchase.");

		System.out.println("Enter how many shares you want");
		long stockNum = Utility.getlong();
		ShareHolding hold = new ShareHolding();
		for (int i = 0; i < stockNum; i++) {
			if (numOfSharesAvailable > 1) {
				comshare = shareDetails();
			}
			hold.getList().add(comshare);
		}

		userDetails.setShareDetails(hold);

		return userDetails;
	}

	private CompanyShares shareDetails() {
		CompanyShares shares = new CompanyShares();

		System.out.println("Enter the Stock Symbol");
		String symbol = Utility.getString();
		shares.setSymbol(symbol);
		currentShareStockData = currentShareStockData + "Share Name : " + symbol + "\n";

		System.out.println("Enter the Number of Stock");
		long noOfShare =Utility.getlong();
		shares.setNumberOfShares((int) noOfShare);
		currentShareStockData = currentShareStockData + "Number of Shares : " + noOfShare + "\n";

		System.out.println("Enter the price of Stock");
		int sharePrice =Utility.getInteger();
		shares.setPrice(sharePrice);
		currentShareStockData = currentShareStockData + "Shares Price : " + sharePrice + "\n";

		if (buy(sharePrice, symbol) == true) {
			numOfSharesAvailable = numOfSharesAvailable - noOfShare;
			shareStockData = shareStockData + currentShareStockData;
			return shares;
		}
		return null;

	}

	/**
	 * @param sharePrice
	 * @param symbol
	 * @return
	 */
	private boolean buy(int amount, String symbol) {
		for (int i = 0; i < stockName.length; i++) {
			if (symbol.equals(stockName[i]) == true) {
				shareRate[i] = shareRate[i] - amount;
				System.out.println("Available share rate of " + symbol + " is --> " + shareRate[i]);

				return true;
			}
		}
		return false;
	}

	public boolean sell(long amount, String symbol) {
		for (int i = 0; i < stockName.length; i++) {
			if (symbol.equals(stockName[i]) == true) {
				shareRate[i] = (int) (shareRate[i] + amount);
				System.out.println("Available share rate of " + symbol + " is -> " + shareRate[i]);
				return true;
			}
		}
		return false;
	}

	public void printReport() throws FileNotFoundException, IOException, ParseException {
		JSONParser json = new JSONParser();
		Object obj = json.parse(new FileReader("/home/bridgeit/Documents/Docs/StockAccount.json"));
		JSONObject jsonObj = (JSONObject) obj;
		JSONArray totalShare = (JSONArray) jsonObj.get("customerArray");
		JSONObject customerDetails = (JSONObject) totalShare.get(0);
		JSONObject companyShareobj = (JSONObject) customerDetails.get("userList");
		JSONArray shareArray = (JSONArray) companyShareobj.get("list");
		for (int i = 0; i < shareArray.size(); i++) {
			JSONObject temp = (JSONObject) shareArray.get(i);
			System.out.println("| " + temp + " |");
		}
	}

	public static void main(String[] args)
			throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		StockAccount newcustum = new StockAccount(name);

		System.out.println("Create Profile");
		newcustum.createProfile();

		System.out.println("Enter the stock Symbol if you want to purchased or sell your stock");
		String stockName = Utility.getString();
		System.out.println("Enter amount of stock you want to purchased or sell");
		int amount = Utility.getInteger();
		System.out.println("Enter the choice for buying or selling the stock as 1 and 2");
		int choice = Utility.getInteger();
		StockAccount stock = new StockAccount(stockName);
		switch (choice) {
		case 1:
			stock.buy(amount, stockName);
			break;

		case 2:
			stock.sell(amount, stockName);
			break;

		default:
			System.out.println("Invalid Choices");
			break;
		}
	}

	public void createProfile() throws JsonGenerationException, JsonMappingException, IOException, ParseException {

		UserList custum = new UserList();
		userDetails = customerDetails();
		custum.getUserList().add(userDetails);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("/home/bridgeit/Documents/Docs/StockAccount.json"),custum);

	}
}