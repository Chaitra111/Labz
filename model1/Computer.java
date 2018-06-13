package com.bridgelabz.model1;

public abstract class Computer   {

	public abstract String getKEYBOARD();
	public abstract String getDISPLAY();
	public abstract String getCPU();
	
	@Override
	public String toString(){
		return "KEYBOARD= "+this.getKEYBOARD()+", DISPLAY="+this.getDISPLAY()+", CPU="+this.getCPU();
	}
}