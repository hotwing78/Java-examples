package edu.trident.wingo.assignment5;

import java.util.Date;



public class FareRecords extends GenericCabRecord  {

	private String CabID;
	private double fare;


	public FareRecords(String CabID, Date date, double fare){
		super(date);
		this.CabID = CabID;
		this.fare = fare;
		
	}

	public String getCabID() {
		return CabID;
	}

	public void setCabID(String cabID) {
		CabID = cabID;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}
	

}