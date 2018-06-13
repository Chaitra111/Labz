package com.bridgelabz.oops;

import java.util.ArrayList;

/**
 * @author Chaitra Ankolekar Date : 18/05/2018 Purpose :
 */
public class StockPortfolio {

	ArrayList<Stock> stocklist = new ArrayList<Stock>();

	public void setStockList(ArrayList<Stock> stockList) {
		this.stocklist = stockList;
	}

	public ArrayList<Stock> getStockList() {
		return stocklist;
	}
}
