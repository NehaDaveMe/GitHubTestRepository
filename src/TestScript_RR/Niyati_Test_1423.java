package TestScript_RR;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.FileUtils1;
import ObjectRepository.AddContractor_Pkg_MonthlyPayroll_Page;


public class Niyati_Test_1423  extends BaseClass {
	
	WebDriverCommonLib wb = new WebDriverCommonLib();

	String programmeName = "Program Name-PN-1";
	String Admin = "Roger Federer - Bella Jee";
	String Sponsor = "HSBC-Sponsor - Vincent John";
	String Switch_text = "Track Offsite Coverage";
	String attribue_Txt = "ios-ui-select";
	String DBA_err_Msg_txt = "This field is required.";
	String DBA_Switch_Tip_Act_txt = "Activating this switch will cause DBA names to appear after Contractor Company Names on Reports and CIP COIs.";
	String Hierarcytext = "Click here to view the Key Performance Indicators(KPIs) ";
	//String CP_Contains_text = "Mark Boucher";
	//String Cp_Contains_text_status = "Enrolled";
	String contracot_DBA = "Contractor DBA1234";
	String CP_Contains_text = "Roger Federer";
	String Cp_Contains_text_status = "Enrolled";
	String Contractorname = "Roger Federer - Roger Federer";
	String ActCinttext = CP_Contains_text + "DBAContractor D" + contracot_DBA;
	String Carriername = "Carrier Name-1234";
	String Policy_Eff_date = "02/01/2020";
	String policy_Exp_date = "02/01/2021";
	String EachOCCValue = "100,000";
	String DamageToRentedPremises = "100000";
	String MedExp = "100000";
	String perAdvinjry = "100000";
	String GenAggr = "100000";
	String prodcomOpAgg = "100000";
	String Insured = "Contractor ";
	String frame_Id = "ifrmPreview";
	String GL_Num = "GL_NUM_123";
	String Excess_Umbrella_num = "UMbrella_GL_123";

