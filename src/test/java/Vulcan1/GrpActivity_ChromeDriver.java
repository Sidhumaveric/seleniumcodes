package Vulcan1;

import java.io.File;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import junit.framework.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GrpActivity_ChromeDriver {
	
static WebDriver driver = null;
	
	public void LoginPage(){
		WebElement Username= driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		Username.sendKeys("mngr358081");
		WebElement Password= driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]"));
		Password.sendKeys("zUhymab");
		WebElement Login = driver.findElement(By.name("btnLogin"));
		Login.click();
	}
	
	// New Customer Creation
	public void CustomerCreaion() throws InterruptedException {
		WebElement Newcustomer = driver.findElement(By.xpath("//a[contains(text(),'New Customer')]"));
		Newcustomer.click();
		WebElement CustomerName = driver.findElement(By.name("name"));
		CustomerName.sendKeys("Vulcan");
		WebElement Gender = driver.findElement(By.name("rad1"));
		Gender.click();
		WebElement Dob = driver.findElement(By.id("dob"));
		Dob.sendKeys("09-01-2009");	
		WebElement Address = driver.findElement(By.cssSelector("table.layout:nth-child(8) table:nth-child(1) tbody:nth-child(1) tr:nth-child(7) td:nth-child(2) > textarea:nth-child(1)"));
		Address.sendKeys("Maveric DLF Chennai 600001");
		WebElement City = driver.findElement(By.xpath("//input[@name='city']"));
		City.sendKeys("Chennai");
		WebElement State = driver.findElement(By.xpath("//input[@name='state']"));
		State.sendKeys("Tamil Nadu");
		WebElement Pincode = driver.findElement(By.name("pinno"));
		Pincode.sendKeys("600089");
		WebElement Phonenumber = driver.findElement(By.xpath("//*[@name='telephoneno']"));
		Phonenumber.sendKeys("9087615432");
		WebElement Email = driver.findElement(By.xpath("//*[@name='emailid']"));
		// value for EmailID
		int min=300;
		int max=400;
		int randomNumber = (int)(Math.random()*(max-min+1)+min);
		Email.sendKeys("VulcanJasmine231"+randomNumber+"@gmail.com");
		//Email.sendKeys("Vulcan42@gmail.com");
		WebElement PasswordNewcustomer = driver.findElement(By.cssSelector("input[type='password']"));
		PasswordNewcustomer.sendKeys("Vulcan@2021");
		WebElement Submit = driver.findElement(By.cssSelector("input[name='sub']"));
		Submit.click();
		Thread.sleep(2000);
	}
	public void Account() throws InterruptedException {
		//Click New Account Tab
		WebElement NewAccount1 = driver.findElement(By.xpath("//*[@href='addAccount.php']"));
		NewAccount1.click();
		Thread.sleep(3000);
	}
	
	public void AccountCreation(String CustomerIDinput1) throws InterruptedException {
		
		
		//Provide Input for creating new account
		WebElement NewCustomerID=driver.findElement(By.cssSelector("input[name='cusid']"));
		NewCustomerID.sendKeys(CustomerIDinput1);
		WebElement staticDropdown = (driver.findElement(By.name("selaccount")));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(0);
		WebElement InitialDeposit= driver.findElement(By.name("inideposit"));
		InitialDeposit.sendKeys("70000");
		WebElement NewAccountSubmit = driver.findElement(By.name("button2"));
		NewAccountSubmit.click();
		Thread.sleep(3000);
		/*
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
        System.out.println("alert was present and accepted");
        */
        //Getting invalid data provided message
       // method();	
	
		boolean value=Check();
		if(value) {
			WebElement Notification = driver.findElement(By.cssSelector("label[id='message14']"));
			if(Notification.isDisplayed())
				{
				System.out.println("---------------------------");
				System.out.println(Notification.getText());
				System.out.println("---------------------------");
				}
			Assert.assertEquals(true,Notification.isDisplayed());
			WebElement Reset = driver.findElement(By.xpath("//input[@name='reset']"));
                        Reset.click();
			Thread.sleep(3000);
		}	
		
	}
	public boolean Check() {
		try {
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	// Amount Deposit Form
	public void Deposit(String AccountIDinput) throws InterruptedException {
		WebElement AmountDepositPage= driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[8]/a"));
		AmountDepositPage.click();
		Thread.sleep(3000);
		WebElement AMTDFAccountNo= driver.findElement(By.xpath("//input[@name='accountno']"));
		AMTDFAccountNo.sendKeys(AccountIDinput);
		WebElement AmountDeposit= driver.findElement(By.xpath("//input[@name='ammount']"));
		AmountDeposit.sendKeys("1000");
		WebElement Description = driver.findElement(By.xpath("//input[@name='desc']"));
		Description.sendKeys("MAVERIC ACCOUNT");
		WebElement DepositSubmit = driver.findElement(By.xpath("//input[@name='AccSubmit']"));
		DepositSubmit.click();
		Thread.sleep(3000);
	}
	
	//Balance Enquiry
	public void BalanceEnquiry(String AccountIDinput) throws InterruptedException {
		WebElement BalanceEnquiry = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[12]/a"));
		BalanceEnquiry.click();
		WebElement BalanceAccNo = driver.findElement(By.cssSelector("input[name='accountno']"));
		BalanceAccNo.sendKeys(AccountIDinput);
		WebElement BalanceSubmit = driver.findElement(By.cssSelector("input[value='Submit']"));
		BalanceSubmit.click();
		Thread.sleep(3000);
	}
	
	//Logout
	public void Logout() {
		WebElement Logout = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a"));
		Logout.click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	public void Screenshots(String fileName) throws Exception {
		//Mouse actions Down
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,5000)");
		//Screenshots
		Date d = new Date();
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\sidhus\\Pictures\\GAS\\"+fileName+".png"+d.toString().replace(":","_")+".png"));
		Thread.sleep(3000);
	}
	
	public void DepositedAmountEnquiry() {
		WebElement CurrentBalance=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[23]/td[2]"));
		System.out.println("Current Balance: "+ CurrentBalance.getText());
		WebElement AmountCredited = driver.findElement(By.xpath("//*[@id=\"deposit\"]/tbody/tr[12]/td[2]"));
		System.out.println(("AmountCredited :" + AmountCredited.getText()));
	}
	
	public void Balance() {
		WebElement BalanceCheck = driver.findElement(By.cssSelector("table#balenquiry"));
		System.out.println("------------------------------");
		System.out.println(BalanceCheck.getText());
		System.out.println("------------------------------");
	}
	
	public String fetchCustId() throws InterruptedException {
		// New Account Creation - Get the Customer Id for Account Creation
		WebElement custID1=driver.findElement(By.xpath("//*[@id=\'customer\']/tbody/tr[4]/td[2]"));
		String CustomerIDinput1=custID1.getText();
		return CustomerIDinput1;		
	}
	
	public String fetchAccountNumber() {
		WebElement accId=driver.findElement(By.xpath("//*[@id=\'account\']/tbody/tr[4]/td[2]"));
		String AccountIDinput=accId.getText();
		return AccountIDinput;
	}
	
	public void end() {
		driver.close();
	}
	
			
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		//System Properties
		
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("incognito");
		capabilities.setCapability(ChromeOptions.CAPABILITY, option);
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sidhus\\MavenSelenium\\MavenSeleniumsessions\\Drivers\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(capabilities);
		
		//Login
		driver.get("http://demo.guru99.com/V4/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		
		GrpActivity_ChromeDriver object=new GrpActivity_ChromeDriver();
		object.LoginPage();
		object.CustomerCreaion();
		object.Screenshots("NewCustomer");
		
		String custIdCreated=object.fetchCustId();
		
		//Passing invalid details for Account Field
		object.Account();
		object.AccountCreation("Welcome");
		object.Screenshots("AccountInvalidData");	
		
		object.AccountCreation(custIdCreated);
		object.Screenshots("Account");
		
		
		String accountIdCreated=object.fetchAccountNumber();
		object.Deposit(accountIdCreated);
		object.DepositedAmountEnquiry();
		object.Screenshots("Deposit");
		
		object.BalanceEnquiry(accountIdCreated);
		object.Balance();
		object.Screenshots("BalanceEnquiry");
		
		object.Logout();
		object.Screenshots("Logout");
		
		object.end();		
	
	}

}
