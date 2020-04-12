package com.stepdefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cts.utility.Base;
import com.pages.Myaccount_Deletecartitem;
import com.pages.Myaccount_Placingorder;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Test_Myaccount_Deletecartitem extends Base{

	Base b=new Base();
	Myaccount_Deletecartitem acc_remove;
	private static Logger logger=(Logger) LogManager.getLogger(Myaccount_Placingorder.class);
	
	@Given("User on home page6")
	public void user_on_home_page6() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		prop=b.initiateproperties();
	    driver=b.intiatedriver(prop.getProperty("browser"));
	    driver.get(prop.getProperty("url"));
		logger.debug("Entered to home page");
		acc_remove = new Myaccount_Deletecartitem(driver);
		b.startTest("Test_Myaccount_Deletecartitem");
		 if(driver.getTitle().equals("Automation Practice Site"))
		    {
		    	test.log(LogStatus.PASS, "Navigated to the specified url");
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Test Failed");
		    }
	}
	@Given("select the shop for a product and add to cart")
	public void select_the_shop_for_a_product_and_add_to_cart() {
		// Write code here that turns the phrase above into concrete actions
		acc_remove.click_shop();
		if(driver.getTitle().equals("Products – Automation Practice Site"))
	    {
	    	test.log(LogStatus.PASS, "Navigated to Shop");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
		acc_remove.click_additem();
		logger.error("Users logged with valid credentials");
	}
	@Then("clicks on view basket")
	public void clicks_on_view_basket() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		acc_remove.click_viewitem();
		if(driver.getTitle().equals("Basket – Automation Practice Site"))
	    {
	    	test.log(LogStatus.PASS, "Added to the basket");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
		Thread.sleep(2000);
		logger.error("Clicks on view basket");

	}

	@Then("delete the unwanted item")
	public void delete_the_unwanted_item() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		acc_remove.click_deleteitem();
		logger.error("Unwanted product is removed");
	}

	@Then("deleted message appear on screen")
	public void deleted_message_appear_on_screen() throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Deleted message appears on screen");
		Thread.sleep(2000);
		b.takeScreenshot("Myaccount_Deletecartitem");
		b.endTest();
		acc_remove.delete_message();
		

	}

}
