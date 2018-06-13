package com.bridgelabz.DesignPatterns;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.Utility.Utility;

public class Employees implements Cloneable{

	private List<String> empList;

	public Employees() {
		empList = new ArrayList<String>();
	}

	public Employees(List<String> list) {
		this.empList = list;
	}

	public void loadData() {
		// read all employees from database and put into the list
		System.out.println("enter the number of persons to add a group");
		int n = Utility.getInteger();
		System.out.println("enter the names");
		for (int i = 0; i < n; i++) {
			empList.add(Utility.getString());
			}
	}

	public List<String> getEmpList() {
		return empList;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		List<String> temp = new ArrayList<String>();
		for (String s : this.getEmpList()) {
			temp.add(s);
		}
		return new Employees(temp);
	}
}