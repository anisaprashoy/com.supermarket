package com.supermarket.pages;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	Properties prop = new Properties();
	FileInputStream ip;
	GeneralUtilities generalutility;
	PageUtility pageutility;
	WaitUtility waitutility;
	
	@CacheLookup
	@FindBy(xpath = "//input[contains(@name,'username')]")
	private WebElement userNameElement;
	@CacheLookup
	@FindBy(xpath = "//input[contains(@name,'password')]")
	private WebElement passwordElement;

	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement signinButtonElement;

	@FindBy(xpath = "//label[@for='remember']")
	private WebElement rememberMeElement;

	@FindBy(xpath = "//div[@class='icheck-dark']//input[@id='remember']")
	private WebElement rememberMeCheckBoxElement;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertMessage;

	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement profileElement;

	public LoginPage(WebDriver driver) {
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

	
	public String get_LoginUsersName() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_TextOfElement(profileElement);
	}

	public String get_UserNameAttributeOfLogin(String attributeName) {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_AttributeValue(userNameElement, attributeName);
	}

	public String get_PasswordAttributeOfLogin(String attributeName) {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_AttributeValue(passwordElement, attributeName);
	}

	public String get_SigninButtonTexteOfLogin() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_TextOfElement(signinButtonElement);
	}

	public String get_RememberMeCheckBoxTextOfLogin() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_TextOfElement(rememberMeElement);
	}

	public void clickOn_RememberMeCheckBox() {
		pageutility = new PageUtility(driver);
		pageutility.click_UsingJavascriptExecuter(rememberMeElement);
	}

	public boolean Is_RememberMeCheckBoxSelected() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.is_Selected(rememberMeCheckBoxElement);
	}

	public boolean alert_MessageInvalidLogin() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.is_Selected(rememberMeElement);
	}

	public boolean is_InvalidAlertMessageDisplayed(String expectedText) {
		generalutility = new GeneralUtilities(driver);
		waitutility = new WaitUtility(driver);
		waitutility.wait_ForVisibility(10, "//div[@class='alert alert-danger alert-dismissible']");
		return generalutility.is_ExpectedTextPresent(alertMessage, expectedText);
	}
}
