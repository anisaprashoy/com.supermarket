package com.supermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

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
	@FindBy(xpath = "//div[@style='background-color:#E91E63 !important;']")
	private WebElement managePagesBoxElement;
	@FindBy(xpath = "//div[@style='background-color:green !important;']")
	private WebElement dashBoardBoxElement;
	@FindBy(xpath = "//div[@style='background-color:teal !important;']")
	private WebElement categoryBoxElement;
	@FindBy(xpath = "//div[@style='background-color:#9ABC32 !important;']")
	private WebElement manageProductBoxElement;
	@FindBy(xpath = "//div[@style='background-color:#f4d442 !important;']")
	private WebElement manageOfferCodeBoxElement;
	@FindBy(xpath = "//div[@style='background-color:#42d9f4 !important;']")
	private WebElement manageSliderBoxElement;
	@FindBy(xpath = "//div[@style='background-color:#f44283 !important;']")
	private WebElement managePackageBoxElement;
	@FindBy(xpath = "//div[@style='background-color:#066be5 !important;']")
	private WebElement manageDeliveryBoyBoxElement;
	@FindBy(xpath = "//div[@style='background-color:#06e5a2 !important;']")
	private WebElement manageUsersBoxElement;
	@FindBy(xpath = "//div[@style='background-color:#ff6d00 !important;']")
	private WebElement manageOrdersBoxElement;
	@FindBy(xpath = "//div[@style='background-color:#7283a7 !important;']")
	private WebElement manageLocationBoxElement;
	@FindBy(xpath = "//div[@style='background-color:#4B515D !important;']")
	private WebElement purchasedPackagesBoxElement;
	@FindBy(xpath = "//div[@style='background-color:#42a5f5 !important;']")
	private WebElement mobileSliderBoxElement;
	@FindBy(xpath = "//div[@style='background-color:teal !important;']")
	private WebElement manageNewsBoxElement;
	@FindBy(xpath = "//div[@style='background-color:purple !important;']")
	private WebElement manageExpenseBoxElement;

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

	// get_TextOfElements(String xpath)
	public String managePageBackgroundColor() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_CssValue(managePagesBoxElement, "background-color");
	}

	public String dashBoard_backgroundColor() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_CssValue(dashBoardBoxElement, "background-color");	
	}

	public String category_backgroundColor() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_CssValue(categoryBoxElement, "background-color");
	}

	public String manageProduct_backgroundColor() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_CssValue(manageProductBoxElement, "background-color");
	}

	public String manageOfferCode_backgroundColor() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_CssValue(manageOfferCodeBoxElement, "background-color");	
	}

	public String manageSlider_backgroundColor() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_CssValue(manageSliderBoxElement, "background-color");
	}

	public String managePackage_backgroundColor() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_CssValue(managePackageBoxElement, "background-color");
		
	}

	public String manageDeliveryBoy_backgroundColor() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_CssValue(manageDeliveryBoyBoxElement, "background-color");
	}

	public String manageUsers_backgroundColor() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_CssValue(manageUsersBoxElement, "background-color");
		
			
	}

	public String manageOrders_backgroundColor() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_CssValue(manageOrdersBoxElement, "background-color");
	}

	public String manageLocation_backgroundColor() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_CssValue(manageLocationBoxElement, "background-color");
	}

	public String purchasedPackages_backgroundColor() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_CssValue(purchasedPackagesBoxElement, "background-color");
	}

	public String mobileSlider_backgroundColor() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_CssValue(mobileSliderBoxElement, "background-color");
	}

	public String manageNews_backgroundColor() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_CssValue(manageNewsBoxElement, "background-color");
	}

	public String manageExpense_backgroundColor() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_CssValue(mobileSliderBoxElement, "background-color");
		
	}

}
