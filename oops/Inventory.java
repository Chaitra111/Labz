package com.bridgelabz.oops;

import java.util.ArrayList;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose :
 */
public class Inventory {

		ArrayList<Product> riceList = new ArrayList<Product>();
		ArrayList<Product> wheatList = new ArrayList<Product>();
		ArrayList<Product> pulsesList = new ArrayList<Product>();
				 
		//return the riceList
		public ArrayList<Product> getRiceList() {
			return riceList;
		}
	
		//riceList the riceList to set
		public void setRiceList(ArrayList<Product> riceList) {
			this.riceList = riceList;
		}
		
		//return the wheatList
		public ArrayList<Product> getWheatList() {
			return wheatList;
		}
		
		// wheatList the wheatList to set
		public void setWheatList(ArrayList<Product> wheatList) {
			this.wheatList = wheatList;
		}
		
		//return the pulsesList
		public ArrayList<Product> getPulsesList() {
			return pulsesList;
		}
		
		//pulsesList the pulsesList to set
		public void setPulsesList(ArrayList<Product> pulsesList) {
			this.pulsesList = pulsesList;
		}

	}