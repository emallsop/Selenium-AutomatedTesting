package com.qa.thedemosite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicUserTest {
	public WebDriver driver = null;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void createUser() {
		//creates user
		driver.get("http://thedemosite.co.uk/addauser.php");
		driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("test123");
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("test");
	    driver.findElement(By.name("FormsButton2")).click();
	    //login
	    driver.findElement(By.linkText("4. Login")).click();
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("test123");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("test");
	    driver.findElement(By.name("FormsButton2")).click();
	    //assert logged in
	    WebElement loginSuccess = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
	    assertEquals("login success","**Successful Login**",loginSuccess.getText());
		
	}
}
