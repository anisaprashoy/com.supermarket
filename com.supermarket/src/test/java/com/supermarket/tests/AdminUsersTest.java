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
	GeneralUtilities generalutilities = new GeneralUtilities();

	@Test(dataProvider = "loginCredentials", dataProviderClass = DataProviders.class)
	public void verify_UserCanOpenAdminUsersPage(String userName, String password) {
		adminuserspage = new AdminUsersPage(driver);
		System.out.println(userName + " " + password);
		String actualResult = adminuserspage.open_AdminUsers(userName, password);
		String expectedResult = "Admin Users | 7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 0)
	public void verifyUserCanCreate_NewUsers() {
		adminuserspage = new AdminUsersPage(driver);
		excel.setExcelFile("AdminUsersData", "NewUserCreation");
		String userName = excel.get_CellData(0, 1);
		String password = excel.get_CellData(1, 1);
		String timeStamp = generalutilities.get_TimeStamp();
		userName = userName + "_" + timeStamp;
		String userType = excel.get_CellData(2, 1);
		String expectedResult = "×" + "\n" + "Alert!" + "\n" + "User Created Successfully";
		String actualResult = adminuserspage.create_NewUser(userName, password, userType);
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(groups = { "Smoke", "Regression" })
	public void verify_UserCanSearchUsers() {
		adminuserspage = new AdminUsersPage(driver);
		excel.setExcelFile("AdminUsersData", "SearchUserDetails");
		String userName = excel.get_CellData(0, 1);
		String expectedResult = "Search Admin Users";
		String actualResult = adminuserspage.search_User(userName);
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(groups = { "Smoke", "Regression" })
	public void verify_UserCanDeactivateUser() {
		adminuserspage = new AdminUsersPage(driver);
		String expectedResult = "×" + "\n" + "Alert!" + "\n" + "User Status Changed Successfully";
		String actualResult = adminuserspage.deactivate_User("ani123");
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 1,dependsOnMethods = "verifyUserCanCreate_NewUsers")
	public void verify_UserCanDeleteUser() {
		adminuserspage = new AdminUsersPage(driver);
		String expectedResult = "×" + "\n" + "Alert!" + "\n" + "User Deleted Successfully";
		String actualResult = adminuserspage.delete_User("nisaDelete");
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test
	public void verify_UserCanEditUser() {
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.edit_User("ani123", "nisa1234", "Delivery Boy");
		String expectedResult = "×" + "\n" + "Alert!" + "\n" + "User Updated Successfully";
		String actualResult = adminuserspage.alert_MessageTextAfterUdade();
		Assert.assertEquals(actualResult, expectedResult);
	}

}
