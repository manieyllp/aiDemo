package com.zebrunner.carina.utils.report;


public class ExtentLogger {
	 
	public static void pass(String message) {
    ExtentManager.getExtentTest().pass(message);
	}
	public static void fail(String message) {
		 ExtentManager.getExtentTest().pass(message);
	}
	public static void skip(String message) {
		 ExtentManager.getExtentTest().skip(message);
	}
 
}