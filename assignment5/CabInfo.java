package edu.trident.wingo.assignment5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import edu.trident.wingo.assignment5.CabRecord.RecordType;




public class CabInfo implements Comparable <CabInfo>{

	ArrayList<FareRecords> faresList = new ArrayList<FareRecords>();
	ArrayList<ServiceRecords> servicesList = new ArrayList<ServiceRecords>();
	ArrayList<GasRecords> gasList = new ArrayList<GasRecords>();
	String CabId;
	FareRecords fares;
	ServiceRecords services;
	GasRecords gas;
	int compareDates;
	public static final Comparator<GenericCabRecord> COMPARE_DATE = new Comparator<GenericCabRecord>(){
		public int compare(GenericCabRecord arg0, GenericCabRecord arg1) {
			return arg0.getDate().compareTo(arg1.getDate());
		}
		
		};

	public CabInfo (String CabId){
	   
		this.CabId = CabId;
		services.getServiceCostTotal();
		
		
	}
	

	public String getCabId() {
		return CabId;
	}
	
	public void addGas(GasRecords something){
		gasList.add(something);
	}
	
	public void addService(ServiceRecords something){
		servicesList.add(something);
	}
	
	public void addFare(FareRecords something){
		
		faresList.add(something);
	}
	
	public void getFirstDate(Date d1, Date d2)
	{
		Date firstDate;
		d1 = fares.getDate();
		d2 = services.getDate();
		if(COMPARE_DATE.compare(d1, d2) > 1){
			firstDate = d1;
		}
		
	}
	
	public void getLastDate()
	{
		faresList.size();
		
	}
	
	public void getTotalServices(){
		String cab = null;
		int serviceCount = 0;
		for(int i = 0; i >= servicesList.size(); i++)
		{
			if(services.getCabId().equals(servicesList.get(i).getCabId()))
			{
				faresList.size();
			}
		}
	}

	public long countDays(Date d1, Date d2)
	{
		final long LENGTH_OF_DAY = 24 * 60 * 60 * 1000;
		long dayDifference = 0;
		
		long t1;
		long t2;

		t1 = d1.getTime();
		t2 = d2.getTime();
		
		long diff = t2 - t1;
		
		dayDifference = (diff/LENGTH_OF_DAY);
		
		return dayDifference;
	}

	
	public void sortList(){
		Collections.sort(faresList,COMPARE_DATE);
		Collections.sort(gasList,COMPARE_DATE);
		Collections.sort(servicesList,COMPARE_DATE);
	}


	@Override
	public int compareTo(CabInfo arg0) {
		
		return CabId.compareTo(arg0.getCabId());
	}
	
}



