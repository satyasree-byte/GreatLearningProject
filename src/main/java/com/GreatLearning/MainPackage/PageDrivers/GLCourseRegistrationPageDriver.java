package com.GreatLearning.MainPackage.PageDrivers;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.GreatLearning.MainPackage.BaseDriver.BaseDriver;
import com.GreatLearning.MainPackage.Reports.ExtentReport;
import com.GreatLearning.MainPackage.Utilities.CSVReader;
import com.GreatLearning.MainPackage.Utilities.ObjectRepoReader;
import com.GreatLearning.MainPackage.WrapperLibraries.WrapperClassLibrary;
import com.aventstack.extentreports.Status;

public class GLCourseRegistrationPageDriver extends BaseDriver {

	WrapperClassLibrary lib = new WrapperClassLibrary();
	CSVReader GetData = new CSVReader();
	
	public void VerifyRegistrationForm(String testID) throws IOException {
			
			String RegistrationPageTitleValue = GetData.getValue(testID, "RegistrationPageTitleValue");
		
			String RegistrationPageTitle = ObjectRepoReader.getObject("GL_RegistrationPageTitle");
			lib.VerifyPresenceOfElementByXpath(RegistrationPageTitle);
			String title = driver.getTitle();
			System.out.println(title);
			if((driver.findElements(By.xpath(RegistrationPageTitle)).size() > 0) && (title.contains(RegistrationPageTitleValue)))
			{
				ExtentReport.getTest().log(Status.PASS, "Great Learning Registration page Verified successfully");
				System.out.println(	"Great Learning Registration page Verified successfully");
			} else {
				ExtentReport.getTest().log(Status.FAIL, "Great Learning Registration page not Verified ");
				System.out.println("Great Learning Registration page not Verified");
			}
			
		
	}

	public void VerifyBasicInfoTitle(String testID) throws IOException {
		
		String BasicInfoTitleValue = GetData.getValue(testID, "BasicInfoTitleValue");
		
		String BasicInfoTitle = ObjectRepoReader.getObject("GL_BasicInfoTitle");
		lib.VerifyPresenceOfElementByXpath(BasicInfoTitle);
		String title = driver.getTitle();
		System.out.println(title);
		if((driver.findElements(By.xpath(BasicInfoTitle)).size() > 0) && (title.contains(BasicInfoTitleValue)))
		{
			ExtentReport.getTest().log(Status.PASS, "Great Learning BasicInfoTitle Verified successfully");
			System.out.println(	"Great Learning BasicInfoTitle Verified successfully");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Great Learning BasicInfoTitle not Verified ");
			System.out.println("Great Learning BasicInfoTitle not Verified");
		}
		
	}

	public void EnterBasicInformation(String testID) throws IOException {
		
		String NameValue = GetData.getValue(testID, "Name");
		String MobileNumValue = GetData.getValue(testID, "MobileNum");
		String EmailValue = GetData.getValue(testID, "Email");
		String CityValue = GetData.getValue(testID, "City");
		String WorkExpValue = GetData.getValue(testID, "WorkExp");
		
		
		String Name = ObjectRepoReader.getObject("GL_Name");
		String MobileNum =  ObjectRepoReader.getObject("GL_MobileNum");
		String Email =  ObjectRepoReader.getObject("GL_Email");
		String City =  ObjectRepoReader.getObject("GL_City");
		String WorkExp =  ObjectRepoReader.getObject("GL_WorkExp");
		
		
		if (lib.EnterText(testID,Name,NameValue)) {
			ExtentReport.getTest().log(Status.PASS,"Enter Name in Basic Info is successful");
			System.out.println("Enter Name in Basic Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Enter Name in Basic Info failed ");
			System.out.println("Enter Name in Basic Info failed");
		}
			
		if (lib.EnterText(testID,MobileNum,MobileNumValue)) {
			ExtentReport.getTest().log(Status.PASS,"Enter Mobile Number in Basic Info is successful");
			System.out.println("Enter Mobile Number in Basic Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Enter Mobile Number in Basic Info failed ");
			System.out.println("Enter Mobile Number in Basic Info failed");
		}
		
		
		if (lib.EnterText(testID,Email,EmailValue)) {
			ExtentReport.getTest().log(Status.PASS,"Enter Email in Basic Info is successful");
			System.out.println("Enter Mobile Number in Basic Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Enter Email in Basic Info failed ");
			System.out.println("Enter Email in Basic Info failed");
		}
		
		if (lib.EnterTextAndSelect(testID,City,CityValue)) {
			ExtentReport.getTest().log(Status.PASS,"Enter City in Basic Info is successful");
			System.out.println("Enter City in Basic Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Enter City in Basic Info failed ");
			System.out.println("Enter City in Basic Info failed");
		}
		
		if (lib.SelectByID(testID,WorkExp,WorkExpValue)) {
			ExtentReport.getTest().log(Status.PASS,"Enter WorkExp in Basic Info is successful");
			System.out.println("Enter WorkExp in Basic Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Enter WorkExp in Basic Info failed ");
			System.out.println("Enter WorkExp in Basic Info failed");
		}
		
		
	}

