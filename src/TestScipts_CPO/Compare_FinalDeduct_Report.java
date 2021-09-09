package TestScipts_CPO;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import ModulerLibrary.CPO_LogInAction;
import ObjectRepository.HomePage;
import ObjectRepository.ReportModule;
import ObjectRepository.Report_FinalDeduct;
import ObjectRepository_CPO.CPO_HomePage;
import ObjectRepository_CPO.CPO_ReportsModule;
import ObjectRepository_CPO.Report_CPO_FinalDeduct;

public class Compare_FinalDeduct_Report extends BaseClass {
	WebDriverCommonLib wb = new WebDriverCommonLib();

	@Test
	public void compareFinalDeductReport() throws Throwable {
		String ProgramName = "Program7852";
		String ProjectName = "Sony Project9832";
		String reportName = "Final Deduct";
		// String divisionName="";

		try {
			HomePage.controlMenuReports(driver).click();
			test.log(LogStatus.INFO, "Clicked on Report Module Icon");
			Thread.sleep(2000);
			wb.selectSingleValue(ReportModule.selectProgramDropdown(driver), ProgramName);
			test.log(LogStatus.INFO, ProgramName + " Program Select Form Dropdown");
			Thread.sleep(5000);
			Report_FinalDeduct.selectReport(driver, reportName).click();
			test.log(LogStatus.PASS, reportName + " Report is Selected");
			wb.getWindowIDs();
			driver.switchTo().window(wb.map.get("childID"));
			// wb.selectSingleValue(Report_FinalDeduct.filterSelectDivisionDropdown(driver),
			// Division);
			// test.log(LogStatus.PASS, Division+" Selected Successfully");

			Report_FinalDeduct.filterSelectProjectFormOption(driver, ProjectName).click();
			test.log(LogStatus.PASS, ProjectName + " Project Selected Successfully");

			// Report_FinalDeduct.filterSelectContractorFormOption(driver).click();
			// test.log(LogStatus.PASS, " Contractor Selected Successfully");
			Report_FinalDeduct.btnBuildReport(driver).click();
			test.log(LogStatus.INFO, " Clicked On Build Report Button");
			Thread.sleep(3000);

		} catch (Throwable e) {
			test.log(LogStatus.FAIL, e + " Something Went Wrong");
		}
		// String reportName=ReportModule.reportHeaderReportName(driver,
		// "Contractor Enrollment Summary").getText();

		try {
			System.out.println(Report_FinalDeduct.reportHeaderReportName(driver).getText());
			Assert.assertEquals(Report_FinalDeduct.reportHeaderReportName(driver).getText(), "Final Deduct");
			System.out.println("Report Name is Matched");
			test.log(LogStatus.PASS, "Report Header Name Matched");
			test.log(LogStatus.PASS, "Report Generated Successfully");
		} catch (Throwable e) {
			System.out.println("report name not matched");
			test.log(LogStatus.FAIL, e + "Report Header Name Not Matched");
		}

		List<WebElement> lst1 = Report_FinalDeduct.WC_GL_UMB_Totals(driver);
		ArrayList<String> WPlistTotal = new ArrayList<String>();
		for (int i = 0; i < lst1.size(); i++) {
			WPlistTotal.add(lst1.get(i).getText());
		}

		System.out.println(WPlistTotal);

		driver.close();
		driver.switchTo().window(wb.map.get("parentID"));

		String baseUrl = driver.getCurrentUrl();

		CPO_LogInAction.logInCPO(driver);// login action take in place
		CPO_HomePage.IconReports(driver).click();// click on home report icon
		test.log(LogStatus.INFO, " Clicked On Reports Page");
		wb.selectSingleValue(CPO_ReportsModule.selectProgram(driver), ProgramName);
		test.log(LogStatus.PASS, ProgramName + " Program Selected");
		CPO_ReportsModule.openReport(driver, reportName).click();// click on
																	// respective
																	// report
		test.log(LogStatus.PASS, reportName + " Report Selected");
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));

		Thread.sleep(1000);
		wb.selectSingleValue(Report_CPO_FinalDeduct.selectDistrict(driver), "All Districts");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", Report_CPO_FinalDeduct.selectContractor(driver));
		Thread.sleep(2000);
		wb.selectSingleValueFromList(Report_CPO_FinalDeduct.selectProject(driver), ProjectName);
		test.log(LogStatus.PASS, ProgramName + " Project Selected");
		wb.selectSingleValue(Report_CPO_FinalDeduct.selectContractor(driver), "All Contractors");
		test.log(LogStatus.PASS, " Contractor Selected");
		Report_CPO_FinalDeduct.btnBuildReport(driver).click();
		test.log(LogStatus.INFO, " Clicked On Build Report Button");

		try {

			System.out.println(Report_CPO_FinalDeduct.reportHeader(driver).getText());
			Assert.assertEquals(Report_CPO_FinalDeduct.reportHeader(driver).getText(), "Final Deduct");
			test.log(LogStatus.PASS, " Report Name Matched");
		} catch (Throwable e) {
			test.log(LogStatus.PASS, e + " Report Name Not Matched");
		}

		List<WebElement> lst2 = Report_CPO_FinalDeduct.WC_GL_UMB_Totals(driver);
		ArrayList<String> CPlistTotal = new ArrayList<String>();
		for (int i = 0; i < lst2.size(); i++) {
			CPlistTotal.add(lst2.get(i).getText());
		}

		System.out.println(WPlistTotal.equals(CPlistTotal));//Comparing both list
		if (WPlistTotal.equals(CPlistTotal) == true) {
			test.log(LogStatus.PASS, "Data Matched");
		} else {
			test.log(LogStatus.FAIL, "Data did't Matched");
		}

		System.out.println(WPlistTotal);
		test.log(LogStatus.PASS, "Contractor Insurance Tracking Report Sub Total Values Wrap Portal:- " + WPlistTotal);
		System.out.println(CPlistTotal);
		test.log(LogStatus.PASS,
				"Contractor Insurance Tracking Report Sub Total Values Contractor Portal:- " + CPlistTotal);

		driver.close();
		driver.switchTo().window(wb.map.get("parentID"));

		driver.navigate().to(baseUrl);

	}
}
