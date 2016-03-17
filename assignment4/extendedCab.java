//file: Assignment 3
//Author:Damon WIngo
//Purpose: added functionality to taxi
package edu.trident.wingo.assignment4;


class extendedCab extends taxi_Cab 

{
         static double mss;
         double mainCost;
         double net;
         final double service = 25.00;
         double iGas;
		
         public extendedCab(double startGas) 
		 {
				
		    iGas = startGas;
			super.setGas(iGas);
			mss = 0;
			mainCost = 0;
			
		 }

      	
      	
 
     	
         public int recordTrip(double miles)
         {
        	 int go = super.recordTrip(miles);
        	 if(go == 1)
        	 {
        		 mss += miles;
        
        	 }
        	 return go;
        	 
         }
		 public void service()
		 {
			 
			  mainCost = (mainCost + service);
			  mss = 0;
		 }
		 public double getNetEarnings()
		  {
			  net = (totalFare - mainCost);
			  return net;
			  
		  }
		  protected static double getMSS()
		  {
			  return mss;
		  }
		  
		  
		  protected void gasCost(double perGal, double addGas)
		  {
			  double price = perGal;
			  double curGas; 
			  double prevGas = getGas();
			  super.addGas(addGas);
			  
			  curGas = super.getGas();
		      mainCost += (price * (curGas - prevGas));
			 
		  }
	
		  
		 public void reset()
		  {
			  super.reset();
			  mainCost = 0;
			  net = 0;
		  }

	
	

}
