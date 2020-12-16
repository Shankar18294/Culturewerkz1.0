package com.Pratian.Culturewerkz.Automation.TestClasses;

 

import java.io.IOException;
import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.Alert;
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

 

public class DeletingObjectiveAlert extends BaseTest{
    
    @Test(dataProvider = "signIn")
    public void AlertMessageOnDeletingObjective(String userName, String password) throws IOException
    {
        
        driver.get(PropertyManager.getProperty("url.app"));
        Objective objective= new Objective(driver);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

 

        objective.provideUserName(userName);
        objective.providePassword(password);
        Home home= objective.clickSignInButton(driver);
        
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        objective.clickonObjective(driver);
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         objective.clickonSingleObjective(driver);
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         objective.clickondelete(driver);
        
//
//         String expected =  "Are you sure you want to delete ?";
//        WebElement text = driver.findElement(By.xpath("//label[@class='ng-binding']"));
//       String actual= text.getText();
//         Assert.assertEquals(actual, expected);
//       System.out.println(actual);
         Boolean popup = driver.findElement(By.xpath("//label[@class='ng-binding']")).isDisplayed();
         //System.out.println(popup);
          WebElement msg1 = driver.findElement(By.xpath("//label[@class='ng-binding']"));
          String popupmsg1 = msg1.getText();
          String expected = "Are you sure you want to delete ?";
          Assert.assertEquals(popupmsg1, expected);
          
         
    }

 

    @DataProvider(name="signIn")            
    public Object[][] getCredentials() {            

 

        return new Object[][] {                

 

            {"kk@pratian.com","password@123"}     

 

        };
    }

 

}