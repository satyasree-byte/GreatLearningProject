package com.GreatLearning.MainPackage.PageDrivers;

import java.io.IOException;

import org.openqa.selenium.By;

import com.GreatLearning.MainPackage.BaseDriver.BaseDriver;
import com.GreatLearning.MainPackage.Reports.ExtentReport;
import com.GreatLearning.MainPackage.Utilities.CSVReader;
import com.GreatLearning.MainPackage.Utilities.ObjectRepoReader;
import com.GreatLearning.MainPackage.WrapperLibraries.WrapperClassLibrary;
import com.aventstack.extentreports.Status;

public class GLCloudComputingPageDriver extends BaseDriver {

	WrapperClassLibrary lib = new WrapperClassLibrary();
	CSVReader GetData = new CSVReader();

	public void VerifyPageCloudComputing(String testID) throws IOException {
		String CloudCompPageTitleValue = GetData.getValue(testID, "CloudCompPageTitle");
		
		String CloudCompPageTitle = ObjectRepoReader.getObject("GL_CloudComputingPageTitle");
		lib.VerifyPresenceOfElementByXpath(CloudCompPageTitle);
		String title = driver.getTitle();
		System.out.println(title);
		if((driver.findElements(By.xpath(CloudCompPageTitle)).size() > 0) && (title.contains(CloudCompPageTitleValue)))
		{
			ExtentReport.getTest().log(Status.PASS,
					"Great Learning CloudComputing page Verified successfully");
			System.out.println(
					"Great Learning CloudComputing page Verified successfully");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Great Learning CloudComputing page not Verified ");
			System.out.println("Great Learning CloudComputing page not Verified");
		}
		
	}

	public void ApplyForThecourse(String testID) throws IOException {

		String ApplyNow = ObjectRepoReader.getObject("GL_ApplyNow");
		
		if (lib.ClickByXpath(testID ,ApplyNow)) {
			ExtentReport.getTest().log(Status.PASS,"Click on APply now button is successful");
			System.out.println("Click on APply now button is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Click on Apply now button failed ");
			System.out.println("Click on Apply now button failed");
		}
		
		
	}
		

}
