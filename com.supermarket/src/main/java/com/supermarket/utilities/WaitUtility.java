package com.supermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility 
{
	public static final long IMPLICIT_WAIT=10;
	public static final long PAGE_LOAD_WAIT=10;
	
	WebDriver driver;
	WebDriverWait wait;
	
	public WaitUtility(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public void wait_ForElemenToBeClickable(long second,String xpath)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(second));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
	
	public void wait_ForVisibility(long second,String xpath)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(second));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	
	public void wait_ForInvisibility(long second,String xpath)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(second));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}
	public void wait_UntilPopupAlert(long second,String xpath)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(second));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void fluent_Wait(long timeout,long polling,String path)
	{
		Wait  wait = (WebDriverWait) new FluentWait(driver)
				 .withTimeout(Duration.ofSeconds(timeout))
				   .pollingEvery(Duration.ofSeconds(polling))
				  .ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
	}	
}