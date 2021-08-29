package com.axisBank.pages;


import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AxisBankPage {
	WebDriver driver;
	
	public AxisBankPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Grab Deals")
	public WebElement grabDeals;
	
	@FindBy(xpath="(//a[@title='E M I'])[1]")
	public WebElement emi;
	
	@FindBy(xpath="(//div[@class='controlIndicator'])[3]")
	public WebElement otherCategory;
	
	@FindBy(id="ddlorderbyfilter")
	public WebElement sortByDropDown;
	
	@FindBy(xpath="(//a[@class='travelTnc'])[2]")
	public WebElement secondOffer;
	
	@FindBy(xpath="//h6[@class='detail']")
	public WebElement offerValidity;
	
	public void moveToGrabDetails()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(grabDeals).perform();
	}
	public void clickOnEMI()
	{
		emi.click();
	}
	public void filterByOthers() throws InterruptedException
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(otherCategory).perform();
		Thread.sleep(5000);
		otherCategory.click();
	}
	public void sortBy(String dropDownValue)
	{
		Select options=new Select(sortByDropDown);
		options.selectByVisibleText(dropDownValue);
	}
	public void clickOnSecondOffer()
	{
		secondOffer.click();
	}
	public void switchToNewWindow()
	{
		Set<String> allWindows=driver.getWindowHandles();
		for(String handle:allWindows)
		{
		driver.switchTo().window(handle);
		}
	}
	public void moveToValidaity()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(offerValidity);
	}
	
	
	

}
