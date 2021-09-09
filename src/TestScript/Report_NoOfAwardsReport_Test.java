package TestScript;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.ExcelDataConfig;
import GenericLibrary.FileUtils1;
import ObjectRepository.HomePage;
import ObjectRepository.ReportModule;
import ObjectRepository.Report_ContractorPackageStatusReport;
import ObjectRepository.Report_NoOfAwardsReport;

public class Report_NoOfAwardsReport_Test extends BaseClass
{
	
	WebDriverCommonLib wb=new WebDriverCommonLib();
	String selectReportName="No. of Awards Report";	
	String headerName="No. of Awards Report";
	@Test(dataProvider = "excelData")
	public void testNoOfAwardsReport(String ProgramName, String Division, String Projects,String userName, String password, String ProjectNAME1,String ProjectNAME2) throws InterruptedException
	{
		try 
		
		{
//			WPO_LoginActionClientWise.logInCommon(driver, userName, password);
			HomePage.controlMenuReports(driver).click();
			test.log(LogStatus.INFO, "Clicked on Report Module Icon");
			Thread.sleep(2000);
			wb.selectSingleValue(ReportModule.selectProgramDropdown(driver), ProgramName);
			test.log(LogStatus.INFO, "Respective Program Select Form Dropdown");
			Thread.sleep(5000);
			Report_NoOfAwardsReport.selectReport(driver, selectReportName).click();
			test.log(LogStatus.PASS, selectReportName+ " Report is Selected");
			wb.getWindowIDs();
			driver.switchTo().window(wb.map.get("childID"));
			
			try {
				wb.selectSingleValue(Report_NoOfAwardsReport.filterSelectDivisionDropdown(driver), Division);
				test.log(LogStatus.PASS, " Divisions Selected Successfully");
			} catch (Throwable e) {
				System.out.println(e);
			}		
			Report_NoOfAwardsReport.filterSelectProjectFormOption(driver, Projects).click();
			test.log(LogStatus.PASS, " Project Selected Successfully");

			
			Report_NoOfAwardsReport.btnBuildReport(driver).click();
			test.log(LogStatus.INFO, " Clicked On Build Report Button");
			Thread.sleep(3000);
					
		} catch (Throwable e) {
			test.log(LogStatus.FAIL, e+" Something Went Wrong");
		}
		
//	String reportName=ReportModule.reportHeaderReportName(driver, "Contractor Enrollment Summary").getText();

		try {
			System.out.println(Report_NoOfAwardsReport.reportHeaderReportName(driver).getText());
			Assert.assertEquals(Report_NoOfAwardsReport.reportHeaderReportName(driver).getText(), headerName);
			System.out.println("Report Name is Matched");
			test.log(LogStatus.PASS, "Report Header Name Matched");
			test.log(LogStatus.PASS, "Report Generated Successfully");
		} catch (Throwable e) 
		{
			System.out.println("report name not matched");
			test.log(LogStatus.FAIL, e+"Report Header Name Not Matched");
		}
		
// Filter Testing
		ReportModule.FilterWindowButton(driver).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", ReportModule.filterSelectProjectFormOption(driver, ProjectNAME1));
		test.log(LogStatus.PASS, " First Project Selected Successfully");

		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", Report_NoOfAwardsReport.btnBuildReport(driver));
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
	}
	@DataProvider(name = "excelData")
	public Object[][] passdata() {

		String filePath="./testData/clientWiseReportTestData.xlsx";
//		String filePath="E:\\kp workspace selenium\\Wrap Portal\\testData\\LocktonReportData2.xlsx";
//		String filePath="D:\\NOURTEK\\Wrap Portal-2\\testData\\LocktonReportData2.xlsx";
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
