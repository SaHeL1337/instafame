package de.instafame.pages;

import de.instafame.pages.implementation.ActivityPage;
import de.instafame.pages.implementation.ExplorePage;
import de.instafame.pages.implementation.LoginPage;
import de.instafame.pages.implementation.ProfilePage;
import de.instafame.pages.implementation.SearchPage;


public class Instagram extends Webpage{

	
	protected static String url = "https://www.instagram.com";
	
	private static LoginPage m_loginPage = null;
	private static ActivityPage m_activityPage = null;
	private static ExplorePage m_explorePage = null;
	private static ProfilePage m_profilePage = null;
	private static SearchPage m_searchPage = null;
	
	//list of selectors that are used in multiple pages
	//@FindBy (xpath = "//div[@eventproxy='toolbarRight_activeButton']")
	//WebElement activeMenuButton;
	
	
	public static LoginPage LoginPage() {
		m_loginPage = (m_loginPage == null)? init(new LoginPage()) : m_loginPage;
		return m_loginPage;
	}
	
	public static ActivityPage ActivityPage() {
		m_activityPage = (m_activityPage == null)? init(new ActivityPage()) : m_activityPage;
		return m_activityPage;
	}
	
	public static ExplorePage ExplorePage() {
		m_explorePage = (m_explorePage == null)? init(new ExplorePage()) : m_explorePage;
		return m_explorePage;
	}
	
	public static ProfilePage ProfilePage() {
		m_profilePage = (m_profilePage == null)? init(new ProfilePage()) : m_profilePage;
		return m_profilePage;
	}
	
	public static SearchPage SearchPage() {
		m_searchPage = (m_searchPage == null)? init(new SearchPage()) : m_searchPage;
		return m_searchPage;
	}
	
	public static void cleanUp() {
		m_loginPage = null;
		m_searchPage = null;
		m_profilePage = null;
		m_explorePage = null;
		m_activityPage = null;
		Webpage.cleanup();
	}
	
	protected static void waitForPageReady() {
		//TODO
		//Make page readiness depend on visibility/clickability of activemenu
		//seems to be the best indicator
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
