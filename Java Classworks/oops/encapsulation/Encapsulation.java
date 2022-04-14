package com.csscorp.oops.encapsulation;

public class Encapsulation {
	
	private int day;
	private int noOfTrainees;
	private String batchName;
	
		
	public Encapsulation(int day, int noOfTrainees, String batchName) {
		super();
		this.day = day;
		this.noOfTrainees = noOfTrainees;
		this.batchName = batchName;
	}
	public Encapsulation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getNoOfTrainees() {
		return noOfTrainees;
	}
	public void setNoOfTrainees(int noOfTrainees) {
		this.noOfTrainees = noOfTrainees;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	@Override
	public String toString() {
		return "Encapsulation [day=" + day + ", noOfTrainees=" + noOfTrainees
				+ ", batchName=" + batchName + "]";
	}
	
		
	

}
