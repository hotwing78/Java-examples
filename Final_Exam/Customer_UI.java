package edu.trident.wingo.Final_Exam;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

import javax.swing.*;

import edu.trident.wingo.Final_Exam.Products.Items;
;

public class Customer_UI extends Machine_Screen implements ActionListener,ItemListener {

	private static final long serialVersionUID = 1L;
		DecimalFormat aFormat = new DecimalFormat("###.00");
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
		ButtonGroup productGroup = new ButtonGroup();
		JTextField money = new JTextField(6);
		JLabel greetings = new JLabel("Hello, please make a selection");
		JLabel payment = new JLabel("Enter payment");
		JLabel changePrice = new JLabel("Look ");
		JRadioButton candy= new JRadioButton("Candy");
		JRadioButton chips = new JRadioButton("Chips");
		JRadioButton crackers =  new JRadioButton("Crackers");
		JRadioButton cookies = new JRadioButton("Cookies");
		double change;
		double price;
		int sold;
		Items item = null;
		
		
		
		
	protected Customer_UI(Vending_Machine_Smarts v){
		super(v);
		add(greetings);
		productGroup.add(candy);
		add(candy);
		productGroup.add(chips);;
		add(chips);
		productGroup.add(crackers);
		add(crackers);
		productGroup.add(cookies);
		add(cookies);
		add(ok);
		add(payment);
		add(money);
		candy.addItemListener(this);
		chips.addItemListener(this);
		cookies.addItemListener(this);
		crackers.addItemListener(this);
		ok.addActionListener(this);
		add(changePrice);
		setLayout(new FlowLayout());
		
	}

	public void itemStateChanged(ItemEvent a){
		 Object here = a.getSource();
		 	if (here == candy){
		 		item = item.CANDY;
		 		price = mech.getItemPrice(item);
		 		changePrice.setText(""+ item +" $"+ aFormat.format(price));
		 	
		 	}
		 	if (here == chips){	
		 		item = item.CHIPS;
		 		price = mech.getItemPrice(item);
		 		changePrice.setText(""+ item +" $"+ aFormat.format(price));
		 	}
		 	if (here == crackers){
		 		item = item.CRACKERS;
		 		price = mech.getItemPrice(item);
		 		changePrice.setText(""+ item +" $"+ aFormat.format(price));
		 	}
		 	if (here == cookies){	
		 		item = item.COOKIES;
		 		price = mech.getItemPrice(item);
		 		changePrice.setText(""+ item +" $"+ aFormat.format(price));
		 	}
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
			if(source == ok){
				if(candy.isSelected()){
					double p = Double.parseDouble(money.getText());
					Items item = Items.CANDY;
					sold = mech.sale(item, p); 
					double change = mech.getChange();
					changePrice.setText(item +" sold; change: $" + aFormat.format(change));
				}
				else if(chips.isSelected()){
					double p = Double.parseDouble(money.getText());
					Items item = Items.CHIPS;
					 sold = mech.sale(item,p);
					double change = mech.getChange();
					changePrice.setText(item +" sold; change: $" + aFormat.format(change));
					
				}
				else if(crackers.isSelected()){
					double p = Double.parseDouble(money.getText());
					Items item = Items.CRACKERS;
					 sold = mech.sale(item,p); 
					double change = mech.getChange();
					changePrice.setText(item +" sold; change: $" + aFormat.format(change));
				}
				else if(cookies.isSelected()){
					double p = Double.parseDouble(money.getText());
					Items item = Items.COOKIES;
					sold = mech.sale(item,p); 
					double change = mech.getChange();
					changePrice.setText(item +" sold; change: $" + aFormat.format(change));
				}
			}
	
		
	}


}

