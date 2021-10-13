package com.selenium.code.sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class afterlogin {

	public WebDriver driver;
	
	
	public void admin() {
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
	}
	
	
}
