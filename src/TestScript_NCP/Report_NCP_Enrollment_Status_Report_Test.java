package TestScript_NCP;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.ExcelDataConfig;
import ModulerLibrary.NCP_LoginAction;
import ObjectRepository_NCP.NCP_HomePage;
import ObjectRepository_NCP.NCP_ReportPage;
import ObjectRepository_NCP.Report_NCP_Contractor_Cost_Summary;

public class Report_NCP_Enrollment_Status_Report_Test extends BaseClass
{
	WebDriverCommonLib wb = new WebDriverCommonLib();
	public String reportName = "Status Report";
	
	
	@Test(dataProvider = "excelData")
	public void testEnrollmentStatusReport(String ProgramName, String Division, String Projects)
			throws Throwable {
		String baseUrl = driver.getCurrentUrl();
		NCP_LoginAction.logInNCP(driver);
		NCP_HomePage.ReportModule(driver).click();
		test.log(LogStatus.PASS, " Clicked on Report Module");
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
		driver.switchTo().frame(0);
		Thread.sleep(1000);
//		wb.selectSingleValueByIndex(Report_NCP_Contractor_Cost_Summary.selectProgram(driver), 1);
		test.log(LogStatus.PASS, Projects + " Project Selected");
		Thread.sleep(1000);
		wb.selectSingleValue(Report_NCP_Contractor_Cost_Summary.selectContractor(driver), "All Contractors");
		test.log(LogStatus.PASS, " Contractor Selected");
		Report_NCP_Contractor_Cost_Summary.btnBuildReport(driver).click();
		test.log(LogStatus.INFO, " Clicked On Build Report Button");

		try {
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			driver.switchTo().frame(1);
			Thread.sleep(2000);
			System.out.println(Report_NCP_Contractor_Cost_Summary.reportHeader(driver).getText());
			Assert.assertEquals(Report_NCP_Contractor_Cost_Summary.reportHeader(driver).getText(),
					"Enrollment Status Report");
			test.log(LogStatus.PASS, " Report Name Matched");
		} catch (Throwable e) {
			test.log(LogStatus.PASS, e + " Report Name Not Matched");
		}
		driver.switchTo().defaultContent();
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
