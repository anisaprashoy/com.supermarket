package com.supermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")
	private WebElement pushNotificatio_Send_Element;

	
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
	public String text_OfPushNotificationPage()
	{
		WebElement textElement=driver.findElement(By.xpath("//h3[contains(text(),'Push Notifications Informations')]"));
		generalutility=new GeneralUtilities(driver);
		return generalutility.get_TextOfElement(textElement);	
	}
	public String find_TextOfPushNotificationPage()
	{
		login();
		click_OnPushNotificationLink();
		return text_OfPushNotificationPage();	
	}
	public boolean sendButton_IsClickable()
	{
		login();
		click_OnPushNotificationLink();
		generalutility=new GeneralUtilities(driver);
		return generalutility.is_Enabled(pushNotificatio_Send_Element);
	}
	
	public void enter_TitleAndDiscription(String title,String description)
	{
		waitutility=new WaitUtility(driver);	
		waitutility.wait_ForVisibility(10,"//i[contains(@class,'nav-icon fas fa-fas fa-bell')]");
		pushNotificationTitleElement.sendKeys(title);
		pushNotificationDescriptionElement.sendKeys(description);
	}
	public String alert_MessageAfterSendingNotification()
	{
		WebElement alert=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		generalutility=new GeneralUtilities(driver);
		return generalutility.get_TextOfElement(alert);		
	}
	public void click_OnSendButton()
	{
	pushNotificatio_Send_Element.click();
	}
	
	public String send_notification(String title,String description)
	{
		login();
		click_OnPushNotificationLink();
		enter_TitleAndDiscription(title,description);
		click_OnSendButton();
		return alert_MessageAfterSendingNotification();
		
	}
	
	
}
