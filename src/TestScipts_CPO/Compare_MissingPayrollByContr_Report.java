package TestScipts_CPO;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import ModulerLibrary.CPO_LogInAction;
import ObjectRepository.HomePage;
import ObjectRepository.ReportModule;
import ObjectRepository.Report_MissingPayrollbyContractorOld;
import ObjectRepository_CPO.CPO_HomePage;
import ObjectRepository_CPO.CPO_ReportsModule;
import ObjectRepository_CPO.Report_CPO_ContractorDeductTracking;

public class Compare_MissingPayrollByContr_Report extends BaseClass {
	WebDriverCommonLib wb = new WebDriverCommonLib();
	String selectReportName = "Missing Payroll By Contractor";
	public List<WebElement> lst1;

	@Test
	public void testCompareMissingPayrollBycontractorReport() throws Throwable {
		try {
			HomePage.controlMenuReports(driver).click();
			test.log(LogStatus.INFO, "Clicked on Report Module Icon");
			Thread.sleep(2000);
			wb.selectSingleValueByIndex(ReportModule.selectProgramDropdown(driver), 24);
			test.log(LogStatus.INFO, "Respective Program Select Form Dropdown");
			Thread.sleep(5000);
			Report_MissingPayrollbyContractorOld.selectReport(driver, selectReportName).click();
			test.log(LogStatus.PASS, selectReportName + " Report is Selected");
			wb.getWindowIDs();
			driver.switchTo().window(wb.map.get("childID"));
			driver.switchTo().frame(0);
			wb.selectSingleValue(Report_MissingPayrollbyContractorOld.selectDivision(driver), "All Divisions");
			test.log(LogStatus.PASS, " Divisions Selected Successfully");
			Thread.sleep(2000);
			wb.selectSingleValue(Report_MissingPayrollbyContractorOld.selectProjects(driver), "Sony Project One");
			test.log(LogStatus.PASS, " Project Selected Successfully");
			Thread.sleep(4000);
			wb.selectSingleValue(Report_MissingPayrollbyContractorOld.selectContractors(driver), "All Contractors");
			wb.selectSingleValueByIndex(Report_MissingPayrollbyContractorOld.selectContractors(driver), 2);
			// wb.mouseMoveToElement(Report_MissingPayrollbyContractorOld.selectContractors(driver));
			// wb.selectSingleValue(Report_MissingPayrollbyContractorOld.selectContractors(driver),
			// "Sony 1 Contractor Company - jonty rod");
			test.log(LogStatus.PASS, " Contractor Selected Successfully");
			Thread.sleep(8000);
			Report_MissingPayrollbyContractorOld.btnBuildReport(driver).click();
			test.log(LogStatus.INFO, " Clicked On Build Report Button");
			Thread.sleep(4000);
		} catch (Throwable e) {
			System.out.println(e);
			test.log(LogStatus.FAIL, e + " Something Went Wrong");
		}
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(1);
			System.out.println(Report_MissingPayrollbyContractorOld.reportHeaderReportName(driver).getText());
			Assert.assertEquals(Report_MissingPayrollbyContractorOld.reportHeaderReportName(driver).getText(),
					"Missing Payroll by Contractor Report");
			System.out.println("Report Name is Matched");
			test.log(LogStatus.PASS, "Report Header Name Matched");
			test.log(LogStatus.PASS, "Report Generated Successfully");

		} catch (Throwable e) {
			System.out.println("report name not matched");
			test.log(LogStatus.FAIL, e + "Report Header Name Not Matched");
		}

		// wb.printListData(Report_MissingPayrollbyContractorOld.countAllMissingPayroll(driver));

		lst1 = Report_MissingPayrollbyContractorOld.countAllMissingPayroll(driver);
		// added data in to Array list
		ArrayList<String> list1Data = new ArrayList<String>();
		for (int i = 0; i < lst1.size(); i++) {
			list1Data.add(lst1.get(i).getText());
		}
		driver.switchTo().defaultContent();
		driver.close();
		driver.switchTo().window(wb.map.get("parentID"));

