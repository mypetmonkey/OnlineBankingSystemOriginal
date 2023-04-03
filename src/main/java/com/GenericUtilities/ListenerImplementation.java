package com.GenericUtilities;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log(methodName+"------>testscript excution started");
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS,methodName+"----->passed");
		Reporter.log(methodName+"----->testScript execution successfull");
		
	}

	public void onTestFailure(ITestResult result) {
		
//		String methodname=result.getMethod().getMethodName();
//		String failedScript=methodname+new JavaUtilities().getSystemDate();
//		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
//		File src=edriver.getScreenshotAs(OutputType.FILE);
//		File dest=new File("./screenshotOBS/"+failedScript+".png");
//		try {
//			FileUtils.copyFile(src, dest);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			String ssName=WebdriverUtilities.getScreenshot(BaseClass.sdriver,result.getMethod().getMethodName());
			test.addScreenCaptureFromPath("./../Screenshot/"+ssName+".png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL,result.getThrowable().getMessage() );
		Reporter.log("testscript execution failed");
	}

	public void onTestSkipped(ITestResult result) {  
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"--skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("test execution skipped");
	}

	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlReport.config().setDocumentTitle("SDET-47 Batch");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Online-Banking_System");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);report.setSystemInfo("Base-Browser  ","chrome");
		report.attachReporter(htmlReport);report.setSystemInfo("os  ", "windows");
		report.attachReporter(htmlReport);report.setSystemInfo("base-URL  ", "https://localhost:8888");
		report.attachReporter(htmlReport);report.setSystemInfo("Reporter-name   ", "Rajhans");
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	
	

}
