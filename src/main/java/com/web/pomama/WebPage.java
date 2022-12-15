package com.web.pomama;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class  WebPage{
	public static WebDriver driver;
	@FindBy(xpath="//select[@id='searchDropdownBox']")
	private WebElement dropdown;
    @FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement search;
	

	 
    public WebPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
	public WebElement getDropdown() {
		return dropdown;
	}
	public WebElement getSearch() {
		return search;
	}
	
	
	
}
