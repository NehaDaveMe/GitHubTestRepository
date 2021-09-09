package TestScript;

import java.io.IOException;
import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.RandomClass;
import ModulerLibrary.WPO_AddContractorPkgAction;
import ObjectRepository.AddContractor_Pkg_Enrollment_Summary_Page;
import ObjectRepository.AddContractor_Pkg_Insurance_Enrollment_Page;
import ObjectRepository.AddContractor_Pkg_OSHA_EMR_Page;
import ObjectRepository.AddContractor_Pkg_Page;
import ObjectRepository.AddContractor_Pkg_Required_Documents_Page;
import ObjectRepository.AddContractor_Pkg_SubContractorInfo;
import ObjectRepository.AddProject_General_Information_Page;
import ObjectRepository.AddTradePage;
import ObjectRepository.ContractorPackageModule;
import ObjectRepository.HomePage;
import ObjectRepository.ProjectModule;

public class Exclude_CP_DocumentSignTest extends BaseClass 
{
	
	WebDriverCommonLib wb = new WebDriverCommonLib();
//	AddContractor_Pkg_TC tc = new AddContractor_Pkg_TC();
	public String contractorName = "Alex Comp2273";
	public String projectName = "Test Sony project Reg 123";//"Sony Projects3524";
	public String programName="Test Sony Program 123";//"Sony Programs3524";//"Sony Tower One Prog";
	public String contractorCompany="Alex Comp2273";//"sony";
	public String contactName="Jimmy Smith";
	public String tradeNumber = RandomClass.randomTradeNO();
	public String insuranceCompName = "Carriers3524";
	public String submissionFrequency = "Quarterly";
	public String reportTime = "Quarterly";
	public String contractorPKGno=RandomClass.randomContractorPkgNo();
	public String EnrollmentType ="Excluded Contractor";
	
	//span[contains(text(),'Renewal Contractor Off-Site COI')]/../div//input
	//span[contains(text(),'Signed Enrollment Form')]/../div//input
	
