package testclass_package;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utilities.UtilityClass;
import pom_package.KiteZerodhaLoginPage;
import testBrowserSetup.Pojo;

public class ValidateLogin extends Pojo{
	
	WebDriver driver;
	KiteZerodhaLoginPage l;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser)
	{
		reporter =new ExtentHtmlReporter("test-output//ExtendReport//Extent.html");
		ExtentReports extend=new ExtentReports();
		extend.attachReporter(reporter);
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=launchChromeBrowser();
		}
		
		else
			if(browser.equalsIgnoreCase("FireFox"))
			{
				driver=launchFireFoxBrowser();
			}
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}

	
	@BeforeMethod
	public void beforemethod()
	{
		driver.get("https://kite.zerodha.com/#loggedout");
	}
	@Test
	public void Logintest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		l=new KiteZerodhaLoginPage(driver);
		l.insertUserId();
		l.insertPassword();
		l.ClickOnLogin();
		Thread.sleep(2000);
		l.insertPin();
		l.clickOnContinue();
		Thread.sleep(2000);
		String Expected="https://kite.zerodha.com/dashboard#loggedout";
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, Expected);
			
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException
	{
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			UtilityClass.screenShot(driver);
		}
		driver.close();
	}
	
	@AfterTest
	public void aftertest()
	{
		driver.quit();
		driver=null;
	}
	

}
