package com.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)//to execute this test case as cucumber test
@CucumberOptions(//this annotation is used to run your cucumber file with different parameters
		features="src/main/resources/ZProjectfolder",
		tags= {"@TC_03"},
		glue= {"com.stepdefinition"},
		plugin= {"html:reports.html",
	    		 "json:JSONReport", "junit:target/myreport.xml"}
		)
@SuiteClasses({})//its acts as collection of tests
public class BillingAddress_TestRunner {

}
