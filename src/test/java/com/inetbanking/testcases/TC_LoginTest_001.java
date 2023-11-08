package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	
	@Test
	public void loginTest() throws IOException
	{
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(username);
		loginPage.setPassword(password);
		loginPage.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePge"))
		{
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		}
		
		
		
	}
}
