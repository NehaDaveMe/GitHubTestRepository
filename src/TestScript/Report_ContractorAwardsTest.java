package TestScript;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.ExcelDataConfig;
import GenericLibrary.FileUtils1;
import ModulerLibrary.WPO_LoginActionClientWise;
import ObjectRepository.HomePage;
import ObjectRepository.ReportModule;
import ObjectRepository.Report_ContractorAwards;

public class Report_ContractorAwardsTest extends BaseClass
{
	
	WebDriverCommonLib wb=new WebDriverCommonLib();
	String selectReportName="Contractor Awards";
//	String project1 = "120 Piedmont Student Housing";
//	String project2 = "712 West Peachtree";

	
	
	@Test(dataProvider="excelData")
	public void testContractorAwards(String ProgramName, String Division, String Projects,String userName, String password , String ProjectNAME1,String ProjectNAME2) throws InterruptedException
	{
	try 
	{	
	//WPO_LoginActionClientWise.logInLockton(driver);
	WPO_LoginActionClientWise.logInCommon(driver, userName, password);

		HomePage.controlMenuReports(driver).click();
		test.log(LogStatus.INFO, "Clicked on Report Module Icon");
		Thread.sleep(2000);
		wb.selectSingleValue(ReportModule.selectProgramDropdown(driver), ProgramName);
		test.log(LogStatus.INFO, ProgramName+" Respective Program Select Form Dropdown");
		Thread.sleep(5000);
		ReportModule.selectReport(driver, selectReportName).click();
		test.log(LogStatus.PASS, selectReportName+ " Report is Selected");
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		
		try {
			wb.selectSingleValue(Report_ContractorAwards.filterSelectDivisionDropdown(driver), Division);
			test.log(LogStatus.PASS,Division+ "  Selected Successfully");
		} catch (Throwable e) {
			// TODO: handle exception
		}
		
		Report_ContractorAwards.filterSelectProjectFormOption(driver, Projects).click();
		test.log(LogStatus.PASS,Projects+ " Project Selected Successfully");
		
		Report_ContractorAwards.btnBuildReport(driver).click();
		test.log(LogStatus.INFO, " Clicked On Build Report Button");
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Report Generated " +test.addScreenCapture(FileUtils1.getScreenshot(driver)));

	} catch (Throwable e) {
		test.log(LogStatus.FAIL, e+" Something Went Wrong");
		test.log(LogStatus.PASS, "Something went Wrong " +test.addScreenCapture(FileUtils1.getScreenshot(driver)));
	}
	//		String reportName=ReportModule.reportHeaderReportName(driver, "Contractor Enrollment Summary").getText();
	
	try {
		System.out.println(Report_ContractorAwards.reportHeaderReportName(driver).getText());
		Assert.assertEquals(Report_ContractorAwards.reportHeaderReportName(driver).getText(), "Contractor Awards");
		System.out.println("Report Name is Matched");
		test.log(LogStatus.PASS, "Report Header Name Matched");
		test.log(LogStatus.PASS, "Report Generated Successfully");
	} catch (Throwable e) 
	{
		System.out.println("report name not matched");
		test.log(LogStatus.FAIL, e+"Report Header Name Not Matched");
		
	}
	//filter testing
	
			Report_ContractorAwards.filterWindowButton(driver).click();
			Thread.sleep(3000);
			Report_ContractorAwards.filterSelectProjectFormOption(driver, ProjectNAME1).click();
			test.log(LogStatus.PASS, " First Project Selected Successfully");
			ReportModule.btnBuildReport(driver).click();
			test.log(LogStatus.PASS, "Clicked on Build Report Button ");
			int contPkgSize=7;
			//testCount(contPkgSize);

			//add second project
			Report_ContractorAwards.filterWindowButton(driver).click();
			Thread.sleep(3000);
			Report_ContractorAwards.filterSelectProjectFormOption(driver, ProjectNAME2).click();
			test.log(LogStatus.PASS, " Second Project Selected Successfully");
			ReportModule.btnBuildReport(driver).click();
			test.log(LogStatus.PASS, "Clicked on Build Report Button ");
			contPkgSize=11;
			//testCount(contPkgSize);
		
			
			//Excel file
			Report_ContractorAwards.excelLink(driver).click();
			test.log(LogStatus.PASS, "Clicked on Export to Excel Link");
			Thread.sleep(5000);
			//isFileDownloaded is the std method which accept the name of file and confirms the download
			if(wb.isFileDownloaded("Contractor_Awards_Report.xls")==true)
			{
				System.out.println("Excel file Downloaded Successfully");
				test.log(LogStatus.PASS, "Excel file Downloaded Successfully");
			}else
			{
				System.out.println("Excel file is not Downloaded Successfully");
				test.log(LogStatus.FAIL, "Excel file is not Downloaded Successfully");
			}
			
			
			//Add Filter Test
			Report_ContractorAwards.filterWindowButton(driver).click();
			test.log(LogStatus.PASS, "Clicked on Filter ");
			Thread.sleep(3000);
			Report_ContractorAwards.addFilterBtnOutside(driver).click();
			test.log(LogStatus.PASS, "Clicked on Add Filter Button From Filter");
			wb.getWindowID3();
			driver.switchTo().window(wb.map.get("subchildID"));
			driver.manage().window().maximize();
			wb.waitForElemnet(Report_ContractorAwards.selectAnFilterDropdown(driver));
			wb.selectSingleValueByIndex(Report_ContractorAwards.selectAnFilterDropdown(driver), 1);
			Thread.sleep(3000);
			test.log(LogStatus.PASS, " Filter Selected Successfully From Dropdown");
			wb.selectSingleValueByIndex(Report_ContractorAwards.selectAFilterCondition(driver), 1);
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Filter Condition Selected Successfully ");
			Report_ContractorAwards.addFilterParameter1(driver).click();
			Thread.sleep(1000);
			wb.selectSingleValueFromList(Report_ContractorAwards.selectParameter1(driver), "Enrolled");
			test.log(LogStatus.PASS, "Parameter Selected Successfully ");
			Report_ContractorAwards.addFilterBtnInside(driver).click();
			test.log(LogStatus.PASS, "Clicked on Add Filter Button ");
			Thread.sleep(3000);
			driver.switchTo().window(wb.map.get("childID"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",ReportModule.btnBuildReport(driver));
			test.log(LogStatus.PASS, "Clicked on Build Report Button ");
			
			Thread.sleep(5000);
	
	driver.close();
	driver.switchTo().window(wb.map.get("parentID"));
}
	
	@DataProvider(name="excelData")
	public Object [] [] passdata()
	{		
		String filePath="./testData/clientWiseReportTestData.xlsx";
//		String filePath="E:\\kp workspace selenium\\Wrap Portal\\testData\\clientWiseReportTestData.xlsx";
		ExcelDataConfig config=new ExcelDataConfig(filePath);//put all excel data in to the config object
		int row=config.getRowCount(0);//get exact row count from sheet
		int col=config.getColCount(0);
		System.out.println(col);
		System.out.println(row);

Object[][] data = new Object[row-1][col];//store all row and column in multidimensional array and print one by one
		for(int i = 1;i<row;i++)
		{	
			for (int j = 0; j <col; j++) 
			{
	            data[i-1][j] = config.getExcelData("Sheet1", i, j);
	        }
		}
		return data;//return data to test
	}
	public void testCount(int contPkgSize )
	{
		
		List<WebElement> countOfContractorPkg= Report_ContractorAwards.countContractorPkg(driver);
		
		if(countOfContractorPkg.size()==contPkgSize)
		{
			System.out.println("Contractor Pkg Count is Matached");
			test.log(LogStatus.PASS,countOfContractorPkg.size()+" Contractor Pkg Count is Matached");
		}else
		{
			System.out.println("Contractor Pkg Count is Not Matached");
			test.log(LogStatus.FAIL,"Contractor Pkg Count is Not Matached");
		}

	}
}
