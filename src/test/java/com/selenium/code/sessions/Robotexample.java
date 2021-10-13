package com.selenium.code.sessions;
import java.awt.AWTException;	
import java.awt.Robot;	
import java.awt.event.KeyEvent;	
import org.openqa.selenium.By;	
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Robotexample {

	@Test
    void robo() throws InterruptedException, AWTException{	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	
		driver.get("http://www.edureka.co");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Courses")).click();
		Robot robot = new Robot();
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		System.out.println("a");
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		System.out.println("b");
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		System.out.println("c");
		robot.mouseMove(30,100);
		Thread.sleep(4000);
		System.out.println("d");
		driver.quit();
    }	 

}
