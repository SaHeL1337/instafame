package de.instafame.pages.implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import de.instafame.pages.Instagram;

public class SearchPage extends Instagram{
	
	protected static String url = "https://www.instagram.com/";
	
	@FindBy (name = "username")
	WebElement userIDInput;
	
	@FindBy (name = "password")
	WebElement userPasswordInput;
	
	@FindBy (xpath = "//button[contains(text(), 'Log in')]")
	WebElement loginSubmitButton;
	
	@FindBy (className = "coreSpriteDesktopNavProfile")
	WebElement profileLink;
	

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
