/**
 * 
 */
package TestScript_Neha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.FileUtils1;
import GenericLibrary.RandomClass;
import ModulerLibrary.NCP_GCLoginAction;
import ModulerLibrary.NCP_SponsorLoginAction;
import ObjectRepository.AddContractor_Pkg_Enrollment_Summary_Page;
import ObjectRepository.AddContractor_Pkg_Insurance_Enrollment_Page;
import ObjectRepository.AddContractor_Pkg_Page;
import ObjectRepository.AddContractor_Pkg_SubContractorInfo;
import ObjectRepository.AddProgramPage;
import ObjectRepository.AddProgram_Email_Management_Page;
import ObjectRepository.AddProgram_General_Info_Page;
import ObjectRepository.AddProjectPage;
import ObjectRepository.AddProject_Email_Management_Page;
import ObjectRepository.AddProject_General_Information_Page;
import ObjectRepository.AddTradePage;
import ObjectRepository.ContractorPackageModule;
import ObjectRepository.EmailModule;
import ObjectRepository.HomePage;
import ObjectRepository.ProgramModule;
import ObjectRepository.ProjectModule;
import ObjectRepository_NCP.NCP_EnrollmentPage;
import ObjectRepository_NCP.NCP_HomePage;
import ObjectRepository_NCP.NCP_MyContractsPage;
import ObjectRepository_NCP.NCP_SubContractorPage;
import TestScript.AddProgramTestClass;

/**
 * @author NDave
 *
 */
public class TaskValidationEmailManagementTest extends BaseClass {
	
