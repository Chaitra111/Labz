package com.bridgelabz.oops;

import com.bridgelabz.Utility.Utility;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose :
 */
public class Patient {

	private int p_id;
	private String p_name;
	private int p_age;
	private long p_mobileNum;
	
	//get the patient id
	public int getPid(){
		return p_id;
	}
	
	//set patient id
	public void setPid(int pid) {
		this.p_id=pid;
	}
	
	//get patient name
	public String getPname() {
		return p_name;
	}
	
	//set patient name
	public void setPname(String pname) {
		this.p_name=pname;
	}
	
	//get age of patient
	public int getPage(){
		return p_age;
	}
	
	//set patient age
	public void setPage(int page) {
		this.p_age=page;
	}
	
	//get patient mobile number
	public long getPnumber() {
		return p_mobileNum;
	}
		
	//set patient mobile number
	public void setPnumber(long pmobilenum) {
		this.p_mobileNum = pmobilenum;
	} 
	
	//toString method 
	public String toString() {
		return "patients: [id=" + p_id +"  pname="+ p_name +"age= " + p_age +" mobile= " + p_mobileNum +" ]";
	}
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
}
