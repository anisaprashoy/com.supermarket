package com.supermarket.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void select_ByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void select_ByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void click_UsingMouse(WebElement element) {
		actions = new Actions(driver);
		actions.click().build().perform();
	}
	public void scrollIntoViewByWebElement_UsingJavascriptExecuter(WebElement element)
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
	public void scrollByIndex_UsingJavascriptExecuter(WebElement element)
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public void press_UsingRobotClass()
	{
		
	}
	public void click_UsingJavascriptExecuter(WebElement element)
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	//doubt in parameter
	public void fileUpload_UsingSendkeys(String elementPath,String path)
	{
		WebElement fileChoose=driver.findElement(By.xpath(elementPath));
		fileChoose.sendKeys(path);
	}
	public boolean is_Visible(String xpath)
	{
		try {
			driver.findElement(By.xpath(xpath));
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	public boolean is_Clicked(WebElement element)
	{
		try {
			element.click();
			return false;
		} catch (Exception e) {
			return true;
		}
	}
	public void scroll_And_Click(WebElement element)
	{
		int x=0;
		js=(JavascriptExecutor) driver;
		while(is_Clicked(element))
		{
			js.executeScript("window.scrollBy(0," + x + ")");
			x=x+20;
			
		}
		
	}
	
	
	// js index scrolldown,js webelement scroll into view,click
	// file upload2..robotclass
	
}
