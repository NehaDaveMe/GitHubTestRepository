package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.RandomClass;
import ModulerLibrary.NCP_LoginAction;
import ModulerLibrary.WPO_AddContractorPkgAction;
import ObjectRepository_NCP.EnrollCP_Enrollment_Page;
import ObjectRepository_NCP.NCP_HomePage;

public class Exclude_CP_NCP_DocumentSignTest extends BaseClass
{
	
	
	
	WebDriverCommonLib wb = new WebDriverCommonLib();
	// AddContractor_Pkg_TC tc = new AddContractor_Pkg_TC();
	public String contractorName = "Alex Comp2273";
	public String projectName = "Test Sony project Reg 123";// "Sony
															// Projects3524";
	public String programName = "Test Sony Program 123";// "Sony
														// Programs3524";//"Sony
														// Tower One Prog";
	public String contractorCompany = "Alex Comp2273";// "sony";
	public String contactName = "Jimmy Smith";
	public String tradeNumber = RandomClass.randomTradeNO();
	public String insuranceCompName = "Carriers3524";
	public String submissionFrequency = "Quarterly";
	public String reportTime = "Quarterly";
	public String contractorPKGno = RandomClass.randomContractorPkgNo();
	public String EnrollmentType = "Excluded Contractor";
	String dba = RandomClass.randomDBA();	
	public String uName="JimmySmith114211";
	public String password="uX6R1i0L7KxA";

//	Username: JimmySmith114211
//	Password: uX6R1i0L7KxA

	// span[contains(text(),'Renewal Contractor Off-Site COI')]/../div//input
	// span[contains(text(),'Signed Enrollment Form')]/../div//input

