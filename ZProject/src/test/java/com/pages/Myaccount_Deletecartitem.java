package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cts.utility.Base;

public class Myaccount_Deletecartitem extends Base {

	@FindBy(xpath="//ul/li/a")
	WebElement shop;
	
	@FindBy(xpath="//a[text()='Add to basket']")
	WebElement additem;
	
	@FindBy(xpath="//a[text()='View Basket']")
	WebElement viewitem;
	
	@FindBy(xpath="//body//form//tr//td/a[@class='remove']")
	WebElement deleteitem;
	
	
	public Myaccount_Deletecartitem(WebDriver d) //initializes all the elements with driver
    {
        driver=d;
        PageFactory.initElements(driver,this);
		driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
    }

	public void click_shop() //clicks on shop
	{
		shop.click();
	}
	public void click_additem() //clicks on add item
	{
		additem.click();
	}
	public void click_viewitem() //clicks on view item
	{
		viewitem.click();
	}
	public void click_deleteitem() //deletes the item
	{
		deleteitem.click();
	}
	public void delete_message() // gets message and quits driver
	{
		driver.quit();
	}
}
