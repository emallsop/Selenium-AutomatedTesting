package com.qa.shoppingsite;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingSiteSearchResult {
	
	//search for the product names listed only in the search results list (not from rest of page)
	public List<String> getResults(WebDriver driver) {
		
		//xpath of search results
		WebElement resultList = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul"));
		
		//create list of product names within search results
	    List<String> productName = new ArrayList<String>();
	    List<WebElement> allProductsName = resultList.findElements(By.className("product-name"));
	    
	    
	    for(WebElement w : allProductsName) {
	        productName.add(w.getText());
	    }

	    return productName;
		
	}

}
