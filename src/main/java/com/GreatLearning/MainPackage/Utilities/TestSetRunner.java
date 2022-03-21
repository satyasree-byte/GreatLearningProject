package com.GreatLearning.MainPackage.Utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RegExUtils;
import org.apache.log4j.Logger;
import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;


public class TestSetRunner {

	static Logger logger = Logger.getLogger(TestSetRunner.class);

	@BeforeSuite
	public static void main(String[]ar) {
		String platform;

		String testSetPath = "C:\\Users\\satyasree\\Downloads\\MiCredit_Automation\\src\\test\\resources\\DataEngineNew.xlsx";
		
		System.out.println(testSetPath);
		TestNG myTestNG = new TestNG();
		String suite = "";
		String test = "";
		String tcls = null;
		try {
			
			File file = new File(testSetPath);
			List<Map> rows = ExcelReader.read("DataEngineNew.xlsx", "DataEngine");			
			System.out.println("Rows are::"+rows);
			
			XmlSuite mySuite = new XmlSuite();
			 mySuite.setName(suite);				 
			 List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
			 List<XmlTest> myTests = new ArrayList<XmlTest>();
			 Map<String,String> testngParams = new HashMap<String,String> ();
			 XmlTest myTest = new XmlTest(mySuite);
			 myTest.setName(test);

			 		List<XmlClass> myClasses = new ArrayList<XmlClass> ();
			 		List<XmlInclude> xmlInclude=new ArrayList<XmlInclude> ();
					 for(Map map:rows)
					 {
						 
						 if((map.containsKey("TestClass") && 
								 map.containsKey("TestCaseName") && 
								 	map.get("RunMode").toString().equals("Yes")))
								 {
							// String Class = "com.App.MICredit_AutomationTestSuite.GEN_CreditReportSuite";
							 XmlClass cls = new XmlClass(map.get("TestClass").toString());
							// System.out.println(map.get("TestClass").toString());				
							 myClasses.add(cls);
							 		xmlInclude.add(new XmlInclude(map.get("TestCaseName").toString()));
							 		System.out.println(map.get("TestCaseName").toString());
							 		cls.setIncludedMethods(xmlInclude);							 		
								 }
					 }	
					 myTest.setXmlClasses(myClasses);					 
					 myTests.add(myTest);
					 mySuite.setTests(myTests);
					 mySuites.add(mySuite);
					 myTestNG.setXmlSuites(mySuites);
					 myTestNG.run();
					 
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: TestSuite: " + suite + "- Class not found..!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			System.out.println("ERROR: Problem while reading test set"
					+ "..!!" + e.getMessage());
		}
		
	}
}
