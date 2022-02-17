package com.qa.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class TestUtils {
	

	public static void takeScreenshotOnFailure(Scenario scenario, WebDriver driver)
	{
		//take screen shot
		String screenshotName= scenario.getName().replaceAll(" ", "_");
		byte[] sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, "image/png", screenshotName);
		
	}


}
