package com.ebay.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.qa.base.BaseClass;

public class ProductPage extends BaseClass{
	
	@FindBy(xpath="//a[@id='isCartBtn_btn']")
	private WebElement cart_btn;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public CartPage addToCart() {
		
		cart_btn.click();
		
		return new CartPage();
		
	}

}
