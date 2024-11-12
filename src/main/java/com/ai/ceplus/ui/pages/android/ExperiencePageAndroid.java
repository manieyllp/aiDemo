package com.ai.ceplus.ui.pages.android;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ai.ceplus.ui.pages.common.ExperiencePageBase;
import com.ai.ceplus.ui.pages.common.LoginPageBase;
import com.ai.ceplus.ui.pages.common.commonUtils;
import com.aventstack.extentreports.Status;
import com.zebrunner.carina.core.AbstractTest1;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ExperiencePageBase.class)
public class ExperiencePageAndroid extends ExperiencePageBase{

	commonUtils element=new commonUtils();
	@FindBy(xpath = "//android.widget.TextView[@text=\"MT\"]")
	protected ExtendedWebElement profile_Icon;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Add\"]")
	protected ExtendedWebElement add_button;
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Cancel\"]")
	protected ExtendedWebElement delete_Icon;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Yes, Delete\"]")
	protected ExtendedWebElement confirm_Delete;
		
	@FindBy(xpath = "//android.widget.TextView[@text=\"Experience\"]/following-sibling::android.view.View[2]//(//android.view.View[@content-desc=\"Edit\"])[1]")
	protected ExtendedWebElement edit_Button;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Employee Code\"]/parent::*")
	protected ExtendedWebElement input_EmployeeCode;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Company\"]/parent::*")
	protected ExtendedWebElement input_Company;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Position Held (Designation)\"]/parent::*")
	protected ExtendedWebElement input_Position_Held;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"CTC\"]/parent::*")
	protected ExtendedWebElement input_CTC;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Start Date\"]/parent::*")
	protected ExtendedWebElement input_StartDate;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"End Date\"]/parent::*")
	protected ExtendedWebElement input_EndDate;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	protected ExtendedWebElement calender_OK;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")
	protected ExtendedWebElement calender_Cancel;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Save\"]")
	protected ExtendedWebElement button_save;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Successfully Updated!\"]")
	protected ExtendedWebElement text_Updated;
	
	@FindBy(xpath = "//android.view.View[contains(@content-desc,\"01\")]")
	protected ExtendedWebElement select_StartDate;
	
	@FindBy(xpath = "//android.view.View[contains(@content-desc,\"05\")]")
	protected ExtendedWebElement select_EndDate;
	
	
	//android.widget.TextView[@text="Experience"]
	
	//(//android.widget.TextView[@text="Test Engineer Ssa"]/following-sibling::android.view.View/android.view.View)[1]
	//android.widget.TextView[@text="Successfully Deleted!"]

	
	//android.view.View[contains(@content-desc,"01")]
	//android.view.View[@content-desc="21 November 2024"]
	
	
	public ExperiencePageAndroid(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickProfileIcon() throws InterruptedException, IOException {
		element.click(profile_Icon, "Profile Icon");
	}
	
	public void clickOnFirstEdit() throws IOException {
		element.scrollTillXpath(edit_Button, driver);
		element.click(edit_Button, "Edit");
		
	}
	
	
	
	public void clickEdit() throws IOException {
		
		element.click(edit_Button, "Edit");	
	}

	public void enterEmployeeCode() throws IOException {
		element.sendKeys(input_EmployeeCode, "QA", "Employee Code");
	}
	

	public void enterCompany() throws IOException {
		
		element.sendKeys(input_Company, "QA New", "Company");
	}
	
	public void enterPosition() throws IOException {
		
		element.sendKeys(input_Position_Held, "QA Lead", "Position");
	}
	
	public void enterCTC() throws IOException {
		
		element.sendKeys(input_CTC, "12", "CTC");
	}
	
	public void selectStartDate() throws IOException {
		
		element.scrollTillText("Start", driver);
		element.click(input_StartDate, "Start Date");
		element.click(select_StartDate, "01 Date");
		element.click(calender_OK, "Ok");
		
	}
	
	public void selectEndDate() throws IOException {
		
		element.click(input_EndDate, "End Date");
		element.click(select_EndDate, "05 Date");
		element.click(calender_OK, "Ok");
	}
	
	
	public void clickSave() throws IOException {
	
		element.click(button_save, "Save");
		
	}
	
	public void verifySucessfullyUpdated() {
		
		if(text_Updated.isPresent()) {
			
			AbstractTest1.extentTest.log(Status.PASS, "Succesully Updated!");
		}else {
			AbstractTest1.extentTest.log(Status.FAIL, "Entry is not updated");
			
		}
		
	}
	
	
	
}


