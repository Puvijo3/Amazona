package com.amazon.Amazon_maven;
	import java.io.IOException;
	import java.util.List;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	public class Amazon1 {
		static void screen() throws InterruptedException, IOException  {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\puvana\\eclipse-workspace\\Miniproject\\chromedriver\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			WebElement sele=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
			String expected=Datadriven.allData("Amazon", 0, 0);
			Select choose=new Select(sele);
			Thread.sleep(1000);
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
		Thread.sleep(2000);
		WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		String searchop=Datadriven.allData("Amazon", 1, 1);
		search.sendKeys(searchop);
	Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/child::div[1]")).click();
			Thread.sleep(5000);
		List<WebElement> opt=driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		for (WebElement webElement : opt) {
			String text=webElement.getText();
			//System.out.println(text);
			
		}
		
		System.out.println("total products"+ "="+opt.size());
		Thread.sleep(3000);
		//driver.quit();
		  
	}
		public static void main(String[] args) throws InterruptedException, IOException {
			screen();
		}
		}


