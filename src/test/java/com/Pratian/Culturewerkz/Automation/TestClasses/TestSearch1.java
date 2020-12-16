package com.Pratian.Culturewerkz.Automation.TestClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pratian.Culturewerkz.Automation.FileHandling.PropertyManager;
import com.Pratian.Culturewerkz.Automation.PageObjects.Home;
import com.Pratian.Culturewerkz.Automation.PageObjects.SignIn;

public class TestSearch1 extends BaseTest {
	
	@Test(priority = 1, dataProvider = "signIn")
	public void search(String userName, String password) throws IOException
	{
		
		driver.get(PropertyManager.getProperty("url.app"));
		SignIn signIn= new SignIn(driver);
		signIn.provideUserName(userName);
		signIn.providePassword(password);
		signIn.clickSignInButton(driver);
		
				
	}
	
	@Test(priority = 2, dataProvider = "search")
	public void search(String search1)
	{
		/*Check whether the user is able to provide at least 3 characters of a person
		 in the organization in the search box and able to view the search result 
		 matching the characters he provided*/
		
		Home home = new Home(driver);
		home.provideUserSearch(search1);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div/div/ul/li[2]")));
		home.autoSearch();
		
	}
	

	@DataProvider(name="signIn")			
	public Object[][] getCredentials() {			

		return new Object[][] {				

			{"kk@pratian.com","password@123"},

		};
	}
	
	@DataProvider(name="search")			
	public Object[][] getSearch() {			

		return new Object[][] {				
			
			{"abh"},
			{"ABH"},
			{"Abh"}

		};
	}

}
