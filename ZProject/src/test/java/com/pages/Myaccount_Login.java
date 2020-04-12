package com.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cts.utility.Base;


public class Myaccount_Login extends Base {

	@FindBy(xpath="//ul/li[2][@id='menu-item-50']/a")
	WebElement account;
	
	@FindBy(name="username")
	WebElement enteruser;
	
	@FindBy(id="password")
    WebElement enterpass;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement login;
	
	@FindBy(xpath="//div[@class='woocommerce-MyAccount-content']")
	WebElement home;
	
	public Myaccount_Login(WebDriver d) //initializes all the elements with driver
    {
        driver=d;
        PageFactory.initElements(driver,this);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
    }
	public void myaccount() //clicks on my account
	{
		account.click();
	}
	
	  public void sendkeys1(String susername, String spassword) //enters username and password
	    {
	         enteruser.sendKeys(susername);
	         enterpass.sendKeys(spassword);
	            
	    }
	  
	  public void login() //clicks on login button
	  {
		  login.click();
	  }
	  
	  public void loginsucess() //gets message and quits the driver
	    {
	    	System.out.println(home.getText());
	    	driver.quit();
	    }
	    
	  
}