	@Test
	public void enrollContractor_Pkg_Excluded_NCPTest() throws Throwable {

		WPO_AddContractorPkgAction.add_ContractorPkg(contractorName, projectName, programName, contractorCompany,
				contactName, tradeNumber, contractorPKGno, insuranceCompName, submissionFrequency, reportTime,
				EnrollmentType);
		
		String BaseUrl=driver.getCurrentUrl();
		//login to the ncp
		NCP_LoginAction.logInNCPCommon(driver, uName, password);
	
		NCP_HomePage.btnFilterBy(driver).click();
		test.log(LogStatus.PASS, " Clicked On Filter Button");
		
		NCP_HomePage.selectProgramField(driver).click();
		test.log(LogStatus.PASS, " Clicked On Select Program Field");
		Thread.sleep(2000);
		wb.selectSingleValueFromList(NCP_HomePage.selectProgramFromList(driver),programName );
		test.log(LogStatus.PASS, programName+" Program Name successfully selected form drop down");
		Thread.sleep(2500);

		
		NCP_HomePage.selectProjectField(driver).click();
		test.log(LogStatus.PASS, " Clicked On Select Project Field");
		Thread.sleep(2000);
		wb.selectSingleValueFromList(NCP_HomePage.selectProjectFromList(driver),projectName );
		test.log(LogStatus.PASS, projectName+" Project Name successfully selected form drop down");
		Thread.sleep(2900);
		
		
		if(NCP_HomePage.selectUpperTierField(driver).isEnabled()==true)
		{
			test.log(LogStatus.PASS, " Upper Tier Field is enabled");
			System.out.println(" Upper Tier Field is enabled");
			Thread.sleep(1500);	
		}else
		{
			test.log(LogStatus.FAIL, " Upper Tier Field is not enabled");
			System.out.println(" Upper Tier Field is not enabled");
		}
		
		NCP_HomePage.selectTradeField(driver).click();
		test.log(LogStatus.PASS, " Clicked On Select Trade Field");
		Thread.sleep(1500);
		NCP_HomePage.searchForTradeField(driver).sendKeys("T");;
		Thread.sleep(1500);
		wb.selectSingleValueFromList(NCP_HomePage.selectTradeFromList(driver),tradeNumber);
		Thread.sleep(1500);
		System.out.println(tradeNumber);
		
		NCP_HomePage.selectEnrollmentTypeField(driver).click();
		wb.selectSingleValueFromList(NCP_HomePage.selectEnrollmentFromList(driver), "Excluded Contractor");
		
//		wb.selectSingleValueFromList(NCP_HomePage.selectTradeFromList(driver), tradeNumber);
		test.log(LogStatus.PASS, tradeNumber+" Trade successfully selected form drop down");
		Thread.sleep(2500);
		
		NCP_HomePage.btnSearch(driver).click();
		test.log(LogStatus.PASS, " Clicked on Search Button");
		Thread.sleep(2000);
		NCP_HomePage.selectPreviewPanelProjectDropdown(driver, projectName).click();
		test.log(LogStatus.PASS, " Clicked on Selected Contractor Package");
		Thread.sleep(1000);
		NCP_HomePage.selectEnrollmentTab(driver, "Enrollment").click();
		test.log(LogStatus.PASS, " Clicked on Enrollment View");
		Thread.sleep(3000);
//		EnrollCP_Enrollment_Page.CompanyInformationEditBtn(driver).click();
		
		try {
			EnrollCP_Enrollment_Page.cipAgreementContinueButton(driver).click();
		} catch (Throwable e) {
			System.out.println(e);
		}
		
		//Add New DBA
		EnrollCP_Enrollment_Page.addNewContractorDBALink(driver).click();
		test.log(LogStatus.PASS, " Clicked Add New DBA link");
		Thread.sleep(1000);
		EnrollCP_Enrollment_Page.addNewDBAField(driver).click();
		test.log(LogStatus.PASS, " Clicked on add new DBA Field");
		EnrollCP_Enrollment_Page.addNewDBAField(driver).sendKeys(dba);
		test.log(LogStatus.PASS, " DBA Added Successfully");
		EnrollCP_Enrollment_Page.addNewDBASaveBtn(driver).click();
		test.log(LogStatus.PASS, " Clicked on DBA Save Button");
		//Thread.sleep(1500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.EMR_Field(driver));
		test.log(LogStatus.PASS, " Clicked on DBA Save Button");
//		EnrollCP_Enrollment_Page.EMR_Field(driver).click();
		Thread.sleep(1000);
		EnrollCP_Enrollment_Page.EMR_Field(driver).clear();
		EnrollCP_Enrollment_Page.EMR_Field(driver).sendKeys("10");
		test.log(LogStatus.PASS, " EMR Added Successfully");
		EnrollCP_Enrollment_Page.EMR_EndDateField(driver).click();
		EnrollCP_Enrollment_Page.EMR_EndDateField(driver).sendKeys("12/15/2020");
		test.log(LogStatus.PASS, " End Date Added Successfully");
		EnrollCP_Enrollment_Page.legalStatusField(driver).click();
		wb.selectSingleValueFromList(EnrollCP_Enrollment_Page.selectLegalStatus(driver), "Joint Venture");
		test.log(LogStatus.PASS, " Select Legarl Status Joint Venture From DropDown");
		EnrollCP_Enrollment_Page.btnContinue(driver).click();
		test.log(LogStatus.PASS, " Clicked on Continue Button");
//Contact Information Page
		try {
			js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.sameAsPrimaryContactCheckBox(driver));
			test.log(LogStatus.PASS, " Same As Primary Contact Check box selected successfully");
			
		} catch (Throwable e) {
			System.out.println(e+"exception handeled ");
		}
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		Thread.sleep(3000);		
		
//Contract Details Page
		EnrollCP_Enrollment_Page.contractPriceField(driver).clear();
		EnrollCP_Enrollment_Page.contractPriceField(driver).sendKeys("6100000");
		test.log(LogStatus.PASS, " Contract Value Added Successfully");
		
