package com.ebay.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ebay.qa.base.BaseClass;
import com.ebay.qa.pages.CartPage;
import com.ebay.qa.pages.CheckoutPage;
import com.ebay.qa.pages.HomePage;
import com.ebay.qa.pages.ProductPage;
import com.ebay.qa.pages.SearchResultPage;

public class E2ETest extends BaseClass{
	
	HomePage hpObj;
	SearchResultPage srpObj;
	ProductPage ppObj;
	CartPage cartObj;
	CheckoutPage coutObj;
	
	
	@BeforeMethod
	public void setUp()
	{
		hpObj = new HomePage();
	}
	
	@Test
	public void productSearch() throws InterruptedException {
		srpObj = hpObj.searchProduct(prop.getProperty("searchKeyword"));
		Thread.sleep(3000);
		ppObj = srpObj.goToProductPage();
		Thread.sleep(3000);
		cartObj = ppObj.addToCart();
		Thread.sleep(3000);
		coutObj = cartObj.goToCheckout();
		Thread.sleep(2000);
		coutObj.enterShippingAddress();
		Thread.sleep(3000);
		coutObj.enterCardDetails();
		
		Assert.assertEquals(coutObj.getCardError().getText(), "We don't support this card. Please use a different one.", "Card details are not valid");
		
	}
	
	

}
