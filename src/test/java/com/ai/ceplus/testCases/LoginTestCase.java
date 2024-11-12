package com.ai.ceplus.testCases;

import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
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

public class LoginTestCase extends AbstractTest1 implements IAbstractTest, IAbstractDataProvider {

	  @Test(testName = "Login Test Case", description =
	  "verify Login Scenario" ,priority = 1 ,dataProvider =
	  "DataProvider")
	  
	  @CsvDataSourceParameters(path = "csv/CE_Plus.csv" , dsUid = "TestCaseID",
	  executeColumn = "Execute", executeValue = "Y")
	  
	  @MethodOwner(owner = "AI") public void verifyLogin(Map<String,
	  String> args) throws Exception {

		  System.out.println("Fetch data from Test Data:"+args.get("UserID"));
		
		  LoginPageBase HomePage=initPage(getDriver(), LoginPageBase.class);
		
		  HomePage.clickSkip();
		  HomePage.enterEmailID(args.get("UserID"));
		  HomePage.clickSignIn();
		  HomePage.enterPassowrd(args.get("Password"));
		  HomePage.clickPasswordSignIn();
		  HomePage.clickSkip();
		  HomePage.verifyLogin();

	  }
	 
	
}
