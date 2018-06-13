 package com.bridgelabz.oops;

import java.util.Date;

public class Appointment {
	Integer d_id;
	Date date;

	// constructor
	public Appointment(int did, Date date) {
		this.d_id = did;
		this.date = date;
	}

	// getter and setter methods
	public int getDid() {
		return d_id;
	}

	public void setDid(int did) {
		this.d_id = did;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String toString() {
		return "Appointment [did=" + d_id + ", date=" + date + "]";
	}

	public int hashCode() {
		return this.d_id.hashCode() + this.date.hashCode();
	}

	// checking for equality
	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (object == this)
			return true;
		if (!(object instanceof Appointment))
			return false;

		Appointment dA = (Appointment) object;

		if ((this.d_id == dA.d_id) && (this.date.equals(dA.date)))
			return true;
		else
			return false;
	}
}