/**
 * 
 */
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
import ModulerLibrary.NCP_GCLoginAction;
import ModulerLibrary.NCP_LoginAction;
import ModulerLibrary.NCP_SponsorLoginAction;
import ModulerLibrary.NCP_SubCLoginAction;
import ModulerLibrary.WPO_SelectContractorPkgAction;
import ObjectRepository.AddContractorPage;
import ObjectRepository.AddContractor_Pkg_Enrollment_Summary_Page;
import ObjectRepository.AddContractor_Pkg_GL_Umbrella_Coverage_Page;
import ObjectRepository.AddContractor_Pkg_Insurance_Enrollment_Page;
import ObjectRepository.AddContractor_Pkg_Page;
import ObjectRepository.AddProgramPage;
import ObjectRepository.AddProgram_Contractor_Portal_Options_Page;
import ObjectRepository.AddProgram_General_Info_Page;
import ObjectRepository.AddProject_General_Information_Page;
import ObjectRepository.ContractorPackageModule;
import ObjectRepository.HomePage;
import ObjectRepository.ProgramModule;
import ObjectRepository.ProjectModule;
import ObjectRepository.Task_Module_Page;
import ObjectRepository_NCP.NCP_EnrollmentPage;
import ObjectRepository_NCP.NCP_HomePage;
import ObjectRepository_NCP.NCP_LoginPage;
import ObjectRepository_NCP.NCP_MyContractsPage;
import ObjectRepository_NCP.NCP_HomePage;
import ObjectRepository_NCP.NCP_MyContractsPage;
import TestScript.ProjectAdvancedFilter_Test;

/**
 * @author NDave
 *
 */
public class TaskValidationSwitchProgramModuleContractorPortalOptionsTest extends BaseClass {
	
	WebDriverCommonLib wb = new WebDriverCommonLib();
	String ProgramName="Goyal";
	
	@Test(priority=1)
	public void Program_Contractor_Portal_Options_TurnOnorTurnOFFSwitches() throws Throwable 
	{		
	test.log(LogStatus.INFO, "========== Contractor Portal Option Program Section Switches 'Turn ON  or  turn OFF'==========");
	HomePage.controlMenuHomeIcon(driver).click();
	Thread.sleep(3000);
	test.log(LogStatus.INFO, "Clicked On Home Icon");
	HomePage.HomeMenuPrograms(driver).click();
	test.log(LogStatus.INFO, "Clicked On Programs Module Icon");
	Thread.sleep(2000);
	ProgramModule.programSearchEditBox(driver).sendKeys(ProgramName);
	ProgramModule.programSearchEditBox(driver).sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	test.log(LogStatus.INFO, "Edit buttom has been clicked");
	Thread.sleep(3000);
	ProgramModule.programEditIcon(driver).click();
	Thread.sleep(4000);
	wb.getWindowIDs();
	driver.switchTo().window(wb.map.get("childID"));
	AddProgramPage.addProgramContractorPortalOptionTab(driver).click();
	Thread.sleep(2000);
	wb.TurnONSwitches(AddProgram_Contractor_Portal_Options_Page.ActivateContractorPortalForThisProgram(driver));
	Thread.sleep(2000);
	wb.TurnONSwitches(AddProgram_Contractor_Portal_Options_Page.ContractorPortalOption_GC_SubC_Sponsor_allswitches(driver));
	test.log(LogStatus.PASS, "All the switches of Program Module Contractor Portal Option is now ON for " + ProgramName);
	// wb.TurnOFFSwitches(AddProgram_General_Info_Page.SwitchesGeneralInfo(driver)
	test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Program_Contractor_Portal_Options_TurnONSwitches")));
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	AddProgram_Contractor_Portal_Options_Page.contractorPortalSaveAndCloseButton(driver).click();
	Thread.sleep(3000);
	driver.switchTo().window(wb.map.get("parentID"));
	Thread.sleep(2000);
	}
	 
