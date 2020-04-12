package com.cts.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {

	public WebDriver driver;
	public Properties prop;
	
	public static ExtentTest test;
	public static ExtentReports report;
	
	public Properties initiateproperties() throws IOException
	{
		prop= new Properties();
		FileInputStream ip = new FileInputStream("C:/Users/lenovo/eclipse-workspace/ZProject/src/test/resources/TestData/config.properties");
		prop.load(ip);
		
		return prop;
	}
	
	public WebDriver intiatedriver(String Browsername)
	{
		if(Browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/lenovo/eclipse-workspace/ZProject/src/test/resources/Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:/Users/lenovo/eclipse-workspace/ZProject/src/test/resources/Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	public void takeScreenshot(String filename) throws IOException
	{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("C:/Users/lenovo/eclipse-workspace/ZProject/src/test/resources/Screenshots/"+filename+".jpg"));
	}
	
	public String[] datadriven_excel() throws IOException
	{
		String[] names = new String[2];
		FileInputStream fin;
			fin = new FileInputStream("C:/Users/lenovo/eclipse-workspace/ZProject/src/test/resources/TestData/datadrivenexcel.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fin);
			XSSFSheet sh = wb.getSheet("Sheet1"); 
		    names[0] = sh.getRow(1).getCell(0).getStringCellValue();
	        names[1] = sh.getRow(1).getCell(1).getStringCellValue();
	
		
		return names;
	}
	public void startTest(String str)
	{
		report = new ExtentReports("C:/Users/lenovo/eclipse-workspace/ZProject/ExtentReports/"+str+".html");
		test = report.startTest(str);
	}
	public void endTest()
	{
	report.endTest(test);
	report.flush();
	}
}
