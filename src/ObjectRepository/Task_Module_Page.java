package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//-----------POM file made by Neha ---------------------------
public class Task_Module_Page {

	public static WebElement element;
	public static List<WebElement> listelement;

	//----Task Module--------------------
	static String Tasks_Icon = "//span[@id='ctl00_ContentPlaceHolder1_spnTasks']//a[@id='ctl00_ContentPlaceHolder1_aTask']";
	//a[@href='../frmTask.aspx']//span[@class='icon']
	//li[@id='ctl00_ctrlMenu_liTask']
	static String PlusBtn = "//div[@class='leftButtonGroup']//i[@class='fa fa-plus']";
	static String EditBtn = "//i[@class='fa fa-pencil-square-o']";
	static String DeleteBtn = "//div[@class='leftButtonGroup']//i[@class='fa fa-trash-o']";
	static String TaskModule_Searchbar = "//input[@id='ctl00_ContentPlaceHolder1_cntrlTaskList_txtSearch']";
	static String TaskModule_RefreshBtn = "//div[@class='rightButtonGroup']//i[@class='fa fa-refresh']";

	public static WebElement Tasks_Icon(WebDriver driver) {

		element = driver.findElement(By.xpath(Tasks_Icon));
		return element;
	}

	public static WebElement PlusBtn(WebDriver driver) {

		element = driver.findElement(By.xpath(PlusBtn));
		return element;
	}

	public static WebElement EditBtn(WebDriver driver) {

		element = driver.findElement(By.xpath(EditBtn));
		return element;
	}

	public static WebElement DeleteBtn(WebDriver driver) {

		element = driver.findElement(By.xpath(DeleteBtn));
		return element;
	}

	public static WebElement TaskModule_Searchbar(WebDriver driver) {

		element = driver.findElement(By.xpath(TaskModule_Searchbar));
		return element;
	}

	public static WebElement TaskModule_RefreshBtn(WebDriver driver) {

		element = driver.findElement(By.xpath(TaskModule_RefreshBtn));
		return element;
	}

	//----------------------- Adavcne Search------------------------------------

	static String AdvSearchBtn = "//a[@data-original-title='Advanced Search']";
	static String AdvSearch_BeginDate = "//input[@id='ctl00_ContentPlaceHolder1_cntrlTaskList_startdatetimepicker']";
	static String AdvSearch_EndDate = "//input[@id='ctl00_ContentPlaceHolder1_cntrlTaskList_enddatetimepicker']";
	static String AdvSearch_SelectAdmin = "//select[@id='ctl00_ContentPlaceHolder1_cntrlTaskList_ddlNodeAdministrator']";
	static String AdvSearch_SelectProgram = "//select[@id='ctl00_ContentPlaceHolder1_cntrlTaskList_ddlProject']";
	static String AdvSearch_SelectProject = "//select[@id='ctl00_ContentPlaceHolder1_cntrlTaskList_ddlWorkSite']";
	static String SelectStatus_DropDown = "//div/a/span[@class='fltr']/i";
	static String SelectCategory = "//button[normalize-space()='Select Category']";
	static String SearBtn = "//div[@class='advancesearchGroup']/div/a";
	static String SearchButton = "//input[@id='btnAdvanceSearch']";
	static String ClsoeBtn = "//button[normalize-space()='Close']";
	static String Checkbox_taskDueDate = "";
	static String selectTaskFrmListBD = "//div[@class]//div[@class='statusType']/div[1]";
	static String selectTaskFrmListED = "//div[@class]//div[@class='statusType']/div[2]";

	public static List<WebElement> selectTaskFrmListBD(WebDriver driver) {
		listelement = driver.findElements(By.xpath(selectTaskFrmListBD));
		return listelement;
	}
	
	public static List<WebElement> selectTaskFrmListED(WebDriver driver) {
		listelement = driver.findElements(By.xpath(selectTaskFrmListED));
		return listelement;
	}
	
	public static WebElement AdvSearchBtn(WebDriver driver) {

		element = driver.findElement(By.xpath(AdvSearchBtn));
		return element;
	}

	public static WebElement AdvSearch_BeginDate(WebDriver driver) {

		element = driver.findElement(By.xpath(AdvSearch_BeginDate));
		return element;
	}

	public static WebElement AdvSearch_EndDate(WebDriver driver) {

		element = driver.findElement(By.xpath(AdvSearch_EndDate));
		return element;
	}

	public static WebElement AdvSearch_SelectAdmin(WebDriver driver) {

		element = driver.findElement(By.xpath(AdvSearch_SelectAdmin));
		return element;
	}
	
	public static WebElement AdvSearch_SelectProgram(WebDriver driver, String str) {
		element = driver.findElement(By.xpath(AdvSearch_SelectProgram));
		Select select = new Select(element);
		select.selectByVisibleText(str);
		return element;
	}

	public static WebElement AdvSearch_SelectProject(WebDriver driver) {

		element = driver.findElement(By.xpath(AdvSearch_SelectProject));
		return element;
	}

	public static WebElement SelectStatus_DropDown(WebDriver driver) {

		element = driver.findElement(By.xpath(SelectStatus_DropDown));
		return element;
	}

	public static WebElement SelectCategory(WebDriver driver) {

		element = driver.findElement(By.xpath(SelectCategory));
		return element;
	}

	public static WebElement SearBtn(WebDriver driver) {

		element = driver.findElement(By.xpath(SearBtn));
		return element;
	}
	
	public static WebElement SearchButton(WebDriver driver) {

		element = driver.findElement(By.xpath(SearchButton));
		return element;
	}

