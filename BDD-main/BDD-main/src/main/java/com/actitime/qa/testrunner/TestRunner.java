package com.actitime.qa.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"D:/BDD-main/BDD-main/src/main/java/com/actitime/qa/feature/Loging.feature,D:/BDD-main/BDD-main/src/main/java/com/actitime/qa/feature/CreateUser.feature"}
		,glue={"com/actitime/qa/stepdefinitions"}
		,monochrome = true,
				strict=true,
				dryRun=false
				
		)




public class TestRunner {
	
	
	

}