	 @Test(priority=2)
	public void Program_Contractor_Portal_Options_SponsorSwitches() throws Throwable 
	{
//Logic for Sponsor My Contract Switch
		 
		 String BaseUrl=driver.getCurrentUrl();
		 NCP_SponsorLoginAction.logInNCP(driver);
		 test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Program_Contractor_Portal_Options_Sponsor_MyContract")));
		 Thread.sleep(2000);
		 int size= NCP_HomePage.TopNavigationBar_Elements(driver).size();
		 
		 Boolean Flag= false;
		 Boolean Flag_Certificate= false;
		 Boolean Flag_ChangeOrder= false;
		 Boolean Flag_Close_Out= false;
		 Boolean Flag_Loss_control_and_safety= false;
		 
		 for(int i=0;i<size;i++)
		 {
			 String str=NCP_HomePage.TopNavigationBar_Elements(driver).get(i).getText();
			 Thread.sleep(1500);
			 
			 if(str.equals("My Contracts"))
			 {
				 Flag=true;
				 System.out.println("In if,My Contracts");
				 
//Logic for Sponsor Certificate switch				 
				 
				 NCP_HomePage.TopNavigationBar_Elements(driver).get(i).click();
				 Thread.sleep(2000);
				 
				 NCP_MyContractsPage.MyContracts_CPlist_FirstElement(driver).click();
				 Thread.sleep(2000);
				 test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Program_Contractor_Portal_Options_Switch_Certificate")));
				 int size1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).size();
				 for(int j=0;j<size1;j++)
				 {
					 String str1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).getText();
					 Thread.sleep(1500);
					 
					 if(str1.contains("CIP Certificate"))
					 {
						 System.out.println("CIP Certificate");
						 Flag_Certificate=true;
						 break;
					 }
					 else
					 {
					  Flag_Certificate=false;
					 }

				 }
				 if(Flag_Certificate==true)
				 {
					 test.log(LogStatus.PASS, "Switch Certificate is ON at Program Level");
				 }
				 else
				 {
					 test.log(LogStatus.FAIL, "Switch Certificate is OFF at Program Level");
				 }
				 
//Logic for Change Order switch					 
				 
				 size1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).size();
				 for(int j=0;j<size1;j++)
				 {
					 String str1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).getText();
					 Thread.sleep(1500);
					 
					 if(str1.contains("Change Order"))
					 {
						 System.out.println("Change Order");
						 Flag_ChangeOrder=true;
						 break;
					 }
					 else
					 {
						 Flag_ChangeOrder=false;
					 }

				 }
				 if(Flag_ChangeOrder==true)
				 {
					 test.log(LogStatus.PASS, "Switch Change Order is ON at Program Level");
				 }
				 else
				 {
					 test.log(LogStatus.FAIL, "Switch Change Order is OFF at Program Level");
				 }
				 
//Logic for Loss control and safety switch					 
				 
				 size1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).size();
				 for(int j=0;j<size1;j++)
				 {
					 String str1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).getText();
					 Thread.sleep(1500);
					 
					 if(str1.contains("Safety Observation(s)"))
					 {
						 System.out.println("Safety Observation(s)");
						 Flag_Loss_control_and_safety=true;
						 break;
					 }
					 else
					 {
						 Flag_Loss_control_and_safety=false;
					 }

				 }
				 if(Flag_Loss_control_and_safety==true)
				 {
					 test.log(LogStatus.PASS, "Switch Loss control and safety is ON at Program Level");
				 }
				 else
				 {
					 test.log(LogStatus.FAIL, "Switch Loss control and safety is OFF at Program Level");
				 }