		// Contractor Portal Code Start
		String ProgramName = "Sony Tower Test";
		String ProjectName = "Sony Project One";
		String reportName = "Missing Payroll By Contractor";

		String baseUrl = driver.getCurrentUrl();

		CPO_LogInAction.logInCPO(driver);
		CPO_HomePage.IconReports(driver).click();
		test.log(LogStatus.INFO, " Clicked On Reports Page");
		wb.selectSingleValue(CPO_ReportsModule.selectProgram(driver), ProgramName);
		test.log(LogStatus.PASS, ProgramName + " Program Selected");
		CPO_ReportsModule.openReport(driver, reportName).click();
		test.log(LogStatus.PASS, reportName + " Report Selected");
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		wb.selectSingleValue(Report_CPO_ContractorDeductTracking.selectProgram(driver), ProjectName);
		test.log(LogStatus.PASS, ProgramName + " Project Selected");
		Thread.sleep(1000);
		wb.selectSingleValue(Report_CPO_ContractorDeductTracking.selectContractor(driver), "All Contractors");
		test.log(LogStatus.PASS, " Contractor Selected");
		Report_CPO_ContractorDeductTracking.btnBuildReportOld(driver).click();
		test.log(LogStatus.INFO, " Clicked On Build Report Button");

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(1);
			System.out.println(Report_CPO_ContractorDeductTracking.reportHeader(driver).getText());
			Assert.assertEquals(Report_CPO_ContractorDeductTracking.reportHeader(driver).getText(),
					"Missing Payroll by Contractor Report");
			test.log(LogStatus.PASS, " Report Name Matched");
		} catch (Throwable e) {
			test.log(LogStatus.PASS, e + " Report Name Not Matched");
		}

		// wb.printListData(Report_MissingPayrollbyContractorOld.countAllMissingPayroll(driver));
		List<WebElement> list2 = Report_MissingPayrollbyContractorOld.countAllMissingPayroll(driver);

		// added data in to Array list
		ArrayList<String> list2Data = new ArrayList<String>();
		for (int i = 0; i < list2.size(); i++) {
			list2Data.add(list2.get(i).getText());
		}

		System.out.println(list1Data.equals(list2Data));
		test.log(LogStatus.PASS, "Is List Matched:- "+list1Data.equals(list2Data));
		System.out.println(list1Data);
		test.log(LogStatus.PASS,"Missing Payroll By Contractor Wrap Portal:- "+list1Data);
		System.out.println(list2Data);
		test.log(LogStatus.PASS, "Missing Payroll By Contractor Contractor Portal:- "+list2Data );

		System.out.println("Result of removing " + list1Data.removeAll(list2Data));
		System.out.println("Removing element are:- " + list1Data);

		int temp = 0;
		for (int i = 0; i < list1Data.size(); i++) {
			System.out.println(list1Data.get(i));
			for (int j = 0; j < list2Data.size(); j++) {
				System.out.println(list2Data.get(j));
				if (list1Data.get(i).equals(list2Data.get(j))) {
					System.out.println(list1Data.get(i));
				} else {
					// System.out.println("in else ");
					temp = 1;
				}
			}
		}

		// System.out.println(temp);
		if (temp == 1) {
			System.out.println("List not matched");
		}

		driver.switchTo().defaultContent();
		driver.close();
		driver.switchTo().window(wb.map.get("parentID"));

		driver.navigate().to(baseUrl);

	}
}

/*
 * [June - 2019] June - 2019 October - 2019 July - 2019 August - 2019 September
 * - 2019 October - 2019 October - 2019 July - 2019 August - 2019 September -
 * 2019 October - 2019 October - 2019 October - 2019 July - 2019 August - 2019
 * September - 2019 October - 2019 July - 2019 August - 2019 September - 2019
 * October - 2019 July - 2019 August - 2019 September - 2019 October - 2019
 * October - 2019 July - 2019 August - 2019 September - 2019 October - 2019 July
 * - 2019 August - 2019 September - 2019 October - 2019 October - 2019 October -
 * 2019 July - 2019 August - 2019 September - 2019 October - 2019
 */
