package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {
	
	static String data;
	
	public static void screenShot(WebDriver driver) throws IOException
	{
		Double n=Math.random();
		String name=n.toString().replace(':', '.').concat(".jpeg");
		File sourcefile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationfile=new File("C:\\Users\\Harshal\\Desktop\\Software Testing\\Automation\\screenshot" + name);
		FileHandler.copy(sourcefile, destinationfile);
		
	}
	
	
	public static String excelSheet(int rowvalue,int cellvalue) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Harshal\\Desktop\\text.xlsx");
		Cell c=WorkbookFactory.create(file).getSheet("Sheet1").getRow(rowvalue).getCell(cellvalue);
		try
		{
			data=c.getStringCellValue();
		}
		
		catch(java.lang.IllegalStateException e)
		{
			double d=c.getNumericCellValue();
			data=String.valueOf(d); 
		}
		
		return data;
	}

}
