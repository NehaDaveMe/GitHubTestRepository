package TestScript_NCP;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import ModulerLibrary.NCP_LoginAction;
import ObjectRepository_NCP.NCP_HomePage;

public class ContracroPkgCount_NCPTest extends BaseClass
{
	
	WebDriverCommonLib wb= new WebDriverCommonLib();
	String programName="Automation Program dont touch";
	String projectName="Test 132 ON";
	String tradeName="T7026";
	public  String uName="JimmySmith114211";//"JimmySmith113888";//"JimmySmith114211";//
	public String password="uX6R1i0L7KxA";//"uO5J6h4K1UdS";//"uX6R1i0L7KxA";//
	
	
	@Test
	public void testChangeOrder() throws Throwable
	{
		String BaseUrl=driver.getCurrentUrl();
		NCP_LoginAction.logInNCPCommon(driver, uName, password);
		
		NCP_HomePage.btnFilterBy(driver).click();
		test.log(LogStatus.PASS, " Clicked On Select Program Field");
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
		
		NCP_HomePage.btnSearch(driver).click();
		test.log(LogStatus.PASS, " Clicked on Search Button");
		Thread.sleep(3000);
		
		
		String ncpUnenrolledCP = NCP_HomePage.notificationUnenrolledContractorPkg(driver).getText();
//		String ncpAssignCP = NCP_HomePage.notificationAssignContractorPkg(driver).getText();
		String ncpExpiredOffsiteCP = NCP_HomePage.notificationExpiredOffSiteCoverage(driver).getText();
		String ncpMissingPayrollWorkCP = NCP_HomePage.notificationMissingPayrollPkg(driver).getText();
		String notificationOtherNotificationsCoverage = NCP_HomePage.notificationOtherNotificationsCoverage(driver).getText();
			
		System.out.println("NCP side Pkg counts "+ncpUnenrolledCP + ncpExpiredOffsiteCP + notificationOtherNotificationsCoverage +ncpMissingPayrollWorkCP);
		
		
		
		
		
	}
}
