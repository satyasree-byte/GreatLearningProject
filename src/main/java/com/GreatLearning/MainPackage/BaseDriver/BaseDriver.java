package com.GreatLearning.MainPackage.BaseDriver;

import java.io.File;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;


import com.GreatLearning.MainPackage.Reports.ExtentReport;

public class BaseDriver {

	public static long StartTime;
	public static long ElapsedTime;
	// static logger = ExtentReport.getTest();
//	private static final String CSVDATAENGINEPATH = "./src/test/resources/DataEngine.csv";

	public static WebDriver driver = null;

	@BeforeMethod
	public void Base() {

		try {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\satyasree\\eclipse-workspace\\GreatLearningAutomation\\src\\test\\Driver\\chromedriver.exe");

			// Instantiate a ChromeDriver class.
			driver = new ChromeDriver();

			// Launch Website
			driver.navigate().to("https://www.mygreatlearning.com/");

			// Maximize the browser
			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(2000);
			//driver.findElement(By.id("btn-download-brochure")).click();

		} catch (Exception e) {
			System.out.println("Cause is" + e.getCause());
			System.out.println("Message is" + e.getMessage());
			e.printStackTrace();
			e.getSuppressed();
		}

	}

	@AfterMethod
	public void endTest() {
		driver.close();
		ExtentReport.endTest();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}


// Works as per listener and takes screenshots when failed.
	public void failed(String TestName) {

		try {
			File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(srcfile, new File("C:\\Users\\satyasree\\Cognizant_Telstra\\src\\test\\Screenshots\\"
					+ TestName + "_" + "test_failure.jpg"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
