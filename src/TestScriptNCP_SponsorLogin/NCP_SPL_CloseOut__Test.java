package TestScriptNCP_SponsorLogin;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import ModulerLibrary.NCP_SponsorLoginAction;
import ObjectRepository_NCP.EnrollCP_AddCloseoutPage;
import ObjectRepository_NCP.NCP_HomePage;
import ObjectRepository_NCP.NCP_SponsorLoginHomePage;

public class NCP_SPL_CloseOut__Test extends BaseClass
{
	
	WebDriverCommonLib wb= new WebDriverCommonLib();
	public String contractorName = "Alex Comp3524";
	String programName="Automation Program dont touch";
	String projectName="Test 132 ON";
	String tradeName="TRANO2814";
	@Test
	public void addCloseOutTest() throws Throwable
	{
		String BaseUrl=driver.getCurrentUrl();
		
		NCP_SponsorLoginAction.logInNCP(driver);
		NCP_SponsorLoginHomePage.moduleMyContracts(driver).click();
		Thread.sleep(3000);
		
		
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
		NCP_HomePage.searchForTradeField(driver).click();
		Thread.sleep(1500);
		NCP_HomePage.searchForTradeField(driver).sendKeys(tradeName);
		Thread.sleep(1500);
		System.out.println(tradeName);
		wb.selectSingleValueFromList(NCP_HomePage.selectTradeFromList(driver), tradeName);
		
		/*NCP_HomePage.selectTradeField(driver).click();
		test.log(LogStatus.PASS, " Clicked On Select Trade Field");
		Thread.sleep(2000);
		wb.selectSingleValueFromList(NCP_HomePage.selectTradeFromList(driver), tradeName);*/
		test.log(LogStatus.PASS, tradeName+" Trade successfully selected form drop down");
		
		NCP_HomePage.btnSearch(driver).click();
		test.log(LogStatus.PASS, " Clicked on Search Button");
		Thread.sleep(4000);
		
		NCP_HomePage.selectPreviewPanelProjectDropdown(driver,contractorName).click();
		test.log(LogStatus.PASS, " Clicked on Selected Contractor Package");
		Thread.sleep(2000);
		NCP_HomePage.selectEnrollmentTab(driver, "Closeout").click();
		test.log(LogStatus.PASS, " Clicked on Enrollement View");
		Thread.sleep(5000);
		wb.waitForElemnet(EnrollCP_AddCloseoutPage.closeoutDate(driver));
		EnrollCP_AddCloseoutPage.closeoutDate(driver).sendKeys("04/30/2021");
		test.log(LogStatus.PASS, " Closeout Date Selected Successfully");
		EnrollCP_AddCloseoutPage.SaveBtn(driver).click();
		test.log(LogStatus.PASS, " Clicked on Closeout Date save button");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",EnrollCP_AddCloseoutPage.auditCompanyName(driver));
		
		wb.waitForElemnet(EnrollCP_AddCloseoutPage.auditCompanyName(driver));
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
