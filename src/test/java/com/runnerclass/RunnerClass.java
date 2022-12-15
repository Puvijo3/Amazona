 package com.runnerclass;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.baseClassAma.BaseclassAma;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;    

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//java//com//feature//Amazon.feature", glue="com.stepdefinition",monochrome=true,plugin= {"pretty",
        "html:Report/htmlReport.html",
        "json:Report/jsonreport.json",
        "junit:Report/junitReport.xml",
        //"com.cucumber.listener.ExtentCucumberFormatter:Report/ExtentReport.html"
        })

public class RunnerClass extends BaseclassAma {
	public static WebDriver driver=null;
	@BeforeClass
	public static void setUp() {
	driver=browserLaunch("chrome");
	
		
		

	}
	@AfterClass
	public static void tearDown() {
close();
	}

}
