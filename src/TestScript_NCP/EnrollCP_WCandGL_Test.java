package TestScript_NCP;

import org.testng.annotations.Test;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.RandomClass;
import ModulerLibrary.NCP_EnrollContractorPkg_Pages_Action;

import ModulerLibrary.NCP_LoginAction;
import ModulerLibrary.WPO_AddContractorPkgAction;
import ObjectRepository_NCP.EnrollCP_Enrollment_Page;
import ObjectRepository_NCP.NCP_HomePage;

public class EnrollCP_WCandGL_Test extends BaseClass
{
	WebDriverCommonLib wb= new WebDriverCommonLib();
	// public String projectName;

	public String programName="Automation Program dont touch";
	public String projectName="Test 132 ON";
	public String tradeName="T7026";
	public String contractorPKGno = RandomClass.randomContractorPkgNo();
	public String EnrollmentType = "WC & GL Enrollment";
	public String contractorCompany="Alex Comp3524";//"sony";
	public String contactName="Jimmy Smith";
	public String dba = RandomClass.randomDBA();
	public String contractorName = "Alex Comp2273";
	public String tradeNumber = RandomClass.randomTradeNO();
	public String insuranceCompName = "Carriers3524";
	public String startDate = "01/01/2021";
	public String uName="JimmySmith114540";//"JimmySmith114211";//"JimmySmith113888";//"JimmySmith114211";//
	public String password="Admin@123";//"uX6R1i0L7KxA";//"uO5J6h4K1UdS";//"uX6R1i0L7KxA";//
	public String submissionFrequency = "Quarterly";
	public String reportTime = "Quarterly";
	public String tab="Enrollment";
	
	
	@Test
	public void enrollWCandGL_CPTest() throws Throwable
	{
		
		WPO_AddContractorPkgAction.add_ContractorPkg(contractorName, projectName, programName, contractorCompany,
				contactName, tradeNumber, contractorPKGno, insuranceCompName, submissionFrequency, reportTime,
				EnrollmentType);
		
		String BaseUrl=driver.getCurrentUrl();
		NCP_LoginAction.logInNCPCommon(driver, uName, password);
		//filter select for respective pkg
		NCP_HomePage.filterForRespectiveCP(programName, projectName, tradeNumber, tab);
		try {
			EnrollCP_Enrollment_Page.cipAgreementContinueButton(driver).click();
		} catch (Throwable e) {
			System.out.println(e);
		}
		NCP_EnrollContractorPkg_Pages_Action.myCompanyInformationPage(driver, dba);
		NCP_EnrollContractorPkg_Pages_Action.contactInformationPage(driver);
		NCP_EnrollContractorPkg_Pages_Action.contactDetailsPage(driver, startDate);
		NCP_EnrollContractorPkg_Pages_Action.workClassPage(driver);
		NCP_EnrollContractorPkg_Pages_Action.premiumModificationPage(driver);
		NCP_EnrollContractorPkg_Pages_Action.generalLiabilityPage(driver, 1);
		NCP_EnrollContractorPkg_Pages_Action.umbrellExxcessLiabilityPage(driver, 1);
		NCP_EnrollContractorPkg_Pages_Action.pollutionLiabilityPage(driver, 1);
		NCP_EnrollContractorPkg_Pages_Action.subContractorPage(driver);
		NCP_EnrollContractorPkg_Pages_Action.doccumentsPage(driver);
		NCP_EnrollContractorPkg_Pages_Action.reviewEnrollmentPage(driver);

		driver.navigate().to(BaseUrl);//navigate to base url
		Thread.sleep(5000);
	}
	
}
