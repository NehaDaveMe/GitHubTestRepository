package ModulerLibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import ObjectRepository.AddContractor_Pkg_Insurance_Enrollment_Page;
import ObjectRepository.ContractorPackageModule;
import ObjectRepository.HomePage;

public class WPO_SelectContractorPkgAction extends BaseClass
{
	

	public static void selectContractorpkg(String contractorPKGno ,String tabName) throws InterruptedException
	{	
		
		HomePage.controlMenuContractorPackage(driver).click();
		Thread.sleep(6000);
		test.log(LogStatus.INFO, "Clicked On Control Menu Contractor Package Icon");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)", "");
		
		/*js.executeScript("arguments[0].click();",ContractorPackageModule.addIcon(driver));
		test.log(LogStatus.INFO, "Clicked On Add Contractor Package Icon");
*/		Thread.sleep(2000);
		
		ContractorPackageModule.advanceSearchIcon(driver).click();
		Thread.sleep(2000);
		ContractorPackageModule.advanceSearchSearchByContractorNumber(driver).sendKeys(contractorPKGno);
		Thread.sleep(4000);
		ContractorPackageModule.advanceSearchSearchBtn(driver).click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		System.out.println(ContractorPackageModule.fetchTradeNamePriviewP(driver).getText());
		
		WebDriverCommonLib wb = new WebDriverCommonLib();
		
		// insurance enrollment page
		wb.waitForElemnet(ContractorPackageModule.InsuranceEnrollmentPagePriviewP(driver));
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Clicked on Insurance Enrollment Page");
		
		
	/*	wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		driver.manage().window().maximize();
		// AddContractor_Pkg_Insurance_Enrollment_Page.InsuranceEnrollmentTab(driver).click();
		Thread.sleep(7000);
		
		 AddContractor_Pkg_Insurance_Enrollment_Page.enrollContractorPkgAllTab(driver, tabName).click();
	*/	 
	/*	 List<WebElement> listOfPremium = AddContractor_WC_Premiums_Modifications_Page.premiumValues(driver);
			System.out.println("size of list" + listOfPremium.size());
			for (int i=0;i<=listOfPremium.size()-1;i++) 
			{
				System.out.println(listOfPremium.get(i).getAttribute("value"));
			}
			Thread.sleep(2000);
			AddContractor_WC_Premiums_Modifications_Page.btnSaveAndClose(driver).click();
			Thread.sleep(4000);
			
			driver.switchTo().window(wb.map.get("parentID"));*/
			
//		 return listOfPremium;
	}
	public static void selectContractorpkgPayroll(String contractorPKGno ,String tabName) throws InterruptedException
	{	
		
		HomePage.controlMenuContractorPackage(driver).click();
		Thread.sleep(6000);
		test.log(LogStatus.INFO, "Clicked On Control Menu Contractor Package Icon");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)", "");
		
		/*js.executeScript("arguments[0].click();",ContractorPackageModule.addIcon(driver));
		test.log(LogStatus.INFO, "Clicked On Add Contractor Package Icon");
*/		Thread.sleep(2000);
		
		ContractorPackageModule.advanceSearchIcon(driver).click();
		Thread.sleep(2000);
		ContractorPackageModule.advanceSearchSearchByContractorNumber(driver).sendKeys(contractorPKGno);
		Thread.sleep(4000);
		ContractorPackageModule.advanceSearchSearchBtn(driver).click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		System.out.println(ContractorPackageModule.fetchTradeNamePriviewP(driver).getText());
		ContractorPackageModule.MonthlyPayrollSeeMorePriviewP(driver).click();
		
		
		
//		WebDriverCommonLib wb = new WebDriverCommonLib();
//		
//		// insurance enrollment page
//		wb.waitForElemnet(ContractorPackageModule.InsuranceEnrollmentPagePriviewP(driver));
//		Thread.sleep(2000);
//		test.log(LogStatus.INFO, "Clicked on Insurance Enrollment Page");
	}
	
	public static void selectContractorpkgOnly(String contractorPKGno) throws InterruptedException
	{	
		
		HomePage.controlMenuContractorPackage(driver).click();
		test.log(LogStatus.INFO, "Clicked On Control Menu Contractor Package Icon");
		Thread.sleep(6000);
		WebDriverCommonLib wb = new WebDriverCommonLib();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,-350)", "");
		int x = 1;
		do {
			try {
				wb.waitForElemnet(ContractorPackageModule.searchEditBox(driver));			
				test.log(LogStatus.INFO, "Clicked in Search Edit Box");
				x=2;
			} catch (Throwable e) {
				System.out.println("Search icon not found " +e);
				js.executeScript("window.scrollBy(0,-350)", "");
			}
		} while (x==1);		
		
		Thread.sleep(2000);
		ContractorPackageModule.advanceSearchIcon(driver).click();
		Thread.sleep(2000);
		ContractorPackageModule.advanceSearchSearchByContractorNumber(driver).sendKeys(contractorPKGno);
		Thread.sleep(4000);
		ContractorPackageModule.advanceSearchSearchBtn(driver).click();
		Thread.sleep(2000);
		
		}
	
	public static void selectContractorpkgWithTrade(String tradeNO) throws InterruptedException
	{	
		
		HomePage.controlMenuContractorPackage(driver).click();
		test.log(LogStatus.INFO, "Clicked On Control Menu Contractor Package Icon");
		Thread.sleep(6000);
		WebDriverCommonLib wb = new WebDriverCommonLib();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,-350)", "");
		int x = 1;
		do {
			try {
				wb.waitForElemnet(ContractorPackageModule.searchEditBox(driver));			
				test.log(LogStatus.INFO, "Clicked in Search Edit Box");
				x=2;
			} catch (Throwable e) {
				System.out.println("Search icon not found " +e);
				js.executeScript("window.scrollBy(0,-350)", "");
			}
		} while (x==1);		
		
		Thread.sleep(2000);
		ContractorPackageModule.advanceSearchIcon(driver).click();
		Thread.sleep(2000);
		ContractorPackageModule.advanceSearchSearchForTrade(driver).sendKeys(tradeNO,Keys.TAB);
		Thread.sleep(4000);
		ContractorPackageModule.advanceSearchSearchBtn(driver).click();
		Thread.sleep(2000);
		
		}
}
