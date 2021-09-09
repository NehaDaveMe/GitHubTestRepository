package TestScript_RR;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.FileUtils1;
import ObjectRepository.AddProjectPage;


public class ProjectValidationsTest extends BaseClass {
	
	WebDriverCommonLib wb = new WebDriverCommonLib();

	String ProgramName = "THANOS PG Name";
	String ProgramAdmin = "Thanos Contac - Thanos_F- L-N";
	String ProjectAdmin = "Thanos Contac - Thanos_F- L-N";
	String ProgramSponsor = "Thanos Pvt Ltd - Thanos  FN-LN";
	String EndDateGIPage = "01/01/2025";
	String policy_startdate = "01/01/2020";
	String policy_Enddate = "01/01/2021";
	String ProgramActAlertMsgGIPage = "Program must be selected.";
	String ProjectActAlertMsgGIPage = "Project Name must be selected.";
	String ProjectNameActErrMsgGIPage = "This field is required.";
	String ProjectName = "Thanos PJ";
	String StateGIPage = "Canada";
	String StateActAlertMsgGIPage = "State must be selected.";
	String StateActErrMsgGIPage = "State Required";
	String EndDateActErrMsgGIPage = "This field is required.";
	String EndDateActAlertMsgGIPage = "End Date must be entered.";
	String GenralContractorDeleteBtnSuccessActAlertMsg = "General Contractor Removed Successfully.";
	String GenralContractorCompanyActErrMsgGIPage = "This field is required.";
	String GenralContractorContactActErrMsgGIPage = "This field is required.";
	String GenralContractorCompanyActAlertMsgGIPage = "In General Contractor Section Company and Contact details must be entered.";
	String GenralContractorContactActAlertMsgGIPage = "In General Contractor Section Contact details must be entered.";
	String GenralContractorCompanyNameGIPage = "Thanos Contact [Thanos FEIN]";
	String GenralContractorContactNameGIPage = "Thanos Contact - Thanos FN-LN";
	String GenralContractorActAlertMsgGIPage = "Please add a Contact for this Company"; // This is at Save button of Gen
																						// Contractor
	String GeneralContractorCompanyName = "Thanos Contact";
	String GeneralContractorContactName = "Hercules";
	String GeneralContractorCompanyRoger = "Roger Federer [Hercules-FE-1]"; // "Roger Federer";
	String GeneralContractorContactHercules = "Roger Federer - Hercules Contac"; // "Hercules";
	String AddressType = "NAME-ADDRESS TYPE NAME";
	String Address1 = "Address1";
	String AddressState = "Canada";
	String AddressTypeActAlertMsg = "Address Type must be selected.";
	String AddressTypeActErrMsg = "Address Type Required";
	String Address1ActErrMsg = "Address 1 is Required";
	String Address1ActAlertMsg = "Address 1 must be entered.";
	String AddressStateActErrMsg = "State Required";
	String AddressStateActAlertMsg = "State must be selected.";
	String CompanyNameContacts = "Thanos Contac";
	String CompanyFirstNameContacts = "Thanos_F-";
	String CompanyLastNameContacts = "L-N";
	String EMailIdContacts = "raja.reddy@nourtek.com";
	String CompanyNameContactsActErrMsg = "Company Name Required";
	String CompanyNameContactsActAlertMsg = "Company Name must be entered.";
	String CompanyFirstNameContactsErrMsg = "This field is required.";
	String CompanyFirstNameContactsActAlertMsg = "First Name must be entered.";
	String CompanyLastNameContactsErrMsg = "This field is required.";
	String CompanyLastNameContactsActAlertMsg = "Last Name must be entered.";
	String EmailIdContactsActErrMsg = "This field is required.";
	String EmailIdContactsActAlertMsg = "Email must be entered.";
	String TrackcappedUncappedPayrollSwicthActAlertMsg = "Warning! Turning off this switch will cause all WC calculations to utilize the Uncapped Payroll values. Are you sure you want to proceed?";
	String GLPayrollSwitchActAlertMsg = "There are contractor package already added for this project. Making a switch on will not allow you to add payroll for those contractor package.\r\n"
			+ "\r\n"
			+ "Do you still want to switch on \"Track Payroll for GL Only Contracts\" for newly added contractor package?";

