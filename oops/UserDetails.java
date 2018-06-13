package com.bridgelabz.oops;

/**
 * @author Chaitra Ankolekar
 *  Date : 18/05/2018 
 *  Purpose :
 */
public class UserDetails {

	private String name;
	private long number;
	private ShareHolding sharedetails;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public long getNumber() {
		return number;
	}

	public void setShareDetails(ShareHolding sharedetails) {
		this.sharedetails = sharedetails;
	}

	public ShareHolding getShareDEtails() {
		return sharedetails;
	}
}
