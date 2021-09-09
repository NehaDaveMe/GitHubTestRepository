package TestScript;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import junit.framework.Assert;
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
import ObjectRepository.Report_FinalDeduct;

public class Calculation_FinalDeductReportTest extends BaseClass {

	WebDriverCommonLib wb = new WebDriverCommonLib();
//	List<WebElement> lst1;
//	WPO_AddContractorPkgAction addCpAction=new WPO_AddContractorPkgAction();
//	WPO_EnrollContractorPkgAction enrollCpAction =new WPO_EnrollContractorPkgAction();
//	WPO_SelectContractorPkgAction selectContractorPkg= new WPO_SelectContractorPkgAction(); 
	
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
	
//	WPO_EnrollContractorPkgAction enp=new WPO_EnrollContractorPkgAction();
	public String tabName = "WC Premiums Modifications";
	
	
	@Test
	public void calculationFinalDeductReport() throws Throwable
	{
		String reportName = "Final Deduct";
	
		//add new cp and enroll cp action class 
//		addCpAction.add_CP_Via_Project(contractorName, projectName, programName, contractorCompany, contactName, tradeNumber, contractorPKGno, insuranceCompName, submissionFrequency, reportTime);
//		enrollCpAction.enrollContractorTest(contractorName, projectName, programName, contractorCompany, contactName, tradeNumber, contractorPKGno, insuranceCompName);
//		List<WebElement> prm = enp.listOfPremium;
//		ArrayList<String> prm2 = enp.data1;
		
		WPO_SelectContractorPkgAction.selectContractorpkg(contractorPKGno, tabName);
		
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		driver.manage().window().maximize();
		// AddContractor_Pkg_Insurance_Enrollment_Page.InsuranceEnrollmentTab(driver).click();
		Thread.sleep(7000);
		AddContractor_Pkg_Insurance_Enrollment_Page.enrollContractorPkgAllTab(driver, tabName).click();
	
		// Store wc values in list
		/*List<WebElement> listOfPremium = AddContractor_WC_Premiums_Modifications_Page.premiumValues(driver);
		System.out.println("size of list" + listOfPremium.size());
		for (int i = 0; i <= listOfPremium.size() - 1; i++) {
			System.out.println(listOfPremium.get(i).getAttribute("value").trim());
		}*/
		
		List<WebElement> listOfPremium = AddContractor_Pkg_WC_Premiums_Modifications_Page.premiumValues(driver);
		 ArrayList<Object> CPValues = new ArrayList<Object>();
			for (int i = 0; i < listOfPremium.size(); i++) 
			{
				CPValues.add(listOfPremium.get(i).getAttribute("value").trim());
			}
			
			System.out.println(CPValues);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",AddContractor_Pkg_WC_Premiums_Modifications_Page.btnSaveAndClose(driver));
		AddContractor_Pkg_WC_Premiums_Modifications_Page.btnSaveAndClose(driver).click();
		Thread.sleep(4000);
//		driver.switchTo().defaultContent();
		driver.switchTo().window(wb.map.get("parentID"));
		
		try {
			HomePage.controlMenuReports(driver).click();
			test.log(LogStatus.INFO, "Clicked on Report Module Icon");
			Thread.sleep(2000);
			wb.selectSingleValue(ReportModule.selectProgramDropdown(driver), programName);
			test.log(LogStatus.INFO, programName + " Program Select Form Dropdown");
			Thread.sleep(5000);
			ReportModule.selectReport(driver, reportName).click();
			test.log(LogStatus.PASS, reportName + " Report is Selected");
			wb.getWindowIDs();
			driver.switchTo().window(wb.map.get("childID"));
			// wb.selectSingleValue(Report_FinalDeduct.filterSelectDivisionDropdown(driver),
			// Division);
			// test.log(LogStatus.PASS, Division +" Selected Successfully");

			Report_FinalDeduct.filterSelectProjectFormOption(driver, projectName).click();
			test.log(LogStatus.PASS, projectName + " Project Selected Successfully");

//			Report_FinalDeduct.filterSelectContractorFormOption(driver).click();
//			test.log(LogStatus.PASS, " Contractor Selected Successfully");

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
		
		System.out.println(contractorPKGno);
		
		Thread.sleep(5000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",Report_FinalDeduct.selectContractorPkgID(driver, contractorPKGno));
		System.out.println(Report_FinalDeduct.selectContractorPkgID(driver, contractorPKGno).getText());
	
		List<WebElement> lst1 = Report_FinalDeduct.selectWCModifiersValue(driver, contractorPKGno);
		System.out.println("list of the wc "+lst1.size());

		 ArrayList<Object> reportValues = new ArrayList<Object>();
		for (int i = 0; i < lst1.size(); i++) 
		{
			reportValues.add(lst1.get(i).getText());
		}
		
		System.out.println(reportValues);
		
		
		System.out.println(CPValues.equals(reportValues));
		
		
		//List<WebElement> enp = Report_FinalDeduct.selectWCModifiersValue(driver, contractorPKGno);
	/*	System.out.println("list of the wc "+prm.size());
		
		for (int i = 0; i < prm.size()-1; i++) 
		{
			System.out.println(prm.get(i).getText());	
		}
		
		System.out.println(prm2);
		for (int i = 0; i < prm2.size()-1; i++) 
		{
			System.out.println(prm2);	
		}
			System.out.println(lst1.equals(prm));// Comparing both
*/		
		
		
		/*
		try{
		    Assert.assertEquals(listOfPremium, lst1);
		    System.out.println("Equal lists");
		}catch(Throwable e){
		    System.err.println("Lists are not equal. "+e.getMessage());
		}
		*/
		
		driver.close();
		driver.switchTo().window(wb.map.get("parentID"));

		
		
//		List<WebElement> lst1 = Report_FinalDeduct.AllDataFinalDeduct(driver);
//		List<WebElement> lst2 = Report_FinalDeduct.AllDataFinalDeduct(driver);
		/*
		 * ArrayList<Object> WPlistTotal = new ArrayList<Object>(); for (int i =
		 * 0; i < lst1.size(); i++) { WPlistTotal.add(lst1.get(i).getText()); }
		 */

	}
}
