package edu.trident.wingo.assignment5;

import java.text.ParseException;
import java.util.Date;

public class ServiceRecords extends GenericCabRecord {
	
	private Date date;
	private String cabID;
	private double serviceCost;
	private int totalServices;
	private double serviceCostTotal;
	public ServiceRecords(String cabID, Date date, double serviceCost) throws ParseException {
		
		super(date);
		this.date = date;
		this.cabID = cabID;
		this.serviceCost = serviceCost;
		setServiceCostTotal();
		// TODO Auto-generated constructor stub
	}
	
	public String getCabId(){
		return cabID;
	}
	private void setServiceCostTotal(){
		serviceCostTotal += serviceCost;
	}
	
	public double getServiceCostTotal(){
		
		return serviceCostTotal;
	}
	
	public double getServiceCost(){
		return serviceCost;
	}

}