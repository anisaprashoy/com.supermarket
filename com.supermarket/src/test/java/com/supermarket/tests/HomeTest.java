package com.supermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.ScreenShot;

public class HomeTest extends BaseClass
{
	HomePage homepage;
	GeneralUtilities generalutilities;
	@Test
	public void printHamePage_Links()
	{		
		String userName="anisa";
		String password="anisa";
		homepage=new HomePage(driver);
		homepage.login(userName, password);
		homepage.homePage_Links();
		List<String> links=new ArrayList<String>();
		System.out.println(homepage.homePage_Links());
	}
	
	

}
