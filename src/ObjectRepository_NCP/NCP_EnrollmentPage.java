/**
 * 
 */
package ObjectRepository_NCP;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author NDave
 *
 */
public class NCP_EnrollmentPage {
	
	private static WebElement element;
	private static List<WebElement> listElement;
	
	static String ContractorPackage_EnrollmentPage_leftpanel="//div[@class='treeview-colorful custom-treeview']/ul/li/a";
	static String CompanyInformation_Continue_Button ="//a[contains(text(),'Continue')]";
	static String Contract_CostWorksheet_Continue_Button ="//a[contains(text(),'Looks Good, Continue')]";
	static String Subcontractors_Continue_Button ="//a[contains(text(),'Looks Good,Continue')]";
	static String RequiredDocuments_Continue_Button ="//a[contains(text(),'Continue')]";
	static String ReviewEnrollment_submitdigitalenrollment_button ="//a[contains(text(),'Submit Digital Enrollment')]";
	
	public static List<WebElement> ContractorPackage_EnrollmentPage_leftpanel(WebDriver driver) {
		listElement = driver.findElements(By.xpath(ContractorPackage_EnrollmentPage_leftpanel));
		return listElement;
	}
	
	public static WebElement CompanyInformation_Continue_Button(WebDriver driver) {
		element = driver.findElement(By.xpath(CompanyInformation_Continue_Button));
		return element;
	}
	
	public static WebElement Contract_CostWorksheet_Continue_Button(WebDriver driver) {
		element = driver.findElement(By.xpath(Contract_CostWorksheet_Continue_Button));
		return element;
	}
	
	public static WebElement Subcontractors_Continue_Button(WebDriver driver) {
		element = driver.findElement(By.xpath(Subcontractors_Continue_Button));
		return element;
	}
	
	public static WebElement RequiredDocuments_Continue_Button(WebDriver driver) {
		element = driver.findElement(By.xpath(RequiredDocuments_Continue_Button));
		return element;
	}
	
	public static WebElement ReviewEnrollment_submitdigitalenrollment_button(WebDriver driver) {
		element = driver.findElement(By.xpath(ReviewEnrollment_submitdigitalenrollment_button));
		return element;
	}
	

}
