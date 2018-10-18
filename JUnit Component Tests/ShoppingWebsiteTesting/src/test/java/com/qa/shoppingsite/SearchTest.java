package com.qa.shoppingsite;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class SearchTest {
	
	public WebDriver driver = null;
	public static ExtentReports report;
	public ExtentTest test;
	
	@BeforeClass
	public static void initial() {
	report = new ExtentReports("C:\\Users\\Admin\\Desktop\\TestReport\\DressTest.html", true);
	}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public static void end() {
		report.flush();
	}
	
	@Test
	public void createUser() throws InterruptedException, IOException {
				
		//start report
		test = report.startTest("Search");
		
		//log this in report
		test.log(LogStatus.INFO, "Shopping site opened");

		//open site
		driver.get("http://automationpractice.com/index.php");
		ShoppingSiteSearch SearchPage = PageFactory.initElements(driver, ShoppingSiteSearch.class);
		
		//search dress
		SearchPage.search("dress");
		
		//log this in report
		test.log(LogStatus.INFO, "Dress Searched");
		
		ShoppingSiteSearchResult searchResults = PageFactory.initElements(driver, ShoppingSiteSearchResult.class);
		
	    System.out.print(searchResults.getResults(driver));
	    
	    //check if printed dress is in search results
	    boolean dressResult;
	    
	    if (searchResults.getResults(driver).contains("Printed Dress")) {
	    	dressResult = true;
	    } else {
	    	dressResult = false;
	    }
	    
	    //log whether dress is present
	    if (dressResult) {
	    	test.log(LogStatus.PASS, "Search successful");
	    }
	    else {
	    	test.log(LogStatus.FAIL, "Search unsuccessful");

	    }
	    
	    assertEquals(true, dressResult);
	    
	    //end report
	    test.log(LogStatus.INFO, "Test Complete");
	    report.endTest(test);
	    report.flush();
	    
	}

}