//Logic for Close Out switch		
				 size1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).size();
				 for(int j=0;j<size1;j++)
				 {
					 Thread.sleep(1000);
					 String str1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).getText();
					 					 
					 if(str1.contains("Closeout"))
					 {
						 System.out.println("Closeout");
						 Flag_Close_Out=true;
						 break;
					 }
					 else
					 {
						 Flag_Close_Out=false;
					 }

				 }
				 if(Flag_Close_Out==true)
				 {
					 test.log(LogStatus.PASS, "Switch Close Out is ON at Program Level");
				 }
				 else
				 {
					 test.log(LogStatus.FAIL, "Switch Close Out is OFF at Program Level");
				 }
				 
				 break;
			 }
			 else
			 {
				 Flag= false;
			 }

		 }
		 
		 if(Flag==true)
		 {
			 test.log(LogStatus.PASS, "Switch My Contracts is ON at Program Level");
			 	 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Switch My Contracts is OFF at Program Level, and dependent switches Certificate,Change Orders,Close Out,Loss control & safety cannot be validated");
		 }
	 
		 
	}
	 
	 @Test(priority=3)
	 public void Program_Contractor_Portal_Options_GC_Switches() throws Throwable 
		{
//Logic for GC My Contract Switch
			 
			 String BaseUrl=driver.getCurrentUrl();
			 NCP_GCLoginAction.logInNCP(driver);
			 test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Program_Contractor_Portal_Options_GC_MyContract")));
			 Thread.sleep(2000);
			 int size= NCP_HomePage.TopNavigationBar_Elements(driver).size();
			 
			 Boolean Flag= false;
			 Boolean Flag_Certificate= false;
			 Boolean Flag_ChangeOrder= false;
			 Boolean Flag_Close_Out= false;
			 Boolean Flag_Loss_control_and_safety= false;
			 Boolean Flag_MyPolicyInfo= false;
			 
			 for(int i=0;i<size;i++)
			 {
				 String str=NCP_HomePage.TopNavigationBar_Elements(driver).get(i).getText();
				 Thread.sleep(1500);
				 
				 if(str.equals("My Contracts"))
				 {
					 Flag=true;
					 System.out.println("In if,My Contracts");
					 
//Logic for GC Sponsor Certificate switch				 
					 
					 NCP_HomePage.TopNavigationBar_Elements(driver).get(i).click();
					 Thread.sleep(2000);
					 
					 NCP_MyContractsPage.MyContracts_CPlist_FirstElement(driver).click();
					 Thread.sleep(2000);
					 test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Program_Contractor_Portal_Options_Switch_Certificate")));
					 int size1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).size();
					 for(int j=0;j<size1;j++)
					 {
						 String str1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).getText();
						 Thread.sleep(1500);
						 
						 if(str1.contains("CIP Certificate"))
						 {
							 System.out.println("CIP Certificate");
							 Flag_Certificate=true;
							 break;
						 }
						 else
						 {
						  Flag_Certificate=false;
						 }

					 }
					 if(Flag_Certificate==true)
					 {
						 test.log(LogStatus.PASS, "Switch Certificate is ON at Program Level");
					 }
					 else
					 {
						 test.log(LogStatus.FAIL, "Switch Certificate is OFF at Program Level");
					 }
					 
//Logic for GC Change Order switch					 
					 
					 size1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).size();
					 for(int j=0;j<size1;j++)
					 {
						 String str1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).getText();
						 Thread.sleep(1500);
						 
						 if(str1.contains("Change Order"))
						 {
							 System.out.println("Change Order");
							 Flag_ChangeOrder=true;
							 break;
						 }
						 else
						 {
							 Flag_ChangeOrder=false;
						 }

					 }
					 if(Flag_ChangeOrder==true)
					 {
						 test.log(LogStatus.PASS, "Switch Change Order is ON at Program Level");
					 }
					 else
					 {
						 test.log(LogStatus.FAIL, "Switch Change Order is OFF at Program Level");
					 }
					 
//Logic for GC Loss control and safety switch					 
					 
					 size1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).size();
					 for(int j=0;j<size1;j++)
					 {
						 String str1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).getText();
						 Thread.sleep(1500);
						 
						 if(str1.contains("Safety Observation(s)"))
						 {
							 System.out.println("Safety Observation(s)");
							 Flag_Loss_control_and_safety=true;
							 break;
						 }
						 else
						 {
							 Flag_Loss_control_and_safety=false;
						 }

					 }
					 if(Flag_Loss_control_and_safety==true)
					 {
						 test.log(LogStatus.PASS, "Switch Loss control and safety is ON at Program Level");
					 }
					 else
					 {
						 test.log(LogStatus.FAIL, "Switch Loss control and safety is OFF at Program Level");
					 }

//Logic for GC Close Out switch		
					 size1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).size();
					 for(int j=0;j<size1;j++)
					 {
						 Thread.sleep(1000);
						 String str1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).getText();
						 					 
						 if(str1.contains("Closeout"))
						 {
							 System.out.println("Closeout");
							 Flag_Close_Out=true;
							 break;
						 }
						 else
						 {
							 Flag_Close_Out=false;
						 }

					 }
					 if(Flag_Close_Out==true)
					 {
						 test.log(LogStatus.PASS, "Switch Close Out is ON at Program Level");
					 }
					 else
					 {
						 test.log(LogStatus.FAIL, "Switch Close Out is OFF at Program Level");
					 }
					 
