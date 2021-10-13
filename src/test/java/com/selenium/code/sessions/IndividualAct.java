package com.selenium.code.sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IndividualAct {
	WebDriver driver;
	//1.	Invoke Google Chrome browser/Firefox browser (any one).
	@BeforeTest
	     public  void  setup() throws InterruptedException {		
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		}
	     @Test
	     public void launch() throws InterruptedException {
	    	 //2.	open url :   https://www.saucedemo.com/
	    	 driver.get("https://www.saucedemo.com/");
	    	 driver.manage().window().maximize();
	    	 Thread.sleep(3000);
	  }
	     @Test
	     public void login() throws InterruptedException {
	    	 
	    	 //3.	login to website using username and password (username -  standard_user   passwd -  secret_sauce)
	    	 driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
	    	 driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
	    	 driver.findElement(By.id("login-button")).click();
	    	 Thread.sleep(2000);
	    	 
	    	 //5.	Verify you are on home page : Verify the text on page " SWAG LABS" or verify the logo on home page.
	    	 System.out.println("------------- Page Title------------");
	    	 System.out.println(driver.getTitle());
	    	 System.out.println("------------------------------------");
	     }
	     
	     @Test
	     public void shopping() throws InterruptedException {
	    	 //6.	Click on ADD TO CART option on any of the product
	    	 driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
	    	 Thread.sleep(2000);
	    	 //7.	Click on YOUR CART icon on top right corner
	    	 driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]")).click();
	    	 //8.	Click on CHECKOUT
	    	 driver.findElement(By.cssSelector("#checkout")).click();
	    	 
	    	 //9.	Add details for CHECKOUT (First name, Last name, zip code)
	    	 driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Sidhu");
	    	 driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/input[1]")).sendKeys("Subramani");
	    	 driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/input[1]")).sendKeys("635803");
	    	
	    	 //10.	Scroll page down and click on CONTINUE
	    	 JavascriptExecutor js = (JavascriptExecutor)driver;  
	         js.executeScript("scrollBy(0, 4000)"); 
	         Thread.sleep(2000);
	    	 driver.findElement(By.id("continue")).click();
	         js.executeScript("scrollBy(0, 4000)"); 
	         //11.	Scroll page down and Click on FINISH
	         driver.findElement(By.xpath("//button[@id='finish']")).click();
	         Thread.sleep(1000);
	         //12.	Click on BACK HOME
	         driver.findElement(By.id("back-to-products")).click();
	     }
	     
	     @AfterTest
	     public void logout() {
	    	//13.	LOGOUT (from Top left menu in home page)
	     driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
         driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
	     driver.close();
	    
	     }

}
