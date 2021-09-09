package TestScript;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.RandomClass;
import ModulerLibrary.WPO_SelectContractorPkgAction;
import ObjectRepository.AddContractor_Pkg_Insurance_Enrollment_Page;
import ObjectRepository.AddContractor_Pkg_WC_Premiums_Modifications_Page;

public class LocationCodeDuplicationTest extends BaseClass
{	
	
	WebDriverCommonLib wb = new WebDriverCommonLib();
	public String contractorName = "Alex Comp2273";
	public String projectName = "Test Sony project Reg 123";// "Sony
															// Projects3524";
	public String programName = "Test Sony Program 123";// "Sony
														// Programs3524";//"Sony
														// Tower One Prog";
	public String contractorCompany = "Alex Comp2273";// "sony";
	public String contactName = "Jimmy Smith";
	public String tradeNumber = RandomClass.randomTradeNO();
	public String contractorPKGno = "P121545-P121545CONTRACTOR_PKG_NO32227";//PC3524-P3524CONTRACTOR_PKG_NO43235";//RandomClass.randomContractorPkgNo();//"PC3524-P3524CONTRACTOR_PKG_NO50396";
	public String insuranceCompName = "Carriers3524";
	public String submissionFrequency = "Quarterly";
	public String reportTime = "Quarterly";
	public String tabName = "WC Premiums Modifications";
	
@Test
public void locationDuplicationCodeTest() throws InterruptedException
{
	WPO_SelectContractorPkgAction.selectContractorpkg(contractorPKGno, tabName);
	wb.getWindowIDs();
	driver.switchTo().window(wb.map.get("childID"));
	driver.manage().window().maximize();
	// AddContractor_Pkg_Insurance_Enrollment_Page.InsuranceEnrollmentTab(driver).click();
	Thread.sleep(9000);
//	AddContractor_Pkg_Insurance_Enrollment_Page.enrollContractorPkgAllTab(driver, tabName).click();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();",AddContractor_Pkg_Insurance_Enrollment_Page.fieldLocationNumber(driver));
//	String oldLocationCode = AddContractor_Pkg_Insurance_Enrollment_Page.fieldLocationNumber(driver).getText();
//	System.out.println("Old Loaction Code"+oldLocationCode);
	AddContractor_Pkg_Insurance_Enrollment_Page.fieldLocationNumber(driver).clear();
	
	AddContractor_Pkg_Insurance_Enrollment_Page.fieldLocationNumber(driver).sendKeys("Div3010");
	
	AddContractor_Pkg_Insurance_Enrollment_Page.btnSave(driver).click();
	Thread.sleep(3000);
	try {
		AddContractor_Pkg_Insurance_Enrollment_Page.locationCodeDuplicateAlertCancelBtn(driver).click();
		test.log(LogStatus.PASS, " Duplicate Code Allowed and cancel it");
	} catch (Exception e) {
		test.log(LogStatus.PASS, " Duplicate Code is not Allowed and cancel it");
		// TODO: handle exception
	}
	
	driver.close();
	driver.switchTo().window(wb.map.get("parentID"));

}
	
}
