package com.bridgelabz.oops;

import com.bridgelabz.Utility.Utility;

public class Management {

	private Long p_mobileNum;
	private int p_id;
	private String p_name;
	private int p_age;
	private String d_name;
	private int d_id;
	private String specialization;
	private String availabilty;

	public String toString() {
		return "patients: [id=" + p_id +"  pname="+ p_name +"age= " + p_age +" mobile= " + p_mobileNum +" ]";
	}
	
	// method to add patient information
	@SuppressWarnings("unused")
	public void addPatient() {
		System.out.println("Enter your details:");

		System.out.println("Enter id:");
		int p_id = Utility.getInteger();
		System.out.println();

		System.out.println("Enter name:");
		String p_name = Utility.getString();
		System.out.println();

		System.out.println("Enter age:");
		this.p_age = Utility.getInteger();
		System.out.println();

		System.out.println("Enter mobile number:");
		this.p_mobileNum = Utility.getlong();
	}
	
	public String toString1() {
		return "doctor:[id=" + d_id + " name=" + d_name + " specialization=" + specialization + " availability="
				+ availabilty + "]";
	}

	// method to add doctors information
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
