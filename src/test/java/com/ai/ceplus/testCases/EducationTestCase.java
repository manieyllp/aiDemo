package com.ai.ceplus.testCases;

import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.ai.ceplus.ui.pages.common.ExperiencePageBase;
import com.ai.ceplus.ui.pages.common.LoginPageBase;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.zebrunner.carina.core.AbstractTest1;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.CsvDataSourceParameters;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.report.ExtentLogger;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class EducationTestCase extends AbstractTest1 implements IAbstractTest, IAbstractDataProvider {

	
	  @Test(testName = "Experience Text case", description =
	  "verify Experience Edit" ,priority = 1 ,dataProvider =
	  "DataProvider")
	  
	  @CsvDataSourceParameters(path = "csv/CE_Plus.csv" , dsUid = "TestCaseID",
	  executeColumn = "Execute", executeValue = "Y")
	  
	  @MethodOwner(owner = "AI") public void verifyExperienceEdit(Map<String,
	  String> args) throws Exception {

		  System.out.println("Fetch data from Test Data:"+args.get("UserID"));
		
		  LoginPageBase LoginPage=initPage(getDriver(), LoginPageBase.class);
		  ExperiencePageBase experiencePage=initPage(getDriver(), ExperiencePageBase.class);
		  	  
		  LoginPage.clickSkip();
		  LoginPage.enterEmailID(args.get("UserID"));
		  LoginPage.clickSignIn();
		  LoginPage.enterPassowrd("Xebia@123");
		  LoginPage.clickPasswordSignIn();
		  LoginPage.clickSkip();
		  experiencePage.clickProfileIcon();
		  experiencePage.clickOnFirstEdit();
		  experiencePage.enterEmployeeCode();
		  experiencePage.enterPosition();
		  experiencePage.enterCompany();
		  experiencePage.enterCTC();
		  experiencePage.selectStartDate();
		  experiencePage.selectEndDate();
		  experiencePage.clickSave();
		  experiencePage.verifySucessfullyUpdated();

	  }
	 
	
}
