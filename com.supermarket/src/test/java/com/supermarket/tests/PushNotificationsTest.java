package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.PushNotificationsPage;
import com.supermarket.utilities.Excel;

public class PushNotificationsTest extends BaseClass{
	PushNotificationsPage pushnotificationspage;
	Excel excel=new Excel();
	
	@Test
	public void verify_LoginByCheckingProfileName(){		
		pushnotificationspage=new PushNotificationsPage(driver);
		pushnotificationspage.login();
		pushnotificationspage.click_OnPushNotificationLink();
		excel.setExcelFile("PushNotificationData","WarningMessage");
		String title=excel.get_CellData(0, 0);
		String description=excel.get_CellData(0, 1);
		pushnotificationspage.pushnotificationTitleAndDiscription(title,description);
	}
}
