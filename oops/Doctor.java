package com.bridgelabz.oops;

import com.bridgelabz.Utility.Utility;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose :
 */
public class Doctor {

	private int d_id;
	private String d_name;
	private String specialization;
	private String availabilty;

	// get the doctor id
	public int getDid() {
		return d_id;
	}

	// set doctor id
	public void setDid(int did) {
		this.d_id = did;
	}

	// get doctor name
	public String getDname() {
		return d_name;
	}

	// set doctor name
	public void setDname(String dname) {
		this.d_name = dname;
	}

	// get doctor specialization
	public String getDspecialization() {
		return specialization;
	}

	// set doctor specialization
	public void setDaspecialization(String dspecialization) {
		this.specialization = dspecialization;
	}

	// get doctors availability
	public String getDavailability() {
		return availabilty;
	}

	// set doctor specialization
	public void setDavailability(String availabilty) {
		this.availabilty = availabilty;
	}

	// toString method
	public String toString() {
		return "doctor:[id=" + d_id + " name=" + d_name + " specialization=" + specialization + " availability="
				+ availabilty + "]";
	}
	public void addDoctor() {
		System.out.println("Enter your details:");

		System.out.println("Enter id:");
		this.d_id = Utility.getInteger();
		System.out.println();

		System.out.println("Enter name:");
		this.d_name = Utility.getString();
		System.out.println();

		System.out.println("Enter age:");
		this.specialization = Utility.getString();
		System.out.println();

		System.out.println("Enter mobile number:");
		this.availabilty = Utility.getString();
	}
}