package com.Pratian.Culturewerkz.Automation.TestClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pratian.Culturewerkz.Automation.FileHandling.PropertyManager;
import com.Pratian.Culturewerkz.Automation.PageObjects.Home;
import com.Pratian.Culturewerkz.Automation.PageObjects.SignIn;

public class TestSearchDDT extends BaseTest {
	
	
	@Test(priority = 1, dataProvider = "signIn") 
	public void search(String userName, String password) throws IOException {

		driver.get(PropertyManager.getProperty("url.app")); 
		SignIn signIn= new SignIn(driver); 
		signIn.provideUserName(userName);
		signIn.providePassword(password); 
		signIn.clickSignInButton(driver);

	}


	@Test (priority = 2, dataProvider = "search")
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
	String [][] getLoginData() throws IOException
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

	@DataProvider(name="search")			
	String [][] getSearchData() throws IOException
	{
		String path= System.getProperty("user.dir")+"/src/test/java/com/Pratian/Culturewerkz/Automation/TestData/testData.xlsx";
		
		int rownum1=com.Pratian.Culturewerkz.Automation.Utils.XLUtils.getRowCount(path, "Sheet2");
		int colcount=com.Pratian.Culturewerkz.Automation.Utils.XLUtils.getCellCount(path,"Sheet2",1);
		
		String searchData[][]=new String[rownum1][colcount];
		
		for(int i=1;i<=rownum1;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				searchData[i-1][j]=com.Pratian.Culturewerkz.Automation.Utils.XLUtils.getCellData(path,"Sheet2", i,j);//1 0
			}
				
		}
	return searchData;
	}

}
