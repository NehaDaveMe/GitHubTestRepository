package TestScript;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
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
import ObjectRepository.AddContractor_Pkg_WC_Premiums_Modifications_Page;
import ObjectRepository.AddProject_General_Information_Page;
import ObjectRepository.AddTradePage;
import ObjectRepository.ContractorPackageModule;
import ObjectRepository.HomePage;
import ObjectRepository.ProjectModule;

public class Enroll_CP_WC_Only extends BaseClass 
{
	
	WebDriverCommonLib wb = new WebDriverCommonLib();
	public String contractorName = "Alex Comp3524";
	public String projectName = "Sony Projects3524";
	String programName = "Sony Programs3524";// "Sony Tower One Prog";
	String contractorCompany = "Alex Comp3524";// "sony";
	String contactName = "Jimmy Smith";
	
	public String tradeNumber = RandomClass.randomTradeNO();
	public String insuranceCompName = "Carriers3524";
	public String submissionFrequency = "Quarterly";
	public String reportTime = "Quarterly";
	public String contractorPKGno = RandomClass.randomContractorPkgNo();
	public String EnrollmentType = "WC Only Enrollment";
	
	
	@Test
	public void enrollContractor_Pkg_WC_OnlyTest() throws InterruptedException, IOException {
		WebDriverWait webwait = new WebDriverWait(driver, 60);
		
		WPO_AddContractorPkgAction.add_ContractorPkg(contractorName, projectName, programName, contractorCompany,
				contactName, tradeNumber, contractorPKGno, insuranceCompName, submissionFrequency, reportTime,
				EnrollmentType);
		HomePage.controlMenuHomeIcon(driver).click();
		test.log(LogStatus.INFO, "Clicked On Home Icon");
		HomePage.HomeMenuContractorPackage(driver).click();
		test.log(LogStatus.INFO, "Clicked On Contracotr Package Icon");
		// Thread.sleep(10000);
		wb.waitForElemnet(ContractorPackageModule.searchEditBox(driver));
		JavascriptExecutor js = (JavascriptExecutor) driver;
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
			
			/*AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedCappedPayroll(driver).clear();
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedCappedPayroll(driver).sendKeys("100000");
			test.log(LogStatus.PASS, "Estimated Uncapped Payroll Added Successfully");
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedUncappedPayroll(driver).clear();
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedUncappedPayroll(driver).sendKeys("100000");
			test.log(LogStatus.PASS, "Estimated Capped Payroll Added Successfully");*/
			try {
				AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedCappedPayroll(driver).clear();
				AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedCappedPayroll(driver).sendKeys("100000");
				test.log(LogStatus.PASS, "Estimated Uncapped Payroll Added Successfully");
			} catch (Throwable e) {
				System.out.println("Exception in Uncapped payroll"+e);
			}
			
			try {
				AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedUncappedPayroll(driver).clear();
				AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedUncappedPayroll(driver).sendKeys("100000");
				test.log(LogStatus.PASS, "Estimated Capped Payroll Added Successfully");

			} catch (Throwable e) {
				System.out.println("Exception in Capped payroll"+e);
			}
			
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedManHours(driver).clear();
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedManHours(driver).sendKeys("1000");
			test.log(LogStatus.PASS, "Estimated Man Hours Added Successfully");
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedStartDate(driver).clear();
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedStartDate(driver).sendKeys("09/02/2019",
					Keys.TAB);
			test.log(LogStatus.PASS, "Estimated Start Date Added Successfully");
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedCompletionDate(driver).clear();
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldEstimatedCompletionDate(driver).sendKeys("12/31/2020",
					Keys.TAB);
			test.log(LogStatus.PASS, "Estimated Completion Date Added Successfully");

			System.out.println("Program Radio Button is Selected \t"
					+ AddContractor_Pkg_Insurance_Enrollment_Page.redioBtnProgram(driver).isSelected());

			js.executeScript("arguments[0].click();",
					AddContractor_Pkg_Insurance_Enrollment_Page.textAreaBrieflyDescribetheScopeWork(driver));
			AddContractor_Pkg_Insurance_Enrollment_Page.textAreaBrieflyDescribetheScopeWork(driver).sendKeys("Testing");
			
			js.executeScript("arguments[0].scrollIntoView();",AddContractor_Pkg_Insurance_Enrollment_Page.selectWorkClass(driver));
			wb.waitForElemnet(AddContractor_Pkg_Insurance_Enrollment_Page.selectWorkClass(driver));
			Thread.sleep(4000);
			AddContractor_Pkg_Insurance_Enrollment_Page.selectWorkClassSearchBox(driver).sendKeys("Test");
			wb.selectSingleValueFromList(
					AddContractor_Pkg_Insurance_Enrollment_Page.selectAllWorkClassFromAutoCompleteDropDown(driver),
					"Test");
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Work Class Selected Successfully");
			// wb.selectSingleValueFromList(AddContractor_Pkg_Insurance_Enrollment_Page.selectAllWorkClassFromAutoCompleteDropDown(driver),"Technicians");
		
			
			try {
				AddContractor_Pkg_Insurance_Enrollment_Page.cappedPayrollAlertOkBtn(driver).click();
				Thread.sleep(1500);
			} catch (Throwable e) {
				System.out.println("Capped Alert is not present Exception" +e);
			}
			// wb.selectSingleValueFromList(AddContractor_Pkg_Insurance_Enrollment_Page.selectAllWorkClassFromAutoCompleteDropDown(driver),"Technicians");
			AddContractor_Pkg_Insurance_Enrollment_Page.addWorkClassWorkHoursField(driver).sendKeys("100");
			test.log(LogStatus.PASS, "Work Class Hours Added Successfully");
			
			try {
				AddContractor_Pkg_Insurance_Enrollment_Page.addWorkClassUnCappedPayrollField(driver).sendKeys("5000");
				test.log(LogStatus.PASS, "Work Class Uncapped Payroll Added Successfully");
			} catch (Throwable e) {
				System.out.println("Exception in Uncapped payroll"+e);
			}
		
			try {
				AddContractor_Pkg_Insurance_Enrollment_Page.addWorkClassCappedPayrollField(driver).sendKeys("5000");
				test.log(LogStatus.PASS, "Work Class Capped Payroll Added Successfully");

			} catch (Throwable e) {
				System.out.println("Exception in Capped payroll"+e);
			}			
			
/*			AddContractor_Pkg_Insurance_Enrollment_Page.addWorkClassWorkHoursField(driver).sendKeys("100");
			test.log(LogStatus.PASS, "Work Class Hours Added Successfully");
			AddContractor_Pkg_Insurance_Enrollment_Page.addWorkClassUnCappedPayrollField(driver).sendKeys("5000");
			test.log(LogStatus.PASS, "Work Class Uncapped Payroll Added Successfully");
			AddContractor_Pkg_Insurance_Enrollment_Page.addWorkClassCappedPayrollField(driver).sendKeys("5000");
			test.log(LogStatus.PASS, "Work Class Capped Payroll Added Successfully");
*/
			AddContractor_Pkg_Insurance_Enrollment_Page.addWorkClassRateField(driver).sendKeys("15");
			test.log(LogStatus.PASS, "Work Class Rate Added Successfully");
			js.executeScript("arguments[0].click();",
					AddContractor_Pkg_Insurance_Enrollment_Page.addWorkClassAddWorkClassBtn(driver));
			test.log(LogStatus.INFO, "Clicked On Add Work Class Button");
			Thread.sleep(10000);
			js.executeScript("arguments[0].click();",
					AddContractor_Pkg_Insurance_Enrollment_Page.markAsConfirmedRadioBtn(driver));
			test.log(LogStatus.INFO, "Clicked On Contract Details Mark As Confirmed Radio Button");
				
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldLocationNumber(driver).clear();
			AddContractor_Pkg_Insurance_Enrollment_Page.fieldLocationNumber(driver)
					.sendKeys(RandomClass.randomDivisionCode());

			js.executeScript("arguments[0].click();",
					AddContractor_Pkg_Insurance_Enrollment_Page.btnSaveAndContinue(driver));
			test.log(LogStatus.PASS, "Clicked On Contract Details Save And Continue Button");
			Thread.sleep(3500);
		
		} catch (Throwable e) {
			System.out.println(e);
		}
			int x = 1;
			do {
				try {
					AddContractor_Pkg_Insurance_Enrollment_Page.locationCodeDuplicateAlertOKBtn(driver).click();
					Thread.sleep(2000);
					Random ran = new Random();
					int rNo = ran.nextInt(100000);
					String NewLocationCode = "LOC" + rNo;
					Thread.sleep(1000);
					AddContractor_Pkg_Insurance_Enrollment_Page.fieldLocationNumber(driver).clear();
					Thread.sleep(1000);
					AddContractor_Pkg_Insurance_Enrollment_Page.fieldLocationNumber(driver)
							.sendKeys(NewLocationCode);
					js.executeScript("arguments[0].click();",
							AddContractor_Pkg_Insurance_Enrollment_Page.btnSaveAndContinue(driver));
					test.log(LogStatus.PASS, "Clicked On Contract Details Save And Continue Button");
					Thread.sleep(2000);
				} catch (Throwable e) {
					System.out.println("Alert Not Present" + e);
					x = 2;
				}
			} while (x == 1);			
			
			
			
			
			try {
				// first common alert handled
				AddContractor_Pkg_Insurance_Enrollment_Page.alertCoomman(driver).click();
				Thread.sleep(2000);
			} catch (Throwable e) {
				System.out.println("Alert issue  " + e);
			}

