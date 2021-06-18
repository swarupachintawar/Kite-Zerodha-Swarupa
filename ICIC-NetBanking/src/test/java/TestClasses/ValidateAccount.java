package TestClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMclasses.PersonalMainpage;

public class ValidateAccount {
	
	WebDriver driver;
	PersonalMainpage mainpage;
	SoftAssert softassert;
	
	@BeforeSuite
	public void beforeSuite()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		softassert=new SoftAssert();
	}
	
	@BeforeClass
	public void beforeClass() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harshal\\Desktop\\Software Testing\\Tools\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.navigate().to("https://www.icicibank.com/");
		mainpage=new PersonalMainpage(driver);
	}
	
	
	@Test
	public void accountTest() throws InterruptedException
	{
		mainpage=new PersonalMainpage(driver);
		Thread.sleep(5000);
		mainpage.goToAccount();
		mainpage.goToDeposits();
		Thread.sleep(3000);
		mainpage.goTomore();
		String url=driver.getCurrentUrl();
		String text=mainpage.getmorepagetext();
		boolean result=text.equals("Invest your idle funds in Fixed Deposit");
		
		softassert.assertEquals("https://www.icicibank.com/Personal-Banking/account-deposit/fixed-deposit/index.page?ITM=nli_cms_FD_fixed_deposit_more_menu_navigation", url);
		softassert.assertTrue(result,"Pass:-Text mattched");
		
	}
	
	@Test
	public void investTest() throws InterruptedException
	{
		mainpage.goToInvest();
		Thread.sleep(2000);
		mainpage.goToFixeddeposite();
		
		WebElement title=driver.findElement(By.xpath("(//label[@id='LabelForControl16117102'])[1]"));
		String url=title.getText();
		softassert.assertEquals("Login to Internet Banking",url);
		boolean result=url.equals("Login to Internet Banking");
		softassert.assertTrue(result,"Swarupa good job");
	}
	
	@AfterMethod
	public void afterMethod() throws IOException, InterruptedException
	{
		mainpage.screenShot();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		
	}
	
	@AfterClass
	public void afterClass()
	{
		softassert.assertAll();
		driver.close();
	}
	
	

}
