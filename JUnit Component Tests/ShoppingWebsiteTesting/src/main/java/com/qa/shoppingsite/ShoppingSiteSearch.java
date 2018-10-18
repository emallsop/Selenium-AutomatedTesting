package com.qa.shoppingsite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingSiteSearch {
	
	@FindBy(id = "search_query_top")
	private WebElement searchbox;
	
	public void search(String text) throws InterruptedException {
		searchbox.sendKeys(text);
		searchbox.submit();
	}

}

	

