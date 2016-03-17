//file: Assignment 3
//Author:Damon WIngo
//Purpose: Manager User interface

package edu.trident.wingo.assignment4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class managerConsole extends taxi_UI implements MaintenanceListener, ActionListener, ItemListener
{

	ButtonGroup manageGroup = new ButtonGroup();
	JLabel output = new JLabel("Output here");
	JLabel warning = new JLabel("");
	JLabel serviceInfo = new JLabel("");
	JRadioButton milesDriven = new JRadioButton("Miles Driven");
	JRadioButton grossEarnings = new JRadioButton("Gross Earnings");
	JRadioButton MSS = new JRadioButton("Miles since service");
	JRadioButton netEarnings = new JRadioButton("Net Earnings");
	JRadioButton reset = new JRadioButton("Reset");
	JButton override = new JButton ("Override fare");
	JTextField exit = new JTextField(10);

	private static final long serialVersionUID = 1L;

	protected managerConsole(extendedCab e)
	{
		super(e);
		manageGroup.add(grossEarnings);
		manageGroup.add(netEarnings);
		manageGroup.add(milesDriven);
		manageGroup.add(MSS);
		manageGroup.add(reset);
		add(ok);
		add(grossEarnings);
		add(netEarnings);
		add(milesDriven);
		add(MSS);
		add(reset);
		add(output);
		add(exit);
		add(override);
		add(warning);
		add(serviceInfo);
		exit.setEnabled(false);
		output.setEnabled(false);
		override.addActionListener(this);
		override.setEnabled(false);
		grossEarnings.addItemListener(this);
		netEarnings.addItemListener(this);
		reset.addItemListener(this);
		milesDriven.addItemListener(this);
		ok.addActionListener(this);
		
	}

	@Override
	public void showService(int service) {
		
			if (service == MaintenanceListener.serviceRequired)
			{
				override.setEnabled(true);
			    serviceInfo.setText("Service is required.\n");
				
			}
			else if (service == MaintenanceListener.servicePerformed)
			    serviceInfo.setText(" Service performed ");
			
		}
		// TODO Auto-generated method 
	public void itemStateChanged(ItemEvent a)
	{
		Object here = a.getSource();
	    if (here == milesDriven)
		{
			output.setText("total miles");
			exit.setText("");
		}
	
	 if (here == grossEarnings)
		{
			
			output.setText("gross earnings");
		}

	 if (here == MSS)
		{
		output.setText("miles since service");
		exit.setText("");
		}
	 if (here == netEarnings)
		{
		
		output.setText("Net Earnings");
		
		}
	 if (here == reset)
		{
		
		output.setText("");
		exit.setText("");
		}
		else
			warning.setText("");
	}

public void actionPerformed(ActionEvent e)
{
	DecimalFormat aFormat = new DecimalFormat("###.00");
	Object source = e.getSource();
	
	if(source == ok)
	{
		if (milesDriven.isSelected())
		{
			double miles = ecab.getTotalMIles();
			exit.setText("" +aFormat.format(miles));
			
		}
		
		else if (grossEarnings.isSelected())
		{
			double grossE = ecab.getGrossEarnings();
			exit.setText(""+aFormat.format(grossE));
		}
	
		
		else if (MSS.isSelected())
			{
			double milesSince = extendedCab.getMSS();
			exit.setText(""+aFormat.format(milesSince));
			}
		
		else if (netEarnings.isSelected())
		{
			double earnings = ecab.getNetEarnings();
			exit.setText(""+aFormat.format(earnings));
	
		}
		else if (reset.isSelected())
		{
			ecab.reset();
			warning.setText("");
		}
		
	}
	if (source == override)
	{
		int allow = 1;
		ecab.setOverride(allow);
	}
 } 
	
}
	







