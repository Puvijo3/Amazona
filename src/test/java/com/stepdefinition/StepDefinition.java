package com.stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.amazon.Amazon_maven.Datadriven;
import com.baseClassAma.BaseclassAma;
import com.runnerclass.RunnerClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinition extends BaseclassAma{
	public static WebDriver driver=RunnerClass.driver;
	
	@Given("^user Launch The Application$")
	public void user_Launch_The_Application() throws Throwable {
		getUrl("https://www.amazon.in/");
		
	}

	@When("^user Select The Drop Down$")
	public void user_Select_The_Drop_Down() throws Throwable {
		implicity();
		WebElement sele=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		//String expected=Datadriven.allData("Amazon", 0, 0);
		String expected="Watches";
		Select choose=new Select(sele);
		thread();
		List<WebElement> options=choose.getOptions();
	for (WebElement web : options) {
		String tex=web.getText();
		if(expected.equalsIgnoreCase(tex)) {
			choose.selectByVisibleText(expected);
			}
		else {   
			
			continue;
		}
	}
	 
	}

	@When("^user Enter Product In Searchbox$")
	public void user_Enter_Product_In_Searchbox() throws Throwable {
		thread();
		WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		//String searchop=Datadriven.allData("Amazon", 1, 1);
		String searchop="kids";
		search.sendKeys(searchop);
	thread5();
	   
	}

	@Then("^user Click The Search Option$")
	public void user_Click_The_Search_Option() throws Throwable {
		WebElement resul = driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/child::div[1]"));
		clickOnWE(resul);
		thread5();

	}

	@Then("^user Get The Total Count$")
	public void user_Get_The_Total_Count() throws Throwable {
		List<WebElement> opt=driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		for (WebElement webElement : opt) {
			String text=webElement.getText();
			System.out.println(text);
			
		}
		
		System.out.println("total products"+ "="+opt.size());
		
  
	}


}
