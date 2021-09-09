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
public class NCP_SubContractorPage {
	
	private static WebElement element;
	private static List<WebElement> listElement;
	static String AddSubContractorbtn = "//div[@class='col-md-12']/a";
	static String Contractor = "//div[@class='md-form custom-form-group mb-0']/ul/li/input[@placeholder='Type to search for the Contractor']";
	static String contact = "//div[@class='form-group custom-form-group required']/div/ul/li";
	static String EstimatedContractValue = "//div[@class='col-md-6']/div[@class='md-form custom-form-group required']/input[@id='ContractorValue']";
	static String contactsearch = "//div[@id='divddlContact']//div/input[@class='select-dropdown']";
	static String EstimatedstartDate = "//div[@class='md-form custom-form-group required']/input[@id='ContrPackageStartDate']";
	static String Trade ="//div[@id='divTrade']/div/ul/li/input[@placeholder='Type to search for the Trade.']";
	static String Description = "//div[@class='md-form custom-form-group required']/textarea[@id='BriefDescription']";
	static String SaveContractorButton = "//div[@class='col-md-12 clearfix btn-save-and-back']/a[@data-text='Save a Subcontractor']";
	
	public static WebElement contactsearch(WebDriver driver) {
		element = driver.findElement(By.xpath(contactsearch));
		return element;
	}
	
	public static WebElement Contractor(WebDriver driver) {
		element = driver.findElement(By.xpath(Contractor));
		return element;
	}
	public static WebElement AddSubContractorbtn(WebDriver driver) {
		element = driver.findElement(By.xpath(AddSubContractorbtn));
		return element;
	}
	
	public static List<WebElement> contact(WebDriver driver) {
		listElement = driver.findElements(By.xpath(contact));
		return listElement;
	}
	public static WebElement EstimatedContractValue(WebDriver driver) {
		element = driver.findElement(By.xpath(EstimatedContractValue));
		return element;
	}
	
	public static WebElement EstimatedstartDate(WebDriver driver) {
		element = driver.findElement(By.xpath(EstimatedstartDate));
		return element;
	}

	public static WebElement Trade(WebDriver driver) {
		element = driver.findElement(By.xpath(Trade));
		return element;
	}
	public static WebElement Description(WebDriver driver) {
		element = driver.findElement(By.xpath(Description));
		return element;
	}
	public static WebElement SaveContractorButton(WebDriver driver) {
		element = driver.findElement(By.xpath(SaveContractorButton));
		return element;
	}
}
