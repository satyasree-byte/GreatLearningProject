package com.GreatLearning.MainPackage.PageDrivers;

import java.io.IOException;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;


import com.GreatLearning.MainPackage.BaseDriver.BaseDriver;
import com.GreatLearning.MainPackage.Reports.ExtentReport;
import com.GreatLearning.MainPackage.Utilities.CSVReader;
import com.GreatLearning.MainPackage.Utilities.ObjectRepoReader;
import com.GreatLearning.MainPackage.WrapperLibraries.WrapperClassLibrary;
import com.aventstack.extentreports.Status;


public class GLHomePageDriver extends BaseDriver {
	
	WrapperClassLibrary lib = new WrapperClassLibrary();
	CSVReader GetData = new CSVReader();

	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public void VerifyHomePage(String testID) throws IOException {
		
		String HomePageTitleValue = GetData.getValue(testID, "HomePageTitleValue");
		
		String HomePageTitle = ObjectRepoReader.getObject("GL_HomePageTitle");
		lib.VerifyPresenceOfElementByID(HomePageTitle);
		String title = driver.getTitle();
		System.out.println(title);
		if((driver.findElements(By.id(HomePageTitle)).size() > 0) && (title.contains(HomePageTitleValue)))
		{
			ExtentReport.getTest().log(Status.PASS,
					"Great Learning Home page Verified successfully");
			System.out.println(
					"Great Learning Home page Verified successfully");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Great Learning Home page not Verified ");
			System.out.println("Great Learning Home page not Verified");
		}
		
	}

	public void SelectCloudComputingInExplorePrograms(String testID) throws IOException {
		
		String CloudComputingTextValue = GetData.getValue(testID, "CloudVisibleText");
		
		String ExplorePrograms = ObjectRepoReader.getObject("GL_ExplorePrograms");
		String CloudComputing = ObjectRepoReader.getObject("GL_CloudComputing");
		
		//mouse hover
		if (lib.MouseHover(ExplorePrograms)) {
			ExtentReport.getTest().log(Status.PASS,"Hover on Explore programs is successful");
			System.out.println("Hover on Explore programs is succesful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Hover on Explore programs failed ");
			System.out.println("Hover on Explore programs failed");
		}
		
		//Select Cloud Computing
		if (lib.SelectByXpath(testID,CloudComputing,CloudComputingTextValue)) {
			ExtentReport.getTest().log(Status.PASS,"Selection of Cloud computing is successful");
			System.out.println("Selection of Cloud computing is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Selection of Cloud computing failed ");
			System.out.println("Selection of Cloud computing failed");
		}
		
		
		
	}


	public void SelectPGProgram(String testID) throws IOException {
		
		String PGProgram = ObjectRepoReader.getObject("GL_PGProgram");
		
		if (lib.ClickByXpath(testID ,PGProgram)) {
			ExtentReport.getTest().log(Status.PASS,"Selection of Cloud computing is successful");
			System.out.println("Selection of Cloud computing is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Selection of Cloud computing failed ");
			System.out.println("Selection of Cloud computing failed");
		}
		
	}

}
