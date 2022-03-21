package com.GreatLearning.TestSuite;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.GreatLearning.MainPackage.BaseDriver.BaseDriver;
import com.GreatLearning.MainPackage.PageDrivers.GLCloudComputingPageDriver;
import com.GreatLearning.MainPackage.PageDrivers.GLCourseRegistrationPageDriver;
import com.GreatLearning.MainPackage.PageDrivers.GLHomePageDriver;
import com.GreatLearning.MainPackage.Reports.ExtentReport;
import com.GreatLearning.MainPackage.Reports.TestListener;
import com.aventstack.extentreports.ExtentTest;

@Listeners(TestListener.class)
public class HappyFlowAutomationTestSuite extends BaseDriver{
	
	GLHomePageDriver G_Home = new GLHomePageDriver();
	GLCloudComputingPageDriver G_Cloud = new GLCloudComputingPageDriver();
	GLCourseRegistrationPageDriver G_Reg = new GLCourseRegistrationPageDriver();
	
	@Test(enabled = true)
	public void ATC_001_GreatLearningHappyFlow() throws Exception {
		 String TestID = new Object() {} 
         .getClass() 
         .getEnclosingMethod() 
         .getName(); 
         
        ExtentTest logger = ExtentReport.startTest(TestID,"To Run through the Happy flow of Applying to a course in Great learning");
        System.out.println(TestID);
        
        G_Home.VerifyHomePage(TestID);
        G_Home.SelectCloudComputingInExplorePrograms(TestID);
//        G_Home.VerifyOptionsInCloudComputing(TestID);
//        G_Home.VerifyTypeAndDurationOfCourse(TestID);
        G_Home.SelectPGProgram(TestID);
        
        
        G_Cloud.VerifyPageCloudComputing(TestID);
        G_Cloud.ApplyForThecourse(TestID);
        
        
        G_Reg.VerifyRegistrationForm(TestID);
        G_Reg.VerifyBasicInfoTitle(TestID);
        G_Reg.EnterBasicInformation(TestID);
        G_Reg.VerifyTermsAndPoliciesAndProceed(TestID);
        
        G_Reg.VerifyProfessionInfoTitle(TestID);
        G_Reg.EnterProfessionDetailsAndProceed(TestID);
        
        G_Reg.VerifyEducationInfoTitle(TestID);
        G_Reg.EnterEducationDetailsAndProceed(TestID);
        
        G_Reg.EnterLinkedDetails(TestID);
        G_Reg.EnterStatementOfPurposeAndSubmit(TestID);
        G_Reg.SelectTerms(TestID);
        G_Reg.SubmitApplication(TestID);
        
        G_Reg.ValidateApplication(TestID);
        G_Reg.EnterEmailAndPasswordAndSignUp(TestID);
        
        G_Reg.VerifyMyApplications(TestID);
        ExtentReport.endTest();
   
		
		
	}
	

}
