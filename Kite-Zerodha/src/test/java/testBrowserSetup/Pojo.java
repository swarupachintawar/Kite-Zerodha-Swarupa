package testBrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Pojo {
	
	public WebDriver launchChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harshal\\Desktop\\Software Testing\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	
	public WebDriver launchFireFoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Harshal\\Desktop\\Software Testing\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		return driver;
	}

}
