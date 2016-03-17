package edu.trident.wingo.assignment5;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CabSort  implements CabRecord

{
	
	private Date date;
	private static String CabID;
	private RecordType type;
	private double amount;
	private double cost;
	private int totalServices;
	//private double gross = FareRecords.getGrossEarned();
	
	FareRecords fare;
	ServiceRecords service;
	GasRecords gas;

	
	public CabSort(String date, String CabID, String type, String amount, String cost) throws ParseException
	{
	
		SimpleDateFormat now = new SimpleDateFormat("yyyy/MM/dd");
		this.date = now.parse(date);
		this.CabID = CabID;
		this.type = RecordType.valueOf(type);
		this.amount = Double.parseDouble(amount);
		this.cost = Double.parseDouble(cost);
		/*fare = new FareRecords(CabID,amount);
		fares.add(fare);
		service = new ServiceRecords(CabID,date,amount);
		services.add(service);
		gas = new GasRecords(CabID,amount,cost);
		fuel.add(gas);*/
						
	}
	
	
	
	@Override
	public RecordType getType() 
	{
		return type;
	}

	public Date getDate() {
		
		return date;
	}

	public String getCabId() {
		
		return CabID;
	}

	@Override
	public double getValue() {
	
		return amount;
	}

	@Override
	public double getPerGallonCost() {
	
		return cost;
	}
	
	

}


