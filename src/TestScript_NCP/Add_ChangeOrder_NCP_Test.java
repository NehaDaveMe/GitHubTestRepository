package TestScript_NCP;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import ModulerLibrary.NCP_LoginAction;
import ObjectRepository_NCP.EnrollCP_AddChangeOrderPage;
import ObjectRepository_NCP.NCP_HomePage;

public class Add_ChangeOrder_NCP_Test extends BaseClass
{
	WebDriverCommonLib wb= new WebDriverCommonLib();
	String programName="Automation Program dont touch";
	String projectName="Test 132 ON";
	String tradeName="TRANO5892";//TRANO3152 - Neha  //Trades4501
	public String uName="JimmySmith114540";//"JimmySmith114211";//"JimmySmith113888";//"JimmySmith114211";//
	public String password= "Admin@123";//"Admin@123";
	@Test
	/*public void testChangeOrder(String TestCaseName,String programName, String projectName , String tradeName) throws Throwable
	{*/
	public void testChangeOrder() throws Throwable
	{
		String BaseUrl=driver.getCurrentUrl();
//		NCP_LoginAction.logInNCP(driver);
		NCP_LoginAction.logInNCPCommon(driver, uName, password);
		
		NCP_HomePage.btnFilterBy(driver).click();
		test.log(LogStatus.PASS, " Clicked On Filter Button");

		NCP_HomePage.selectProgramField(driver).click();
		test.log(LogStatus.PASS, " Clicked On Select Program Field"); 
		wb.selectSingleValueFromList(NCP_HomePage.selectProgramFromList(driver),programName );
		test.log(LogStatus.PASS, programName+" Program Name successfully selected form drop down");

		NCP_HomePage.selectProjectField(driver).click();
		Thread.sleep(1500);
		test.log(LogStatus.PASS, " Clicked On Select Project Field");
		wb.selectSingleValueFromList(NCP_HomePage.selectProjectFromList(driver),projectName );
		test.log(LogStatus.PASS, tradeName+" Project Name successfully selected form drop down");
		Thread.sleep(2500);
		
		NCP_HomePage.selectTradeField(driver).click();
		test.log(LogStatus.PASS, " Clicked On Select Trade Field");
		Thread.sleep(1500);
		NCP_HomePage.searchForTradeField(driver).click();
		Thread.sleep(1500);
		NCP_HomePage.searchForTradeField(driver).sendKeys(tradeName);
		Thread.sleep(1500);
		System.out.println(tradeName);
		wb.selectSingleValueFromList(NCP_HomePage.selectTradeFromList(driver), tradeName);
		test.log(LogStatus.PASS, tradeName+" Trade successfully selected form drop down");
		Thread.sleep(2500);
		
		NCP_HomePage.btnSearch(driver).click();
		test.log(LogStatus.PASS, " Clicked on Search Button");
		Thread.sleep(3000);

		NCP_HomePage.selectPreviewPanelProjectDropdown(driver, projectName).click();
		test.log(LogStatus.PASS, " Clicked on Selected Contractor Package");
		Thread.sleep(1000);
		
		NCP_HomePage.selectEnrollmentTab(driver, "Change Order").click();
		test.log(LogStatus.PASS, " Clicked on Change Order View");
		Thread.sleep(3000);
		
		EnrollCP_AddChangeOrderPage.addChangeOrderBtn(driver).click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, " Clicked on Add Change Order button");
		Actions act= new Actions(driver);
		
		act.moveToElement(EnrollCP_AddChangeOrderPage.additionalContractValueField(driver)).doubleClick().sendKeys("1000").build().perform();
		test.log(LogStatus.PASS, " Additional Contract value added suceesfully");
//		EnrollCP_AddChangeOrderPage.additionalContractValueField(driver).sendKeys("1000");
		Thread.sleep(2000);
		act.moveToElement(EnrollCP_AddChangeOrderPage.additionalSelfPerformedValueField(driver)).doubleClick().sendKeys("1000").build().perform();
		test.log(LogStatus.PASS, " Additional Self Performed Contract value added suceesfully");
//		EnrollCP_AddChangeOrderPage.additionalSelfPerformedValueField(driver).sendKeys("1000");
		act.moveToElement(EnrollCP_AddChangeOrderPage.additionalSubContractorCostField(driver)).doubleClick().sendKeys("1000").build().perform();
		test.log(LogStatus.PASS, " Additional Sub Contractor Cost added suceesfully");
//		EnrollCP_AddChangeOrderPage.additionalSubContractorCostField(driver).sendKeys("1000");
		
		List<WebElement> lst1 = EnrollCP_AddChangeOrderPage.addUncappedPayrollForWCClasCode(driver);
		System.out.println("Size of payroll - "+lst1.toString());
		for(WebElement a: lst1)
		{
			try {
				act.moveToElement(a).doubleClick().build().perform();
				Thread.sleep(1500);
				a.sendKeys("1000");
			} catch (Throwable e) {
				System.out.println(e);
			}
			
		}
		test.log(LogStatus.PASS, " Additional Capped Uncapped Value added successfully");
		EnrollCP_AddChangeOrderPage.effectiveDate(driver).click();
		EnrollCP_AddChangeOrderPage.effectiveDate(driver).sendKeys("05/0/2021",Keys.TAB);
		test.log(LogStatus.PASS, " Effective Date added successfully");
		EnrollCP_AddChangeOrderPage.newEstimatedCompletionDate(driver).click();
		EnrollCP_AddChangeOrderPage.newEstimatedCompletionDate(driver).sendKeys("10/30/2023",Keys.TAB);
		test.log(LogStatus.PASS, " Effective Commpletion Date added successfully");
		EnrollCP_AddChangeOrderPage.descriptionField(driver).sendKeys("Testing Change Order");
		test.log(LogStatus.PASS, " Description Field added successfully");
		EnrollCP_AddChangeOrderPage.saveBtn(driver).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, " Clicked on Change Order Save Button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",EnrollCP_AddChangeOrderPage.closeChangeOrderWindow(driver));
		test.log(LogStatus.PASS, " Change Order added successfully");
		driver.navigate().to(BaseUrl);//navigate to base url
		
		
	}
}
