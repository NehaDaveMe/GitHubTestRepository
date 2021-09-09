/**
 * 
 */
package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author NDave
 *
 */
public class EmailModule {
	
	private static WebElement element;
	private static List<WebElement> listElement;
	
	static String SentEmail_Selectfirstvaluefromlist = "//div[@id='divPreviewPanel']//div[@class='panel-body emailList']/div/ul/li[1]";
	
	public static WebElement SentEmail_Selectfirstvaluefromlist(WebDriver driver) {
		element = driver.findElement(By.xpath(SentEmail_Selectfirstvaluefromlist));
		return element;
	}
	
	static String SentEmail_Selectfirstvaluefromlist_ToField = "//div[@id='divEmailTo']/span[@id='ltrOEmailTo']";
	
	public static WebElement SentEmail_Selectfirstvaluefromlist_ToField(WebDriver driver) {
		element = driver.findElement(By.xpath(SentEmail_Selectfirstvaluefromlist_ToField));
		return element;
	}
	

}
