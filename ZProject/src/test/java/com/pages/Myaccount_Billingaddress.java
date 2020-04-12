package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cts.utility.Base;

public class Myaccount_Billingaddress extends Base {
	
	@FindBy(xpath="//ul/li[2][@id='menu-item-50']/a")
	WebElement account;
	@FindBy(name="username")
	WebElement user;	
	@FindBy(name="password")
	WebElement pass;	
	@FindBy(xpath="//input[@name='login']")
	WebElement login;	
	@FindBy(linkText="Addresses")
	WebElement address;
	@FindBy(linkText="Edit")
	WebElement edit;
	@FindBy(name="billing_first_name")
	WebElement firstname;
	@FindBy(name="billing_last_name")
	WebElement lastname;
	@FindBy(name="billing_company")
	WebElement companyname;
	@FindBy(name="billing_email")
	WebElement email;
	@FindBy(name="billing_phone")
	WebElement phone;
	@FindBy(name="billing_address_1")
	WebElement address1;
	@FindBy(name="billing_address_2")
	WebElement address2;
	@FindBy(name="billing_city")
	WebElement city;
	@FindBy(xpath="//input[@name='save_address']")
	WebElement saving;
	@FindBy(xpath="//div[@class='woocommerce-message']")
	WebElement success;
	public Myaccount_Billingaddress(WebDriver d) //initializes all the elements with driver
	{
		driver=d;
		PageFactory.initElements(driver,this);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 }
	public void myaccount() //clicks myaccount
	{
		account.click();
	}
	public void sendKeys1(String username,String password) //enters username and password
	{
		user.sendKeys(username);
		pass.sendKeys(password);
		
	}
	public void login() //clicks login
	{
		login.click();
		
	}
	public void click_address() { //clicks address details
		address.click();
	}
	public void click_edit()  //clicks on edit billing address details
	{
		edit.click();
	}
	public void credentials(String str1,String str2,String str3,String str4,String str5,String str6,String str7,String str8) //enters all details
	{
		firstname.clear();
		firstname.sendKeys(str1);
		lastname.clear();
		lastname.sendKeys(str2);
		companyname.clear();
		companyname.sendKeys(str3);
		email.clear();
		email.sendKeys(str4);
		phone.clear();
		phone.sendKeys(str5);
		address1.clear();
		address1.sendKeys(str6);
		address2.clear();
		address2.sendKeys(str7);
		city.clear();
		city.sendKeys(str8);
	}
	public void click_savechanges() //clicks on savechanges
	{
		saving.click();
	}
	public void success_message() //gets message and quits driver
	{
		System.out.println(success.getText());
		driver.quit();
}	
}
