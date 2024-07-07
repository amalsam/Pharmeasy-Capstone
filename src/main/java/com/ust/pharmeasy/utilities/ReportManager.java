package com.ust.pharmeasy.utilities;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ust.pharmeasy.base.Setup;



public class ReportManager {
	public static ExtentReports extent;
	public static ExtentSparkReporter htmlReporter; 
	public static ExtentTest test;
	public static ExtentReports CreateReport() {
		String repname = "TestReport--"+Setup.getTimeStamb()+".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//TestNG//"+repname);
		htmlReporter.config().setDocumentTitle("PharmEasy Test");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("MM/dd/yyyy HH:mm:ss");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS","Windows 11");
		extent.setSystemInfo("Host Name","localhost");
		extent.setSystemInfo("Environment","Test");
		extent.setSystemInfo("User Name", "Team 2");
		
		return extent;
		
	}
	public static ExtentTest createTest(ITestResult result, ExtentReports report) {
		test = report.createTest("Verification of "+result.getName());
		return test;
	}

}
