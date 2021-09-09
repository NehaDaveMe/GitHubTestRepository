package TestScript_Neha;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import com.sun.jna.platform.win32.WinNT.HANDLE;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.FileUtils1;
import GenericLibrary.RandomClass;
import ModulerLibrary.WPO_SelectContractorPkgAction;
import ObjectRepository.AddContractorPage;
import ObjectRepository.AddContractor_Pkg_Enrollment_Summary_Page;
import ObjectRepository.AddContractor_Pkg_GL_Umbrella_Coverage_Page;
import ObjectRepository.AddContractor_Pkg_Insurance_Enrollment_Page;
import ObjectRepository.AddContractor_Pkg_Page;
import ObjectRepository.AddProgram_General_Info_Page;
import ObjectRepository.AddProject_General_Information_Page;
import ObjectRepository.ContractorPackageModule;
import ObjectRepository.HomePage;
import ObjectRepository.ProgramModule;
import ObjectRepository.ProjectModule;
import ObjectRepository.Task_Module_Page;
import TestScript.ProjectAdvancedFilter_Test;

public class TaskValidationSwitchProgramModuleGeneralInfoTest extends BaseClass {

	WebDriverCommonLib wb = new WebDriverCommonLib();
	String ProgramName = "Goyal";
	String ExpStatus = "Status - Active";
	String ContractorPkgName = "hafiz contractor";
	String NonCipValue = "Non-CIP Compliance:";
	String CIPCertificate = "Certificate(s):";
	String ChangeOrder = "Change Order(s) & Insurance Cost Adjustment(s):";
	String InsuranceEnroll = "Insurance Enrollment:";
	// String Maintenance= "Maintenance";
	String TrackFixed = "Type of Contract";
	String InsuranceEnrollment = "Insurance Enrollment:";
	String Project = "Rivera One";
	String CP = "Hafiz contractor";
	String Enrolltype= "WC & GL Enrollment";
	String Trade = "4953 |  Refuse Systems";
	String PreviewEnrollstatus="Conditionally Enrolled";
	String Enrollstatus = "Incomplete Paperwork | Conditionally Enrolled";
	String Enrollstatus1 ="Pending Closeout";
	String Trade1 = "1521 | Air-Conditioning";

	SoftAssert softAssertion = new SoftAssert();

	  @Test(priority=1)
	  public void ProgramGeneralInfoTurnOnorTurnOFFSwitches() throws Throwable 
	  {
		test.log(LogStatus.INFO, "========== General Info Program Section Switches 'Turn ON  or  turn OFF'==========");
		HomePage.controlMenuHomeIcon(driver).click();
		Thread.sleep(6000);
		test.log(LogStatus.INFO, "Clicked On Home Icon");
		HomePage.HomeMenuPrograms(driver).click();
		test.log(LogStatus.INFO, "Clicked On Programs Module Icon");
		Thread.sleep(2000);
		ProgramModule.programSearchEditBox(driver).sendKeys(ProgramName);
		ProgramModule.programSearchEditBox(driver).sendKeys(Keys.ENTER);
		test.log(LogStatus.INFO, "Edit buttom has been clicked");
		Thread.sleep(3000);
		ProgramModule.programEditIcon(driver).click();
		Thread.sleep(4000);
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		wb.TurnONSwitches(AddProgram_General_Info_Page.SwitchesGeneralInfo(driver));
		test.log(LogStatus.PASS, "All the switches of Program Module General Info Page is now ON for " + ProgramName);
		// wb.TurnOFFSwitches(AddProgram_General_Info_Page.SwitchesGeneralInfo(driver)

		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		AddProgram_General_Info_Page.saveButton(driver).click();
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(wb.map.get("parentID"));
		Thread.sleep(2000);
	  }
	  
	  @Test(priority=2)
	  public void ProgramGeneralInfoSwitchStatus() throws Throwable 
	  {
		test.log(LogStatus.INFO, "========== General Info Program Section Switches 'Switch Status'==========");
		driver.switchTo().frame(ProgramModule.ProgramPreviewPanelFrame(driver));
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Inside Program Preview Panel");
		wb.mouseover(ProgramModule.programStatusButtonPrivewP(driver));
		Thread.sleep(1500);
		String ActStatus = ProgramModule.ProgramPreviewStatuscheck(driver).getAttribute("data-original-title");

		//wb.Comparestatus(ActStatus, ExpStatus);
		if(ActStatus.equalsIgnoreCase(ExpStatus))
		{
			test.log(LogStatus.PASS, "Status is" + ActStatus);
		}
		else
		{
			test.log(LogStatus.FAIL, "Status is" + ActStatus);
		}
		
		Thread.sleep(2000);
		driver.switchTo().defaultContent();

	}

