//file: Assignment 3
//Author:Damon WIngo
//Purpose: Console template
package edu.trident.wingo.assignment4;

import javax.swing.*;



import java.awt.*;

public class taxi_UI extends JFrame 
{

	/**
	 * ,\
	 */
	private static final long serialVersionUID = 1L;
	//JFrame components
	
	JButton ok = new JButton ("Enter");
	
	final int width = 475;
	final int height = 225;
	
	

	extendedCab ecab;
	
	protected  taxi_UI(extendedCab e)
	{
		
	super("Acme Taxi Co.");
	ecab = e;
    setSize(width,height);
	setLayout(new FlowLayout());
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
			
			
		
}


	


