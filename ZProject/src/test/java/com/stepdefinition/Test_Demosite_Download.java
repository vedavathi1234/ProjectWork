package com.stepdefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cts.utility.Base;
import com.pages.Demosite_Download;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_Demosite_Download extends Base {

	Base b = new Base();
	Demosite_Download down_file;
	
	public static Logger logger = LogManager.getLogger(Test_Demosite_Download.class.getName());
	
	@Given("User on homepage3")
	public void user_on_homepage3() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		prop=b.initiateproperties();
	    driver=b.intiatedriver(prop.getProperty("browser"));
	    driver.get(prop.getProperty("url"));
	    driver.manage().window().maximize();
	    logger.debug("Navigated to the specified url");
	    down_file= new Demosite_Download(driver);
	    b.startTest("Test_Demosite_Download");
	    if(driver.getTitle().equals("Automation Practice Site"))
	    {
	    	test.log(LogStatus.PASS, "Navigated to the specified url");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
	    
	}

	@When("Userclicks on Demosite")
	public void userclicks_on_Demosite() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Clicking on Demosite");
		down_file.Click_Demosite();
		Thread.sleep(2000);
		if(driver.getTitle().equals("Register"))
	    {
	    	test.log(LogStatus.PASS, "landed on the Register page");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
		System.out.println(driver.getTitle());
	}

	@When("User clicks on Download file")
	public void user_clicks_on_Download_file() {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Clicking on download file");
		down_file.Download_file();
		if(driver.getTitle().equals("File input - Multi select"))
	    {
	    	test.log(LogStatus.PASS, "landed on the File download page");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Test Failed");
	    }
		System.out.println(driver.getTitle());
	}

	@When("User enters the data")
	public void user_enters_the_data() {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Entering the data");
		down_file.Enter_data();
	}

	@When("User generates the file")
	public void user_generates_the_file() {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Generating the file");
		down_file.generate_file();
	}

	@When("User downloads the file")
	public void user_downloads_the_file() {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Downloading the file");
		down_file.Download_file1();
	}

	@Then("File is downloaded")
	public void file_is_downloaded() throws InterruptedException, IOException {
		// Write code here that turns the phrase above into concrete actions
		logger.info("File is downloaded");
		Thread.sleep(1000);
		b.takeScreenshot("Demosite_Download");
		b.endTest();
		down_file.file_downloaded();
	}



}
