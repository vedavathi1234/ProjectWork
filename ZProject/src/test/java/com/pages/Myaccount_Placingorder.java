package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cts.utility.Base;

public class Myaccount_Placingorder extends Base {

	@FindBy(xpath="//ul/li[2][@id='menu-item-50']/a")
	WebElement account;	
	@FindBy(name="username")
	WebElement user;	
	@FindBy(name="password")
	WebElement pass;	
	@FindBy(xpath="//input[@name='login']")
	WebElement login;
	@FindBy(xpath="//ul/li[1]/a")
	WebElement shop;
	@FindBy(xpath="//a[text()='Add to basket']")
	WebElement addbasket;	
	@FindBy(xpath="//a[text()='View Basket']")
	WebElement view;
	@FindBy(xpath="//div[@class='wc-proceed-to-checkout']/a")
	WebElement proceed;
	@FindBy(xpath="//*[@id=\"place_order\"]")
	WebElement placeorder;
	@FindBy(xpath="//p[@class='woocommerce-thankyou-order-received']")
	WebElement message;
	public Myaccount_Placingorder(WebDriver d) //initializes all the elements with driver
	{
		driver=d;
		PageFactory.initElements(driver,this);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void myaccount() //clicks on my account
	{
		account.click();
	}
	public void sendKeys1(String username,String password) //enters username and password
	{
		user.sendKeys(username);
		pass.sendKeys(password);
		
	}
	public void login() //clicks on login button
	{
		login.click();
		
	}
	public void click_shop() //clicks on shop
	{
		shop.click();			
	}
	public void click_addtobasket() // clicks on add to basket
	{
		addbasket.click();
	}
	public void click_viewbasket() //clicks on view basket
	{
		view.click();
	}
	public void click_proceed() //clicks on proceed to checkout
	{
		proceed.click();
	}
	public void click_placeorder() { //clicks on placeorder
		placeorder.click();
	}
	   
	public void order_message() { //gets the message and quits driver
		System.out.println(message.getText());
		driver.quit();
	}
}
