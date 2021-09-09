package ObjectRepository_CPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CPO_HomePage 
{
	
	private static WebElement element;

	// Login Page
	static String IconHome= "//a[contains(text(),'Home')]";
	static String IconMyProfile = "//a[contains(text(),'My Profile')]";
	static String IconMyProjects ="//a[contains(text(),'My Projects')]";
	static String IconLossControll ="//a[contains(text(),'Loss Control')]";
	static String IconReports ="//a[contains(text(),'Reports')]";
	static String IconLogout ="//a[contains(text(),'Logout')]";
	static String AlertCloseBtn ="//a[@class='styleButton blueBtn']";
	
	public static WebElement IconHome(WebDriver driver) {
		element = driver.findElement(By.xpath(IconHome));
		return element;
	}
	public static WebElement IconMyProfile(WebDriver driver) {
		element = driver.findElement(By.xpath(IconMyProfile));
		return element;
	}
	public static WebElement IconMyProjects(WebDriver driver) {
		element = driver.findElement(By.xpath(IconMyProjects));
		return element;
	}
	public static WebElement IconLossControll(WebDriver driver) {
		element = driver.findElement(By.xpath(IconLossControll));
		return element;
	}
	public static WebElement IconReports(WebDriver driver) {
		element = driver.findElement(By.xpath(IconReports));
		return element;
	}
	public static WebElement IconLogout(WebDriver driver) {
		element = driver.findElement(By.xpath(IconLogout));
		return element;
	}
	public static WebElement AlertCloseBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(AlertCloseBtn));
		return element;
	}
}
