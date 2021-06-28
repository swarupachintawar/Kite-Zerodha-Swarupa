package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hotelpage {
	
	WebDriver driver;
	Actions a;

	@FindBy (xpath="(//input[@type='radio'])[1]")
	private WebElement indiabutton;
	
	@FindBy (xpath="//input[@id='downshift-1-input']")
	private WebElement Area;
	
	@FindBy (xpath="//span[text()='Mumbai']")
	private WebElement Areaname;
	
	@FindBy (xpath="//div[@data-testid='openCheckinCalendar']")
	private WebElement checkin;
	
	@FindBy (xpath="//span[text()='17']")
	private WebElement checkindate;
	
	@FindBy (xpath="//div[@data-testid='openCheckoutCalendar']")
	private WebElement checkout;
	
	@FindBy (xpath="//span[text()='20']")
	private WebElement checkoutdate;
	
	@FindBy (xpath="//input[@value='2 Guests in 1 Room ']")
	private WebElement Guest;
	
	@FindBy (xpath="//h4[text()='1']")
	private WebElement room;
	
	@FindBy (xpath="(//span[text()='+'][1])")
	private WebElement roomcount;
	
	@FindBy (xpath="(//span[text()='+'][2])")
	private WebElement adultcount;
	
	@FindBy (xpath="(//span[text()='+'][3])")
	private WebElement childcount;
	
	@FindBy (xpath="//button[text()='Done']")
	private WebElement done;
	
	@FindBy (xpath="//button[text()='Search Hotels']")
	private WebElement search;
	
	public Hotelpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public  void performAct()
	{
		a=new Actions(driver);
		
	}
	
	public void clickOnIndia()
	{
		indiabutton.click();
	}
	
	public void insertareaname() throws InterruptedException
	{
		Area.sendKeys("Mumbai");
		Thread.sleep(2000);
		performAct();
		a.moveToElement(Areaname).click().build().perform();
	}
	
	public void selectcheckin()
	{
		checkin.click();
		performAct();
		a.moveToElement(checkindate).click().build().perform();
	}
	
//	public void selectcheckout() throws InterruptedException
//	{
//		Thread.sleep(3000);
//		checkout.click();
//		Thread.sleep(3000);
//		checkoutdate.click();
//	}
	
	public void clickonGuest()
	{
		Guest.click();
	}
	
	public void selectroom()
	{
		room.click();
		performAct();
		a.moveToElement(roomcount).perform();
	}
	
	public void rci()
	{
		roomcount.click();
	}
	public void selectadult()
	{
		performAct();
		a.moveToElement(adultcount).perform();
	}
	public void aci()
	{
		adultcount.click();
	}
	public void selectchild()
	{
		performAct();
		a.moveToElement(childcount).perform();
	}
	public void cci()
	{
		childcount.click();
	}
	
	public void clickOndone()
	{
		performAct();
		a.moveToElement(done).click().build().perform();
	}
	
	public void clicksearch()
	{
		search.click();
	}
	
	
	
	
}
