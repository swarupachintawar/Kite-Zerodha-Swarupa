package POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	
	@FindBy (xpath="//input[@id='DUMMY1']")
	private WebElement input;
	
	@FindBy (xpath="//input[@id='AuthenticationFG.USER_PRINCIPAL']")
	private WebElement userid;
	
	@FindBy (xpath="//input[@id='AuthenticationFG.ACCESS_CODE']")
	private WebElement password;
	
	@FindBy (xpath="(//input[@type='Submit'])[1]")
	private WebElement submit;
	
	@FindBy (xpath="//iframe[@id='Revamp_Banner_ID']")
	private WebElement frame;
	
	@FindBy (xpath="(//a[text()='click here'])[2]")
	private WebElement rbilink;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void switchToFrame()
	{
		driver.switchTo().frame(frame);
	}
	public void clickOnInput()
	{
		input.click();
	}
	public void insertUserId()
	{
		userid.sendKeys("swarupa");
	}
	public void insertPassword()
	{
		password.sendKeys("Swarupa");
	}
	public void clickOnSubmit()
	{
		submit.click();
	}
	public void clickOnRbiGuidelinelink()
	{
		rbilink.click();
	}
	
	
	
	

}
