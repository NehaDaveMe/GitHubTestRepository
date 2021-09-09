/**
 * 
 */
package ModulerLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;
import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import ObjectRepository_NCP.EnrollCP_Enrollment_Page;

/**
 * @author KiranP
 *
 */
public class NCP_EnrollContractorPkg_Pages_Action extends BaseClass {
	WebDriverCommonLib wb = new WebDriverCommonLib();
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public static void myCompanyInformationPage(WebDriver driver, String dba) throws Throwable {
		WebDriverCommonLib wb = new WebDriverCommonLib();
		test.log(LogStatus.INFO, " -----------------My Company Information Page Open------------------");
		// my company info page
		EnrollCP_Enrollment_Page.addNewContractorDBALink(driver).click();
		test.log(LogStatus.PASS, " Clicked Add New DBA link");
		Thread.sleep(1000);
		EnrollCP_Enrollment_Page.addNewDBAField(driver).click();
		test.log(LogStatus.PASS, " Clicked on add new DBA Field");
		EnrollCP_Enrollment_Page.addNewDBAField(driver).sendKeys(dba);
		test.log(LogStatus.PASS, " DBA Added Successfully");
		EnrollCP_Enrollment_Page.addNewDBASaveBtn(driver).click();
		test.log(LogStatus.PASS, " Clicked on DBA Save Button");
		// Thread.sleep(1500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].click();", EnrollCP_Enrollment_Page.EMR_Field(driver));
			// EnrollCP_Enrollment_Page.EMR_Field(driver).click();
			Thread.sleep(1000);
			EnrollCP_Enrollment_Page.EMR_Field(driver).clear();
			EnrollCP_Enrollment_Page.EMR_Field(driver).sendKeys("10");
			test.log(LogStatus.PASS, " EMR Added Successfully");
			EnrollCP_Enrollment_Page.EMR_EndDateField(driver).click();
			Thread.sleep(700);
			EnrollCP_Enrollment_Page.EMR_EndDateField(driver).sendKeys("12/15/2022");
			test.log(LogStatus.PASS, " End Date Added Successfully");
		
		} catch (Throwable e) {
			System.out.println("Emr is not presnt "+e);
		}
		
		//now jv bydefault selected
		/*EnrollCP_Enrollment_Page.legalStatusField(driver).click();
		Thread.sleep(1000);
		wb.selectSingleValueFromList(EnrollCP_Enrollment_Page.selectLegalStatus(driver), "Joint Venture");
		test.log(LogStatus.PASS, " Select Legarl Status Joint Venture From DropDown");*/
		
