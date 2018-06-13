package com.bridgelabz.oops;

import java.util.ArrayList;

/**
 * @author Chaitra Ankolekar 
 * Date : 18/05/2018 
 * Purpose :
 */
public class ShareHolding {

	ArrayList<CompanyShares> list = new ArrayList<>();

	public void setList(ArrayList<CompanyShares> list) {
		this.list = list;
	}

	public ArrayList<CompanyShares> getList() {
		return list;
	}
}
