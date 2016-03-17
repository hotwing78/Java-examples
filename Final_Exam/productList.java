package edu.trident.wingo.Final_Exam;

import edu.trident.wingo.Final_Exam.Products.Items;

public class productList {
	
private Items item;
private double price;
private int stock;

public productList(Items item, double price, int stock) {
	// TODO Auto-generated constructor stub
	this.item = item;
	this.price = price;
	this.stock = stock;
	}

public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}

public double getPrice() {
	return price;
}

public Items getItem() {
	return item;
}

public String toStringOwner(){
	  return (this.getItem()+" " + this.getPrice()+" "+ this.getStock());
}
@Override
public String toString() {
     return (this.getItem()+" " + this.getPrice());
}

public String getItemSelection(Items item) {
	if (item ==Items.valueOf("CANDY")){
		 return (this.getItem()+" " + this.getPrice());
	}
	else if(item == Items.valueOf("CHIPS")){
		 return (this.getItem()+" " + this.getPrice());
	}
	else if(item == Items.valueOf("CRACKERS"))
		 return (this.getItem()+" " + this.getPrice());
	else
		 return (this.getItem()+" " + this.getPrice());
}


}
