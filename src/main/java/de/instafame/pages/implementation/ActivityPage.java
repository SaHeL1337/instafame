package de.instafame.pages.implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import de.instafame.pages.Instagram;

public class ActivityPage extends Instagram{
	
	protected static String url = "https://www.instagram.com/accounts/activity/";
	
	@FindBy (name = "username")
	WebElement userIDInput;
	
	@FindBy (name = "password")
	WebElement userPasswordInput;
	
	@FindBy (xpath = "//button[contains(text(), 'Log in')]")
	WebElement loginSubmitButton;
	

	public void navigate() {
		DRIVER.navigate().to(url);
	}
	
	public void loginUser(String userName, String userPassword) {
		waitForPageReady();
		userIDInput.sendKeys(userName);
		userPasswordInput.sendKeys(userPassword);
		loginSubmitButton.click();
		waitForPageReady();
	}
	
	public String getTitle() {
		return DRIVER.getTitle();
	}
	
}