		EnrollCP_Enrollment_Page.selefPerformContractValue(driver).clear();
		EnrollCP_Enrollment_Page.selefPerformContractValue(driver).sendKeys("610000");
		test.log(LogStatus.PASS, " Self Perform Contract Value Added Successfully");
		
		EnrollCP_Enrollment_Page.estimatedManhours(driver).clear();
		EnrollCP_Enrollment_Page.estimatedManhours(driver).sendKeys("6100");
		test.log(LogStatus.PASS, " Estimated Hours Added Successfully");
		
		try {
			EnrollCP_Enrollment_Page.estimatedUncappedPayroll(driver).clear();
			EnrollCP_Enrollment_Page.estimatedUncappedPayroll(driver).sendKeys("95500");
			EnrollCP_Enrollment_Page.estimatedUncappedPayroll(driver).sendKeys(Keys.TAB);
			test.log(LogStatus.PASS, " Uncapped Payroll Added Successfully");
		} catch (Throwable e) {
			System.out.println(e);
		}
		
/*		// alert occurred first time
		try {
			EnrollCP_Enrollment_Page.CVtoPayrollRatio_Alert_LetContinueBtn(driver).click();
			Thread.sleep(2000);
			test.log(LogStatus.PASS, " click on Alert Continue");
		} catch (Throwable e) {
			System.out.println(e);
		}

		// alert occurred second time
		try {
			EnrollCP_Enrollment_Page.CVtoPayrollRatio_Alert_LetContinueBtn(driver).click();
			Thread.sleep(2000);
			test.log(LogStatus.PASS, " click on Alert Continue");
		} catch (Throwable e) {
			System.out.println(e);
		}
		
		 * EnrollCP_Enrollment_Page.SPCVtoPayrollRatio_Alert_OKBtn(driver).click
		 * ();
		 
		try {
			EnrollCP_Enrollment_Page.estimatedCappedPayroll(driver).clear();
			EnrollCP_Enrollment_Page.estimatedCappedPayroll(driver).sendKeys("95500");
			test.log(LogStatus.PASS, " Capped Payroll Added Successfully");
		} catch (Throwable e) {
			System.out.println(e);
		}
		// EnrollCP_Enrollment_Page.estimatedCappedPayroll(driver).sendKeys(Keys.TAB);
*/		
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_Enrollment_Page.estimatedStartDate(driver));
		EnrollCP_Enrollment_Page.estimatedStartDate(driver).clear();
		EnrollCP_Enrollment_Page.estimatedStartDate(driver).sendKeys("01/02/2021");
		Thread.sleep(1000);
		test.log(LogStatus.PASS, " Estimated Strt Date Added Successfully");
		EnrollCP_Enrollment_Page.estimatedStartDate(driver).sendKeys(Keys.TAB);
		EnrollCP_Enrollment_Page.estimatedEndDate(driver).sendKeys("12/20/2023");
		Thread.sleep(1000);
		EnrollCP_Enrollment_Page.estimatedEndDate(driver).sendKeys(Keys.TAB);
		test.log(LogStatus.PASS, " Estimated End Date Added Successfully");
		EnrollCP_Enrollment_Page.selectUnitCostSwitch(driver).click();
		Thread.sleep(1000);
		EnrollCP_Enrollment_Page.selectFixedCostSwitch(driver).click();
		test.log(LogStatus.PASS, " Fixed Cost Switch Selected Successfully");
		EnrollCP_Enrollment_Page.ScopeOfWorkTestArea(driver).sendKeys("Testing scope of Work");
		test.log(LogStatus.PASS, " Scope of Work Description Added Successfully");
	
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		Thread.sleep(3000);

		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		Thread.sleep(3000);

