package ModulerLibrary;

import org.openqa.selenium.JavascriptExecutor;
import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import ObjectRepository.AddContractor_Pkg_GL_Umbrella_Coverage_Page;
import ObjectRepository.AddContractor_Pkg_Insurance_Enrollment_Page;
import ObjectRepository.AddContractor_Pkg_WC_Premiums_Modifications_Page;
import ObjectRepository.ContractorPackageModule;
import ObjectRepository.HomePage;

public class OCP_ConfirmEnrollCPFrmAdminAction extends BaseClass
{
	
	public static void confirmFromAdminSide(String tradeNumber , String enrollmentStartDate) throws Throwable
	{
		WebDriverCommonLib wb=new WebDriverCommonLib();
		
//Confirm From Admin		
		HomePage.controlMenuHomeIcon(driver).click();
		test.log(LogStatus.INFO, "Clicked On Home Icon");
		HomePage.HomeMenuContractorPackage(driver).click();
		test.log(LogStatus.INFO, "Clicked On Contracotr Package Icon");

		// search for contractor package
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
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
		
		AddContractor_Pkg_Insurance_Enrollment_Page.enrollmentDate(driver).sendKeys(enrollmentStartDate);
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
		driver.switchTo().defaultContent();
	}
}
