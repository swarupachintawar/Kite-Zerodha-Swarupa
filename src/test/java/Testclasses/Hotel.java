package Testclasses;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POMClasses.Homepage;
import POMClasses.Hotelpage;

public class Hotel {
	WebDriver driver;
	int roomcount;
	int adultcount;
	int Childrenroomcount;
	Hotelpage hotel;
	Homepage home;
	
	
	@BeforeClass
	public void beforeclass()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harshal\\Desktop\\Software Testing\\chromedriver.exe");
		driver=new ChromeDriver();	
	}
	
	@BeforeMethod
	public void beforemethod() throws InterruptedException
	{
		driver.navigate().to("https://www.goibibo.com/");
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of rooms");
		roomcount=s.nextInt();
		System.out.println("Enter the number of adult");
		adultcount=s.nextInt();
		System.out.println("Enter the number of Children");
		Childrenroomcount=s.nextInt();
		Thread.sleep(5000);
		
	}
	
	@Test
	public void hotelvalidate() throws InterruptedException
	{
		hotel=new Hotelpage(driver);
		home=new Homepage(driver);
		home.clickOnHotels();
		Thread.sleep(2000);
		hotel.clickOnIndia();
		hotel.insertareaname();
		hotel.selectcheckin();
		//hotel.selectcheckout();
		Thread.sleep(2000);
		hotel.clickonGuest();
		hotel.selectroom();
		for(int x=1;x<roomcount;x++)
		{
			hotel.rci();
		}
		hotel.selectadult();
		for(int x=1;x<adultcount;x++)
		{
			hotel.aci();
		}
		hotel.selectchild();
		for(int x=1;x<Childrenroomcount;x++)
		{
			hotel.cci();
		}
		hotel.clickOndone();
		hotel.clicksearch();
	}

	
	

}