/*//Add Work Class
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnAddWorkClass(driver));
		test.log(LogStatus.PASS, " Clicked on Add Work Class Button");
		Thread.sleep(4000);
		EnrollCP_Enrollment_Page.WCClassCodeField(driver).sendKeys("Test");
		test.log(LogStatus.PASS, " Work Class Selected Successfully");
		Thread.sleep(2000);
		EnrollCP_Enrollment_Page.WCClassCodeField(driver).sendKeys(Keys.TAB);
		Thread.sleep(1500);
		EnrollCP_Enrollment_Page.cappedUncappedAlertOKBtn(driver).click();
		Thread.sleep(1500);
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_Enrollment_Page.WCHoursField(driver));
		EnrollCP_Enrollment_Page.WCHoursField(driver).click();
		EnrollCP_Enrollment_Page.WCHoursField(driver).sendKeys("150");
		EnrollCP_Enrollment_Page.WCHoursField(driver).sendKeys(Keys.TAB);
		test.log(LogStatus.PASS, " Work Hours Added Successfully");
		
		try {
			EnrollCP_Enrollment_Page.WCUncappedPayrollField(driver).sendKeys("15000",Keys.TAB);
			test.log(LogStatus.PASS, " Work Class Uncapped Payroll Added Successfully");	
			
		} catch (Throwable e) {
			System.out.println(e);
		}
		
		try {
			EnrollCP_Enrollment_Page.WCCappedPayrollField(driver).sendKeys("15000",Keys.TAB);	
			Thread.sleep(2000);
			test.log(LogStatus.PASS, " Work Class Capped Payroll Added Successfully");
		} catch (Throwable e) {
			System.out.println(e);
		}
//		EnrollCP_Enrollment_Page.WCUncappedPayrollField(driver).sendKeys("15000");
		EnrollCP_Enrollment_Page.WCRateField(driver).sendKeys("15");
		test.log(LogStatus.PASS, " Work Class Rate Added Successfully");
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		Thread.sleep(2000);
		try {
			EnrollCP_Enrollment_Page.CVtoPayrollRatio_Alert_LetContinueBtn(driver).click();
			test.log(LogStatus.PASS, " Alert Accepted");	
		} catch (Throwable e) {
			System.out.println("Alert Not Present"+e);
		}
		Thread.sleep(3000);
		
		try {
			EnrollCP_Enrollment_Page.CVtoPayrollRatio_Alert_LetContinueBtn(driver).click();	
		} catch (Throwable e) {
			System.out.println("Alert Not Present"+e);
		}
		
//		EnrollCP_Enrollment_Page.CVtoPayrollRatio_Alert_LetContinueBtn(driver).click();
		test.log(LogStatus.PASS, " Alert Accepted");
		Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_Enrollment_Page.btnContinue(driver));
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Continue Button");
//Premium modification Page
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Premium Modification Page Continue Button");
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Continue Button");
//GL Page
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_Enrollment_Page.selectGLClassCode(driver, 1));
		EnrollCP_Enrollment_Page.selectGLClassCode(driver, 1).click();
		test.log(LogStatus.PASS, " Clicked on GL Class Code Field");
		Thread.sleep(1000);
		wb.selectSingleValueFromList(EnrollCP_Enrollment_Page.selectGLClassCodeFromList(driver, 1), "Airport runaway");
		test.log(LogStatus.PASS, " GL Class Code Selected Successfully");
		EnrollCP_Enrollment_Page.glSIRLossChargeField(driver).click();
		EnrollCP_Enrollment_Page.glSIRLossChargeField(driver).sendKeys("100");
		test.log(LogStatus.PASS, " GL Sir Loss Charge Added Successfully");
		EnrollCP_Enrollment_Page.glDeductibleField(driver).click();	
		EnrollCP_Enrollment_Page.glDeductibleField(driver).sendKeys("100");
		test.log(LogStatus.PASS, " GL Deductible Added Successfully");
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));		
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		Thread.sleep(12000);
		
//UMB Page
		//wb.waitForElemnet(EnrollCP_Enrollment_Page.selectUMBClassCode(driver, 1));
		js.executeScript("window.scrollBy(0,250)","");
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_Enrollment_Page.selectUMBClassCode(driver, 1));
		test.log(LogStatus.PASS, " Clicked on UMB Class Code Field");
		EnrollCP_Enrollment_Page.selectUMBClassCode(driver,1).click();
		Thread.sleep(1000);
		wb.selectSingleValueFromList(EnrollCP_Enrollment_Page.selectUMBClassCodeFromList(driver, 1), "Airport runaway");
		test.log(LogStatus.PASS, " UMB Class Code Selected Successfully");
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_Enrollment_Page.btnContinue(driver));
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		Thread.sleep(9000);
		
		wb.waitForElemnet(EnrollCP_Enrollment_Page.selectPollClassCode(driver, 1));
		js.executeScript("window.scrollBy(0,350)", "");
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_Enrollment_Page.selectPollClassCode(driver, 1));
		EnrollCP_Enrollment_Page.selectPollClassCode(driver, 1).click();
		test.log(LogStatus.PASS, " Clicked on POll Class Code Field");
		Thread.sleep(1000);
		wb.selectSingleValueFromList(EnrollCP_Enrollment_Page.selectPollClassCodeFromList(driver, 1), "Airport runaway");
		test.log(LogStatus.PASS, " Poll Class Code Selected Successfully");
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_Enrollment_Page.btnContinue(driver));
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));
		Thread.sleep(9000);
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_Enrollment_Page.lookGoodContinueBtn(driver));
		EnrollCP_Enrollment_Page.lookGoodContinueBtn(driver).click();
		test.log(LogStatus.PASS, " Clicked on Looks Good Continue Button");
		Thread.sleep(5000);
		*/
		
