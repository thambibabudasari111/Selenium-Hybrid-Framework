package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	public String baseUrl = readConfig.getApplicationUrl();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters ("browser")
	@BeforeClass
	public void setUp(String browser)
	{
		
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(browser.equals("ie"))
		{
			driver = new InternetExplorerDriver();
		}
		
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public static String randomString()
	{
		String generateString = RandomStringUtils.randomAlphabetic(8);
		return generateString;
	}
	
	public static String randomNum()
	{
		String generateNum = RandomStringUtils.randomNumeric(5);
		return generateNum;
	}
	
}
