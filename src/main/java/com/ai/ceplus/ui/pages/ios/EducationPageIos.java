package com.ai.ceplus.ui.pages.ios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.ai.ceplus.ui.pages.common.EducationPageBase;
import com.ai.ceplus.ui.pages.common.commonUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = Type.IOS_PHONE ,parentClass = EducationPageBase.class)
public class EducationPageIos extends EducationPageBase implements IMobileUtils {
	commonUtils element = new commonUtils();
	
	public EducationPageIos(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"+\"])[1]")
	protected ExtendedWebElement addExpericeButton;
	
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"+\"])[2]")
	protected ExtendedWebElement addEducationButton;
	
	@FindBy(xpath = "(//XCUIElementTypeButton[@name=\"edit\"])[last()]")
	protected ExtendedWebElement editLastEducationButton;
	
	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Education\"]//preceding-sibling::XCUIElementTypeButton[@name=\"edit\"])[last()]")
	protected ExtendedWebElement editLastExperienceButton;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"delete\"]")
	protected ExtendedWebElement deleteButton;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@name=\"Yes, Delete\"]")
	protected ExtendedWebElement deleteConfirmationButton;
	
	@FindBy(xpath = "//XCUIElementTypeTextField[@value=\"Qualification Type*\"]")
	protected ExtendedWebElement qualificationType;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Graduation\"]")
	protected ExtendedWebElement graduationOption;
	
	
	@FindBy(xpath = "//XCUIElementTypeTextField[@value=\"Qualification Name*\"]")
	protected ExtendedWebElement qualificationName;
	
	@FindBy(xpath = "//XCUIElementTypeTextField[@value=\"Specialization*\"]")
	protected ExtendedWebElement specialization;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Criminal Justice\"]")
	protected ExtendedWebElement criminalJusticeOption;
	
	
	
	@FindBy(xpath = "//XCUIElementTypeTextField[@value=\"Mode of Education*\"]")
	protected ExtendedWebElement modeOfEducation;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Full time\"] full time option")
	protected ExtendedWebElement fullTimeOption;
	
	
	 
	@FindBy(xpath = "//XCUIElementTypeTextField[@value=\"School*\"]")
	protected ExtendedWebElement school;
	
	@FindBy(xpath = "//XCUIElementTypeTextField[@value=\"Highest Education*\"]")
	protected ExtendedWebElement higherEducation;
	
	@FindBy(xpath = "//XCUIElementTypeTextField[@value=\"Start Date*\"]")
	protected ExtendedWebElement startDate;
	 
	@FindBy(xpath = "//XCUIElementTypeTextField[@value=\"End Date*\"]")
	protected ExtendedWebElement endDate;
	 
	@FindBy(xpath = "//XCUIElementTypeTextField[@value=\"Grade*\"]")
	protected ExtendedWebElement grade;
	 
	@FindBy(xpath = "//XCUIElementTypeTextField[@value=\"Location*\"]")
	protected ExtendedWebElement location;
	 
	
	 /*
		
	@Override
	public void addEducation() throws IOException {
		element.click(addEducationButton, "Add Education Button");
		tap(qualificationType);
//		tap(graduationOption);
		element.click(graduationOption, "Graduation");
		tap(specialization);
//		tap(criminalJusticeOption);
		element.click(criminalJusticeOption, "Criminal Justice Option");

	}
	
	

	@Override
	public void navigateToProfile() throws IOException {
		element.click(profileIcon, "Profile Icon");
		
//		swipe(profileIcon);
		
	}

	@Override
	public void verifyProfileDetails() throws IOException {
		String expectedName= "Myai  Test7";
		String expectedEmail= "myai.test7@airindia.com";
		element.assertEquals(userName.getAttribute("value"), expectedName,"User name");
		element.assertEquals(userEmail.getAttribute("value"), expectedEmail,"User email");
		
	}

	@Override
	public void navigateExperience() throws IOException {
		swipe(addExpericeButton);	
	}

	@Override
	public void navigateEducation() throws IOException {
		swipe(addEducationButton);
	}

	

	@Override
	public void deleteEducation() throws IOException {
		swipe(editLastEducationButton);
		element.click(editLastEducationButton, "Edit Education");
		element.click(deleteButton, "Delete Button");
		element.click(deleteConfirmationButton, "Delete Confirmation");
		
	}

	@Override
	public void editExperience() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	*/

}
