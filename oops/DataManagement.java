package com.bridgelabz.oops;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose :
 */
public class DataManagement {
	static int sum_rice = 0;
	static int total_rice = 0;
	static int sum_wheat = 0;
	static int total_wheat = 0;
	static int sum_pulses = 0;
	static int total_pulses = 0;
	static int total_value=0;

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("/home/bridgeit/Documents/Docs/ooops.json"));
			JSONObject jsonobject = (JSONObject) obj;
			JSONArray rice = (JSONArray) jsonobject.get("Rice");
			for (int i = 0; i < rice.size(); i++) {
				JSONObject objrice = (JSONObject) (rice.get(i));
				sum_rice += (Integer.parseInt(objrice.get("Weight").toString()))
						* (Integer.parseInt(objrice.get("Price").toString()));
				total_rice += (Integer.parseInt(objrice.get("Weight").toString()));
			}
			System.out.println(rice);
			System.out.println(sum_rice);
			System.out.println(total_rice);
			JSONArray wheat = (JSONArray) jsonobject.get("Wheat");
			for (int i = 0; i < wheat.size(); i++) {
				JSONObject objwheat = (JSONObject) (wheat.get(i));
				sum_wheat += (Integer.parseInt(objwheat.get("Weight").toString()))
						* (Integer.parseInt(objwheat.get("Price").toString()));
				total_wheat += (Integer.parseInt(objwheat.get("Weight").toString()));
			}
			System.out.println(wheat);
			System.out.println(sum_wheat);
			System.out.println(total_wheat);
			JSONArray pulses = (JSONArray) jsonobject.get("Pulses");
			for (int i = 0; i < pulses.size(); i++) {
				JSONObject objpulses = (JSONObject) (pulses.get(i));
				sum_pulses += (Integer.parseInt(objpulses.get("Weight").toString()))
						* (Integer.parseInt(objpulses.get("Price").toString()));
				total_pulses += (Integer.parseInt(objpulses.get("Weight").toString()));
			}
			total_value += ((long)(sum_rice+sum_wheat+sum_pulses));
			System.out.println(pulses);
			System.out.println(sum_pulses);
			System.out.println(total_pulses);
			System.out.println(total_value);
		} catch (IOException | org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}

	}
}
