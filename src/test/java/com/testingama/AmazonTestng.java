package com.testingama;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.baseClassAma.BaseclassAma;


public class AmazonTestng extends BaseclassAma {
	public WebDriver driver=null;
	@Test(priority = 0)
	public void browserLaunch() {
		driver=browserLaunch("chrome");
		getUrl("https://www.amazon.in/");
	}
	@Test(priority = 1)
	public void searchBox() throws InterruptedException {
		WebElement dropdown=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		String expected="Watches";
		Select choose=new Select(dropdown);
		List<WebElement> options=choose.getOptions();
	
thread();
	for(int i=0;i< options.size();i++) {
		String actual=options.get(i).getText();
		if(expected.equalsIgnoreCase(actual)) {
			choose.selectByVisibleText(actual);
			}
		else {      
			continue;
		}
	}
	 }  
	@Test(priority = 2)
	public void enterSearch() throws InterruptedException {
		implicity();
		WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		String searchop="kids";
		//search.sendKeys(searchop);
		sendKeys(search, searchop);
		WebElement buttons = driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/child::div[1]"));
		clickOnWE(buttons);
	}
	@Test(priority = 3)
	public void getCount() throws InterruptedException {
		
		List<WebElement> opt=driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		for (WebElement webElement : opt) {
			String text=webElement.getText();
			System.out.println(text);
			
		}
		
		System.out.println("total products"+ "="+opt.size());
	}

}
