package com.ust.pharmeasy.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ust.pharmeasy.base.Setup;



public class EventListenerClass implements ITestListener {
	ExtentTest test;
	ExtentReports report;
	public void onStart(ITestContext context) {
	    report = ReportManager.CreateReport();
	  }
	
	
	public void onTestStart(ITestResult result) {
		test =ReportManager.createTest(result, report);
	  }
	
	//@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getName()+" Passed :)");
		String path = System.getProperty("user.dir")+"/screenshots/pass/"+result.getName()+Setup.getTimeStamb()+"pass.png";
		Setup.takescreenshot(path);
		test.addScreenCaptureFromPath(path);
		
		
	}
	
//	public void onTestStart(ITestResult result) {
//		System.out.println("Test started");
//
//	}
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getName()+" Failed :(");
		String path = System.getProperty("user.dir")+"/screenshots/fail/"+result.getName()+Setup.getTimeStamb()+"fail.png";
		Setup.takescreenshot(path);
		test.addScreenCaptureFromPath(path);
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped");
	}
	public void onFinish(ITestContext context) {
	    report.flush();
	  }

}