			try {
				AddContractor_Pkg_Insurance_Enrollment_Page.alertCVtoPayroll(driver).click();
				Thread.sleep(2000);
			} catch (Throwable e) {
				System.out.println("Alert issue  " + e);
			}

			try {
				AddContractor_Pkg_Insurance_Enrollment_Page.alertUncappedPayrolToWorkclassUncappedPayroll(driver).click();
				Thread.sleep(2000);
			} catch (Throwable e) {
				System.out.println("Alert issue  " + e);
			}

			try {
				AddContractor_Pkg_Insurance_Enrollment_Page.alertCappedPayrolToWorkclassCappedPayroll(driver).click();
			} catch (Throwable e) {
				System.out.println("Alert issue  " + e);
			}

			Thread.sleep(8000);

		// Thread.sleep(7000);
		js.executeScript("window.scrollBy(0,3500)");
		js.executeScript("arguments[0].scrollIntoView();",
				AddContractor_Pkg_WC_Premiums_Modifications_Page.markAsConfirmedRadioBtn(driver));
		AddContractor_Pkg_WC_Premiums_Modifications_Page.markAsConfirmedRadioBtn(driver).click();
		test.log(LogStatus.INFO, "Cliced On WC Premium Modification Page Mark As Confirmed Radio Button ");
		js.executeScript("window.scrollBy(0,1000)");
		AddContractor_Pkg_WC_Premiums_Modifications_Page.btnSaveAndContinue(driver).click();
		test.log(LogStatus.INFO, "Clicked On WC Premium Modificaction Page Save And Continue Button");
		Thread.sleep(5000);

