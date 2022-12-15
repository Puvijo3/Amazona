package com.web.pomama;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SdpAmazon {
public WebDriver driver;
public ProductPage pp;

public WebPage getWebPage() {
	WebPage wp=new WebPage(driver);
	return wp;
	}


public ProductPage getProductPage() {
	if(pp==null) {
		pp=new ProductPage(driver);
	}
	return pp;
}
public  SdpAmazon(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

}
