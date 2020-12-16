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

public class TestEditDraft extends BaseTest {

	@Test(dataProvider = "updatedDraftOkr")
	public void updatedDraftOkrpage(String userName, String password) throws IOException
	{

		driver.get(PropertyManager.getProperty("url.app"));
		SignIn signin = new SignIn(driver);
		signin.provideUserName(userName);
		signin.providePassword(password);
		signin.clickSignInButton(driver);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Objective obj = new Objective(driver);
		obj.clickonObjective(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		obj.clickonDrafts(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		obj.clickonDraftedObjective(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		obj.provideTitle("Automation");
		obj.clickonButtonSaveAsDraft(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		obj.clickonDrafts(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div[2]/div[1]/div/div[2]/div/div[1]/a/div/div[2]/div/div/h6")));
		boolean result = obj.draftDisplayed();
		Assert.assertEquals(result, true);		
	}


	@DataProvider(name="updatedDraftOkr")			
	public Object[][] getCredentials() {			

		return new Object[][] {				

			{"kk@pratian.com","password@123"} 	

		};
	}

}
