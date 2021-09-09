package TestScript;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.FileUtils1;
import GenericLibrary.RandomClass;
import ModulerLibrary.WPO_LoginActionClientWise;
import ModulerLibrary.WPO_SelectContractorPkgAction;
import ObjectRepository.AddContractor_Pkg_Insurance_Enrollment_Page;
import ObjectRepository.AddContractor_Pkg_WC_Premiums_Modifications_Page;
import ObjectRepository.HomePage;
import ObjectRepository.ReportModule;
import ObjectRepository.Report_FinalDeduct;
import ObjectRepository.Report_ProgramCloseoutSummary;

public class Calculation_ProgramCloseoutSummaryTest extends BaseClass
{
	
	WebDriverCommonLib wb = new WebDriverCommonLib();
	List<WebElement> lst1;
	public String contractorName = "Alex Comp3524";
	public String projectName = "Sony Projects3524";
	String programName = "Sony Programs3524";// "Sony Tower One Prog";
	String contractorCompany = "Alex Comp3524";// "sony";
	String contactName = "Jimmy Smith";
	public String tradeNumber = RandomClass.randomTradeNO();
	public String contractorPKGno = "PC3524-P3524CONTRACTOR_PKG_NO43235";//RandomClass.randomContractorPkgNo();//"PC3524-P3524CONTRACTOR_PKG_NO50396";
	public String insuranceCompName = "Carriers3524";
	public String submissionFrequency = "Quarterly";
	public String reportTime = "Quarterly";
	public String tabName = "Insurance Enrollment";
	String selectReportName = "Program Closeout Summary";
	
	String project1 = "120 Piedmont Student Housing";
	String project2 = "712 West Peachtree";
	
	//report displays only missing payroll cp's
	@Test
	public void testProgramCloseoutSummary()
			throws InterruptedException {
		WPO_SelectContractorPkgAction.selectContractorpkg(contractorPKGno, tabName);
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		driver.manage().window().maximize();
		// AddContractor_Pkg_Insurance_Enrollment_Page.InsuranceEnrollmentTab(driver).click();
		Thread.sleep(7000);
	//	AddContractor_Pkg_Insurance_Enrollment_Page.enrollContractorPkgAllTab(driver, tabName).click();
	
		// Store wc values in list
		List<WebElement> listOfPremium = Report_ProgramCloseoutSummary.takeAllEstimatedValue(driver);
		 ArrayList<Object> CPValues = new ArrayList<Object>();
			for (int i = 0; i < listOfPremium.size(); i++) 
			{
				CPValues.add(listOfPremium.get(i).getAttribute("value").trim());
			}
			System.out.println(CPValues);
				
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",AddContractor_Pkg_Insurance_Enrollment_Page.btnClose(driver));
		AddContractor_Pkg_Insurance_Enrollment_Page.btnClose(driver).click();
		Thread.sleep(4000);
		driver.switchTo().window(wb.map.get("parentID"));
		
		try {
			HomePage.controlMenuReports(driver).click();
			test.log(LogStatus.INFO, "Clicked on Report Module Icon");
			Thread.sleep(2000);
			wb.selectSingleValue(ReportModule.selectProgramDropdown(driver), programName);
			test.log(LogStatus.INFO, programName + " Program Select Form Dropdown");
			Thread.sleep(5000);

			wb.selectSingleValueFromList(Report_ProgramCloseoutSummary.allReportList(driver), selectReportName);
			// Report_ProgramCloseoutSummary.selectReport(driver,
			// selectReportName).click();
			test.log(LogStatus.PASS, selectReportName + " Report is Selected");
			wb.getWindowIDs();
			driver.switchTo().window(wb.map.get("childID"));
//			wb.selectSingleValue(Report_ProgramCloseoutSummary.filterSelectDivisionDropdown(driver), Division);
//			test.log(LogStatus.PASS, Division + " Selected Successfully");
			
			Report_ProgramCloseoutSummary.filterSelectProjectFormOption(driver, projectName).click();
			test.log(LogStatus.PASS, programName + " Project Selected Successfully");

			Report_ProgramCloseoutSummary.btnBuildReport(driver).click();
			test.log(LogStatus.INFO, " Clicked On Build Report Button");
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Report Generated " + test.addScreenCapture(FileUtils1.getScreenshot(driver)));

		} catch (Throwable e) {
			test.log(LogStatus.FAIL, e + " Something Went Wrong");
			System.out.println(e);
			test.log(LogStatus.PASS, "Something Went Wrong" + test.addScreenCapture(FileUtils1.getScreenshot(driver)));
		}

		try {

			System.out.println(Report_ProgramCloseoutSummary.reportHeaderReportName(driver).getText());
			Assert.assertEquals(Report_ProgramCloseoutSummary.reportHeaderReportName(driver).getText(),
					"Closeout Summary");
			System.out.println("Report Name is Matched");
			test.log(LogStatus.PASS, "Report Header Name Matched");
			test.log(LogStatus.PASS, "Report Generated Successfully");
		} catch (Throwable e) {
			System.out.println("report name not matched");
			test.log(LogStatus.FAIL, e + "Report Header Name Not Matched");
		}
		
		js.executeScript("arguments[0].scrollIntoView();",Report_ProgramCloseoutSummary.selectContractorPkgID(driver, contractorPKGno));
		System.out.println(Report_ProgramCloseoutSummary.selectContractorPkgID(driver, contractorPKGno).getText());

		List<WebElement> lst1 = Report_ProgramCloseoutSummary.selectWCModifiersValue(driver, contractorPKGno);
		System.out.println("list of the wc "+lst1.size());

	
		 ArrayList<Object> reportValues = new ArrayList<Object>();
		for (int i = 0; i < lst1.size(); i++) 
		{
			reportValues.add(lst1.get(i).getText());
		}
		
		System.out.println(reportValues);
		
		
		System.out.println(CPValues.equals(reportValues));
		driver.close();
		driver.switchTo().window(wb.map.get("parentID"));


	}
}