	public void VerifyTermsAndPoliciesAndProceed(String testID) throws IOException {
		
		String Terms = ObjectRepoReader.getObject("GL_Terms");
		String Next = ObjectRepoReader.getObject("GL_Next");
		
		if (lib.ClickByXpath(testID,Terms)) {
			ExtentReport.getTest().log(Status.PASS,"Enter Email in Basic Info is successful");
			System.out.println("Enter Mobile Number in Basic Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Enter Email in Basic Info failed ");
			System.out.println("Enter Email in Basic Info failed");
		}
		String parent = driver.getWindowHandle();
		driver.switchTo().window(parent);
		if (lib.ClickByXpath(testID,Next)) {
			ExtentReport.getTest().log(Status.PASS,"Clicked on next button");
			System.out.println("Clicked on next button");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Click on next button failed ");
			System.out.println("Click on next button failed");
		}
	}

	public void VerifyProfessionInfoTitle(String testID) throws IOException {
		
		String ProfessionInfoTitleValue = GetData.getValue(testID, "ProfessionInfoTitleValue");
		
		String ProfessionInfoTitle = ObjectRepoReader.getObject("GL_ProfessionInfoTitle");
		lib.VerifyPresenceOfElementByXpath(ProfessionInfoTitle);
		String title = driver.getTitle();
		System.out.println(title);
		if((driver.findElements(By.xpath(ProfessionInfoTitle)).size() > 0) && (title.contains(ProfessionInfoTitleValue)))
		{
			ExtentReport.getTest().log(Status.PASS, "Great Learning ProfessionInfoTitle Verified successfully");
			System.out.println(	"Great Learning ProfessionInfoTitle Verified successfully");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Great Learning ProfessionInfoTitle not Verified ");
			System.out.println("Great Learning ProfessionInfoTitle not Verified");
		}
		
	}

