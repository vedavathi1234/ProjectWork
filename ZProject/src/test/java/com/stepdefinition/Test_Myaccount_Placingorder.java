package com.stepdefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cts.utility.Base;
import com.pages.Myaccount_Placingorder;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_Myaccount_Placingorder extends Base {

	Base b=new Base();
	Myaccount_Placingorder acc_placeorder;
	private static Logger logger=(Logger) LogManager.getLogger(Myaccount_Placingorder.class);
	
	@Given("Enters the home page")
	public void enters_the_home_page() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		prop=b.initiateproperties();
	    driver=b.intiatedriver(prop.getProperty("browser"));
	    driver.get(prop.getProperty("url"));
		logger.debug("Entered to home page");
		acc_placeorder = new Myaccount_Placingorder(driver);
		b.startTest("Test_Myaccount_Placingorder");
		 if(driver.getTitle().equals("Automation Practice Site"))
		    {
		    	test.log(LogStatus.PASS, "Navigated to the specified url");
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Test Failed");
		    }
	}

	@When("User login with valid credentials")
	public void user_login_with_valid_credentials() {
		// Write code here that turns the phrase above into concrete actions
		acc_placeorder.myaccount();
		logger.info("Navigated to the Myaccount");
		String un = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		acc_placeorder.sendKeys1(un, pwd);
		logger.info("Entered username and password");
		acc_placeorder.login();
		if(driver.getTitle().equals("My Account – Automation Practice Site"))
	    {
	    	test.log(LogStatus.PASS, "Sucessfully login completed");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
		logger.error("Clicked on login button");
	}

	@Then("User clicks on shop")
	public void user_clicks_on_shop() {
		// Write code here that turns the phrase above into concrete actions
		acc_placeorder.click_shop();
		if(driver.getTitle().equals("Products – Automation Practice Site"))
	    {
	    	test.log(LogStatus.PASS, "Navigated to Shop");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
		logger.info("Navigated to the shop");
	}

	@Then("User select an item to basket and view the product")
	public void user_select_an_item_to_basket_and_view_the_product() {
		// Write code here that turns the phrase above into concrete actions
		acc_placeorder.click_addtobasket();
		acc_placeorder.click_viewbasket();
		if(driver.getTitle().equals("Basket – Automation Practice Site"))
	    {
	    	test.log(LogStatus.PASS, "Added to the basket");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
		logger.info("Added item to the basket and clicked to view the basket");
	
	}

	@Then("Clicks on proceed")
	public void clicks_on_proceed() {
		// Write code here that turns the phrase above into concrete actions
	  acc_placeorder.click_proceed();
	  if(driver.getTitle().equals("Checkout – Automation Practice Site"))
	    {
	    	test.log(LogStatus.PASS, "Proceeded to checkout");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
	  logger.info("Clicked on proceed");
	}

	@Then("Moveon to place order")
	public void moveon_to_place_order() {
		// Write code here that turns the phrase above into concrete actions
		acc_placeorder.click_placeorder();
		if(driver.getTitle().equals("Checkout – Automation Practice Site"))
	    {
	    	test.log(LogStatus.PASS, "Proceeded to placeorder");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
		logger.info("Placed order");
	}

	@Then("User lands on other page which shows order is successfull")
	public void user_lands_on_other_page_which_shows_order_is_successfull() throws IOException, InterruptedException {
		Thread.sleep(1000);
		b.takeScreenshot("Myaccount_Placingorder");
		b.endTest();
		acc_placeorder.order_message();
	}
}
