package edu.trident.wingo.Final_Exam;

import java.util.ArrayList;
import java.util.List;


public class Vending_Machine_Smarts implements Products{
	Items item;
	String popularItem;
	double[] price = {.65,.85,.85,1.00};
	double saleTotal;
	double moneyRecieved;
	double change;
	ArrayList<productList> junk = new ArrayList<productList>();
	productList product;
	private int candyStock = 2;
	private int crackerStock = 2;
	private int cookieStock = 2;
	private int chipStock =2;
	//totals sold
	private int mostSold;
	private int candySoldTotal= 0;
	private int crackerSoldTotal = 0;
	private int chipsSoldTotal= 0;
	private int cookieSoldTotal = 0;
	public Vending_Machine_Smarts(){
		moneyRecieved= 0;
		product = new productList(item.CRACKERS,price[0], crackerStock);
		junk.add(product);
		product = new productList(item.COOKIES,price[1],cookieStock);
		junk.add(product);
		product = new productList(item.CHIPS,price[2],chipStock);
		junk.add(product);
		product = new productList(item.CANDY,price[3],candyStock);
		junk.add(product);
		
	}
	
	public int sale(Items item, double money){
		moneyRecieved = money;
	    this.item = item;
		int newStock = product.getStock();
		if(item == Items.valueOf("CANDY") && (moneyRecieved > price[3]) && candyStock >0){
			saleTotal += price[3];
			candySoldTotal++;
			if(candySoldTotal > mostSold){
				popularItem = "CANDY";
				mostSold = candySoldTotal;
			}
			newStock = candyStock - 1;
			change = moneyRecieved - price[3];
			product.setStock(newStock);
			return 1;
		}
		else if(item == Items.valueOf("CHIPS") && (moneyRecieved > price[2]) && chipStock > 0){
			saleTotal += price[2];
			chipsSoldTotal++;
			if(chipsSoldTotal > mostSold){
				popularItem = "CHIPS";
				mostSold = candySoldTotal;
			}
			newStock = candyStock - 1;
			change = moneyRecieved - price[2];
			product.setStock(newStock);
			return 1;
		}
		else if(item == Items.valueOf("CRACKERS") && (moneyRecieved > price[0]) && crackerStock > 0){
			saleTotal += price[0];
			crackerSoldTotal++;
			if(crackerSoldTotal > mostSold){
				popularItem = "CRACKERS";
				mostSold = candySoldTotal;
			}
			newStock = crackerStock - 1;
			change = moneyRecieved - price[0];
			product.setStock(newStock);
			return 1;
		}
		else if(item == Items.valueOf("COOKIES") && (moneyRecieved > price[1]) && cookieStock > 0){
			saleTotal += price[1];
			cookieSoldTotal++;
			if(cookieSoldTotal > mostSold){
				popularItem = "COOKIES";
				mostSold = candySoldTotal;
			}
			newStock = cookieStock - 1;
			change = moneyRecieved - price[1];
			product.setStock(newStock);
			return 1;
		}
		else 
			return -1;
		
	}

	
	public Items getItemSelection(Items item) {
		if (item ==Items.valueOf("CANDY")){
			return Items.CANDY;
		}
		else if(item == Items.valueOf("CHIPS")){
			return Items.CHIPS;
		}
		else if(item == Items.valueOf("CRACKERS"))
			return Items.CRACKERS;
		else
			return Items.COOKIES;
	}

	public double getItemPrice(Items item) {
		this.item = item;
		if(item == Items.CANDY){
			return price [3];
		}
		else if(item ==Items.COOKIES){
			return price [1];
		}
		else if(item ==Items.CHIPS){
			return price [2];
		}
		else 
			return price [0];
	}
	
	public void addStock(int add, Items typeOfStock){
		Items item = typeOfStock;
		if(item == Items.CANDY){
			 candyStock+=add;
			 if(candyStock > 4){
				 candyStock = 4;
			 }
		}
		else if(item ==Items.COOKIES){
			 cookieStock+=add;
			 if(cookieStock > 4){
				 candyStock = 4;
			 }
		}
		else if(item == Items.CHIPS){
			chipStock+= add;
			if(chipStock > 4){
				chipStock = 4;
			}
		}
		else
			 crackerStock+= add;
			if(crackerStock > 4){
				crackerStock = 4;
			}
		
	}
	public int getItemStock(Items item) {
		this.item = item;
		if(item == Items.CANDY){
		return candyStock;
		}
		else if(item ==Items.COOKIES){
			 return cookieStock;
		}
		else if(item == Items.CHIPS){
			return chipStock;
		}
		else
			return crackerStock;
		
	}

	public double getChange(){
		return change;
	}
	public void showStock(int stock) {
		// TODO Auto-generated method stub
		
	}

	public double getTotalSales(){
		return saleTotal;
	}
	
	public int getTotalItemSold(Items item){
		this.item = item;
		if(item == Items.CANDY){
			return candySoldTotal;
			}
			else if(item ==Items.COOKIES){
				 return cookieSoldTotal;
			}
			else if(item == Items.CHIPS){
				return chipsSoldTotal;
			}
			else
				return crackerSoldTotal;
			
		}
	
	public String getMostSold(){
		return("Most popular item is " + popularItem+":" +mostSold);
	}


}


	 
