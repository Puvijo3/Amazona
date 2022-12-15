package com.web.pomama;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public WebDriver driver;
	@FindBy(xpath="//div[@class='autocomplete-results-container']/child::div[1]")
	private WebElement buttons;
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal']")
	private List<WebElement> opti;
	public ProductPage(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}
	public WebElement getButtons() {
		return buttons;
	}
	public List<WebElement> getOption() {
		return opti;
	}

}
