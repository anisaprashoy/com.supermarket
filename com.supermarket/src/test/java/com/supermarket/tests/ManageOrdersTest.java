package com.supermarket.tests;

import org.testng.annotations.Test;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.ManageOrdersPage;
import com.supermarket.utilities.Excel;

public class ManageOrdersTest extends BaseClass{
	ManageOrdersPage  manageorderspage;
	Excel excel=new Excel();
	@Test
	public void verify()
	{
		manageorderspage=new ManageOrdersPage(driver);
		manageorderspage.open_ManageOrders();
		
	}
	
	

}
