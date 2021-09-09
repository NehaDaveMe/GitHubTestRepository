package TestScript;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.RandomClass;
import ModulerLibrary.WPO_AddContractorPkgAction;
import ObjectRepository.AddContractor_Pkg_Page;
import ObjectRepository.AddProject_General_Information_Page;
import ObjectRepository.AddTradePage;
import ObjectRepository.ContractorPackageModule;
import ObjectRepository.HomePage;
import ObjectRepository.ProjectModule;

public class Cancelled_Contractor_Pkg extends BaseClass {
	WebDriverCommonLib wb = new WebDriverCommonLib();
	public String contractorName = "Alex Comp2273";
	public String projectName = "Test Sony project Reg 123";
	public String programName = "Test Sony Program 123";
	public String contractorCompany = "Alex Comp2273";// "sony";
	public String contactName = "Jimmy Smith";
	public String tradeNumber = RandomClass.randomTradeNO();
	public String insuranceCompName = "Carriers3524";
	public String submissionFrequency = "Quarterly";
	public String reportTime = "Quarterly";
	public String contractorPKGno = RandomClass.randomContractorPkgNo();
	public String EnrollmentType = "GL Only Enrollment";// "Excluded Contractor";
	String dba = RandomClass.randomDBA();
	public String status = "Assigned";
	/*
	 * public String uName="JimmySmith114211"; public String
	 * password="uX6R1i0L7KxA";
	 */

	@Test
	public void enrollContractor_Pkg_GL_OnlyTest() throws InterruptedException, IOException {
		WPO_AddContractorPkgAction.add_ContractorPkg(contractorName, projectName, programName, contractorCompany,
				contactName, tradeNumber, contractorPKGno, insuranceCompName, submissionFrequency, reportTime,
				EnrollmentType);
		// WebDriverWait webwait = new WebDriverWait(driver, 60);
		HomePage.controlMenuHomeIcon(driver).click();
		test.log(LogStatus.PASS, "Clicked On Home Icon");
		HomePage.HomeMenuContractorPackage(driver).click();
		test.log(LogStatus.PASS, "Clicked On Contracotr Package Icon");
		Thread.sleep(5000);
		// checkPageIsReady();
		// wb.waitForElemnet(ContractorPackageModule.searchEditBox(driver));
		// test.log(LogStatus.PASS, "Clicked On Edit Icon");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
		int x = 2;
		do {
			try {
				ContractorPackageModule.advanceSearchIcon(driver).click();
				test.log(LogStatus.PASS, "Clicked On Advance Search Icon");
				x = 2;
			} catch (Throwable e) {
				System.out.println(e);
				js.executeScript("window.scrollBy(0,-350)", "");
			}
		} while (x == 1);
		Thread.sleep(4000);
		wb.selectSingleValue(ContractorPackageModule.advanceSearchSelectProgram(driver), programName);
		test.log(LogStatus.PASS, programName + " Respective Project Selected Successfully");
		Thread.sleep(1500);
		wb.selectSingleValue(ContractorPackageModule.advanceSearchSelectEnrollmenttype(driver), EnrollmentType);
		test.log(LogStatus.PASS, EnrollmentType + " Enrollment Type Selected Successfully");
		Thread.sleep(1500);
		ContractorPackageModule.advanceSearchSelectContractorStatus(driver).click();
		test.log(LogStatus.PASS, " clicked on Contractor Status Field");
		// wb.selectSingleValueFromList(ContractorPackageModule.advanceSearchSelectStatusFromDropdownList(driver),
		// "Missing Payroll");
		ContractorPackageModule.advanceSearchSelect_Single_StatusFromDropdown(driver, status).click();
		test.log(LogStatus.PASS, status + " Status Selected Successfully");
		Thread.sleep(1500);
		ContractorPackageModule.advanceSearchSearchBtn(driver).click();
		test.log(LogStatus.PASS, " Clicked on Advance Search Button");
		Thread.sleep(10000);
		js.executeScript("window.scrollBy(0,-350)", "");

		do {
			try {
				ContractorPackageModule.editIcon(driver).click();
				test.log(LogStatus.PASS, " Clicked On Contractor Package Edit Icon Button");
				x = 2;
			} catch (Throwable e) {
				System.out.println(e);
				js.executeScript("window.scrollBy(0,-350)", "");
			}
		} while (x == 1);

		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		driver.manage().window().maximize();
		js.executeScript("arguments[0].click();", AddContractor_Pkg_Page.cancelContractorPkgBtn(driver));
		test.log(LogStatus.PASS, " Clicked On Canceled Contractor Package Button");
		Thread.sleep(2000);
		AddContractor_Pkg_Page.cancelContractorPkgBtnAlertOKBtn(driver).click();
		test.log(LogStatus.PASS, " Clicked On Canceled Contractor Package Alert Ok Button");
		Thread.sleep(3000);

		/*
		 * //now if we cancel the cp then its directly navigate to the preview
		 * panel screen
		 * js.executeScript("arguments[0].click();",AddContractor_Pkg_Page.
		 * saveAndCloseBtn(driver)); test.log(LogStatus.PASS,
		 * " Clicked On Contractor Package Save And Close Button"); try {
		 * 
		 * AddContractor_Pkg_Page.alertConfirmComplianceContinueBtn(driver).
		 * click(); test.log(LogStatus.PASS,
		 * " Clicked On Contractor Package Compliance Alert OK Button"); //
		 * AddContractor_Pkg_Page.saveAndCloseBtn(driver).click(); } catch
		 * (Throwable e) { System.out.println(e); }
		 */

		driver.switchTo().window(wb.map.get("parentID"));
		System.out.println(ContractorPackageModule.singleContractorPkgStatus(driver).getText());
		if (ContractorPackageModule.singleContractorPkgStatus(driver).getText().contains("Cancelled")) {
			System.out.println("Status Matched and Contractor Package get Cancelled Successfully");
			test.log(LogStatus.PASS, " Status Matched and Contractor Package get Cancelled Successfully");
		} else {
			System.err.println("Status Not Matched");
			test.log(LogStatus.FAIL, " Status Not Matched and Contractor Package not get Cancelled Successfully");
		}

		Thread.sleep(5000);
	}

	public void checkPageIsReady() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return;
		}
	}
}