	@Test(priority=3)
	public void ProgramGeneralInfoSwitchNonCIPCompliance() throws Throwable 
	{
		test.log(LogStatus.INFO,"========== General Info Program Section Switches 'Switch Non CIP Compliance'==========");
		Thread.sleep(2000);
		HomePage.controlMenuHomeIcon(driver).click();
		Thread.sleep(2000);
		HomePage.controlMenuContractorPackage(driver).click();
		test.log(LogStatus.INFO, "Clicked On Contractor Package Icon");
		AddContractor_Pkg_Page.search_Bar(driver).sendKeys(ContractorPkgName);
		AddContractor_Pkg_Page.search_Bar(driver).sendKeys(Keys.ENTER);
		test.log(LogStatus.INFO, ContractorPkgName + " passed inside search box");
		Thread.sleep(2000);
		ContractorPackageModule.searchIcon(driver).click();
		Thread.sleep(2000);
		driver.switchTo().frame(HomePage.ContractorPackagePreviewPanelFrame(driver));
		Thread.sleep(2000);

		test.log(LogStatus.INFO, "Inside Preview panel");
		
		int DD= AddContractor_Pkg_Page.PreviewlinkSection1(driver).size();
		Thread.sleep(2000);
		
		boolean Flag=false;
		
		for(int i=0; i<DD; i++)
		{
			String str=AddContractor_Pkg_Page.PreviewlinkSection1(driver).get(i).getText();
			System.out.println(str);
			
			if(str.contains("Non-CIP Compliance:"))
			{
				test.log(LogStatus.PASS, "Track Non Cip Compliance Coverage Switch is ON");
				Flag=true;
				break;
			}
			
		}
		
		if(Flag==false)
		{
			test.log(LogStatus.FAIL, "Track Non Cip Compliance Coverage Switch is OFF");
		}
		test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Track Non CIP Compliance Switch validation")));

		Thread.sleep(2000);
		//driver.switchTo().defaultContent();

	}

	 @Test(priority=4)
	public void ProgramGeneralInfoCIPCertificate() throws Throwable 
	{
		test.log(LogStatus.INFO,"========== General Info Program Section Switches 'Manage CIP Certificates'==========");
		Thread.sleep(3000);
		
		int DD= AddContractor_Pkg_Page.PreviewlinkSection2(driver).size();
		Thread.sleep(2000);
		
		boolean Flag=false;
		
		for(int i=0; i<DD; i++)
		{
			Thread.sleep(1000);
			String str=AddContractor_Pkg_Page.PreviewlinkSection2(driver).get(i).getText();
			System.out.println(str);
			
			if(str.contains("Certificate(s):"))
			{
				test.log(LogStatus.PASS, "Track Manage Cip Certificate Switch is ON");
				Flag=true;
				break;
			}
			
		}
		
		if(Flag==false)
		{
			test.log(LogStatus.FAIL, "Track Manage Cip Certificate Switch is OFF");
		}
		test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Track Manage Cip Certificate Switch validation")));

		Thread.sleep(2000);

	}

	 @Test(priority=5)
	public void ProgramGeneralInfoChangeOrder() throws Throwable 
	{
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "========== General Info Program Section Switches 'Change Order'==========");
		Thread.sleep(4000);
		int DD= AddContractor_Pkg_Page.PreviewlinkSection2(driver).size();
		Thread.sleep(2000);
		
		boolean Flag=false;
		
		for(int i=0; i<DD; i++)
		{
			Thread.sleep(1000);
			String str=AddContractor_Pkg_Page.PreviewlinkSection2(driver).get(i).getText();
			System.out.println(str);
			
			if(str.contains("Change Order(s) & Insurance Cost Adjustment(s):"))
			{
				test.log(LogStatus.PASS, "Track Manage Change Order Switch is ON");
				Flag=true;
				break;
			}
			
		}
		
		if(Flag==false)
		{
			test.log(LogStatus.FAIL, "Track Manage Change Order Switch is OFF");
		}
		test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Track Manage Cip Certificate Switch validation")));

