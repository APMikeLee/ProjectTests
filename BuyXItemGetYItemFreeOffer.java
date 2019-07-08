package com.tdd.shoppingcart;


public class BuyXItemGetYItemFreeOffer implements IOffer{

	private int XItem;
	private int YItem;
	
		public BuyXItemGetYItemOffer(int xItem, int yItem){
			
			XItem = xItem;
			YItem = yItem;
		}
		
		@Override
		//First Offer
		public void applyOffer(Product product){
			if (product.getQuantity()>= XItem){
				int tenperProductQty = product.getQuantity() / (XItem + YItem);
				double unitPrice = product.getTotalPrice() / product.getQuantity();
				//Item Apples have 10% discount offer 
				double discount = unitPrice - (unitPrice / 0.10);
				product.setTotalPrice(product.getTotalPrice() - discount);
				}
			}
		
		@Override
		//Second Offer
		public void apply2Offer(Product product){
			if (product.getQuantity()>= XItem){
				int fiftyperProductQty = product.getQuantity() / (XItem + YItem);
				double unitPrice = product.getTotalPrice() / product.getQuantity();
				//Item Apples have 50% discount offer 
				double discount = unitPrice - (unitPrice / 0.50);
				product.setTotalPrice(product.getTotalPrice() - discount);
			}
		}
		// get/set
		
}
