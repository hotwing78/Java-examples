//file: Assignment 3
//Author:Damon WIngo
//Purpose: Taxi User interface
package edu.trident.wingo.assignment4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class taxiConsole extends taxi_UI implements  ActionListener, ItemListener, MaintenanceListener
{

	
	ButtonGroup taxiGroup = new ButtonGroup();
    JRadioButton record = new JRadioButton("Record Trip");
	JRadioButton addGas = new JRadioButton("Add Gas");
	JRadioButton availableGas = new JRadioButton ("Gas in Tank");
	JRadioButton milesLeft = new JRadioButton("Miles Remaining");
	JRadioButton service = new JRadioButton("Service");
	JLabel input = new JLabel("Input here");
	JLabel output = new JLabel("Output here");
	JLabel warning = new JLabel("");
	JLabel serviceInfo = new JLabel("");
	JTextField enter = new JTextField(10);
	JTextField exit = new JTextField(10);
	JTextField gallonCost = new JTextField(5);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected taxiConsole(extendedCab e)
	{
		super(e);
		taxiGroup.add(record);
		taxiGroup.add(addGas);
		taxiGroup.add(availableGas);
		taxiGroup.add(milesLeft);
		taxiGroup.add(service);
		add(ok);
		add(input);
		add(enter);
		add(output);
		add(exit);
		add(record);
		add(addGas);
		add(availableGas);
		add(milesLeft);
		add(service);
		add(warning);
		add(gallonCost);
		add(serviceInfo);
		service.addItemListener(this);
		gallonCost.setVisible(false);
		addGas.addItemListener(this);
		record.addItemListener(this);
		availableGas.addItemListener(this);
		milesLeft.addItemListener(this);
		exit.setEnabled(false);
		ok.addActionListener(this);
	}
	@Override
	public void showService(int service) {
		
			if (service == MaintenanceListener.serviceRequired)
			{
	
			    serviceInfo.setText("Service is required.\n");
				
			}
			if (service == MaintenanceListener.servicePerformed)
			{
			    serviceInfo.setText("Service performed ");
			}
			
		}

		public void itemStateChanged(ItemEvent a)
		{
			Object here = a.getSource();
			if(here == record)
				{
					input.setText("Enter Miles:");
					enter.setText("");
					output.setText("");
					exit.setText("");
				}
			
		    if(here == addGas)
					{
					enter.setText("");
					input.setText("Gas Added:");
					output.setText("Gas in Tank");
					warning.setText("Enter cost per gallon");
					gallonCost.setVisible(true);
					}
					else
					{
					gallonCost.setVisible(false);
					warning.setText("");
					}
			
			 if (here == availableGas)
				{
					input.setText("");
					enter.setText("");
					output.setText("gas in tank");
					exit.setText("");
				}
			
			 if (here == milesLeft)
				{
					input.setText("");
					enter.setText("");
					output.setText("miles available");
					exit.setText("");
					
				}
			
			 if (here == service)
				{
					input.setText("");
					enter.setText("");
					output.setText("");
					serviceInfo.setText("");
					warning.setText("");
					exit.setText("");
				}
			
		}



	

		
		public void actionPerformed(ActionEvent e)
		{
			DecimalFormat aFormat = new DecimalFormat("###.00");
			Object source = e.getSource();
			
			if(source == ok)
			{
				if(record.isSelected())
				{	
					double miles = Double.parseDouble(enter.getText());
					int trip = ecab.recordTrip(miles);
					double fare = ecab.getFare();
					
					if(trip != -1)
					{
					output.setText("Fare");
					exit.setText(""+ aFormat.format(fare));
					enter.setText("");
					
					}
					else 
					
						warning.setText("Cannot accept fare");
						serviceInfo.setText("fuel required");
			
				}
				
				else if (addGas.isSelected())
						{
							double addGas = Double.parseDouble(enter.getText());
							double perGallon= Double.parseDouble(gallonCost.getText());
							ecab.gasCost(perGallon,addGas);
							double gas = ecab.getGas();
							exit.setText("" + aFormat.format(gas));
							
						}
				
				else if (availableGas.isSelected())
					    {
						double gas = ecab.getGas();
						exit.setText("" +aFormat.format(gas));
						}
				
				else if (milesLeft.isSelected())
					    {
						double miles = ecab.getMilesLeft();
						exit.setText(""+aFormat.format(miles));
						}
				
				else if (service.isSelected())
						{
					    ecab.service();
					    warning.setText("");
					    serviceInfo.setText("");
				        }
			}
			

	

		}


		
}
