package TestScipts_CPO;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import ModulerLibrary.CPO_LogInAction;
import ObjectRepository_CPO.CPO_Add_CP_EnrollmentPage;
import ObjectRepository_CPO.CPO_Add_MonthlyPayroll;
import ObjectRepository_CPO.CPO_HomePage;
import ObjectRepository_CPO.CPO_MyProjectsModule;

public class CPO_Add_MonthlyPayroll_Test extends BaseClass
{
	WebDriverCommonLib wb = new WebDriverCommonLib();

	@Test
	public void testMonthlyPayroll() throws Throwable {
		String ProgramName = "Automation Program dont touch";
		String ProjectName = "Test 132 ON";
		String TradeNo="TRANO7199";
		String TradeName="Trades4536";
		String ContractorName="Alex Comp3524";
		String EnrollmentType="WC & GL Enrollment";
		
		String BaseUrl = driver.getCurrentUrl();// store base url for future use
		CPO_LogInAction.logInCPO(driver);
		
		CPO_HomePage.IconMyProjects(driver).click();
		test.log(LogStatus.INFO, " Clicked On My Projects Page");
		wb.selectSingleValue(CPO_MyProjectsModule.selectProgram(driver), ProgramName);
		Thread.sleep(2000);
		wb.selectSingleValue(CPO_MyProjectsModule.selectProjects(driver), ProjectName);
		Thread.sleep(2000);
		wb.selectSingleValue(CPO_MyProjectsModule.selectTrade(driver), TradeName);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", CPO_MyProjectsModule.selectContractorPackage(driver, ProgramName,
				ProjectName, TradeNo, ContractorName, EnrollmentType));
		
		test.log(LogStatus.PASS, ProgramName + " " + ProjectName + " " + TradeNo + " " + EnrollmentType
				+ " Contractor Package Selected");
		js.executeScript("arguments[0].click();", CPO_Add_CP_EnrollmentPage.linkMonthlyPayroll(driver));
		Thread.sleep(1500);
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		driver.manage().window().maximize();
		Thread.sleep(4000);
			
		wb.selectSingleValueByIndex(CPO_Add_MonthlyPayroll.selectPayrollPeriodFromList(driver), 1);
		test.log(LogStatus.PASS, " Payroll Month Selected Successfully");
		
		Thread.sleep(3000);
		fillPayroll();
		
		Thread.sleep(3000);
		driver.switchTo().window(wb.map.get("parentID"));
		driver.navigate().to(BaseUrl);// navigate to base url
		test.log(LogStatus.INFO, " Monthly Payroll Added Successfully");
	}

	public void fillPayroll() throws InterruptedException 
	{
		wb.waitForElemnet(CPO_Add_MonthlyPayroll.addPayrollCVField(driver));
		Actions act = new Actions(driver);
		act.moveToElement(CPO_Add_MonthlyPayroll.addPayrollCVField(driver)).doubleClick().build().perform();
		CPO_Add_MonthlyPayroll.addPayrollCVField(driver).sendKeys("1000");
		test.log(LogStatus.PASS, " Payroll Contract Value Added Successfully");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		act.moveToElement(CPO_Add_MonthlyPayroll.addPayrollSelfCVField(driver)).doubleClick().build().perform();
		CPO_Add_MonthlyPayroll.addPayrollSelfCVField(driver).sendKeys("1000");
		test.log(LogStatus.PASS, " Payroll Self Performed Contract Value Added Successfully");
		
		List<WebElement> payroll = CPO_Add_MonthlyPayroll.addPayrollForALLWorkClass(driver);
		for (WebElement b : payroll) 
		{
			act.moveToElement(b).doubleClick().build().perform();
			Thread.sleep(1000);
			b.sendKeys("100");
			test.log(LogStatus.PASS, " Payroll and hours added Successfully");
		}
		js.executeScript("window.scrollBy(0,150)");
		Thread.sleep(2000);
		
		try {

			CPO_Add_MonthlyPayroll.addPayrollNextMonthBtn(driver).click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, " Clicked on Continue Next Month Payroll Button");
			fillPayroll();

		} catch (Throwable e) {

			System.out.println(e);
			CPO_Add_MonthlyPayroll.addPayrollSaveBtn(driver).click();
			test.log(LogStatus.PASS, " Clicked on Payroll Save Button");
			Thread.sleep(5000);
		}			
			
		 /*else {
			CPO_Add_MonthlyPayroll.addPayrollSaveBtn(driver).click();
			test.log(LogStatus.PASS, " Clicked on Payroll Save Button");
			Thread.sleep(5000);
		}
*/
	}
}
