package pom_package;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.UtilityClass;

public class KiteZerodhaLoginPage {

WebDriver driver;
WebDriverWait wait;
	
	@FindBy (xpath="//input[@id='userid']")
	private WebElement userid;
	
	@FindBy (xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement login;
	
	@FindBy (xpath="//input[@type='password']")
	private WebElement pin;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement continue1;
	
	
	public KiteZerodhaLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void insertUserId() throws EncryptedDocumentException, IOException
	{
		wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userid']")));
		String user=UtilityClass.excelSheet(2,1);
		userid.sendKeys(user);
		
	}
	
	public void insertPassword() throws EncryptedDocumentException, IOException
	{
		String pwd=UtilityClass.excelSheet(2,2);
		password.sendKeys(pwd);
	}
	

	public void ClickOnLogin()
	{
		login.click();
	}
	
	public void insertPin() throws EncryptedDocumentException, IOException
	{
		String pinno=UtilityClass.excelSheet(3,1);
		pin.sendKeys("959594");
	}
	
	public void clickOnContinue()
	{
		continue1.click();
	}
}

