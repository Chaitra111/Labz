package com.bridgelabz.oops;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose :
 */
public class Person {

	private String fname;
	private String lname;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String mobNum;

	public Person(String fname, String lname, String address, String city, String state, String zip, String mobNum) {
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.mobNum = mobNum;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return mobNum;
	}

	public void setPhone(String mobNum) {
		this.mobNum = mobNum;
	}
}
