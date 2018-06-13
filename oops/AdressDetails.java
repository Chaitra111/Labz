package com.bridgelabz.oops;

import org.json.simple.JSONObject;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose :
 */
public class AdressDetails {

	String firstname;
	String lastname;
	String address;
	String city;
	String state;
	String zip;
	String phoneNum;
	
	public AdressDetails(String firstname,String lastname,String address,String city,String state,String zip,String phoneNum) {
		this.firstname=firstname;
		this.lastname=lastname;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phoneNum=phoneNum;
	}
	
	public JSONObject toJsonObject() {
		JSONObject jsonobject=new JSONObject();
		jsonobject.put("First Name", firstname);
		jsonobject.put("Last Name", lastname);
		jsonobject.put("Address", address);
		jsonobject.put("City", city);
		jsonobject.put("State",state);
		jsonobject.put("Zip",zip);
		jsonobject.put("Phone Number",phoneNum);
		return jsonobject;
		
	}
}