//sub Contractor 
		EnrollCP_Enrollment_Page.subContractorCostNoBtn(driver).click();
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on SubContractor Continue Button");
		Thread.sleep(3000);
//sub summary page
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_Enrollment_Page.lookGoodContinueBtn(driver));
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.lookGoodContinueBtn(driver));
		Thread.sleep(3000);
		test.log(LogStatus.PASS, " Clicked on Sub Summary Looks Good Continue Button");
//Documents
		Thread.sleep(2000);
		String docName=driver.findElement(By.xpath("//h5[contains(text(),'Optional Documents')]/../../div[2]//i/../../div")).getText();
		System.out.println("Doc name is " +docName);
		if(docName.contains("Signed Enrollment Form"))
		{
			test.log(LogStatus.PASS, " Signed Enrollment Form Document is Present");
			
		}else
		{
			test.log(LogStatus.FAIL, " Signed Enrollment Form Document is not Present");
		}
		
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Documents Continue Button");
		Thread.sleep(3000);
		try {
			js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));	
			Thread.sleep(3000);
		} catch (NoSuchElementException e) 
		{
		System.out.println(e);
		}
		Thread.sleep(2000);
		
		try {
			js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));	
			Thread.sleep(5000);

		} catch (Throwable e) {
			System.out.println(e);
		}
		
		/*Thread.sleep(5000);
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.letMeOutBtn(driver));
		test.log(LogStatus.PASS, " Clicked on Let Me Out Button");
		Thread.sleep(3000);
*/		
		try {
			EnrollCP_Enrollment_Page.cipAgreementConfirmationSubmitDegitalEnrollmentButton(driver).click();
			Thread.sleep(6000);
		} catch (Throwable e) {
			System.out.println(e);
		}
		
		try {
			js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.submitEnrollmentBtn(driver));
			test.log(LogStatus.PASS, " Clicked on Submit Enroll Button");
			Thread.sleep(6000);
		} catch (Throwable e) {
			System.out.println(e);
		}
		
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_Enrollment_Page.CompleteBtn(driver));
		
		EnrollCP_Enrollment_Page.CompleteBtn(driver).click();
		test.log(LogStatus.PASS, " Clicked Complete Button");
		
		test.log(LogStatus.PASS, " Contractor Package Enrolled Successfully");
		driver.navigate().to(BaseUrl);//navigate to base url
		Thread.sleep(5000);
		

	}

}