		Thread.sleep(2000);


	}

	 @Test(priority=6)
	public void ProgramGeneralInfoMaintenanceWrap() throws Throwable 
	{
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "========== General Info Program Section Switches 'Maintenance Wrap'==========");
		Thread.sleep(4000);
		try {
			softAssertion.assertEquals(
					ContractorPackageModule.nonCipComplianceANDMaintenanceWrap(driver, InsuranceEnroll), true);
			test.log(LogStatus.PASS, "Insurance Enrollment is displayed at Contractor Package Preview panel");
			ContractorPackageModule.InsuranceEnrollmentPagePriviewP(driver).click();
			Thread.sleep(2000);
			wb.getWindowIDs();
			driver.switchTo().window(wb.map.get("childID"));
			test.log(LogStatus.INFO, "switched to Insurance Enrollment form window");
			// driver.manage().window().maximize();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1200)");
			try {
				softAssertion.assertEquals(ContractorPackageModule.MaintenanceWrap(driver), true);
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Maintenance radiobutton is visible under Insurance Enrollment Form");
			} catch (Throwable e) {
				test.log(LogStatus.FAIL, "Maintenance radiobutton is NOT visible under Insurance Enrollment Form");
			}

		} catch (Throwable e) {
			test.log(LogStatus.FAIL, "Maintenance Wrap switch is OFF");
		}
		Thread.sleep(2000);

		test.log(LogStatus.INFO,
				test.addScreenCapture(FileUtils1.captureScreen(driver, "Maintenance Wrap Switch validation")));

	}

	 @Test(priority=7)
	public void ProgramGeneralInfoTrackFixedCostTimeMaterial() throws Throwable 
	{
		Thread.sleep(2000);
		test.log(LogStatus.INFO,"========== General Info Program Section Switches 'Track Fixed Cost/Time and Material'==========");
		Thread.sleep(4000);
		try {
			// SoftAssert softAssertion = new SoftAssert();
			softAssertion.assertEquals(ContractorPackageModule.TrackFixedCostTimeandMaterial(driver), true);
			Thread.sleep(2000);
			test.log(LogStatus.PASS,
					"Switch Track Fixed Cost/Time and Material is ON, Drop down Type Of Contract is visible");
			// driver.close();
			Thread.sleep(2000);
		} catch (Throwable e) {
			test.log(LogStatus.FAIL,
					"Switch Track Fixed Cost/Time and Material is OFF, Drop down Type Of Contract is NOT visible");
			// driver.close();
		}
		test.log(LogStatus.INFO, test.addScreenCapture(
				FileUtils1.captureScreen(driver, "Track Fixed Cost/Time and Material Switch validation")));
		Thread.sleep(2000);
		driver.close();
	}