// Logic for GC Non Cip Compliance	
					 
					 size1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).size();
					 for(int j=0;j<size1;j++)
					 {
						 Thread.sleep(1000);
						 String str1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).getText();
						 					 
						 if(str1.contains("Enrollment"))
						 {
							 System.out.println("Enrollment");

							 NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).click();
							 Thread.sleep(2000);
							 
							 int size2=NCP_EnrollmentPage.ContractorPackage_EnrollmentPage_leftpanel(driver).size();
							 for(int k=0;k<size2;k++)
							 {
								Thread.sleep(1000);
								String str2=NCP_EnrollmentPage.ContractorPackage_EnrollmentPage_leftpanel(driver).get(k).getText();
								test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Program_Contractor_Portal_Options_Switch_NonCipCompliance")));
								if(str2.contains("My Policy Information"))
								{									
									Flag_MyPolicyInfo= true;									
								}							
							 }
							 
							 if(Flag_MyPolicyInfo==true)
							 {
								 test.log(LogStatus.PASS, "Switch non Cip compliance is ON at Program Level");
							 }
							 else
							 {
								 test.log(LogStatus.FAIL, "Switch non Cip compliance is OFF at Program Level");
							 }
							 
							 break;
						 }
						 else
						 {
							 test.log(LogStatus.INFO, "Enrollment is not available");
						 }

					 }					 
					 break;
				 }
				 else
				 {
					 Flag= false;
				 }

			 }
			 
			 if(Flag==true)
			 {
				 test.log(LogStatus.PASS, "Switch My Contracts is ON at Program Level");
				 	 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Switch My Contracts is OFF at Program Level, and dependent switches Certificate,Change Orders,Close Out,Loss control & safety, Non cip compliance cannot be validated");
			 }
		 		 
			 
			 
		}
	 
	 @Test(priority=4)
	 public void Program_Contractor_Portal_Options_SubC_Switches() throws Throwable 
		{
//Logic for SubC My Contract Switch
			 
			 String BaseUrl=driver.getCurrentUrl();
			 NCP_SubCLoginAction.logInNCP(driver);
			 test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Program_Contractor_Portal_Options_SubC_MyContract")));
			 Thread.sleep(2000);
			 int size= NCP_HomePage.TopNavigationBar_Elements(driver).size();
			 
			 Boolean Flag= false;
			 Boolean Flag_Certificate= false;
			 Boolean Flag_ChangeOrder= false;
			 Boolean Flag_Close_Out= false;
			 Boolean Flag_Loss_control_and_safety= false;
			 Boolean Flag_MyPolicyInfo= false;
			 Boolean Flag_Enrollment= false;
			 
			 for(int i=0;i<size;i++)
			 {
				 String str=NCP_HomePage.TopNavigationBar_Elements(driver).get(i).getText();
				 Thread.sleep(1500);
				 
				 if(str.equals("My Contracts"))
				 {
					 Flag=true;
					 System.out.println("In if,My Contracts");
					 
//Logic for SubC Certificate switch				 
					 
					 NCP_HomePage.TopNavigationBar_Elements(driver).get(i).click();
					 Thread.sleep(2000);
					 
					 NCP_MyContractsPage.MyContracts_CPlist_FirstElement(driver).click();
					 Thread.sleep(2000);
					 test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Program_Contractor_Portal_Options_Switch_Certificate")));
					 int size1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).size();
					 for(int j=0;j<size1;j++)
					 {
						 String str1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).getText();
						 Thread.sleep(1500);
						 
						 if(str1.contains("CIP Certificate"))
						 {
							 System.out.println("CIP Certificate");
							 Flag_Certificate=true;
							 break;
						 }
						 else
						 {
						  Flag_Certificate=false;
						 }

					 }
					 if(Flag_Certificate==true)
					 {
						 test.log(LogStatus.PASS, "Switch Certificate is ON at Program Level");
					 }
					 else
					 {
						 test.log(LogStatus.FAIL, "Switch Certificate is OFF at Program Level");
					 }
					 
//Logic SubC for Change Order switch					 
					 
					 size1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).size();
					 for(int j=0;j<size1;j++)
					 {
						 String str1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).getText();
						 Thread.sleep(1500);
						 
						 if(str1.contains("Change Order"))
						 {
							 System.out.println("Change Order");
							 Flag_ChangeOrder=true;
							 break;
						 }
						 else
						 {
							 Flag_ChangeOrder=false;
						 }

					 }
					 if(Flag_ChangeOrder==true)
					 {
						 test.log(LogStatus.PASS, "Switch Change Order is ON at Program Level");
					 }
					 else
					 {
						 test.log(LogStatus.FAIL, "Switch Change Order is OFF at Program Level");
					 }
					 
