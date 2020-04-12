package com.stepdefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cts.utility.Base;
import com.pages.Myaccount_Accountdetails;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_Myaccount_accountdetails extends Base {

	Base b = new Base();
	Myaccount_Accountdetails my_accdet;
	
	public static Logger logger = LogManager.getLogger(Test_Myaccount_accountdetails.class.getName());
	
	@Given("User on homepage1")
	public void user_on_homepage1() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		prop=b.initiateproperties();
	    driver=b.intiatedriver(prop.getProperty("browser"));
	    driver.get(prop.getProperty("url"));
	    driver.manage().window().maximize();
	    logger.debug("Navigated to the specified url");
	    
	}

	@Given("User on login page1")
	public void user_on_login_page1() {
		// Write code here that turns the phrase above into concrete actions
		my_accdet= new Myaccount_Accountdetails(driver);
		b.startTest("Test_Myaccount_accountdetails");
		 if(driver.getTitle().equals("Automation Practice Site"))
		    {
		    	test.log(LogStatus.PASS, "Navigated to the specified url");
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Test Failed");
		    }
		my_accdet.myaccount();
		logger.info("Navigated to the Myaccount");
	}

	@When("User clicks login button1")
	public void user_clicks_login_button1() {
		// Write code here that turns the phrase above into concrete actions
		String un = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		my_accdet.sendkeys1(un, pwd);
		logger.info("Entered username and password");
		my_accdet.login();
		if(driver.getTitle().equals("My Account – Automation Practice Site"))
	    {
	    	test.log(LogStatus.PASS, "Sucessfully login completed");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
	}

	@When("User clicks on Accountdetails1")
	public void user_clicks_on_Accountdetails1() {
		// Write code here that turns the phrase above into concrete actions
		logger.error("Navigating to your account");
		my_accdet.click_accountdetails();
	}

	@When("User enters {string} and {string} and {string}")
	public void user_enters_and_and(String string, String string2, String string3) {
		// Write code here that turns the phrase above into concrete actions
		my_accdet.credentials(string, string2, string3);
		logger.info("Entered new password");
	}

	@Then("User lands on password changed successfully")
	public void user_lands_on_password_changed_successfully() throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Password changed successfully");
		Thread.sleep(1000);
		b.takeScreenshot("Myaccount_Accountdetails");
		if(driver.getTitle().equals("My Account – Automation Practice Site"))
	    {
	    	test.log(LogStatus.PASS, "Account Details changed successfully");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
		b.endTest();
		my_accdet.success_message();
	}




}