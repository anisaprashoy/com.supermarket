package com.supermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class HomePage {
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
	
	public HomePage(WebDriver driver) {
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
	//get_TextOfElements(String xpath)
	public List<String> homePage_Links()
	{
		generalutility=new GeneralUtilities(driver);
		return generalutility.get_TextOfElements("//div[@class='row']//div[@class='col-lg-3 col-6']");
	
	}


}
