package edu.trident.wingo.Final_Exam;

import java.awt.FlowLayout;

import javax.swing.*;



public class Machine_Screen extends JFrame  {
	
JButton ok = new JButton ("Enter");
	
	final int width = 475;
	final int height = 225;
	Vending_Machine_Smarts mech;
	
	protected  Machine_Screen(Vending_Machine_Smarts v)
	{
	 super("Junk Food Central");
	 mech = v;
    setSize(width,height);
	setLayout(new FlowLayout());
	setVisible(true);
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}


}
