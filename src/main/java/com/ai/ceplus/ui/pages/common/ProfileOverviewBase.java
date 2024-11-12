package com.ai.ceplus.ui.pages.common;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class ProfileOverviewBase extends AbstractPage{

	
	public ProfileOverviewBase(WebDriver driver) {
        super(driver);
    }

	public abstract void navigateToProfile() throws IOException ;
	
	public abstract void verifyProfileDetails() throws IOException;
    
}