	WebDriverCommonLib wb = new WebDriverCommonLib();
	String programName=RandomClass.randomProgram();
	String projectName = RandomClass.randomProject();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String MailSentTo = "";
	String Email_String = "divyesh@nourtek.com;neha.dave@nourtek.com";
	String Email_StringContains = "neha.dave@nourtek.com";
	//String Email_Portal = "neha.dave@nourtek.com";
	String ContractorName = "Hafiz contractor";
	String Trade = "Air-Conditioning";
	
	
	@Test(priority=1)
	public void Program_EmailManagement_CPCreatedFirstTime() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "========== Email Management ---Contractor Package is created first time--- ==========");
		HomePage.controlMenuHomeIcon(driver).click();
		test.log(LogStatus.INFO, "Clicked On Home Icon");
		HomePage.HomeMenuPrograms(driver).click();
		test.log(LogStatus.INFO, "Clicked On Programs Module Icon");
		Thread.sleep(2000);
	
		//Add new Program
		test.log(LogStatus.INFO, "========== Add Program Section  ==========");
		ProgramModule.programAddIcon(driver).click();
		test.log(LogStatus.INFO, "Clicked On Program Add Icon");
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		wb.windowScrollBy(0, 1000);
		AddProgram_General_Info_Page.programName(driver).sendKeys(programName);
		System.out.println(programName);
		test.log(LogStatus.PASS, "Program Name Added Successfully");
		
		//Program Administrator
		AddProgram_General_Info_Page.addNewNodeAdministratorLink(driver).click();
		test.log(LogStatus.PASS, "Clicked on Add New Administrator Link");		
		wb.getWindowID3();
		driver.switchTo().window(wb.map.get("subchildID"));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		AddProgram_General_Info_Page.contractorCompanyNameField(driver).sendKeys("Alex Comp53");
		Thread.sleep(2000);
		AddProgram_General_Info_Page.contractorCompanyNameField(driver).sendKeys(Keys.TAB);
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Company Name Added Successfully");
		AddProgram_General_Info_Page.contactFirstName(driver).sendKeys(RandomClass.randomContactName("Rony"));
		test.log(LogStatus.PASS, "Contact First Name Added Successfully");
		AddProgram_General_Info_Page.contactLastName(driver).sendKeys(RandomClass.randomContactName("Jony"));
		test.log(LogStatus.PASS, "Contact Last Name Added Successfully");
		AddProgram_General_Info_Page.contactEmail(driver).sendKeys("neha.dave@nourtek.com");
		test.log(LogStatus.PASS, "Contact Email ID Name Added Successfully");
		AddProgram_General_Info_Page.contactCellPhone(driver).sendKeys("12345678912579");
		test.log(LogStatus.PASS, "Contact Phone NO Name Added Successfully");
		AddProgram_General_Info_Page.addAdministratorSaveAndCloseButton(driver).click();
		test.log(LogStatus.PASS, "Clicked On Save And Close Button");
		Thread.sleep(3000);
		driver.switchTo().window(wb.map.get("childID"));
		test.log(LogStatus.PASS, "New Administrator Added Successfully");
		
		//sponsor
		AddProgram_General_Info_Page.addNewSponsorLink(driver).click();
		test.log(LogStatus.PASS, "Clicked on Add New Sponsor Link");
		wb.getWindowID3();
		driver.switchTo().window(wb.map.get("subchildID"));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		AddProgram_General_Info_Page.contractorCompanyNameField(driver).sendKeys("Sponsor1735");;
		Thread.sleep(2000);
		AddProgram_General_Info_Page.contractorCompanyNameField(driver).sendKeys(Keys.TAB);
		test.log(LogStatus.PASS, "Company Name Added Successfully");
		Thread.sleep(3000);
		AddProgram_General_Info_Page.contactFirstName(driver).sendKeys(RandomClass.randomContactName("Jonty"));
		test.log(LogStatus.PASS, "Sponsor First Name Added Successfully");
		Thread.sleep(2000);
		AddProgram_General_Info_Page.contactLastName(driver).sendKeys(RandomClass.randomContactName("Rode"));
		test.log(LogStatus.PASS, "Sponsor Last Name Added Successfully");
		Thread.sleep(2000);
		AddProgram_General_Info_Page.contactEmail(driver).sendKeys("neha.dave@nourtek.com");
		test.log(LogStatus.PASS, "Sponsor Email ID Name Added Successfully");
		Thread.sleep(2000);
		AddProgram_General_Info_Page.contactCellPhone(driver).sendKeys("12345678912579");
		test.log(LogStatus.PASS, "Sponsor Phone NO Name Added Successfully");
		AddProgram_General_Info_Page.addAdministratorSaveAndCloseButton(driver).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Clicked On Save And Close Button");
		driver.switchTo().window(wb.map.get("childID"));
		test.log(LogStatus.PASS, "New Sponsor Added Successfully");
		Thread.sleep(2000);
		
		//Switch 
		AddProgram_General_Info_Page.TrackExcludedContractor(driver).click();
		Thread.sleep(2000);
		
		//Save and close button
		wb.windowScrollBy(0, 1000);
		AddProgram_General_Info_Page.saveButton(driver).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Clicked On Save Button");
		Thread.sleep(2000);
		AddProgramPage.addProgramEmailManagementTab(driver).click();
		Thread.sleep(15000);
		wb.windowScrollBy(0, 1500);
		AddProgram_Email_Management_Page.emailManagementSaveAndCloseButton(driver).click();
		Thread.sleep(2000);
		wb.Switchtoparent();
		
		//Add New Project
		
		test.log(LogStatus.INFO, "========== Add Project Section  ==========");		
		Thread.sleep(1500);
		HomePage.controlMenuProject(driver).click();
		test.log(LogStatus.INFO, "Clicked on Project Module Icon");
		ProjectModule.projectAddIcon(driver).click();
		test.log(LogStatus.INFO, "Clicked on Add Project Icon");
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		Thread.sleep(2000);
		driver.manage().window().maximize();

		wb.selectSingleValue(AddProject_General_Information_Page.selectProgramField(driver), programName);
		test.log(LogStatus.PASS, "Program Selected Successfully");
		Thread.sleep(2000);
		AddProject_General_Information_Page.projectNameField(driver).sendKeys(projectName);
		test.log(LogStatus.PASS, "Project Name Added Successfully");
		Thread.sleep(2000);
		wb.selectSingleValue(AddProject_General_Information_Page.selectStateField(driver), RandomClass.randomState());
		test.log(LogStatus.PASS, "Project State Selected Successfully");
		Thread.sleep(2000);
		AddProject_General_Information_Page.endDate(driver).sendKeys("01/04/2023");
		test.log(LogStatus.PASS, "Project End Date Added Successfully");
		Thread.sleep(2000);
		wb.windowScrollBy(0, 1000);
		AddProjectPage.SaveBtnGIPage(driver).click();
		Thread.sleep(2000);
		AddProjectPage.addProjectEmailManagementTab(driver).click();
		Thread.sleep(2000);
		AddProject_Email_Management_Page.projectLevelEmailManagementSwitch(driver).click();
		Thread.sleep(2000);
		test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Existing Project Email selection")));
		
		//------------------- Untick and selection of checkboxes for GC and SubC
		wb.UN_Tick_List_of_ChkBoxes(AddProject_Email_Management_Page.ContractorPackageIsCreatedFirstTime(driver));
		wb.UN_Tick_List_of_ChkBoxes(AddProject_Email_Management_Page.AdditionalCPCreated(driver));
		wb.UN_Tick_List_of_ChkBoxes(AddProject_Email_Management_Page.ContractorPackagecreatedfromContractorPortal(driver));
		wb.UN_Tick_List_of_ChkBoxes(AddProject_Email_Management_Page.ExcludedEnrollmentConfirmedbyAdministrator(driver));
		wb.UN_Tick_List_of_ChkBoxes(AddProject_Email_Management_Page.EnrollmentsubmittedByContractor(driver));
		
		Thread.sleep(2000);
		AddProject_Email_Management_Page.ContractorPackageIsCreatedFirstTime_GC_chkbox(driver).click();
		Thread.sleep(1000);
		AddProject_Email_Management_Page.ContractorPackageIsCreatedFirstTime_SubC_chkbox(driver).click();
		Thread.sleep(1000);
		AddProject_Email_Management_Page.AdditionalCPCreated_GC_chkbox(driver).click();
		Thread.sleep(1000);
		AddProject_Email_Management_Page.AdditionalCPCreated_SubC_chkbox(driver).click();
		Thread.sleep(2000);
		AddProject_Email_Management_Page.ContractorPackagecreatedfromContractorPortal_GC_chkbox(driver).click();
		Thread.sleep(2000);
		AddProject_Email_Management_Page.ContractorPackagecreatedfromContractorPortal_SubC_chkbox(driver).click();
		Thread.sleep(2000);
		AddProject_Email_Management_Page.ExcludedEnrollmentConfirmedbyAdministrator_GC_chkbox(driver).click();
		Thread.sleep(2000);
		AddProject_Email_Management_Page.ExcludedEnrollmentConfirmedbyAdministrator_SubC_chkbox(driver).click();
		Thread.sleep(2000);
		AddProject_Email_Management_Page.EnrollmentSubmittedByContractor_GC_chkbox(driver).click();
		Thread.sleep(2000);
		AddProject_Email_Management_Page.EnrollmentSubmittedByContractor_SubC_chkbox(driver).click();
		Thread.sleep(2000);
		
		
		
		
		wb.windowScrollBy(0, 2500);
		AddProject_Email_Management_Page.saveAndCloseButton(driver).click();
		Thread.sleep(2000);
		wb.Switchtoparent();
		
		//---------------------------------------------------------------------------
		//Add New ContractorPackage
		test.log(LogStatus.INFO, "========== Add Contractor Package Section  ==========");		
		HomePage.controlMenuContractorPackage(driver).click();
		test.log(LogStatus.INFO, "Clicked on CP Module Icon");
		ContractorPackageModule.addIcon(driver).click();
		//js.executeScript("arguments[0].click();",ContractorPackageModule.addIcon(driver));
		test.log(LogStatus.INFO, "Clicked On Add Contractor Package Icon");
		Thread.sleep(2000);
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		driver.manage().window().maximize();
		

		wb.waitForElemnet(AddContractor_Pkg_Page.selectProgram(driver));
		AddContractor_Pkg_Page.selectProgramSearchBox(driver).sendKeys(programName);
		
		wb.selectSingleValueFromList(AddContractor_Pkg_Page.selectProgramDropdownAutocomplete(driver), programName);
		System.out.println("Program Added Successfully");
		test.log(LogStatus.PASS, programName+" Program  added successfully");
		Thread.sleep(2500);

		AddContractor_Pkg_Page.selectProject(driver).click();
		AddContractor_Pkg_Page.selectProjectSearchBox(driver).sendKeys(projectName);
		wb.selectSingleValueFromList(AddContractor_Pkg_Page.selectProjectDropdownAutocomplete(driver), projectName);
		System.out.println("Project Added Successfully");
		test.log(LogStatus.PASS, projectName+ " Project added successfully");
		
		Thread.sleep(2000);
		AddContractor_Pkg_Page.selectEnrollmentType(driver).click();
		AddContractor_Pkg_Page.selectEnrollmentTypeSearchBox(driver).sendKeys("WC & GL");
		System.out.println("Enrollment Type Added Successfully");
		test.log(LogStatus.PASS, "Enrollment Type added successfully");
		wb.selectSingleValueFromList(AddContractor_Pkg_Page.selectEnrollmentTypeDropdownAutocomplete(driver), "WC & GL Enrollment");
		Thread.sleep(2000);
		
		//Add Contractor
		AddContractor_Pkg_Page.addNewContractorLink(driver).click();
		test.log(LogStatus.PASS, "Clicked on Add New Contractor Link");
		wb.getWindowID3();
		driver.switchTo().window(wb.map.get("subchildID"));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		AddProgram_General_Info_Page.contractorCompanyNameField(driver).sendKeys("hafiz");;
		Thread.sleep(2000);
		AddProgram_General_Info_Page.contractorCompanyNameField(driver).sendKeys(Keys.TAB);
		test.log(LogStatus.PASS, "Company Name Added Successfully");
		Thread.sleep(3000);
		AddProgram_General_Info_Page.contactFirstName(driver).sendKeys(RandomClass.randomContactName("Jonty"));
		test.log(LogStatus.PASS, "Contractor First Name Added Successfully");
		AddProgram_General_Info_Page.contactLastName(driver).sendKeys(RandomClass.randomContactName("Rode"));
		test.log(LogStatus.PASS, "Contractor Last Name Added Successfully");
		AddProgram_General_Info_Page.contactEmail(driver).sendKeys("neha.dave@nourtek.com");
		test.log(LogStatus.PASS, "Contractor Email ID Name Added Successfully");
		AddProgram_General_Info_Page.contactCellPhone(driver).sendKeys("12345678912579");
		test.log(LogStatus.PASS, "Contractor Phone NO Name Added Successfully");
		AddProgram_General_Info_Page.addAdministratorSaveAndCloseButton(driver).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Clicked On Save And Close Button");
		driver.switchTo().window(wb.map.get("childID"));
		test.log(LogStatus.PASS, "New Contractor Added Successfully");
		//Trade
		wb.selectSingleValueFromList(AddContractor_Pkg_Page.TradeDD(driver),"1234 | 1234-");
		Thread.sleep(2000);
		wb.windowScrollBy(0, 1500);
		AddContractor_Pkg_Page.btnNext(driver).click();
		Thread.sleep(2000);
		test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Email selection")));
		AddContractor_Pkg_Page.sendEmailSendAndCloseBtn(driver).click();
		driver.switchTo().window(wb.map.get("parentID"));
		System.out.println("Contractor Package Created Successfully");
		test.log(LogStatus.PASS, "Contractor Package Created successfully");
		
		
		//Email Verification
		Thread.sleep(2000);
		wb.windowScrollBy(0, 200);
		HomePage.controlMenuEmailIcon(driver).click();	
		test.log(LogStatus.PASS, "Email Icon at Home Page is clicked");
		Thread.sleep(3000); 
		wb.mouseover(HomePage.controlMenuEmailIcon(driver));
		Thread.sleep(2000);
		test.log(LogStatus.PASS,"Mouse over is performed on Email Icon in Side Panel at Home Page");
		wb.mouseMoveToElement(HomePage.HomeMenuEmail_Sent(driver));
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Sent Email icon is clicked at Email page");
		Thread.sleep(4000); 
		test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Email sent to")));
		
		EmailModule.SentEmail_Selectfirstvaluefromlist(driver).click();
		Thread.sleep(4000);
		driver.switchTo().frame(HomePage.EmailPreviewPanelFrame(driver));
		String str=EmailModule.SentEmail_Selectfirstvaluefromlist_ToField(driver).getText();
		Thread.sleep(2000);
		test.log(LogStatus.INFO, str);
		System.out.println(str);
		Thread.sleep(2000);
		
		if(str.contains(Email_String))
		{
			System.out.println("CP created first time, Email sent to correct recipient");
			test.log(LogStatus.PASS, str);
		}
		else
		{
			System.out.println("CP created first time, Email sent to incorrect recipient");
			test.log(LogStatus.FAIL, str);
		}
		
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}
	
