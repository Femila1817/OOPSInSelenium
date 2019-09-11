package com.MyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.MyPages.BasePage;
import com.MyPages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	
	WebDriver driver;
	public Page page;
	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public void setUP(String browser) throws InterruptedException {
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			System.out.println("Eror is browser name; please check the browser naeme");
		}
		
		
		//driver.get("https://app.hubspot.com/login");
		driver.get("https://mijainscribes.wordpress.com/");
		Thread.sleep(6000);
		page = new BasePage(driver);
		
	}

	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}