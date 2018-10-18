package com.qa.cucumber;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepCucumber {
	
	public WebDriver driver = null;
	public static ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\TestReport\\CucumberTest.html", true);
	public ExtentTest test;
	public static int testCount = 1;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();

	}
	
	@After
	public void tearDown() {
		driver.quit();

	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address() throws Throwable {
		 if (testCount == 1) {
			 	test = extent.startTest("Navigate to Menu");
			 	testCount++;
		 } else if (testCount == 2) {
			 	test = extent.startTest("Navigate to Checkout");
			 	testCount--;
		 }
		//load page
		driver.get(Constants.welcomeURL);
		test.log(LogStatus.INFO, "Entered Home page");
		
		//xpath for welcome message on front page
		FrontPage frontPage = PageFactory.initElements(driver, FrontPage.class);
		
		//report if home page loaded successfully
		 if (frontPage.getFPHeader().getText().equals("We're passionate about tea. ")) {
		    	test.log(LogStatus.PASS, "Successfully entered home page");
		    }
		    else {
		    	test.log(LogStatus.FAIL, "Home page not loaded");
		    	extent.endTest(test);
			    extent.flush();
		    }
		//assert this contains expected text for front page 
		assertEquals("Correct page loaded","We're passionate about tea. ", frontPage.getFPHeader().getText());
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() throws Throwable {
		//click menu button
		FrontPage frontPage = PageFactory.initElements(driver, FrontPage.class);
		frontPage.getMenuButton().click();
		test.log(LogStatus.INFO, "Menu button clicked");
		//xpath for header on menu page
		MenuPage menuPage = PageFactory.initElements(driver, MenuPage.class);
		
		//report if menu page loaded successfully
		 if (menuPage.getMenuHeader().getText().equals("Menu")) {
		    	test.log(LogStatus.PASS, "Successfully entered menu page");
		    }
		    else {
		    	test.log(LogStatus.FAIL, "Menu page not loaded");
		    	extent.endTest(test);
			    extent.flush();
		    }
		//check on menu page by checking text in header
		assertEquals("Menu Loaded","Menu",menuPage.getMenuHeader().getText());
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() throws Throwable {
		//id of products on page
		MenuPage menuPage = PageFactory.initElements(driver, MenuPage.class);
		//check products available to browse
		 if (menuPage.getProduct1().getText().equals("Green Tea")) {
		    	test.log(LogStatus.PASS, "Product 1 available to browse");
		    }
		    else {
		    	test.log(LogStatus.FAIL, "Product 1 not available to browse");
		    	extent.endTest(test);
			    extent.flush();
		    }
		 
		 if (menuPage.getProduct2().getText().equals("Oolong Tea")) {
		    	test.log(LogStatus.PASS, "Product 2 available to browse");
		    }
		    else {
		    	test.log(LogStatus.FAIL, "Product 2 not available to browse");
		    	extent.endTest(test);
			    extent.flush();
		    }
		 //assert these ids are for expected products
		assertEquals("Product 1 loaded","Green Tea",menuPage.getProduct1().getText());
		assertEquals("Product 2 loaded", "Oolong Tea",menuPage.getProduct2().getText());
		
		test.log(LogStatus.INFO, "Test Complete");
	    extent.endTest(test);
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() throws Throwable {
		
		//click checkout button
		MenuPage menuPage = PageFactory.initElements(driver, MenuPage.class);
		menuPage.getCheckoutButton().click();	
		
		test.log(LogStatus.INFO, "Checkout button clicked");
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() throws Throwable {
		
		CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
		if (checkoutPage.getOrderButton().getText().equals("Place Order")) {
			test.log(LogStatus.PASS, "Successfully entered checkout page");
		} else {
			test.log(LogStatus.FAIL, "Checkout page not loaded");
			extent.endTest(test);
		    extent.flush();
		}
		//check entered checkout page by checking 'place order' button is present
		assertEquals("Checkout Page Loaded", "Place Order", checkoutPage.getOrderButton().getText());
		test.log(LogStatus.INFO, "Test Complete");
	    extent.endTest(test);
	    extent.flush();
	}


}