//	@Test
	public void test() throws Throwable
	{

		try
		{
		String dbURL = "jdbc:mysql://localhost:3036/wrapportal";
		String username = "root";
		String password = "pass123";
		String query = "select * from clients";
		
		//Loading Drivers
		Class.forName("com.mysql.jdbc.Driver");
		
		//Connection Establishment
		Connection con= DriverManager.getConnection(dbURL, username, password);
		System.out.println(1);
		
		//Create statement object
		Statement stmt = con.createStatement();
		
		//Execute query and store result
		ResultSet rs= stmt.executeQuery(query);
		System.out.println(rs);
		System.out.println(2);
		if (con != null) 
		{ 
			System.out.println(3);
			System.out .println("Successfully connected to MySQL database test"); 
			 
		}
	}catch (SQLException ex) 
		{ 
		System.out .println("An error occurred while connecting MySQL databse"); 
		ex.printStackTrace(); 
		}
	}
	
//	@Test(priority=2)
	public void Program_EmailManagement_AdditionalCPCreated() throws Throwable
	{
		test.log(LogStatus.INFO, "========== Email Management ---Additional CP created--- ==========");
		HomePage.controlMenuHomeIcon(driver).click();
		test.log(LogStatus.INFO, "Clicked On Home Icon");
				
		//Add New ContractorPackage
				test.log(LogStatus.INFO, "========== Add Contractor Package Section  ==========");		
				HomePage.controlMenuContractorPackage(driver).click();
				test.log(LogStatus.INFO, "Clicked on CP Module Icon");
				ContractorPackageModule.addIcon(driver).click();
				//js.executeScript("arguments[0].click();",ContractorPackageModule.addIcon(driver));
				test.log(LogStatus.INFO, "Clicked On Add Contractor Package Icon");
				Thread.sleep(2000);
				wb.getWindowIDs();
				driver.switchTo().window(wb.map.get("childID"));
				driver.manage().window().maximize();
				

				wb.waitForElemnet(AddContractor_Pkg_Page.selectProgram(driver));
				AddContractor_Pkg_Page.selectProgramSearchBox(driver).sendKeys(programName);
				
				wb.selectSingleValueFromList(AddContractor_Pkg_Page.selectProgramDropdownAutocomplete(driver), programName);
				System.out.println("Program Added Successfully");
				test.log(LogStatus.PASS, programName+" Program  added successfully");
				Thread.sleep(2500);

				AddContractor_Pkg_Page.selectProject(driver).click();
				AddContractor_Pkg_Page.selectProjectSearchBox(driver).sendKeys(projectName);
				wb.selectSingleValueFromList(AddContractor_Pkg_Page.selectProjectDropdownAutocomplete(driver), projectName);
				System.out.println("Project Added Successfully");
				test.log(LogStatus.PASS, projectName+ " Project added successfully");
				
				Thread.sleep(4000);
				AddContractor_Pkg_Page.selectEnrollmentType(driver).click();
				Thread.sleep(2000);
				AddContractor_Pkg_Page.selectEnrollmentTypeSearchBox(driver).sendKeys("WC & GL");
				System.out.println("Enrollment Type Added Successfully");
				test.log(LogStatus.PASS, "Enrollment Type added successfully");
				wb.selectSingleValueFromList(AddContractor_Pkg_Page.selectEnrollmentTypeDropdownAutocomplete(driver), "WC & GL Enrollment");
				Thread.sleep(2000);
				
				//Select Contractor
				AddContractor_Pkg_Page.selectContractor(driver).sendKeys(ContractorName);
				Thread.sleep(1500);
				AddContractor_Pkg_Page.selectContractor(driver).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				test.log(LogStatus.INFO, "Contractor name selected successfully");
				
				Thread.sleep(3000);
				AddContractor_Pkg_Page.selectContactsearch(driver).click();
				Thread.sleep(4000);
				AddContractor_Pkg_Page.selectContactsearch(driver).sendKeys("Contractor contractor");
				test.log(LogStatus.PASS, "Contact search added successfully");
				System.out.println("Contact search clicked");
				wb.selectSingleValueFromList(AddContractor_Pkg_Page.selectContactList(driver),"Contractor contractor");
				Thread.sleep(2000);
				
				//Trade
				AddContractor_Pkg_Page.TradeSearch(driver).click();
				Thread.sleep(4000);
				wb.selectSingleValueFromList(AddContractor_Pkg_Page.TradeDD(driver),"1234 | 1234-");
				Thread.sleep(2000);
				wb.windowScrollBy(0, 1500);
				AddContractor_Pkg_Page.btnNext(driver).click();
				Thread.sleep(2000);
				test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Email selection")));
				AddContractor_Pkg_Page.sendEmailSendAndCloseBtn(driver).click();
				driver.switchTo().window(wb.map.get("parentID"));
				System.out.println("Contractor Package Created Successfully");
				test.log(LogStatus.PASS, "Contractor Package Created successfully");
				
				//Email Verification
				Thread.sleep(2000);
				wb.windowScrollBy(0, 200);
				HomePage.controlMenuEmailIcon(driver).click();	
				test.log(LogStatus.PASS, "Email Icon at Home Page is clicked");
				Thread.sleep(3000); 
				wb.mouseover(HomePage.controlMenuEmailIcon(driver));
				Thread.sleep(2000);
				test.log(LogStatus.PASS,"Mouse over is performed on Email Icon in Side Panel at Home Page");
				wb.mouseMoveToElement(HomePage.HomeMenuEmail_Sent(driver));
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "Sent Email icon is clicked at Email page");
				Thread.sleep(4000); 
				test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Email sent to")));
				
				EmailModule.SentEmail_Selectfirstvaluefromlist(driver).click();
				Thread.sleep(2000);
				driver.switchTo().frame(HomePage.EmailPreviewPanelFrame(driver));
				String str=EmailModule.SentEmail_Selectfirstvaluefromlist_ToField(driver).getText();
				Thread.sleep(2000);
				test.log(LogStatus.INFO, str);
				System.out.println(str);
				Thread.sleep(2000);
				
				if(str.contains(Email_String))
				{
					System.out.println("Additional CP Created, Email sent to correct recipient");
					test.log(LogStatus.PASS, str);
					test.log(LogStatus.PASS, "Additional CP Created, Email sent to correct recipient");
				}
				else
				{
					System.out.println("Additional CP Created, Email sent to incorrect recipient");
					test.log(LogStatus.FAIL, str);
					test.log(LogStatus.PASS, "Additional CP Created, Email sent to incorrect recipient");
				}
				driver.switchTo().defaultContent();
				
	}
	
