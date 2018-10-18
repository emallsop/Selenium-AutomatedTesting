package com.qa.cucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/div/button")
	private WebElement placeorderButton;
	
	public WebElement getOrderButton() {
		return placeorderButton;
	}

}
