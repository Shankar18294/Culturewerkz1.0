package com.Pratian.Culturewerkz.Automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home extends BasePage {

	@FindBy(xpath = "//*[@id=\"logoutForm\"]/div/a/span[2]/span")
	WebElement userName;
	
	public Home(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public String getUserName()
	{
		return userName.getText();
	}

}
