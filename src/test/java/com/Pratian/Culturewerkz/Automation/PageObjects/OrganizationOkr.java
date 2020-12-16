package com.Pratian.Culturewerkz.Automation.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationOkr extends BasePage {
	
	@FindBy(xpath="/html/body/div[4]/div[4]/div[2]/a/div")
	WebElement people;
	@FindBy(xpath = "/html/body/div[4]/div/div[1]/div[1]/div/h4")
	WebElement peoplePage;
	@FindBy(xpath = "/html/body/div[4]/div/div[1]/div[1]/div/h4")
	WebElement searchPeople;
	@FindBy(xpath = "/html/body/div[4]/div/div[4]/div[1]/div/div/div/div/show-users-list/div[3]/div[2]/div/label")
	WebElement searchResult;
	@FindBy(xpath="/html/body/div[4]/div[4]/div[2]/a/div")
	WebElement keyResults;
	@FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div")
	WebElement keyResultsPage;
	
	JavascriptExecutor je = (JavascriptExecutor) driver;
	
	public OrganizationOkr(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public void clickPeople(WebDriver driver) {
		je.executeScript("arguments[0].click();",people);
	}

	public void provideName(String search) {
		je.executeScript("arguments[0].value='search'",searchPeople);
	}
	
	public Boolean displayed() {
		return searchResult.isDisplayed();
	}
	
	public Boolean assertMessege() {
		return peoplePage.isDisplayed();
	}
	
	public void clickKeyResult(WebDriver driver) {
		je.executeScript("arguments[0].click();",keyResults);
	}
	
	public Boolean displayedKeyResults() {
		return keyResultsPage.isDisplayed();
	}

	
	


}