//	 @Test(priority=8) //Need to check
	public void ProgramGeneralInfoTrackExcludedContractors() throws Throwable 
	{
		Thread.sleep(2000);
		test.log(LogStatus.INFO,"========== General Info Program Section Switches 'Track Excluded Contractors'==========");
		//wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("parentID"));
		Thread.sleep(1500);
		//driver.switchTo().defaultContent();
		Thread.sleep(1500);
		driver.switchTo().frame(HomePage.ContractorPackagePreviewPanelFrame(driver));
		Thread.sleep(2000);
		try {
			softAssertion.assertEquals(ContractorPackageModule.trackExcludedContractors(driver, InsuranceEnrollment),
					true);
			test.log(LogStatus.PASS,
					"Track Excluded Contractor switch is enabled and Insurance Enrollment is available at Preview panel");
		} catch (Throwable e) {
			test.log(LogStatus.FAIL,
					"Track Excluded Contractor switch is disabled and Insurance Enrollment is not available at Preview panel");
		}
		test.log(LogStatus.INFO, test
				.addScreenCapture(FileUtils1.captureScreen(driver, "Track Excluded Contractors Switch validation")));
	}

	@Test(priority=9)
	public void ProgramGeneralInfoIsTradeRequired() throws Throwable 
	{
		
		Thread.sleep(2000);
		test.log(LogStatus.INFO,"========== General Info Program Section Switches 'Is Trade Required for Contractor Package'==========");
		//wb.getWindowIDs();

		//driver.switchTo().defaultContent();
		Thread.sleep(1500);
		//System.out.println(driver.getWindowHandle());
		driver.switchTo().window(wb.map.get("parentID"));
		Thread.sleep(1500);
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].scrollIntoView();",
		 * ContractorPackageModule.EditBrn(driver)); Thread.sleep(3000);
		 * js.executeScript("arguments[0].click();",
		 * ContractorPackageModule.EditBrn(driver));
		 */
		ContractorPackageModule.EditBrn(driver).click();
		Thread.sleep(3000);
		wb.SwitchtoChild1();
		Thread.sleep(2000);

		WebElement ele = AddContractor_Pkg_Page.TradeCheck(driver);
		Thread.sleep(2000);
		System.out.println("element is" + ele);
		String Attribute = ele.getAttribute("class");
		Thread.sleep(3000);

		if (Attribute.equalsIgnoreCase("errorMark span-trade-validation")) {
			System.out.println(Attribute + "In if, Switch Is trade required is ON");
			test.log(LogStatus.PASS, Attribute + "Is trade required Switch is ON");
		} else {
			System.out.println(Attribute + "In else, Switch Is trade required is OFF");
			test.log(LogStatus.FAIL, Attribute + "Is trade required Switch is OFF");
		}

		test.log(LogStatus.INFO, test.addScreenCapture(
				FileUtils1.captureScreen(driver, "Is trade required for Contractor package Switch validation")));
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(wb.map.get("parentID"));
	}

	@Test(priority = 10)
	public void ProgramGeneralInfoMinReqEnrollmentAllowed() throws Throwable 
	{
		 Thread.sleep(2000);
		test.log(LogStatus.INFO,"========== General Info Program Section Switches 'Minimum Required Enrollment Allowed'==========");
		// wb.Switchtoparent();
		// Thread.sleep(2000);
		
		//Project level switch turning ON
		HomePage.controlMenuProject(driver).click();
		test.log(LogStatus.INFO, "Clicked on Project from control panel");
		Thread.sleep(2000);
		ProjectModule.projectSearchEditBox(driver).sendKeys(Project);
		Thread.sleep(2000);
		ProjectModule.projectSearchIcon(driver).click();
		Thread.sleep(2000);
		ProjectModule.projectEditIcon(driver).click();
		test.log(LogStatus.INFO, "Clicked on Project edit icon");
		Thread.sleep(4000);
System.out.println("1");
		//wb.getWindowIDs();
		wb.SwitchtoChild1();
		//driver.switchTo().window(wb.map.get("childID"));
		test.log(LogStatus.INFO, "On Edit window");
		Thread.sleep(2000);
System.out.println("2");		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		test.log(LogStatus.INFO, "scrolled to switch Min Requirement enrollment allowed in Project");
System.out.println("3");
		WebElement ele = AddProject_General_Information_Page.minRequirementEnrollmentAllowedSwitch(driver);
		String Attribute = ele.getAttribute("class");
		Thread.sleep(2000);

		if (Attribute.equalsIgnoreCase("ios-ui-select checked")) {
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,1000)");
			AddProject_General_Information_Page.generalInformationSaveButton(driver).click();
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Project level switch is already ON");
		} else {
			Thread.sleep(2000);
			AddProject_General_Information_Page.minRequirementEnrollmentAllowedSwitch(driver).click();
			Thread.sleep(2000);
			AddProject_General_Information_Page.generalInformationSaveButton(driver).click();
			test.log(LogStatus.INFO, "Project level switch was Off, now turned it ON");
		}
		test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Project level switch")));
		Thread.sleep(3000);

		// wb.getWindowIDs();
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(wb.map.get("parentID"));
		Thread.sleep(2000);

		HomePage.controlMenuContractorPackage(driver).click();
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Clicked on CP from control panel");
		ContractorPackageModule.searchEditBox(driver).sendKeys(CP);
		ContractorPackageModule.searchIcon(driver).click();
		Thread.sleep(2000);
		ContractorPackageModule.editIcon(driver).click();
		test.log(LogStatus.INFO, "Clicked on CP edit icon");
		Thread.sleep(2000);

		// wb.getWindowIDs();
		wb.SwitchtoChild1();
		// driver.switchTo().window(wb.map.get("childID"));
		test.log(LogStatus.INFO, "On Edit window CP");
		Thread.sleep(2000);
		// JavascriptExecutor j = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
		test.log(LogStatus.INFO, "scrolled to switch Min Requirement enrollment allowed in CP");

		Thread.sleep(2000);
		WebElement el = AddContractor_Pkg_Page.minRequirementEnrollmentAllowedSwitch(driver);
		String Attribut = el.getAttribute("class");
		Thread.sleep(2000);

		//Contract Package level switch turning ON
		if (Attribut.equalsIgnoreCase("ios-ui-select checked")) {
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,1000)");
			test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "CP level switch")));
			test.log(LogStatus.INFO, "CP level switch is already ON");
			Thread.sleep(2000);
			AddContractor_Pkg_Page.saveAndCloseBtn(driver).click();
			// AddContractorPage.addContractorSaveBtn(driver).click();
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Save and button clicked");
		} else {
			Thread.sleep(2000);
			AddContractor_Pkg_Page.minRequirementEnrollmentAllowedSwitch(driver).click();
			test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "CP level switch")));
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "CP level switch was Off, now turned it ON");
			// Thread.sleep(2000);
			AddContractor_Pkg_Page.saveAndCloseBtn(driver).click();
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Save and button clicked");
		}
		

		Thread.sleep(1500);
		//driver.close();
		Thread.sleep(1500);
		wb.Switchtoparent();
		//driver.switchTo().window(wb.map.get("parentID"));
