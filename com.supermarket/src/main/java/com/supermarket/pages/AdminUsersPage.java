package com.supermarket.pages;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class AdminUsersPage {

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
	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	private WebElement adminUsersLink;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newLinkElement;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement newUserNameFieldElement;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement newPasswordFieldElement;
	@FindBy(xpath = "//div[@class='form-group']//select[@class='form-control']")
	private WebElement newUserTypeElement;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement newSaveButtonElement;
	
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	//@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchLinkElement;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchLinkAfterDeleteElement;
	
	
	
	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchUserNameFieldElement;	
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement searchUserTypeElement;	
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchUserSearchButtonElement;
	
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	private WebElement editUserElement;
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement updateButtoneOfEditElement;
	
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	private WebElement deleteUserElement;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert_ForDeleteOrEditUserElement;
	

	public AdminUsersPage(WebDriver driver) {
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

	public void click_AdminUsers() {
		waitutility = new WaitUtility(driver);
		waitutility.wait_ForElemenToBeClickable(10, "//i[@class='nav-icon fas fa-users']");
		adminUsersLink.click();
	}

	public void click_OnNew() {
		waitutility = new WaitUtility(driver);
		waitutility.wait_ForElemenToBeClickable(10, "//a[@onclick='click_button(1)']");
		newLinkElement.click();
	}

	public void enter_UserName(String userName) {
		waitutility = new WaitUtility(driver);
		waitutility.wait_ForElemenToBeClickable(10, "//a[@onclick='click_button(1)']");
		newUserNameFieldElement.sendKeys(userName);
	}

	public void enter_Password(String password) {
		waitutility = new WaitUtility(driver);
		waitutility.wait_ForElemenToBeClickable(10, "//a[@onclick='click_button(1)']");
		newPasswordFieldElement.sendKeys(password);
	}

	public void select_UserType(String userType) {
		waitutility = new WaitUtility(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitutility.IMPLICIT_WAIT));
		
		//newUserTypeElement.click();
		Select select = new Select(newUserTypeElement);
		select.selectByVisibleText(userType);
	}
	public void save_NewUser() {
		newSaveButtonElement.click();
	}
	public void create_NewUser(String userName, String password, String userType) {
		login();
		click_AdminUsers();
		click_OnNew();
		enter_UserName(userName);
		enter_Password(password);
		select_UserType(userType);
		save_NewUser();
	}
	public void click_OnSearchLink(){
		searchLinkElement.click();
	}
	public void enter_SearchLinkUserName(String userName){
		searchUserNameFieldElement.sendKeys(userName);
	}
	public void select_SearchLinkUserType(String userType){
		searchUserTypeElement.sendKeys(userType);
	}
	public void click_OnSearchLinkSearchButton(){
		searchUserSearchButtonElement.click();
	}
	public void click_Edit(){
		editUserElement.click();
	}
	public void search_User(String userName) {
		login();
		click_AdminUsers();
		click_OnSearchLink();
		enter_SearchLinkUserName(userName);
		click_OnSearchLinkSearchButton();		
	}
	public void edit_User(String password) {
		passwordElement.clear();
		passwordElement.sendKeys(password);	
		updateButtoneOfEditElement.click();
	}
	public void update_User(String userName,String password){
		search_User(userName);
		click_Edit();
		edit_User(password);	
	}
	public String alert_MessageTextAfterUdade(){
		generalutility=new GeneralUtilities();
		return generalutility.get_TextOfElement(alert_ForDeleteOrEditUserElement);
	}
	public void click_OnDeleteButton(){
		deleteUserElement.click();
		driver.switchTo().alert().accept();
	}
	public void delete_user(String userName){
		search_User(userName);
		click_OnDeleteButton();
	}
	public void deactivate_User(String userName)
	{
		//driver.findElement(By.xpath("//tbody//tr[13]//td[5]//a[1]")).click();
		generalutility=new GeneralUtilities(driver);
		List<String> usernames=new ArrayList<String>();
		usernames=generalutility.get_TextOfElements("//tr//td[1]");
		int pos=0;
		for(pos=0;pos<=usernames.size();pos++)
		{
			if(usernames.get(pos).equals(userName))
			{
				pos++;
				break;
			}
		}
		driver.findElement(By.xpath("//tr["+pos+"]//td[5]//a[1]")).click();
	}	
}
