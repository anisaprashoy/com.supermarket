package com.supermarket.utilities;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.constants.Constants;

public class GeneralUtilities {
	WebDriver driver;

	public GeneralUtilities(WebDriver driver) {
		this.driver = driver;
	}

	public GeneralUtilities() {

	}

	public String get_TextOfElement(WebElement element) {
		return element.getText();
	}

	public List<String> get_TextOfElements(String xpath) {
		List<String> text = new ArrayList<String>();
		List<WebElement> element = driver.findElements(By.xpath(xpath));
		for (WebElement elementObj : element) {
			text.add(elementObj.getText());
		}
		return text;		
	}	
	public String get_AttributeValue(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	public String get_CssValue(WebElement element, String name) {
		return element.getCssValue(name);
	}

	public boolean is_Displayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean is_Enabled(WebElement element) {
		return element.isEnabled();
	}

	public boolean is_Selected(WebElement element) {
		return element.isSelected();
	}

	public void clear_TextField(WebElement element) {
		element.clear();
	}

	public String get_Title() {
		return driver.getTitle();
	}

	public String get_CurrentUrl() {
		return driver.getCurrentUrl();
	}

	public boolean is_ExpectedTextPresent(WebElement element, String expectedText) {
		return element.getText().equals(expectedText); // getText or attribute
	}

	public String get_TimeStamp() {
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		return timeStamp;
	}

	public String get_RandomNumber() {
		Random r = new Random();
		int x = r.nextInt();
		// int x=r.nextInt(5);
		return String.valueOf(x);
	}

}
