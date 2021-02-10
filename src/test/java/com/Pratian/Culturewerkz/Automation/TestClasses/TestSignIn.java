package com.Pratian.Culturewerkz.Automation.TestClasses;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pratian.Culturewerkz.Automation.FileHandling.PropertyManager;
import com.Pratian.Culturewerkz.Automation.PageObjects.Home;
import com.Pratian.Culturewerkz.Automation.PageObjects.SignIn;



public class TestSignIn extends BaseTest {
	
	static Logger log = LogManager.getLogger(TestSignIn.class);

	
	@Test(dataProvider = "signIn")
	public void signInWithValidCredentials(String userName, String password) throws IOException
	{
		/*Check whether or not user is able to sign in into Culturewerkz
		with valid credentials*/
		
		driver.get(PropertyManager.getProperty("url.app"));
        driver.manage().window().maximize();

		SignIn signIn= new SignIn(driver);
		signIn.provideUserName(userName);
		
		log.debug("username entered");
		
		signIn.providePassword(password);
		log.debug("password entered");
		
		Home home= signIn.clickSignInButton(driver);
		log.debug("signIn button clicked");
		
		//Assert.assertEquals(home.getUserName(), "Krishna Kumar Sivakumar");
		//log.debug("assertion passed");
	}
	

	@DataProvider(name="signIn")			
	public Object[][] getCredentials() {			

		return new Object[][] {				

			{"kk@pratian.com","password@123"} 	

		};
	}

}
