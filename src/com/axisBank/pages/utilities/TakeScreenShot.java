package com.axisBank.pages.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {
	
	public static void takeScreenShot(WebDriver driver) throws IOException
	{
		Calendar c=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yymmss");
		String date=sdf.format(c.getTime());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File scr=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr,new File("C:\\Users\\aparna chowdary\\Documents\\SBA\\Selenium\\screenshots\\screenshot"+date+".png"));
	}
}
