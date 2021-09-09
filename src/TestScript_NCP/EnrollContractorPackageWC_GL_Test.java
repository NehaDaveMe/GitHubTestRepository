package TestScript_NCP;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.RandomClass;
import ModulerLibrary.NCP_LoginAction;
import ModulerLibrary.WPO_AddContractorPkgAction;
import ModulerLibrary.WPO_SelectContractorPkgAction;
import ObjectRepository.AddContractor_Pkg_GL_Umbrella_Coverage_Page;
import ObjectRepository.AddContractor_Pkg_Insurance_Enrollment_Page;
import ObjectRepository.AddContractor_Pkg_WC_Premiums_Modifications_Page;
import ObjectRepository.ContractorPackageModule;
import ObjectRepository.HomePage;
import ObjectRepository_NCP.EnrollCP_AddMothlyPayrollPage;
import ObjectRepository_NCP.EnrollCP_Enrollment_Page;
import ObjectRepository_NCP.NCP_HomePage;

public class EnrollContractorPackageWC_GL_Test extends BaseClass
{
	
	WebDriverCommonLib wb= new WebDriverCommonLib();
	// public String projectName;

	public String programName="Automation Program dont touch";
	public String projectName="Test 132 ON";
	public String tradeName="T7026";
	public String contractorPKGno = RandomClass.randomContractorPkgNo();
	public String EnrollmentType = "WC & GL Enrollment";
	public String contractorCompany="Alex Comp3524";//"sony";
	public String contactName="Jimmy Smith";
	public String dba = RandomClass.randomDBA();
	public String contractorName = "Alex Comp2273";
	public String tradeNumber = RandomClass.randomTradeNO();
	public String insuranceCompName = "Carriers3524";
	public String startDate = "01/01/2021";
	
	public String uName="JimmySmith114540";//"JimmySmith114211";//"JimmySmith113888";//"JimmySmith114211";//
	public String password="Admin@123";//"Admin@123";//"uX6R1i0L7KxA";//"uO5J6h4K1UdS";//"uX6R1i0L7KxA";//

	public String submissionFrequency = "Quarterly";
	public String reportTime = "Quarterly";
	public String tab="Enrollment";
	
	
	@Test()
	/*public void enrollCPWC_GL(String TestCaseName ,String programName, String projectName , String tradeName) throws Throwable
	{*/
		public void enrollCPWC_GL() throws Throwable
		{
		
		//for creating new contractor pkg at wp side
		WPO_AddContractorPkgAction.add_ContractorPkg(contractorName, projectName, programName, contractorCompany,
				contactName, tradeNumber, contractorPKGno, insuranceCompName, submissionFrequency, reportTime,
				EnrollmentType);
		
/*		System.out.println(TestCaseName + programName + projectName + tradeName);
		this.projectName =projectName;
		this.programName = programName;*/
		
		String BaseUrl=driver.getCurrentUrl();
//		NCP_LoginAction.logInNCP(driver);
		NCP_LoginAction.logInNCPCommon(driver, uName, password);
		
		
		
		//ncp home page //coding done in homePage pom file 
		
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
		
		NCP_HomePage.selectTradeField(driver).click();
		test.log(LogStatus.PASS, " Clicked On Select Trade Field");
		Thread.sleep(1500);
		NCP_HomePage.searchForTradeField(driver).click();
		Thread.sleep(1500);
		NCP_HomePage.searchForTradeField(driver).sendKeys(tradeNumber);
		Thread.sleep(2500);
		System.out.println(tradeNumber);
		
		wb.selectSingleValueFromList(NCP_HomePage.selectTradeFromList(driver), tradeNumber);
		test.log(LogStatus.PASS, tradeNumber+" Trade successfully selected form drop down");
		Thread.sleep(2500);
		
		NCP_HomePage.btnSearch(driver).click();
		test.log(LogStatus.PASS, " Clicked on Search Button");
		Thread.sleep(2000);
		
	//selecting the contractor pkg	
		NCP_HomePage.selectPreviewPanelProjectDropdown(driver, projectName).click();
		test.log(LogStatus.PASS, " Clicked on Selected Contractor Package");
		Thread.sleep(1000);
		NCP_HomePage.selectEnrollmentTab(driver, "Enrollment").click();
		test.log(LogStatus.PASS, " Clicked on Enrollment View");
		Thread.sleep(5000);
//		EnrollCP_Enrollment_Page.CompanyInformationEditBtn(driver).click();
		
		
		
		try {
			EnrollCP_Enrollment_Page.cipAgreementContinueButton(driver).click();
		} catch (Throwable e) {
			System.out.println(e);
		}
		
		
		
//my company info page		
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
		Thread.sleep(1000);
		wb.selectSingleValueFromList(EnrollCP_Enrollment_Page.selectLegalStatus(driver), "Joint Venture");
		test.log(LogStatus.PASS, " Select Legarl Status Joint Venture From DropDown");
		Thread.sleep(1500);
		EnrollCP_Enrollment_Page.btnContinue(driver).click();
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		
//Contact Information Page
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.sameAsPrimaryContactCheckBox(driver));
		test.log(LogStatus.PASS, " Same As Primary Contact Check box selected successfully");
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
		Thread.sleep(1500);
		
