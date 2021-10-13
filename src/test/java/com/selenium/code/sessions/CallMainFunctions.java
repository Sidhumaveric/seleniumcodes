package com.selenium.code.sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CallMainFunctions{
	static WebDriver driver;
	@BeforeTest
	public  void  setup() throws InterruptedException {		
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	}
	@Test
	public void LoginFunction() throws InterruptedException {
    driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.name("txtPassword")).sendKeys("admin123");
	driver.findElement(By.className("button")).click();
	driver.manage().window().maximize();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
	Thread.sleep(1000);
	driver.close();
		}
}

	
	
	

 