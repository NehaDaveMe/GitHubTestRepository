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
import GenericLibrary.RandomClass;
import ModulerLibrary.WPO_SelectContractorPkgAction;
import ObjectRepository.AddContractor_Pkg_Insurance_Enrollment_Page;
import ObjectRepository.AddContractor_Pkg_WC_Premiums_Modifications_Page;
import ObjectRepository.HomePage;
import ObjectRepository.ReportModule;
import ObjectRepository.Report_ContractorInsuranceCreditReport;
import ObjectRepository.Report_FinalDeduct;

public class Calculation_ContractorInsuranceCreditReportTest extends BaseClass {

	WebDriverCommonLib wb = new WebDriverCommonLib();
	List<WebElement> lst1;
	public String contractorName = "Alex Comp3524";
	public String projectName = "Sony Projects3524";
	String programName = "Sony Programs3524";// "Sony Tower One Prog";
	String contractorCompany = "Alex Comp3524";// "sony";
	String contactName = "Jimmy Smith";
	public String tradeNumber = RandomClass.randomTradeNO();
	public String contractorPKGno = "PC3524-P3524KIRAN45465697878";// RandomClass.randomContractorPkgNo();//"PC3524-P3524CONTRACTOR_PKG_NO50396";
	public String locationNo = "P3524kiran54654897";
	public String insuranceCompName = "Carriers3524";
	public String submissionFrequency = "Quarterly";
	public String reportTime = "Quarterly";
	public String tabName = "WC Premiums Modifications";
	String selectReportName = "Contractor Insurance Credit Report";
	
	
	@Test
	public void testContractorInsuranceCreditReport() throws InterruptedException {
		WPO_SelectContractorPkgAction.selectContractorpkg(contractorPKGno, tabName);

		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		driver.manage().window().maximize();
		// AddContractor_Pkg_Insurance_Enrollment_Page.InsuranceEnrollmentTab(driver).click();
		Thread.sleep(7000);
//		AddContractor_Pkg_Insurance_Enrollment_Page.enrollContractorPkgAllTab(driver, tabName).click();

		// Store wc values in list
		List<WebElement> listOfPremium = Report_ContractorInsuranceCreditReport.takeAllEstimatedValue(driver);
		ArrayList<Object> CPValues = new ArrayList<Object>();
		for (int i = 0; i < listOfPremium.size(); i++) {
			CPValues.add(listOfPremium.get(i).getAttribute("value").trim());
		}
		
		System.out.println(CPValues);

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
		AddContractor_Pkg_Insurance_Enrollment_Page.btnClose(driver));
		AddContractor_Pkg_Insurance_Enrollment_Page.btnClose(driver).click();
		Thread.sleep(4000);
		driver.switchTo().window(wb.map.get("parentID"));

		try {
			HomePage.controlMenuReports(driver).click();
			test.log(LogStatus.INFO, "Clicked on Report Module Icon");
			Thread.sleep(2000);
			wb.selectSingleValue(ReportModule.selectProgramDropdown(driver), programName);
			test.log(LogStatus.INFO, "Respective Program Select Form Dropdown");
			Thread.sleep(5000);
			Report_ContractorInsuranceCreditReport.selectReport(driver, selectReportName).click();
			test.log(LogStatus.PASS, selectReportName + " Report is Selected");
			wb.getWindowIDs();
			driver.switchTo().window(wb.map.get("childID"));

			Report_ContractorInsuranceCreditReport.filterSelectProjectFormOption(driver, projectName).click();
			test.log(LogStatus.PASS, " Project Selected Successfully");

			wb.selectSingleValue(Report_ContractorInsuranceCreditReport.filterSelectContractorFormOption(driver),
					"All Contractors");
			test.log(LogStatus.PASS, " Contractor Selected Successfully");

			Report_ContractorInsuranceCreditReport.btnBuildReport(driver).click();
			test.log(LogStatus.INFO, " Clicked On Build Report Button");
			Thread.sleep(3000);

		} catch (Throwable e) {
			test.log(LogStatus.FAIL, e + " Something Went Wrong");
		}
		// String reportName=ReportModule.reportHeaderReportName(driver,
		// "Contractor Enrollment Summary").getText();

		try {
			System.out.println(Report_ContractorInsuranceCreditReport.reportHeaderReportName(driver).getText());
			Assert.assertEquals(Report_ContractorInsuranceCreditReport.reportHeaderReportName(driver).getText(),
					"Contractor Insurance Credit Report");
			System.out.println("Report Name is Matched");
			test.log(LogStatus.PASS, "Report Header Name Matched");
			test.log(LogStatus.PASS, "Report Generated Successfully");
		} catch (Throwable e) {
			System.out.println("report name not matched");
			test.log(LogStatus.FAIL, e + "Report Header Name Not Matched");
		}

		js.executeScript("arguments[0].scrollIntoView();",
				Report_ContractorInsuranceCreditReport.selectContractorPkgID(driver, locationNo));
		System.out.println(Report_ContractorInsuranceCreditReport.selectContractorPkgID(driver, locationNo).getText());

		List<WebElement> lst1 = Report_ContractorInsuranceCreditReport.selectWCModifiersValue(driver, locationNo);
		System.out.println("list of the wc " + lst1.size());

		ArrayList<Object> reportValues = new ArrayList<Object>();
		for (int i = 0; i < lst1.size(); i++) {
			reportValues.add(lst1.get(i).getText());
		}

		System.out.println(reportValues);

		System.out.println(CPValues.equals(reportValues));
		driver.close();
		driver.switchTo().window(wb.map.get("parentID"));

	}
}
