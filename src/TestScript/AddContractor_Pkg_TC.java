package TestScript;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.RandomClass;
import ObjectRepository.AddContractor_Pkg_Page;
import ObjectRepository.AddTradePage;
import ObjectRepository.ContractorPackageModule;
import ObjectRepository.HomePage;

public class AddContractor_Pkg_TC extends BaseClass
{
	
	WebDriverCommonLib wb=new WebDriverCommonLib();
	String ranTrade=RandomClass.randomTrade();
	String programName="Sony Programs3524";//"Sony Tower One Prog";
	String projectName="Sony Projects3524";//"Automation Testing- Project 1";//"Sony Project1834";
	String contractorCompany="Alex Comp3524";//"sony";
	String contactName="Jimmy Smith";//"Rock Smith";//jonty rod
	public String tradeNumber = RandomClass.randomTradeNO();
	
	@Test
	public void addContractorPackage() throws InterruptedException
	{
		HomePage.controlMenuContractorPackage(driver).click();
		Thread.sleep(6000);
		test.log(LogStatus.INFO, "Clicked On Control Menu Contractor Package Icon");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,-250)", "");
		js.executeScript("arguments[0].click();",ContractorPackageModule.addIcon(driver));
		test.log(LogStatus.INFO, "Clicked On Add Contractor Package Icon");
		Thread.sleep(2000);
		//ContractorPackageModule.addIcon(driver).click();
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		driver.manage().window().maximize();
		
		//Select program 
		wb.waitForElemnet(AddContractor_Pkg_Page.selectProgram(driver));
		AddContractor_Pkg_Page.selectProgramSearchBox(driver).sendKeys(programName);
		
		wb.selectSingleValueFromList(AddContractor_Pkg_Page.selectProgramDropdownAutocomplete(driver), programName);
//		AddContractor_Pkg_Page.selectProgramSearchBox(driver).sendKeys("Sony Tower Test",Keys.TAB);
		System.out.println("Program Added Successfully");
		test.log(LogStatus.PASS, programName+" Program  added successfully");
		Thread.sleep(2500);
		//select project
		AddContractor_Pkg_Page.selectProject(driver).click();
		AddContractor_Pkg_Page.selectProjectSearchBox(driver).sendKeys(projectName);
		wb.selectSingleValueFromList(AddContractor_Pkg_Page.selectProjectDropdownAutocomplete(driver), projectName);
		System.out.println("Project Added Successfully");
		test.log(LogStatus.PASS, projectName+ " Project added successfully");
		
		Thread.sleep(2000);
		//select enrollment type
		AddContractor_Pkg_Page.selectEnrollmentType(driver).click();
		AddContractor_Pkg_Page.selectEnrollmentTypeSearchBox(driver).sendKeys("WC & GL");
		System.out.println("Enrollment Type Added Successfully");
		test.log(LogStatus.PASS, "Enrollment Type added successfully");
		wb.selectSingleValueFromList(AddContractor_Pkg_Page.selectEnrollmentTypeDropdownAutocomplete(driver), "WC & GL Enrollment");
		//select contractor
		AddContractor_Pkg_Page.selectContractor(driver).click();
		AddContractor_Pkg_Page.selectContractor(driver).sendKeys(contractorCompany);
		Thread.sleep(2000);
		AddContractor_Pkg_Page.selectContractor(driver).sendKeys(Keys.ENTER);
		System.out.println("Contractor Added Successfully");
		test.log(LogStatus.PASS, "Contractor added successfully");
		Thread.sleep(2000);
		
		//select contact
		AddContractor_Pkg_Page.SelectContact(driver).click();
		AddContractor_Pkg_Page.SelectContactSearchBox(driver).click();
		wb.selectSingleValueFromList(AddContractor_Pkg_Page.SelectContactAutoCompllete(driver), contactName);
		test.log(LogStatus.PASS, contactName+" Contact added successfully");
		Thread.sleep(2500);
		
		
		//select Trade
		
		/*AddContractor_Pkg_Page.selectTrade(driver).click();
		System.out.println(ranTrade);
//		AddContractor_Pkg_Page.selectTradeSearchBox(driver).click();
//		wb.printListData(AddContractor_Pkg_Page.selectTradeDropdownAutocomplete(driver));
		AddContractor_Pkg_Page.selectTradeSearchBox(driver).sendKeys(ranTrade);
		wb.selectSingleValueFromList(AddContractor_Pkg_Page.selectTradeDropdownAutocomplete(driver), ranTrade);
		Thread.sleep(2000);
		System.out.println("Trade Added Successfully");
		test.log(LogStatus.PASS, "Trade added successfully");*/
		
		String tradeName=RandomClass.randomTradeDescription();
		AddContractor_Pkg_Page.addNewTradeLink(driver).click();
		test.log(LogStatus.PASS, "Click on Add New Trade Link");
		wb.getWindowID3();
		driver.switchTo().window(wb.map.get("subchildID"));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		AddTradePage.addTrade_TradeDescriptionField(driver).sendKeys(RandomClass.randomTradeDescription());
		test.log(LogStatus.PASS, "Trade Description Added Successfully");
		
		
		
		System.out.println(tradeNumber);
		AddTradePage.addTrade_TradeNumberField(driver).sendKeys(tradeNumber);
		test.log(LogStatus.PASS, tradeNumber+"Trade Number Added Successfully");
		wb.selectSingleValue(AddTradePage.addTrade_TradeStatusField(driver), "Active");
		test.log(LogStatus.PASS, "Trade Status Selected Successfully");
		AddTradePage.addTradeSaveAndCloseBtn(driver).click();
		
		int x=1;
		do {
			try {	
					Alert alt=driver.switchTo().alert();
					Thread.sleep(2000);
					alt.accept();
					Random ran = new Random();
					int rNo = ran.nextInt(100000);
					String newtradeNumber="TNO"+rNo;
					tradeNumber=newtradeNumber;
					Thread.sleep(1000);
					AddTradePage.addTrade_TradeNumberField(driver).clear();
					Thread.sleep(1000);
					AddTradePage.addTrade_TradeNumberField(driver).sendKeys(tradeNumber);
					test.log(LogStatus.PASS, "Trade Number Added Successfully");
					AddTradePage.addTradeSaveAndCloseBtn(driver).click();
			} catch (Throwable e) 
			{
				System.out.println("Trade Alert Not Present"+e);
				x=2;
			}
		} while (x==1);
		
		driver.switchTo().window(wb.map.get("childID"));
		System.out.println("Trade Added Successfully");
		test.log(LogStatus.PASS, tradeName+" Trade added successfully");
		
		
		
		AddContractor_Pkg_Page.btnNext(driver).click();
		test.log(LogStatus.INFO, "Clicked On Next Button");
		Thread.sleep(1000);
		AddContractor_Pkg_Page.alertConfirmComplianceContinueBtn(driver).click();//newly added alert for compliance button 20/01/2020
		
		AddContractor_Pkg_Page.sendEmailCloseBtn(driver).click();
		driver.switchTo().window(wb.map.get("parentID"));
		System.out.println("Contractor Package Created Successfully");
		test.log(LogStatus.PASS, "Contractor Package Created successfully");
		
	}
}
