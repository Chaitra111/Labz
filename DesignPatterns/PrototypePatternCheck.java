package com.bridgelabz.DesignPatterns;

import java.util.List;

import com.bridgelabz.Utility.Utility;

public class PrototypePatternCheck {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Employees emps = new Employees();
		emps.loadData();

		// Use the clone method to get the Employee object
		Employees empsNew = (Employees) emps.clone();
		List<String> list = empsNew.getEmpList();
		System.out.println("enter the no.of names to add to a group");
		int n = Utility.getInteger();
		for (int i = 0; i < n; i++) {
			list.add(Utility.getString());
			System.out.println("empsNew List: " + list);
		}
		List<String> list1 = empsNew.getEmpList();
		System.out.println("enter the no.of names to remove from a group");
		int m = Utility.getInteger();
		for (int j = 0; j < m; j++) {
			list.remove(Utility.getString());
			System.out.println("empsNew List: " + list1);
		}
	}
}