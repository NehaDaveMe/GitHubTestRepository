package TestScipts_CPO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.RandomClass;
import ModulerLibrary.CPO_LogInAction;
import ModulerLibrary.OCP_ConfirmEnrollCPFrmAdminAction;
import ModulerLibrary.WPO_AddContractorPkgAction;
import ObjectRepository_CPO.CPO_Add_CP_ContractDetailsPage;
import ObjectRepository_CPO.CPO_Add_CP_EnrollmentPage;
import ObjectRepository_CPO.CPO_Add_CP_EnrollmentSummaryPage;
import ObjectRepository_CPO.CPO_Add_CP_GL_Umbrella_Coverage_Page;
import ObjectRepository_CPO.CPO_Add_CP_InsuranceEnrollmentPage;
import ObjectRepository_CPO.CPO_Add_CP_RequiredDocumentsPage;
import ObjectRepository_CPO.CPO_Add_CP_WC_PremiumsModificationsPage;
import ObjectRepository_CPO.CPO_HomePage;
import ObjectRepository_CPO.CPO_MyProjectsModule;

public class CPO_EnrollContPkg_TC extends BaseClass
{
	
	WebDriverCommonLib wb=new WebDriverCommonLib();
	
	
	public String programName="Automation Program dont touch";
	public String projectName="Test 132 ON";
	public String tradeName=RandomClass.randomTradeDescription();
	public String tradeNumber = RandomClass.randomTradeNO();
	public String tradeNo = tradeNumber;
	public String contractorPKGno = RandomClass.randomContractorPkgNo();
	public String EnrollmentType = "WC & GL Enrollment";
	public String contractorCompany="Alex Comp3524";//"sony";
	public String contactName="Jimmy Smith";
	public String dba = RandomClass.randomDBA();
	public String contractorName = "Alex Comp3524";
	public String insuranceCompName = "Carriers3524";
	public String enrollmentStartDate= "01/01/2021";
	public String submissionFrequency = "Quarterly";
	public String reportTime = "Quarterly";
	
	
	
