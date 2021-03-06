package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Report_ContractorStandingReport {
	private static WebElement element;
	private static List<WebElement> listElement;
	static String selectProgramDropdown = "//select[@id='ctl00_ContentPlaceHolder1_ddlProject']";
	static String selectProgramCategoryDropdown = "//select[@id='ctl00_ContentPlaceHolder1_ddlCategory']";
	static String btnCreateReport = "//input[@id='ctl00_ContentPlaceHolder1_btnCreate']";
	static String btnScheduleReport = "//a[text()='Schedule Report']";

	static String filterSortOptionAlpha = "//input[@id='ctrlBuildReport_rdoAlpha']";
	static String filterSortOptionTieredAlpha = "//input[@id='ctrlBuildReport_rdoTieredAlpha']";
	static String filterSelectProgramDropdown = "//select[@id='ctrlBuildReport_lbProject']";

	static String filterSelectDivisionDropdown = "//div[@id='ctrlBuildReport_divDivision']//div/select/option[1]";
	static String filterSelectProjectFormOption = "//div[@id='ctrlBuildReport_divWorksite']//div[@class='non-selected-wrapper']//a[contains(text(),'Sony Project Five')]";

	static String filterSelectContractorFormOption = "//div[@id='ctrlBuildReport_divContractor']//div/select/option[1]";

	static String reportHeaderReportName = "//td[contains(text(),'Contractor Standing Report')]";

	static String selectReport = "//span[text()='+reportName+']";
	static String btnBuildReport = "//input[@class='blueButton btnBuildReport']";

	static String BuildReportBtn_Nofilter = "//input[@id='btnBuildReport']";

	public static WebElement BuildReportBtn_Nofilter(WebDriver driver) {
		element = driver.findElement(By.xpath(BuildReportBtn_Nofilter));
		return element;
	}

	public static WebElement btnBuildReport(WebDriver driver) {
		element = driver.findElement(By.xpath(btnBuildReport));
		return element;
	}

	public static WebElement btnScheduleReport(WebDriver driver) {
		element = driver.findElement(By.xpath(btnScheduleReport));
		return element;
	}

	public static WebElement selectProgramDropdown(WebDriver driver) {
		element = driver.findElement(By.xpath(selectProgramDropdown));
		return element;
	}

	public static WebElement selectProgramCategoryDropdown(WebDriver driver) {
		element = driver.findElement(By.xpath(selectProgramCategoryDropdown));
		return element;
	}

	public static WebElement btnCreateReport(WebDriver driver) {
		element = driver.findElement(By.xpath(btnCreateReport));
		return element;
	}

	public static WebElement selectReport(WebDriver driver, String reportName) {
		element = driver.findElement(By.xpath("//span[contains(text(),'" + reportName + "')]"));
		return element;

	}

	public static WebElement filterSelectProjectFormOption(WebDriver driver) {
		element = driver.findElement(By.xpath("//select[@id='ctrlBuildReport_lbWorkSite']"));
		return element;

	}

	public static WebElement filterselectProjectFormOption(WebDriver driver) {
		element = driver.findElement(By.xpath("//select[@id='ListBox2']"));
		return element;

	}

	public static WebElement filterSelectcontractorFormOption(WebDriver driver) {
		element = driver.findElement(By.xpath("//select[@id='ListBox3']"));
		return element;
	}

	public static WebElement filterSelectContractorFormOption(WebDriver driver) {
		element = driver.findElement(By.xpath(filterSelectContractorFormOption));
		return element;
	}

	static String reportheaderReportName = "//span[@id='Label1' and @class='ReportPageHeader']";

	public static WebElement reportheaderReportName(WebDriver driver) {
		element = driver.findElement(By.xpath(reportheaderReportName));
		return element;
		// we directly fetch project name in method and use dynamic xpath to
		// accepting report name through method
	}

	public static WebElement reportHeaderReportName(WebDriver driver) {
		element = driver.findElement(By.xpath(reportHeaderReportName));
		return element;
		// we directly fetch project name in method and use dynamic xpath to
		// accepting report name through method
	}

	public static WebElement filterSelectProgramDropdown(WebDriver driver) {
		element = driver.findElement(By.xpath(filterSelectProgramDropdown));
		return element;
	}

	public static WebElement filterSelectDivisionDropdown(WebDriver driver) {
		element = driver.findElement(By.xpath(filterSelectDivisionDropdown));
		return element;
	}

	static String allReportList = "//div[starts-with(@id,'divChild')]//span[@class='reportName']//span";// list
	static String buildReportBtn = "//input[@id='ctrlBuildReport_btnBuildReport' or @class='blueButton btnBuildReport' ]";
	static String exportToPDF = "//div[@id='divExportIcon']/ul/li[1]";
	static String exportToExcel = "//a[@id='lnkExcel']";

	static String timeStamp = "//td[@class='dateTimeHeader trt']";
	static String programName = "//table[@class='subTable tableHeader']/tbody/tr[3]//td[contains(text(),'Program:')]//span";
	static String sponsorName = "//table[@class='contractorTable tableSubHeader']/tbody/tr[1]//td[3]/span";
	static String projectName = "//div[@id='divTableData']/table[2]/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]//tbody/tr/td[1]/span";
	
	static String districtName = "//div[@id='divTableData']/table[2]/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]//tbody/tr/td[2]/span";
	static String allProjectName = "//table[@class='mainTable']//*[@class='innerTable']//tbody//td[2]/span";// list
	static String allColumnName = "//table[@class='mainTable']/tbody/tr[2]//tbody/tr[2]//tbody/tr[1]//th";

	public static List<WebElement> allReportList(WebDriver driver) {
		listElement = driver.findElements(By.xpath(allReportList));
		return listElement;
	}

	public static WebElement buildReportBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(buildReportBtn));
		return element;
	}

	public static WebElement exportToPDF(WebDriver driver) {
		element = driver.findElement(By.xpath(exportToPDF));
		return element;
	}

	public static WebElement exportToExcel(WebDriver driver) {
		element = driver.findElement(By.xpath(exportToExcel));
		return element;
	}

	public static WebElement timeStamp(WebDriver driver) {
		element = driver.findElement(By.xpath(timeStamp));
		return element;
	}

	public static WebElement programName(WebDriver driver) {
		element = driver.findElement(By.xpath(programName));
		return element;
	}

	public static WebElement sponsorName(WebDriver driver) {
		element = driver.findElement(By.xpath(sponsorName));
		return element;
	}

	public static WebElement projectName(WebDriver driver) {
		element = driver.findElement(By.xpath(projectName));
		return element;
	}
	
	public static WebElement districtName(WebDriver driver) {
		element = driver.findElement(By.xpath(districtName));
		return element;
	}


	public static List<WebElement> allProjectName(WebDriver driver) {
		listElement = driver.findElements(By.xpath(allProjectName));
		return listElement;
	}

	public static List<WebElement> allColumnName(WebDriver driver) {
		listElement = driver.findElements(By.xpath(allColumnName));
		return listElement;
	}

	// filter xpaths
	static String countProjectNames = "//div[@id='divTableDataWeb']/table/tbody/tr[2]/th[contains(text(),'Project:') and position()=2]";
	static String countProjectWiseContractorPkg = "//div[@id='divTableDataWeb']//tbody//tr//td[@class='innerTableData tdCompanyName' and position()=2]";
	static String countContractorPkgStatus = "//table[@class='mainTable']//table[@class='subTable-child']/tbody/tr[2]/td[2]/table/tbody/tr/td[@class='txt-left innerTableData' and position()<5]";
	static String countContractorNO = "//table[@class='mainTable']//table[@class='subTable-child']/tbody/tr[2]/td[2]/table/tbody/tr/td[@class='txt-left innerTableData' and position()=3]";
	static String pdfLink = "//a[@id='lnkPDF']";
	static String excelLink = "//a[@id='lnkExcel']";

	public static List<WebElement> countProjectNames(WebDriver driver) {
		listElement = driver.findElements(By.xpath(countProjectNames));
		return listElement;
	}

	public static List<WebElement> countProjectWiseContractorPkg(WebDriver driver) {
		listElement = driver.findElements(By.xpath(countProjectWiseContractorPkg));
		return listElement;
	}

	public static List<WebElement> countContractorPkgStatus(WebDriver driver) {
		listElement = driver.findElements(By.xpath(countContractorPkgStatus));
		return listElement;
	}

	public static List<WebElement> countContractorNO(WebDriver driver) {
		listElement = driver.findElements(By.xpath(countContractorNO));
		return listElement;
	}

	public static WebElement pdfLink(WebDriver driver) {
		element = driver.findElement(By.xpath(pdfLink));
		return element;
	}

	public static WebElement excelLink(WebDriver driver) {
		element = driver.findElement(By.xpath(excelLink));
		return element;
	}

}
