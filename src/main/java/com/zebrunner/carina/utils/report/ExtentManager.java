package com.zebrunner.carina.utils.report;
 
import com.aventstack.extentreports.ExtentTest;
 
public class ExtentManager {
	
	
	//This class is to handle threads for Extent test and print steps for each Individual Test.
	
	private ExtentManager() {}
	
	private static 	ThreadLocal<ExtentTest> extTest= new ThreadLocal<>();
	
	public static ExtentTest getExtentTest() {
		return extTest.get();
	}
	public static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}
	public static void unload() {
		extTest.remove();
	}
 
}