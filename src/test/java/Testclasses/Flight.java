package Testclasses;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POMClasses.Homepage;
import POMClasses.extraclass;

public class Flight {
	
	WebDriver driver;
	Homepage home;
	
	@BeforeClass
	public void beforeclass()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harshal\\Desktop\\Software Testing\\chromedriver.exe");
		driver=new ChromeDriver();	
	}
	
	@BeforeMethod
	public void beforemethod()
	{
		driver.navigate().to("https://www.goibibo.com/");
	}

	@Test
	public void flightvalidation() throws InterruptedException
	{
		Homepage home=new Homepage(driver);
		boolean b=home.flightcheck();
		if(b=true)
		{
		home.selectSource();
		home.selectDestination();
		home.selectdate();
		home.clickOnSearch();
		}
		String title=driver.getTitle();
		Assert.assertEquals("Book Cheap Flights, Air Tickets, Hotels, Bus & Holiday Package at Goibibo", title);
		Assert.assertTrue(b, "Flight iccon is selected");
		
	}
	
	@AfterMethod
	public void afterMethod() throws IOException
	{
	 driver.navigate().back();
	 extraclass e=new extraclass(driver);
	 e.screenshot();
	}
}
