package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Report_ContractorPayrollManHoursAndLaborRateOld 
{
	
	private static WebElement element;
	private static List<WebElement> listElement;
	
	static String btnAddFootnote="//input[@id='btnaddfootnote']";
	static String textAreaFootnote="//textarea[@id='txtFootnote']";
	static String btnFootnoteCancel="//a[@class='btn flft']";
	static String btnFootnoteClear="//input[@id='btnClearFootnote']";
	static String btnFootnoteAdd="//input[@id='btnAddFootnote']";
	
	static String btnAddFilter="//input[@id='btnAddFilter']";
	static String filterSelectAttribute="//select[@id='ddlField']";
	static String filterSelectCondition="//select[@id='ddlCompare']";
	static String filterSelectAttributeValue="//ul[@class='select2-choices']";
	static String filterAddFilterBtn="//input[@id='btnAdd']";
	static String selectDivision="//select[@id='lstDivisons']";
	static String selectProjects="//select[@id='ListBox2']";
	static String selectContractors="//select[@id='ListBox3']";
	
	static String reportHeaderReportName= "//span[@id='Label1']";//span[@id='Label1']
	static String selectReport = "//span[text()='+reportName+']";//we directly fetch report name in method and use dynamic xpath we accepting report name through method
	static String btnBuildReport ="//input[@id='btnBuildReport']";
	
	static String linkExportToExcel ="//a[@id='HlinkExportExcel']";
	static String linkExportToWord ="//a[@id='HlinkExportWord']";
	static String linkExportToPDF ="//a[@id='HlinkExportPDF']";
	
	
	public static WebElement btnAddFootnote(WebDriver driver) {
		element = driver.findElement(By.xpath(btnAddFootnote));
		return element;
	}
	public static WebElement textAreaFootnote(WebDriver driver) {
		element = driver.findElement(By.xpath(textAreaFootnote));
		return element;
	}public static WebElement btnFootnoteCancel(WebDriver driver) {
		element = driver.findElement(By.xpath(btnFootnoteCancel));
		return element;
	}public static WebElement btnFootnoteClear(WebDriver driver) {
		element = driver.findElement(By.xpath(btnFootnoteClear));
		return element;
	}public static WebElement btnFootnoteAdd(WebDriver driver) {
		element = driver.findElement(By.xpath(btnFootnoteAdd));
		return element;
	}public static WebElement btnAddFilter(WebDriver driver) {
		element = driver.findElement(By.xpath(btnAddFilter));
		return element;
	}public static WebElement filterSelectAttribute(WebDriver driver) {
		element = driver.findElement(By.xpath(filterSelectAttribute));
		return element;
	}public static WebElement filterSelectCondition(WebDriver driver) {
		element = driver.findElement(By.xpath(filterSelectCondition));
		return element;
	}public static WebElement filterSelectAttributeValue(WebDriver driver) {
		element = driver.findElement(By.xpath(filterSelectAttributeValue));
		return element;
	}public static WebElement filterAddFilterBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(filterAddFilterBtn));
		return element;
	}public static WebElement selectDivision(WebDriver driver) {
		element = driver.findElement(By.xpath(selectDivision));
		return element;
	}public static WebElement selectProjects(WebDriver driver) {
		element = driver.findElement(By.xpath(selectProjects));
		return element;
	}public static WebElement selectContractors(WebDriver driver) {
		element = driver.findElement(By.xpath(selectContractors));
		return element;
	}public static WebElement linkExportToExcel(WebDriver driver) {
		element = driver.findElement(By.xpath(linkExportToExcel));
		return element;
	}public static WebElement linkExportToWord(WebDriver driver) {
		element = driver.findElement(By.xpath(linkExportToWord));
		return element;
	}public static WebElement btnBuildReport(WebDriver driver) {
		element = driver.findElement(By.xpath(btnBuildReport));
		return element;
	}
	public static WebElement linkExportToPDF(WebDriver driver) {
		element = driver.findElement(By.xpath(linkExportToPDF));
		return element;
	}
	
	public static WebElement selectReport(WebDriver driver,String reportName) {
		element = driver.findElement(By.xpath("//span[contains(text(),'"+reportName+"')]"));
		return element;
		//we directly fetch report name in method and use dynamic xpath to accepting report name through method
	}
	
	public static WebElement filterSelectProjectFormOption(WebDriver driver,String projectName) {
		element = driver.findElement(By.xpath("//div[@id='ctrlBuildReport_divWorksite']//div[@class='non-selected-wrapper']//a[contains(text(),'"+projectName+"')]"));
		return element;
		//we directly fetch project name in method and use dynamic xpath to accepting report name through method
	}
	
	public static WebElement reportHeaderReportName(WebDriver driver) {
		element = driver.findElement(By.xpath(reportHeaderReportName));
		return element;
		//we directly fetch project name in method and use dynamic xpath to accepting report name through method
	}
	
	// calculation Xpath
	static String takeAllEstimatedValue = "//input[@id='ctrlInsuranceEnrollment_txtContractPrice' or @id='ctrlInsuranceEnrollment_txtPayrolls']";// AddContractor_WC_Premiums_Modifications_Page.premiumValues(driver);
	public static List<WebElement> takeAllEstimatedValue(WebDriver driver)
	{
		listElement = driver.findElements(By.xpath(takeAllEstimatedValue));
		return listElement;
	}
	// CALCULATION Xpath
	// static String selectContractorPkg
	// ="//span[contains(text(),'ContractroPkgNo')]";
	public static WebElement selectContractorPkgID(WebDriver driver, String contrPkgNo) {
		element = driver.findElement(By.xpath("//td[contains(text(),'"+contrPkgNo+"')]"));
		return element;
	}

	public static List<WebElement> selectWCModifiersValue(WebDriver driver, String contrPkgNo) {
		listElement = driver.findElements(By.xpath("//td[contains(text(),'"+contrPkgNo+"')]/../following-sibling::tr[position()>10 and position()<14]/td[position()>3 and position()<5]"));
		return listElement;
	}
	
}