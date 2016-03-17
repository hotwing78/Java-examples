package edu.trident.wingo.assignment5;

import java.util.Date;

public class GasRecords extends GenericCabRecord {
	
	private double perGallonCost;
	private double fuelAmount;
	private String cabID;
	

	public GasRecords(String cabID, Date date, double fuelAmount, double perGallon) {
		super(date);
		this.cabID = cabID;
		this.fuelAmount = fuelAmount;
		this.perGallonCost = perGallon;
	
		// TODO Auto-generated constructor stub
	}
	
	
	public double getPerGallonCost(){
		
		return perGallonCost;
	}

}
