package POMClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class extraclass {
	WebDriver driver;
	static String data;
	static Cell c;
	
	public extraclass(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public static String value()
	{
		String data=extraclass.data;
		return data;
	}
	
	public void Fetchexcel() throws EncryptedDocumentException, IOException
	{
		String path="C:\\Users\\Harshal\\Desktop\\text.xlsx";
		FileInputStream file=new FileInputStream(path);
		Sheet s=WorkbookFactory.create(file).getSheet("Sheet1");
	for(int x=0;x<=4;x++)
	{
		System.out.println();
		for(int y=0;y<=1;y++)
		{
			Cell c=s.getRow(x).getCell(y);
			
			try
			{
				data=c.getStringCellValue();
				System.out.print(data + " ");
			}
		
			catch(java.lang.IllegalStateException e)
			{
				double d=c.getNumericCellValue();
				data=String.valueOf(d); 
				System.out.print(data + " ");
			}
		
		}
		extraclass.value();
	}
	}
	
	
	
	public void screenshot() throws IOException
	{
		LocalTime time=java.time.LocalTime.now();
		String name=time.toString().replace(':', '.').concat(".jpeg");
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Harshal\\Desktop\\Software Testing\\Automation\\screenshot\\" + name);
		FileHandler.copy(source, dest);
	}

}
