package com.axisBank.pages.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertryReader {
	
	public static String getValue(String key ) throws IOException{
		FileInputStream fs = new FileInputStream("C:\\Users\\aparna chowdary\\Documents\\SBA\\Selenium\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(fs);
		return prop.getProperty(key);
	}
	
}
