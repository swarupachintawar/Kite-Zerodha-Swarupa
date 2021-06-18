package POMclasses;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalMainpage {
	
	WebDriver driver;
	Actions a;
	String text;
	
	@FindBy (xpath="//span[text()='Accounts']")
	private WebElement account;
	
	@FindBy (xpath="(//label[text()='Deposits'])[1]")
	private WebElement deposits;
	
	@FindBy (xpath="(//a[@href='/Personal-Banking/account-deposit/fixed-deposit/index.page?ITM=nli_cms_FD_fixed_deposit_more_menu_navigation'])[1]")
	private WebElement more;
	
	@FindBy (xpath="//h3[text()='Invest your idle funds in Fixed Deposit']")
	private WebElement morepage;
	
	@FindBy (xpath="//span[text()='Invest']")
	private WebElement Invest;
	
	@FindBy (xpath="(//a[text()='OPEN Fixed Deposit'])[2]")
	private WebElement FixedDeposite;
	
	@FindBy (xpath="(//a[text()='LOGIN'])[1]")
	private WebElement login;
	
	public PersonalMainpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void actionsClass()
	{
		a=new Actions(driver);
	}
	
	public void goToAccount()
	{
		actionsClass();
		a.moveToElement(account).click().build().perform();
	}
	
	public void goToDeposits()
	{
		actionsClass();
		a.moveToElement(deposits).perform();
	}
	
	public void goTomore()
	{
		actionsClass();
		a.moveToElement(more).click().build().perform();
		
	}
	public String getmorepagetext()
	{
		text=morepage.getText();
		return text;
		
	}
	public void goToInvest()
	{
		actionsClass();
		a.moveToElement(Invest).perform();
	}
	
	public void goToFixeddeposite() throws InterruptedException
	{
		actionsClass();
		a.moveToElement(FixedDeposite).click().build().perform();
		Thread.sleep(2000);
	}
	
	public void screenShot() throws IOException
	{
		LocalTime time=java.time.LocalTime.now();
		String name=time.toString().replace(':', '.').concat(".jpeg");
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Harshal\\Desktop\\Software Testing\\Automation\\screenshot\\" + name);
		FileHandler.copy(source, dest);
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
	


}
