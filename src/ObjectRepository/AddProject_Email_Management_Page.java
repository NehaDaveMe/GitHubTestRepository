package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProject_Email_Management_Page {
	private static WebElement element;
	private static List<WebElement> listElement;
	
	static String saveAndContinueButton = "//input[@id='cntrWorkSiteAddUpdateEmail_btnNextGeneralInfomation']"; //input[@id='cntrWorkClassAddUpdate_btnSaveandClose']"; //input[@value='Save and Continue']";
	static String saveAndCloseButton = "//input[@value='Save and Close']";
	static String backButton = "//input[@value='Back']";
	static String closeButton = "//button[@class='btn']";
	static String projectLevelEmailManagementSwitch ="//div[@id='uniform-cntrWorkSiteAddUpdateEmail_chkWorksiteEmailAccess']//div[@class='inner']";
	
	public static WebElement projectLevelEmailManagementSwitch(WebDriver driver) {
		element = driver.findElement(By.xpath(projectLevelEmailManagementSwitch));
		return element;
	}
	
	public static WebElement saveAndContinueButton(WebDriver driver) {
		element = driver.findElement(By.xpath(saveAndContinueButton));
		return element;
	}

	public static WebElement saveAndCloseButton(WebDriver driver) {
		element = driver.findElement(By.xpath(saveAndCloseButton));
		return element;
	}

	public static WebElement backButton(WebDriver driver) {
		element = driver.findElement(By.xpath(backButton));
		return element;
	}

	public static WebElement closeButton(WebDriver driver) {
		element = driver.findElement(By.xpath(closeButton));
		return element;
	}
	
	
	//------------------------Neha start--------------------------------
	
	static String ContractorPackageIsCreatedFirstTime = "//tr/td//div[contains(text(),'Contractor Package is Created First Time')] [not(contains(text(),'Contractor Package is Created First Time - Excluded Contractor'))]/../../../td//div/span";
	static String AdditionalCPCreated = "//tr/td//div[contains(text(),'Additional Contractor Package Created')]/../../../td//div/span";
	static String AdditionalCPCreated_SubC_chkbox = "//div/span/input[@id='cntrWorkSiteAddUpdateEmail_dgEmails_ctl01_chkSubContract']";
	static String AdditionalCPCreated_GC_chkbox = "//div/span/input[@id='cntrWorkSiteAddUpdateEmail_dgEmails_ctl01_chkGeneral']";
	static String ContractorPackageIsCreatedFirstTime_GC_chkbox = "//div/span/input[@id='cntrWorkSiteAddUpdateEmail_dgEmails_ctl00_chkGeneral']";
	static String ContractorPackageIsCreatedFirstTime_SubC_chkbox = "//div/span/input[@id='cntrWorkSiteAddUpdateEmail_dgEmails_ctl00_chkSubContract']";
	
	static String ContractorPackagecreatedfromContractorPortal = "//tr/td//div[contains(text(),'Contractor Package created from the Contractor Portal')]/../../../td//div/span";
	public static List<WebElement> ContractorPackagecreatedfromContractorPortal(WebDriver driver) {
		listElement = driver.findElements(By.xpath(ContractorPackagecreatedfromContractorPortal));
		return listElement;
	}
	
	static String EnrollmentsubmittedByContractor = "//tr/td//div[contains(text(),'Enrollment Submitted by Contractor')]/../../../td//div/span";
	public static List<WebElement> EnrollmentsubmittedByContractor(WebDriver driver) {
		listElement = driver.findElements(By.xpath(EnrollmentsubmittedByContractor));
		return listElement;
	}
	static String ContractorPackagecreatedfromContractorPortal_GC_chkbox = "//div/span/input[@id='cntrWorkSiteAddUpdateEmail_dgEmails_ctl02_chkGeneral']";
	public static WebElement ContractorPackagecreatedfromContractorPortal_GC_chkbox(WebDriver driver) {
		element = driver.findElement(By.xpath(ContractorPackagecreatedfromContractorPortal_GC_chkbox));
		return element;
	}
	
	static String ContractorPackagecreatedfromContractorPortal_SubC_chkbox = "//div/span/input[@id='cntrWorkSiteAddUpdateEmail_dgEmails_ctl02_chkSubContract']";
	public static WebElement ContractorPackagecreatedfromContractorPortal_SubC_chkbox(WebDriver driver) {
		element = driver.findElement(By.xpath(ContractorPackagecreatedfromContractorPortal_SubC_chkbox));
		return element;
	}
	
	static String ExcludedEnrollmentConfirmedbyAdministrator = "//tr/td//div[contains(text(),'Excluded Enrollment Confirmed by Administrator')]/../../../td//div/span";
	public static List<WebElement> ExcludedEnrollmentConfirmedbyAdministrator(WebDriver driver) {
		listElement = driver.findElements(By.xpath(ExcludedEnrollmentConfirmedbyAdministrator));
		return listElement;
	}
	static String ExcludedEnrollmentConfirmedbyAdministrator_GC_chkbox = "//div/span/input[@id='cntrWorkSiteAddUpdateEmail_dgEmails_ctl03_chkGeneral']";
	public static WebElement ExcludedEnrollmentConfirmedbyAdministrator_GC_chkbox(WebDriver driver) {
		element = driver.findElement(By.xpath(ExcludedEnrollmentConfirmedbyAdministrator_GC_chkbox));
		return element;
	}
	
	static String ExcludedEnrollmentConfirmedbyAdministrator_SubC_chkbox = "//div/span/input[@id='cntrWorkSiteAddUpdateEmail_dgEmails_ctl03_chkSubContract']";
	public static WebElement ExcludedEnrollmentConfirmedbyAdministrator_SubC_chkbox(WebDriver driver) {
		element = driver.findElement(By.xpath(ExcludedEnrollmentConfirmedbyAdministrator_SubC_chkbox));
		return element;
	}
	
	static String EnrollmentSubmittedByContractor_GC_chkbox = "//div/span/input[@id='cntrWorkSiteAddUpdateEmail_dgEmails_ctl04_chkGeneral']";
	public static WebElement EnrollmentSubmittedByContractor_GC_chkbox(WebDriver driver) {
		element = driver.findElement(By.xpath(EnrollmentSubmittedByContractor_GC_chkbox));
		return element;
	}
	
	static String EnrollmentSubmittedByContractor_SubC_chkbox = "//div/span/input[@id='cntrWorkSiteAddUpdateEmail_dgEmails_ctl04_chkSubContract']";
	public static WebElement EnrollmentSubmittedByContractor_SubC_chkbox(WebDriver driver) {
		element = driver.findElement(By.xpath(EnrollmentSubmittedByContractor_SubC_chkbox));
		return element;
	}

	
	
	
	public static List<WebElement> ContractorPackageIsCreatedFirstTime(WebDriver driver) {
		listElement = driver.findElements(By.xpath(ContractorPackageIsCreatedFirstTime));
		return listElement;
	}
	public static WebElement ContractorPackageIsCreatedFirstTime_GC_chkbox(WebDriver driver) {
		element = driver.findElement(By.xpath(ContractorPackageIsCreatedFirstTime_GC_chkbox));
		return element;
	}
	
	public static WebElement ContractorPackageIsCreatedFirstTime_SubC_chkbox(WebDriver driver) {
		element = driver.findElement(By.xpath(ContractorPackageIsCreatedFirstTime_SubC_chkbox));
		return element;
	}

	public static List<WebElement> AdditionalCPCreated(WebDriver driver) {
		listElement = driver.findElements(By.xpath(AdditionalCPCreated));
		return listElement;
	}
	
	public static WebElement AdditionalCPCreated_SubC_chkbox(WebDriver driver) {
		element = driver.findElement(By.xpath(AdditionalCPCreated_SubC_chkbox));
		return element;
	}
	
	public static WebElement AdditionalCPCreated_GC_chkbox(WebDriver driver) {
		element = driver.findElement(By.xpath(AdditionalCPCreated_GC_chkbox));
		return element;
	}


	
	//-----------------------Neha End-----------------------------------
}
