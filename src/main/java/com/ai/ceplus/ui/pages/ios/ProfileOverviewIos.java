package com.ai.ceplus.ui.pages.ios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.ai.ceplus.ui.pages.common.ProfileOverviewBase;
import com.ai.ceplus.ui.pages.common.commonUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = Type.IOS_PHONE ,parentClass = ProfileOverviewBase.class)
public class ProfileOverviewIos extends ProfileOverviewBase implements IMobileUtils {
	commonUtils element = new commonUtils();
	
	
	@FindBy(xpath = "(//XCUIElementTypeImage[@name=\"mangnifyingglass\"]//preceding-sibling::XCUIElementTypeButton)[2]")
	protected ExtendedWebElement profileIcon;
	
	@FindBy(xpath = "((//XCUIElementTypeImage[@name='profileBackground' or @name='Ellipse7728'])[last()]//following-sibling::XCUIElementTypeStaticText)[1]")
	protected ExtendedWebElement userName;
	
	@FindBy(xpath = "((//XCUIElementTypeImage[@name='profileBackground' or @name='Ellipse7728'])[last()]//following-sibling::XCUIElementTypeStaticText)[3]")
	protected ExtendedWebElement userEmail;
	
	
	
	public ProfileOverviewIos(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void navigateToProfile() throws IOException {
		element.click(profileIcon, "Profile Icon");
		
	}

	@Override
	public void verifyProfileDetails() throws IOException {
		String expectedName= "Myai  Test7";
		String expectedEmail= "myai.test7@airindia.com";
		element.assertEquals(userName.getAttribute("value"), expectedName,"User name");
		element.assertEquals(userEmail.getAttribute("value"), expectedEmail,"User email");
		
	}


}