		Thread.sleep(1500);
		EnrollCP_Enrollment_Page.btnContinue(driver).click();
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		test.log(LogStatus.INFO, " -----------------My Company Information Page Closed------------------");
	}

	public static void contactInformationPage(WebDriver driver) throws Throwable {
		WebDriverCommonLib wb = new WebDriverCommonLib();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		test.log(LogStatus.INFO, " -----------------Contract Information Page Open------------------");
		// Contact Information Page
		js.executeScript("arguments[0].click();", EnrollCP_Enrollment_Page.sameAsPrimaryContactCheckBox(driver));
		test.log(LogStatus.PASS, " Same As Primary Contact Check box selected successfully");

		js.executeScript("arguments[0].click();", EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		Thread.sleep(3000);
		test.log(LogStatus.INFO, " -----------------Contract Information Page Closed------------------");

	}

	public static void contactDetailsPage(WebDriver driver, String startDate) throws Throwable {
		WebDriverCommonLib wb = new WebDriverCommonLib();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		test.log(LogStatus.INFO, " -----------------Contract Details Page Open------------------");
		
		// Contract Details Page
		EnrollCP_Enrollment_Page.contractPriceField(driver).clear();
		Thread.sleep(500);
		EnrollCP_Enrollment_Page.contractPriceField(driver).sendKeys("6100000");
		test.log(LogStatus.PASS, " Contract Value Added Successfully");

		EnrollCP_Enrollment_Page.selefPerformContractValue(driver).clear();
		Thread.sleep(500);
		EnrollCP_Enrollment_Page.selefPerformContractValue(driver).sendKeys("610000");
		test.log(LogStatus.PASS, " Self Perform Contract Value Added Successfully");
		Thread.sleep(1500);

		EnrollCP_Enrollment_Page.estimatedManhours(driver).clear();
		Thread.sleep(500);
		EnrollCP_Enrollment_Page.estimatedManhours(driver).sendKeys("6100.00");
		test.log(LogStatus.PASS, " Estimated Hours Added Successfully");

		try {
			EnrollCP_Enrollment_Page.estimatedUncappedPayroll(driver).clear();
			EnrollCP_Enrollment_Page.estimatedUncappedPayroll(driver).sendKeys("960000", Keys.TAB);
			test.log(LogStatus.PASS, " Uncapped Payroll Added Successfully");
		} catch (Throwable e) {
			System.out.println(e);
		}

		// alert occurred First time if payroll is outside the cv %
		try {
			EnrollCP_Enrollment_Page.CVtoPayrollRatio_Alert_LetContinueBtn(driver).click();
			Thread.sleep(2000);
			test.log(LogStatus.PASS, " click on Alert Continue");
		} catch (Throwable e) {
			System.out.println(e);
		}

		// start date
		js.executeScript("arguments[0].scrollIntoView();", EnrollCP_Enrollment_Page.estimatedStartDate(driver));
		EnrollCP_Enrollment_Page.estimatedStartDate(driver).clear();
		EnrollCP_Enrollment_Page.estimatedStartDate(driver).sendKeys(startDate);
		Thread.sleep(1000);
		test.log(LogStatus.PASS, " Estimated Strt Date Added Successfully");
//		EnrollCP_Enrollment_Page.estimatedStartDate(driver).sendKeys(Keys.TAB);

		// End date
		// js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.estimatedEndDate(driver));
		// EnrollCP_Enrollment_Page.estimatedEndDate(driver).click();
		Thread.sleep(1000);
		EnrollCP_Enrollment_Page.estimatedEndDate(driver).clear();
		EnrollCP_Enrollment_Page.estimatedEndDate(driver).sendKeys("11/10/2023");
		Thread.sleep(1000);
		EnrollCP_Enrollment_Page.estimatedEndDate(driver).sendKeys(Keys.TAB);
		test.log(LogStatus.PASS, " Estimated End Date Added Successfully");
		// type of contract
		EnrollCP_Enrollment_Page.selectUnitCostSwitch(driver).click();
		Thread.sleep(1000);
		EnrollCP_Enrollment_Page.selectFixedCostSwitch(driver).click();
		test.log(LogStatus.PASS, " Fixed Cost Switch Selected Successfully");
		// Scope of work
		EnrollCP_Enrollment_Page.ScopeOfWorkTestArea(driver).sendKeys("Testing scope of Work");
		test.log(LogStatus.PASS, " Scope of Work Description Added Successfully");
		Thread.sleep(1500);
		js.executeScript("arguments[0].click();", EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		Thread.sleep(4000);
		test.log(LogStatus.INFO, " -----------------Contract Details Page Closed------------------");
	}

	public static void workClassPage(WebDriver driver) throws Throwable {
		
		WebDriverCommonLib wb = new WebDriverCommonLib();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		test.log(LogStatus.INFO, " -----------------Work Class Page Open------------------");
		// Add Work Class
	/*	js.executeScript("arguments[0].click();", EnrollCP_Enrollment_Page.btnAddWorkClass(driver));
		test.log(LogStatus.PASS, " Clicked on Add Work Class Button");
		Thread.sleep(4000);*/
		
		EnrollCP_Enrollment_Page.WCClassCodeField(driver).sendKeys("Test");
		test.log(LogStatus.PASS, " Work Class Selected Successfully");
		Thread.sleep(2500);
		EnrollCP_Enrollment_Page.WCClassCodeField(driver).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		try {
			//accept the alert project located
			driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		} catch (Throwable e) {
			// TODO: handle exception
		}Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", EnrollCP_Enrollment_Page.WCHoursField(driver));
		EnrollCP_Enrollment_Page.WCHoursField(driver).click();
		EnrollCP_Enrollment_Page.WCHoursField(driver).sendKeys("150");
		EnrollCP_Enrollment_Page.WCHoursField(driver).sendKeys(Keys.TAB);
		test.log(LogStatus.PASS, " Work Hours Added Successfully");
		try {
			EnrollCP_Enrollment_Page.WCUncappedPayrollField(driver).sendKeys("15000");
			Thread.sleep(500);
			EnrollCP_Enrollment_Page.WCUncappedPayrollField(driver).sendKeys(Keys.TAB);
			test.log(LogStatus.PASS, " Work Class Uncapped Payroll Added Successfully");
		} catch (Throwable e) {
			System.out.println(e);
		}
		try {
			EnrollCP_Enrollment_Page.WCCappedPayrollField(driver).sendKeys("15000");
			Thread.sleep(500);
			EnrollCP_Enrollment_Page.WCCappedPayrollField(driver).sendKeys(Keys.TAB);
			Thread.sleep(2000);
			test.log(LogStatus.PASS, " Work Class Capped Payroll Added Successfully");
		} catch (Throwable e) {
			System.out.println(e);
		}
		EnrollCP_Enrollment_Page.WCRateField(driver).sendKeys("14");
		test.log(LogStatus.PASS, " Work Class Rate Added Successfully");
		
		js.executeScript("arguments[0].click();", EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		Thread.sleep(3000);

		try {
			//occur for estimated uncapped and total uncapped is not same 
			EnrollCP_Enrollment_Page.CVtoPayrollRatio_Alert_LetContinueBtn(driver).click();
			test.log(LogStatus.PASS, " Uncapped Alert Accepted");
		} catch (Throwable e) {
			System.out.println("Alert Not Present" + e);
		}
		Thread.sleep(3000);

		try {
			//occur for estimated capped and total capped is not same 
			EnrollCP_Enrollment_Page.CVtoPayrollRatio_Alert_LetContinueBtn(driver).click();
			test.log(LogStatus.PASS, " Capped Alert Accepted");
		} catch (Throwable e) {
			System.out.println("Alert Not Present" + e);
		}
		Thread.sleep(5000);
		wb.waitForCompletePageLoad(driver);//we pass 30 sec only
		js.executeScript("arguments[0].scrollIntoView();", EnrollCP_Enrollment_Page.btnContinue(driver));
		js.executeScript("arguments[0].click();", EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		test.log(LogStatus.INFO, " -----------------Work Class Page Closed------------------");
	}

	public static void premiumModificationPage(WebDriver driver) {
		//worker compensation page
		WebDriverCommonLib wb = new WebDriverCommonLib();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		test.log(LogStatus.INFO, " -----------------Premium Modification Page Open------------------");
		wb.waitForCompletePageLoad(driver);
		js.executeScript("arguments[0].scrollIntoView();", EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Premium Modification Page Continue Button");
		js.executeScript("arguments[0].click();", EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		test.log(LogStatus.INFO, " -----------------Premium Modification Page Closed------------------");
		
	}
	
	public static void generalLiabilityPage(WebDriver driver, int GL_NO) throws Throwable {

		WebDriverCommonLib wb = new WebDriverCommonLib();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		test.log(LogStatus.INFO, " -----------------General Liability Page Open------------------");
		wb.waitForCompletePageLoad(driver);
//GL Page
		
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_Enrollment_Page.selectGLClassCode(driver, GL_NO));
		EnrollCP_Enrollment_Page.selectGLClassCode(driver, GL_NO).click();
		test.log(LogStatus.PASS, " Clicked on GL Class Code Field");
		Thread.sleep(1000);
		wb.selectSingleValueFromList(EnrollCP_Enrollment_Page.selectGLClassCodeFromList(driver, GL_NO), "Airport runaway");
		test.log(LogStatus.PASS, " GL Class Code Selected Successfully");
	
		EnrollCP_Enrollment_Page.glSIRLossChargeField(driver).click();
		EnrollCP_Enrollment_Page.glSIRLossChargeField(driver).sendKeys("100");
		test.log(LogStatus.PASS, " GL Sir Loss Charge Added Successfully");
		
		EnrollCP_Enrollment_Page.glDeductibleField(driver).click();	
		EnrollCP_Enrollment_Page.glDeductibleField(driver).sendKeys("100");
		test.log(LogStatus.PASS, " GL Deductible Added Successfully");
		
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));		
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		Thread.sleep(13000);
		test.log(LogStatus.INFO, " -----------------General Liability Page Closed------------------");
	}
	
	public static void umbrellExxcessLiabilityPage(WebDriver driver, int umb_Code) throws Throwable {

		WebDriverCommonLib wb = new WebDriverCommonLib();
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		wb.waitForCompletePageLoad(driver);
		Thread.sleep(1000);
		test.log(LogStatus.INFO, " -----------------UMB/Excess Liability Page Open------------------");
//		js.executeScript("window.scrollBy(0,250)", "");
		js.executeScript("arguments[0].scrollIntoView();", EnrollCP_Enrollment_Page.selectUMBClassCode(driver, umb_Code));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", EnrollCP_Enrollment_Page.selectUMBClassCode(driver, umb_Code));// 06/02/2021
		Thread.sleep(2500);
		test.log(LogStatus.PASS, " Clicked on UMB Class Code Field");
		wb.selectSingleValueFromList(EnrollCP_Enrollment_Page.selectUMBClassCodeFromList(driver,umb_Code ), "Airport runaway");
		test.log(LogStatus.PASS, " UMB Class Code Selected Successfully");

		js.executeScript("arguments[0].scrollIntoView();", EnrollCP_Enrollment_Page.btnContinue(driver));
		js.executeScript("arguments[0].click();", EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		Thread.sleep(9000);
		
		test.log(LogStatus.INFO, " -----------------UMB/Excess Liability Page Closed------------------");
	}

	public static void pollutionLiabilityPage(WebDriver driver, int polNo) throws Throwable {

		WebDriverCommonLib wb = new WebDriverCommonLib();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wb.waitForCompletePageLoad(driver);
		test.log(LogStatus.INFO, " -----------------Pollution Liability Page Open------------------");
//pollution
//		wb.waitForElemnet(EnrollCP_Enrollment_Page.selectPollClassCode(driver, polNo));
		js.executeScript("window.scrollBy(0,350)", "");
		js.executeScript("arguments[0].scrollIntoView();", EnrollCP_Enrollment_Page.selectPollClassCode(driver, polNo));
		EnrollCP_Enrollment_Page.selectPollClassCode(driver, polNo).click();
		test.log(LogStatus.PASS, " Clicked on POll Class Code Field");
		Thread.sleep(1000);
		wb.selectSingleValueFromList(EnrollCP_Enrollment_Page.selectPollClassCodeFromList(driver, polNo),
				"Airport runaway");
		test.log(LogStatus.PASS, " Poll Class Code Selected Successfully");
		js.executeScript("arguments[0].scrollIntoView();", EnrollCP_Enrollment_Page.btnContinue(driver));
		js.executeScript("arguments[0].click();", EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Continue Button");
//		Thread.sleep(9000);
		wb.waitForCompletePageLoad(driver);
		js.executeScript("arguments[0].scrollIntoView();", EnrollCP_Enrollment_Page.lookGoodContinueBtn(driver));
		EnrollCP_Enrollment_Page.lookGoodContinueBtn(driver).click();
		test.log(LogStatus.PASS, " Clicked on Looks Good Continue Button");
		Thread.sleep(5000);
		test.log(LogStatus.INFO, " -----------------Pollution Liability Page Closed------------------");
	}

	
	public static void subContractorPage(WebDriver driver) throws InterruptedException
	{
		WebDriverCommonLib wb = new WebDriverCommonLib();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wb.waitForCompletePageLoad(driver);
		test.log(LogStatus.INFO, " -----------------Sub Contractor Page open------------------");
		// sub Contractor
		EnrollCP_Enrollment_Page.subContractorCostNoBtn(driver).click();
		js.executeScript("arguments[0].click();", EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on SubContractor Continue Button");
//		Thread.sleep(3000);
		// sub summary page
		wb.waitForCompletePageLoad(driver);
		js.executeScript("arguments[0].scrollIntoView();", EnrollCP_Enrollment_Page.lookGoodContinueBtn(driver));
		js.executeScript("arguments[0].click();", EnrollCP_Enrollment_Page.lookGoodContinueBtn(driver));
		Thread.sleep(3000);
		test.log(LogStatus.PASS, " Clicked on Sub Summary Looks Good Continue Button");
		test.log(LogStatus.INFO, " -----------------Sub Contractor Page Closed------------------");
	}
	
	public static void doccumentsPage(WebDriver driver) throws InterruptedException
	{
		WebDriverCommonLib wb = new WebDriverCommonLib();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wb.waitForCompletePageLoad(driver);
		test.log(LogStatus.INFO, " -----------------Documents Page Open------------------");
		// Documents
		Thread.sleep(2000);
		String docName = driver
				.findElement(By.xpath("//h5[contains(text(),'Optional Documents')]/../../div[2]//i/../../div"))
				.getText();
		System.out.println("Doc name is " + docName);
		if (docName.contains("Signed Enrollment Form")) {
			test.log(LogStatus.PASS, " Signed Enrollment Form Document is Present");

		} else {
			test.log(LogStatus.FAIL, " Signed Enrollment Form Document is not Present");
		}

		js.executeScript("arguments[0].click();", EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Documents Continue Button");
		Thread.sleep(3000);
		try {
			//two time document continue is occurred
			js.executeScript("arguments[0].click();", EnrollCP_Enrollment_Page.btnContinue(driver));
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		Thread.sleep(2000);
		test.log(LogStatus.INFO, " -----------------Documents Page Closed------------------");
	}
	
	public static void reviewEnrollmentPage(WebDriver driver) throws InterruptedException
	{
		WebDriverCommonLib wb = new WebDriverCommonLib();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wb.waitForCompletePageLoad(driver);
		test.log(LogStatus.INFO, " -----------------Review Enrollment Page Open------------------");
		
//		driver.findElement(By.xpath("//a[contains(text(),'Check my info')]")).click();//check my info button
		try {
			js.executeScript("arguments[0].click();", EnrollCP_Enrollment_Page.btnContinue(driver));
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		Thread.sleep(5000);
		
		//Agreement and confirmation page
		wb.waitForCompletePageLoad(driver);
		try {
			EnrollCP_Enrollment_Page.cipAgreementConfirmationSubmitDegitalEnrollmentButton(driver).click();
			Thread.sleep(8000);
		} catch (Throwable e) {
			System.out.println(e);
		}
		Thread.sleep(5000);
		//Thanks for confirming! page
//		wb.waitForElementTOBeClickble(EnrollCP_Enrollment_Page.CompleteBtn(driver));
		js.executeScript("arguments[0].scrollIntoView();", EnrollCP_Enrollment_Page.CompleteBtn(driver));
		EnrollCP_Enrollment_Page.CompleteBtn(driver).click();
		test.log(LogStatus.PASS, " Clicked Complete Button");
		test.log(LogStatus.PASS, " Contractor Package Enrolled Successfully");
		test.log(LogStatus.INFO, " -----------------Review Enrollment Page Closed------------------");
	}
	
	
	

}
