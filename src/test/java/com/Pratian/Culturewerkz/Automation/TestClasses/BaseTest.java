package com.Pratian.Culturewerkz.Automation.TestClasses;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Pratian.Culturewerkz.Automation.FileHandling.PropertyManager;


public class BaseTest {
	
	com.Pratian.Culturewerkz.Automation.Utils.ReadConfig readconfig=new com.Pratian.Culturewerkz.Automation.Utils.ReadConfig();
	
	static Logger log = LogManager.getLogger(BaseTest.class);
	static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) throws IOException
	{
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		
	}
	
	public WebDriver getDriver()
    {
        return driver;
     
     }
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	

}
