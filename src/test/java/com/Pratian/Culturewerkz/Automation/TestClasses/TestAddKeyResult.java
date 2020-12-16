package com.Pratian.Culturewerkz.Automation.TestClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pratian.Culturewerkz.Automation.FileHandling.PropertyManager;
import com.Pratian.Culturewerkz.Automation.PageObjects.Home;
import com.Pratian.Culturewerkz.Automation.PageObjects.Objective;
import com.Pratian.Culturewerkz.Automation.PageObjects.SignIn;

public class TestAddKeyResult extends BaseTest {

	@Test(dataProvider = "signIn")
	public void addKeyResult(String userName, String password) throws IOException
	{
		/*Check whether or not user is able to sign in into Culturewerkz
		with valid credentials*/

		driver.get(PropertyManager.getProperty("url.app"));
		SignIn signIn= new SignIn(driver);
		signIn.provideUserName(userName);
		signIn.providePassword(password);
		Home home= signIn.clickSignInButton(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Objective okr = new Objective(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		okr.clickonObjective(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		okr.clickonSingleObjective(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		okr.clickaddKeyResult(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		okr.provideKeyResult("Automation");
		okr.provideScore("1");
		WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"#form\"]/div[3]/div[2]/input")));
		okr.provideDueDate("12/16/2020");
		okr.clickSave(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		boolean result =  okr.displayedKeyResult();
		Assert.assertEquals(result, true);


	}


	@DataProvider(name="signIn")			
	public Object[][] getCredentials() {			

		return new Object[][] {				

			{"kk@pratian.com","password@123"} 	

		};
	}


}
