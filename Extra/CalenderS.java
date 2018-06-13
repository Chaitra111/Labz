package com.bridgelabz.Extra;

import com.bridgelabz.Utility.Utility;

public class CalenderS {
	public static void main(String[] args) {
		Utility u = new Utility();
		int m = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		MyStack first[][] = new MyStack[6][];
		for (int i = 0; i < 6; i++) {
			first[i] = new MyStack[7];
			for (int j = 0; j < 7; j++) {
				first[i][j] = new MyStack();
			}
		}

		MyStack a[][] = new MyStack[6][];
		for (int i = 0; i < 6; i++) {
			a[i] = new MyStack[7];
			for (int j = 0; j < 7; j++) {
				a[i][j] = new MyStack();
			}
		}
		int d = 1;
		String[] months = { " ", "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String[] days = { " S", " M", " T", " W", "Th", " F", " S" };
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				first[i][j].push("  ");
			}
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (Utility.dateValidator(d, m, y)) {
					j = (int) u.day(d, m, y);
					if (d < 10) {
						first[i][j].pop();
						first[i][j].push(" " + d);
						d++;
					} else {
						first[i][j].pop();
						first[i][j].push("" + d);
						d++;
					}
				}
			}
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				a[i][j].push(first[i][j].pop());
			}
		}

		// System.out.println("printing");
		// System.out.println(a[0][6].size());
		System.out.println(months[m] + " " + y);
		System.out.println();
		for (int i = 0; i < 7; i++) {
			System.out.print(days[i] + "  ");
		}
		System.out.println();
		System.out.println("--------------------------");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(a[i][j].pop() + "  ");
			}
			System.out.println();
		}
	}
}