package com.ai.ceplus.ui.pages.android;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ai.ceplus.ui.pages.common.LoginPageBase;
import com.ai.ceplus.ui.pages.common.commonUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;


@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPageAndroid extends LoginPageBase{

	commonUtils element=new commonUtils();
	@FindBy(xpath = "//*[@text=\"Skip\"]")
	protected ExtendedWebElement skip_Button;
	
	@FindBy(xpath = "//android.widget.EditText")
	protected ExtendedWebElement input_EmailId;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"i0118\"]")
	protected ExtendedWebElement input_Password;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Sign In\"]")
	protected ExtendedWebElement signIn_Button;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"idSIButton9\"]")
	protected ExtendedWebElement signIn_password_button;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Home\"]")
	protected ExtendedWebElement home_Tab;
	
	public LoginPageAndroid(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickSkip() throws InterruptedException, IOException {
		
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
			
		}catch(Exception e){
			
			 System.out.println("Element not found: " + e.getMessage());
	          Assert.fail("Login Failed");
			
		}
		
	}
	
	
	
	
}
