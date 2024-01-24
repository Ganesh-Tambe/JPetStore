package com.JPetStore.JPetStore;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportListener implements ITestListener {

    private ExtentReports extentReports;
    private ExtentTest extentTest;

    
    public void onStart(ITestContext context) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("ExtentReport/extent-report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }


    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

   
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test Passed");
    }

    
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, "Test Failed");
        extentTest.log(Status.FAIL, result.getThrowable());
    }

    // Implement other methods as needed
}

