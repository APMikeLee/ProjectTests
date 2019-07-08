package com.tdd.test.shoppingcart;

import org.junit.Assert;
import org.junit.Test;
import com.tdd.shoppingcart.*;


public class ShoppingCartAppTest {
	
	@Test
	public void testCreateEmptyShoppingCart() {
		ShoppingCart cart = new ShoppingCart();
		Assert.assertEquals(0, cart.getProductCount());
	}
	
	@Test
	public void testAddSingleProductToShoppingCart() {
		ShoppingCart cart = new ShoppingCart();
		Product product = new Product("Mug Soup: 65p per tin", 1, 65.0);
		cart.addProduct(product);
		Assert.assertEquals(1, cart.getProductCount());
		Assert.assertEquals(65.0, cart.getTotalCartValue(),0.0);
	}
	
	@Test
	public void addDifferentProductsToTheCart(){
		ShoppingCart cart = new ShoppingCart();
		
		Product product = new Product("Mug Soup: 65p per tin", 1, 65.0);
		Product Bread = new Product("Bread: 80p per Loaf", 1, 80.0);
		Product Milk = new Product("Milk: 1.30p per bottle", 1, 130.0);
		Product Apples = new Product("Apples: 1.00p per bag", 1, 100.0);
		
		cart.addProduct(product);
		cart.addProduct(Bread);
		cart.addProduct(Milk);
		cart.addProduct(Apples);
		
		Assert.assertEquals(4, cart.getProductCount());
		Assert.assertEquals(165.0, cart.getTotalCartValue(),0.0);
	//
	//	Assert.assertEquals(80.0, cart.getTotalCartValue(),0.0);
	//	Assert.assertEquals(3, cart.getProductCount());
	//	Assert.assertEquals(130.0, cart.getTotalCartValue(),0.0);
	//	Assert.assertEquals(4, cart.getProductCount());
		Assert.assertEquals(100.0, cart.getTotalCartValue(),0.0);
	
	}
	
	@Test
	public void testAddMultipleQuantityOfAProductAndApplyOfferToCart() {
		IOffer offer = new BuyXItemGetYItemOffer(2,1);
		ShoppingCart cart = new ShoppingCart();
		cart.setOffer(offer);
		Product product = new Product("Apples have 10% discount off their normal price this week :", 5, 150.0);
		cart.addProduct(product);
		Assert.assertEquals(1, cart.getProductCount());
		Assert.assertEquals(100.0, cart.getTotalCartValue(),0.0);
	}
	
    @Test
	public void addDifferentProductsAndAppyOfferToTheCart(){
		IOffer offer = new BuyXItemGetYItemFreeOffer(2,1);
		ShoppingCart cart = new ShoppingCart();
		Product Apples = new Product("Apples have 10% discount this week", 1, 100.0);
		Product Soup = new Product("Two Tins of Soup 50 % discount on loaf of bread", 3, 170.0);
		cart.setOffer(offer);
		cart.addProduct(Apples);
		cart.setOffer(new NoOffer());//No offer for the Soap
		cart.addProduct(Soup);
		Assert.assertEquals(4, cart.getProductCount());
		Assert.assertEquals(260.0, cart.getTotalCartValue(),0.0);
	
	
} 
    @Test
	public void testApplyBuyOneGetFiftyPercentDiscountOnNextOfferToTheCart(){
		IOffer offer = new DiscountOnNextItemOffer(50.0);
		ShoppingCart cart = new ShoppingCart();
		cart.setOffer(offer);
		Product Apples = new Product("Apples have 10% discount this week", 2, 150.0);
		cart.addProduct(Apples);
		Assert.assertEquals(2, cart.getProductCount());
		Assert.assertEquals(200.0, cart.getProductByName("Apples").getTotalPrice(),0.0);
		Assert.assertEquals(150.0, cart.getTotalCartValue(),0.0);
	}

}
