package com.Pratian.Culturewerkz.Automation.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Home extends BasePage {

	@FindBy(xpath = "//*[@id=\"logoutForm\"]/div/a/span[2]/span")
	WebElement userName;
	@FindBy(xpath = "//*[@id=\"search\"]")
	WebElement search;
	@FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div/form/div/div/ul/li[1]")
	WebElement searchSuggestion;
	@FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div/form/div/div/ul/li[1]")
	WebElement logout;
	@FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div/form/div/div/ul/li[1]")
	WebElement changePassword;
	@FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div/form/div/div/ul/li[1]")
	WebElement passwordPage;
	@FindBy(xpath = "/html/body/div[2]/div[1]/div[5]/form/div/div/a[1]")
	WebElement feedbackLink;
	@FindBy(xpath = "/html/body/div[3]/div/div/div/label")
	WebElement feedbackPage;
	@FindBy(xpath="/html/body/div[4]/div[2]/div[2]/a[1]/div/div[2]")
	WebElement orgOkr;
	@FindBy(xpath="//span[text()='Add New']")
	WebElement newOkr;
	@FindBy(xpath="/html/body/div[2]/div[1]")
	WebElement logo;
	
	JavascriptExecutor je = (JavascriptExecutor) driver;


	public Home(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public String getUserName()
	{
		return userName.getText();
	}

	public void provideUserSearch(String search)
	{
		this.search.clear();
		this.search.sendKeys(search);
	}


	public String autoSearch() { 
		System.out.println(searchSuggestion.getText());
		return searchSuggestion.getText();

	}
	
	public void logoutDropdown(WebDriver driver) {
		je.executeScript("arguments[0].click();",logout);
	}

	public void updatePassword(WebDriver driver) {
		je.executeScript("arguments[0].click();",changePassword);
	}
	
	public Boolean updatePasswordPage() {
		return passwordPage.isDisplayed();
	}
	
	public void organizationOkr(WebDriver driver) {
		je.executeScript("arguments[0].click();",orgOkr);
	}

	public void sendFeedback(WebDriver driver) {
		je.executeScript("arguments[0].click();",feedbackLink);
	}
	
	public Boolean feedbackPage() {
		return feedbackPage.isDisplayed();
	}
	
	public void clickNewOkr(WebDriver driver) {

		newOkr.click();

	}
	
	public void clickLogo(WebDriver driver) {
		je.executeScript("arguments[0].click();",logo);
	}
	
}