		EnrollCP_Enrollment_Page.estimatedManhours(driver).clear();
		EnrollCP_Enrollment_Page.estimatedManhours(driver).sendKeys("6100");
		test.log(LogStatus.PASS, " Estimated Hours Added Successfully");
		try {
			EnrollCP_Enrollment_Page.estimatedUncappedPayroll(driver).clear();
			EnrollCP_Enrollment_Page.estimatedUncappedPayroll(driver).sendKeys("955000");
			test.log(LogStatus.PASS, " Uncapped Payroll Added Successfully");
		} catch (Throwable e) {
			System.out.println(e);
		}
//alert occurred second time
	try {
		EnrollCP_Enrollment_Page.CVtoPayrollRatio_Alert_LetContinueBtn(driver).click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, " click on Alert Continue");
	} catch (Throwable e) {
		System.out.println(e);
	}
		/*	EnrollCP_Enrollment_Page.SPCVtoPayrollRatio_Alert_OKBtn(driver).click();
	*/	
		try {
			EnrollCP_Enrollment_Page.estimatedCappedPayroll(driver).clear();
			EnrollCP_Enrollment_Page.estimatedCappedPayroll(driver).sendKeys("955000");
			test.log(LogStatus.PASS, " Capped Payroll Added Successfully");
		} catch (Throwable e) {
			System.out.println(e);
		}
//		EnrollCP_Enrollment_Page.estimatedCappedPayroll(driver).sendKeys(Keys.TAB);
		
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_Enrollment_Page.estimatedStartDate(driver));
		EnrollCP_Enrollment_Page.estimatedStartDate(driver).clear();
		EnrollCP_Enrollment_Page.estimatedStartDate(driver).sendKeys(startDate);
		Thread.sleep(1000);
		test.log(LogStatus.PASS, " Estimated Strt Date Added Successfully");
		EnrollCP_Enrollment_Page.estimatedStartDate(driver).sendKeys(Keys.TAB);
		
		
//		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.estimatedEndDate(driver));
//		EnrollCP_Enrollment_Page.estimatedEndDate(driver).click();
		Thread.sleep(1000);
		EnrollCP_Enrollment_Page.estimatedEndDate(driver).sendKeys("11/10/2023");
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
		
