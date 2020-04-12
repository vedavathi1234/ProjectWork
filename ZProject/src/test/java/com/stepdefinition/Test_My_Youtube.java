package com.stepdefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cts.utility.Base;
import com.pages.My_Youtube;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_My_Youtube extends Base{

	Base b=new Base();
	My_Youtube tube;
	
	public static Logger logger = LogManager.getLogger(Test_Myaccount_accountdetails.class.getName());
	
	@Given("User on homepage4")
	public void user_on_homepage4() throws IOException{
		// Write code here that turns the phrase above into concrete actions
		prop=b.initiateproperties();
	    driver=b.intiatedriver(prop.getProperty("browser"));
	    driver.get(prop.getProperty("url"));
	    driver.manage().window().maximize();
	    logger.debug("Navigated to the specified url");
	}

	@When("User clicks on Demosite")
	public void user_clicks_on_Demosite() {
		// Write code here that turns the phrase above into concrete actions
		tube=new My_Youtube(driver);
		 b.startTest("Test_My_Youtube");
		 if(driver.getTitle().equals("Automation Practice Site"))
		    {
		    	test.log(LogStatus.PASS, "Navigated to the specified url");
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Test Failed");
		    }
		tube.Click_Demosite();
		logger.info("Navigated to the demosite");
		if(driver.getTitle().equals("Register"))
	    {
	    	test.log(LogStatus.PASS, "landed on the Register page");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
	}

	@When("User clicks on vimeo button")
	public void user_clicks_on_vimeo_button() {
		// Write code here that turns the phrase above into concrete actions
		tube.Download_file();
		logger.info("Clicked on vimeo");
		if(driver.getTitle().equals("Youtube"))
	    {
	    	test.log(LogStatus.PASS, "landed on the Youtube page");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
	}

	@Then("video is played")
	public void video_is_played() throws InterruptedException, IOException {
		// Write code here that turns the phrase above into concrete actions
	    tube.playclick();
	    logger.info("Clicked on play");
	    Thread.sleep(2000);
	    b.takeScreenshot("My_Youtube");
	    b.endTest();
	    tube.end();
	}

	
}
