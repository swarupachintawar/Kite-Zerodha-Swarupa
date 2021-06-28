package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	Actions a;
	
	@FindBy (xpath="//a[text()='Flights']")
	private WebElement flight;
	
	@FindBy (xpath="//input[@id='gosuggest_inputSrc']")
	private WebElement from;
	
	@FindBy (xpath="//input[@id='gosuggest_inputDest']")
	private WebElement Destination;
	
	@FindBy (xpath="//input[@id='departureCalendar']")
	private WebElement Calender;
	
	@FindBy (xpath="//div[@aria-label='Fri Jun 11 2021']")
	private WebElement date;
	
	@FindBy (xpath="//button[text()='SEARCH']")
	private WebElement search;
	
	@FindBy (xpath="//span[text()='Mumbai, India']")
	private WebElement mumbai;
	
	@FindBy (xpath="//span[text()='Nagpur, India']")
	private WebElement nagpur;
	
	@FindBy (xpath="//a[text()='Hotels']")
	private WebElement hotel;
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void actions()
	{
		a=new Actions(driver);
	}
	
	public boolean flightcheck()
	{
		boolean flightstatus=flight.isSelected();
		return flightstatus;
	}
	
	public void selectSource() throws InterruptedException
	{
		actions();
		from.sendKeys("Mumbai");
		Thread.sleep(2000);
		a.moveToElement(mumbai).click().build().perform();
	}
	
	public void selectDestination() throws InterruptedException
	{
		actions();
		Destination.sendKeys("Nagpur");
		Thread.sleep(2000);
		a.moveToElement(nagpur).click().build().perform();
	}
	
	public void selectdate() throws InterruptedException
	{
		Calender.click();
		Thread.sleep(2000);
		actions();
		a.moveToElement(date).click().build().perform();
	}

	public void clickOnSearch()
	{
		
		search.click();
	}
	
	public void clickOnHotels()
	{
		hotel.click();
	}
}
