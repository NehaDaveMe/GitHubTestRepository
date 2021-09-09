package TestScript_RR;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.FileUtils1;
import GenericLibrary.RandomClass;
import ObjectRepository.AddContractor_Pkg__Claim_Page;

public class AddClaimsViaCliamModuleTest extends BaseClass {

	static String programName = "Sony Programs3524";//"Automation Program dont touch"; // "THANOS PG Name";
	static String projectName = "Sony Projects3524"; // "Thanos PJ"; //"RAUT123";
	static String tradename = "2085";
	static String Contractor_Type = "WC & GL Enrollment";
	static String Contractor = "Hercules"; // " Ashley";
	static String contractorPkgNo="PC3524-P3524CONTRACTOR_PKG_NO36519";
		
	WebDriverCommonLib wb = new WebDriverCommonLib();
	
	@Test
	public void ClaimAdditionModule() throws Throwable {

		AddContractor_Pkg__Claim_Page.ClaimModule_claimsICon(driver).click();
		test.log(LogStatus.PASS, "Claim ICon is cliked succesfully");
		Thread.sleep(10000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)", "");//scroll up
		Thread.sleep(6000);
		
		AddContractor_Pkg__Claim_Page.ClaimModule_AddBtn(driver).click();
		test.log(LogStatus.PASS, "Claim Add Btn is cliked succesfully");
		Thread.sleep(4000);
		
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		
		wb.selectSingleValue(
				AddContractor_Pkg__Claim_Page.AddClaimsViaCliamModuleTest_SelectProgramme(driver),programName);
		test.log(LogStatus.PASS, "Programme is selected from Drop down succesfully");
		Thread.sleep(4000);
		
		wb.selectSingleValue(AddContractor_Pkg__Claim_Page.AddClaimsViaCliamModuleTest_Selectproject(driver), projectName);
		test.log(LogStatus.PASS, "Project name  is selected from Drop down succesfully");
		Thread.sleep(4000);
		
		AddContractor_Pkg__Claim_Page.contractorPkgNoField(driver).sendKeys(contractorPkgNo);
		Thread.sleep(4000);

		AddContractor_Pkg__Claim_Page.searchBtn(driver).click();
		Thread.sleep(4000);
		
		AddContractor_Pkg__Claim_Page.selectFirstContractorPkg(driver).click();
		//div[@id='divContractorpackageList']/table/tbody/tr/td[1]/div
		
		AddContractor_Pkg__Claim_Page.nextBtn(driver).click();
		test.log(LogStatus.PASS, "next button is clicked succesfully");
		Thread.sleep(5000);
		
		//select[@id='cntrlClaim_ddlClaimType']
		wb.selectSingleValue(AddContractor_Pkg__Claim_Page.selectClaimType(driver), "General Liability");
		Thread.sleep(1500);
		AddContractor_Pkg__Claim_Page.reportedClaimDate(driver).sendKeys("04/25/2021");
		Thread.sleep(1500);
		AddContractor_Pkg__Claim_Page.reportedClaimDate(driver).sendKeys(Keys.TAB);
		Thread.sleep(1500);
		
		AddContractor_Pkg__Claim_Page.lossDate(driver).sendKeys("04/25/2021");
		Thread.sleep(1500);
		AddContractor_Pkg__Claim_Page.lossDate(driver).sendKeys(Keys.TAB);
		Thread.sleep(1500);
		wb.selectSingleValueByIndex(AddContractor_Pkg__Claim_Page.selectPolicyNo(driver), 1);
		
		AddContractor_Pkg__Claim_Page.claimDescription(driver).sendKeys("Testing Claim");
		
		AddContractor_Pkg__Claim_Page.saveAndContinueBtn(driver).click();
		Thread.sleep(5000);
		AddContractor_Pkg__Claim_Page.AlertOkBtn(driver).click();
		Thread.sleep(5000);
		
		AddContractor_Pkg__Claim_Page.provoiderFirstName(driver).sendKeys("Alexy");
		AddContractor_Pkg__Claim_Page.injuryDetailPagesaveAndContineBtn(driver).click();
		Thread.sleep(5000);
		
//		wb.waitForElemnet(AddContractor_Pkg__Claim_Page.radioBtnBusinessEntity(driver));
		Thread.sleep(8000);
	//claimant info page	
		String value = AddContractor_Pkg__Claim_Page.radioBtnBusinessEntity(driver).getAttribute("disabled");
		System.out.println(value);
		
		if(value.equals("disabled"))
		{
			System.out.println("Business Entity Radio Button is Disabled");
		}
		else{
			System.out.println("Business Entity Radio Button is not Disabled");
		}
		
		AddContractor_Pkg__Claim_Page.claimantFirstName(driver).sendKeys("David");
		AddContractor_Pkg__Claim_Page.claimantLastName(driver).sendKeys("Warner");
		AddContractor_Pkg__Claim_Page.claimantPhoneNo(driver).sendKeys(RandomClass.randomPhoneNo());
		AddContractor_Pkg__Claim_Page.claimantJobTitle(driver).sendKeys("Admin");
		AddContractor_Pkg__Claim_Page.addressLine1(driver).sendKeys("North Tower West Side New York");
		AddContractor_Pkg__Claim_Page.city(driver).sendKeys("New York");
		
		wb.selectSingleValue(AddContractor_Pkg__Claim_Page.selectState(driver), "California (CA)");
		AddContractor_Pkg__Claim_Page.zip(driver).sendKeys("784598659");
		AddContractor_Pkg__Claim_Page.ClaimantInformationSaveAndContinueBtn(driver).click();
		Thread.sleep(5000);	
		
//Financial Data page		
		AddContractor_Pkg__Claim_Page.insurerBICom(driver).sendKeys("1000");
		AddContractor_Pkg__Claim_Page.insurerOsPdCall(driver).sendKeys("1000");
		AddContractor_Pkg__Claim_Page.insurerOsExpense(driver).sendKeys("1000");
		AddContractor_Pkg__Claim_Page.insurerOsLegal(driver).sendKeys("1000");
		AddContractor_Pkg__Claim_Page.netOsTotal(driver).sendKeys("1000");
		AddContractor_Pkg__Claim_Page.insurerPaidComp(driver).sendKeys("1000");
		AddContractor_Pkg__Claim_Page.insurerPaidColl(driver).sendKeys("1000");
		AddContractor_Pkg__Claim_Page.insurerPaidExpense(driver).sendKeys("1000");
		AddContractor_Pkg__Claim_Page.insurerPaidLegal(driver).sendKeys("1000");
		AddContractor_Pkg__Claim_Page.netPaidTotal(driver).sendKeys("1000");
		AddContractor_Pkg__Claim_Page.RecoveryReceivedComp(driver).sendKeys("1000");
		AddContractor_Pkg__Claim_Page.RecoveryReceivedColl(driver).sendKeys("1000");
		AddContractor_Pkg__Claim_Page.RecoveryReceivedExpense(driver).sendKeys("1000");
		AddContractor_Pkg__Claim_Page.claimAmount(driver).sendKeys("1000");
		AddContractor_Pkg__Claim_Page.actionNoteTextArea(driver).sendKeys("1000");
		AddContractor_Pkg__Claim_Page.finacialDataSaveAndContinueButton(driver).click();
		Thread.sleep(5000);
		
		AddContractor_Pkg__Claim_Page.prepairedByTitle(driver).sendKeys("TestTitle");
		
		
		js.executeScript("arguments[0].scrollIntoView();",AddContractor_Pkg__Claim_Page.uploadDocumentLink(driver));
		AddContractor_Pkg__Claim_Page.uploadDocumentLink(driver).click();
		Thread.sleep(10000);
		// add file through AutoIT
		Runtime.getRuntime().exec("E:\\kp workspace selenium\\Wrap Portal\\AutoIT Script\\FileUpload.exe");
		Thread.sleep(10000);
		
		AddContractor_Pkg__Claim_Page.otherInfoAndDocSaveAndCloseButton(driver).click();
		driver.switchTo().window(wb.map.get("parentID"));
		
		
		/*
		AddContractor_Pkg__Claim_Page.ClaimInfo_ClaimDate(driver).sendKeys("10/27/2020");
		AddContractor_Pkg__Claim_Page.ClaimInfo_ClaimDate(driver).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Claim date is enetred succesfully");
		AddContractor_Pkg__Claim_Page.ClaimInfo_Claim_Number(driver).sendKeys("1234");
		Thread.sleep(2000);
		AddContractor_Pkg__Claim_Page.ClaimInfo_Policy_Number(driver).sendKeys("1234");
		Thread.sleep(2000);
		WebElement claimLogStatus = AddContractor_Pkg__Claim_Page.ClaimInfo_Claim_Status(driver);
		Select SclaimLogStatus = new Select(claimLogStatus);
		SclaimLogStatus.selectByIndex(1);
		System.out.println("claim LogStatus   is Seelcted  ");
		test.log(LogStatus.PASS, "Claim LogStatus  is Selected  succesfully");
		Thread.sleep(2000);
		WebElement claimType = AddContractor_Pkg__Claim_Page.ClaimInfo_claim_Type(driver);
		Select SclaimType = new Select(claimType);
		SclaimType.selectByIndex(0);
		// System.out.println("claim type is Seelcted ");
		test.log(LogStatus.PASS, "Claim type is selected  succesfully");
		WebElement claimSpecificcode = AddContractor_Pkg__Claim_Page.claimInfo_Claim_Specific_Class_code(driver);
		Select SclaimSpecificcodee = new Select(claimSpecificcode);
		SclaimSpecificcodee.selectByIndex(1);
		// System.out.println("claim specific code is Seelcted ");
		test.log(LogStatus.PASS, "Claim Specificc date  is enetred succesfully");
		AddContractor_Pkg__Claim_Page.ClaimInfo_ReportDate(driver).sendKeys("10/06/2020");
		AddContractor_Pkg__Claim_Page.ClaimInfo_ReportDate(driver).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		AddContractor_Pkg__Claim_Page.ClaimInfo_Closed_Date(driver).sendKeys("11/06/2020");
		AddContractor_Pkg__Claim_Page.ClaimInfo_Closed_Date(driver).sendKeys(Keys.TAB);
		AddContractor_Pkg__Claim_Page.ClaimInfo_Primary_Physician_Used(driver).sendKeys("Raja the physian");
		Thread.sleep(2000);
		AddContractor_Pkg__Claim_Page.ClaimInfo_Loss_Date(driver).sendKeys("10/01/2020");
		AddContractor_Pkg__Claim_Page.ClaimInfo_Loss_Date(driver).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		AddContractor_Pkg__Claim_Page.ClaimInfo_Loss_Time(driver).sendKeys("16:30");
		Thread.sleep(2000);
		AddContractor_Pkg__Claim_Page.ClaimInfo_Loss_Time(driver).sendKeys(Keys.TAB);

		AddContractor_Pkg__Claim_Page.ClaimInfo_Loss_code(driver).sendKeys("1234");
		Thread.sleep(2000);
		AddContractor_Pkg__Claim_Page.ClaimInfo_Claim_Description(driver)
				.sendKeys("this is the claim description feild");
		Thread.sleep(2000);
		AddContractor_Pkg__Claim_Page.ClaimantInfo_Claimant_Name(driver).sendKeys("raja the claimant");
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Claimant name  is enetred succesfully");
		AddContractor_Pkg__Claim_Page.ClaimantInfo_ClaimantAddress_1(driver).sendKeys("Texas");
		Thread.sleep(2000);
		AddContractor_Pkg__Claim_Page.ClaimantInfo_ClaimantAddress_2(driver).sendKeys("Texas");
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Claimant Address  is enetred succesfully");
		AddContractor_Pkg__Claim_Page.ClaimantInfo_Claimant_Phone(driver).sendKeys("99862520851234");
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Claimant  phone num  is enetred succesfully");
		AddContractor_Pkg__Claim_Page.Other_Info_Prepared_by_First_Name(driver).sendKeys("Raja");
		Thread.sleep(2000);
		AddContractor_Pkg__Claim_Page.Other_Info_Prepared_by_Last_Name(driver).sendKeys("Reddy");
		AddContractor_Pkg__Claim_Page.Other_Info_Prepared_by_Email(driver).sendKeys("raja.reddy@nourtek.com");
		test.log(LogStatus.PASS, "Claimant email is enetred succesfully");
		Thread.sleep(2000);
		AddContractor_Pkg__Claim_Page.Other_Info_Prepared_by_Telephone(driver).sendKeys("99862520851234");
		AddContractor_Pkg__Claim_Page.Financial_Data_Insurer_OS_Medical_BI_Comp(driver).sendKeys("1000");
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Claimant Financial data is enetred succesfully");
		AddContractor_Pkg__Claim_Page.Financial_Data_Insurer_Paid_Medical_BI_Comp(driver).sendKeys("1000");
		test.log(LogStatus.PASS, "Claimant Financial data Insurer paid medical BI comp is enetred succesfully");
		Thread.sleep(2000);
		AddContractor_Pkg__Claim_Page.Financial_Data_Recovery_Received_Medical_BI_Comp(driver).sendKeys("1000");
		test.log(LogStatus.PASS,
				"Claimant Financial data recovery Medical BI comp paid medical BI comp is enetred succesfully");
		Thread.sleep(2000);
		AddContractor_Pkg__Claim_Page.Financial_Data_Claim_Amount(driver).sendKeys("1500");
		test.log(LogStatus.PASS,
				"Claimant Financial data recovery Medical BI comp paid medical BI comp is enetred succesfully");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(6000);
		AddContractor_Pkg__Claim_Page.Review_Admin_Markas_Confirm(driver).click();
		test.log(LogStatus.PASS, "Claimant Review Admin Marks Confirm   is clicked succesfully");
		Thread.sleep(2000);
		AddContractor_Pkg__Claim_Page.Review_Admin_Action_Notes(driver)
				.sendKeys("This Action notes is for admin review only");
		test.log(LogStatus.PASS, "Admin review Action notes  is enetred succesfully");
		Thread.sleep(2000);
		AddContractor_Pkg__Claim_Page.CloseBtn_ClaimsTab(driver).click();
		test.log(LogStatus.PASS, "cliams page close button is clicked succesfully ");
		// driver.switchTo().window(id1);
		wb.Switchtoparent();
		System.out.println("Switched to parent");
		// test.log(LogStatus.PASS,
		// test.addScreenCapture(GenericLibrary.BaseClass.captureScreen(driver,
		// "ClaimAdditionModule")));
		test.log(LogStatus.PASS, "Report Generated " + test.addScreenCapture(FileUtils1.getScreenshot(driver)));
		
		*/
	}

}