		Thread.sleep(6000);

//sub contractor page come before the documents page
		wb.waitForElemnet(AddContractor_Pkg_SubContractorInfo.btnSaveAndContinue(driver));
		// AddContractor_Pkg_SubContractorInfo.btnSaveAndContinue(driver).click();
		Thread.sleep(5000);

//Document Page		
		AddContractor_Pkg_Required_Documents_Page.btnAddNewDocument(driver).click();
		test.log(LogStatus.PASS, "Clicked on Add Document Button");
		List<WebElement> checkBoxCount = AddContractor_Pkg_Required_Documents_Page
				.selectAllDocumentcheckBoxWhatAreYouUploadingPage(driver);

		for (int i = 0; i < checkBoxCount.size(); i++) {
			checkBoxCount.get(i).click();
			Thread.sleep(500);
		}
		test.log(LogStatus.PASS, "Document Checkbox selected Successfully");
		js.executeScript("window.scrollBy(0,150)", "");
		js.executeScript("arguments[0].click();",
				AddContractor_Pkg_Required_Documents_Page.clickHereToUploadManualyLink(driver));
		test.log(LogStatus.PASS, "Clicked on Click Here to upload manually Link ");
		AddContractor_Pkg_Required_Documents_Page.addDocNameOfTheFileField(driver).sendKeys("TestFile");
		test.log(LogStatus.PASS, "Document Name Added Successfully");
		AddContractor_Pkg_Required_Documents_Page.addDocPlusBtn(driver).click();
		test.log(LogStatus.PASS, "Clicked on Add Document Plus Button");
		
		Thread.sleep(3000);
		// add file through AutoIT
		Runtime.getRuntime().exec("./AutoIT Script/FileUpload.exe");
		test.log(LogStatus.PASS, "Documnet Added Successfully");
		Thread.sleep(5000);
		AddContractor_Pkg_Required_Documents_Page.addDocAddBtn(driver).click();
		test.log(LogStatus.PASS, "Clicked on Alert Add Document Button");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,250)", "");
		js.executeScript("arguments[0].click();",
				AddContractor_Pkg_Required_Documents_Page.markedAsConfirmedRadioBtn(driver));
		// js.executeScript("arguments[0].click();",AddContractor_Pkg_Required_Documents_Page.addDocsaveAndCloseBtn(driver));
		test.log(LogStatus.PASS, "Clicked on Mark As Confirmed");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,350)", "");
		js.executeScript("arguments[0].click();",
				AddContractor_Pkg_Required_Documents_Page.addDocsaveAndContinueBtn(driver));
		test.log(LogStatus.PASS, "Clicked on Save And Continue button");
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", AddContractor_Pkg_Required_Documents_Page.btnSaveAndContinue(driver));
		test.log(LogStatus.INFO, "Clicked On required Documents Save And Continue Button");

		try {
			Alert alert2 = driver.switchTo().alert();
			alert2.accept();
			Thread.sleep(3000);

		} catch (Throwable e) {
			System.out.println(e);
		}

		try {

			wb.mouseMoveToElement(
					AddContractor_Pkg_Insurance_Enrollment_Page.sendEmailBtnContinueWithoutSending(driver));
		} catch (Throwable e) {
			System.out.println(e);
		}

		Thread.sleep(6000);
		js.executeScript("window.scrollBy(0,4000)");
		
// Osha EMR Page
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
