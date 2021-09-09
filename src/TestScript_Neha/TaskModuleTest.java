package TestScript_Neha;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.FileUtils1;
import GenericLibrary.RandomClass;
import ObjectRepository.AddContractorPage;
import ObjectRepository.AddContractor_Pkg_Page;
import ObjectRepository.ContractorPackageModule;
import ObjectRepository.HomePage;
import ObjectRepository.ProgramModule;
import ObjectRepository.Task_Module_Page;

public class TaskModuleTest extends BaseClass{
	
	WebDriverCommonLib wb = new WebDriverCommonLib();
	String Subject = RandomClass.randomTaskSubject();
	String EmailSubjectId=RandomClass.randomTaskSubject();
	String Email ="neha@nourtek.com";
	String AssignedTo ="Parthiv Patel";
	String RelatedTo ="Parthiv Patel";
	String BeginDt = "06/03/2021";
	String EndDt = "06/03/2023";
	//String Status ="Completed";
	String Description_text = "This is description section";
	String Estimated_Days = "1";
	String Estimated_Hours = "2";
	String Actual_Days = "3";
	String Actual_Hours = "4";
	String Completed = "5";
	String AdvBeginDt ="01/01/2021";
	String AdvEndDt ="12/12/2023";
	String Program = "Goyal";

	//----------------------Add Functionality--------------------------------
	
	@Test
	public void taskmodule() throws Throwable
	{
		System.out.println("Task Module initiated");
		HomePage.controlMenuTask(driver).click();
		test.log(LogStatus.PASS, "Task module initiated");
		Thread.sleep(3000);
		Task_Module_Page.PlusBtn(driver).click();
		test.log(LogStatus.PASS, "Plus button clicked");
		Thread.sleep(3000);
		try {
			wb.getWindowIDs();
			driver.switchTo().window(wb.map.get("childID"));
			driver.manage().window().maximize();
			test.log(LogStatus.PASS, "switched to Add window at try block");
			System.out.println("In try");
			Thread.sleep(2000);
		}catch (Exception e) {
			test.log(LogStatus.PASS, "switched to Add window at  catch block");
			System.out.println("In catch");
			Thread.sleep(1000);
		}
		Task_Module_Page.Subject_field(driver).sendKeys(Subject);
		test.log(LogStatus.PASS, "Subject field entered with value");
		Thread.sleep(1000);
		Task_Module_Page.Assignedto_field(driver).sendKeys(AssignedTo);
		test.log(LogStatus.PASS, "Assignedto field entered");
		Thread.sleep(2000);
		Task_Module_Page.Assignedto_field(driver).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		Task_Module_Page.Relatedto_field(driver).sendKeys(RelatedTo);
		Thread.sleep(1000);
		Task_Module_Page.Relatedto_field(driver).sendKeys(Keys.ENTER);
		test.log(LogStatus.PASS, "Relatedto field entered");
		Thread.sleep(1000);
		Task_Module_Page.BeginDt(driver).sendKeys(BeginDt);
		Thread.sleep(2000);
		Task_Module_Page.BeginDt(driver).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Begin Dt eneterd");
		Task_Module_Page.EndDt(driver).sendKeys(EndDt);
		Task_Module_Page.EndDt(driver).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "End Dt eneterd");
		Task_Module_Page.Status_DD(driver,1);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Status selected from drop down");
		Task_Module_Page.Priority_DD(driver,2);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Priority selected from drop down");
		
		driver.switchTo().frame(Task_Module_Page.Description_iframe(driver));		
		Thread.sleep(2000);
		Task_Module_Page.Description_text(driver).sendKeys(Description_text);
		Thread.sleep(5000);
		test.log(LogStatus.PASS, Description_text);

		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		wb.Tick_CheckBox(Task_Module_Page.Checkbox_TaskDueDate(driver));
		Thread.sleep(2000);
		wb.TurnONSwitch(Task_Module_Page.Switch_task_estimate(driver));
		Thread.sleep(3000);
		
		wb.scrollToEndt();
		Thread.sleep(2000);
		Task_Module_Page.Estimated_Days_field(driver).sendKeys(Estimated_Days);
		Task_Module_Page.Estimated_Hours_field(driver).sendKeys(Estimated_Hours);
		Task_Module_Page.Actual_Days_field(driver).sendKeys(Actual_Days);
		Task_Module_Page.Actual_Hours_field(driver).sendKeys(Actual_Hours);
		Task_Module_Page.Completed_field(driver).sendKeys(Completed);
		Task_Module_Page.Saveclose_btn(driver).click();
		Thread.sleep(2000);
		
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
		
		//---------------------------Advance search functionality-----------------------
		
		System.out.println("Task Module initiated");
		HomePage.controlMenuTask(driver).click();
		test.log(LogStatus.PASS, "Task module initiated");
		Thread.sleep(3000);
		Task_Module_Page.AdvSearchBtn(driver).click();
		Thread.sleep(1000);
		Task_Module_Page.AdvSearch_BeginDate(driver).sendKeys(AdvBeginDt);
		Thread.sleep(2000);
		Task_Module_Page.AdvSearch_BeginDate(driver).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Advance Begin Dt eneterd");
		Task_Module_Page.AdvSearch_EndDate(driver).sendKeys(AdvEndDt);
		Task_Module_Page.AdvSearch_EndDate(driver).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Advance End Dt eneterd");
		Task_Module_Page.AdvSearch_SelectProgram(driver, Program);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Advance search Program selected", Program);	
		Task_Module_Page.SearchButton(driver).click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Advance search button clicked");
		
		List<WebElement> selTaskBD = Task_Module_Page.selectTaskFrmListBD(driver);
		System.out.println("List size is: "+selTaskBD.size());
		
		 List<WebElement> selTaskED = Task_Module_Page.selectTaskFrmListED(driver);
		 System.out.println("List size is: "+selTaskED.size());
		
		for(int i =0;i<selTaskBD.size();i++) {

			String str = selTaskBD.get(i).getText();
			String str1 = str.replaceAll("[^\\d.]+/", "");
			str1=str1.trim();
			str1=str.replace("Begin Date: ", "");
			System.out.println(str1);
			
			String str2 = selTaskED.get(i).getText();
			String str3 = str.replaceAll("[^\\d.]+/", "");
			str3=str3.trim();
			str3=str2.replace("End Date: ", "");
			System.out.println(str3);
			
			 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(str1);  
			 Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(AdvBeginDt);
			 Date date3=new SimpleDateFormat("dd/MM/yyyy").parse(AdvEndDt);
			 Date date4=new SimpleDateFormat("dd/MM/yyyy").parse(str3); 
			if(date1.after(date2) && date1.before(date3))
			{
				System.out.println("Begin date is in the range");
				test.log(LogStatus.PASS, "Begin date is in the range: "+date1);
			}
			else
			{
				System.out.println("Begin date is not in the range: "+date1);
				test.log(LogStatus.PASS, "Begin date is not in the range: "+date1);
			}
			
			if(date4.after(date2) && date4.before(date3))
			{
				System.out.println("End date is in the range");
				test.log(LogStatus.PASS, "End date is in the range: "+date4);
			}
			else
			{
				System.out.println("End date is not in the range: "+date4);
				test.log(LogStatus.PASS, "End date is not in the range: "+date4);
			}

			
		}
		test.log(LogStatus.PASS, test.addScreenCapture(FileUtils1.captureScreen(driver, "Advance search on the basis of date validation")));
		
		
	}

}