	public void EnterProfessionDetailsAndProceed(String testID) throws IOException {
		
		String OrgValue = GetData.getValue(testID, "OrgValue");
		String FromMonthValue = GetData.getValue(testID, "FromMonth");
		String FromYearValue = GetData.getValue(testID, "FromYear");
		String JobTitleValue = GetData.getValue(testID, "JobTitleVlaue");
		String industryValue  = GetData.getValue(testID, "industryValue");
		String ProgramExpValue  = GetData.getValue(testID, "ProgramExpValue");
		String Programlangs =  GetData.getValue(testID, "Programlangs");
		
		
		
		String Organization = ObjectRepoReader.getObject("GL_Organization");
		String CheckBox =  ObjectRepoReader.getObject("GL_ChkCurrWorkHere");
		String FromMonth =  ObjectRepoReader.getObject("GL_FromMonth");
		String FromYear =  ObjectRepoReader.getObject("GL_FromYear");
		String JobTitle =  ObjectRepoReader.getObject("GL_JobTitle");
		String Industry =  ObjectRepoReader.getObject("GL_Industry");
		String ProgramExp  = ObjectRepoReader.getObject("GL_ProgramExp");
		String Next = ObjectRepoReader.getObject("GL_Next");
		String Java = ObjectRepoReader.getObject("GL_Java");
		
		
		if (lib.EnterText(testID,Organization,OrgValue)) {
			ExtentReport.getTest().log(Status.PASS,"Entry of Organization name in Professional Info is successful");
			System.out.println("Entry of Organization name in Professional Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Entry of Organization name in Professional Infofailed ");
			System.out.println("Entry of Organization name in Professional Info is failed");
		}
		
		if (lib.ClickByID(testID,CheckBox)) {
			ExtentReport.getTest().log(Status.PASS,"Clicked on CheckBox currently here");
			System.out.println("Clicked on CheckBox currently here");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Click on CheckBox currently here failed ");
			System.out.println("Click on CheckBox currently here failed");
		}
		
		if (lib.SelectByID(testID,FromMonth,FromMonthValue)) {
			ExtentReport.getTest().log(Status.PASS,"Selection of FromMonth in Professional Info is successful");
			System.out.println("Selection of FromMonth in Professional Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Selection of FromMonth in Professional Info failed ");
			System.out.println("Selection of FromMonth in Professional Info failed");
		}
		
		if (lib.SelectByID(testID,FromYear,FromYearValue.trim())) {
			ExtentReport.getTest().log(Status.PASS,"Selection of FromYear in Professional Info is successful");
			System.out.println("Selection of FromYear in Professional Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Selection of FromYear in Professional Info failed ");
			System.out.println("Selection of FromYear in Professional Info failed");
		}
		
		if (lib.EnterText(testID,JobTitle,JobTitleValue)) {
			ExtentReport.getTest().log(Status.PASS,"Entry of JobTitle in Professional Info is successful");
			System.out.println("Entry of JobTitle in Professional Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Entry of JobTitle in Professional Info failed ");
			System.out.println("Entry of JobTitle in Professional Info is failed");
		}
		
		if (lib.SelectByID(testID,Industry,industryValue)) {
			ExtentReport.getTest().log(Status.PASS,"Selection of Industry in Professional Info is successful");
			System.out.println("Selection of Industry in Professional Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Selection of Industry in Professional Info failed ");
			System.out.println("Selection of Industry in Professional Info failed");
		}
		
		if (lib.SelectByID(testID,ProgramExp,ProgramExpValue)) {
			ExtentReport.getTest().log(Status.PASS,"Selection of ProgramExp in Professional Info is successful");
			System.out.println("Selection of ProgramExp in Professional Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Selection of ProgramExp in Professional Info failed ");
			System.out.println("Selection of ProgramExp in Professional Info failed");
		}
		
		if (lib.ClickByXpath(testID,Java)) {
			ExtentReport.getTest().log(Status.PASS,"Selection of Programlanguages in Professional Info is successful");
			System.out.println("Selection of Programlanguages in Professional Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Selection of Programlanguages in Professional Info failed ");
			System.out.println("Selection of Programlanguages in Professional Info failed");
		}
		
		
		if (lib.ClickByXpath(testID,Next)) {
			ExtentReport.getTest().log(Status.PASS,"Clicked on next button");
			System.out.println("Clicked on next button");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Click on next button failed ");
			System.out.println("Click on next button failed");
		}
	}

	public void VerifyEducationInfoTitle(String testID) throws IOException {
		
		String EducationInfoTitleValue = GetData.getValue(testID, "EducationInfoTitleValue");
		
		String EducationInfoTitle = ObjectRepoReader.getObject("GL_EducationInfoTitle");
		lib.VerifyPresenceOfElementByXpath(EducationInfoTitle);
		String title = driver.getTitle();
		System.out.println(title);
		if((driver.findElements(By.xpath(EducationInfoTitle)).size() > 0) && (title.contains(EducationInfoTitleValue)))
		{
			ExtentReport.getTest().log(Status.PASS, "Great Learning EducationInfoTitle Verified successfully");
			System.out.println(	"Great Learning EducationInfoTitle Verified successfully");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Great Learning EducationInfoTitle not Verified ");
			System.out.println("Great Learning EducationInfoTitle not Verified");
		}
		
	}

