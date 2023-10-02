package com.ExtendReport;

import com.aventstack.extentreports.ExtentReports;

public class ExtentFactory {

	public static ExtentReports getInstance() {
		ExtentReports extent;
		extent = new ExtentReports();
		extent.setSystemInfo("Selenium Version", "4.8.1");
		extent.setSystemInfo("Platform", "Windows");

		return extent;

	}
}