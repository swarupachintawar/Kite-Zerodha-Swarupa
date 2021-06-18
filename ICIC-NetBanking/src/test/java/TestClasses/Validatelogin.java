package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMclasses.Loginpage;
import POMclasses.PersonalMainpage;

public class Validatelogin {
	
	WebDriver driver;
	PersonalMainpage main;
	Loginpage loginp;
	
	@BeforeSuite
	public void beforeSuite()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
	}
	
	@BeforeClass
	public void beforeClass() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harshal\\Desktop\\Software Testing\\Tools\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.navigate().to("https://www.icicibank.com/");
	}
	
	@Test
	public void validateLogin() throws InterruptedException
	{
		main=new PersonalMainpage(driver);
		main.clickOnLogin();
		loginp=new Loginpage(driver);
		Thread.sleep(2000);
		loginp.clickOnInput();
		loginp.insertUserId();
		loginp.insertPassword();
		loginp.clickOnSubmit();
		
	}
	
	@Test
	public void validateRBIlink()
	{
		loginp.switchToFrame();
		loginp.clickOnRbiGuidelinelink();
		
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException, IOException
	{
		main.screenShot();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.close();
	}
	

}
