package com.tdd.shoppingcart;

import java.util.Scanner;
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
	private static double totalCartValue;
	
	public double subTotal; //change to totalCartValue ?
	public int weekcount;
	public static double runningTotal;
	private static double itemPrice;
	static boolean ordering = true;
	
	static Scanner input = new Scanner(System.in);
	
	//Number of Products in the List
	public int getProductCount(){
		return productList.size();
	}
	
	//Combined the following two methods --
	//Apply Discounted Offer of 10% on Apples
	public void addProduct(Product product) {
		if(offer != null){
			offer.applyOffer(product);//apply offer
		}
		productList.add(product);
	}
	
	//Apply Discounted Offer two tins of Soup get a Loaf 50% off
	public void addProduct1(Product product) {
		if(offer != null){
			offer.applyOffer(product);//apply offer
		}
		productList.add(product);
		
	}
	

	public double getTotalCartValue1(){
		return 0.0;		
	}
	
	
	public double getTotalCartValue(){
		
		if(productList.size() > 0){
			for(Product product : productList){
			//	totalCartValue = TotalCartValue() + product.getTotalPrice();
				
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
	
	public static void menu() {
    	System.out.println("WELCOME TO LEE'S SHOP");
    	//System.out.println("This week Sorry No Offers");
        System.out.println("Available Now: \n1. Soup per tin(65p) \n2. Milk ($1.30)\n3. Apples per bag($1.00)\n4. Bread per loaf (80p)\n5. Done");
   }

    public static double itemPrice(int foodItem) {
	     if (foodItem == 1) {
	           // Soup = 65p
	    	   System.out.println();
	           System.out.println("Soup");
	            itemPrice = 0.65;
	     }
	     if (foodItem == 2) {
	            // Milk = $1.30
	            System.out.println("Milk");
	            itemPrice = 1.30;
	     }
	     if (foodItem == 3) {
	            // Apples = $1.00
	            System.out.println("Apples");
	            itemPrice = 1.00;
	     }
	     if (foodItem == 4){
	        	//Bread = 80
	        	System.out.println("Bread");
	        	itemPrice = 0.80;
	     }
	        
	        quantity();
	     return itemPrice;
	    }

    public static double quantity() {
	        System.out.println("Enter quantity");
	        double quantity = input.nextDouble();
	        
	        //if(FoodItem == 1 & quantity > 2){
	        //	System.out.println("Get a Bread Loaf at 1/2 price");
	        //}
	        subTotal(quantity, itemPrice);
	        return quantity;
	}

    public static double subTotal(double quantity, double itemPrice) {
	        double subTotal = quantity * itemPrice;
	        System.out.println("Subtotal: " + subTotal);
	        return subTotal;
	}

	public static void done(double runningTotal) {
	        ordering = false;
	        System.out.println("Your Running Total:" + runningTotal);
	        System.out.println("Enjoy!");
	}

	public static void main(String[] args) {
	        int menuOption;
	        int foodItem = 0;
	        int weekcount = 0;
	        int special = 0;
	        
	        input = new Scanner(System.in);
	        do {
	        	weekcount = weekcount+1;
	        	
	        	if(weekcount > 1){
	        		System.out.println("This Week Apples have a discount 10%");
	        	}
	        		
	            double runningTotal = 0;
	            menu();
	            menuOption = input.nextInt();
	            switch (menuOption) {
	            case 1:
	                foodItem = 1;//{
	                if(quantity() == 2){
	                	special = 1;
	                	System.out.println("You have bought two tins buy a bread loaf at half price");
	                	//IOffer();
	                	//addProduct1(foodItem); 	 
	                }
	                itemPrice(foodItem);
	                break;
	            case 2:
	                foodItem = 2;
	                if(special == 1){
	                	System.out.println("Your Discount has been Applied 50% of Bread");
	                	//Condition set for Ioffer 2.
	                }
	                itemPrice(foodItem);
	                break;
	            case 3:
	                foodItem = 3;
	                itemPrice(foodItem);
	                break;
	            case 4:
	                foodItem = 4;
	                itemPrice(foodItem);
	                if(weekcount > 1){
		        		System.out.println("This Week Apples have a discount 10%");
		        		//Call Method for Ioffer 1.
		        		//DiscountOnNextItemOffer.applyOffer();
		        	}   
	                break;
	            case 5:
	                done(runningTotal);
	                break;
	            default:
	                System.out.println("Invalid option.");
	            }
	        } while (ordering);
	        {
	            subTotal(quantity(), itemPrice(foodItem));
	            runningTotal = runningTotal + subTotal(quantity(), itemPrice(foodItem));
	            totalCartValue = runningTotal;
	        }
	    }

}
