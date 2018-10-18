package com.qa.cucumber;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrontPage {
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914886\"]/div/h1")
	private WebElement frontPage;
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]")
	private WebElement menuButton;
	
	public WebElement getFPHeader() {
		return frontPage;
	}
	
	public WebElement getMenuButton() {
		return menuButton;
	}

}
