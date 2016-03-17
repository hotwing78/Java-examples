package edu.trident.wingo.Final_Exam;

import java.awt.FlowLayout;

public class CreateMachine {

	public static void main(String[] args) {
		Vending_Machine_Smarts here = new Vending_Machine_Smarts();
		Customer_UI machine = new Customer_UI(here);
		Owner_UI owner = new Owner_UI(here);
		machine.setLayout(new FlowLayout());
		// TODO Auto-generated method stub

	}

}
