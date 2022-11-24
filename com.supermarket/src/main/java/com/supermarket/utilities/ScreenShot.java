package com.supermarket.utilities;

import java.io.File;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.supermarket.constants.Constants;

public class ScreenShot {
	//TakesScreenshot is a interface
	TakesScreenshot scrhhot;
	public void take_Screenshot(WebDriver driver,String imageName)
	{
		scrhhot=(TakesScreenshot) driver;
		GeneralUtilities generalutility=new GeneralUtilities();
		
		
		try {
			
			scrhhot=(TakesScreenshot) driver;
			File sreen_shot=scrhhot.getScreenshotAs(OutputType.FILE);
			String timeStamp=generalutility.get_TimeStamp();
			String destinationFolderPath=Constants.SCREENSHOT_FILEPATH+imageName+timeStamp+".png";
			File finalDestination=new File(destinationFolderPath);
		
			FileHandler.copy(sreen_shot, finalDestination);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
