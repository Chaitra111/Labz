package com.bridgelabz.Extra;

import com.bridgelabz.Utility.Utility;

public class Calenderq {

	public static void main(String[] args) {
		Utility u=new Utility();
		int m = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		MyQueue a[][] = new MyQueue[6][];
		for (int i = 0; i < 6; i++) {
			a[i] = new MyQueue[7];
			for (int j = 0; j < 7; j++) {
				a[i][j] = new MyQueue();
			}
		}
		int d = 1;
		String[] months = { " ", "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String[] days = { " S", " M", " T", " W", "Th", " F", " S" };
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				a[i][j].enqueue("  ");
			}
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (u.dateValidator(d, m, y)) {
					j = (int) u.day(d, m, y);
					if (d < 10) {
						a[i][j].dequeue();
						a[i][j].enqueue(" " + d);
						d++;
					} else {
						a[i][j].dequeue();
						a[i][j].enqueue("" + d);
						d++;
					}
				}
			}
		}
		System.out.println(months[m] + " " + y);
		System.out.println();
		for (int i = 0; i < 7; i++) {
			System.out.print(days[i] + "  ");
		}
		System.out.println();
		System.out.println("--------------------------");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(a[i][j].dequeue() + "  ");
			}
			System.out.println();
		}

	}
}