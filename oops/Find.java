 package com.bridgelabz.oops;

import java.util.ArrayList;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose :
 */
public class Find {

	// search doctor by id
	public ArrayList<Doctor> findById(ArrayList<Doctor> a1, int did) {
		ArrayList<Doctor> temp = new ArrayList<Doctor>();
		for (Doctor d : a1) {
			if (d.getDid() == did) {
				temp.add(d);
			}
		}
		return temp;
	}

	public ArrayList<Doctor> findByName(ArrayList<Doctor> a1, String name) {
		ArrayList<Doctor> temp = new ArrayList<Doctor>();
		for (Doctor d : a1) {
			if (d.getDname() == name) {
				temp.add(d);
			}
		}
		return temp;
	}

	public ArrayList<Doctor> findByAvailability(ArrayList<Doctor> a1, String availabilty) {
		ArrayList<Doctor> temp = new ArrayList<Doctor>();
		for (Doctor d : a1) {
			if (d.getDavailability() == availabilty) {
				temp.add(d);
			}
		}
		return temp;
	}

	public ArrayList<Patient> findByPid(ArrayList<Patient> p1, int pid) {
		ArrayList<Patient> temp = new ArrayList<Patient>();
		for (Patient d : p1) {
			if (d.getPid() == pid) {
				temp.add(d);
			}
		}
		return temp;
	}

	public ArrayList<Patient> findByPname(ArrayList<Patient> p1, String name) {
		ArrayList<Patient> temp = new ArrayList<Patient>();
		for (Patient p : p1) {
			if (p.getPname() == name) {
				temp.add(p);
			}
		}
		return temp;
	}
	public ArrayList<Patient> findByPnumber(ArrayList<Patient> p1, long number) {
		ArrayList<Patient> temp = new ArrayList<Patient>();
		for (Patient d : p1) {
			if (d.getPnumber() == number) {
				temp.add(d);
			}
		}
		return temp;
	}
}