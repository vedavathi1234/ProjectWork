package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cts.utility.Base;

public class Addtobasket extends Base{

	@FindBy(xpath="//*[@id=\"s\"]")
	WebElement search;
	
	@FindBy(xpath="//li[@class='cat-item cat-item-19']/a")
	WebElement links;
	
	@FindBy(xpath="//select[@class='orderby']")
	WebElement filter;
	
	@FindBy(xpath="//select[@class='orderby']/option[@value='menu_order']")
	WebElement defaultsorting;
	
	@FindBy(xpath="//a[text()='Add to basket']")
	WebElement addbasket;
	
	@FindBy(xpath="//a[text()='View Basket']")
	WebElement view;
	
	@FindBy(xpath="//tbody/tr/td[3]/a")
	WebElement msg;
	
	
	public Addtobasket(WebDriver d) //initializes all the elements with driver
    {
        driver=d;
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
    }
	
	public void typename(String name) //searches the item
	{
		search.sendKeys(name);
		search.sendKeys(Keys.ENTER);
	}
	
	public void selectlink() //clicks on html link
	{
		links.click();
	}
	
	public void filter1() //selects default sorting
	{
		filter.click();
	}
	public void selectfilter() //selects default sorting
	{
		defaultsorting.click();
	}
	public void addtobasket() //clicks add to basket and clicks view basket
	{
		addbasket.click();
		view.click();
	}
	public void message() //quits driver
	{
		driver.quit();
	}
	
}

