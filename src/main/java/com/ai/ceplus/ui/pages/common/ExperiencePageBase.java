package com.ai.ceplus.ui.pages.common;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class ExperiencePageBase extends AbstractPage{

	
	public ExperiencePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickProfileIcon() throws InterruptedException, IOException;
    
    public abstract void enterEmployeeCode() throws IOException;
    
    public abstract void clickOnFirstEdit() throws IOException;
    
    public abstract void enterCompany() throws IOException;
    
    public abstract void enterPosition() throws IOException;
    
    public abstract void enterCTC() throws IOException;
    
    public abstract void selectStartDate() throws IOException;
    
    public abstract void selectEndDate() throws IOException ;
    
    public abstract void clickSave() throws IOException;
    
    public abstract void verifySucessfullyUpdated();
}
