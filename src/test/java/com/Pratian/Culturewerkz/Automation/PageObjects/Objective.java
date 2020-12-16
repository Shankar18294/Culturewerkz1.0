package com.Pratian.Culturewerkz.Automation.PageObjects;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Objective extends BasePage{

	public Objective(WebDriver driver) {
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
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/div[1]/div[1]/div/div[2]")
	WebElement objectives;
	
	

	/*
	 * @FindBy(css =".summary_font_size") WebElement objectives;
	 */

	@FindBy(xpath = "//h6")
	WebElement objective;
	@FindBy(linkText ="Delete")
	WebElement delete;
	@FindBy(xpath ="//*[@id=\"panel1\"]/div/div[2]/div[1]/div[1]/div[2]/div/div/a[2]")
	WebElement deleteKey;
	@FindBy(xpath ="/html/body/div[4]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[1]/div/a")
	WebElement addKeyResult;
	@FindBy(xpath ="/html/body/div[4]/div/div/div[4]/div/div/div/form/div[1]/div[2]/textarea")
	WebElement keyResult;
	@FindBy(xpath ="/html/body/div[4]/div/div/div[4]/div/div/div/form/div[2]/div[2]/input")
	WebElement score;
	@FindBy(xpath ="/html/body/div[4]/div/div/div[4]/div/div/div/form/div[3]/div[2]/input")
	WebElement dueDate;
	@FindBy(xpath ="/html/body/div[4]/div/div/div[4]/div/div/div/form/div[6]/div/button")
	WebElement saveBtn;
	@FindBy(xpath ="//*[@id=\"#form\"]/div[3]/div[2]/input")
	WebElement kerResultAdded;

	@FindBy(xpath="//*[@name=\"Objective\"]")
	WebElement title;
	@FindBy(xpath="//*[@name=\"ObjDescription\"]")
	WebElement description;
	@FindBy(className="select2-search__field")
	WebElement clickCategory;
	@FindBy(xpath="//*[@id=\"#form\"]/div[3]/div[2]/span/span[1]/span/ul/li[1]")
	WebElement selectCategory;
	@FindBy (xpath="//*[@id='#form']/div[5]/div[1]/input")
	WebElement dateBox;
	@FindBy (xpath="/html/body/div[4]/div/div[3]/div[1]/form/div[5]/div[2]/div/input")
	WebElement endDate;
	@FindBy(xpath="//button[contains(text(), 'Publish')]")
	WebElement publish;
	@FindBy(xpath="//*[@id=\"leftdiv\"]/div[1]/div[1]/span")

	WebElement publishedObjective;
	@FindBy(xpath ="/html/body/div[4]/div[3]/div[2]/div[1]/ul/li[2]")
	WebElement drafts;
	@FindBy(xpath = "//*[@id='drafted']/div/div[1]/a/div")
	WebElement draftedObjective;
	@FindBy(name = "Objective")
	WebElement draftTitle;
	@FindBy(xpath = "/html/body/div[4]/div/div[3]/div[3]/div[2]/div[1]/button[1]")
	WebElement buttonSaveAsDraft;
	@FindBy(xpath = "/html/body/div[4]/div[3]/div[2]/div[1]/div/div[2]/div/div[1]/a/div/div[2]/div/div/h6")
	WebElement draftResult;






	JavascriptExecutor je = (JavascriptExecutor) driver;


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

	public void clickonObjective(WebDriver driver) 
	
	{
		je.executeScript("arguments[0].click();",objectives);

	}
	public void clickonSingleObjective(WebDriver driver) 
	{
		objective.click();

	}
	public void clickondelete(WebDriver driver) 
	{
		je.executeScript("arguments[0].click();",delete);

	}
	public Home clickOnKeyDelete(WebDriver driver) {
		deleteKey.click();
		return new Home(driver);
	}

	public void clickaddKeyResult(WebDriver driver) {
		je.executeScript("arguments[0].click();",addKeyResult);
	}

	public void provideKeyResult(String keyresult) {
		je.executeScript("arguments[0].value='Automation'",keyResult);
	}

	public void provideScore(String sc) {
		je.executeScript("arguments[0].value='1'",score);
	}

	public void provideDueDate(String date) {
		je.executeScript("arguments[0].value='12/16/2020'",dueDate);
	}

	public void clickSave(WebDriver driver) {
		je.executeScript("arguments[0].click();",saveBtn);
	}

	public Boolean displayedKeyResult() {
		return kerResultAdded.isDisplayed();
	}

	public void setTitle(String titleName) {
		title.sendKeys(titleName);
	}

	public void setDescription(String descriptionName) {
		description.sendKeys(descriptionName);

	}

	public void selectCategory() {
		this.clickCategory.click();
		this.clickCategory.sendKeys("Performance");
		this.clickCategory.sendKeys(Keys.ENTER);
	}

	public void startingDate() {
		this.dateBox.clear();
		this.dateBox.sendKeys("12/16/2020");
	}

	public void endDate() {
		this.endDate.clear();
		this.endDate.sendKeys("12/17/2020");
	}

	public void clickPublishButton() {

		publish.click();

	}

	public Boolean objectiveDisplayed() {
		return publishedObjective.isDisplayed();
	}

	public void clickonDrafts(WebDriver driver) 
	{
		drafts.click();
	}

	public void clickonDraftedObjective(WebDriver driver) 
	{
		draftedObjective.click();

	}

	public void provideTitle(String titleName)
	{
		title.clear();
		this.title.sendKeys(titleName);
	}
	
	public void clickonButtonSaveAsDraft(WebDriver driver) {
		je.executeScript("arguments[0].click();",buttonSaveAsDraft);
	}

	public Boolean draftDisplayed() {
		return draftResult.isDisplayed();
	}


}