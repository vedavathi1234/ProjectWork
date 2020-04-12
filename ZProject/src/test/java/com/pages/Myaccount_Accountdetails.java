package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cts.utility.Base;

public class Myaccount_Accountdetails extends Base {

	@FindBy(xpath="//ul/li[2][@id='menu-item-50']/a")
	WebElement account;
	
	@FindBy(name="username")
	WebElement enteruser;
	
	@FindBy(id="password")
    WebElement enterpass;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement login;
	
	@FindBy(linkText="Account Details")
	WebElement accountdetails;
	
	@FindBy(xpath="//input[@id='password_current']")
	WebElement currentpassword;
	
	@FindBy(xpath="//input[@id='password_1']")
	WebElement newpassword;
	
	@FindBy(xpath="//input[@id='password_2']")
	WebElement confirmpassword;
	
	@FindBy(xpath="//p/input[@name='save_account_details']")
	WebElement savechanges;
	
	@FindBy(xpath="//div[@class='woocommerce-message']")
	WebElement success;
	
	public Myaccount_Accountdetails(WebDriver d) //initializes all the elements with driver
    {
        driver=d;
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
    }
	public void myaccount() //clicks my account
	{
		account.click();
	}
	
	public void sendkeys1(String susername, String spassword) //enters username and password
    {
         enteruser.sendKeys(susername);
         enterpass.sendKeys(spassword);
            
    }
	
	 public void login() //clicks login
	  {
		  login.click();
	  }
	  
	  public void click_accountdetails() //clicks account details
	  {
		  accountdetails.click();
	  }
	  public void credentials(String str1, String str2, String str3) //enters the details
	  {
		  currentpassword.sendKeys(str1);
		  newpassword.sendKeys(str2);
		  confirmpassword.sendKeys(str3);
		  savechanges.submit();
	  }
	  public void success_message() //gets message and quits driver
	  {
		  System.out.println(success.getText());
		  driver.quit();
	  }
	  
	  
	 

}
