package com.axisBank.test;

import org.testng.annotations.Test;
import com.axisBank.pages.AxisBankPage;
import com.axisBank.pages.utilities.ExcelUtilities;
import com.axisBank.pages.utilities.PropertryReader;
import com.axisBank.pages.utilities.TakeScreenShot;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;


public class AxisBank_TestCase {
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser) throws IOException
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aparna chowdary\\Downloads\\ChromeDrivers\\chromedriver_77.0.3865.40\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\aparna chowdary\\Downloads\\SBA\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(PropertryReader.getValue("url"));	
	}
	@Test
	public void testCase() throws Exception
	{
		
		AxisBankPage page=new AxisBankPage(driver);
		page.moveToGrabDetails();
		page.clickOnEMI();
		page.filterByOthers();
		System.out.println(ExcelUtilities.getCellData(0, 0));
		page.sortBy(ExcelUtilities.getCellData(0, 0));
		page.clickOnSecondOffer();
		page.switchToNewWindow();
		page.moveToValidaity();
		System.out.println(page.offerValidity.getText());
		TakeScreenShot.takeScreenShot(driver);
	}
	@AfterMethod
	public void quitDriver()
	{
		driver.quit();
	}
}