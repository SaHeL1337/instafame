package de.instafame.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import de.instafame.utils.Browser;

public class Webpage {

	protected static int TIMEOUT_IN_SECONDS = 15;
	protected static WebDriver DRIVER = null;
	protected static WebDriverWait WAIT = null;
	protected static Browser BROWSER = Browser.Chrome;
	protected static String BASE_URL = "";
		
	protected static <T> T init(T p_page){
		if(DRIVER == null) {
			initDriver();
		}
		
		PageFactory.initElements(Webpage.DRIVER, p_page);
		return p_page;
	}
	
	protected static void initDriver() {
		switch(BROWSER) {
		case Firefox:
			 System.setProperty(
		                "webdriver.gecko.driver",
		                "webdriver/geckodriver.exe");
			DRIVER = new FirefoxDriver();
			break;
			
		case Chrome: default:
			 System.setProperty(
		                "webdriver.chrome.driver",
		                "webdriver/chromedriver.exe");
			DRIVER = new ChromeDriver();
			break;
		}
		
		
		DRIVER.manage().window().maximize();
		WAIT = new WebDriverWait(DRIVER, TIMEOUT_IN_SECONDS);
	}
	
	
	public static void setDriver(Browser p_browser) {
		BROWSER = p_browser;
	}
	
	protected static void cleanup() {
		DRIVER.close();
		DRIVER = null;
	}
	
	public String getTitle() {
		return DRIVER.getTitle();
	}
}