System.out.println("4");		
		Thread.sleep(2000);
		driver.switchTo().frame(HomePage.ContractorPackagePreviewPanelFrame(driver));

		
		ContractorPackageModule.InsuranceEnrollmentPagePriviewP(driver).click();
		Thread.sleep(2000);

		wb.SwitchtoChild1();
		Thread.sleep(2000);
System.out.println("5");		
		test.log(LogStatus.INFO, "switched to Insurance Enrollment form window");
		js.executeScript("window.scrollBy(0,2500)");
		Thread.sleep(3500);
		ContractorPackageModule.ConfirmEnrolledRadioButton(driver).click();		
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Confirm Enrolled RadioButton clicked");
		AddContractor_Pkg_Insurance_Enrollment_Page.btnSave(driver).click();
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(1500);
		//driver.switchTo().defaultContent();
		
		driver.switchTo().window(wb.map.get("parentID"));
		Thread.sleep(3000);

		
		  WebElement e = ContractorPackageModule.CheckConditionallyEnrolled(driver, CP , Project, Enrolltype, ProgramName, Trade);
		  e.click();
		  
		  Thread.sleep(3000);
		  driver.switchTo().frame(HomePage.ContractorPackagePreviewPanelFrame(driver));
		  Thread.sleep(3000);
		  test.log(LogStatus.INFO, "Inside frame");
		 String str= ContractorPackageModule.Previewpanelstatus(driver, PreviewEnrollstatus).getText();
		 Thread.sleep(2300);
		 System.out.println("String:: "+ str);
		 
		if (str.contains("Conditionally Enrolled")) {
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Minimum Requirement Enrollments Allowed Switch is ON");
			test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Minimum Requirement Enrollments Allowed Switch")));
		}
		else
		{
			test.log(LogStatus.FAIL, "Minimum Requirement Enrollments Allowed Switch is OFF");
			test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Minimum Requirement Enrollments Allowed Switch")));
		}
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}

	@Test(priority = 11)
	public void ProgramGeneralInfoPreBidContractorPackage() throws Throwable 
	{
		test.log(LogStatus.INFO,"====== General Info Program Section Switches 'Enroll Pre Bid contractor Pkg'==========");
		HomePage.controlMenuContractorPackage(driver).click();
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Clicked on CP from control panel");
		ContractorPackageModule.searchEditBox(driver).sendKeys(CP);
		Thread.sleep(2000);
		ContractorPackageModule.searchIcon(driver).click();
		Thread.sleep(2000);
		 WebElement e = ContractorPackageModule.CheckEnrolledStatus(driver, CP , Project, Enrolltype, Enrollstatus,ProgramName, Trade);
		 e.click();
		 test.log(LogStatus.INFO, "CP with" + Enrollstatus +  "status selected");
		 Thread.sleep(2000);
		 
		ContractorPackageModule.editIcon(driver).click();
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Clicked on CP edit icon");
		Thread.sleep(2000);
		wb.SwitchtoChild1();
		Thread.sleep(3000);
		AddContractor_Pkg_Page.ContractTypeDDClickArrow(driver).click();
		Thread.sleep(2000);
		int DD =AddContractor_Pkg_Page.contracttypeDDtoverifyPreBid(driver).size();
System.out.println("Size is "+DD);		
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Contract Type DD is clicked");
	
		for(int i=0; i<DD; i++)
		{
			String str=AddContractor_Pkg_Page.contracttypeDDtoverifyPreBid(driver).get(i).getText();
			System.out.println("String is"+str);
			
			if(str.contains("Pre Bid"))
			{				
				test.log(LogStatus.PASS, "Pre Bid switch is ON");
				break;
			}
			else
			{				
				test.log(LogStatus.FAIL, "Pre Bid switch is OFF");
			}
			
		}
		
		Thread.sleep(1500);
		test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "DD Contract type for Pre Bid")));
		driver.close();
		
		Thread.sleep(2000);
	}
	
	@Test(priority = 12)
	public void ProgramGeneralInfoContractorToVerifiedInsuranceCostComparison() throws Throwable 
	{
		test.log(LogStatus.INFO,"====== General Info Program Section Switches 'Contractor to verified Insurance Cost Comparison'==========");
		wb.Switchtoparent();
		//HomePage.controlMenuHomeIcon(driver).click();
		Thread.sleep(2000);
System.out.println("11");		
		HomePage.controlMenuProject(driver).click();
		Thread.sleep(2000);
		ProjectModule.projectSearchEditBox(driver).sendKeys(Project);
		Thread.sleep(2000);
		ProjectModule.projectSearchIcon(driver).click();
		Thread.sleep(2000);
		ProjectModule.projectEditIcon(driver).click();
		Thread.sleep(2000);
		wb.SwitchtoChild1();
System.out.println("12");		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		
		
		WebElement ele = AddProject_General_Information_Page.contractortoverifyinsurancecostcomparisonswitch(driver);
		String Attribute = ele.getAttribute("class");
		Thread.sleep(2000);

		if (Attribute.equalsIgnoreCase("ios-ui-select checked")) {
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,1000)");
			AddProject_General_Information_Page.generalInformationSaveButton(driver).click();
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Project level switch is already ON");
		} else {
			Thread.sleep(2000);
			AddProject_General_Information_Page.contractortoverifyinsurancecostcomparisonswitch(driver).click();
			Thread.sleep(2000);
			AddProject_General_Information_Page.generalInformationSaveButton(driver).click();
			test.log(LogStatus.INFO, "Project level switch was Off, now turned it ON");
		}
		test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Project level switch")));
		Thread.sleep(3000);
		driver.close();
		wb.Switchtoparent();
		Thread.sleep(2000);

		HomePage.controlMenuContractorPackage(driver).click();
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Clicked on CP from control panel");
		ContractorPackageModule.searchEditBox(driver).sendKeys(CP);
		ContractorPackageModule.searchIcon(driver).click();
		Thread.sleep(2000);

		driver.switchTo().frame(HomePage.ContractorPackagePreviewPanelFrame(driver));
		Thread.sleep(2000);		
		ContractorPackageModule.InsuranceEnrollmentPagePriviewP(driver).click();
		Thread.sleep(2000);
		wb.SwitchtoChild1();
		test.log(LogStatus.INFO, "switched to Insurance Enrollment form window");
		js.executeScript("window.scrollBy(0,1000)");
		test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Project level switch")));
		Thread.sleep(2000);
		WebElement el= AddContractor_Pkg_Insurance_Enrollment_Page.ContractorCompanyInsurancecost(driver);
		String st=el.getText();
		System.out.println(st);
		Thread.sleep(2000);
		
		  if(st.contains("Contractor Company’s Insurance Cost *")) 
		  {
			  test.log(LogStatus.PASS, "switch Contractor to verified Insurance cost company is ON");
		  }
		  else
		  {
			  test.log(LogStatus.FAIL, "switch Contractor to verified Insurance cost company is OFF");
		  }
		 
		 driver.close();
		 Thread.sleep(2000);
		// driver.switchTo().defaultContent();
		 driver.switchTo().window(wb.map.get("parentID"));
		 Thread.sleep(1500);
		 //HomePage.controlMenuHomeIcon(driver).click();
		 
	}
	
