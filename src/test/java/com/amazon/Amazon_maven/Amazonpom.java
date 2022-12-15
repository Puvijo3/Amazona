  package com.amazon.Amazon_maven;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.baseClassAma.BaseclassAma;
import com.property.ConfigurationHelperA;
import com.web.pomama.SdpAmazon;
import com.web.pomama.WebPage;

public class Amazonpom extends BaseclassAma{
	public static WebDriver driver=null;
	public static void main(String[] args) throws IOException, InterruptedException {
		String browser=ConfigurationHelperA.getInstance().getBrowser();
		driver=browserLaunch(browser);
		SdpAmazon sa=new SdpAmazon(driver);
		String url=ConfigurationHelperA.getInstance().getUrl();
		getUrl(url);
		implicity();
		//String expected="Watches";
		String sheet=ConfigurationHelperA.getInstance().getSheet();
		String expected=Datadriven.allData(sheet, 0, 0);
		Select choose=new Select(sa.getWebPage().getDropdown());
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
	    implicity();
        //String searchop="kids";
	    String searchop=Datadriven.allData(sheet, 1, 1);
		sendKeys(sa.getWebPage().getSearch(), searchop);
		thread();   
		clickOnWE(sa.getProductPage().getButtons());
		for (WebElement webElement : sa.getProductPage().getOption()) {
			String text=webElement.getText();
			//System.out.println(text);
			
		}
		
		System.out.println("total products"+ "="+sa.getProductPage().getOption().size());
		thread5();
		close();
	}

}