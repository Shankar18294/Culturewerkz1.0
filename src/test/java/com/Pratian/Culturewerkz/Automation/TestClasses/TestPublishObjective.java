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

public class TestPublishObjective extends BaseTest {
	
	@Test(dataProvider = "signIn")
	public void publishObjective(String userName,String password) throws IOException
	{
		
		/*Check whether or not user is able to publish the objective*/

		driver.get(PropertyManager.getProperty("url.app"));
		SignIn signIn=new SignIn(driver);
		signIn.provideUserName(userName);
		signIn.providePassword(password);
		signIn.clickSignInButton(driver);
		
		Home home = new Home(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		home.clickNewOkr(driver);
		
		
		
		Objective objective=new Objective(driver);
		objective.setTitle("mobile automation  testing");
		objective.setDescription("mobile automation started running");
		objective.selectCategory();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		objective.startingDate();
		objective.endDate();
		objective.clickPublishButton();
		//WebDriverWait wait = new WebDriverWait(driver, 30);
       //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"leftdiv\\\"]/div[1]/div[1]/span")));
		//boolean result = objective.objectiveDisplayed();
		//Assert.assertEquals(result, true);	
		
	}
	@DataProvider(name="signIn")			
	public Object[][] getCredentials()
	{			

		return new Object[][] 
				{				

			{"kk@pratian.com","password@123"} 	

				};
	}

}