//	@Test(priority=3)
	public void Program_EmailManagement_CPcreatedfromthecontractorportal() throws Throwable
	{	
		 Thread.sleep(2000);
		 String BaseUrl=driver.getCurrentUrl();
		 NCP_GCLoginAction.logInNCP(driver);
		 Thread.sleep(2000);
		 
		 NCP_MyContractsPage.MyContracts_CPlist_FirstElement(driver).click();
		 
		 Thread.sleep(2000);
		 int size1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).size();
		 for(int j=0;j<size1;j++)
		 {
			 String str1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).getText();
			 Thread.sleep(4000);
			 
			 if(str1.contains("Subcontractors"))
			 {
				 NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).click();
				 Thread.sleep(4000);
				 wb.windowScrollBy(0, 1000);
				 NCP_SubContractorPage.AddSubContractorbtn(driver).click();
				 test.log(LogStatus.PASS, "Add Subcontractor button clicked");
				 Thread.sleep(4000);
				 NCP_SubContractorPage.Contractor(driver).sendKeys(ContractorName);
				 Thread.sleep(4000);
				 NCP_SubContractorPage.Contractor(driver).sendKeys(Keys.ENTER);
				 Thread.sleep(6000);
				 test.log(LogStatus.PASS, "Contractor name entered");
				 NCP_SubContractorPage.contactsearch(driver).click();
				 Thread.sleep(2000);
				// NCP_SubContractorPage.contactsearch(driver).sendKeys("Contractor contractor");
				 Thread.sleep(2000);
				 wb.selectSingleValueFromList(NCP_SubContractorPage.contact(driver),"Contractor contractor");
				 Thread.sleep(2000);
				 test.log(LogStatus.PASS, "contact selected successfully");
				 NCP_SubContractorPage.EstimatedContractValue(driver).sendKeys("5");
				 Thread.sleep(2000);
				 test.log(LogStatus.PASS, "Estimated contract value selected successfully");
				 NCP_SubContractorPage.EstimatedstartDate(driver).sendKeys("01/01/2021");
				 Thread.sleep(2000);
				 test.log(LogStatus.PASS, "Estimated start value selected successfully");
				 NCP_SubContractorPage.Trade(driver).sendKeys(Trade);
				 Thread.sleep(3000);
				 NCP_SubContractorPage.Trade(driver).sendKeys(Keys.ENTER);
				 Thread.sleep(4000);
				 test.log(LogStatus.PASS, "Trade selected successfully");
				 Thread.sleep(4000);
				 wb.windowScrollBy(0, 1000);
				 Thread.sleep(4000);
				 NCP_SubContractorPage.Description(driver).sendKeys("test");
				 Thread.sleep(2000);
				 test.log(LogStatus.PASS, "Description passed successfully");
				 NCP_SubContractorPage.SaveContractorButton(driver).click();
				 Thread.sleep(2000);
				 test.log(LogStatus.PASS, "Save subcontractor button clicked successfully");
				 
				 driver.close();
				 launchBrowser("chrome");
				 //Email
				 HomePage.controlMenuHomeIcon(driver).click();
				 Thread.sleep(2000);
				 wb.windowScrollBy(0, 200);
					HomePage.controlMenuEmailIcon(driver).click();	
					test.log(LogStatus.PASS, "Email Icon at Home Page is clicked");
					Thread.sleep(3000); 
					wb.mouseover(HomePage.controlMenuEmailIcon(driver));
					Thread.sleep(2000);
					test.log(LogStatus.PASS,"Mouse over is performed on Email Icon in Side Panel at Home Page");
					wb.mouseMoveToElement(HomePage.HomeMenuEmail_Sent(driver));
					Thread.sleep(3000);
					test.log(LogStatus.PASS, "Sent Email icon is clicked at Email page");
					Thread.sleep(4000); 
					test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Email sent to")));
					
					EmailModule.SentEmail_Selectfirstvaluefromlist(driver).click();
					Thread.sleep(2000);
					driver.switchTo().frame(HomePage.EmailPreviewPanelFrame(driver));
					String str=EmailModule.SentEmail_Selectfirstvaluefromlist_ToField(driver).getText();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, str);
					System.out.println(str);
					Thread.sleep(2000);
					
					if(str.contains(Email_StringContains))
					{
						System.out.println("CP created from Contractor Portal, Email sent to correct recipient");
						test.log(LogStatus.PASS, str);
					}
					else
					{
						System.out.println("CP created from Contractor Portal, Email sent to incorrect recipient");
						test.log(LogStatus.FAIL, str);
					}
					
				 break;
			 }	
			 driver.switchTo().defaultContent();
			 Thread.sleep(3000);
		 }	
	}
	