	public static WebElement ClsoeBtn(WebDriver driver) {

		element = driver.findElement(By.xpath(ClsoeBtn));
		return element;
	}

	static String SelectSortingExpression = "//select[@id='ctl00_ContentPlaceHolder1_cntrlTaskList_ddlSort']";

	public static WebElement SelectSortingExpression(WebDriver driver) {

		element = driver.findElement(By.xpath(SelectSortingExpression));
		return element;
	}
	
	
	static String PreviewPanelSubjectText ="//div[@class='title flft']";
	public static WebElement PreviewPanelSubjectText(WebDriver driver) {

		element = driver.findElement(By.xpath(PreviewPanelSubjectText));
		return element;
	}
	
	//-----------Task Module inside Add Button-----------------
	
	static String Subject_field = "//input[@id='cntrlTaskAddUpdate_txtTitle']";
	static String Assignedto_field = "//input[@id='token-input-cntrlTaskAddUpdate_txtAssignedTo']";
	static String Relatedto_field = "//input[@id='token-input-cntrlTaskAddUpdate_txtRelatedTo']";
	static String BeginDt = "//input[@id='cntrlTaskAddUpdate_startdatetimepicker']";
	static String EndDt = "//input[@id='cntrlTaskAddUpdate_enddatetimepicker']";
	static String Status_DD = "//select[@id='cntrlTaskAddUpdate_ddlStatus']";
	static String Priority_DD = "//select[@id='cntrlTaskAddUpdate_ddlPriority']";
	static String Description_iframe = "//iframe[@id='cntrlTaskAddUpdate_txtDesc_ifr']";
	static String Description_text = "//html//body[@data-id='cntrlTaskAddUpdate_txtDesc']";
	static String Saveclose_btn ="//input[@id='cntrlTaskAddUpdate_btnSaveandClose']";
	static String Checkbox_TaskDueDate = "//div[@id='uniform-UserList-2']//input[@name='UserList']/..";
	static String Switch_task_estimate = "//div[@id='uniform-cntrlTaskAddUpdate_chkTaskEstimateAccess']//div[@class='ios-ui-select' or 'ios-ui-select checked']";
	static String Estimated_Days_field = "//input[@id='cntrlTaskAddUpdate_txtEstimatedDays']";
	static String Actual_Days_field = "//input[@id='cntrlTaskAddUpdate_txtActualWorkingDays']";
	static String Estimated_Hours_field = "//input[@id='cntrlTaskAddUpdate_txtEstimtedHours']";
	static String Actual_Hours_field = "//input[@id='cntrlTaskAddUpdate_txtActualHours']";
	static String Completed_field = "//input[@id='cntrlTaskAddUpdate_txtCompleted']";
	static String SaveContinue_Btn = "//input[@id='cntrlTaskAddUpdate_btnSaveandClose']";
	
	public static WebElement Estimated_Days_field(WebDriver driver) {

		element = driver.findElement(By.xpath(Estimated_Days_field));
		return element;
	}
	
	public static WebElement Actual_Days_field(WebDriver driver) {

		element = driver.findElement(By.xpath(Actual_Days_field));
		return element;
	}
	
	public static WebElement Estimated_Hours_field(WebDriver driver) {

		element = driver.findElement(By.xpath(Estimated_Hours_field));
		return element;
	}
	
	public static WebElement Actual_Hours_field(WebDriver driver) {

		element = driver.findElement(By.xpath(Actual_Hours_field));
		return element;
	}
	
	public static WebElement Completed_field(WebDriver driver) {

		element = driver.findElement(By.xpath(Completed_field));
		return element;
	}
	
	public static WebElement SaveContinue_Btn(WebDriver driver) {

		element = driver.findElement(By.xpath(SaveContinue_Btn));
		return element;
	}

	
	public static WebElement Subject_field(WebDriver driver) {

		element = driver.findElement(By.xpath(Subject_field));
		return element;
	}

	public static WebElement Assignedto_field(WebDriver driver) {

		element = driver.findElement(By.xpath(Assignedto_field));
		return element;
	}
	
	public static WebElement Relatedto_field(WebDriver driver) {

		element = driver.findElement(By.xpath(Relatedto_field));
		return element;
	}
	
	public static WebElement BeginDt(WebDriver driver) {

		element = driver.findElement(By.xpath(BeginDt));
		return element;
	}
	
	public static WebElement EndDt(WebDriver driver) {

		element = driver.findElement(By.xpath(EndDt));
		return element;
	}
	
	public static WebElement Status_DD(WebDriver driver, int index) {
		element = driver.findElement(By.xpath(Status_DD));
		Select select = new Select(element);
		select.selectByIndex(index);
		return element;
	}
	
	public static WebElement Priority_DD(WebDriver driver, int index) {
		element = driver.findElement(By.xpath(Priority_DD));
		Select select = new Select(element);
		select.selectByIndex(index);
		return element;
	}
	
	public static WebElement Saveclose_btn(WebDriver driver) {

		element = driver.findElement(By.xpath(Saveclose_btn));
		return element;
	}
	
	public static WebElement Description_iframe(WebDriver driver) {

		element = driver.findElement(By.xpath(Description_iframe));
		return element;
	}
	
	public static WebElement Description_text(WebDriver driver) {

		element = driver.findElement(By.xpath(Description_text));
		return element;
	}
	
	public static WebElement Checkbox_TaskDueDate(WebDriver driver) {

		element = driver.findElement(By.xpath(Checkbox_TaskDueDate));
		return element;
	}
	
	public static WebElement Switch_task_estimate(WebDriver driver) {

		element = driver.findElement(By.xpath(Switch_task_estimate));
		return element;
	}


	
	
}
