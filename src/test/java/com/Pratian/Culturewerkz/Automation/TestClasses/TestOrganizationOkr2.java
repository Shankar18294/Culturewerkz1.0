package com.Pratian.Culturewerkz.Automation.TestClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pratian.Culturewerkz.Automation.FileHandling.PropertyManager;
import com.Pratian.Culturewerkz.Automation.PageObjects.Home;
import com.Pratian.Culturewerkz.Automation.PageObjects.OrganizationOkr;
import com.Pratian.Culturewerkz.Automation.PageObjects.SignIn;

public class TestOrganizationOkr2 extends BaseTest {
	
	@Test(dataProvider = "signIn")
	public void peopleWiseOrgReportSearchResult(String userName, String password) throws IOException
	{
		/*Check whether or not user is able to search for people in people wise organization report page*/
		
		driver.get(PropertyManager.getProperty("url.app"));
		SignIn signIn= new SignIn(driver);
		signIn.provideUserName(userName);
		signIn.providePassword(password);
		Home home= signIn.clickSignInButton(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]/div[2]/a[1]/div/div[2]")));
	    home.organizationOkr(driver);
	    OrganizationOkr okr = new OrganizationOkr(driver);
	    okr.clickPeople(driver);
	    //WebDriverWait wait2 = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[1]/div[1]/div/h4")));
	   //okr.assertMessege();
	   okr.provideName("abhijit");
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[4]/div[1]/div/div/div/div/show-users-list/div[3]/div[2]/div/label")));
	   boolean result =  okr.displayed();
		Assert.assertEquals(result, true);
				
	}
	

	@DataProvider(name="signIn")			
	public Object[][] getCredentials() {			

		return new Object[][] {				

			{"kk@pratian.com","password@123"} 	

		};
	}


}
