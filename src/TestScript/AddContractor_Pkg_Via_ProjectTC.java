package TestScript;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.RandomClass;
import ObjectRepository.AddContractor_Pkg_Page;
import ObjectRepository.AddProject_General_Information_Page;
import ObjectRepository.AddTradePage;
import ObjectRepository.HomePage;
import ObjectRepository.ProjectModule;

public class AddContractor_Pkg_Via_ProjectTC extends BaseClass
{
	WebDriverCommonLib wb=new WebDriverCommonLib();
	String ProjectName="Sony Projects3524";
	
	@Test
	public void add_CP_Via_Project() throws InterruptedException
	{
		HomePage.controlMenuHomeIcon(driver).click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Clicked on Home Icon");
		HomePage.HomeMenuProjects(driver).click();
		test.log(LogStatus.PASS, "Clicked on Project Module Icon");
		ProjectModule.projectSearchEditBox(driver).sendKeys(ProjectName);
		test.log(LogStatus.PASS, "Search for Project "+ProjectName);
		Thread.sleep(1000);
		ProjectModule.projectSearchIcon(driver).click();
		test.log(LogStatus.PASS, "Clicked on Search Project Icon");
		Thread.sleep(3000);
		ProjectModule.projectEditIcon(driver).click();
		test.log(LogStatus.PASS, "Clicked on Edit Project Icon");
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");//Scroll down
		AddProject_General_Information_Page.linkCreateContractorPkg(driver).click();
		test.log(LogStatus.PASS, "Clicked Create Contractor Package Link");
		wb.getWindowID3();
		driver.switchTo().window(wb.map.get("subchildID"));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		AddContractor_Pkg_Page.non_CIP_Compliance(driver).click();
		Thread.sleep(1000);
		wb.selectSingleValueFromList(AddContractor_Pkg_Page.selectCompliance(driver), "Compliance29");
		test.log(LogStatus.PASS," Compliance added successfully");		
		
		String tradeName=RandomClass.randomTradeDescription();
		AddContractor_Pkg_Page.addNewTradeLink(driver).click();
		test.log(LogStatus.PASS, "Click on Add New Trade Link");
		wb.getWindowID4();
		driver.switchTo().window(wb.map.get("subsubchildID"));
		Thread.sleep(2000);

		driver.manage().window().maximize();
		AddTradePage.addTrade_TradeDescriptionField(driver).sendKeys(RandomClass.randomTradeDescription());
		test.log(LogStatus.PASS, "Trade Description Added Successfully");
		AddTradePage.addTrade_TradeNumberField(driver).sendKeys(RandomClass.randomTradeNO());
		test.log(LogStatus.PASS, "Trade Number Added Successfully");
		wb.selectSingleValue(AddTradePage.addTrade_TradeStatusField(driver), "Active");
		test.log(LogStatus.PASS, "Trade Status Selected Successfully");
		AddTradePage.addTradeSaveAndCloseBtn(driver).click();
		driver.switchTo().window(wb.map.get("subchildID"));
		System.out.println("Trade Added Successfully");
		test.log(LogStatus.PASS, tradeName+" Trade added successfully");
		Thread.sleep(2000);
		
		
		AddContractor_Pkg_Page.btnNext(driver).click();
		test.log(LogStatus.PASS, "Clicked On Next Button");
		Thread.sleep(1000);
		try {
			
			AddContractor_Pkg_Page.alertConfirmComplianceContinueBtn(driver).click();		
		
		} catch (Throwable e) 
		{
			System.out.println(e);
		}
				
		AddContractor_Pkg_Page.sendEmailCloseBtn(driver).click();
		driver.switchTo().window(wb.map.get("childID"));
		System.out.println("Contractor Package Created Successfully");
		test.log(LogStatus.PASS, "Contractor Package Created successfully");
		
		driver.close();
		driver.switchTo().window(wb.map.get("parentID"));
		
	}
}
