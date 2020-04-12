package com.stepdefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cts.utility.Base;
import com.pages.Myaccount_Billingaddress;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_BillingAddress extends Base{
	
	Base b=new Base();
	Myaccount_Billingaddress acc_billing;
	private static Logger logger=(Logger) LogManager.getLogger(Test_BillingAddress.class.getName());


	@Given("User on home page1")
		public void user_on_home_page1() throws IOException {
		// Write code here that turns the phrase above into concrete actions
			prop=b.initiateproperties();
		    driver=b.intiatedriver(prop.getProperty("browser"));
		    driver.get(prop.getProperty("url"));
		    driver.manage().window().maximize();
			logger.debug("navigating to the url");
	}

	@Given("User enters to login page")
	public void user_enters_to_login_page() {
		// Write code here that turns the phrase above into concrete actions
		 acc_billing=new Myaccount_Billingaddress(driver);
		 b.startTest("Test_BillingAddress");
		 if(driver.getTitle().equals("Automation Practice Site"))
		    {
		    	test.log(LogStatus.PASS, "Navigated to the specified url");
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Test Failed");
		    }
		 acc_billing.myaccount();
		 logger.info("Navigating to myaccount");
	}

	@When("User enters details and clicks login button")
	public void user_enters_details_and_clicks_login_button() {
		// Write code here that turns the phrase above into concrete actions
		String un = prop.getProperty("username");
		String pwd = prop.getProperty("password");
	    acc_billing.sendKeys1(un, pwd);
	    acc_billing.login();
		logger.info("entered username and password");
		if(driver.getTitle().equals("My Account – Automation Practice Site"))
	    {
	    	test.log(LogStatus.PASS, "Sucessfully login completed");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
		
	}

	@When("User clicks on Address")
	public void user_clicks_on_Address() {
		// Write code here that turns the phrase above into concrete actions
		acc_billing.click_address();
	}

	@When("User click on edit option")
	public void user_click_on_edit_option() {
		// Write code here that turns the phrase above into concrete actions
		acc_billing.click_edit();
		logger.info("clicked on edit billing address");
	}

	@Then("Start entering details {string} {string} {string} {string} {string} {string} {string} {string}")
	public void start_entering_details(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
		// Write code here that turns the phrase above into concrete actions
		 acc_billing.credentials(string, string2, string3, string4, string5, string6, string7, string8);
		 logger.info("edited the billing address");
	}

	@Then("Click on savechanges")
	public void click_on_savechanges() {
		// Write code here that turns the phrase above into concrete actions
		acc_billing.click_savechanges();
		logger.info("clicked on save changes");
	}

	@Then("User get saving notification")
	public void user_get_saving_notification() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		b.takeScreenshot("Myaccount_Billingaddress");
	    
	    if(driver.getTitle().equals("My Account – Automation Practice Site"))
	    {
	    	test.log(LogStatus.PASS, "Billing Address changed successfully");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
	    b.endTest();
		acc_billing.success_message();
	}



}