//Add Work Class
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
		EnrollCP_Enrollment_Page.WCRateField(driver).sendKeys("14");
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
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.selectUMBClassCode(driver,1));//06/02/2021 kp
//		EnrollCP_Enrollment_Page.selectUMBClassCode(driver,1).click();
		Thread.sleep(1000);
		wb.selectSingleValueFromList(EnrollCP_Enrollment_Page.selectUMBClassCodeFromList(driver, 1), "Airport runaway");
		test.log(LogStatus.PASS, " UMB Class Code Selected Successfully");
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_Enrollment_Page.btnContinue(driver));
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Continue Button");
		Thread.sleep(9000);
		//pollution
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
/*//Documents
		
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));
		test.log(LogStatus.PASS, " Clicked on Documents Continue Button");
		Thread.sleep(3000);
		try {
			js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.btnContinue(driver));	
		} catch (NoSuchElementException e) 
		{
		System.out.println(e);
		}
		
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();",EnrollCP_Enrollment_Page.letMeOutBtn(driver));
		test.log(LogStatus.PASS, " Clicked on Let Me Out Button");
		Thread.sleep(3000);
		
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
		*/

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
		
		
		
//Confirm From Admin		
		HomePage.controlMenuHomeIcon(driver).click();
		test.log(LogStatus.INFO, "Clicked On Home Icon");
		HomePage.HomeMenuContractorPackage(driver).click();
		test.log(LogStatus.INFO, "Clicked On Contracotr Package Icon");

		// search for contractor package
		Thread.sleep(8000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
		
	//optimized update the code with new logic 30/04/2021
		WPO_SelectContractorPkgAction.selectContractorpkgWithTrade(tradeNumber);
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,-250)", "");
		driver.switchTo().frame(0);
		System.out.println(ContractorPackageModule.fetchTradeNamePriviewP(driver).getText());

		// insurance enrollment page
		wb.waitForElemnet(ContractorPackageModule.InsuranceEnrollmentPagePriviewP(driver));
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Clicked on Insurance Enrollment Page");
		// switch focus to child window
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		driver.manage().window().maximize();
		// AddContractor_Pkg_Insurance_Enrollment_Page.InsuranceEnrollmentTab(driver).click();
		Thread.sleep(7000);
		
		js.executeScript("arguments[0].scrollIntoView();",AddContractor_Pkg_Insurance_Enrollment_Page.markAsConfirmedRadioBtn(driver));
		
		js.executeScript("arguments[0].click();",AddContractor_Pkg_Insurance_Enrollment_Page.markAsConfirmedRadioBtn(driver));
		test.log(LogStatus.INFO, "Clicked On Contract Details Mark As Confirmed Radio Button");
		
		AddContractor_Pkg_Insurance_Enrollment_Page.enrollmentDate(driver).sendKeys(startDate);
		test.log(LogStatus.PASS, "Enrollment Date Added Successfully");
		
		js.executeScript("arguments[0].click();",
				AddContractor_Pkg_Insurance_Enrollment_Page.btnSaveAndContinue(driver));
		test.log(LogStatus.PASS, "Clicked On Contract Details Save And Continue Button");
		Thread.sleep(3000);
		

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
		try {
			// first common alert handled
			AddContractor_Pkg_Insurance_Enrollment_Page.alertCoomman(driver).click();
			Thread.sleep(2000);
		} catch (Throwable e) {
			System.out.println("Alert issue  " + e);
		}
		try {
			// first common alert handled
			AddContractor_Pkg_Insurance_Enrollment_Page.alertCoomman(driver).click();
			Thread.sleep(2000);
		} catch (Throwable e) {
			System.out.println("Alert issue  " + e);
		}
		
//WC modification page
	
		js.executeScript("window.scrollBy(0,3500)");
		js.executeScript("arguments[0].scrollIntoView();",
				AddContractor_Pkg_WC_Premiums_Modifications_Page.markAsConfirmedRadioBtn(driver));
		AddContractor_Pkg_WC_Premiums_Modifications_Page.markAsConfirmedRadioBtn(driver).click();
		test.log(LogStatus.INFO, "Cliced On WC Premium Modification Page Mark As Confirmed Radio Button ");
		js.executeScript("window.scrollBy(0,1000)");
		try {
			AddContractor_Pkg_WC_Premiums_Modifications_Page.zeroChargesAlert(driver).click();
		} catch (Throwable e) {
			System.out.println(e);
		}
		Thread.sleep(1500);
		AddContractor_Pkg_WC_Premiums_Modifications_Page.btnSaveAndContinue(driver).click();
		test.log(LogStatus.INFO, "Clicked On WC Premium Modificaction Page Save And Continue Button");
		Thread.sleep(7000);
		
