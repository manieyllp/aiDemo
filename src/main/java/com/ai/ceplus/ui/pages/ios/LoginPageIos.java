package com.ai.ceplus.ui.pages.ios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ai.ceplus.ui.pages.common.LoginPageBase;
import com.ai.ceplus.ui.pages.common.commonUtils;
import com.aventstack.extentreports.Status;
import com.zebrunner.carina.core.AbstractTest1;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;


@DeviceType(pageType = Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPageIos extends LoginPageBase{

	commonUtils element=new commonUtils();
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Skip\"]")
	protected ExtendedWebElement skip_Button;
	
	@FindBy(xpath = "//XCUIElementTypeTextField")
	protected ExtendedWebElement input_EmailId;
	
	@FindBy(xpath = "//XCUIElementTypeSecureTextField")
	protected ExtendedWebElement input_Password;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Sign In\"]")
	protected ExtendedWebElement signIn_Button;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Sign in\"]")
	protected ExtendedWebElement signIn_password_button;
	
	@FindBy(xpath = "//*[@name=\"Home\"]")
	protected ExtendedWebElement home_Tab;
	
	@FindBy(xpath = "(//XCUIElementTypeOther[@name='Horizontal scroll bar, 1 page'])[2]")
	protected ExtendedWebElement locationDenyButton;
	
	public LoginPageIos(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickSkip() throws InterruptedException, IOException {
				
		if(locationDenyButton.isPresent(5)) {
			element.click(locationDenyButton,"Location Deny");
		}
		element.click(skip_Button, "Skip");

	}
	
	public void enterEmailID(String emailID) throws IOException {
		
		//input_EmailId.click();
		element.sendKeys(input_EmailId, emailID, "Air India Email Id");
	}

	public void clickSignIn() throws InterruptedException, IOException {
		
		element.click(signIn_Button, "Sign In");
	}
	
	public void enterPassowrd(String password) throws InterruptedException, IOException {
		
		element.click(input_Password, "Passowrd input Field");
		element.sendKeys(input_Password, password, "Passowrd");
	}
	
	public void clickPasswordSignIn() throws IOException {
		
		element.click(signIn_password_button, "Sign In");
	}
	
	public void verifyLogin() {
		
		try {
			String actual=home_Tab.getText();
			System.out.println(actual);
			Assert.assertTrue(actual.contains("Home"), "Login Failed !!");
			AbstractTest1.extentTest.log(Status.PASS, "Login Successfully.");
			
		}catch(Exception e){
			AbstractTest1.extentTest.log(Status.FAIL, "Login is not successfully.");
			 System.out.println("Element not found: " + e.getMessage());
	          Assert.fail("Login Failed");
			
		}
		
	}

	
	
	
	
	
}