//	@Test(priority = 13) //Working Fine. Bug in WP.
	public void ProgramGeneralInfoTrackInsurancecost() throws Throwable 
	{
		test.log(LogStatus.INFO,"====== General Info Program Section Switches 'Track Ins Cost'==========");
		//wb.Switchtoparent();                  //if required
		Thread.sleep(2000);
		HomePage.controlMenuProject(driver).click();
		test.log(LogStatus.INFO, "Clicked on Project from control panel");
		Thread.sleep(2000);
		ProjectModule.projectSearchEditBox(driver).sendKeys(Project);
		ProjectModule.projectSearchIcon(driver).click();
		Thread.sleep(2000);
		ProjectModule.projectEditIcon(driver).click();
		test.log(LogStatus.INFO, "Clicked on Project edit icon");
		Thread.sleep(2000);

		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		test.log(LogStatus.INFO, "On Edit window");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		test.log(LogStatus.INFO, "scrolled to switch Min Requirement enrollment allowed in Project");

		WebElement ele = AddProject_General_Information_Page.TrackInsuranceCostSwitch(driver);
		String Attribute = ele.getAttribute("class");
		Thread.sleep(2000);
		//test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Project level Track Ins cost switch")));
		
		if (Attribute.equalsIgnoreCase("ios-ui-select checked")) {
			test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Project level Track Ins cost switch")));
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,1000)");
			AddProject_General_Information_Page.generalInformationSaveButton(driver).click();
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Project level Track Ins cost switch is already ON");
		} else {
			Thread.sleep(2000);
			AddProject_General_Information_Page.TrackInsuranceCostSwitch(driver).click();
			Thread.sleep(2000);
			test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Project level Track Ins cost switch")));
			AddProject_General_Information_Page.generalInformationSaveButton(driver).click();
			test.log(LogStatus.INFO, "Project level Track Ins Cost switch was Off, now turned it ON");
		}
		
		Thread.sleep(3000);

		driver.close();
		// wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("parentID"));
		Thread.sleep(3000);
		
		HomePage.controlMenuContractorPackage(driver).click();
		test.log(LogStatus.INFO, "Clicked on Contractor Package");
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Clicked on CP from control panel");
		Thread.sleep(2000);
		ContractorPackageModule.searchEditBox(driver).sendKeys(CP);
		ContractorPackageModule.searchIcon(driver).click();
		Thread.sleep(2000);
		driver.switchTo().frame(HomePage.ContractorPackagePreviewPanelFrame(driver));
		Thread.sleep(2000);

		ContractorPackageModule.InsuranceEnrollmentPagePriviewP(driver).click();
		Thread.sleep(2000);
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,-950)");
		Thread.sleep(2000);
		
		wb.SwitchtoChild1();
		test.log(LogStatus.INFO, wb.getTitle());
		Thread.sleep(2000);
		test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Track Insurance Cost")));
		int tabs=AddContractor_Pkg_Enrollment_Summary_Page.WCPremiumsModificationGLandUmbrellaCoverageTabs(driver).size();
		System.out.println(tabs);
		int count=0;
		
		for(int i=0; i<tabs; i++)
		{
			String str=AddContractor_Pkg_Enrollment_Summary_Page.WCPremiumsModificationGLandUmbrellaCoverageTabs(driver).get(i).getText();
			System.out.println(str);
			if(str.equalsIgnoreCase("WC Premiums Modifications"))
			{
				test.log(LogStatus.PASS, "Tab visible:: " + str);
				count++;
				 
			}
			if(str.equalsIgnoreCase("GL & Umbrella Coverage"))
			{
				test.log(LogStatus.PASS, "Tab visible:: " + str);
				count++;
			}
		}
		
		if(count==2)
		{
			test.log(LogStatus.PASS, "Track status switch is ON");
		}
		else
		{
			test.log(LogStatus.FAIL, "Track status switch is OFF");
		}
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(wb.map.get("parentID"));		
	}
	
	@Test(priority = 14)
	public void ProgramGeneralInfoAllowNegotiatedInsCost() throws Throwable 
	{
		test.log(LogStatus.INFO,"====== General Info Program Section Switches 'Allow Negotiated Ins Cost'==========");
		//wb.Switchtoparent();                  //if required
		Thread.sleep(2000);
		
		HomePage.controlMenuContractorPackage(driver).click();
		test.log(LogStatus.INFO, "Clicked on Contractor Package");
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Clicked on CP from control panel");
		Thread.sleep(2000);
		ContractorPackageModule.searchEditBox(driver).sendKeys(CP);
		ContractorPackageModule.searchIcon(driver).click();
		Thread.sleep(2000);
		driver.switchTo().frame(HomePage.ContractorPackagePreviewPanelFrame(driver));
		Thread.sleep(2000);

		ContractorPackageModule.InsuranceEnrollmentPagePriviewP(driver).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,-950)");
		Thread.sleep(2000);
		
		wb.SwitchtoChild1();
		Thread.sleep(2000);
		AddContractor_Pkg_GL_Umbrella_Coverage_Page.GLandUmbrellaCoverageTab(driver).click();
		test.log(LogStatus.INFO, "Clicked on GL_Umbrella_Coverage tab ");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,1000)");
		Boolean b= AddContractor_Pkg_GL_Umbrella_Coverage_Page.EstimatedInsuranceCostLink(driver);
		test.log(LogStatus.INFO, "Crolled to link, verifing if link is present or not");
		
		if(b.equals(true))
		{
			test.log(LogStatus.PASS, "Inside if, Switch is Allowed contractor to negotiate ON");
			test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Allow negotiated Ins cost")));
		}
		else
		{
			test.log(LogStatus.FAIL, "Inside else, Switch is Allowed contractor to negotiate OFF");
		}
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(wb.map.get("parentID"));	
		
	}
	
		@Test(priority = 15)
		public void ProgramGeneralInfoTrackLossControlANdSafety() throws Throwable 
		{
			test.log(LogStatus.INFO,"====== General Info Program Section Switches 'Track Loss Control And Safety'==========");
			//wb.Switchtoparent();                  //if required
			Thread.sleep(2000);
			
			HomePage.controlMenuContractorPackage(driver).click();
			test.log(LogStatus.INFO, "Clicked on Contractor Package");
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Clicked on CP from control panel");
			Thread.sleep(2000);
			ContractorPackageModule.searchEditBox(driver).sendKeys(CP);
			ContractorPackageModule.searchIcon(driver).click();
			Thread.sleep(2000);
			driver.switchTo().frame(HomePage.ContractorPackagePreviewPanelFrame(driver));
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Inside Preview panel");
			
			int DD= AddContractor_Pkg_Page.PreviewlinkSection2(driver).size();
			Thread.sleep(2000);
			
			boolean Flag=false;
			
			for(int i=0; i<DD; i++)
			{
				String str=AddContractor_Pkg_Page.PreviewlinkSection2(driver).get(i).getText();
				System.out.println(str);
				
				if(str.contains("Safety Observation(s):"))
				{
					test.log(LogStatus.PASS, "Track loss control and safety Switch is ON");
					Flag=true;
					break;
				}
				
			}
			
			if(Flag==false)
			{
				test.log(LogStatus.FAIL, "Track loss control and safety Switch is OFF");
			}
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
		}
		
		@Test(priority = 16)
		public void ProgramGeneralInfoRequiredCloseoutForLowerTierArchitecture() throws Throwable 
		{
			test.log(LogStatus.INFO,"====== General Info Program Section Switches 'Required Clos eout For LowerTier Architecture'==========");
			Thread.sleep(2000);
			
			HomePage.controlMenuContractorPackage(driver).click();
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Clicked on CP from control panel");
			ContractorPackageModule.searchEditBox(driver).sendKeys(CP);
			Thread.sleep(2000);
			ContractorPackageModule.searchIcon(driver).click();
			Thread.sleep(2000);
			 WebElement e = ContractorPackageModule.CheckEnrolledStatus(driver, CP , Project, Enrolltype, Enrollstatus1,ProgramName, Trade1);
			 e.click();
			 test.log(LogStatus.INFO, "CP with" + Enrollstatus1 +  "status selected");
			 Thread.sleep(2000);
			
			driver.switchTo().frame(HomePage.ContractorPackagePreviewPanelFrame(driver));
			Thread.sleep(2000);
			int size=AddContractor_Pkg_Page.PreviewlinkSection3(driver).size();
			
			for(int i=0; i<size; i++)
			{
				String str=AddContractor_Pkg_Page.PreviewlinkSection3(driver).get(i).getText();
				Thread.sleep(2000);
				System.out.println("String is"+str);
				
				if(str.contains("Completion Notice:"))
				{				
					test.log(LogStatus.PASS, "Completion Notice link found");
					Thread.sleep(2500);
					AddContractor_Pkg_Page.PreviewlinkSection3(driver).get(i).click();
					Thread.sleep(2000);
					wb.SwitchtoChild1();
					test.log(LogStatus.INFO, "Inside child window Completion notice");
					Thread.sleep(2000);
					int siz=AddContractor_Pkg_Page.lowertiercontractorcheck(driver).size();
					for(int j=0; j<size; j++)
					{
						String str1=AddContractor_Pkg_Page.lowertiercontractorcheck(driver).get(i).getText();
						test.log(LogStatus.INFO, str1);
						System.out.println("String is"+str1);
						if(str1.contains("There are still open Subcontractors for this Contractor Package. You cannot Closed-Out the Upper-Tier until all Subcontractors are Closed-Out."))
						{
							test.log(LogStatus.PASS, "Switch Required Clos eout For LowerTier Architecture is ON");
							test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Required Clos eout For LowerTier Architecture is ON")));
						}
						else
						{
							test.log(LogStatus.FAIL, "Switch Required Clos eout For LowerTier Architecture is OFF");
							test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Required Clos eout For LowerTier Architecture is OFF")));
						}
						
					}
					break;
				}
				else
				{				
					test.log(LogStatus.FAIL, "Completion Notice link not found");
				}
	
			}
			
			driver.close();
			Thread.sleep(2000);
			wb.Switchtoparent();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
