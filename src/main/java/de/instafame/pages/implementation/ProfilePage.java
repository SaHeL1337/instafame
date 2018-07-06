package de.instafame.pages.implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import de.instafame.pages.Instagram;

public class ProfilePage extends Instagram{
	
	protected static String url = "https://www.instagram.com/";
	
	@FindBy (className = "coreSpriteDesktopNavProfile")
	WebElement profileIcon;
	
	@FindBy (xpath = "//a[contains(@href, '/followers/')]/span")
	WebElement numberOfAbosInA;
	
	@FindBy (xpath = "//a[contains(@href, '/following/')]/span")
	WebElement numberOfAbosOutA;
	
	@FindBy (xpath = "//ul//li/span/span")
	WebElement numberOfPostsSpan;
	
	@FindBy (xpath = "//section/div/h1")
	WebElement profileNameIdentifier;
	
	public void navigate() {
		DRIVER.navigate().to(url);
		profileIcon.click();

		waitForPageReady();
	}
	
	public String getNumberOfAbosIn() {
		return numberOfAbosInA.getText();
	}
	
	public String getNumberOfAbosOut() {
		return numberOfAbosOutA.getText();
	}
	
	public String getNumberOfPosts() {
		return numberOfPostsSpan.getText();
	}

	public String getProfileName() {
		return profileNameIdentifier.getText();
	}
}
