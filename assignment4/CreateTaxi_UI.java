//file: Assignment 4
//Author:Damon WIngo
//Purpose: Create Taxi User interface and Taxi_Cab
package edu.trident.wingo.assignment4;

import javax.swing.JOptionPane;

public class CreateTaxi_UI 
{
  
	public static void main(String[] args) 
	{
		double startGas = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter current fuel lvl"));
		extendedCab ecab = new extendedCab(startGas);
		taxiConsole taxi = new taxiConsole(ecab);
		managerConsole manager = new managerConsole(ecab);
		ecab.addListener(taxi);
		ecab.addListener(manager);
		manager.setVisible(true);
		taxi.setVisible(true);
		// TODO Auto-generated method stub

	}

}

