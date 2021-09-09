package TestScript_Neha;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.FileUtils1;
import GenericLibrary.RandomClass;
import ObjectRepository.ContractorPackageModule;
import ObjectRepository.HomePage;
import ObjectRepository.Task_Module_Page;

public class TaskValidationPreBidCPTest extends BaseClass{
	
	WebDriverCommonLib wb = new WebDriverCommonLib();
	String EmailSubjectId=RandomClass.randomTaskSubject();
	String AssignedTo="test test";
	String Stdate="05/31/2021";
	String Enddate="05/31/2023";
	String msg="I am Message Body";
	String Email ="neha@nourtek.com";
	String EmailByName ="neha";
	
	
	@Test
	public void validateContractorPackage() throws Throwable
	{
		Thread.sleep(2000);
		HomePage.PreBidContractorPackageIcon(driver).click();
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Clicked On Control Menu Pre bid Contractor Package Icon");
		driver.switchTo().frame(0);
		ContractorPackageModule.TaskIconActivityPanel(driver).click();
		test.log(LogStatus.PASS, "Clicked on Pre bid Contractor Package Activity Panel Task Icon ");
		Thread.sleep(2000);
		
		ContractorPackageModule.TxtSubject(driver).sendKeys(EmailSubjectId);
		test.log(LogStatus.PASS, "Text Inserted for Subject ");
		
		ContractorPackageModule.AssignedTo(driver).click();
		Thread.sleep(2000);
		ContractorPackageModule.AssignedTo(driver).sendKeys(AssignedTo);
		Thread.sleep(2000);
		ContractorPackageModule.AssignedTo(driver).sendKeys(Keys.DOWN);
		ContractorPackageModule.AssignedTo(driver).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Assigned to selected");

		ContractorPackageModule.StartDate(driver).sendKeys(Stdate);
		ContractorPackageModule.StartDate(driver).click();
		test.log(LogStatus.PASS, "start date entered");
		
		ContractorPackageModule.EndDate(driver).sendKeys(Enddate);
		ContractorPackageModule.EndDate(driver).click();
		test.log(LogStatus.PASS, "End date entered");
		
		Thread.sleep(4000);
		wb.selectSingleValueFromList(ContractorPackageModule.selectDropDownPriority(driver), "Normal");
		Thread.sleep(4000);
		
		Thread.sleep(4000);
		wb.selectSingleValueFromList(ContractorPackageModule.selectDropDownStatus(driver), "Not Started");
		Thread.sleep(8000);
		
		ContractorPackageModule.Message(driver).sendKeys(msg);
		test.log(LogStatus.PASS, "Message entered");
		 			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		ContractorPackageModule.Submitbutton(driver).click();
		test.log(LogStatus.PASS, "Submit button clicked");
		Thread.sleep(6000);
		
		try {
			wb.getWindowIDs();
			driver.switchTo().window(wb.map.get("childID"));
			driver.manage().window().maximize();
			test.log(LogStatus.PASS, "switched to EMail window at try block");
			System.out.println("In try");
			Thread.sleep(1000);
		}catch (Exception e) {
			test.log(LogStatus.PASS, "switched to EMail window at  catch block");
			System.out.println("In catch");
			Thread.sleep(1000);
		}
		
		Thread.sleep(2000);
		ContractorPackageModule.To_EmailFeild(driver).sendKeys(Email);
		Thread.sleep(2000);
		ContractorPackageModule.To_EmailFeild(driver).sendKeys(Keys.ENTER);
		test.log(LogStatus.PASS, "Email to send is enetered as" + Email);
		Thread.sleep(2000);
		
		ContractorPackageModule.SendandCloseBtn(driver).click();
		test.log(LogStatus.PASS, "Send and close button is clicked at Email Management Page");
		Thread.sleep(4000);
		
		driver.switchTo().window(wb.map.get("parentID")); 
		Thread.sleep(4000);
		HomePage.controlMenuHomeIcon(driver).click(); 
		Thread.sleep(4000);
		
		Thread.sleep(4000); 
		HomePage.controlMenuEmailIcon(driver).click();
		test.log(LogStatus.PASS, "Email Icon at Home Page is clicked");
		Thread.sleep(3000); 
		wb.mouseover(HomePage.controlMenuEmailIcon(driver));
		test.log(LogStatus.PASS,"Mouse over is performed on Email Icon in Side Panel at Home Page");
		wb.mouseMoveToElement(HomePage.HomeMenuEmail_Sent(driver));
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Sent Email icon is clicked at Email page");
		Thread.sleep(4000); 
		
		HomePage.SearchEmailFeild(driver).sendKeys(Email);
		HomePage.SearchEmailFeild(driver).sendKeys(Keys.ENTER);
		test.log(LogStatus.PASS, "Email has been entered in the field and clicked search");
		Thread.sleep(4000);
		
		driver.switchTo().frame(HomePage.EmailPreviewPanelFrame(driver));
		Thread.sleep(2000);
		
		String EmailToText = HomePage.EmailPreviewPanelToFeild(driver).getText();
		if(EmailToText.contains(EmailSubjectId)) {
			test.log(LogStatus.PASS, "Email is sent successfully");
		}else
		{
			test.log(LogStatus.FAIL, "Email is not sent and not displayed");
		}
		Thread.sleep(5000);
		
		driver.switchTo().window(wb.map.get("parentID")); 
		Thread.sleep(4000);
		HomePage.controlMenuHomeIcon(driver).click(); 
		Thread.sleep(4000);
		HomePage.controlMenuTask(driver).click();
		test.log(LogStatus.PASS, "Task icon is clicked");
		Thread.sleep(4000);
		Task_Module_Page.TaskModule_Searchbar(driver).sendKeys(EmailSubjectId);
		test.log(LogStatus.PASS, "task Module is seached with Neha Task");
		Thread.sleep(5000);
		Task_Module_Page.SearBtn(driver).click();
		test.log(LogStatus.PASS, "task Module btn at task search bar clicked");
		Thread.sleep(3000);
		driver.switchTo().frame(HomePage.EmailPreviewPanelFrame(driver));
		WebElement ele= Task_Module_Page.PreviewPanelSubjectText(driver);
		String Subjecttext = ele.getText();
		System.out.println(Subjecttext + "Is the subject");
		if(Subjecttext.contains(EmailSubjectId)) {
			test.log(LogStatus.PASS, "Subject Task is Matched");
		}else {
			test.log(LogStatus.FAIL, "Subject Task is not  Matched");
		}
		driver.switchTo().defaultContent();
		test.log(LogStatus.PASS, test.addScreenCapture(FileUtils1.captureScreen(driver, "Email Sent Verify after add Task")));
			
	}
	

}
