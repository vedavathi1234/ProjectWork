package com.stepdefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cts.utility.Base;
import com.pages.Addtobasket;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_Addtobasket extends Base{
	
	Base b = new Base();
	Addtobasket addbas;
	
	public static Logger logger = LogManager.getLogger(Test_Addtobasket.class.getName());
	
	@Given("User on homepage2")
	public void user_on_homepage2() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		prop=b.initiateproperties();
	    driver=b.intiatedriver(prop.getProperty("browser"));
	    driver.get(prop.getProperty("url"));
	    driver.manage().window().maximize();
	    logger.debug("Navigated to the specified url");
	    addbas= new Addtobasket(driver);
	    b.startTest("Test_Addtobasket");
	    if(driver.getTitle().equals("Automation Practice Site"))
	    {
	    	test.log(LogStatus.PASS, "Navigated to the specified url");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
	}

	@When("User searches the product")
	public void user_searches_the_product() {
		// Write code here that turns the phrase above into concrete actions
		addbas.typename("html");
		logger.info("searched the product");
		if(driver.getTitle().equals("Search Results for “html” – Automation Practice Site"))
	    {
	    	test.log(LogStatus.PASS, "Searched for the product");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
		
	}

	@When("User select the product")
	public void user_select_the_product() {
		// Write code here that turns the phrase above into concrete actions
		addbas.selectlink();
		logger.info("selected the type of the product");
		if(driver.getTitle().equals("HTML – Automation Practice Site"))
	    {
	    	test.log(LogStatus.PASS, "Selected the type of product");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
	}

	@When("User select the filter")
	public void user_select_the_filter() {
		// Write code here that turns the phrase above into concrete actions
		addbas.filter1();
		logger.info("Added filter");
	}

	@When("User click the product")
	public void user_click_the_product() {
		addbas.selectfilter();
		logger.info("selected the final product");
	}

	@When("User add to basket")
	public void user_add_to_basket() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		addbas.addtobasket();
		logger.info("Added to the basket");
		if(driver.getTitle().equals("Basket – Automation Practice Site"))
	    {
	    	test.log(LogStatus.PASS, "Added to the basket");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
		Thread.sleep(2000);
	}

	@Then("User lands on basketpage")
	public void user_lands_on_basketpage() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Landed on the basket page");
		b.takeScreenshot("Addtobasket");
		b.endTest();
		addbas.message();
	}


	

}
