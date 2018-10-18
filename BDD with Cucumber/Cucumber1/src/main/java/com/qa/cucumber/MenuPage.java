package com.qa.cucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage {

	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914921\"]/div/h1")
	private WebElement menuHeader;
	
	@FindBy(id = "wsb-element-00000000-0000-0000-0000-000453230000")
	private WebElement product1;
	
	@FindBy(id = "wsb-element-00000000-0000-0000-0000-000453231735")
	private WebElement product2;
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a")
	private WebElement checkoutButton;
	
	public WebElement getMenuHeader() {
		return menuHeader;
	}
	
	public WebElement getProduct1() {
		return product1;
	}
	
	public WebElement getProduct2() {
		return product2;
	}
	
	public WebElement getCheckoutButton() {
		return checkoutButton;
	}


}