	public void EnterEducationDetailsAndProceed(String testID) throws IOException, InterruptedException {
		
		String DegreeValue = GetData.getValue(testID, "DegreeValue");
		String SpecializationValue = GetData.getValue(testID, "SpecializationValue");
		String CollegeValue = GetData.getValue(testID, "CollegeValue");
		String GradYearValue = GetData.getValue(testID, "GradYearValue");
		String CGPAValue  = GetData.getValue(testID, "CGPAValue");
	
		
		String Degree = ObjectRepoReader.getObject("GL_Degree");
		String Specialization =  ObjectRepoReader.getObject("GL_Specialization");
		String College =  ObjectRepoReader.getObject("GL_College");
		String GradYear =  ObjectRepoReader.getObject("GL_GradYear");
		String CGPA =  ObjectRepoReader.getObject("GL_CGPA");
		String Next = ObjectRepoReader.getObject("GL_Next2");
		
		
		if (lib.SelectByID(testID,Degree,DegreeValue)) {
			ExtentReport.getTest().log(Status.PASS,"Selection of Degree in Educational Info is successful");
			System.out.println("Selection of Degree in Educational Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Selection of Degree in Educational Info failed ");
			System.out.println("Selection of Degree in Educational Info failed");
		}
		
		if (lib.EnterText(testID,Specialization,SpecializationValue)) {
			ExtentReport.getTest().log(Status.PASS,"Entry of Specialization in Educational Info is successful");
			System.out.println("Entry of Specialization in Educational Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Entry of Educational in Professional Info failed ");
			System.out.println("Entry of Specialization in Educational Info is failed");
		}
		
		if (lib.EnterText(testID,College,CollegeValue)) {
			ExtentReport.getTest().log(Status.PASS,"Entry of College in Educational Info is successful");
			System.out.println("Entry of College in Educational Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Entry of College in Professional Info failed ");
			System.out.println("Entry of College in Educational Info is failed");
		}
		
		if (lib.SelectByID(testID,GradYear,GradYearValue)) {
			ExtentReport.getTest().log(Status.PASS,"Selection of GradYear in Educational Info is successful");
			System.out.println("Selection of GradYear in Educational Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Selection of GradYear in Educational Info failed ");
			System.out.println("Selection of GradYear in Educational Info failed");
		}
		
		if (lib.EnterText(testID,CGPA,CGPAValue)) {
			ExtentReport.getTest().log(Status.PASS,"Entry of CGPA in Educational Info is successful");
			System.out.println("Entry of CGPA in Educational Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Entry of CGPA in Professional Info failed ");
			System.out.println("Entry of CGPA in Educational Info is failed");
			
		}
		WebElement element = driver.findElement(By.id("prof_details_end"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
		
		if (lib.ClickByID(testID,Next)) {
			ExtentReport.getTest().log(Status.PASS,"Clicked on next button");
			System.out.println("Clicked on next button");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Click on next button failed ");
			System.out.println("Click on next button failed");
		}
		
	}

	public void EnterLinkedDetails(String testID) throws IOException {
		
		String LinkedInURLValue = GetData.getValue(testID, "LinkedInURL");
		
		String LinkedInURL = ObjectRepoReader.getObject("GL_LinkedInURL");
		String Next = ObjectRepoReader.getObject("GL_Next3");
		
		if (lib.EnterText(testID,LinkedInURL,LinkedInURLValue)) {
			ExtentReport.getTest().log(Status.PASS,"Entry of LinkedInURL in Educational Info is successful");
			System.out.println("Entry of LinkedInURL in Educational Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Entry of LinkedInURL in Professional Info failed ");
			System.out.println("Entry of LinkedInURL in Educational Info is failed");
		}
		
		if (lib.ClickByID(testID,Next)) {
			ExtentReport.getTest().log(Status.PASS,"Clicked on next button");
			System.out.println("Clicked on next button");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Click on next button failed ");
			System.out.println("Click on next button failed");
		}
	}

	public void UploadResume(String testID) throws IOException {
		
		String PathValue = GetData.getValue(testID, "PathValue");
		
		String Upload = ObjectRepoReader.getObject("GL_Upload");
		
		lib.ClickByID(testID, Upload);
		if (lib.EnterText(testID,Upload,PathValue)) {
			ExtentReport.getTest().log(Status.PASS,"Entry of Upload in Educational Info is successful");
			System.out.println("Entry of Upload in Educational Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Entry of LinkedInURL in Professional Info failed ");
			System.out.println("Entry of Upload in Educational Info is failed");
		}
		
	}

	public void EnterStatementOfPurposeAndSubmit(String testID) throws IOException {

		String StatPurposeValue = GetData.getValue(testID, "StatPurposeValue");
		
		String StatPurpose = ObjectRepoReader.getObject("GL_Purpose");
		
		if (lib.EnterText(testID,StatPurpose,StatPurposeValue)) {
			ExtentReport.getTest().log(Status.PASS,"Entry of StatPurpose in Educational Info is successful");
			System.out.println("Entry of StatPurpose in Educational Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Entry of StatPurpose in Professional Info failed ");
			System.out.println("Entry of StatPurpose in Educational Info is failed");
		}
		
	}

	public void SelectTerms(String testID) throws IOException {
	
		String Terms = ObjectRepoReader.getObject("GL_FinalTerms");
		
		if (lib.ClickByXpath(testID,Terms)) {
			ExtentReport.getTest().log(Status.PASS,"Click Terms in successful");
			System.out.println("Click Terms in successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Click Terms is failed ");
			System.out.println("Click Terms in successful is failed");
		}
		
		
	}

	public void SubmitApplication(String testID) throws IOException {
		
		String Submit = ObjectRepoReader.getObject("GL_Submit");
		
		if (lib.ClickByID(testID ,Submit)) {
			ExtentReport.getTest().log(Status.PASS,"Click on Submit button is successful");
			System.out.println("Click on Submit button is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Click on Submit button failed ");
			System.out.println("Click on Submit button failed");
		}
		
		
	}

	public void ValidateApplication(String testID) throws IOException {
		
		String AppSuccessText = ObjectRepoReader.getObject("GL_AppSuccessText");

		if (driver.findElement(By.xpath(AppSuccessText)).getText().equals("Application submitted successfully")) {
			ExtentReport.getTest().log(Status.PASS, "Great Learning Registration successful");
			System.out.println(	"Great Learning Registration successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Great Learning Registration failed");
			System.out.println("Great Learning Registration failed");
		}
		
		
	}

	public void EnterEmailAndPasswordAndSignUp(String testID) throws IOException {
		
		String PassowrdValue = GetData.getValue(testID, "PassowrdValue");
		
		String Passowrd = ObjectRepoReader.getObject("GL_Password");
		String SignUp = ObjectRepoReader.getObject("GL_SignUp");
		
		if (lib.EnterText(testID,Passowrd,PassowrdValue)) {
			ExtentReport.getTest().log(Status.PASS,"Entry of Passowrd in Educational Info is successful");
			System.out.println("Entry of Passowrd in Educational Info is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Entry of Passowrd in Professional Info failed ");
			System.out.println("Entry of Passowrd in Educational Info is failed");
		}
		
		if (lib.ClickByID(testID ,SignUp)) {
			ExtentReport.getTest().log(Status.PASS,"Click on SignUp button is successful");
			System.out.println("Click on SignUp button is successful");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Click on SignUp button failed ");
			System.out.println("Click on SignUp button failed");
		}
	}

	public void VerifyMyApplications(String testID) throws IOException {
		
		String MyApplicationsPageTitleValue = GetData.getValue(testID, "MyApplicationsPageTitleValue");
		
		String MyApplicationsPageTitle = ObjectRepoReader.getObject("GL_MyApplicationsPageTitle");
		lib.VerifyPresenceOfElementByXpath(MyApplicationsPageTitle);
		String title = driver.getTitle();
		System.out.println(title);
		if((driver.findElements(By.xpath(MyApplicationsPageTitle)).size() > 0) && (title.contains(MyApplicationsPageTitleValue)))
		{
			ExtentReport.getTest().log(Status.PASS, "Great Learning MyApplications page Verified successfully");
			System.out.println(	"Great Learning MyApplications page Verified successfully");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "Great Learning MyApplications page not Verified ");
			System.out.println("Great Learning MyApplications page not Verified");
		}
		ExtentReport.getTest().log(Status.PASS, "Great Learning Sign Up Completed and Test Passed successfully ");
		System.out.println("Great Learning Sign Up Completed and Test Passed successfully");
	}

}
