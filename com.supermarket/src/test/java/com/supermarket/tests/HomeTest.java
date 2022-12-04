package com.supermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.ScreenShot;

public class HomeTest extends BaseClass
{
	HomePage homepage;
	GeneralUtilities generalutilities;
	SoftAssert softassert;

	@Test
	public void verify()
	{
		homepage=new HomePage(driver);
		String userName="anisa";
		String password="anisa";
		homepage=new HomePage(driver);
		softassert=new SoftAssert();
		homepage.login(userName, password);	
		String linkName="Manage Pages";
		if(linkName=="Manage Pages")
		{
			String expectedColor="rgba(233, 30, 99, 1)";
			String actualColor=homepage.managePageBackgroundColor();	
			softassert.assertEquals(actualColor,expectedColor);	
			softassert.assertAll();
		}
	
		else if (linkName=="Dashboard") 
		{
			
			String expectedColor="rgba(0, 128, 0, 1)";
			String actualColor=homepage.dashBoard_backgroundColor();
			softassert.assertEquals(actualColor,expectedColor);	
			softassert.assertAll();	
		}
		else if (linkName=="Category") 
		{
			String expectedColor="rgba(0, 128, 128, 1)";
			String actualColor=homepage.category_backgroundColor();
			softassert.assertEquals(actualColor,expectedColor);	
			softassert.assertAll();		
		}
		
		else if (linkName=="Manage Product") 
		{
			String expectedColor="rgba(154, 188, 50, 1)";
			String actualColor=homepage.manageProduct_backgroundColor();
			softassert.assertEquals(actualColor,expectedColor);	
			softassert.assertAll();	
		}
		else if (linkName=="Manage Offer Code") 
		{
			String expectedColor="rgba(244, 212, 66, 1)";
			String actualColor=homepage.manageOfferCode_backgroundColor();
			softassert.assertEquals(actualColor,expectedColor);	
			softassert.assertAll();	
		}
	
		else if (linkName=="Manage Slider") 
		{
			String expectedColor="rgba(66, 217, 244, 1)";
			String actualColor=homepage.manageSlider_backgroundColor();
			softassert.assertEquals(actualColor,expectedColor);	
			softassert.assertAll();	
		}
		else if (linkName=="Manage Package") 
		{
			String expectedColor="rgba(244, 66, 131, 1)";
			String actualColor=homepage.managePackage_backgroundColor();
			softassert.assertEquals(actualColor,expectedColor);	
			softassert.assertAll();	
		}
		
		else if (linkName=="Manage Delivery Boy") 
		{
			String expectedColor="rgba(6, 107, 229, 1)";
			String actualColor=homepage.manageDeliveryBoy_backgroundColor();
			softassert.assertEquals(actualColor,expectedColor);	
			softassert.assertAll();	
		}
		else if (linkName=="Manage Users") 
		{
			String expectedColor="rgba(6, 229, 162, 1)";
			String actualColor=homepage.manageUsers_backgroundColor();
			softassert.assertEquals(actualColor,expectedColor);	
			softassert.assertAll();	
		}
		else if (linkName=="Manage Orders") 
		{
			String expectedColor="rgba(255, 109, 0, 1)";
			String actualColor=homepage.manageOrders_backgroundColor();
			softassert.assertEquals(actualColor,expectedColor);	
			softassert.assertAll();	
		}
		else if (linkName=="Manage Location") 
		{
			String expectedColor="rgba(114, 131, 167, 1)";
			String actualColor=homepage.manageLocation_backgroundColor();
			softassert.assertEquals(actualColor,expectedColor);	
			softassert.assertAll();	
		}
		else if (linkName=="Purchased Packages") 
		{
			String expectedColor="rgba(75, 81, 93, 1)";
			String actualColor=homepage.purchasedPackages_backgroundColor();
			softassert.assertEquals(actualColor,expectedColor);	
			softassert.assertAll();	
		}
		else if (linkName=="Mobile Slider") 
		{
			String expectedColor="rgba(66, 165, 245, 1)";
			String actualColor=homepage.mobileSlider_backgroundColor();
			softassert.assertEquals(actualColor,expectedColor);	
			softassert.assertAll();	
		}
		else if (linkName=="Manage News") 
		{
			String expectedColor="rgba(0, 128, 128, 1)";
			String actualColor=homepage.manageNews_backgroundColor();
			softassert.assertEquals(actualColor,expectedColor);	
			softassert.assertAll();	
		}
		else if (linkName=="Manage Expense") 
		{
			String expectedColor="rgba(66, 165, 245, 1)";
			String actualColor=homepage.manageExpense_backgroundColor();
			softassert.assertEquals(actualColor,expectedColor);	
			softassert.assertAll();
		}	
		
	}
	
}
