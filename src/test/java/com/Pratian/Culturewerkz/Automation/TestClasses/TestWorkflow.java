package com.Pratian.Culturewerkz.Automation.TestClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pratian.Culturewerkz.Automation.FileHandling.PropertyManager;
import com.Pratian.Culturewerkz.Automation.PageObjects.Home;
import com.Pratian.Culturewerkz.Automation.PageObjects.Objective;
import com.Pratian.Culturewerkz.Automation.PageObjects.SignIn;

public class TestWorkflow extends BaseTest {

	@Test(priority = 1, dataProvider = "signIn")
	public void signIn(String userName, String password) throws IOException {
		/*
		 * Check whether or not user is able to sign in into Culturewerkz with valid
		 * credentials
		 */

		driver.get(PropertyManager.getProperty("url.app"));
		SignIn signIn = new SignIn(driver);
		signIn.provideUserName(userName);
		signIn.providePassword(password);
		signIn.clickSignInButton(driver);

	}

	@Test(priority = 2, dataProvider = "search")
	public void search(String search1) {
		/*
		 * Check whether the user is able to provide at least 3 characters of a person
		 * in the organization in the search box and able to view the search result
		 * matching the characters he provided
		 */

		Home home = new Home(driver);
		home.provideUserSearch(search1);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div/div/ul/li[2]")));
		home.autoSearch();

	}

	/*
	 * @Test(priority = 3) public void feedback() {
	 * 
	 * Check whether or not user is able to navigate to send feedback page
	 * 
	 * Home home = new Home(driver); driver.manage().timeouts().implicitlyWait(15,
	 * TimeUnit.SECONDS); home.logoutDropdown(driver); home.sendFeedback(driver);
	 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); boolean
	 * result = home.feedbackPage(); Assert.assertEquals(result, true); }
	 */

	@Test(priority = 3)
	public void publishObjective() throws InterruptedException {
		/* Check whether or not user is able to publish the objective */

		Home home = new Home(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		home.clickNewOkr(driver);

		Objective objective = new Objective(driver);
		objective.setTitle("mobile automation  testing");
		objective.setDescription("mobile automation started running");
		objective.selectCategory();
		objective.startingDate();
		objective.endDate();
		objective.clickPublishButton();

	}

//	@Test(priority = 5)
//	public void addKeyResult() throws IOException {
//
//		/* check whether user is able to add results to the existing objective */
//
//		driver.get(PropertyManager.getProperty("url.app1"));
//		//driver.navigate().to("https://mycloud-culturewerkz.pratian.com/Home/Index");
//
//		Objective okr = new Objective(driver);
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]/div[1]/div[1]/div[1]/p")));
//		okr.clickonObjective(driver);
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		okr.clickonSingleObjective(driver);
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		okr.clickaddKeyResult(driver);
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		okr.provideKeyResult("Automation");
//		okr.provideScore("1");
//		// WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"#form\"]/div[3]/div[2]/input")));
//		okr.provideDueDate("12/16/2020");
//		okr.clickSave(driver);
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		boolean result = okr.displayedKeyResult();
//		Assert.assertEquals(result, true);
//
//	}

//	@Test(priority = 4)
//	public void deleteObjective() throws IOException {
//
//		/* check whether user is able to delete existing objective */
//
//		//driver.get(PropertyManager.getProperty("url.app1"));
//		driver.navigate().to("https://mycloud-culturewerkz.pratian.com/Home/Index");
//
//		Objective objective = new Objective(driver);
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		objective.clickonObjective(driver);
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		objective.clickonSingleObjective(driver);
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		objective.clickondelete(driver);
//		Boolean popup = driver.findElement(By.xpath("//label[@class='ng-binding']")).isDisplayed();
//		WebElement msg1 = driver.findElement(By.xpath("//label[@class='ng-binding']"));
//		String popupmsg1 = msg1.getText();
//		String expected = "Are you sure you want to delete ?";
//		Assert.assertEquals(popupmsg1, expected);
//	}

	@DataProvider(name = "signIn")
	public Object[][] getCredentials() {

		return new Object[][] {

				{ "kk@pratian.com", "password@123" },

		};
	}

	@DataProvider(name = "search")
	public Object[][] getSearch() {

		return new Object[][] {

				{ "abh" }, { "ABH" }, { "Abh" }

		};
	}

}
