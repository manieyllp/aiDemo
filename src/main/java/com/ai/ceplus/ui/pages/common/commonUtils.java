package com.ai.ceplus.ui.pages.common;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.zebrunner.carina.core.AbstractTest1;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;


public class commonUtils extends AbstractTest1{

	
	public void click(ExtendedWebElement element,String discription) throws IOException {
		
		element.click();
		
		 String screenshotLink="<div style='overflow: hidden;'>"
                 + "<span style='float: left;'>Click on :<b>'"+discription+"'</b></span>"
                 + "<span style='float: right;'><a href='" + addcaptureScreenshotInReport() + "' target='_blank'>Click here to view screenshot</a></span>"
                 + "</div>";
		AbstractTest1.extentTest.log(Status.PASS, screenshotLink);
	
		
	}
		
	public void sendKeys(ExtendedWebElement element,String enterInput,String discription) throws IOException {
		
		element.type(enterInput);
	
		System.out.println(element.isElementPresent());
		 String screenshotLink="<div style='overflow: hidden;'>"
                 + "<span style='float: left;'>Enter : '"+discription+"':<b>'"+enterInput+"'</b></span>"
                 + "<span style='float: right;'><a href='" + addcaptureScreenshotInReport() + "' target='_blank'>Click here to view screenshot</a></span>"
                 + "</div>";
		 
		AbstractTest1.extentTest.log(Status.PASS, screenshotLink);
	
		
	}
	
	public boolean assertEquals(String actual, String expected, String name) {
		boolean assertStatus =true;
		if(actual.equals(expected)) {
			AbstractTest1.extentTest.log(Status.PASS, "Validation passed for: "+name+" Value: "+actual );
		}else {
			AbstractTest1.extentTest.log(Status.FAIL , "Validation failed for: "+name+" Observed: "+actual);
			assertStatus =false;
		}
			
		return assertStatus;
	}
	public void clear(ExtendedWebElement element,String discription) throws IOException {
		
		element.clear();
	
		 String screenshotLink="<div style='overflow: hidden;'>"
                 + "<span style='float: left;'>Clear :<b>'"+discription+"'</b></span>"
                 + "<span style='float: right;'><a href='" + addcaptureScreenshotInReport() + "' target='_blank'>Click here to view screenshot</a></span>"
                 + "</div>";
		 
		AbstractTest1.extentTest.log(Status.PASS, screenshotLink);
	
		
	}
	
	
	public void scrollTillText(String text,WebDriver driver) {
		
		boolean isElementFound = false;
		int maxScrollAttempts = 15;  // Adjust as needed based on screen layout and element position
		int attempts = 0;

		while (!isElementFound && attempts < maxScrollAttempts) {
		    try {	 
		    	
		    	driver.findElement(AppiumBy.androidUIAutomator(
		    			"new UiSelector().textContains(\""+text+"\")"));
		    	
		        isElementFound = true;
		        
		    } catch (NoSuchElementException e) {
		    	
		    	driver.findElement(AppiumBy.androidUIAutomator(
		    			"new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
		        attempts++;
		    }
		}

		if (!isElementFound) {
		    System.out.println("Element not found after " + maxScrollAttempts + " scroll attempts.");
		}
	}
	
	public void scrollTillXpath(ExtendedWebElement element,WebDriver driver) {
		
		boolean isElementFound = false;
		int maxScrollAttempts = 15;  // Adjust as needed based on screen layout and element position
		int attempts = 0;

		while (!isElementFound && attempts < maxScrollAttempts) {
		    if (element.isElementPresent(2)) {
		        isElementFound = true;
		    } else {
		        // Perform a scroll if the element is not yet found
		        driver.findElement(AppiumBy.androidUIAutomator(
		        		"new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
		        attempts++;
		    }
		}

		if (!isElementFound) {
		    System.out.println("Element not found after " + maxScrollAttempts + " scroll attempts.");
		}
	}
	
}