//Logic for SubC Loss control and safety switch					 
					 
					 size1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).size();
					 for(int j=0;j<size1;j++)
					 {
						 String str1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).getText();
						 Thread.sleep(1500);
						 
						 if(str1.contains("Safety Observation(s)"))
						 {
							 System.out.println("Safety Observation(s)");
							 Flag_Loss_control_and_safety=true;
							 break;
						 }
						 else
						 {
							 Flag_Loss_control_and_safety=false;
						 }

					 }
					 if(Flag_Loss_control_and_safety==true)
					 {
						 test.log(LogStatus.PASS, "Switch Loss control and safety is ON at Program Level");
					 }
					 else
					 {
						 test.log(LogStatus.FAIL, "Switch Loss control and safety is OFF at Program Level");
					 }

//Logic for SubC Close Out switch		
					 size1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).size();
					 for(int j=0;j<size1;j++)
					 {
						 Thread.sleep(1000);
						 String str1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).getText();
						 					 
						 if(str1.contains("Closeout"))
						 {
							 System.out.println("Closeout");
							 Flag_Close_Out=true;
							 break;
						 }
						 else
						 {
							 Flag_Close_Out=false;
						 }

					 }
					 if(Flag_Close_Out==true)
					 {
						 test.log(LogStatus.PASS, "Switch Close Out is ON at Program Level");
					 }
					 else
					 {
						 test.log(LogStatus.FAIL, "Switch Close Out is OFF at Program Level");
					 }
					 
// Logic for Non Cip Compliance	
					 size1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).size();
					 for(int j=0;j<size1;j++)
					 {
						 Thread.sleep(1000);
						 String str1=NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).getText();
						 					 
						 if(str1.contains("Enrollment"))
						 {
							 System.out.println("Enrollment");

							 NCP_MyContractsPage.MyContracts_CPlist_contractActivities(driver).get(j).click();
							 Thread.sleep(2000);
							 
							 int size2=NCP_EnrollmentPage.ContractorPackage_EnrollmentPage_leftpanel(driver).size();
							 for(int k=0;k<size2;k++)
							 {
								Thread.sleep(1000);
								String str2=NCP_EnrollmentPage.ContractorPackage_EnrollmentPage_leftpanel(driver).get(k).getText();
								test.log(LogStatus.INFO, test.addScreenCapture(FileUtils1.captureScreen(driver, "Program_Contractor_Portal_Options_Switch_NonCipCompliance")));
								if(str2.contains("My Policy Information"))
								{									
									Flag_MyPolicyInfo= true;									
								}							
							 }
							 
							 if(Flag_MyPolicyInfo==true)
							 {
								 test.log(LogStatus.PASS, "Switch non Cip compliance is ON at Program Level");
							 }
							 else
							 {
								 test.log(LogStatus.FAIL, "Switch non Cip compliance is OFF at Program Level");
							 }
							 
							 break;
						 }
						 else
						 {
							 test.log(LogStatus.INFO, "Enrollment is not available");
						 }

					 }					 
					 break;
				 }
				 else
				 {
					 Flag= false;
				 }

			 }
			 
			 if(Flag==true)
			 {
				 test.log(LogStatus.PASS, "Switch My Contracts is ON at Program Level");
				 	 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Switch My Contracts is OFF at Program Level, and dependent switches Certificate,Change Orders,Close Out,Loss control & safety, Non cip compliance cannot be validated");
			 }
		 		 
			 
		}

}
