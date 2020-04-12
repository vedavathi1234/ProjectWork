package com.stepdefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.cts.utility.Base;
import com.pages.Myaccount_Login;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_Myaccount_Login extends Base {

	Base b = new Base();
	Myaccount_Login acc_login;
	
	private static Logger logger = (Logger) LogManager.getLogger(Test_Myaccount_Login.class);
	
	@Given("User on homepage")
	public void user_on_homepage() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		prop=b.initiateproperties();
	    driver=b.intiatedriver(prop.getProperty("browser"));
	    driver.get(prop.getProperty("url"));
	    driver.manage().window().maximize();
	    logger.debug("Navigated to the specified url");
	    
	}

	@Given("User on login page")
	public void user_on_login_page() {
		// Write code here that turns the phrase above into concrete actions
		acc_login= new Myaccount_Login(driver);
		b.startTest("Test_Myaccount_Login");
		 if(driver.getTitle().equals("Automation Practice Site"))
		    {
		    	test.log(LogStatus.PASS, "Navigated to the specified url");
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Test Failed");
		    }
		acc_login.myaccount();
		logger.info("Navigated to the Myaccount");
	}

	@When("User enters username and password")
	public void user_enters_username_and_password() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		String[] names = new String[2];
		names=b.datadriven_excel();
		String un = names[0];
		String pwd = names[1];
		acc_login.sendkeys1(un, pwd);
		logger.info("Entered username and password");
	}

	@When("user clicks login button")
	public void user_clicks_login_button() {
		// Write code here that turns the phrase above into concrete actions
		acc_login.login();
		logger.error("Clicked on login button");
	}

	@Then("User lands on homepage")
	public void user_lands_on_homepage() throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(1000);
		logger.info("Login sucessfull");
		b.takeScreenshot("Myaccount_Login");
		 System.out.println(driver.getTitle());
		    if(driver.getTitle().equals("My Account – Automation Practice Site"))
		    {
		    	test.log(LogStatus.PASS, "Sucessfully login completed");
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Test Failed");
		    }
		    b.endTest();
		acc_login.loginsucess();
		
		
	}



}
