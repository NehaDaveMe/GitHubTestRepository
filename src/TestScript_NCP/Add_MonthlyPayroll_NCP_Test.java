package TestScript_NCP;


import java.util.List;

//import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import ModulerLibrary.NCP_LoginAction;
import ObjectRepository_NCP.EnrollCP_AddMothlyPayrollPage;
import ObjectRepository_NCP.NCP_HomePage;

public class Add_MonthlyPayroll_NCP_Test extends BaseClass
{
	WebDriverCommonLib wb= new WebDriverCommonLib();
	String programName="Automation Program dont touch";
	String projectName="Test 132 ON";
	String tradeNumber="TRANO5892";//Trades4501
	public String uName="JimmySmith114540";//"JimmySmith114211";//"JimmySmith113888";//"JimmySmith114211";//
	public String password= "Admin@123";//"Admin@123";
	
	@Test
	public void testMonthlyPayroll() throws Throwable
	{
	/*@Test
	public void testMonthlyPayroll(String TestCaseName,String programName, String projectName , String tradeName) throws Throwable
	{*/
		String BaseUrl=driver.getCurrentUrl();
		
//		NCP_LoginAction.logInNCP(driver);
		NCP_LoginAction.logInNCPCommon(driver, uName, password);
		NCP_HomePage.btnFilterBy(driver).click();
		test.log(LogStatus.PASS, " Clicked On Filter Button");
		
		wb.waitForElemnet(NCP_HomePage.selectProgramField(driver));
//		NCP_HomePage.selectProgramField(driver).click();
		test.log(LogStatus.PASS, " Clicked On Select Program Field");
		Thread.sleep(2000);
		wb.selectSingleValueFromList(NCP_HomePage.selectProgramFromList(driver),programName );
		test.log(LogStatus.PASS, programName+" Program Name successfully selected form drop down");
		Thread.sleep(2500);
		
		wb.waitForElemnet(NCP_HomePage.selectProjectField(driver));
//		NCP_HomePage.selectProjectField(driver).click();
		test.log(LogStatus.PASS, " Clicked On Select Project Field");
		Thread.sleep(2000);
		wb.selectSingleValueFromList(NCP_HomePage.selectProjectFromList(driver),projectName );
		test.log(LogStatus.PASS, projectName+" Project Name successfully selected form drop down");
		Thread.sleep(2900);
		
		//update the code Select trade from list 05/03/2021 by kp
		NCP_HomePage.selectTradeField(driver).click();
		test.log(LogStatus.PASS, " Clicked On Select Trade Field");
		Thread.sleep(3000);
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
		Thread.sleep(4000);
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<WebElement> payroll = EnrollCP_AddMothlyPayrollPage.addPayrollForALLWorkClass(driver);
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
		Thread.sleep(4000);
		if(EnrollCP_AddMothlyPayrollPage.addPayrollNextMonthBtn(driver).isDisplayed()==true)
		{
			js.executeScript("arguments[0].click();",EnrollCP_AddMothlyPayrollPage.addPayrollNextMonthBtn(driver));
//			EnrollCP_AddMothlyPayrollPage.addPayrollNextMonthBtn(driver).click();
			Thread.sleep(7000);
			test.log(LogStatus.PASS, " Clicked on Continue Next Month Payroll Button");
			fillPayroll();
		}else
		{
			js.executeScript("arguments[0].click();",EnrollCP_AddMothlyPayrollPage.addPayrollSaveBtn(driver));
//			EnrollCP_AddMothlyPayrollPage.addPayrollSaveBtn(driver).click();
			test.log(LogStatus.PASS, " Clicked on Payroll Save Button");
			Thread.sleep(7000);
		}
		
	}
	
}