//	@Test(priority=4)
	public void Program_EmailManagement_ExcludedEnrollmentConfirmedByAdministrator() throws Throwable
	{
		test.log(LogStatus.INFO, "========== Email Management ---Excluded Enrollment Confirmed by Administrator--- ==========");
		HomePage.controlMenuHomeIcon(driver).click();
		test.log(LogStatus.INFO, "Clicked On Home Icon");
				
		//Add New ContractorPackage
				test.log(LogStatus.INFO, "========== Add Contractor Package Section  ==========");		
				HomePage.controlMenuContractorPackage(driver).click();
				test.log(LogStatus.INFO, "Clicked on CP Module Icon");
				ContractorPackageModule.addIcon(driver).click();
				//js.executeScript("arguments[0].click();",ContractorPackageModule.addIcon(driver));
				test.log(LogStatus.INFO, "Clicked On Add Contractor Package Icon");
				Thread.sleep(2000);
				wb.getWindowIDs();
				driver.switchTo().window(wb.map.get("childID"));
				driver.manage().window().maximize();
				

				wb.waitForElemnet(AddContractor_Pkg_Page.selectProgram(driver));
				AddContractor_Pkg_Page.selectProgramSearchBox(driver).sendKeys(programName);
				
				wb.selectSingleValueFromList(AddContractor_Pkg_Page.selectProgramDropdownAutocomplete(driver), programName);
				System.out.println("Program Added Successfully");
				test.log(LogStatus.PASS, programName+" Program  added successfully");
				Thread.sleep(2500);

				AddContractor_Pkg_Page.selectProject(driver).click();
				AddContractor_Pkg_Page.selectProjectSearchBox(driver).sendKeys(projectName);
				wb.selectSingleValueFromList(AddContractor_Pkg_Page.selectProjectDropdownAutocomplete(driver), projectName);
				System.out.println("Project Added Successfully");
				test.log(LogStatus.PASS, projectName+ " Project added successfully");
				
				Thread.sleep(4000);
				AddContractor_Pkg_Page.selectEnrollmentType(driver).click();
				Thread.sleep(2000);
				AddContractor_Pkg_Page.selectEnrollmentTypeSearchBox(driver).sendKeys("Excluded Contractor");
				System.out.println("Enrollment Type Added Successfully");
				test.log(LogStatus.PASS, "Enrollment Type added successfully");
				wb.selectSingleValueFromList(AddContractor_Pkg_Page.selectEnrollmentTypeDropdownAutocomplete(driver), "Excluded Contractor");
				Thread.sleep(2000);
				
				//Select Contractor
				AddContractor_Pkg_Page.selectContractor(driver).sendKeys(ContractorName);
				Thread.sleep(2000);
				AddContractor_Pkg_Page.selectContractor(driver).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				test.log(LogStatus.INFO, "Contractor name selected successfully");
				
				Thread.sleep(3000);
				AddContractor_Pkg_Page.selectContactsearch(driver).click();
				Thread.sleep(3000);
				AddContractor_Pkg_Page.selectContactsearch(driver).sendKeys("Contractor contractor");
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Contact search added successfully");
				System.out.println("Contact search clicked");
				wb.selectSingleValueFromList(AddContractor_Pkg_Page.selectContactList(driver),"Contractor contractor");
				Thread.sleep(2000);
				
				//Trade
				AddContractor_Pkg_Page.TradeSearch(driver).click();
				Thread.sleep(4000);
				wb.selectSingleValueFromList(AddContractor_Pkg_Page.TradeDD(driver),"1234 | 1234-");
				Thread.sleep(2000);
				wb.windowScrollBy(0, 1500);
				AddContractor_Pkg_Page.btnNext(driver).click();
				Thread.sleep(2000);
				test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Email selection")));
				AddContractor_Pkg_Page.sendEmailSendAndCloseBtn(driver).click();
				Thread.sleep(4000);
				
				driver.switchTo().window(wb.map.get("parentID"));
				Thread.sleep(3000);
				System.out.println("Contractor Package Created Successfully");
				test.log(LogStatus.PASS, "Contractor Package Created successfully");
				
				driver.switchTo().frame(HomePage.ContractorPackagePreviewPanelFrame(driver));
				System.out.println("1");
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,2500)");
				ContractorPackageModule.InsuranceEnrollmentPagePriviewP(driver).click();
				System.out.println("2");
				Thread.sleep(2000);

				wb.SwitchtoChild1();
				Thread.sleep(2000);
		
				test.log(LogStatus.INFO, "switched to Insurance Enrollment form window");
				js.executeScript("window.scrollBy(0,1000)");
				Thread.sleep(3500);
				
			//	ContractorPackageModule.MarkAsConfirmed(driver).click();		
			//	Thread.sleep(2000);
			//	test.log(LogStatus.INFO, "Confirm Enrolled RadioButton clicked");
				
				AddContractor_Pkg_Insurance_Enrollment_Page.ContractValue(driver).sendKeys("1");
				Thread.sleep(2000);
				test.log(LogStatus.INFO, "ContractValue entered");
				AddContractor_Pkg_Insurance_Enrollment_Page.SelfPerformedContractValue(driver).sendKeys("1");
				Thread.sleep(2000);
				test.log(LogStatus.INFO, "SelfPerformedContractValue entered");	
				AddContractor_Pkg_Insurance_Enrollment_Page.EstimatedStartDate(driver).sendKeys("01/01/2021");
				Thread.sleep(2000);
				test.log(LogStatus.INFO, "EstimatedStartDate entered");	
				AddContractor_Pkg_Insurance_Enrollment_Page.ScopeofWorktextarea(driver).sendKeys("text");
				Thread.sleep(2000);
				test.log(LogStatus.INFO, "ScopeofWorktextarea entered");					
				
				js.executeScript("window.scrollBy(0,1000)");
				Thread.sleep(2000);
				AddContractor_Pkg_Insurance_Enrollment_Page.btnSaveAndContinue(driver).click();
				Thread.sleep(3000);
				js.executeScript("window.scrollBy(0,2500)");
				AddContractor_Pkg_SubContractorInfo.btnSaveAndContinue(driver).click();
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,2500)");
				Thread.sleep(2000);
				AddContractor_Pkg_Enrollment_Summary_Page.btnEnrollmentSummaryPageConfirmAndContinue(driver).click();
				Thread.sleep(3000);
				AddContractor_Pkg_Page.sendEmailSendAndCloseBtn(driver).click();
				Thread.sleep(4000);
				
				//driver.close();
				driver.switchTo().window(wb.map.get("parentID"));
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				//driver.switchTo().window(wb.map.get("parentID"));
				Thread.sleep(2000);
				
				//Email
				 HomePage.controlMenuHomeIcon(driver).click();
				 Thread.sleep(2000);
				 wb.windowScrollBy(0, 200);
					HomePage.controlMenuEmailIcon(driver).click();	
					test.log(LogStatus.PASS, "Email Icon at Home Page is clicked");
					Thread.sleep(3000); 
					wb.mouseover(HomePage.controlMenuEmailIcon(driver));
					Thread.sleep(2000);
					test.log(LogStatus.PASS,"Mouse over is performed on Email Icon in Side Panel at Home Page");
					wb.mouseMoveToElement(HomePage.HomeMenuEmail_Sent(driver));
					Thread.sleep(3000);
					test.log(LogStatus.PASS, "Sent Email icon is clicked at Email page");
					Thread.sleep(4000); 
					test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Email sent to")));
					
					EmailModule.SentEmail_Selectfirstvaluefromlist(driver).click();
					Thread.sleep(2000);
					driver.switchTo().frame(HomePage.EmailPreviewPanelFrame(driver));
					String str=EmailModule.SentEmail_Selectfirstvaluefromlist_ToField(driver).getText();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, str);
					System.out.println(str);
					Thread.sleep(2000);
					
					if(str.contains(Email_StringContains))
					{
						System.out.println("CP created from Contractor Portal, Email sent to correct recipient");
						test.log(LogStatus.PASS, str);
					}
					else
					{
						System.out.println("CP created from Contractor Portal, Email sent to incorrect recipient");
						test.log(LogStatus.FAIL, str);
					}
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
	}
	
	@Test(priority=5)
	public void Program_EmailManagement_Enrollment_Submitted_by_Contractor() throws Throwable
	{
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "========== Email Management ---Enrollment Submitted by Contractor--- ==========");
		// Thread.sleep(2000);
		 String BaseUrl=driver.getCurrentUrl();
		 NCP_GCLoginAction.logInNCP(driver);
		// Thread.sleep(2000);
		 
		 NCP_MyContractsPage.MyContracts_CPlist_FirstElement(driver).click();
		// Thread.sleep(2000);
		 int size1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).size();
		 for(int j=0;j<size1;j++)
		 {
			 String str1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).getText();
			 Thread.sleep(4000);
			 
			 if(str1.contains("Enrollment"))
			 {
				 NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).click();
				 Thread.sleep(4000);
				 //wb.windowScrollBy(0, 1000);
				 int size2=NCP_EnrollmentPage.ContractorPackage_EnrollmentPage_leftpanel(driver).size();
				 for(int k=0;k<size2;k++)
				 {
					Thread.sleep(1000);
					String str2=NCP_EnrollmentPage.ContractorPackage_EnrollmentPage_leftpanel(driver).get(k).getText();
					test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Program_Contractor_Portal_Options_Switch_NonCipCompliance")));
					if(str2.contains("Review Enrollment"))
					{									
						    NCP_EnrollmentPage.ContractorPackage_EnrollmentPage_leftpanel(driver).get(k).click();
							//wb.windowScrollBy(0, 1000);	
						    test.log(LogStatus.INFO, str2);
							NCP_EnrollmentPage.ReviewEnrollment_submitdigitalenrollment_button(driver).click();
							test.log(LogStatus.INFO, "Submit button clicked");
					}							
				 }
				 
				 driver.close();
				 launchBrowser("chrome");
				 //Email
				 HomePage.controlMenuHomeIcon(driver).click();
				 Thread.sleep(2000);
				 wb.windowScrollBy(0, 200);
					HomePage.controlMenuEmailIcon(driver).click();	
					test.log(LogStatus.PASS, "Email Icon at Home Page is clicked");
					Thread.sleep(3000); 
					wb.mouseover(HomePage.controlMenuEmailIcon(driver));
					Thread.sleep(2000);
					test.log(LogStatus.PASS,"Mouse over is performed on Email Icon in Side Panel at Home Page");
					wb.mouseMoveToElement(HomePage.HomeMenuEmail_Sent(driver));
					Thread.sleep(3000);
					test.log(LogStatus.PASS, "Sent Email icon is clicked at Email page");
					Thread.sleep(4000); 
					test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Email sent to")));
					
					EmailModule.SentEmail_Selectfirstvaluefromlist(driver).click();
					Thread.sleep(2000);
					driver.switchTo().frame(HomePage.EmailPreviewPanelFrame(driver));
					String str=EmailModule.SentEmail_Selectfirstvaluefromlist_ToField(driver).getText();
					Thread.sleep(2000);
					test.log(LogStatus.INFO, str);
					System.out.println(str);
					Thread.sleep(2000);
					
					if(str.contains(Email_StringContains))
					{
						System.out.println("CP created from Contractor Portal, Email sent to correct recipient");
						test.log(LogStatus.PASS, str);
					}
					else
					{
						System.out.println("CP created from Contractor Portal, Email sent to incorrect recipient");
						test.log(LogStatus.FAIL, str);
					}
					
				 break;
			 }	
			 driver.switchTo().defaultContent();
			 Thread.sleep(3000);
				 
			 }
		 }
	}
	
	

