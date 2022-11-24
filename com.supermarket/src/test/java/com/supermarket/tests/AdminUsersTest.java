package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.BaseClass;
import com.supermarket.base.DataProviders;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtilities;

public class AdminUsersTest extends BaseClass {
	AdminUsersPage adminuserspage;
	Excel excel = new Excel();
	GeneralUtilities generalutilities=new GeneralUtilities();

	@Test(dataProvider = "loginCredentials",dataProviderClass = DataProviders.class)
	public void temp(String userName,String password)
	{
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.login(userName,password);
	}
	
	//time stamp not working
	@Test
	public void verifyNewUsers() {
		adminuserspage = new AdminUsersPage(driver);
		excel.setExcelFile("AdminUsersData","NewUserCreation");
		String userName=excel.get_CellData(0, 1);	
		String password=excel.get_CellData(1, 1);
		String timeStamp=generalutilities.get_TimeStamp();
		userName=userName+"_"+timeStamp;
		String userType=excel.get_CellData(2, 1);
		
		//userType=userType
		adminuserspage.create_NewUser(userName,password,userType);
	}
	@Test
	public void verifySearchUsers() {
		adminuserspage = new AdminUsersPage(driver);
		excel.setExcelFile("AdminUsersData","SearchUserDetails");
		String userName=excel.get_CellData(0, 1);	
		adminuserspage.search_User(userName);	
	}
	@Test
	public void verifyEditUsers() {
		adminuserspage = new AdminUsersPage(driver);
		excel.setExcelFile("AdminUsersData","EditUserPassword");
		String userName=excel.get_CellData(0, 1);	
		String password=excel.get_CellData(1, 1);
		adminuserspage.update_User(userName,password);	
		String expectedResult="×"+"\n"+"Alert!"+"\n"+"User Updated Successfully";
		String actualResult=adminuserspage.alert_MessageTextAfterUdade();
		Assert.assertEquals(actualResult,expectedResult);
	}
	@Test
	public void check_UserAfterDeleteFunction()
	{
		adminuserspage = new AdminUsersPage(driver);
		excel.setExcelFile("AdminUsersData","NewUserCreation");
		String userName=excel.get_CellData(0, 1);	
		adminuserspage.delete_user(userName);	
	}
	@Test
	public void verifyAdminUserDeactivation()
	{
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.login();
		adminuserspage.click_AdminUsers();
		adminuserspage.deactivate_User("nasrin");
	}
}
