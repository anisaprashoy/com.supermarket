package com.supermarket.base;

import org.testng.annotations.DataProvider;

import com.supermarket.utilities.Excel;

public class DataProviders {
	Excel excel=new Excel();
	
	@DataProvider(name="loginCredentials")
	public Object[][] method_UserName()
	{
		return new Object[][] {{"admin","admin"}};
	}
	
	
	@DataProvider(name="loginCredentialsUseExcel")
	public Object[][] method_UserName1()
	{
		excel.setExcelFile("LoginData","DataProviderLogin");
		Object data[][]=excel.get_MultiDimensionalData(4, 2);
		return data;
	}
	
	
}
