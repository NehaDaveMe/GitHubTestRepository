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
public class NCP_MyContractsPage {
	
	private static WebElement element;
	private static List<WebElement> listElement;
	
	static String MyContracts_CPlist_FirstElement="//div[@class='accordion md-accordion custom-accordion mt-4 contractor-package-list']/div[1]";
	static String MyContracts_CPlist_contractActivities="//div[@class='accordion md-accordion custom-accordion mt-4 contractor-package-list']/div[1]//div[@class='contractor-package-details collapse show']//ul[@class='list-enrolled']/li[@class]/a[@class='f-15']";
	
	public static WebElement MyContracts_CPlist_FirstElement(WebDriver driver) {
		element = driver.findElement(By.xpath(MyContracts_CPlist_FirstElement));
		return element;
	}

	public static List<WebElement> MyContracts_CPlist_contractActivities(WebDriver driver) {
		listElement = driver.findElements(By.xpath(MyContracts_CPlist_contractActivities));
		return listElement;
	}
}
