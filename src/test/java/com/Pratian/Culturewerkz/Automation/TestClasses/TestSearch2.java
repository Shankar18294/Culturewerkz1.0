package com.Pratian.Culturewerkz.Automation.TestClasses;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pratian.Culturewerkz.Automation.FileHandling.PropertyManager;
import com.Pratian.Culturewerkz.Automation.PageObjects.Home;
import com.Pratian.Culturewerkz.Automation.PageObjects.SignIn;

public class TestSearch2 extends BaseTest {
	
	static Logger log = LogManager.getLogger(TestSearch2.class);

	@Test(priority = 1, dataProvider = "signIn") 
	public void search(String userName, String password) throws IOException {

		driver.get(PropertyManager.getProperty("url.app")); 
		SignIn signIn= new
				SignIn(driver); signIn.provideUserName(userName);
				signIn.providePassword(password); signIn.clickSignInButton(driver);

	}



	@Test (priority = 2, dataProvider = "search")
	public void search(String search1)
	{
		/*Check whether the user is able to provide at least 3 characters of a person
		 in the organization in the search box and able to view the search result 
		 matching the characters he provided*/


		Home home = new Home(driver);
		home.provideUserSearch(search1);
		log.debug("Entered name in the search field");
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div/div/ul/li[2]")));

		//Implementing fluent wait
		WebElement searchResult = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div/div/ul/li[2]"));
		new FluentWait<WebDriver>(driver) 
		.withTimeout(Duration.ofSeconds(30))
		.pollingEvery(Duration.ofMillis(500)) .ignoring(NoSuchElementException.class)
		.until(ExpectedConditions.visibilityOf(searchResult));

		home.autoSearch();

	}



	@DataProvider(name="signIn") public Object[][] getCredentials() {

		return new Object[][] {

			{"kk@pratian.com","password@123"},

		}; 
	}


	@DataProvider(name="search")			
	public Object[][] getSearch() {			

		return new Object[][] {				

			{"abhijit"},
			{"ABHIJIT"},
			{"Abhijit"}

		};
	}

}