	String SelectCarrierName = "Carrier Name-1234";
	String SelectLayer = "1";
	String CarrierActErrMsgExcessUmbrellaPolicy = "Carrier Required";
	String LayerActErrMsgExcessUmbrellaPolicy = "Layer Required";
	String PolicyEffectiveDateActErrMSgExcessUmbrella = "This field is required.";
	String PolicyExpiryDateActErrMsgonEffectiveDateExcessUmbrellapolicy = "Policy Expiration Date must be greater than Policy Effective Date.";
	String PolicyExpiryDateActErrMsgExcessUmbrellaPolicy = "This field is required.";
	String NewEstimatedCompletionDate = "01/01/2025";
	String AdditionalContractValue = "100000";
	String NewEstimatedCompletionDateActErrMsg = "This field is required.";
	String DescriptionActErrMsg = "This field is required.";

	@Test

	public void ProjectValidations() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		AddProjectPage.ProjectSidePanel(driver).click();
		test.log(LogStatus.PASS, "Project Icon button is clicked ");
		System.out.println("Project Icon button is clicked ");
		Thread.sleep(5000);
		wb.scrollToTop();
		AddProjectPage.AdvancesearchbarIcon(driver).click();
		test.log(LogStatus.PASS, "Advacne search button is clicked ");
		System.out.println("Advance Search button is clicked ");
		Thread.sleep(1000);
		wb.selectByVisibleText(ProgramName, AddProjectPage.AdvSearchProgramName(driver));
		wb.selectByVisibleText(ProgramAdmin, AddProjectPage.AdvSearchProgAdmin(driver));
		Thread.sleep(1000);
		wb.selectByVisibleText(ProjectAdmin, AddProjectPage.AdvSearchProjAdmin(driver));
		wb.selectByVisibleText(ProgramSponsor, AddProjectPage.AdvSearchProgramSponsor(driver));
		Thread.sleep(1000);
		wb.scrollToEndt();
		Thread.sleep(1000);
		AddProjectPage.AdvSearchSearchBtnDown(driver).click();
		Thread.sleep(1000);
		wb.scrollToTop();
		AddProjectPage.EditBtnProjectICON(driver).click();
		wb.SwitchtoChild1();
		Thread.sleep(2000);
		wb.scrollToTop();
		wb.selectByIndex(AddProjectPage.SelectprogramGIpage(driver), 0);
		System.out.println("Project Validation Page button is clicked  and selected");
		test.log(LogStatus.PASS, "Project Validation Page button is clicked  and selected");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,200)");
		wb.scrollToEndt();
		Thread.sleep(2000);
		AddProjectPage.SaveandContinueBtnGIPage(driver).click();
		test.log(LogStatus.PASS, "Save and continue button is clicked ");
		System.out.println("Save and continue button is clicked ");
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.ProgramAlertMsgGIPage(driver), ProgramActAlertMsgGIPage);
		System.out.println("Program Validation Page button is clicked  and comapred");
		test.log(LogStatus.PASS, "Program Validation Page button is clicked  and comapred");
		wb.Alert_Click(AddProjectPage.AlertCloseBtn(driver));
		test.log(LogStatus.PASS, "Close button is clicked");
		System.err.println("Close Button is clicked");
		Thread.sleep(1000);
		wb.scrollToTop();
		wb.moveToElement( AddProjectPage.SelectprogramGIpage(driver));
		wb.selectByVisibleText(ProgramName, AddProjectPage.SelectprogramGIpage(driver));
		test.log(LogStatus.PASS, "Program Validation Page button is clicked  and comapred");
		Thread.sleep(2000);
		AddProjectPage.ProjectNameGIpage(driver).click();
		AddProjectPage.ProjectNameGIpage(driver).clear();
		Thread.sleep(1500);
		wb.Compare(AddProjectPage.ProjectNameErrMsgGIpage(driver), ProjectNameActErrMsgGIPage);
		test.log(LogStatus.PASS, "project Name Validation Page button is clicked  and comapred");
		System.out.println("project Name Validation Page button is clicked  and comapred");
		wb.scrollToEndt();
		Thread.sleep(2000);
		AddProjectPage.SaveandContinueBtnGIPage(driver).click();
		test.log(LogStatus.PASS, "Save and continue button is clicked  and comapred");
		System.out.println("Save and continue  button is clicked  and comapred");
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.ProgramAlertMsgGIPage(driver), ProjectActAlertMsgGIPage);
		wb.Alert_Click(AddProjectPage.AlertCloseBtn(driver));
		test.log(LogStatus.PASS, "project Alert Validation Page button is clicked  and comapred");
		System.out.println("project Alert  Validation Page button is clicked  and comapred");
		Thread.sleep(1000);
		wb.scrollToTop();
		wb.moveToElement( AddProjectPage.ProjectNameGIpage(driver));
		AddProjectPage.ProjectNameGIpage(driver).sendKeys(ProjectName);
		test.log(LogStatus.PASS, "project Name Validation Page button is Entered");
		System.out.println("project Name Validation Page button is Entered");
		Thread.sleep(2000);
		wb.moveToElement( AddProjectPage.SelectStateGIPage(driver));
		wb.selectByIndex(AddProjectPage.SelectStateGIPage(driver), 0);
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.SelectStateErrMsgGIPage(driver), StateActErrMsgGIPage);
		test.log(LogStatus.PASS, "project State  Validation Page button is clicked  and comapred");
		System.out.println("project State Validation Page button is clicked  and comapred");
		wb.scrollToEndt();
		Thread.sleep(2000);
		AddProjectPage.SaveandContinueBtnGIPage(driver).click();
		Thread.sleep(2000);
		try {
			wb.scrollToEndt();
			Thread.sleep(2000);
			AddProjectPage.SaveandContinueBtnGIPage(driver).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("No such alert present to pop up");
		}
		wb.Compare(AddProjectPage.SelectStateAlertMsgGIPage(driver), StateActAlertMsgGIPage);
		wb.Alert_Click(AddProjectPage.AlertCloseBtn(driver));
		Thread.sleep(1000);
		wb.scrollToTop();
		wb.moveToElement( AddProjectPage.SelectStateGIPage(driver));
		wb.selectByVisibleText(StateGIPage, AddProjectPage.SelectStateGIPage(driver));
		Thread.sleep(2000);
		wb.moveToElement( AddProjectPage.EndDateGIPage(driver));
		AddProjectPage.EndDateGIPage(driver).click();
		AddProjectPage.EndDateGIPage(driver).clear();
		AddProjectPage.EndDateGIPage(driver).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.EndDateErrMsgGIPage(driver), EndDateActErrMsgGIPage);
		test.log(LogStatus.PASS, "End date button is Selected");
		System.out.println("End date is Selected");
		wb.scrollToEndt();
		Thread.sleep(2000);
		AddProjectPage.SaveandContinueBtnGIPage(driver).click();
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.EndDateAlertMsgGIPage(driver), EndDateActAlertMsgGIPage);
		test.log(LogStatus.PASS, "End date alert is handled ");
		System.out.println("End date alert is ahndled ");
		wb.Alert_Click(AddProjectPage.AlertCloseBtn(driver));
		Thread.sleep(2000);
		wb.scrollToTop();
		wb.scrollByVisibilityOfElement(AddProjectPage.EndDateGIPage(driver));
		AddProjectPage.EndDateGIPage(driver).click();
		AddProjectPage.EndDateGIPage(driver).clear();
		Thread.sleep(2000);
		AddProjectPage.EndDateGIPage(driver).sendKeys(EndDateGIPage);
		AddProjectPage.EndDateGIPage(driver).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,200)");
		Thread.sleep(2000);
		AddProjectPage.GeneralContractorDeleteBtnGIPage(driver).click();
		Thread.sleep(2000);
		wb.Alert();
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.GeneralContractorDeleteSuccessAlertMsgGIPage(driver),
				GenralContractorDeleteBtnSuccessActAlertMsg);
		test.log(LogStatus.PASS, "General Contractor is clicked  and Cleared and compared");
		System.out.println("GeneralContractor is cleared  and comapred");
		wb.Alert_Click(AddProjectPage.GeneralContractorDeleteSuccessAlertMsgOKBtnGIPage(driver));
		Thread.sleep(2000);
		wb.scrollToEndt();
		Thread.sleep(2000);
		AddProjectPage.SaveandContinueBtnGIPage(driver).click();
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.GeneralContractorCompanyAlertGIPage(driver),
				GenralContractorCompanyActAlertMsgGIPage);
		test.log(LogStatus.PASS, "General Contractor is clicked  and Cleared and compared and alert handled ");
		System.out.println("GeneralContractor is cleared  and comapred and alert handled");
		wb.Alert_Click(AddProjectPage.AlertCloseBtn(driver));
		Thread.sleep(2000);
		AddProjectPage.SaveandContinueBtnGIPage(driver).click();
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.GeneralContractorCompanyAlertGIPage(driver),
				GenralContractorCompanyActAlertMsgGIPage);
		test.log(LogStatus.PASS, "General Contractor company is clicked  and Cleared and compared and alert handled");
		System.out.println("GeneralContractor comopany  is cleared  and comapred and alert handled");
		wb.Alert_Click(AddProjectPage.AlertCloseBtn(driver));
		Thread.sleep(2000);
		wb.scrollToTop();
		js.executeScript("window.scrollTo(0,600)");
		Thread.sleep(2000);
		wb.scrollByVisibilityOfElement(AddProjectPage.GeneralContractorCompanyFeildGIPage(driver));
		wb.Compare(AddProjectPage.GeneralContractorCompanyErrMsgGIPage(driver),
				GenralContractorCompanyActErrMsgGIPage);
		AddProjectPage.GeneralContractorCompanyFeildGIPage(driver).click();
		AddProjectPage.GeneralContractorCompanyFeildGIPage(driver).sendKeys("Roger");
		Thread.sleep(2000);
		AddProjectPage.GeneralContractorCompanyFeildGIPage(driver).clear();
		Thread.sleep(2000);
		AddProjectPage.GeneralContractorCompanyFeildGIPage(driver).sendKeys(GeneralContractorCompanyName);
		Thread.sleep(2000);
		AddProjectPage.GeneralContractorCompanyFeildGIPage(driver).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.GeneralContractorCompanyErrMsgGIPage(driver),
				GenralContractorCompanyActErrMsgGIPage);
		AddProjectPage.GeneralContractorSaveBtnGIPage(driver).click();
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.GeneralContractorContacErrMsgGIPage(driver),
				GenralContractorActAlertMsgGIPage);
		wb.Alert_Click(AddProjectPage.GeneralContractorDeleteSuccessAlertMsgOKBtnGIPage(driver));
		Thread.sleep(2000);
		wb.scrollToEndt();
		Thread.sleep(2000);
		AddProjectPage.SaveandContinueBtnGIPage(driver).click();
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.GeneralContractorContactAlertMsgGIPageatSaveandRemoveBtn(driver),
				GenralContractorContactActAlertMsgGIPage);
		wb.Alert_Click(AddProjectPage.AlertCloseBtn(driver));
		Thread.sleep(2000);
		wb.scrollToTop();
		js.executeScript("window.scrollTo(0,600)");
		Thread.sleep(2000);
		wb.scrollByVisibilityOfElement(AddProjectPage.GeneralContractorContactfeildGIPage(driver));
		Thread.sleep(2000);
		AddProjectPage.GeneralContractorContactfeildGIPage(driver).click();
		AddProjectPage.GeneralContractorContactfeildGIPage(driver).sendKeys("Hercules");
		Thread.sleep(2000);
		AddProjectPage.GeneralContractorContactfeildGIPage(driver).clear();
		Thread.sleep(2000);
		AddProjectPage.GeneralContractorContactfeildGIPage(driver).sendKeys(GeneralContractorContactName);
		test.log(LogStatus.PASS, "General Contractor is entered");
		System.out.println("GeneralContractor is Entered");
		Thread.sleep(2000);
		AddProjectPage.GeneralContractorContactfeildGIPage(driver).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		AddProjectPage.GeneralContractorSaveBtnGIPage(driver).click();
		Thread.sleep(3000);
		wb.scrollToEndt();
		Thread.sleep(2000);
		AddProjectPage.SaveandContinueBtnGIPage(driver).click();
		Thread.sleep(3000);
		wb.SwitchtoChild1();
		System.err.println(driver.getTitle() + "It is the title at Addressapge");
		// New functionality added ---Raja
		AddProjectPage.SaveandContinueProjectSettings(driver).click();
		test.log(LogStatus.PASS, "save and continue button at project settings is clicked");
		Thread.sleep(1000);
		AddProjectPage.EditBtnAddressPage(driver).click();
		Thread.sleep(1000);
		wb.SwitchtoChild2();
		wb.selectByIndex(AddProjectPage.EditSelectAddressTypeAddressPage(driver), 0);
		wb.Compare(AddProjectPage.EditSelectAddressTypeErrMsgAddressPage(driver), AddressTypeActErrMsg);
		test.log(LogStatus.PASS, "Address Type is deslseted is entered");
		System.out.println("Address Type is deslseted is Entered");
		AddProjectPage.EditAddressSaveandCloseBtnAddressPage(driver).click();
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.EditSelectAddressTypeAlertMsgAddressPage(driver), AddressTypeActAlertMsg);
		test.log(LogStatus.PASS, "Address Type is deslseted and alert msg  is entered and comapared");
		System.out.println("Address Type is deslseted and alert  is Entered ad compared");
		wb.Alert_Click(AddProjectPage.AlertCloseBtn(driver));
		Thread.sleep(2000);
		wb.selectByVisibleText(AddressType, AddProjectPage.EditSelectAddressTypeAddressPage(driver));
		Thread.sleep(1000);
		AddProjectPage.EditAddress1AddressPage(driver).click();
		AddProjectPage.EditAddress1AddressPage(driver).clear();
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.EditAddress1ErrMsgAddressPage(driver), Address1ActErrMsg);
		AddProjectPage.EditAddressSaveandCloseBtnAddressPage(driver).click();
		test.log(LogStatus.PASS, "Address  1 Type  is entered is cleared");
		System.out.println("Address 1 Type is deslseted is Entered is cleared");
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.EditAddress1AlertMsgAddressPage(driver), Address1ActAlertMsg);
		wb.Alert_Click(AddProjectPage.AlertCloseBtn(driver));
		test.log(LogStatus.PASS, "Address Type is deslseted is entered and alert handled");
		System.out.println("Address Type is deslseted is Entered is handled");
		Thread.sleep(2000);
		AddProjectPage.EditAddress1AddressPage(driver).sendKeys(Address1);
		wb.selectByIndex(AddProjectPage.EditSelectStateAddresspage(driver), 0);
		wb.Compare(AddProjectPage.EditAddressSelectStateErrMsgAddressPage(driver), AddressStateActErrMsg);
		test.log(LogStatus.PASS, "Address Sate  is deslseted is entered");
		System.out.println("Address state  is deslseted is Entered");
		AddProjectPage.EditAddressSaveandCloseBtnAddressPage(driver).click();
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.EditAddressSelectStateAlertMsgAddresPage(driver), AddressStateActAlertMsg);
		test.log(LogStatus.PASS, "Address State  is deslseted is entered and alert handled");
		System.out.println("Address state  is deslseted is Entered and alert handled");
		wb.Alert_Click(AddProjectPage.AlertCloseBtn(driver));
		Thread.sleep(2000);
		wb.selectByVisibleText(AddressState, AddProjectPage.EditSelectStateAddresspage(driver));
		Thread.sleep(1000);
		AddProjectPage.EditAddressSaveandCloseBtnAddressPage(driver).click();
		Thread.sleep(2000);
		wb.SwitchtoChild1();
		Thread.sleep(2000);
		AddProjectPage.NextBtnAddressPage(driver).click();
		test.log(LogStatus.PASS, "Next button is cliked at Address Page");
		System.out.println("Next button is clicked at Address page");
		Thread.sleep(2000);
		AddProjectPage.EditBtnContactsPage(driver).click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Edit button at Contacts page is clicked");
		System.out.println("Edit button at Contacts page is clicked");
		wb.SwitchtoChild2();
		Thread.sleep(2000);

		AddProjectPage.CompanyNameContactsFeild(driver).click();
		AddProjectPage.CompanyNameContactsFeild(driver).clear();
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.CompanyNameContactsErrMsg(driver), CompanyNameContactsActErrMsg);
		wb.scrollToEndt();
		wb.moveToElement( AddProjectPage.SaveandCloseBtnContactsPage(driver));
		AddProjectPage.SaveandCloseBtnContactsPage(driver).click();
		test.log(LogStatus.PASS, "Save and close button at Edit  Contacts page is clicked");
		System.out.println("Save and close button at Edit  Contacts page is clicked");
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.CompanyNameContactsAlertMsg(driver), CompanyNameContactsActAlertMsg);
		wb.Alert_Click(AddProjectPage.AlertCloseBtn(driver));
		test.log(LogStatus.PASS, "Save and close button at Edit  Contacts page is clicked  and alert handled");
		System.out.println("Save and close button at Edit  Contacts page is clicked and alert handled");
		Thread.sleep(2000);
		wb.scrollToTop();
		Thread.sleep(2000);
		AddProjectPage.CompanyNameContactsFeild(driver).sendKeys(CompanyNameContacts);
		Thread.sleep(2000);
		AddProjectPage.CompanyFirstNameContactsFeild(driver).click();
		AddProjectPage.CompanyFirstNameContactsFeild(driver).clear();
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.CompanyFirstNameContactsErrMsg(driver), CompanyFirstNameContactsErrMsg);
		wb.scrollToEndt();
		wb.moveToElement( AddProjectPage.SaveandCloseBtnContactsPage(driver));
		AddProjectPage.SaveandCloseBtnContactsPage(driver).click();
		test.log(LogStatus.PASS, "Save and close button at Edit  Contacts page is clicked at First name contacts ");
		System.out.println("Save and close button at Edit  Contacts page is clicked");
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.CompanyFirstNameContactsAlertMsg(driver),
				CompanyFirstNameContactsActAlertMsg);
		wb.Alert_Click(AddProjectPage.AlertCloseBtn(driver));
		test.log(LogStatus.PASS,
				"Save and close button at Edit  Contacts page is clicked  and alert handled at First name");
		System.out.println("Save and close button at Edit  Contacts page is clicked and alert handled at first name");
		Thread.sleep(2000);
		wb.scrollToTop();
		Thread.sleep(2000);
		AddProjectPage.CompanyFirstNameContactsFeild(driver).sendKeys(CompanyFirstNameContacts);
		Thread.sleep(2000);
		AddProjectPage.CompanyLastNameContactsFeild(driver).click();
		AddProjectPage.CompanyLastNameContactsFeild(driver).clear();
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.CompanyLastNameContactsErrMsg(driver), CompanyLastNameContactsErrMsg);
		wb.scrollToEndt();
		wb.moveToElement( AddProjectPage.SaveandCloseBtnContactsPage(driver));
		AddProjectPage.SaveandCloseBtnContactsPage(driver).click();
		test.log(LogStatus.PASS, "Save and close button at Edit  Contacts page is clicked at last name error Msg");
		System.out.println("Save and close button at Edit  Contacts page is clicked at contacts last name error msg");
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.CompanyLastNameContactsAlertMsg(driver),
				CompanyLastNameContactsActAlertMsg);
		wb.Alert_Click(AddProjectPage.AlertCloseBtn(driver));
		test.log(LogStatus.PASS,
				"Save and close button at Edit  Contacts page is clicked  and alert handled at Last name Contacts");
		System.out.println(
				"Save and close button at Edit  Contacts page is clicked and alert handled at last name contacts");
		Thread.sleep(2000);
		wb.scrollToTop();
		Thread.sleep(2000);
		AddProjectPage.CompanyLastNameContactsFeild(driver).sendKeys(CompanyLastNameContacts);
		Thread.sleep(2000);

		AddProjectPage.EmailIdContactsFeild(driver).click();
		AddProjectPage.EmailIdContactsFeild(driver).clear();
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.EmailIdContactsErrMsg(driver), EmailIdContactsActErrMsg);
		wb.scrollToEndt();
		wb.moveToElement( AddProjectPage.SaveandCloseBtnContactsPage(driver));
		AddProjectPage.SaveandCloseBtnContactsPage(driver).click();
		test.log(LogStatus.PASS, "Save and close button at Edit  Contacts page is clicked at Email ");
		System.out.println("Save and close button at Edit  Contacts page is clicked at Email page");
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.EmailIdContactsAlertMsg(driver), EmailIdContactsActAlertMsg);
		wb.Alert_Click(AddProjectPage.AlertCloseBtn(driver));
		test.log(LogStatus.PASS, "Save and close button at Edit  Contacts page is clicked  and alert handled");
		System.out.println("Save and close button at Edit  Contacts page is clicked and alert handled");
		Thread.sleep(2000);
		wb.scrollToTop();
		Thread.sleep(2000);
		AddProjectPage.EmailIdContactsFeild(driver).sendKeys(EMailIdContacts);
		Thread.sleep(2000);
		wb.scrollToEndt();
		wb.moveToElement( AddProjectPage.SaveandCloseBtnContactsPage(driver));
		AddProjectPage.SaveandCloseBtnContactsPage(driver).click();
		test.log(LogStatus.PASS,
				"Save and close button at Edit  Contacts page is clicked  after all validations at contacts page");
		System.out.println(
				"Save and close button at Edit  Contacts page is clicked after all validations at Contacts page");
		Thread.sleep(2000);
		wb.SwitchtoChild1();
		Thread.sleep(2000);
		AddProjectPage.NextBtnContactsPage(driver).click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle() + "It is the title at Project Admin Page");
		wb.TurnONSwitch(AddProjectPage.AccessSwitchProjectAdministractionAccess(driver));
		Thread.sleep(2000);
		AddProjectPage.DeleteBtnProjectAdministractionAccess(driver).click();
		wb.AlertDismiss();
		Thread.sleep(2000);
		AddProjectPage.SaveandContinueBtnProjectAdministractionAccess(driver).click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Save and continue button is clicked after all validations at Project Admin Access");
		System.out.println("Save and continue  button  is clicked after all validations at Project Admin Access");
		System.out.println(driver.getTitle() + "It is the titlwe at Email Managemet page");
		wb.TurnOFFSwitch(AddProjectPage.EmailManagementSwitch(driver));
		AddProjectPage.SaveandContinueBtnEmailManagement(driver).click();
		test.log(LogStatus.PASS, "Save and continue  button at Email Management is clicked ");
		System.out.println("Save and continue  button at Email Management is clicked ");
		Thread.sleep(3000);
		wb.scrollToEndt();
		System.out.println(driver.getTitle() + "It is the title at Enrollment page");
		AddProjectPage.SaveandContinueBtnEnrollmentSetUp(driver).click();
		test.log(LogStatus.PASS, "Save and continue  button at Enrollment setup button  is clicked ");
		System.out.println("Save and continue  button at Enrollment setup  is clicked ");
		Thread.sleep(3000);
		System.out.println(driver.getTitle() + "It is the title at Payroll page");
		wb.TurnOFFSwitch(AddProjectPage.TrackCappedUncappedPayrollSwitch(driver));
		test.log(LogStatus.PASS, "Track capped payroll and UIncapped payroll switch is handled ");
		System.out.println("Track capped payroll and UIncapped payroll switch is handled ");
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.TrackCappedUncappedPayrollAlertMsg(driver),
				TrackcappedUncappedPayrollSwicthActAlertMsg);
		wb.Alert_Click(AddProjectPage.TrackCappedUncappedPayrollNOBtn(driver));
		Thread.sleep(2000);
		wb.TurnONSwitch(AddProjectPage.TrackpayrollforGLOnlySwitch(driver));
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.TrackGLpayrollAlertMsg(driver), GLPayrollSwitchActAlertMsg);
		wb.Alert_Click(AddProjectPage.TrackGLPayrollAlertCloseBtn(driver));
		Thread.sleep(2000);
		wb.TurnOFFSwitch(AddProjectPage.TrackpayrollforGLOnlySwitch(driver));
		AddProjectPage.SaveandContinueBtnPayrollPage(driver).click();
		test.log(LogStatus.PASS,
				"Track capped payroll and UIncapped payroll switch is handled and comapred text at GL Switch");
		System.out.println("Track capped payroll and UIncapped payroll switch is handled  at gl payroll switch");
		Thread.sleep(3000);
		AddProjectPage.SaveandContinueBtnPremiumModifications(driver).click();
		System.out.println(driver.getTitle() + "It is the title at Premium Midifcations");
		test.log(LogStatus.PASS, "Save and continue button at Premium Modifications is clicked");
		System.out.println("Save and continue button at Premium Modifications page is clicked");
		Thread.sleep(2000);
		System.out.println(driver.getTitle() + "It is the title at Non CIP page");
		AddProjectPage.NextBtnNonCIPPage(driver).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle() + "It is the title at ");
		AddProjectPage.ExcessUmbrellaPolicyEditBtnPolicyandCertifcates(driver).click();
		Thread.sleep(2000);
		wb.SwitchtoChild2();
		Thread.sleep(2000);
		System.out.println(driver.getTitle() + "It is the title at Excess Umbrella page");
		wb.selectByIndex(AddProjectPage.SelectCarrierExcessUmbrellaPolicy(driver), 0);
		wb.Compare(AddProjectPage.SelectCarrierErrMsgExcessUmbrellaPolicy(driver),
				CarrierActErrMsgExcessUmbrellaPolicy);
		Thread.sleep(1000);
		wb.scrollToEndt();
		AddProjectPage.SaveandCloseBtnExcessUmbrellaPolicy(driver).click();
		Thread.sleep(2000);
		wb.Alert();
		Thread.sleep(2000);
		wb.scrollToEndt();
		AddProjectPage.SaveandCloseBtnExcessUmbrellaPolicy(driver).click();
		Thread.sleep(2000);
		wb.Alert();
		wb.scrollToTop();
		Thread.sleep(2000);
		wb.selectByVisibleText(SelectCarrierName, AddProjectPage.SelectCarrierExcessUmbrellaPolicy(driver));
		Thread.sleep(2000);
		wb.selectByIndex(AddProjectPage.SelectLayerExcessUmbrellaPolicy(driver), 0);
		wb.Compare(AddProjectPage.SelectLayerErrMsgExcessUmbrellaPolicy(driver),
				LayerActErrMsgExcessUmbrellaPolicy);
		Thread.sleep(1000);
		wb.scrollToEndt();
		AddProjectPage.SaveandCloseBtnExcessUmbrellaPolicy(driver).click();
		Thread.sleep(2000);
		wb.Alert();
		Thread.sleep(2000);
		wb.scrollToEndt();
		AddProjectPage.SaveandCloseBtnExcessUmbrellaPolicy(driver).click();

		Thread.sleep(2000);
		wb.Alert();
		wb.scrollToTop();
		Thread.sleep(2000);
		wb.selectByVisibleText(SelectLayer, AddProjectPage.SelectLayerExcessUmbrellaPolicy(driver));
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,100)");
		AddProjectPage.PolicyEffectiveDateExcessUmbrellaPolicy(driver).click();
		AddProjectPage.PolicyEffectiveDateExcessUmbrellaPolicy(driver).clear();
		Thread.sleep(2000);
		AddProjectPage.PolicyEffectiveDateExcessUmbrellaPolicy(driver).sendKeys(Keys.TAB);
		AddProjectPage.PolicyEffectiveDateExcessUmbrellaPolicy(driver).sendKeys(Keys.TAB);
		wb.Compare(AddProjectPage.PolicyEffectiveDateErrMsgExcessUmbrellaPolicy(driver),
				PolicyEffectiveDateActErrMSgExcessUmbrella);
		Thread.sleep(2000);
		wb.scrollToEndt();
		AddProjectPage.SaveandCloseBtnExcessUmbrellaPolicy(driver).click();
		Thread.sleep(2000);
		wb.scrollToTop();
		wb.scrollByVisibilityOfElement(
				AddProjectPage.PolicyExpiryDateonEffectivedateExcessUmbrellaPolicy(driver));
		wb.Compare(AddProjectPage.PolicyExpiryDateonEffectivedateExcessUmbrellaPolicy(driver),
				PolicyExpiryDateActErrMsgonEffectiveDateExcessUmbrellapolicy);
		AddProjectPage.PolicyEffectiveDateExcessUmbrellaPolicy(driver).sendKeys(policy_startdate);
		AddProjectPage.PolicyEffectiveDateExcessUmbrellaPolicy(driver).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		AddProjectPage.PolicyExpiryDateExcessUmbrellaPolicy(driver).click();
		AddProjectPage.PolicyExpiryDateExcessUmbrellaPolicy(driver).clear();
		Thread.sleep(2000);
		AddProjectPage.PolicyExpiryDateExcessUmbrellaPolicy(driver).sendKeys(Keys.TAB);
		wb.Compare(AddProjectPage.PolicyExpiryDateErrMsgExcessUmbrellaPolicy(driver),
				PolicyExpiryDateActErrMsgExcessUmbrellaPolicy);
		Thread.sleep(2000);
		wb.scrollToEndt();
		AddProjectPage.SaveandCloseBtnExcessUmbrellaPolicy(driver).click();
		Thread.sleep(2000);
		wb.scrollToTop();
		wb.scrollByVisibilityOfElement(AddProjectPage.PolicyExpiryDateExcessUmbrellaPolicy(driver));
		wb.Compare(AddProjectPage.PolicyExpiryDateErrMsgExcessUmbrellaPolicy(driver),
				PolicyExpiryDateActErrMsgExcessUmbrellaPolicy);
		AddProjectPage.PolicyExpiryDateExcessUmbrellaPolicy(driver).sendKeys(policy_Enddate);
		AddProjectPage.PolicyExpiryDateExcessUmbrellaPolicy(driver).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		wb.scrollToEndt();
		AddProjectPage.SaveandCloseBtnExcessUmbrellaPolicy(driver).click();
		Thread.sleep(2000);
		wb.SwitchtoChild1();
		Thread.sleep(2000);
		AddProjectPage.SaveandContinueBtnPolicyandCertificates(driver).click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle() + "This is the title at Policy certifdcastes agaian");
		AddProjectPage.EditBtnChangeOrder(driver).click();
		Thread.sleep(4000);
		AddProjectPage.EstimatedCompletionDateChangeOrder(driver).click();
		AddProjectPage.EstimatedCompletionDateChangeOrder(driver).clear();
		AddProjectPage.EstimatedCompletionDateChangeOrder(driver).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.EstimatedCompletionDateErrMsgChangeOrder(driver),
				NewEstimatedCompletionDateActErrMsg);
		AddProjectPage.EstimatedCompletionDateChangeOrder(driver).click();
		AddProjectPage.EstimatedCompletionDateChangeOrder(driver).sendKeys(NewEstimatedCompletionDate);
		Thread.sleep(2000);
		AddProjectPage.DescriptionChnageOrder(driver).click();
		AddProjectPage.DescriptionChnageOrder(driver).clear();
		Thread.sleep(2000);
		wb.Compare(AddProjectPage.DescriptionErrMsgChangeOrder(driver), DescriptionActErrMsg);
		AddProjectPage.DescriptionChnageOrder(driver).sendKeys("we are at Description for Change ortder");
		AddProjectPage.SaveandCloseBtnChangeOrder(driver).click();
		Thread.sleep(4000);
		AddProjectPage.FinishandCloseBtnChangeOrder(driver).click();
		Thread.sleep(2000);
		wb.Switchtoparent();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, test.addScreenCapture(FileUtils1.captureScreen(driver, "projectValidations")));

	}

}
