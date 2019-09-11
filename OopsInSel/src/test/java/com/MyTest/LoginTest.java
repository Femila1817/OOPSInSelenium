package com.MyTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyPages.HomePage;
import com.MyPages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test(priority = 1, enabled=true)
	public void verifyLoginPageTitleTest() {
		String title = page.getInstance(LoginPage.class).getPageTitle();
		
		System.out.println("Login Page Title : " +title);
		Assert.assertEquals(title, "HubSpot Login");
	}
	
	@Test(priority = 2, enabled=true)
	public void verifyLoginPageHeaderTest() {
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		
		System.out.println("Header : " +header);
		Assert.assertEquals(header, "Don't have an account?");
	}
	
	@Test(priority = 3)
	public void doLoginTest() {
		HomePage homePage = page.getInstance(LoginPage.class).doLogin("dfemila90@gmail.com", "hfnIT2013");
		
		String homeHeader = homePage.getHomePageHeader();
		System.out.println(homeHeader);
		Assert.assertEquals(homeHeader, "Getting started with HubSpot");
	}

}
