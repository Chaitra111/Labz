package com.bridgelabz.oops;

import java.io.File;
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
public class StockReport {

	static int sumStock = 0;
	static int totalStock = 0;

	public static void main(String[] args)
			throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		StockPortfolio stockfolio = new StockPortfolio();
		ObjectMapper map = new ObjectMapper();
		System.out.println("Enter number of stock");
		int number = Utility.getInteger();
		Stock stocknew = new Stock();
		for (int i = 0; i < number; i++) {
			stocknew = stockMethod();
			stockfolio.getStockList().add(stocknew);
		}
		map.writeValue(new File("/home/bridgeit/Documents/Docs/stock.json"), stockfolio);
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("/home/bridgeit/Documents/Docs/stock.json"));
		JSONObject jsonObject = (JSONObject) obj;
		System.out.println(jsonObject);
		JSONArray array = (JSONArray) jsonObject.get("stockList");
		for (int i = 0; i < array.size(); i++) {
			JSONObject obstock = (JSONObject) (array.get(i));
			sumStock += ((long) obstock.get("stockNumber")) * ((long) obstock.get("stockPrice"));
			totalStock += (long) obstock.get("stockNumber");
		}
		System.out.println(sumStock);
		System.out.println(totalStock);
	}

	public static Stock stockMethod() {
		Stock stock = new Stock();
		System.out.println("Enter the stock name");
		String name = Utility.getString();
		stock.setStockName(name);
		System.out.println("Enter number of shares");
		int share = Utility.getInteger();
		stock.setStockNumber(share);
		System.out.println("enter price per share");
		int price = Utility.getInteger();
		stock.setStockPrice(price);
		return stock;
	}
}