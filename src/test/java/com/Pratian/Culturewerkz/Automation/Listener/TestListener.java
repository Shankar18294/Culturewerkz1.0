package com.Pratian.Culturewerkz.Automation.Listener;



import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.Pratian.Culturewerkz.Automation.TestClasses.BaseTest;
import com.google.common.io.Files;

public class TestListener extends BaseTest implements ITestListener {
	
	
	    WebDriver driver;
	    String filePath = "./src/test/resources/ScreenShots";
	    BaseTest base= new BaseTest();
	    
	    public void onTestFailure(ITestResult result) {
	        String methodName=result.getName().toString();
	        driver = base.getDriver();
	       takeScreenShot(methodName);
	    }
	    
	    private void takeScreenShot(String methodName) {
	        // TODO Auto-generated method stub
	        System.out.println("ScreenShot function called");
	         File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	         System.out.println("Screenshot taken");
	         //The below method will save the screen shot in d drive with test method name 
	            try {
	                Files.copy(scrFile, new File(filePath+methodName+".png"));
	                System.out.println("***Placed screen shot in "+filePath+" ***");
	                
	            } catch (IOException e) {
	                
	                e.printStackTrace();
	            }
	        
	    }
	
	

}
