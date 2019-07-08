package com.tdd.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import com.tdd.shoppingcart.BuyXItemGetYItemFreeOffer;
import com.tdd.shoppingcart.IOffer;
import com.tdd.shoppingcart.NoOffer;
import com.tdd.shoppingcart.Product;
import com.tdd.shoppingcart.ShoppingCart;

public class ShoppingCart {

	private List<Product> productList = new ArrayList<>();
	private IOffer offer;
	private double totalCartValue;
	
	public int getProductCount(){
		return productList.size();
	}
	
	//Apply Discounted Offer of 10%
	public void addProduct(Product product) {
		if(offer != null){
			offer.applyOffer(product);//apply offer
		}
		productList.add(product);
		
	}
	
	//Apply Discounted Offer two tins of Soup get a Loaf 50% off
	//public void addProduct(Product product) {
		//if(offer != null){
		//	offer.apply2Offer(product);//apply offer
		//}
		//productList.add(product);
		
	//}
	

//	public double getTotalCartValue1(){
//		return 0.0;		
//	}
	
	
	public double getTotalCartValue(){
		
		if(productList.size() > 0){
			for(Product product : productList){
				totalCartValue = TotalCartValue() + product.getTotalPrice();
				
			}
		}
		return totalCartValue;
	}

	public void setOffer(IOffer offer){
		this.offer = offer;
	}
	
	public Product getProductByName(String name) {
		if (productList.size() > 0) {
			for (Product product : productList) {
				if (product.getProductName().equals(name)) {
					return product;
				}
			}
		}
	return null;
	}
	

}