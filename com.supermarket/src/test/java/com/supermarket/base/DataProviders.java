package com.supermarket.base;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginCredentials")
	public Object[][] method_UserName()
	{
		return new Object[][] {{"admin","admin"}};
	}
	
}
