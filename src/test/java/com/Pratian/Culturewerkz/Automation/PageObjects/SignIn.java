package com.Pratian.Culturewerkz.Automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn extends BasePage{
	
	public SignIn(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	//PROPERTIES
	@FindBy(xpath = "//*[@id=\"userNameInput\"]")
	WebElement userName;
	@FindBy(xpath = "//*[@id=\"passwordInput\"]")
	WebElement password;
	@FindBy(xpath = "//*[@id=\"submitButton\"]")
	WebElement signInButton;
	
	//METHODS
	public void provideUserName(String userName)
	{
		this.userName.sendKeys(userName);
	}
	public void providePassword(String password)
	{
		this.password.sendKeys(password);
	}
	
	public Home clickSignInButton(WebDriver driver)
	{
		signInButton.click();
		return new Home(driver);
	}
	
	

}
