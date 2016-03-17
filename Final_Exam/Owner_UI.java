package edu.trident.wingo.Final_Exam;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

import javax.swing.*;

import edu.trident.wingo.Final_Exam.Products.Items;

public class Owner_UI extends Machine_Screen implements ItemListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
	ButtonGroup  manageGroup = new ButtonGroup();
	ButtonGroup typeGroup = new ButtonGroup();
	JLabel greeting =  new JLabel("HELLO what can we accomplish?");
	JLabel report = new JLabel("");
	JRadioButton dailyGross = new JRadioButton ("Total Earnings");
	JRadioButton mostSold = new JRadioButton ("Highest selling product");
	JRadioButton addStock = new JRadioButton ("Add Stock");
	JRadioButton amountSold = new JRadioButton ("Products sold");
	JRadioButton candy= new JRadioButton("Candy");
	JRadioButton chips = new JRadioButton("Chips");
	JRadioButton crackers =  new JRadioButton("Crackers");
	JRadioButton cookies = new JRadioButton("Cookies");
	JTextField input = new JTextField(6);
	Items typeOfStock = null;
	
	protected Owner_UI(Vending_Machine_Smarts v){

		super(v);
		manageGroup.add(dailyGross);
		manageGroup.add(mostSold);
		manageGroup.add(amountSold);
		manageGroup.add(addStock);
		typeGroup.add(candy);
		typeGroup.add(crackers);
		typeGroup.add(chips);
		typeGroup.add(cookies);
		add(greeting);
		add(addStock);
		add(mostSold);
		add(dailyGross);
		add(amountSold);
		candy.setVisible(false);
		crackers.setVisible(false);
		chips.setVisible(false);
		cookies.setVisible(false);
		dailyGross.addItemListener(this);
		mostSold.addItemListener(this);
		amountSold.addItemListener(this);
		addStock.addItemListener(this);
		ok.addActionListener(this);
		add(ok);
		add(input);
		add(report);
		add(candy);
		add(crackers);
		add(chips);
		add(cookies);

		setLayout(new FlowLayout());
	}

	@Override
	public void itemStateChanged(ItemEvent a) {

		Object here = a.getSource();
		if(here == addStock){
			candy.setVisible(true);
			crackers.setVisible(true);
			chips.setVisible(true);
			cookies.setVisible(true);
			report.setText("Select item to restock, enter amount then press Enter");
		}
		if(here == mostSold){
			candy.setVisible(false);
			crackers.setVisible(false);
			chips.setVisible(false);
			cookies.setVisible(false);
			report.setText("");
		}
		if(here == dailyGross){
			candy.setVisible(false);
			crackers.setVisible(false);
			chips.setVisible(false);
			cookies.setVisible(false);
			report.setText("");
		}
		if(here == amountSold){
			candy.setVisible(true);
			crackers.setVisible(true);
			chips.setVisible(true);
			cookies.setVisible(true);
			report.setText("Select item for amount sold");
		}


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DecimalFormat aFormat = new DecimalFormat("###.00");
		Object source = e.getSource();

		if(source == ok){
			if(addStock.isSelected()){
				int stock = Integer.parseInt(input.getText());
				input.setVisible(true);
				if(cookies.isSelected()){
					typeOfStock = Items.COOKIES;
				}
				if(chips.isSelected()){
					typeOfStock = Items.CHIPS;
				}
				else if(candy.isSelected()){
					typeOfStock = Items.CANDY;
				}
				else if(crackers.isSelected()){
					typeOfStock = Items.CRACKERS;
				}
				mech.addStock(stock, typeOfStock);
				report.setText(stock + " " + typeOfStock +" added" + mech.getItemStock(typeOfStock)+ " available");
			}
			if(dailyGross.isSelected()){
				double gross = mech.getTotalSales();
				input.setVisible(false);
				report.setText("Total of sales : $"+ aFormat.format(gross));
			}
			if(amountSold.isSelected()){
				input.setVisible(false);
				if(cookies.isSelected()){
					typeOfStock = Items.COOKIES;
				}
				if(chips.isSelected()){
					typeOfStock = Items.CHIPS;
				}
				else if(candy.isSelected()){
					typeOfStock = Items.CANDY;
				}
				else if(crackers.isSelected()){
					typeOfStock = Items.CRACKERS;
				}
				int sold = mech.getTotalItemSold(typeOfStock);
				report.setText(""+typeOfStock +":"+sold);
			}
			if(mostSold.isSelected())
				input.setVisible(false);
				report.setText(mech.getMostSold());
		}
	}

}



