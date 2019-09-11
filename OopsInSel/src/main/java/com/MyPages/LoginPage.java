/**
 * 
 */
package com.MyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Femila
 *
 */
public class LoginPage extends BasePage {

	//page locators;
	
	//using By locators using private >>>>>>>>>>>>>>>>>>>>>>>>> """"Encapsulation""""
	private By logo = By.xpath("//a[contains(text(),'Poems')]");
	private By emailId = By.id("email");
	private By password = By.id("password");
	private By loginBtn = By.id("loginBtn");
	private By pageHeader = By.xpath("//i18n-string[@data-key='login.signupLink.text']");
	
	public LoginPage(WebDriver driver) {
		super(driver);

	}
	
	//public getters  --> within the class we can use
	public WebElement getLogo() {
		
		System.out.println("Logo Changed");
		return getElement(logo);
	}

	public WebElement getEmailId() {
		return getElement(emailId);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLoginBtn() {
		
		return getElement(loginBtn);
	}

	public WebElement getPageHeader() {
		return getElement(pageHeader);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getLoginPageHeader() {
		return getPageHeader(pageHeader);
		
	}
	
	//this is method to login
	
	public HomePage doLogin(String username, String password) {
		getEmailId().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginBtn().click();

		return getInstance(HomePage.class);
	}
	
	//negative test case ; login without username password  //method overloading
	public void doLogin() { //will not return anything
		getEmailId().sendKeys("");
		getPassword().sendKeys("");
		getLoginBtn().click();
	}
	
	//username : dfemila90@gmail.com
	public void doLogin(String userCredential) {
		
		if(userCredential.contains("username")) {
			getEmailId().sendKeys(userCredential.split(":")[1].trim());
		}else if(userCredential.contains("password")) {
			getEmailId().sendKeys(userCredential.split(":")[1].trim());
		}
		getLoginBtn().click();
	}
	
}
