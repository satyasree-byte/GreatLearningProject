package com.GreatLearning.MainPackage.Reports;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	static ExtentReports extent;
	
	
	final static String filePath = "C:\\Users\\satyasree\\eclipse-workspace\\GreatLearningAutomation\\target\\Extent.html";
	static Map<Integer, ExtentTest> extentTestMap = new HashMap();
	public synchronized static ExtentReports getReporter() {
		
		 Calendar cal = Calendar.getInstance();   
		   Date time=cal.getTime();
		   String timestamp = time.toString();
		   String systime=timestamp.replace(":", "-");
		   int year = cal.get(Calendar.YEAR);
		   int month = (cal.get(Calendar.MONTH)+1);
		   int day = cal.get(Calendar.DAY_OF_MONTH);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());


		if(extent == null) {
			 ExtentHtmlReporter html = new ExtentHtmlReporter(systime+".html");
			 html.config().setDocumentTitle("GREAT LEARNING AUTOMATION");
			 html.config().setReportName("SIGN UP HAPPY FLOW");
			 html.config().setTheme(Theme.DARK);
			extent = new ExtentReports();
			extent.attachReporter(html);
		}
		
		return extent;
	}

	public synchronized static ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int)(long)(Thread.currentThread().getId()));
	}
	
	public synchronized static ExtentTest startTest(String testName , String desc) {
		ExtentTest test = getReporter().createTest(testName , desc);
		extentTestMap.put((int)(long)Thread.currentThread().getId(),test);
		
		return test;
	}
	
	public synchronized static void endTest() {
		 getReporter().flush();
		
	}
}
