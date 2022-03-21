package com.GreatLearning.MainPackage.Reports;

import java.io.File;
import java.io.IOException;

import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.GreatLearning.MainPackage.BaseDriver.BaseDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class TestListener extends BaseDriver implements ITestListener {

	// BaseDriver Base = new
	public void onTestStart(ITestResult result) {
		//System.out.println(result.getTestName());

	}

	public void onTestSuccess(ITestResult result) {
		ExtentReport.getTest().log(Status.PASS, "Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		String TestName = result.getMethod().getMethodName();
		String CompleteImagePath;

		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] encoded = null;
		try {
			encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(srcfile));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		CompleteImagePath = System.getProperty("user.dir") + "\\src\\test\\Screenshots\\" + TestName + "_"
				+ "test_SCreenshot.png";
		try {
			FileUtils.copyFile(srcfile, new File(CompleteImagePath));
			Reporter.log("This is the sample screenshot");
			Reporter.log("<a href='" + CompleteImagePath + "'> <img src='" + CompleteImagePath
					+ "' height='400' width='400'/> </a>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ExtentReport.getTest().fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(CompleteImagePath).build());
			ExtentReport.getTest().fail("Test Failed", MediaEntityBuilder
					.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
		ExtentReport.getTest().fail(result.getThrowable());
		
	}

	public void onTestSkipped(ITestResult result) {
		ExtentReport.getTest().log(Status.SKIP, "Test Skipped");
		

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		ExtentReport.getReporter().flush();

	}

}