	@Test
	public void ReadPDFCOI_() throws Throwable {

		AddContractor_Pkg_MonthlyPayroll_Page.ProgrammeICon(driver).click();
		test.log(LogStatus.PASS, "Programme ICon is cicked succesfully");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,0)");
		Thread.sleep(2000);
		AddContractor_Pkg_MonthlyPayroll_Page.AdvancesearchbarIcon(driver).click();
		test.log(LogStatus.PASS, "Adv search ICon is cicked succesfully");
		wb.selectByVisibleText(Admin, AddContractor_Pkg_MonthlyPayroll_Page.Select_Programme_Admin(driver));
		test.log(LogStatus.PASS, "Programme Admin is selected from DropDown");
		wb.selectByVisibleText(Sponsor, AddContractor_Pkg_MonthlyPayroll_Page.Select_Programme_SPonsor(driver));
		test.log(LogStatus.PASS, "Programme Sponsor  is selected from DropDown");
		AddContractor_Pkg_MonthlyPayroll_Page.searchBtnDownProgramme(driver).click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Search btn is clicked succesfully after adv search filters");
		js.executeScript("window.scrollTo(0,0)");
		Thread.sleep(4000);
		AddContractor_Pkg_MonthlyPayroll_Page.Edit_btn(driver).click();
		test.log(LogStatus.PASS, "Edit btn is clicked ");
		wb.SwitchtonewTab();
		test.log(LogStatus.PASS, "Switched to new Tab");
		Thread.sleep(2000);
		wb.TurnON_Switch(AddContractor_Pkg_MonthlyPayroll_Page.Manage_CIP_Certificates_Switch);
		test.log(LogStatus.PASS, "Mange CIP switch is handled succesfully");
		System.out.println("CIP button is handled succesfully");
		js.executeScript("window.scrollTo(0,400)");
		Thread.sleep(2000);
		wb.click(AddContractor_Pkg_MonthlyPayroll_Page.saveandCloseBtn(driver));
		test.log(LogStatus.PASS, "save and close btn is cliked succesfully");
		wb.Switchtoparent();
		test.log(LogStatus.PASS, "Switched to Parent Tab");
		AddContractor_Pkg_MonthlyPayroll_Page.Edit_btn(driver).click();
		test.log(LogStatus.PASS, "Edit btn is clicked again after switch to main tab");
		wb.SwitchtonewTab();
		test.log(LogStatus.PASS, "switch to new  tab 2nd time");
		Thread.sleep(2000);
		wb.click(AddContractor_Pkg_MonthlyPayroll_Page.More_ICOn_Heading(driver));
		Thread.sleep(2000);
		wb.Find_Click(AddContractor_Pkg_MonthlyPayroll_Page.policy_Certificates(driver));
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "clicked on policy and certifcates");
		wb.click(AddContractor_Pkg_MonthlyPayroll_Page.Open_Polict_Btn(driver));
		test.log(LogStatus.PASS, "Clicked on Open policy btn");
		wb.SwitchtoChild2();
		test.log(LogStatus.PASS, "Moved to child window on Open policy btn");
		wb.getTitle();
		Thread.sleep(2000);
		wb.selectByVisibleText(Carriername, AddContractor_Pkg_MonthlyPayroll_Page.Carrier_DropDown(driver));
		test.log(LogStatus.PASS, "Selected carrier name");
		js.executeScript("window.scrollTo(0,100)");
		wb.SenKeyskeys_TAB(AddContractor_Pkg_MonthlyPayroll_Page.policy_Eff_date(driver), Policy_Eff_date);
		test.log(LogStatus.PASS, "Entered effective date  on Open policy page");
		wb.SenKeyskeys_TAB(AddContractor_Pkg_MonthlyPayroll_Page.Policy_Exp_date(driver), policy_Exp_date);
		test.log(LogStatus.PASS, "Entered Exp date  on Open policy page");
		js.executeScript("window.scrollTo(0,200)");
		wb.SenKeyskeys_TAB(AddContractor_Pkg_MonthlyPayroll_Page.EachOccurance(driver), EachOCCValue);
		test.log(LogStatus.PASS, "Entered Each occurance value  on Open policy page");
		wb.SenKeyskeys_TAB(AddContractor_Pkg_MonthlyPayroll_Page.DamaageToRentedPremeises(driver), DamageToRentedPremises);
		test.log(LogStatus.PASS, "Entered Damange value  on Open policy page");
		wb.SenKeyskeys_TAB(AddContractor_Pkg_MonthlyPayroll_Page.MedExp(driver), MedExp);
		test.log(LogStatus.PASS, "Entered Mexp value  on Open policy page");
		wb.SenKeyskeys_TAB(AddContractor_Pkg_MonthlyPayroll_Page.Personal_AdvInjur(driver), perAdvinjry);
		test.log(LogStatus.PASS, "Entered Personal AdvInjury value  on Open policy page");
		wb.SenKeyskeys_TAB(AddContractor_Pkg_MonthlyPayroll_Page.GeneralAggregate(driver), GenAggr);
		test.log(LogStatus.PASS, "General Aggregate value  on Open policy page");
		wb.SenKeyskeys_TAB(AddContractor_Pkg_MonthlyPayroll_Page.Products_Comp_op(driver), prodcomOpAgg);
		test.log(LogStatus.PASS, "Entered prodcomOpAgg value  on Open policy page");
		js.executeScript("window.scrollTo(0,300)");
		wb.click(AddContractor_Pkg_MonthlyPayroll_Page.saveandClose_Btn_policy(driver));
		test.log(LogStatus.PASS, "save and close btn is clicked succesfully");
		wb.Switchtoparent();
		wb.SwitchtonewTab();
		test.log(LogStatus.PASS, "moved to second tab again");
		js.executeScript("window.scrollTo(0,500)");
		wb.click(AddContractor_Pkg_MonthlyPayroll_Page.SetUpGneralCertificate(driver));
		test.log(LogStatus.PASS, "Clcked on setup certificates ");
		Thread.sleep(2000);
		wb.SwitchtoChild2();
		wb.getTitle();
		wb.selectByVisibleText(Insured, AddContractor_Pkg_MonthlyPayroll_Page.Select_Insured_String(driver));
		test.log(LogStatus.PASS, "Selcted the insured dropdown as contractor");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(4000);
		wb.click(AddContractor_Pkg_MonthlyPayroll_Page.SaveandClose_InsuCert(driver));
		test.log(LogStatus.PASS, "save and close button is cliked");
		Thread.sleep(3000);
		wb.Switchtoparent();
		wb.switchToFrameById(frame_Id);
		wb.mouseOverElement(AddContractor_Pkg_MonthlyPayroll_Page.HierachyButton(driver));
		wb.CompareTextandClick(AddContractor_Pkg_MonthlyPayroll_Page.HierachyButton(driver), Hierarcytext,
				AddContractor_Pkg_MonthlyPayroll_Page.HierarchyBtn_txt_graph(driver));
		test.log(LogStatus.PASS, "Hyper text is compared and then clicked ");
		wb.click(AddContractor_Pkg_MonthlyPayroll_Page.Programme_Frame(driver));
		Thread.sleep(4000);
		wb.CP_status_filters(AddContractor_Pkg_MonthlyPayroll_Page.Contrctr_list_frame,AddContractor_Pkg_MonthlyPayroll_Page.Contrctr_Status_list_frame,CP_Contains_text, Cp_Contains_text_status);
		test.log(LogStatus.PASS, "Contractor list is selcted sucesfully");
		wb.SwitchtonewTab();
		Thread.sleep(4000);
		js.executeScript("window.scrollTo(0,0)");
		Thread.sleep(2000);
		wb.switchToFrameById(frame_Id);
		test.log(LogStatus.PASS, "Swicted to frame");
		wb.click(AddContractor_Pkg_MonthlyPayroll_Page.Certifcates_frame(driver));
		System.out.println(driver.getWindowHandles());
		System.out.println("we are at certificates frame");
		wb.SwitchtoChild4();
		System.out.println(driver.getWindowHandle()+ driver.getTitle());
		wb.click(AddContractor_Pkg_MonthlyPayroll_Page.AutoGenerateCetificate(driver));
		test.log(LogStatus.PASS, "Autogenerate certificates");
		Thread.sleep(2000);
		wb.Alert_Click(AddContractor_Pkg_MonthlyPayroll_Page.Ok_Btn(driver));
		test.log(LogStatus.PASS, "Ok button is clciked again");
		wb.switchToFrameByName(AddContractor_Pkg_MonthlyPayroll_Page.Frame_Viewcertciates);
		test.log(LogStatus.PASS, "moved to frame at Contractor package at fame in  enrolment ");
		wb.type(AddContractor_Pkg_MonthlyPayroll_Page.GL_Policy_Number(driver), GL_Num);
		test.log(LogStatus.PASS, "GL policy num is clciked");
		wb.type(AddContractor_Pkg_MonthlyPayroll_Page.Excess_Umbrella(driver), Excess_Umbrella_num);
		test.log(LogStatus.PASS, "Excess_Umbrella_num is typed ");
		wb.click(AddContractor_Pkg_MonthlyPayroll_Page.SavenadCloseBtn_GLpolicy(driver));
		test.log(LogStatus.PASS, "save and close button is clicked succcesfully at Gl policy page");
		wb.getText(AddContractor_Pkg_MonthlyPayroll_Page.View_Certificates(driver));
		wb.click(AddContractor_Pkg_MonthlyPayroll_Page.Finish_Close(driver));
		test.log(LogStatus.PASS, "Finish and close button is clicked at view certoificates ");
		wb.Switchtoparent();
		test.log(LogStatus.PASS, test.addScreenCapture(FileUtils1.captureScreen(driver, "1423")));

	}
}
