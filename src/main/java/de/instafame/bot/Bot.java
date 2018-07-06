package de.instafame.bot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import de.instafame.pages.Instagram;

public class Bot {
	
  private String username = "sahel139@gmail.com";
  private String password = "hirashi155";
	
  @Test(priority=1)
  public void testUserLoginKnowledgeCenter() {
	  Instagram.LoginPage().navigate();
	  Instagram.LoginPage().loginUser(username, password);
	  Instagram.ProfilePage().navigate();
	  
	  System.out.println("Reading profile of " + Instagram.ProfilePage().getProfileName());
	  System.out.println("Detected " + Instagram.ProfilePage().getNumberOfPosts() + " posts.");
	  System.out.println("Detected " + Instagram.ProfilePage().getNumberOfAbosIn() + " followers.");
	  System.out.println("Detected " + Instagram.ProfilePage().getNumberOfAbosOut() + " following");
  }
  
  @AfterMethod(alwaysRun = true)
  protected void tearDown(ITestResult result) {
	  System.out.println("Test complete. Cleaning up.");
	  Instagram.cleanUp();
  }
  
}
