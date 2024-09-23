package com.shoppoint.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class Utilityclassobject {
	
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static ExtentTest getTest()
	{
		return test.get();
	}
	
	public static WebDriver getSdriver()
	{
		return driver.get();
	}
	
	public static void setTest(ExtentTest actTest)
	{
		test.set(actTest);
	}
	
	public static void setSdriver(WebDriver actSdriver)
	{
		driver.set(actSdriver);
	}
}
	


