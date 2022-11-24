package com.supermarket.tests;

import org.bouncycastle.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtilities;

public class LoginTest extends BaseClass
{
	LoginPage loginpage;
	
	
	Excel excel=new Excel();
	
	
	@Test
	public void verifyValidLoginFunctionality(){
		loginpage=new LoginPage(driver);
		excel.setExcelFile("LoginData","ValidLoginCredentials");
		String userName=excel.get_CellData(0, 0);
		String password=excel.get_CellData(0, 1);
		loginpage.login(userName,password);	
	}
	@Test
	public void verify_LoginByCheckingProfileName(){		
		String expectedUserName="Admin";
		loginpage=new LoginPage(driver);
		loginpage.login();
		String actualUserName=loginpage.get_LoginUsersName();
		Assert.assertEquals(actualUserName,expectedUserName);		
	}
	@Test
	public void verifyInvalidloginAlertMessage() {
	    loginpage=new LoginPage(driver);
		excel.setExcelFile("LoginData","InvalidLoginCredentials");
		String userName=excel.get_CellData(0, 0);
		String password=excel.get_CellData(0, 1);
		loginpage.login(userName,password);	
		loginpage.alert_MessageInvalidLogin();
		Assert.assertFalse(loginpage.is_InvalidAlertMessageDisplayed("Invalid Username/Passwordpassword"));
	}
	@Test
	public void verifyRememberMebuttonIsSelectedOrNot(){
		loginpage=new LoginPage(driver);
		loginpage.clickOn_RememberMeCheckBox();
		Assert.assertTrue(loginpage.Is_RememberMeCheckBoxSelected());	
	}
	@Test
	public void verify_TextOfUserName(){
		String expectedResult="Username";
		loginpage=new LoginPage(driver);
		String acualResult=loginpage.get_UserNameAttributeOfLogin("placeholder");
		Assert.assertEquals(acualResult,expectedResult);		
	}
	@Test
	public void verify_TextOfPassword(){
		String expectedResult="Password";
		loginpage=new LoginPage(driver);
		String acualResult=loginpage.get_PasswordAttributeOfLogin("placeholder");
		Assert.assertEquals(acualResult,expectedResult);		
	}
	@Test
	public void verify_TextOfSigninButton(){
		String expectedResult="Sign In";
		loginpage=new LoginPage(driver);
		String acualResult=loginpage.get_SigninButtonTexteOfLogin();
		Assert.assertEquals(acualResult,expectedResult);		
	}
	@Test
	public void verify_textOfRememberMeCheckbox(){
		String expectedResult="Remember Me";	
		loginpage=new LoginPage(driver);
		String acualResult=loginpage.get_RememberMeCheckBoxTextOfLogin();
		Assert.assertEquals(acualResult,expectedResult);		
	}
	
}
