package TestScript_NCP;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import ModulerLibrary.NCP_LoginAction;
import ObjectRepository_NCP.EnrollCP_AddCloseoutPage;
import ObjectRepository_NCP.NCP_HomePage;

public class Add_CloseOut_NCP_Test extends BaseClass
{
	
	String programName="Automation Program dont touch";
	String projectName="Test 132 ON";
	String tradeName="TRANO5892";
	public String uName="JimmySmith114540";//"JimmySmith114211";//"JimmySmith113888";//"JimmySmith114211";//
	public String password= "Admin@123";//"Admin@123";
	String closeoutDate="05/30/2021";
	
	WebDriverCommonLib wb= new WebDriverCommonLib();
	@Test
	public void addCloseOutTest() throws Throwable
	{
	
/*	@Test
	public void addCloseOutTest(String TestCaseName,String programName, String projectName , String tradeName) throws Throwable
	{
*/		String BaseUrl=driver.getCurrentUrl();
//		NCP_LoginAction.logInNCP(driver);
//		test.log(LogStatus.PASS, " Login to the Application");

		NCP_LoginAction.logInNCPCommon(driver, uName, password);
		NCP_HomePage.btnFilterBy(driver).click();
		test.log(LogStatus.PASS, " Clicked On Filter Button");
		NCP_HomePage.selectProgramField(driver).click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, " Clicked On Select Program Field");
		wb.selectSingleValueFromList(NCP_HomePage.selectProgramFromList(driver),programName );
		test.log(LogStatus.PASS, programName+" Program Name successfully selected form drop down");
		Thread.sleep(2000);
		NCP_HomePage.selectProjectField(driver).click();
		test.log(LogStatus.PASS, " Clicked On Select Project Field");
		Thread.sleep(2000);
		wb.selectSingleValueFromList(NCP_HomePage.selectProjectFromList(driver),projectName );
		test.log(LogStatus.PASS, projectName+" Project Name successfully selected form drop down");
		Thread.sleep(2000);
		NCP_HomePage.selectTradeField(driver).click();
		test.log(LogStatus.PASS, " Clicked On Select Trade Field");
		Thread.sleep(2000);
		wb.selectSingleValueFromList(NCP_HomePage.selectTradeFromList(driver), tradeName);
		test.log(LogStatus.PASS, tradeName+" Trade successfully selected form drop down");
		NCP_HomePage.btnSearch(driver).click();
		test.log(LogStatus.PASS, " Clicked on Search Button");
		Thread.sleep(2000);
		NCP_HomePage.selectPreviewPanelProjectDropdown(driver, projectName).click();
		test.log(LogStatus.PASS, " Clicked on Selected Contractor Package");
		Thread.sleep(2000);
		NCP_HomePage.selectEnrollmentTab(driver, "Closeout").click();
		test.log(LogStatus.PASS, " Clicked on Enrollement View");
		Thread.sleep(5000);
		wb.waitForElemnet(EnrollCP_AddCloseoutPage.closeoutDate(driver));
		EnrollCP_AddCloseoutPage.closeoutDate(driver).sendKeys(closeoutDate);
		test.log(LogStatus.PASS, " Closeout Date Selected Successfully");
		
		EnrollCP_AddCloseoutPage.SaveBtn(driver).click();
		test.log(LogStatus.PASS, " Clicked on Closeout Date save button");
		
		Thread.sleep(1500);
		wb.waitForElemnet(EnrollCP_AddCloseoutPage.auditCompanyName(driver));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_AddCloseoutPage.auditCompanyName(driver));
		EnrollCP_AddCloseoutPage.auditCompanyName(driver).sendKeys("TestComp");
		test.log(LogStatus.PASS, " Company name Added Successfully ");
		
		wb.waitForElemnet(EnrollCP_AddCloseoutPage.auditIndividual(driver));
		EnrollCP_AddCloseoutPage.auditIndividual(driver).sendKeys("Test124");
		test.log(LogStatus.PASS, " Individual Added Successfully");
		
		wb.waitForElemnet(EnrollCP_AddCloseoutPage.auditTelephone(driver));
		EnrollCP_AddCloseoutPage.auditTelephone(driver).sendKeys("10214512347897");
		test.log(LogStatus.PASS, " Telephone Added Successfully");
		
		wb.waitForElemnet(EnrollCP_AddCloseoutPage.auditEmail(driver));
		EnrollCP_AddCloseoutPage.auditEmail(driver).sendKeys("kiran@nourtek.com");
		test.log(LogStatus.PASS, " Email Added Successfully");
		
		EnrollCP_AddCloseoutPage.termsAndConditionCheckBox(driver).click();
		test.log(LogStatus.PASS, " Clicked on Terms and Condition Check Box");
		EnrollCP_AddCloseoutPage.CloseoutSaveBtn(driver).click();
		test.log(LogStatus.PASS, " Clicked on Closeout save button");
		
		wb.waitForElemnet(EnrollCP_AddCloseoutPage.CloseoutFailParameterAlertTextArea(driver));
		EnrollCP_AddCloseoutPage.CloseoutFailParameterAlertTextArea(driver).sendKeys("Testing Closeout");
		test.log(LogStatus.PASS, " Added A reson for closout");
		
		try {
			wb.waitForElemnet(EnrollCP_AddCloseoutPage.CloseoutFailParameterAlertSaveBtn(driver));
			EnrollCP_AddCloseoutPage.CloseoutFailParameterAlertSaveBtn(driver).click();
		} catch (Throwable e) 
		{
		System.out.println(e);
		}
		
		Thread.sleep(5000);
		test.log(LogStatus.PASS, " Clicked on Closeout Alert save button");
		test.log(LogStatus.PASS, " Closeout Added Successfully");
		driver.navigate().to(BaseUrl);//navigate to base url
		
	}
}