	@Test
	public void enrollContractor_Pkg_Excluded_Test() throws InterruptedException, IOException 
	{
		
		WPO_AddContractorPkgAction.add_ContractorPkg(contractorName, projectName, programName, contractorCompany, contactName, tradeNumber, contractorPKGno, insuranceCompName, submissionFrequency, reportTime, EnrollmentType);
		WebDriverWait webwait = new WebDriverWait(driver, 60);
		webwait.until(ExpectedConditions.elementToBeClickable(ContractorPackageModule.searchEditBox(driver)));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		

		js.executeScript("arguments[0].click();",ContractorPackageModule.searchEditBox(driver));
		js.executeScript("window.scrollBy(0,-350)", "");
		
		ContractorPackageModule.searchEditBox(driver).sendKeys(contractorName, Keys.TAB);
		Thread.sleep(3000);
		test.log(LogStatus.INFO, "Search For Respective Company");
		js.executeScript("window.scrollBy(0,-350)", "");
		// js.executeScript("window.scrollBy(0,-350)", "");
		js.executeScript("arguments[0].click();", ContractorPackageModule.searchIcon(driver));
		test.log(LogStatus.INFO, "Clicked on Search Icon");
		Thread.sleep(10000);
		js.executeScript("window.scrollBy(0,-250)", "");
		// search for respective contractor pkg and click on it
		js.executeScript("arguments[0].click();",
				ContractorPackageModule.selectDynamicContractorPkg(driver, contractorName, projectName, tradeNumber));
		Thread.sleep(10000);
		
		driver.switchTo().frame(0);
		System.out.println(ContractorPackageModule.fetchTradeNamePriviewP(driver).getText());
		wb.waitForElemnet(ContractorPackageModule.InsuranceEnrollmentPagePriviewP(driver));
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Clicked on Insurance Enrollment Page");
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		driver.manage().window().maximize();
		// AddContractor_Pkg_Insurance_Enrollment_Page.InsuranceEnrollmentTab(driver).click();
		Thread.sleep(7000);
		
		try {
			AddContractor_Pkg_Insurance_Enrollment_Page.popUpCloneCancelBtn(driver).click();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		
		try {
			// Insurance Enrollment page
			js.executeScript("arguments[0].click();",
					AddContractor_Pkg_Insurance_Enrollment_Page.contactInformationEmail(driver));

			js.executeScript("arguments[0].scrollIntoView();",
					AddContractor_Pkg_Insurance_Enrollment_Page.fieldContractValue(driver));
			wb.mouseMoveToElement(AddContractor_Pkg_Insurance_Enrollment_Page.fieldContractValue(driver));
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldContractValue(driver).clear();
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldContractValue(driver).sendKeys("5600000");
			test.log(LogStatus.PASS, "Contract Value Added Successfully");
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldSelfPerformedContractValue(driver).clear();
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldSelfPerformedContractValue(driver).sendKeys("560000");
			test.log(LogStatus.PASS, "Self Performed Contract Value Added Successfully");

			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedUncappedPayroll(driver).clear();
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedUncappedPayroll(driver).sendKeys("100000");
			test.log(LogStatus.PASS, "Estimated Uncapped Payroll Added Successfully");

			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedCappedPayroll(driver).clear();
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedCappedPayroll(driver).sendKeys("100000");
			test.log(LogStatus.PASS, "Estimated Capped Payroll Added Successfully");

			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedManHours(driver).clear();
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedManHours(driver).sendKeys("1000");
			test.log(LogStatus.PASS, "Estimated Man Hours Added Successfully");
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedStartDate(driver).clear();
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedStartDate(driver).sendKeys("01/02/2021",
					Keys.TAB);
			test.log(LogStatus.PASS, "Estimated Start Date Added Successfully");
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedCompletionDate(driver).clear();
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedCompletionDate(driver).sendKeys("12/31/2022",
					Keys.TAB);
			
			test.log(LogStatus.PASS, "Estimated Completion Date Added Successfully");
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldContractorCompanyInsuranceCost(driver).sendKeys("1000");
			test.log(LogStatus.PASS, "Contractor Company's Insurance Cost Added Successfully");
			
			System.out.println("Program Radio Button is Selected \t"
					+ AddContractor_Pkg_Insurance_Enrollment_Page.redioBtnProgram(driver).isSelected());

			js.executeScript("arguments[0].click();",
					AddContractor_Pkg_Insurance_Enrollment_Page.textAreaBrieflyDescribetheScopeWork(driver));
			AddContractor_Pkg_Insurance_Enrollment_Page.textAreaBrieflyDescribetheScopeWork(driver).sendKeys("Testing");

			js.executeScript("arguments[0].click();",
					AddContractor_Pkg_Insurance_Enrollment_Page.markAsConfirmedRadioBtn(driver));
			test.log(LogStatus.INFO, "Clicked On Contract Details Mark As Confirmed Radio Button");

			AddContractor_Pkg_Insurance_Enrollment_Page.fieldLocationNumber(driver).clear();
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldLocationNumber(driver)
					.sendKeys(RandomClass.randomDivisionCode());

			js.executeScript("arguments[0].click();",
					AddContractor_Pkg_Insurance_Enrollment_Page.btnSaveAndContinue(driver));
			test.log(LogStatus.PASS, "Clicked On Contract Details Save And Continue Button");
			Thread.sleep(4000);

			int x = 1;
			do {
				try {
					AddContractor_Pkg_Insurance_Enrollment_Page.locationCodeDuplicateAlertOKBtn(driver).click();
					Thread.sleep(1000);
					Random ran = new Random();
					int rNo = ran.nextInt(100000);
					String NewLocationCode = "LOC" + rNo;
					Thread.sleep(1000);
					AddContractor_Pkg_Insurance_Enrollment_Page.fieldLocationNumber(driver).clear();
					Thread.sleep(1000);
					AddContractor_Pkg_Insurance_Enrollment_Page.fieldLocationNumber(driver).sendKeys(NewLocationCode);
					js.executeScript("arguments[0].click();",
							AddContractor_Pkg_Insurance_Enrollment_Page.btnSaveAndContinue(driver));
					test.log(LogStatus.PASS, "Clicked On Contract Details Save And Continue Button");
					Thread.sleep(2000);
				} catch (Throwable e) {
					System.out.println("Alert Not Present" + e);
					x = 2;
				}
			} while (x == 1);

			/*
			 * AddContractor_Pkg_Insurance_Enrollment_Page.alertCVtoPayroll(
			 * driver).click(); Thread.sleep(2000);
			 * 
			 * AddContractor_Pkg_Insurance_Enrollment_Page.
			 * alertUncappedPayrolToWorkclassUncappedPayroll(driver).click();
			 * Thread.sleep(2000); AddContractor_Pkg_Insurance_Enrollment_Page.
			 * alertCappedPayrolToWorkclassCappedPayroll(driver).click();
			 */

			Thread.sleep(9000);
			
		} catch (Throwable e) {
			System.out.println(e);
		}

		// sub contractor page come before the documents page
		wb.waitForElemnet(AddContractor_Pkg_SubContractorInfo.btnSaveAndContinue(driver));
		// AddContractor_Pkg_SubContractorInfo.btnSaveAndContinue(driver).click();
		Thread.sleep(5000);

		//Documents page
		String docName=AddContractor_Pkg_Required_Documents_Page.signEnrollmentDocumentLink(driver).getText();
		if(docName.contains("Signed Enrollment Form"))
		{
			System.out.println(docName+ "Document Name Pass");
		}else
		{
			System.err.println(docName+ "Document Name is not matched");
		}
		
		js.executeScript("arguments[0].click();", AddContractor_Pkg_Required_Documents_Page.btnSaveAndContinue(driver));
		test.log(LogStatus.INFO, "Clicked On required Documents Save And Continue Button");
		
		//Osha EMR Page
		try {
			AddContractor_Pkg_OSHA_EMR_Page.checkBoxA(driver).click();
			js.executeScript("window.scrollBy(0,2000)");
			js.executeScript("arguments[0].click();", AddContractor_Pkg_OSHA_EMR_Page.radioBtnMarkAsConfirmed(driver));
			js.executeScript("arguments[0].click();", AddContractor_Pkg_OSHA_EMR_Page.btnSaveAndContinue(driver));

		} catch (Throwable e) {
			System.out.println(e);
		}
		try {
			wb.mouseMoveToElement(AddContractor_Pkg_Enrollment_Summary_Page
					.checkBoxEnrollmentSummaryPageFinalTermsAndCondition(driver));
			test.log(LogStatus.PASS, "Enrollment Summary Final Terms And Condition Check Box Selected ");

		} catch (Throwable e) {

			System.out.println(e);
		}

		js.executeScript("arguments[0].click();",
				AddContractor_Pkg_Enrollment_Summary_Page.btnEnrollmentSummaryPageConfirmAndContinue(driver));
		test.log(LogStatus.INFO, "Clicked On Enrollment Summary Confirm And Continue Button");

		try {

			wb.mouseMoveToElement(
					AddContractor_Pkg_Insurance_Enrollment_Page.sendEmailBtnContinueWithoutSending(driver));
		} catch (Throwable e) {
			System.out.println(e);
		}
		try {
			js.executeScript("arguments[0].click();",
					AddContractor_Pkg_Enrollment_Summary_Page.checkBoxEnrollmentSummaryPageAcceptNoLossStmt(driver));
			js.executeScript("arguments[0].click();",
					AddContractor_Pkg_Enrollment_Summary_Page.btnEnrollmentSummaryPageAcceptNoLossStmt(driver));
			wb.mouseMoveToElement(
					AddContractor_Pkg_Insurance_Enrollment_Page.sendEmailBtnContinueWithoutSending(driver));
			// wb.mouseMoveToElement(AddContractor_Pkg_Insurance_Enrollment_Page.sendEmailBtnContinueWithoutSending(driver));
			Thread.sleep(6000);
			js.executeScript("window.scrollBy(0,1500)");

		} catch (Throwable e) {
			System.out.println(e);
		}

		wb.waitForElemnet(
				AddContractor_Pkg_Enrollment_Summary_Page.btnEnrollmentConfirmationPageFinishAndClose(driver));
		test.log(LogStatus.PASS, "Clicked On Enrollent Confirmation Page Finish And Close");
		test.log(LogStatus.PASS, "Contractor Package Enrolled Successfully");
		driver.switchTo().window(wb.map.get("parentID"));

	}
}
