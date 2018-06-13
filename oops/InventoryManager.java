package com.bridgelabz.oops;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
public class InventoryManager {
		
	static int value = 0;
	static int sumRice = 0;
	static int totalRice = 0;
	static int sumWheat = 0;
	static int totalWheat = 0;
	static int sumPulses = 0;
	static int totalPulses = 0;
	static int total_value = 0;

	public static Product productMethod() {
		Product product = new Product();
		System.out.println("Enter the type of product");
		String type = Utility.getString();
		product.SetType(type);
		System.out.println("Enter the weight of product");
		int weight = Utility.getInteger();
		product.setWeight(weight);
		System.out.println("Enter the price of product");
		int price = Utility.getInteger();
		product.setPrice(price);
		return product;
	}

	public static void main(String[] args) throws IOException, ParseException {
		Inventory invent = new Inventory();
		ObjectMapper map = new ObjectMapper();
		System.out.println("Enter how many types of rice");
		value = Utility.getInteger();
		Product product = new Product();
		for (int i = 0; i < value; i++) {
			product = productMethod();
			invent.getRiceList().add(product);
		}

		System.out.println("Enter how many types of wheat");
		value = Utility.getInteger();
		for (int i = 0; i < value; i++) {
			product = productMethod();
			invent.getWheatList().add(product);
		}

		System.out.println("Enter how many types of pulses");
		value = Utility.getInteger();
		for (int i = 0; i < value; i++) {
			product = productMethod();
			invent.getPulsesList().add(product);
		}
		map.writeValue(new File("/home/bridgeit/Documents/Docs/oops.json"), invent);
		// reading
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("/home/bridgeit/Documents/Docs/oops.json"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray rice1 = (JSONArray) jsonObject.get("riceList");
		for (int i = 0; i < rice1.size(); i++) {
			JSONObject objrice = (JSONObject) (rice1.get(i));
			sumRice += ((long) objrice.get("weight")) * (long) (objrice.get("price"));
			totalRice += (long) objrice.get("weight");
		}
		System.out.println(rice1);
		System.out.println(sumRice);
		System.out.println(totalRice);
		JSONArray wheat1 = (JSONArray) jsonObject.get("wheatList");
		for (int i = 0; i < wheat1.size(); i++) {
			JSONObject objwheat = (JSONObject) (wheat1.get(i));
			sumWheat += ((long) objwheat.get("weight")) * (long) (objwheat.get("price"));
			totalWheat += (long) objwheat.get("weight");
		}
		System.out.println(wheat1);
		System.out.println(sumWheat);
		System.out.println(totalWheat);
		JSONArray pulses1 = (JSONArray) jsonObject.get("pulsesList");
		for (int i = 0; i < pulses1.size(); i++) {
			JSONObject objpulses = (JSONObject) (pulses1.get(i));
			sumPulses += ((long) objpulses.get("weight")) * (long) (objpulses.get("price"));
			totalPulses += (long) objpulses.get("weight");
		}
		total_value += ((long) (sumRice + sumWheat + sumPulses));
		System.out.println(pulses1);
		System.out.println(sumPulses);
		System.out.println(totalPulses);
		System.out.println(total_value);
	}
}