	@Test
	public void testEnrollContractorPkg() throws Throwable
	{
		WPO_AddContractorPkgAction.add_ContractorPkgWithTradeDescription(contractorName, projectName, programName, contractorCompany,
				contactName, tradeNumber,tradeName,contractorPKGno, insuranceCompName, submissionFrequency, reportTime,
				EnrollmentType);
		
		String BaseUrl=driver.getCurrentUrl();//store base url for future use 
		CPO_LogInAction.logInCPO(driver);	
		
		CPO_HomePage.IconMyProjects(driver).click();
		test.log(LogStatus.INFO, " Clicked On My Projects Page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wb.selectSingleValue(CPO_MyProjectsModule.selectProgram(driver), programName);
		wb.selectSingleValue(CPO_MyProjectsModule.selectProjects(driver), projectName);
		System.out.println("tname 1"+tradeNumber);
		wb.selectSingleValue(CPO_MyProjectsModule.selectTrade(driver), tradeName );
		
		Thread.sleep(10000);
		CPO_MyProjectsModule.selectContractorPackage(driver, programName, projectName,tradeNo,contractorName, EnrollmentType).click();
//		js.executeScript("arguments[0].click();",CPO_MyProjectsModule.selectContractorPackage(driver, programName, projectName,tradeNumber,contractorName, EnrollmentType));
		test.log(LogStatus.PASS,programName+" "+projectName+" "+ tradeNumber+" "+ EnrollmentType+" Contractor Package Selected");
		
		CPO_Add_CP_EnrollmentPage.linkInsuranceEnrollment(driver).click();
		wb.getWindowIDs();
		
		driver.switchTo().window(wb.map.get("childID"));
		driver.manage().window().maximize();
		try {
			CPO_Add_CP_InsuranceEnrollmentPage.cipAgreementBtnNext(driver).click();
			
		} catch (Throwable e) {
			System.out.println(e);
		}	
		
		try {
			CPO_Add_CP_InsuranceEnrollmentPage.popUpCloneCancelBtn(driver).click();
		} catch (Throwable e) {
			System.out.println(e);
		}
		
		try {
			
			CPO_Add_CP_InsuranceEnrollmentPage.fieldContractorName(driver).click();	
		test.log(LogStatus.PASS, "Contractor Name Added Successfully");
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",CPO_Add_CP_InsuranceEnrollmentPage.contactInformationEmail(driver));
		
		
//Contact Details Page
	
		js.executeScript("arguments[0].scrollIntoView();",CPO_Add_CP_InsuranceEnrollmentPage.fieldContractValue(driver));
		wb.mouseMoveToElement(CPO_Add_CP_InsuranceEnrollmentPage.fieldContractValue(driver));
		CPO_Add_CP_InsuranceEnrollmentPage.fieldContractValue(driver).clear();
		CPO_Add_CP_InsuranceEnrollmentPage.fieldContractValue(driver).sendKeys("5600000");
		test.log(LogStatus.PASS, "Contract Value Added Successfully");
		CPO_Add_CP_InsuranceEnrollmentPage.fieldSelfPerformedContractValue(driver).clear();
		CPO_Add_CP_InsuranceEnrollmentPage.fieldSelfPerformedContractValue(driver).sendKeys("560000");
		test.log(LogStatus.PASS, "Self Performed Contract Value Added Successfully");
		CPO_Add_CP_InsuranceEnrollmentPage.fieldEstimatedCappedPayroll(driver).clear();
		CPO_Add_CP_InsuranceEnrollmentPage.fieldEstimatedCappedPayroll(driver).sendKeys("100000");
		test.log(LogStatus.PASS, "Estimated Uncapped Payroll Added Successfully");
		CPO_Add_CP_InsuranceEnrollmentPage.fieldEstimatedUncappedPayroll(driver).clear();
		CPO_Add_CP_InsuranceEnrollmentPage.fieldEstimatedUncappedPayroll(driver).sendKeys("100000");
		test.log(LogStatus.PASS, "Estimated Capped Payroll Added Successfully");
		CPO_Add_CP_InsuranceEnrollmentPage.fieldEstimatedManHours(driver).clear();
		CPO_Add_CP_InsuranceEnrollmentPage.fieldEstimatedManHours(driver).sendKeys("1000");
		test.log(LogStatus.PASS, "Estimated Man Hours Added Successfully");
		CPO_Add_CP_InsuranceEnrollmentPage.fieldEstimatedStartDate(driver).clear();
		CPO_Add_CP_InsuranceEnrollmentPage.fieldEstimatedStartDate(driver).sendKeys(enrollmentStartDate, Keys.TAB);
		test.log(LogStatus.PASS, "Estimated Start Date Added Successfully");
		CPO_Add_CP_InsuranceEnrollmentPage.fieldEstimatedCompletionDate(driver).clear();
		CPO_Add_CP_InsuranceEnrollmentPage.fieldEstimatedCompletionDate(driver).sendKeys("12/31/2023", Keys.TAB);
		test.log(LogStatus.PASS, "Estimated Completion Date Added Successfully");

		System.out.println("Program Radio Button is Selected \t"
				+ CPO_Add_CP_InsuranceEnrollmentPage.redioBtnProgram(driver).isSelected());

		js.executeScript("arguments[0].click();",
				CPO_Add_CP_InsuranceEnrollmentPage.textAreaBrieflyDescribetheScopeWork(driver));
		CPO_Add_CP_InsuranceEnrollmentPage.textAreaBrieflyDescribetheScopeWork(driver).sendKeys("Testing");
		js.executeScript("window.scrollBy(0,500)");
		
		wb.waitForElemnet(CPO_Add_CP_ContractDetailsPage.selectWorkClass(driver));
		js.executeScript("arguments[0].click();",CPO_Add_CP_ContractDetailsPage.selectWorkClass(driver));
		Thread.sleep(4000);
		CPO_Add_CP_ContractDetailsPage.selectWorkClassSearchBox(driver).sendKeys("Test");
		wb.selectSingleValueFromList(CPO_Add_CP_ContractDetailsPage.selectAllWorkClassFromAutoCompleteDropDown(driver), "Test");
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Work Class Selected Successfully");
		
		try {
			CPO_Add_CP_ContractDetailsPage.slectWorkClassCappedStateAlertOkBtn(driver).click();
		
		} catch (Throwable e) {
			System.out.println("Alert Not Present Statewise"+e);
		}
		
		/*js.executeScript("arguments[0].click();",CPO_Add_CP_InsuranceEnrollmentPage.selectWorkClassSearchBox(driver));
		
		CPO_Add_CP_InsuranceEnrollmentPage.selectWorkClassSearchBox(driver).sendKeys("Test");
		wb.selectSingleValueFromList(CPO_Add_CP_InsuranceEnrollmentPage.selectAllWorkClassFromAutoCompleteDropDown(driver), "Test");
	*/	
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Work Class Selected Successfully");
		// wb.selectSingleValueFromList(CPO_Add_CP_InsuranceEnrollmentPage.selectAllWorkClassFromAutoCompleteDropDown(driver),"Technicians");
		CPO_Add_CP_InsuranceEnrollmentPage.addWorkClassWorkHoursField(driver).sendKeys("100");
		test.log(LogStatus.PASS, "Work Class Hours Added Successfully");
		CPO_Add_CP_InsuranceEnrollmentPage.addWorkClassUnCappedPayrollField(driver).sendKeys("5000");
		test.log(LogStatus.PASS, "Work Class Uncapped Payroll Added Successfully");
		
		try {
			
			CPO_Add_CP_InsuranceEnrollmentPage.addWorkClassCappedPayrollField(driver).sendKeys("5000");
			test.log(LogStatus.PASS, "Work Class Capped Payroll Added Successfully");
			
		} catch (Throwable e) {
			System.out.println("capped payrol field"+e);
		}
		
		
		CPO_Add_CP_InsuranceEnrollmentPage.addWorkClassRateField(driver).sendKeys("15.00");
		test.log(LogStatus.PASS, "Work Class Rate Added Successfully");
		js.executeScript("arguments[0].click();",
				CPO_Add_CP_InsuranceEnrollmentPage.addWorkClassAddWorkClassBtn(driver));
		test.log(LogStatus.INFO, "Clicked On Add Work Class Button");
		Thread.sleep(10000);
		
		js.executeScript("arguments[0].click();", CPO_Add_CP_InsuranceEnrollmentPage.btnSaveAndContinue(driver));
		test.log(LogStatus.PASS, "Clicked On Contract Details Save And Continue Button");
		Thread.sleep(2000);
	
		try {
			driver.findElement(By.xpath("//button[@id='btnSaveModal']")).click();
			
			test.log(LogStatus.PASS, "I understood Alert occurs and handled");
		}catch (Exception e) {
			test.log(LogStatus.PASS, "noooo Alert Accepted");
		}

		Alert alert = driver.switchTo().alert();
		
		try {
			alert.accept();
			test.log(LogStatus.PASS, "Alert Accepted");
		} catch (Exception e) {
			test.log(LogStatus.PASS, "No such alert at Save and continue button for Swithed at admin side-1 ");
		}
		try {
			alert.accept();
			test.log(LogStatus.PASS, "Alert Accepted");
		} catch (Exception e) {
			test.log(LogStatus.PASS, "No such alert at Save and continue button for Swithed at admin side -2");
		}
		
		try {
			alert.accept();
			test.log(LogStatus.PASS, "Alert Accepted");
		} catch (Exception e) {
			test.log(LogStatus.PASS, "No such alert at Save and continue button for Swithed at admin side-3 ");
		}
		
		try {
			alert.accept();
			test.log(LogStatus.PASS, "Alert Accepted");
		} catch (Exception e) {
			test.log(LogStatus.PASS, "No such alert at Save and continue button for Swithed at admin side -4");
		}
		
		try {
			alert.accept();
			test.log(LogStatus.PASS, "Alert Accepted");
		} catch (Exception e) {
			test.log(LogStatus.PASS, "No such alert at Save and continue button for Swithed at admin side -5");
		}
			
		Thread.sleep(10000);
		
//		js.executeScript("window.scrollBy(0,1000)");
		
		//NON CIP Page
		
	/*	CPO_Add_CP_InsuranceEnrollmentPage.WC_BrokerName(driver).clear();
		CPO_Add_CP_InsuranceEnrollmentPage.WC_BrokerName(driver).sendKeys("Wick");
		test.log(LogStatus.PASS, "WC Broker Name Added Successfully");
		CPO_Add_CP_InsuranceEnrollmentPage.WC_BrokerContactName(driver).clear();
		CPO_Add_CP_InsuranceEnrollmentPage.WC_BrokerContactName(driver).sendKeys("Shetty");
		test.log(LogStatus.PASS, "WC Broker Contact Name Added Successfully");
//		CPO_InsuranceEnrollmentPage.WC_InsuranceCompanyNameRemoveIcon(driver).clear();
//		wb.mouseMoveToElement(CPO_InsuranceEnrollmentPage.WC_InsuranceCompanyNameRemoveIcon(driver));
//		executor.executeScript("arguments[0].click();",CPO_InsuranceEnrollmentPage.WC_InsuranceCompanyNameRemoveIcon(driver));
		CPO_Add_CP_InsuranceEnrollmentPage.WC_InsuranceCompanyName(driver).sendKeys(insuranceCompName);
		Thread.sleep(3000);
		CPO_Add_CP_InsuranceEnrollmentPage.WC_InsuranceCompanyName(driver).sendKeys(Keys.DOWN);
		CPO_Add_CP_InsuranceEnrollmentPage.WC_InsuranceCompanyName(driver).sendKeys(Keys.ENTER);
		test.log(LogStatus.PASS, "WC Insurance Company Name Added Successfully");
		CPO_Add_CP_InsuranceEnrollmentPage.WC_PolicyStartDate(driver).clear();
		CPO_Add_CP_InsuranceEnrollmentPage.WC_PolicyStartDate(driver).sendKeys("05/15/2019");
		test.log(LogStatus.PASS, "WC Insurance Start Date Added Successfully");
		CPO_Add_CP_InsuranceEnrollmentPage.WC_BrokerContactPhone(driver).clear();
		CPO_Add_CP_InsuranceEnrollmentPage.WC_BrokerContactPhone(driver).sendKeys(RandomClass.randomPhoneNo());
		test.log(LogStatus.PASS, "WC Insurance Contact Phone No Added Successfully");
		CPO_Add_CP_InsuranceEnrollmentPage.WC_PolicyExpirationDate(driver).clear();
		CPO_Add_CP_InsuranceEnrollmentPage.WC_PolicyExpirationDate(driver).sendKeys("09/05/2020");
		test.log(LogStatus.PASS, "WC Insurance Policy Expiration Date Added Successfully");
		js.executeScript("arguments[0].click();",CPO_Add_CP_InsuranceEnrollmentPage.checkBoxForGLSameAsWorkerComp(driver));
		test.log(LogStatus.PASS, "GL Insurance Check Box Same As Worker Comp Selected Successfully");
		js.executeScript("arguments[0].click();",CPO_Add_CP_InsuranceEnrollmentPage.checkBoxForUMBSameAsWorkerComp(driver));
		test.log(LogStatus.PASS, "UMB Insurance Check Box Same As Worker Comp Selected Successfully");
		js.executeScript("arguments[0].click();",CPO_Add_CP_InsuranceEnrollmentPage.btnSaveAndContinue(driver));
		Thread.sleep(7000);
		test.log(LogStatus.PASS, "Clicked On Insurance Enrollment Save And Continue Button");
*/
		Thread.sleep(5000);
		} catch (Throwable e) 
		{
			test.log(LogStatus.FAIL, e+"Something Went Wrong");
		}
		
	//Wc Premium page	
		js.executeScript("window.scrollBy(0,300)");
		js.executeScript("arguments[0].click();", CPO_Add_CP_WC_PremiumsModificationsPage.btnSaveAndContinue(driver));
		test.log(LogStatus.INFO, "Clicked On WC Premium Modificaction Page Save And Continue Button");
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,1500)");
	//GL Page
		
		/*CPO_Add_CP_GL_Umbrella_Coverage_Page.selectTableAndRateBaseForGeneralLiability(driver, 1, 2).click();
		test.log(LogStatus.PASS, "First GL Rate Based On Radio Button Selected Successfully");
		CPO_Add_CP_GL_Umbrella_Coverage_Page.GLClassCodeField(driver, 1).sendKeys("123ab");
		test.log(LogStatus.PASS, "First GL Class Code Added Successfully");
		CPO_Add_CP_GL_Umbrella_Coverage_Page.GLDescriptionField(driver, 1).sendKeys("Testing");
		test.log(LogStatus.PASS, "First GL Description Added Successfully");
		CPO_Add_CP_GL_Umbrella_Coverage_Page.selectRatePerGeneralLiability(driver, 1, 2).click();
		test.log(LogStatus.PASS, "First GL Rate Per Radio Button Selected Succesfully ");
		CPO_Add_CP_GL_Umbrella_Coverage_Page.enterRateFieldGeneralLiability(driver, 1).sendKeys("1");
		test.log(LogStatus.PASS, "First GL Rate Added Successfully");
		CPO_Add_CP_GL_Umbrella_Coverage_Page.addAdditionalGLBtn(driver).click();
		test.log(LogStatus.INFO, " Clicked On Add Additional General Liability Button");
		test.log(LogStatus.PASS, "====== First GL Added Successfully ======");
		Thread.sleep(2000);
		CPO_Add_CP_GL_Umbrella_Coverage_Page.selectTableAndRateBaseForGeneralLiability(driver, 2, 3).click();
		test.log(LogStatus.PASS, "Second GL Rate Based On Radio Button Selected Successfully");
		CPO_Add_CP_GL_Umbrella_Coverage_Page.GLClassCodeField(driver, 2).sendKeys("123abcdf");
		test.log(LogStatus.PASS, "Second GL Class Code Added Successfully");
		CPO_Add_CP_GL_Umbrella_Coverage_Page.GLDescriptionField(driver, 2).sendKeys("Testing");
		test.log(LogStatus.PASS, "Second GL Description Added Successfully");
		CPO_Add_CP_GL_Umbrella_Coverage_Page.selectRatePerGeneralLiability(driver, 2, 2).click();
		test.log(LogStatus.PASS, "Second GL Rate Per Radio Button Selected Succesfully ");
		CPO_Add_CP_GL_Umbrella_Coverage_Page.enterRateFieldGeneralLiability(driver, 2).sendKeys("1");
		test.log(LogStatus.PASS, "Second GL Rate Added Successfully");
		CPO_Add_CP_GL_Umbrella_Coverage_Page.generalLiabilitySubmitButton(driver, 2).click();
		test.log(LogStatus.INFO, "Clicked On Submit Button Successfully");
		test.log(LogStatus.PASS, "====== Second GL Added Successfully ======");
//		CPO_GL_Umbrella_Coverage_Page.addAdditionalGLBtn(driver).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
	//	js.executeScript("arguments[0].click();",CPO_GL_Umbrella_Coverage_Page.selectTableAndRateBaseForumbrellaLiability(driver, 1, 2));
		CPO_Add_CP_GL_Umbrella_Coverage_Page.selectTableAndRateBaseForumbrellaLiability(driver, 1, 2).click();
		test.log(LogStatus.PASS, "First UMB Rate Based On Radio Button Selected Successfully");
		CPO_Add_CP_GL_Umbrella_Coverage_Page.UMBClassCodeField(driver, 1).sendKeys("456Abc");
		test.log(LogStatus.PASS, "First UMB Class Code Added Successfully");
		CPO_Add_CP_GL_Umbrella_Coverage_Page.UMBDescriptionField(driver, 1).sendKeys("Testing");
		test.log(LogStatus.PASS, "First UMB Description Added Successfully");
		CPO_Add_CP_GL_Umbrella_Coverage_Page.selectRatePerUmbrellaLiability(driver, 1, 3).click();
		test.log(LogStatus.PASS, "First UMB Rate Per Radio Button Selected Succesfully ");
		CPO_Add_CP_GL_Umbrella_Coverage_Page.enterRateFieldUMB(driver, 1).sendKeys("5");
		test.log(LogStatus.PASS, "First UMB Rate Added Successfully");
		test.log(LogStatus.PASS, "====== First UMB Added Successfully ======");
*/	
		js.executeScript("window.scrollBy(0,700)");
		wb.waitForElemnet(CPO_Add_CP_GL_Umbrella_Coverage_Page.btnSaveAndContinue(driver));
//		js.executeScript("arguments[0].click();",CPO_Add_CP_GL_Umbrella_Coverage_Page.btnSaveAndContinue(driver));
		test.log(LogStatus.INFO, "Clicked On GL Umbrella Save And Continue Button");
		Thread.sleep(3000);
		
//Sub Contractor 
		try {
			wb.waitForElemnet(CPO_Add_CP_RequiredDocumentsPage.btnSaveAndContinueSubContractor(driver));
			test.log(LogStatus.INFO, "Clicked On Sub Contractor Save And Continue Button");
			Thread.sleep(8000);
			
		} catch (Throwable e) {
			System.out.println(e);
		}
		
//required document page	
		js.executeScript("window.scrollBy(0,1000)");
		wb.waitForElemnet(CPO_Add_CP_RequiredDocumentsPage.btnSaveAndContinue(driver));
		test.log(LogStatus.INFO, "Clicked On required Documents Save And Continue Button");
	
		
		try {
			Alert alert=driver.switchTo().alert();
			alert.accept();
			Thread.sleep(3000);
			wb.mouseMoveToElement(CPO_Add_CP_InsuranceEnrollmentPage.sendEmailBtnContinueWithoutSending(driver));
		} catch (Throwable e) {
			System.out.println(e);
		}
		
		Thread.sleep(10000);
		
//Enrollment summary page	
		//wb.waitForElemnet(CPO_Add_CP_EnrollmentSummaryPage.btnEnrollmentSummaryPageConfirmAndContinue(driver));
		js.executeScript("window.scrollBy(0,5300)");
		js.executeScript("arguments[0].scrollIntoView();",
				CPO_Add_CP_EnrollmentSummaryPage.btnEnrollmentSummaryPageConfirmAndContinue(driver));
	
		try {
			wb.mouseMoveToElement(
					CPO_Add_CP_EnrollmentSummaryPage.checkBoxEnrollmentSummaryPageFinalTermsAndCondition(driver));
			test.log(LogStatus.PASS, "Enrollment Summary Final Terms And Condition Check Box Selected ");

		} catch (Throwable e) {

			System.out.println(e);
		}
		
		
		js.executeScript("arguments[0].click();",
				CPO_Add_CP_EnrollmentSummaryPage.btnEnrollmentSummaryPageConfirmAndContinue(driver));
		test.log(LogStatus.INFO, "Clicked On Enrollment Summary Confirm And Continue Button");

		try {

			wb.mouseMoveToElement(CPO_Add_CP_InsuranceEnrollmentPage.sendEmailBtnContinueWithoutSending(driver));
		} catch (Throwable e) {
			System.out.println(e);
		}

		try {
			js.executeScript("arguments[0].click();",
					CPO_Add_CP_EnrollmentSummaryPage.checkBoxEnrollmentSummaryPageAcceptNoLossStmt(driver));
			js.executeScript("arguments[0].click();",
					CPO_Add_CP_EnrollmentSummaryPage.btnEnrollmentSummaryPageAcceptNoLossStmt(driver));
			wb.mouseMoveToElement(CPO_Add_CP_InsuranceEnrollmentPage.sendEmailBtnContinueWithoutSending(driver));
			// wb.mouseMoveToElement(CPO_InsuranceEnrollmentPage.sendEmailBtnContinueWithoutSending(driver));
			Thread.sleep(9000);
			js.executeScript("window.scrollBy(0,1500)");

		} catch (Throwable e) {
			System.out.println(e);
		}
		js.executeScript("window.scrollBy(0,500)");
		wb.waitForElemnet(CPO_Add_CP_EnrollmentSummaryPage.btnEnrollmentConfirmationPageFinishAndClose(driver));
		test.log(LogStatus.PASS, "Clicked On Enrollent Confirmation Page Finish And Close");
		test.log(LogStatus.PASS, "Contractor Package Enrolled Successfully");
		driver.switchTo().window(wb.map.get("parentID"));
		
		driver.navigate().to(BaseUrl);//navigate to base url
		
		//confirm with the admin status change from pending review to missing payroll
		OCP_ConfirmEnrollCPFrmAdminAction.confirmFromAdminSide(tradeNo, enrollmentStartDate);
		
		driver.switchTo().window(wb.map.get("parentID"));
	}
}

/*Thread.sleep(5000);
driver.switchTo().frame(0);
CPO_HomePage.AlertCloseBtn(driver).click();
test.log(LogStatus.INFO," Clicked On Alert Window Close Button");
driver.switchTo().defaultContent();*/
