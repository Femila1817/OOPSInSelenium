package com.MyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	
	private By Header =  By.xpath("//div[@class='private-header__title private-page__title']");
	

	public HomePage(WebDriver driver) {
		super(driver);

	}
	public WebElement getHeader() {
		return getElement(Header);
	}
	
	public String getHomePageTitle() {
		return getPageTitle();
	}

	public String getHomePageHeader() {
		return getPageHeader(Header);
		
	}
}
