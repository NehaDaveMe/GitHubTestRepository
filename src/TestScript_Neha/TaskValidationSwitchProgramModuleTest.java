//package TestScript_Neha;
//
//import java.io.IOException;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import CommonLibrary.WebDriverCommonLib;
//import GenericLibrary.BaseClass;
//import ObjectRepository.AddContractor_Pkg_Page;
//import ObjectRepository.AddProgram_General_Info_Page;
//import ObjectRepository.HomePage;
//import ObjectRepository.ProgramModule;
//import ObjectRepository.Task_Module_Page;
//
//public class TaskValidationSwitchProgramModuleTest extends BaseClass {
//	
//	WebDriverCommonLib wb = new WebDriverCommonLib();
//	String ProgramName="Goyal";
//	String ExpStatus="Status - Active";
//	String ContractorPkgName ="hafiz contractor";
//	String NonCipValue = "Non-CIP Compliance:";
//	/*
//	  @Test() 
//	  public void ProgramGeneralInfoSwitchStatus() throws Throwable 
//	  {
//	  test.log(LogStatus.INFO,"========== General Info Program Section Switches 'Switch Status'=========="); 
//	  HomePage.controlMenuHomeIcon(driver).click(); test.log(LogStatus.INFO,
//	  "Clicked On Home Icon"); HomePage.HomeMenuPrograms(driver).click();
//	  test.log(LogStatus.INFO, "Clicked On Programs Module Icon");
//	  Thread.sleep(2000);
//	  ProgramModule.programSearchEditBox(driver).sendKeys(ProgramName);
//	  ProgramModule.programSearchEditBox(driver).sendKeys(Keys.ENTER);
//	  test.log(LogStatus.INFO, "Edit buttom has been clicked"); Thread.sleep(3000);
//	  ProgramModule.programEditIcon(driver).click(); Thread.sleep(4000);
//	  wb.getWindowIDs(); driver.switchTo().window(wb.map.get("childID"));
//	  wb.TurnONSwitches(AddProgram_General_Info_Page.SwitchesGeneralInfo(driver));
//	  test.log(LogStatus.PASS,
//	  "All the switches of Program Module General Info Page is now ON for "
//	  +ProgramName);
//	  //wb.TurnOFFSwitches(AddProgram_General_Info_Page.SwitchesGeneralInfo(driver)
//	  
//	  
//	  Thread.sleep(5000); JavascriptExecutor js = (JavascriptExecutor) driver;
//	  js.executeScript("window.scrollBy(0,1000)");
//	  AddProgram_General_Info_Page.saveButton(driver).click(); Thread.sleep(3000);
//	  wb.getWindowIDs(); driver.switchTo().window(wb.map.get("parentID"));
//	  Thread.sleep(2000);
//	  
//	  driver.switchTo().frame(HomePage.ProgramPreviewPanelFrame(driver));
//	  Thread.sleep(2000); test.log(LogStatus.PASS, "Inside Preview Panel");
//	  wb.mouseover(HomePage.Statuscheck(driver)); Thread.sleep(3000); String
//	  ActStatus=HomePage.Statuscheck(driver).getAttribute("data-original-title");
//	  
//	  wb.Comparestatus(ActStatus, ExpStatus); test.log(LogStatus.INFO, "Status is"
//	  + ActStatus); Thread.sleep(2000);
//	  
//	  }
//	 */
//
//	@Test()
//	public void ProgramGeneralInfoSwitchNonCIPCompliance() throws Throwable
//	{
//		test.log(LogStatus.INFO, "========== General Info Program Section Switches 'Switch Non CIP Compliance'==========");
//		HomePage.controlMenuContractorPackage(driver).click();
//		test.log(LogStatus.INFO, "Clicked On Contractor Package Icon");
//		AddContractor_Pkg_Page.search_Bar(driver).sendKeys(ContractorPkgName);
//		AddContractor_Pkg_Page.search_Bar(driver).sendKeys(Keys.ENTER);
//		test.log(LogStatus.INFO, ContractorPkgName+" passed inside search box");
//		Thread.sleep(3000);
//		driver.switchTo().frame(HomePage.ContractorPackagePreviewPanelFrame(driver));
//		Thread.sleep(5000);
//
//		if(HomePage.EnrollmentListByText(driver, NonCipValue).isDisplayed())
//		{
//			test.log(LogStatus.PASS, "Non SIP compliance enabled in switch and available atPreview panel");
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Non SIP compliance in not at Preview panel");
//		}
//	
//		/*
//		 * String NonCipCompliance_check=HomePage.TrackCompliance(driver).getText();
//		 * if(NonCipCompliance_check==NonCipValue) { test.log(LogStatus.PASS,
//		 * "NonCipCompliance is present");
//		 * System.out.println("NonCip Compliance is present"); } else {
//		 * test.log(LogStatus.PASS, "NonCipCompliance is present");
//		 * System.out.println("Non cip compliance is not present"); }
//		 */
//		
//		
//	}
//		
//		
//	
//
//	
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
