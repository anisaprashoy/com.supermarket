package com.supermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class PushNotificationsPage {
	public WebDriver driver;
	Properties prop = new Properties();
	FileInputStream ip;
	GeneralUtilities generalutility;
	PageUtility pageutility;
	WaitUtility waitutility;
	
	@FindBy(xpath = "//input[contains(@name,'username')]")
	private WebElement userNameElement;

	@FindBy(xpath = "//input[contains(@name,'password')]")
	private WebElement passwordElement;

	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement signinButtonElement;
	
	@FindBy(xpath="//i[contains(@class,'nav-icon fas fa-fas fa-bell')]")
	private WebElement pushNotificationLinkElement;
	
	
	@FindBy(xpath="//input[@placeholder='Enter Title']")
	private WebElement pushNotificationTitleElement;
	
	@FindBy(xpath="//input[@placeholder='Enter Description']")
	private WebElement pushNotificationDescriptionElement;


	
	public PushNotificationsPage(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			ip = new FileInputStream(Constants.CONFIGURE_FILE_PATH);
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void enterUserName(String userName) {
		userNameElement.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordElement.sendKeys(password);
	}
	public void clickOnSubmitButton() {
		signinButtonElement.click();
	}
	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickOnSubmitButton();
	}
	public void login() {
		String userName = prop.getProperty("userName");
		String password = prop.getProperty("password");
		login(userName, password);
	}
	public void click_OnPushNotificationLink()
	{
		pushNotificationLinkElement.click();
	}
	public void pushnotificationTitleAndDiscription(String title,String description)
	{
		waitutility=new WaitUtility(driver);	
		waitutility.wait_ForVisibility1(10,"//i[contains(@class,'nav-icon fas fa-fas fa-bell')]");
		//waitutility.fluent_Wait(20, 5,"//i[contains(@class,'nav-icon fas fa-fas fa-bell')]");
		
		pushNotificationTitleElement.sendKeys(title);
		pushNotificationDescriptionElement.sendKeys(description);
	}
	
}
