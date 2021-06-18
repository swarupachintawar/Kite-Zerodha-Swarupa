package pom_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteZerodhaDashboardPage {
	WebDriver driver;
	Actions a;
	
	
	@FindBy (xpath="//input[@id='search-input']")
	private WebElement search;
	
	@FindBy (xpath="(//span[text()='TATAMOTORS'])[1]")
	private WebElement tatamotors;
	
	@FindBy (xpath="//button[@class='button-blue buy']")
	private WebElement buy;
	
	@FindBy (xpath="//label[text()='Regular']")
	private WebElement regular;
	
	@FindBy (xpath="//label[text()='Intraday ']")
	private WebElement Intraday;
	
	@FindBy (xpath="(//input[@type='number'])[1]")
	private WebElement quantity;
	
	@FindBy (xpath="(//input[@type='number'])[2]")
	private WebElement price;
	
	@FindBy (xpath="(//input[@type='number'])[3]")
	private WebElement Triggerprice;
	
	@FindBy (xpath="//label[text()='Market']")
	private WebElement market;
	
	@FindBy (xpath="//span[@class='margin-value']")
	private WebElement marginvalue;
	
	@FindBy (xpath="(//span[@class='last-price'])[22]")
	private WebElement stockvalue;
	
	public KiteZerodhaDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void insertCompany() throws InterruptedException
	{
		
		a=new Actions(driver);
		a.moveToElement(tatamotors).perform();
		Thread.sleep(2000);
		a.moveToElement(buy).click().build().perform();
		Thread.sleep(2000);
	}

	
	public void clickOnRegular()
	{
		regular.click();
		regular.click();
	}
	
	public boolean statusOfIntraday()
	{
		boolean result=Intraday.isSelected();
		return result;
	}
	
	public void clickOnIntraday()
	{
		Intraday.click();
		
	}
	
	public void clickOnMarket()
	{
		market.click();
	}
	
	public void insertQty()
	{
		quantity.sendKeys("10");
	}
	
	public boolean statusOfPrice()
	{
		boolean result= price.isSelected();
		return result;
	}
	
	public boolean statusOfTriggerPrice()
	{
		boolean result= Triggerprice.isSelected();
		return result;
	}
	
	public String getMarginvalue()
	{
		String Mv=marginvalue.getText();
		return Mv;
	}

	public String getStockvalue()
	{
		String Sv=stockvalue.getText();
		return Sv;
	}

}
