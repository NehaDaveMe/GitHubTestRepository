package TestScript_NCP;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.ExcelDataConfig;
import GenericLibrary.FileUtils1;
import ModulerLibrary.NCP_LoginAction;
import ObjectRepository.ReportModule;
import ObjectRepository.Report_ContractorPackageStatusReport;
import ObjectRepository_NCP.NCP_HomePage;
import ObjectRepository_NCP.NCP_ReportPage;

public class Report_NCP_ContractorPackageStatusReport_Test extends BaseClass {

	WebDriverCommonLib wb = new WebDriverCommonLib();
	public String reportName = "Contractor Package Status Report";
	public String ProjectNAME1 = "Test 132 OFF";
	public String ProjectNAME2 = "Test 132 ON";

	@Test(dataProvider = "excelData", invocationCount = 1)
	public void testContractorPackageStatusReport(String ProgramName, String Division, String Projects) throws Throwable {
		String baseUrl = driver.getCurrentUrl();
		NCP_LoginAction.logInNCP(driver);
		NCP_HomePage.ReportModule(driver).click();
		test.log(LogStatus.PASS, " Clicked on Report Module");
		try {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			wb.waitForElemnet(NCP_ReportPage.selectProgramField(driver));
			Thread.sleep(3000);
			wb.selectSingleValueFromList(NCP_ReportPage.selectProgramFromList(driver), ProgramName);
			test.log(LogStatus.PASS, ProgramName + " Program Selected Successfully");
			wb.selectSingleValueFromList(NCP_ReportPage.selectReportNameFromList(driver), reportName);
			test.log(LogStatus.PASS, reportName + " Report Selected Successfully");

			Thread.sleep(5000);
			wb.getWindowIDs();
			driver.switchTo().window(wb.map.get("childID"));
			driver.manage().window().maximize();
			
			try {
				js.executeScript("arguments[0].scrollIntoView();",
						Report_ContractorPackageStatusReport.filterSelectDivisionDropdown(driver));
				Report_ContractorPackageStatusReport.filterSelectDivisionDropdown(driver).click();
				test.log(LogStatus.PASS, Division + " Divisions Selected Successfully");
			} catch (Throwable e) {
				// TODO: handle exception
			}
			js.executeScript("arguments[0].scrollIntoView();",
					Report_ContractorPackageStatusReport.filterSelectContractorFormOption(driver));

			Report_ContractorPackageStatusReport.filterSelectContractorFormOption(driver).click();
			test.log(LogStatus.PASS, " Contractor Selected Successfully and clicked");

			Report_ContractorPackageStatusReport.btnBuildReport(driver).click();
			test.log(LogStatus.INFO, " Clicked On Build Report Button");
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Report Generated" + test.addScreenCapture(FileUtils1.getScreenshot(driver)));
		} catch (Throwable e) {
			test.log(LogStatus.FAIL, e + " Something Went Wrong");
			test.log(LogStatus.PASS, "Something Went Wrong" + test.addScreenCapture(FileUtils1.getScreenshot(driver)));
		}

		try {

			SoftAssert softAssertion = new SoftAssert();
			System.out.println(Report_ContractorPackageStatusReport.reportHeaderReportName(driver).getText());
			softAssertion.assertEquals(Report_ContractorPackageStatusReport.reportHeaderReportName(driver).getText(),
					reportName);

			System.out.println("Report Name is Matched");
			test.log(LogStatus.PASS, "Report Header Name Matched");
			test.log(LogStatus.PASS, "Report Generated Successfully");
			softAssertion.assertEquals(Report_ContractorPackageStatusReport.programName(driver).getText(), ProgramName);
			test.log(LogStatus.PASS,
					"Program Name:- " + Report_ContractorPackageStatusReport.programName(driver).getText());
			test.log(LogStatus.PASS,
					"Sponsor Name:- " + Report_ContractorPackageStatusReport.sponsorName(driver).getText());

			test.log(LogStatus.PASS,
					"Time Stamp:- " + Report_ContractorPackageStatusReport.timeStamp(driver).getText());
			test.log(LogStatus.PASS, "PDF Option is Present:- "
					+ Report_ContractorPackageStatusReport.exportToPDF(driver).isDisplayed());
			test.log(LogStatus.PASS, "Excel Option is Present:- "
					+ Report_ContractorPackageStatusReport.exportToExcel(driver).isDisplayed());
			test.log(LogStatus.PASS, "================= Column Name =================");
			List<WebElement> list = Report_ContractorPackageStatusReport.allColumnName(driver);
			// wb.printListData();
			for (int i = 0; i < list.size(); i++) {
				test.log(LogStatus.PASS, "=====> " + list.get(i).getText() + " <=====");
			}
			softAssertion.assertAll();
			
		} catch (Throwable e) {
			System.out.println("report name not matched");
			test.log(LogStatus.FAIL, e + "Report Header Name Not Matched");
		}

		// Filter Testing
		ReportModule.FilterWindowButton(driver).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", ReportModule.filterSelectProjectFormOption(driver, ProjectNAME1));
		test.log(LogStatus.PASS, " First Project Selected Successfully");

		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", Report_ContractorPackageStatusReport.btnBuildReport(driver));
		test.log(LogStatus.INFO, " Clicked On Build Report Button");
		Thread.sleep(3000);

		ReportModule.FilterWindowButton(driver).click();
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", ReportModule.filterSelectProjectFormOption(driver, ProjectNAME2));
		test.log(LogStatus.PASS, " Second Project Selected Successfully");
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", Report_ContractorPackageStatusReport.btnBuildReport(driver));
		test.log(LogStatus.INFO, " Clicked On Build Report Button");
		Thread.sleep(3000);

		Thread.sleep(2000);
		// Check for pdf is generated or not take screenshot
		Report_ContractorPackageStatusReport.pdfLink(driver).click();
		Thread.sleep(2000);
		wb.getWindowID3();
		driver.switchTo().window(wb.map.get("subchildID"));
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Pdf Generated " + test.addScreenCapture(FileUtils1.getScreenshot(driver)));
		driver.close();
		driver.switchTo().window(wb.map.get("childID"));

		// Excel file
		Report_ContractorPackageStatusReport.excelLink(driver).click();
		Thread.sleep(10000);
		if (wb.isFileDownloaded("Contractor_Package_Status_Report.xls") == true) {
			System.out.println("Excel file Downloaded Successfully");
			test.log(LogStatus.PASS, "Excel file Downloaded Successfully");
		} else {
			System.out.println("Excel file is not Downloaded Successfully");
			test.log(LogStatus.FAIL, "Excel file is not Downloaded Successfully");
		}
		Thread.sleep(5000);

		driver.close();
		driver.switchTo().window(wb.map.get("parentID"));

		driver.navigate().to(baseUrl);

	}

	@DataProvider(name = "excelData")
	public Object[][] passdata() {
		String filePath = "E:\\kp workspace selenium\\Wrap Portal\\testData\\NCP Report Data.xlsx";
		ExcelDataConfig config = new ExcelDataConfig(filePath);
		int row = config.getRowCount(0);// get exact row count from sheet
		int col = config.getColCount(0);
		System.out.println(col);
		System.out.println(row);

		Object[][] data = new Object[row - 1][col];
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				data[i - 1][j] = config.getExcelData("Sheet1", i, j);
			}
		}
		return data;// return data to test

	}
}