//GL Page		
		js.executeScript("window.scrollBy(0,5000)");
		js.executeScript("arguments[0].scrollIntoView();",AddContractor_Pkg_GL_Umbrella_Coverage_Page.markAsConfirmedRadioBtn(driver));
		js.executeScript("arguments[0].click();",
				AddContractor_Pkg_GL_Umbrella_Coverage_Page.markAsConfirmedRadioBtn(driver));
		test.log(LogStatus.INFO, "Clicked On GL Umbrella Mark as Confirmed Radio Button");
		js.executeScript("window.scrollBy(0,300)");
		js.executeScript("arguments[0].click();",
				AddContractor_Pkg_GL_Umbrella_Coverage_Page.btnSaveAndClose(driver));
		test.log(LogStatus.INFO, "Clicked On GL Umbrella Save And Continue Button");
		Thread.sleep(6000);
		driver.switchTo().window(wb.map.get("parentID"));
	
		//Certificate generate
		WPO_SelectContractorPkgAction.selectContractorpkgWithTrade(tradeNumber);
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,-250)", "");
		driver.switchTo().frame(0);
		System.out.println(ContractorPackageModule.fetchTradeNamePriviewP(driver).getText());
		ContractorPackageModule.CertificatesAutoGenerate(driver).click();
		Thread.sleep(10000);
	}
	
	/*@Test(dependsOnMethods={"enrollCPWC_GL"})
	public void testMonthalyPayroll() throws Throwable
	{
		
			String BaseUrl=driver.getCurrentUrl();
			NCP_LoginAction.logInNCPCommon(driver, uName, password);
			Thread.sleep(5000);	
			
//			new WebDriverWait(driver, 80).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
			
			NCP_HomePage.btnFilterBy(driver).click();
			test.log(LogStatus.PASS, " Clicked On Filter Button");
			Thread.sleep(3000);	
			
			wb.waitForElemnet(NCP_HomePage.selectProgramField(driver));
			test.log(LogStatus.PASS, " Clicked On Select Program Field");
			Thread.sleep(3000);
			wb.selectSingleValueFromList(NCP_HomePage.selectProgramFromList(driver),programName );
			test.log(LogStatus.PASS, programName+" Program Name successfully selected form drop down");
			Thread.sleep(2500);
			
			wb.waitForElemnet(NCP_HomePage.selectProjectField(driver));
//			NCP_HomePage.selectProjectField(driver).click();
			test.log(LogStatus.PASS, " Clicked On Select Project Field");
			wb.selectSingleValueFromList(NCP_HomePage.selectProjectFromList(driver),projectName );
			test.log(LogStatus.PASS, projectName+" Project Name successfully selected form drop down");
			Thread.sleep(3000);
			
			//update the code Select trade from list 05/03/2021 by kp
			int x=2;
			do {
				try {
					NCP_HomePage.selectTradeField(driver).click();
					test.log(LogStatus.PASS, " Clicked On Select Trade Field");
					Thread.sleep(3000);
					x=2;
				} catch (Throwable e) {
					System.out.println(e);
					Thread.sleep(1500);
				}
			} while (x==1);
	
			NCP_HomePage.searchForTradeField(driver).click();
			Thread.sleep(1500);
			NCP_HomePage.searchForTradeField(driver).sendKeys(tradeNumber);
			Thread.sleep(2500);
			System.out.println(tradeNumber);
			wb.selectSingleValueFromList(NCP_HomePage.selectTradeFromList(driver), tradeNumber);
			test.log(LogStatus.PASS, tradeNumber+" Trade successfully selected form drop down");
			Thread.sleep(2500);
			
			
			NCP_HomePage.btnSearch(driver).click();
			test.log(LogStatus.PASS, " Clicked on Search Button");
			Thread.sleep(2000);
			NCP_HomePage.selectPreviewPanelProjectDropdown(driver, projectName).click();
			test.log(LogStatus.PASS, " Clicked on Selected Contractor Package");
			Thread.sleep(2000);
			NCP_HomePage.selectEnrollmentTab(driver, "Payroll").click();
			test.log(LogStatus.PASS, " Clicked on Payroll View");
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			EnrollCP_AddMothlyPayrollPage.addPayrollButton(driver).click();
			test.log(LogStatus.PASS, " Clicked on Add Payroll Button");
			Thread.sleep(5000);
			EnrollCP_AddMothlyPayrollPage.selectPayrollPeriodField(driver).click();
			test.log(LogStatus.PASS, " Clicked on Add Payroll Button");
			Thread.sleep(2000);
			List<WebElement> lst2 = EnrollCP_AddMothlyPayrollPage.selectPayrollPeriodFromList(driver);
			
			for(int i=0;i<=lst2.size()-1;i++)
			{
				lst2.get(i).click();
				break;
			}
			Thread.sleep(5000);
			fillPayroll();
			
			Thread.sleep(9000);
			js.executeScript("arguments[0].click();",EnrollCP_AddMothlyPayrollPage.addPayrollCloseIcon(driver));
			test.log(LogStatus.PASS, " Monthaly Payroll Added Successfully");
			driver.navigate().to(BaseUrl);//navigate to base url
		
	}
	
	public void fillPayroll() throws InterruptedException
	{
		try {
			EnrollCP_AddMothlyPayrollPage.addMonthlyPayrollPolicyAlertOkBtn(driver).click();
		} catch (Throwable e) {
			System.out.println("Polciy Alert is not present"+e);
		}
		wb.waitForElemnet(EnrollCP_AddMothlyPayrollPage.addPayrollCVField(driver));
		Actions act= new Actions(driver);
		Thread.sleep(1500);
		act.moveToElement(EnrollCP_AddMothlyPayrollPage.addPayrollCVField(driver)).doubleClick().build().perform();
		EnrollCP_AddMothlyPayrollPage.addPayrollCVField(driver).sendKeys("1000");
		test.log(LogStatus.PASS, " Payroll Contract Value Added Successfully");
		Thread.sleep(2000);
		
		act.moveToElement(EnrollCP_AddMothlyPayrollPage.addPayrollSelfCVField(driver)).doubleClick().build().perform();
		EnrollCP_AddMothlyPayrollPage.addPayrollSelfCVField(driver).sendKeys("1000");
		test.log(LogStatus.PASS, " Payroll Self Performed Contract Value Added Successfully");
		List<WebElement> payroll = EnrollCP_AddMothlyPayrollPage.addPayrollForALLWorkClass(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(WebElement b:payroll)
		{
			try {
				act.moveToElement(b).doubleClick().build().perform();
				Thread.sleep(1000);
				b.sendKeys("100");
				test.log(LogStatus.PASS, " Payroll and hours added Successfully");
			} catch (Throwable e) {
				System.out.println(e);
			}
		}
		Thread.sleep(5000);
		if(EnrollCP_AddMothlyPayrollPage.addPayrollNextMonthBtn(driver).isDisplayed()==true)
		{	
			js.executeScript("arguments[0].click();",EnrollCP_AddMothlyPayrollPage.addPayrollNextMonthBtn(driver));
			test.log(LogStatus.PASS, " Clicked on Continue Next Month Payroll Button");
			Thread.sleep(7000);
			fillPayroll();
		}else
		{
			js.executeScript("arguments[0].click();",EnrollCP_AddMothlyPayrollPage.addPayrollSaveBtn(driver));
			test.log(LogStatus.PASS, " Clicked on Payroll Save Button");
			Thread.sleep(7000);
		}
		
	}*/
}
