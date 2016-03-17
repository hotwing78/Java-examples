package edu.trident.wingo.Final_Exam;

public interface Products {
	final int stockRequired = 1;
	final int stockPerformed = 2;
	public enum  Items {
		
		CRACKERS,
		COOKIES,
		CHIPS,
		CANDY
		
	}

	//public productList getItemSelection(Items i);
	public double getItemPrice(Items i);
	public int getItemStock(Items i);
	public void showStock(int stock);
	

}
