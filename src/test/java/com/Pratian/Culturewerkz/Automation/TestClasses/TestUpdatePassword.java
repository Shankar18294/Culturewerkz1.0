package com.Pratian.Culturewerkz.Automation.TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pratian.Culturewerkz.Automation.FileHandling.PropertyManager;
import com.Pratian.Culturewerkz.Automation.PageObjects.Home;
import com.Pratian.Culturewerkz.Automation.PageObjects.SignIn;

public class TestUpdatePassword extends BaseTest {
	
	@Test(dataProvider = "signIn")
	public void updatePassword(String userName, String password) throws IOException
	{
	/*Check whether or not user is able to navigate to update password page*/

	 

	driver.get(PropertyManager.getProperty("url.app"));
	SignIn signIn= new SignIn(driver);
	signIn.provideUserName(userName);
	signIn.providePassword(password);
	signIn.clickSignInButton(driver);

	Home home = new Home(driver);
	home.logoutDropdown(driver);
	home.updatePassword(driver);
	boolean result =  home.updatePasswordPage();
	Assert.assertEquals(result, true);


	}

	 


	@DataProvider(name="signIn")
	public Object[][] getCredentials() {

	 

	return new Object[][] {

	 

	{"kk@pratian.com","password@123"}

	 

	};
	}

}
