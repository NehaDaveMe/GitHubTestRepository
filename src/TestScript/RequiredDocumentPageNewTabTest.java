package TestScript;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.RandomClass;
import ModulerLibrary.WPO_SelectContractorPkgAction;
import ObjectRepository.AddContractor_Pkg_Insurance_Enrollment_Page;
import ObjectRepository.AddContractor_Pkg_Required_Documents_Page;

public class RequiredDocumentPageNewTabTest extends BaseClass
{
	
	WebDriverCommonLib wb = new WebDriverCommonLib();
	public String contractorName = "Alex Comp3524";
	public String projectName = "Sony Projects3524";
	public String programName = "Sony Programs3524";// "Sony Tower One Prog";
	public String contractorCompany = "Alex Comp3524";// "sony";
	public String contactName = "Jimmy Smith";
	public String tradeNumber = RandomClass.randomTradeNO();
	public String insuranceCompName = "Carriers3524";
	public String submissionFrequency = "Quarterly";
	public String reportTime = "Quarterly";
	public String contractorPKGno = "P121545-P121545CONTRACTOR_PKG_NO32227";
	public String EnrollmentType = "WC & GL Enrollment";
	public String tabName = "Required Document";
	
	
	@Test
	public void verifyDocumentOpenFunctionalityTest() throws InterruptedException, IOException 
	{
		
		WPO_SelectContractorPkgAction.selectContractorpkg(contractorPKGno, tabName);
		test.log(LogStatus.INFO, " Contractor Pkg Selected Successfully");
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		driver.manage().window().maximize();
		// AddContractor_Pkg_Insurance_Enrollment_Page.InsuranceEnrollmentTab(driver).click();
		Thread.sleep(9000);
		AddContractor_Pkg_Insurance_Enrollment_Page.enrollContractorPkgAllTab(driver, tabName).click();
		Thread.sleep(7000);
		test.log(LogStatus.INFO, " Required Document Tab is selected Successfully");
		
		//xpath is work for only signed enrollment document
//		AddContractor_Pkg_Required_Documents_Page.signEnrollmentDocumentLink(driver).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",AddContractor_Pkg_Required_Documents_Page.signEnrollmentDocumentLink(driver));
		
	//	wb.mouseMoveToElementwithoutClick(AddContractor_Pkg_Required_Documents_Page.signEnrollmentDocumentLink(driver));
		//Thread.sleep(2000);
		
		js.executeScript("arguments[0].click();",AddContractor_Pkg_Required_Documents_Page.signEnrollmentDocumentLinkOpen(driver));
		
//		AddContractor_Pkg_Required_Documents_Page.signEnrollmentDocumentLinkOpen(driver).click();
		
		Thread.sleep(2000);
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
//		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("Required Documents - Wrap-Portal"))
		{
			System.out.println("Title Matched");
		}
		else
		{
			System.out.println("Title did't Matched");
		}
		driver.close();
		driver.switchTo().window(wb.map.get("parentID"));
		
	}
	
}
