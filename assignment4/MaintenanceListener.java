package edu.trident.wingo.assignment4;

public interface MaintenanceListener 
{
	final int serviceRequired = 1;
	final int servicePerformed = 2;
	
	public void showService(int service);
}
