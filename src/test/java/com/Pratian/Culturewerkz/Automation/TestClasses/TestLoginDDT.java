package com.Pratian.Culturewerkz.Automation.TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pratian.Culturewerkz.Automation.FileHandling.PropertyManager;
import com.Pratian.Culturewerkz.Automation.PageObjects.Home;
import com.Pratian.Culturewerkz.Automation.PageObjects.SignIn;

public class TestLoginDDT extends BaseTest {
	
	@Test(dataProvider = "signIn")
	public void signInWithValidCredentials(String userName, String password) throws IOException
	{
		/*Check whether or not user is able to sign in into Culturewerkz
		with valid credentials*/
		
		driver.get(PropertyManager.getProperty("url.app"));
		SignIn signIn= new SignIn(driver);
		signIn.provideUserName(userName);
		signIn.providePassword(password);
		Home home= signIn.clickSignInButton(driver);
		Assert.assertEquals(home.getUserName(), "Krishna Kumar Sivakumar");		
	}
	

	@DataProvider(name="signIn")
	String [][] getData() throws IOException
	{
		String path= System.getProperty("user.dir")+"/src/test/java/com/Pratian/Culturewerkz/Automation/TestData/testData.xlsx";
		
		int rownum=com.Pratian.Culturewerkz.Automation.Utils.XLUtils.getRowCount(path, "Sheet1");
		int colcount=com.Pratian.Culturewerkz.Automation.Utils.XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=com.Pratian.Culturewerkz.Automation.Utils.XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}

}
