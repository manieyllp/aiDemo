package com.ai.ceplus.ui.pages.common;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class LoginPageBase extends AbstractPage{

	
	public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickSkip() throws InterruptedException, IOException;
       
    public abstract void enterEmailID(String emailID) throws InterruptedException, IOException;
    
    public abstract void clickSignIn() throws InterruptedException, IOException ;
    
    public abstract void enterPassowrd(String password) throws InterruptedException, IOException;
    
    public abstract void clickPasswordSignIn() throws IOException;
    
    public abstract void verifyLogin();
    
}
