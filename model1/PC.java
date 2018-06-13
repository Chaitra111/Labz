package com.bridgelabz.model1;

public class PC  extends Computer{

	private String keyboard;
	private String display;
	private String cpu;

	public PC(String keyboard, String display, String cpu) {
		this.keyboard = keyboard;
		this.display = display;
		this.cpu = cpu;
	}

	public String getKEYBOARD() {
		return this.keyboard;
	}

	public String getDISPLAY() {
		return this.display;
	}

	public String getCPU() {
		return this.cpu;
	}
}