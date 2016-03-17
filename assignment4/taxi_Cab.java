//file: Assignment 3
//Author:Damon WIngo
//Purpose: Taxi Cab methods

package edu.trident.wingo.assignment4;



public class taxi_Cab 
{
	
	
	//variables
	protected static double gas;
	protected double miles;
	protected double fare;
	protected final double mpg= 17.6;
	protected final double flatFare = 2.00;
	protected final double mileFare = 0.585;
	private final double FUEL_CAPACITY = 22.9;
	protected double totalFare;
	protected double totalMiles;
	private double override;
	private MaintenanceListener listeners[] = new MaintenanceListener[10];
 	private int numListeners = 0;

	
	public taxi_Cab()
	{
	    override = 0;
		fare = 0;
		
	}
  	
	public void addListener(MaintenanceListener listener)
  	{
  		this.listeners[numListeners] = listener;
  		numListeners++;
  	}
  	
	
	//Taxi processing

	public int recordTrip(double tripMiles)
	{
		miles = tripMiles;
		 double milesAvailable;
		milesAvailable = (gas * mpg);
		
		if (override == 1)
		{
			fare = flatFare + (mileFare * miles);
			milesAvailable = (milesAvailable - miles);
			gas = (milesAvailable/mpg);
			totalFare += fare;
			totalMiles += miles;
			override = 0;
			for (int i = 0; i < numListeners; i++)
			        listeners[i].showService(MaintenanceListener.serviceRequired);
			
			return 1;
		}
		else if(tripMiles > milesAvailable || extendedCab.getMSS() > 500)
		{
			
			if (extendedCab.getMSS() > 500)
  		    {
				
  		    	for (int i = 0; i < numListeners; i++)
  			        listeners[i].showService(MaintenanceListener.serviceRequired);
  		    }
			
			return -1;
		}
		else
		{
			fare = flatFare + (mileFare * miles);
			milesAvailable = (milesAvailable - miles);
			gas = (milesAvailable/mpg);
			totalFare += fare;
			totalMiles += miles;
			if (extendedCab.getMSS() == 0)
		    {
		  	for (int i = 0; i < numListeners; i++)
		        listeners[i].showService(MaintenanceListener.servicePerformed);
		    }
		
			
			return 1;
		}
	}
	
	
	 public void addGas(double gasFill)
	  {
		 	double fillUp;
		    fillUp = gasFill;
			if((gas + fillUp) > FUEL_CAPACITY)
			{
				gas = FUEL_CAPACITY;
			}
			
			else
			{
				 gas = (gas + fillUp);
			}
			
			
	  }
	  
	  public double getFare()
	  {
		  return fare;
	  }
	  
	 
	  public double getGas()
	  {
		  return gas;
	  
	  }
	  
	  public static void setGas(double igas)
	  {
		  gas = igas;
	  }
	  
	  public double getMilesLeft()
	  {
		  double milesAvailable;
		  milesAvailable = (gas*mpg);
		  return milesAvailable;
	  }
	  
	  public double getTotalMIles()
	  {
		  return totalMiles;
	  }
	  
	  public double getGrossEarnings()
	  {
		  return totalFare;
	  }
	  
	  public void reset()
	  {
		  totalFare = 0;
		  totalMiles = 0;
	  }

	public double getOverride() {
		return override;
	}

	public void setOverride(double override) {
		this.override = override;
	}

	
	
}
