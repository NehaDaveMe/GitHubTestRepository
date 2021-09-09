package CommonLibrary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import GenericLibrary.BaseClass;

public class WebDriverCommonLib {

	public HashMap<String, String> map = new HashMap<>();

	public void getWindowIDs() {
		Set<String> set = BaseClass.driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String pID = it.next();
		String cID = it.next();
		map.put("parentID", pID);
		map.put("childID", cID);
	}

	public void getWindowID3() {
		Set<String> set1 = BaseClass.driver.getWindowHandles();
		Iterator<String> str2 = set1.iterator();
		String PID = str2.next();
		String CID = str2.next();
		String SCID = str2.next();
		map.put("parentID", PID);
		map.put("childID", CID);
		map.put("subchildID", SCID);

	}

	public void getWindowID4() {
		Set<String> set1 = BaseClass.driver.getWindowHandles();
		Iterator<String> str2 = set1.iterator();
		String PID = str2.next();
		String CID = str2.next();
		String SCID = str2.next();
		String SSCID = str2.next();
		map.put("parentID", PID);
		map.put("childID", CID);
		map.put("subchildID", SCID);
		map.put("subsubchildID", SSCID);
	}

	public void printListData(List<WebElement> wb) {
		List<WebElement> lst = wb;
		System.out.println("list Size :- " + lst.size());
		for (int i = 0; i <= lst.size() - 1; i++) {

			System.out.println(lst.get(i).getText());
		}
	}

	public void oneByOneClick(List<WebElement> we) {
		List<WebElement> lst = we;
		for (int i = 0; i <= lst.size() - 1; i++) {
			lst.get(i).click();// select all switch one by one
		}
	}

	public void selectSingleValueByIndex(WebElement selectElement, int index) {
		Select sel = new Select(selectElement);
		sel.selectByIndex(index);
	}

	public void selectSingleValueGetOpt(WebElement selectElement, String data) {
		Select sel = new Select(selectElement);
		List<WebElement> lst1 = sel.getOptions();

		for (int i = 0; i < lst1.size(); i++) {
			System.out.println(lst1.get(i).getText());
			 String res = lst1.get(i).getText();

			if (res.contains(data)) {
				lst1.get(i).click();
			}
		}
	}

	public void selectSingleValue(WebElement selectElement, String data) {
		Select sel = new Select(selectElement);
		sel.selectByVisibleText(data);

		/*
		 * List<WebElement> lst1=sel.getOptions(); for(int i=0;i<lst1.size();i++) {
		 * if(lst1.equals(data)) { lst1.get(i).click(); } }
		 */
	}

	public void windowScrollBy(int horizontalScroll, int verticalScroll) {
		 JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
//		js.executeScript("window.scrollBy(0,-250)", "")
		js.executeScript("window.scrollBy(" + horizontalScroll + "," + verticalScroll + ")", "");

	}

	public void selectSingleValueFromList(List<WebElement> selectElement, String data) {

		List<WebElement> str = selectElement;
		System.out.println("size of list" + str.size());
		for (WebElement option : str) {
			if (option.getText().contains(data)) {
				System.out.println("Trying to select" + data);
				option.click();
				break;
			}

		}
	}

	public boolean isFileDownloaded(String fileName) {
		// String downloadPath="C:\\Users\\NTC_Brijesh\\Downloads";
		String downloadPath = "C:\\Neha\\Download";//"C:\\Users\\User\\Downloads";
		
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag = true;
		}

		return flag;
	}

	public void alertOk() {
		Alert alt = BaseClass.driver.switchTo().alert();
		alt.accept();
	}

	public void alertCancel() {
		Alert alt = BaseClass.driver.switchTo().alert();
		alt.dismiss();
	}

	public void mouseMoveToElement(WebElement elemnet) {
		Actions act = new Actions(BaseClass.driver);
		act.moveToElement(elemnet).click().build().perform();
	}
	
	public void mouseMoveToElementwithoutClick(WebElement elemnet) {
		Actions act = new Actions(BaseClass.driver);
		act.moveToElement(elemnet).perform();
	}

	public void mouseLeftClick(WebElement elemnet) {
		Actions act = new Actions(BaseClass.driver);
		act.moveToElement(elemnet).click().build().perform();
	}

	public void rightClick(WebElement elemnet) {
		Actions act = new Actions(BaseClass.driver);
		act.contextClick(elemnet).perform();
	}

	public void waitForElemnetMax(WebElement elemnet) {
		int count = 0;
		while (count <= 20) {
			try {
				elemnet.isDisplayed();
				break;
			} catch (Throwable t) {
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
				}
			}
		}

	}

	public void waitForCompletePageLoad(WebDriver driver) 
	{
		System.out.println("Enter into the page load method"); 
		
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() 
		{
			public Boolean apply(WebDriver driver) 
			{
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
		
		System.out.println("page load method end");
	}

	
	
	
	// public HashMap<String, String> map = new HashMap<>();
	String contractorName = "Mark Boucher";
	String projectName1 = "Hercules PJ";
	String tradeNo = "2085 | TradeDynamic-";

	// depends on change colour method
	public void flash(WebElement element) {

		// JavascriptExecutor js = (JavascriptExecutor)BaseClass.driver;
		String bgcolour = element.getCssValue("backgroundColor");
		System.out.println("the background colour of element is ::::: ----->>>   " + bgcolour);
		for (int i = 0; i < 50; i++) {
			changecolour("#000000", element);
			changecolour(bgcolour, element);
		}

	}

	public void changecolour(String color, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);

	}

	public void DrawBorder(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);

	}
	// Capture tilte of Page

	public String getTitleByJS() {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		String title = js.executeScript("return document.title;").toString();
		System.out.println(title + "It is the title of the page at script executor");
		return title;
	}

	public void ClickElementByJS(WebElement ele) throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		js.executeAsyncScript("arguments[0].click();", ele);

	}

	public void WindowTitleSwitch(String windowTitle) throws Throwable {
		Set<String> ids = BaseClass.driver.getWindowHandles();
		Object[] windowid = new Object[5];
		// Object[] id = ids.toArray();
		String windowID0 = windowid[1].toString();
		String windowID1 = windowid[2].toString();
		String windowID2 = windowid[3].toString();
		String windowID3 = windowid[4].toString();
		String windowID4 = windowid[5].toString();
		String windowID5 = windowid[6].toString();
		String windowID6 = windowid[7].toString();
		for (int i = 0; i < windowid.length; i++) {
			if (windowID0.equalsIgnoreCase(windowTitle)) {
				BaseClass.driver.switchTo().window(windowID0);
				try {
					BaseClass.driver.manage().window().maximize();
					System.out.println("window is maximized at windowID0");
				} catch (Exception e) {
					System.out.println("window is already maximized at windowID0");
				}
			} else if (windowID1.equalsIgnoreCase(windowTitle)) {
				BaseClass.driver.switchTo().window(windowID1);
				try {
					BaseClass.driver.manage().window().maximize();
					System.out.println("window is maximized at windowID1");
				} catch (Exception e) {
					System.out.println("window is already maximized at windowID1");
				}
			} else if (windowID2.equalsIgnoreCase(windowTitle)) {
				BaseClass.driver.switchTo().window(windowID2);
				try {
					BaseClass.driver.manage().window().maximize();
					System.out.println("window is maximized at windowID0");
				} catch (Exception e) {
					System.out.println("window is already maximized at windowID0");
				}
			} else if (windowID3.equalsIgnoreCase(windowTitle)) {
				BaseClass.driver.switchTo().window(windowID3);
				try {
					BaseClass.driver.manage().window().maximize();
					System.out.println("window is maximized at windowID0");
				} catch (Exception e) {
					System.out.println("window is already maximized at windowID0");
				}
			} else if (windowID4.equalsIgnoreCase(windowTitle)) {
				BaseClass.driver.switchTo().window(windowID4);
				try {
					BaseClass.driver.manage().window().maximize();
					System.out.println("window is maximized at windowID0");
				} catch (Exception e) {
					System.out.println("window is already maximized at windowID0");
				}
			} else if (windowID5.equalsIgnoreCase(windowTitle)) {
				BaseClass.driver.switchTo().window(windowID5);
				try {
					BaseClass.driver.manage().window().maximize();
					System.out.println("window is maximized at windowID0");
				} catch (Exception e) {
					System.out.println("window is already maximized at windowID0");
				}
			} else if (windowID6.equalsIgnoreCase(windowTitle)) {
				BaseClass.driver.switchTo().window(windowID6);
				try {
					BaseClass.driver.manage().window().maximize();
					System.out.println("window is maximized at windowID0");
				} catch (Exception e) {
					System.out.println("window is already maximized at windowID0");
				}
			} else {
				System.out.println("no such window id to switch");
			}
		}
	}

	// For loop based oon title

	public String GetText(WebElement ele) {

		String ele1Text = ele.getText();
		System.out.println(ele1Text);

		System.out.println(" Enrollment text is :::" + ele1Text);
		return ele1Text;
	}

	public void GetTextS(List<WebElement> list) {

		for (int i = 0; i < list.size(); i++) {
			String ele1Text = list.get(i).getText();
			System.out.println(ele1Text);

			System.out.println(" Enrollment text is :::" + ele1Text);

		}

	}

	//------------------------Neha start----------------------
	
		public void TurnONSwitches(List<WebElement> list) {
			int size = list.size();
			System.out.println(size);
			
			for (int i = 0; i < list.size(); i++) 
			{
			boolean flag = false;

			String Attribute = list.get(i).getAttribute("class");
			String tagname = list.get(i).getTagName();
			
			//System.out.println(Dimension);
			System.out.println(tagname);
			System.out.println(Attribute + "it is attribute");
		//	String Attribute = list.getAttribute("class");
			System.out.println(Attribute);
			if (Attribute.equals("ios-ui-select")) {
				System.out.println("switch is turn OFF and turned it ON now at If ");
				list.get(i).click();
				flag = true;
				System.out.println(Attribute + "It is the attribute of the Switch at Turn On Method in if ");
				System.out.println(flag);

			} else {
				System.out.println("Switch is already Turn ON");
				flag = true;
				System.out.println(Attribute + "It is the attribute of the Switch  in Turn On method in else  ");
			}
			}

		}
		
		
		public void TurnOFFSwitches(List<WebElement> list) {
			int size = list.size();
			System.out.println(size);
			
			for (int i = 0; i < list.size(); i++) 
			{
			boolean flag = false;

			String Attribute = list.get(i).getAttribute("class");
			String tagname = list.get(i).getTagName();
			System.out.println(tagname);
			System.out.println(Attribute + "it is attribute");
			System.out.println(Attribute);
			
			if (Attribute.equals("ios-ui-select checked")) {
				System.out.println("switch is turn ON and turned it OFF now");
				list.get(i).click();
				flag = true;
				System.out.println(Attribute + "It is at turn OFF method");
				System.out.println(flag);

			} else {
				System.out.println("Switch is already TurnoFF");
				flag = true;
				System.out.println(Attribute + "It is the attribuet in turn off method at else");
				System.out.println(flag + "it is the flag value at Turn off method in else");
			}
			}

		}
		
		public void Comparestatus(String ActualStatus, String Expectedstatus)
		{
			if(ActualStatus==Expectedstatus)
			{
				System.out.println(ActualStatus + "In If condition, Status is Active and Switch is ON");
			}
			else
			{
				System.out.println(ActualStatus + "In else condition, Status is InActive and Switch is OFF");
			}
		}
		
		//------------------------Neha End-----------------------------
	
	public void ClickselectPackage() {
		List<WebElement> DynamicContractorPkg = BaseClass.driver.findElements(By.xpath(
				"//ul[@id='ulNoteList']/li[*]//div[@class='companytitle']/span[contains(text(),'Mark Boucher')]/../..//div[@class='workSite']/span[contains(text(),'Hercules PJ')]/../../../div[2]/div[3]/span[contains(text(),'2085 | TradeDynamic-')]/../../.."));
		for (int i = 0; i < DynamicContractorPkg.size(); i++) {

			String DynamicContractorPkgTXT = DynamicContractorPkg.get(i).getText();
			System.out.println(DynamicContractorPkgTXT);
			DynamicContractorPkg.get(i).click();
			break;
		}

	}

	public void RadioButton(List<WebElement> list, WebElement ele) {

		for (int i = 0; i < list.size(); i++) {

			String listtext = list.get(i).getText();
			String Attribute = list.get(i).getAttribute("class");
			System.out.println(listtext + "::::   " + " === it is the listb text of radio buttton");
			if (listtext.contains("Enrolled")) {
				if (ele.getTagName().contains("div") && (ele.getAttribute("class").contains("radio or radio hover"))) {
					ele.click();
					System.out.println(Attribute + "::::" + "=== ************************************************");
					System.out.println("we found radio button and click");
					break;
				}
			}
		}
	}

	public WebElement selectDynamicContractorPkg() {
		WebElement DynamicContractorPkg = BaseClass.driver
				.findElement(By.xpath("//ul[@id='ulNoteList']/li[*]//div[@class='companytitle']/span[contains(text(),'"
						+ contractorName + "')]/../..//div[@class='workSite']/span[contains(text(),'" + projectName1
						+ "')]/../../../div[2]/div[3]/span[contains(text(),'" + tradeNo + "')]"));

		return DynamicContractorPkg;

	}

	public void compareText() throws Throwable {
		List<WebElement> list = BaseClass.driver
				.findElements(By.xpath("//div[@class='top-bar-wrap clearfix']/ul/li/../li[*][1]"));
		for (int i = 0; i < list.size(); i++) {
			String ele1Text = list.get(i).getText();
			System.out.println("eleText1 is :::" + ele1Text);

			Thread.sleep(2000);
			WebElement DynamicContractorPkg = BaseClass.driver.findElement(By.xpath(
					"//ul[@id='ulNoteList']/li[*]//div[@class='companytitle']/span[contains(text(),'Mark Boucher')]/../..//div[@class='workSite']/span[contains(text(),'Hercules PJ')]/../../../div[2]/div[3]/span[contains(text(),'2085 | TradeDynamic-')]/../../.."));
			String ele2Text = DynamicContractorPkg.getText();
			System.out.println("ele2Text is :::" + ele2Text);
			if (ele1Text.contains(ele2Text)) {
				System.out.println("both statuses  are martching at Enrollment and Contractor packages "
						+ " Enrollment text is :::" + ele1Text + "Contractor pkg text is ::::" + ele2Text);
				// CodeLibrary.SwitchtoChild1();
				Thread.sleep(2000);
				System.out.println("child window1 is clicked");
			} else {
				System.out.println("both statuses  are  not martching at Enrollment and Contractor packages "
						+ " Enrollment text is :::" + ele1Text + "Contractor pkg text is ::::" + ele2Text);
			}
		}
	}

	public void compareTexts(List<WebElement> list, WebElement ele2) throws Throwable {
		for (int i = 0; i < list.size(); i++) {
			String ele1Text = list.get(i).getText();
			System.out.println("eleText1 is :::" + ele1Text);
			WebDriverCommonLib wb = new WebDriverCommonLib();
			wb.Switchtoparent();
			String ele2Text = ele2.getText();
			System.out.println("ele2Text is :::" + ele2Text);
			if (ele1Text.contains(ele2Text)) {
				System.out.println("both statuses  are martching at Enrollment and Contractor packages "
						+ " Enrollment text is :::" + ele1Text + "Contractor pkg text is ::::" + ele2Text);
				// WebDriverCommonLib wb = new WebDriverCommonLib();
				wb.SwitchtoChild1();
				System.out.println("child window1 is clicked");
			} else {
				System.out.println("both statuses  are  not martching at Enrollment and Contractor packages "
						+ " Enrollment text is :::" + ele1Text + "Contractor pkg text is ::::" + ele2Text);
			}
		}
	}


	public void SenKeyskeys_TAB(WebElement ele, String text) {

		try {
			ele.click();
			ele.clear();
			Thread.sleep(2000);
			ele.sendKeys(text);
			Thread.sleep(2000);
			ele.sendKeys(Keys.TAB);
		} catch (Throwable e) {
			System.out.println("element cant be clicked");
		}
	}

	// Switches
	public void TurnON_OFF_Switch(String ele_xpath) {
		boolean flag = false;
		WebElement Switch = BaseClass.driver.findElement(By.xpath(ele_xpath));
		String Attribute = Switch.getAttribute("class");
		System.out.println(Attribute);
		if (Attribute.contains("ios-ui-select")) {
			Switch.click();
			System.out.println("switch is turn oFF and turned ON now");
			flag = true;
		} else {

			if (Attribute.contains("ios-ui-select checked")) {
				Switch.click();
				System.out.println("switch is turn ON and turned OFF now");
				flag = true;

			} else {
				System.out.println("already selected");
				flag = true;
				System.out.println(flag);

			}
		}

	}


	public void TurnOFF_Switch(String ele_xpath) {
		boolean flag = false;
		WebElement Switch = BaseClass.driver.findElement(By.xpath(ele_xpath));
		String Attribute = Switch.getAttribute("class");
		System.out.println(Attribute);
		if (Attribute.equals("ios-ui-select checked")) {
			System.out.println("switch is turn ON and turned it OFF now");
			Switch.click();
			System.out.println(Attribute);
			flag = true;

		} else {
			System.out.println("Switch is already TurnoFF");
			flag = true;
			System.out.println(Attribute);
			System.out.println(flag);

		}

	}

	public void NCP_CHKBOX_Validation(String ele_xpath) {
		boolean flag = false;
		WebElement Switch = BaseClass.driver.findElement(By.xpath(ele_xpath));
		String Attribute = Switch.getAttribute("disabled");
		System.out.println(Attribute);
		if (Attribute.equals("disabled")) {
			System.out.println("check box is disabled");
			System.out.println(Attribute);
			flag = true;

		} else {
			System.out.println("Checkbox is enabled only");
			flag = true;
			System.out.println(Attribute);
			System.out.println(flag);

		}

	}

	public void TurnON_Switch(String ele_xpath) {
		boolean flag = false;
		WebElement Switch = BaseClass.driver.findElement(By.xpath(ele_xpath));
		String Attribute = Switch.getAttribute("class");
		System.out.println(Attribute);
		if (Attribute.equals("ios-ui-select")) {
			System.out.println("switch is turn OFF and turned it ON now");
			Switch.click();
			flag = true;
			System.out.println(Attribute);
			System.out.println(flag);

		} else {
			System.out.println("Switch is already Turn ON");
			flag = true;
			System.out.println(Attribute);
		}

	}

	//
	public void TurnONSwitch(WebElement ele) {
		boolean flag = false;

		String Attribute = ele.getAttribute("class");
		System.out.println(Attribute);
		if (Attribute.equals("ios-ui-select")) {
			System.out.println("switch is turn OFF and turned it ON now at If ");
			ele.click();
			flag = true;
			System.out.println(Attribute + "It is the attribute of the Switch at Turn On Method in if ");
			System.out.println(flag);

		} else {
			System.out.println("Switch is already Turn ON");
			flag = true;
			System.out.println(Attribute + "It is the attribute of the Switch  in Turn On method in else  ");
		}

	}

	public void TurnOFFSwitch(WebElement ele) {
		boolean flag = false;

		String Attribute = ele.getAttribute("class");
		System.out.println(Attribute);
		if (Attribute.equals("ios-ui-select checked")) {
			System.out.println("switch is turn ON and turned it OFF now");
			ele.click();
			System.out.println(Attribute + "It is at turn OFF method");
			flag = true;

		} else {
			System.out.println("Switch is already TurnoFF");
			flag = true;
			System.out.println(Attribute + "It is the attribuet in turn off method at else");
			System.out.println(flag + "it is the flag value at Turn off method in else");

		}

	}

	// Radio Btn

	public void CheckRadioBtn(WebElement ele) throws Exception {
		boolean flag = false;
		String tagname = ele.getTagName();
		System.out.println("tagname at radio button is  =====>  " + tagname);
		String Attribute = ele.getAttribute("class");
		if (Attribute.equals("checked")) {
			System.out.println("Radio button is already selected  and no need to select again");
			System.out.println(Attribute + "It is at  radion button method");
			flag = true;
		} else {
			
			Thread.sleep(2000);
			ele.click();
			Thread.sleep(1500);
			System.out.println("Radio button is not selected and so seleted now");
			flag = true;
			System.out.println(Attribute + "It is the attribuet in Tick radion button  method at else");
			System.out.println(flag + "it is the flag value at Tick radion button method in else");

		}

	}

	// Check Box Tick or Untick

	public void Tick_CheckBox(String ele_xpath) {
		boolean flag = false;
		WebElement chkbox = BaseClass.driver.findElement(By.xpath(ele_xpath));
		String Attribute = chkbox.getAttribute("class");
		System.out.println(Attribute);
		if (Attribute != "checked") {
			chkbox.click();
			System.out.println("Check box  is ticked now at Tick Method ");
			flag = true;
			System.out.println(Attribute);
		} else if (Attribute == "checked") {

			System.out.println("Check box is  ticked  already at Tick method ");
			flag = true;
			System.out.println(Attribute);
			System.out.println(flag);
		}

	}
	
	public void Tick_CheckBox(WebElement chkbox) {
		boolean flag = false;
		//WebElement chkbox = BaseClass.driver.findElement(By.xpath(ele_xpath));
		String Attribute = chkbox.getAttribute("class");
		System.out.println(Attribute);
		if (Attribute != "checked") {
			chkbox.click();
			System.out.println("Check box  is ticked now at Tick Method ");
			flag = true;
			System.out.println(Attribute);
		} else if (Attribute == "checked") {

			System.out.println("Check box is  ticked  already at Tick method ");
			flag = true;
			System.out.println(Attribute);
			System.out.println(flag);
		}

	}

	public void UNTick_CheckBox(String ele_xpath) {
		boolean flag = false;
		WebElement chkbox = BaseClass.driver.findElement(By.xpath(ele_xpath));
		String Attribute = chkbox.getAttribute("class");
		System.out.println(Attribute);
		if (Attribute == "checked") {
			chkbox.click();
			System.out.println("Checked box  is already ticked at Untick method ");
			flag = true;
			System.out.println(Attribute);
		} else if (Attribute != "checked") {
			// chkbox.click();
			System.out
					.println("Check box is not ticked so moved further after vqlidating the UNTICK at Untick method ");
			flag = true;
			System.out.println(Attribute);
			System.out.println(flag);

		}

	}
	
	
	// List of check boxes Untick

		public void UN_Tick_List_of_ChkBoxes(List<WebElement> liist) {

			System.out.println("UN_Tick_List_of_ChkBoxes");
			for (int i = 0; i < liist.size(); i++) {
				boolean flag = false;
				String listtext = liist.get(i).getText();
				String Attribute = liist.get(i).getAttribute("class");
				String tagname = liist.get(i).getTagName();
				System.out.println(tagname);
				System.out.println(Attribute + "it is attribute");
				if (Attribute.equalsIgnoreCase("checked")) {
					liist.get(i).click();
					System.out.println(listtext);
					System.out.println("clicked all now ");
					flag = true;
					System.out.println(flag);
					System.out.println(
							"we are at UN_Tick_List_of_ChkBoxes method and they are  already checked  so we clicked on chk boxes now");
				} else {
					flag = true;
					System.out.println(flag);
					System.out.println("check boxes are already unchecked at UN_Tick_List_of_ChkBoxes method");
				}

			}
		}

		// list of check boxes tick

		public void Tick_List_of_ChkBoxes(List<WebElement> liist) {
			for (int i = 0; i < liist.size(); i++) {
				boolean flag = false;
				String listtext = liist.get(i).getText();
				String Attribute = liist.get(i).getAttribute("class");
				String tagname = liist.get(i).getTagName();
				System.out.println(tagname);
				System.out.println(Attribute + "it is attribute");
				if (Attribute != "checked") {
					liist.get(i).click();
					System.out.println(listtext);
					System.out.println("clikced all");
					flag = true;
					System.out.println(flag);
					System.out.println(
							"we are at Tick_List_of_ChkBoxes method " + "check boxes are already unticked so ticked now");
				} else {
					flag = true;
					System.out.println(flag);
					System.out.println("check boxes are already checked at UN_Tick_List_of_ChkBoxes method");
				}

			}
		}

	// Screenshot code
	public String getScreenshot() {
		String concat = ".";
		Date oDate = new Date();
		SimpleDateFormat oSDF = new SimpleDateFormat("yyyyMMddHHmmss");
		String sDate = oSDF.format(oDate);
		TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "D:\\NOURTEK\\Nourtek\\ExtentReports\\Screenshots\\screen" + sDate + ".png";
		File destination = new File(path);

		try {

			FileUtils.copyFile(src, destination);
		} catch (Throwable e) {
			System.out.println("captured Failed" + e.getMessage());
		}

		String tp = concat + path;
		return tp;

	}

	public String captureScreen(String fileName) {
		if (fileName == "") {
			fileName = "Screenshot";
		}

		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		File srcFile = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);

		try {

			String reportDirectory = "D:\\NOURTEK\\Nourtek\\ExtentReports\\Screenshots\\screen";
			// String reportDirectory= new
			// File(System.getProperty("user.dir")).getAbsolutePath()+"./src/main/java/com/test/automation/Demo/screenshot/";
			destFile = new File(
					(String) reportDirectory + fileName + "-" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(srcFile, destFile);
			// This will help us to link screen shot in Extent report
			Reporter.log("<a href='" + destFile + "'><img src='" + destFile + "' height='100' width='100'/></a>");
			// Reporter.log("<a href='"+destFile.getAbsolutePath()+ "'><img src='"
			// +destFile.getAbsolutePath()+"' height='100' width='100'/></a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}


	public void ListOfFilters_ChkBox_Tick_1(List<WebElement> list, List<WebElement> sublist, String nametext) {
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			String listText = list.get(i).getText();
			String sublistText = sublist.get(i).getText();
			System.out.println("the list of statuses  list  at contractorpackages items are : " + listText);
			System.out.println("the sublist of list at contractor package  items are : " + sublistText);
			String Attribute = sublist.get(i).getAttribute("class");
			String tageName = sublist.get(i).getTagName();
			System.out.println(Attribute);
			System.out.println(tageName);
			if (tageName.contains("span") && !(Attribute.equalsIgnoreCase("checked"))) {
				System.out.println("tag name is  " + tageName + " " + " AND " + "attribute name is" + " " + Attribute
						+ "Tick is  not present in the box");
				if (sublistText.equalsIgnoreCase(nametext)) {
					flag = true;
					sublist.get(i).click();
					System.out.println("tag name is  " + tageName + " " + " AND " + "attribute name is" + " "
							+ Attribute + "Tick is  not present in the box so ticked now");
					System.out.println("the falg at else if is " + flag);
					break;
				} else {
					flag = true;
					System.out.println("we are at else condition and " + "tag name is " + tageName + " "
							+ "attribute name is " + " " + Attribute + "tick is  present already");
					System.out.println("the falg at else  is " + flag);
				}

			}

		}

	}

	public void StatusValidate_switchbyWindowTitle(List<WebElement> list, String Enrolltxt, WebElement cpkgStataus,
			String cpkgtext, String windowTitle1, String windowTitle2, WebElement refreshBtn) {
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			String liststext = list.get(i).getText();
			if (liststext.contains(Enrolltxt)) {
				System.out.println(liststext);
				try {
					int winDow = 0;
					Set<String> allwindow = BaseClass.driver.getWindowHandles();
					for (String eachwindow : allwindow) {
						BaseClass.driver.switchTo().window(eachwindow);
						System.out.println(eachwindow);
						winDow++;
						System.out.println(winDow);
						String eachwinowtitle = BaseClass.driver.getTitle();
						if (eachwinowtitle.contains(windowTitle1)) {
							BaseClass.driver.switchTo().window(eachwindow);
							refreshBtn.click();
							Thread.sleep(4000);
							String ckgstatusText = cpkgStataus.getText();
							if (ckgstatusText.contains(cpkgtext)) {
								if (Enrolltxt.equalsIgnoreCase(cpkgtext)) {
									System.out.println(
											"both the statuses at Contractor package level and ENrollment page are matching");
									BaseClass.driver.switchTo().window(windowTitle2);
									flag = true;

								}
							}
						}
					}
				} catch (Throwable e) {
					System.out.println("we are at catch block and try block condition are not matched");
				}
			}

		}
	}

	public void StatusValidate(List<WebElement> list, String text1, List<WebElement> sublist, String text2,
			String windowTitle1, String windowTitle2) {
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			String liststext = list.get(i).getText();
			if (liststext.contains(text1)) {
				System.out.println(liststext);
				list.get(i).click();
				try {
					Set<String> windowList = BaseClass.driver.getWindowHandles();
					String[] array = windowList.toArray(new String[0]);
					if (BaseClass.driver.getTitle().contains(windowTitle1)) {
						BaseClass.driver.switchTo().window(windowTitle1);
						String sublisttext = sublist.get(i).getText();
						if (sublisttext.contains(text2)) {
							if (text1.equalsIgnoreCase(text2)) {
								System.out.println(
										"both the statuses at Contractor package level and ENrollment page are matching");
								BaseClass.driver.switchTo().window(windowTitle2);
								flag = true;
							}
						}
					}
				} catch (Throwable e) {
					System.out.println("we are at catch block and try block condition are not matched");
				}
			}

		}
	}

	public void ListOfFilters_ChkBox_Tick_1_UnTick_1(List<WebElement> list, List<WebElement> sublist, String nametext) {

		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			String listText = list.get(i).getText();
			String sublistText = sublist.get(i).getText();
			System.out.println("the list of statuses  list  at contractorpackages items are : " + listText);
			System.out.println("the sublist of list at contractor package  items are : " + sublistText);
			String Attribute = sublist.get(i).getAttribute("class");
			String tageName = sublist.get(i).getTagName();
			System.out.println(Attribute);
			System.out.println(tageName);
			if (tageName.contains("span") && (Attribute.equalsIgnoreCase("checked"))) {
				System.out.println("tag name is  " + tageName + " " + " AND " + "attribute name is" + " " + Attribute
						+ "Tick is  not present in the box so ticked now");
				sublist.get(i).click();
			}
			if (listText.equalsIgnoreCase(nametext)) {
				if (!(tageName.contains("span")) && (!Attribute.equalsIgnoreCase("checked"))) {
					flag = true;
					System.out.println(
							"tag name is not " + tageName + " " + " AND " + "attribute name is not " + " " + Attribute);
					System.out.println("the falg at  if is " + flag);
				} else if (tageName.contains("span") && !(Attribute.equalsIgnoreCase("checked"))) {
					flag = true;
					sublist.get(i).click();
					System.out.println("tag name is  " + tageName + " " + " AND " + "attribute name is" + " "
							+ Attribute + "Tick is  not present in the box so ticked now");
					System.out.println("the falg at else if is " + flag);
					break;
				} else {
					flag = true;
					System.out.println("we are at else condition and " + "tag name is " + tageName + " "
							+ "attribute name is " + " " + Attribute + "tick is  present already");
					System.out.println("the falg at else  is " + flag);
				}

			}

		}

	}

	// Switches
	public void ToogleSwitchMethod(String list_element_xpath, String ele_text, String ele_xpath, String locator,
			String ele_attribute_text) {

		boolean flag = false;
		List<WebElement> ListofElements = BaseClass.driver.findElements(By.xpath(list_element_xpath));
		for (int i = 0; i < ListofElements.size(); i++) {
			String List_Text = ListofElements.get(i).getText();
			System.out.println(List_Text);
			if (List_Text.contains(ele_text)) {
				System.out.println("It is at the right place inside " + ele_text);
				WebElement Switch = BaseClass.driver.findElement(By.xpath(ele_xpath));
				String Attribute = Switch.getAttribute(locator);
				System.out.println(locator);
				if (Attribute.contains(ele_attribute_text)) {
					System.out.println("already selected");
					flag = true;
				} else {
//						 if (!(b.getAttribute("class").contains("ios-ui-select checked"))) {
					System.out.println("it has toi select now");
					Switch.click();
					flag = true;
				}

				if (flag) {
					break;
				}
			}
		}

	}

	public void CP_status_filters(String Cont_list, String Cont_statuslist, String Contains_Text,
			String conta_txt_stats) throws Throwable {

		List<WebElement> list = BaseClass.driver.findElements(By.xpath(Cont_list));
		List<WebElement> Sub = BaseClass.driver.findElements(By.xpath(Cont_statuslist));
		for (int i = 0; i < list.size(); i++) {
			String All = list.get(i).getText();
			String Some = Sub.get(i).getText();
			if (All.equalsIgnoreCase(Contains_Text) && Some.equalsIgnoreCase(conta_txt_stats)) {
				list.get(i).click();
				System.out.println(All + ":::" + Some);
				break;

			}

		}
	}

	public void NCP_Filters(String NCP_List, String NCP_statuslist, String text1, String text2) {

		List<WebElement> Contractor = BaseClass.driver.findElements(By.xpath(NCP_List));
		for (int i = 0; i < Contractor.size(); i++) {
			List<WebElement> status = BaseClass.driver.findElements(By.xpath(NCP_statuslist));
			String Clist = Contractor.get(i).getText();
			String SList = status.get(i).getText();
			if (Clist.contains(text1) && SList.contains(text2)) {
				System.out.println(Clist);
				System.out.println(SList);
				status.get(i).click();
				break;
				// div[@class='project-name with-status']
				// li[@class='sub-box']/a
				// Roger Federer
				// Missing Payroll
			}

		}

	}

	public void Multiple_Filters(List<WebElement> parentlist, List<WebElement> childlist, String PComp, String PContra,
			String PEnrol, String Cstaus, String Cprog_proj, String Ctrade) {
		for (int i = 0; i < parentlist.size(); i++) {
			String PList = parentlist.get(i).getText();
			String CList = childlist.get(i).getText();
			if (PList.contains(PComp) && PList.contains(PContra)) {
				if (PList.contains(PComp) && PList.contains(PEnrol)) {
					if (PList.contains(PComp) && CList.contains(Cstaus)) {
						if (CList.contains(Cprog_proj) && CList.contains(Ctrade)) {
							List<String> Parent_AllText = new ArrayList<>();
							Parent_AllText.add(i, PList);
							List<String> Child_AllText = new ArrayList<>();
							Child_AllText.add(i, CList);
							if (Parent_AllText.contains(Child_AllText)) {
								Collections.sort(Child_AllText);
								System.out.println(Child_AllText);
								System.out.println("Parent list contains all the child list ");

							}

						}

					}
				}

			}
		}
	}

	public void getText(WebElement ele) {
		try {
			String text = ele.getText();
			System.out.println(text);
		} catch (Throwable e) {
			System.out.println("ele text is not present");
		}

	}

	// Filters by one String
	public void Filter(String elelist, String Contains_Text) {

		List<WebElement> list = BaseClass.driver.findElements(By.xpath(elelist));
		for (int i = 0; i < list.size(); i++) {
			String listtext = list.get(i).getText();
			System.out.println(listtext);
			if (listtext.contains(Contains_Text)) {
				System.out.println(Contains_Text);
				list.get(i).click();
				System.out.println("desired is selected and validated");
				break;

			}
		}
	}

	public void ListSearch(List<WebElement> list, String Contains_Text) {

		for (int i = 0; i < list.size(); i++) {
			String listtext = list.get(i).getText();
			System.out.println(listtext);
			if (listtext.contains(Contains_Text)) {
				System.out.println(Contains_Text);
				list.get(i).click();
				System.out.println("desired is selected and validated");
				break;

			}
		}
	}

	// comapre and validate
	public void Compare(WebElement ele, String Act) {
		try {
			String Exp = ele.getText();
			System.out.println(Exp + "it is the text at Comapre Method");
			if (Act.contains(Exp)) {
				System.out.println(
						"Both Act and Exp are matching as it contains" + " " + Act + "and  expected" + " " + Exp);
				// test.log(LogStatus.PASS, Act);
			} else if (Act.equalsIgnoreCase(Exp)) {
				System.out.println(
						"Both Act and Exp are matching as it contains" + " " + Act + "and  expected " + " " + Exp);
			} else {
				System.out.println("Both " + " " + Act + ":::::" + " and " + " " + Exp + ":::" + " "
						+ " are not matching at Compare Method");
			}
		} catch (Throwable e) {
			System.out.println("No such Text as the alert is not present");
		}

	}

	// If visible click

	public void Find_Click(WebElement ele) {
		try {
			if (ele.isDisplayed()) {
				ele.click();
				System.err.println(ele + "is visible to clcick");

			} else if (ele.isDisplayed()) {
				moveToElement(ele);
				System.out.println(ele + " visible or displayed  and moved to element and clicked");
			} else {
				System.out.println(ele + "  not visible or displayed to click");
			}
		} catch (Throwable e) {

			System.out.println("we are catch block as the element" + ele + "is not displayed ");
		}
	}

	// comapre and validate
	public void CompareTextandClick(WebElement ele, String Act, WebElement eleText) {

		String Exp = eleText.getText();
		if (Act.equals(Exp)) {
			System.out.println("Both Act and Exp are matching at " + eleText.getText());
		} else {
			ele.click();
			System.out.println("both are not matching and clicked to get the required options at programme ");
		}

	}

	

	// UpandDown

	public void UPDownByArrow(WebElement ele, String text) throws Throwable {

		String attribute = ele.getAttribute("class");
		System.out.println(attribute + " :::: " + "  It is the attribute of the Tag at WebElement");
		if (attribute.contains("marg-right-10 fa fa-caret-down")) {
			System.out.println("It is already down and click on it to get the elements to give input");
			ele.click();
			Thread.sleep(2000);
		} else {
			System.out.println("It is already up so need to click");
		}

	}

	// ScrollByVisibility
	public void scrollByVisibilityOfElement(WebElement ele) throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		Thread.sleep(2000);

	}

	public void scrollToTop() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		try {
			js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
			System.out.println("sccroll to the top");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Nothing to scroll top.It is already top");
		}
	}

	public void waitForElemnet(WebElement element) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	public void waitForElementTOBeClickble(WebElement element) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void scrollToEndt() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		try {
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			System.out.println("sccroll to the End");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Nothing to scroll End.It is already end");
		}
	}

	// Move to Element and click
	public void click(WebElement ele) throws Throwable {

		try {
			try {
				JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
				js.executeScript("arguments[0].scrollIntoView();", ele);
				ele.click();
			} catch (Exception e) {
				ele.click();
			}
		} catch (Exception e) {
			try {
				Actions act = new Actions(BaseClass.driver);
				act.moveToElement(ele).click().build().perform();
				System.out.println("element is clicked at try block");
			} catch (Exception e1) {
				System.out.println("no such element to click");
			}
			ele.click();
		}

	}

	// Alert click

	public void Alert_Click(WebElement ele) {
		boolean flag = false;
		try {
			Alert alert = BaseClass.driver.switchTo().alert();
			alert.accept();

		} catch (Throwable e) {
			try {
				if (ele.isDisplayed()) {
					Thread.sleep(2000);
					ele.click();
					System.out.println("Alert is not presnet but element is available to inspect and click");
					flag = true;
				} else {
					try {
						Thread.sleep(2000);
						ele.click();
					} catch (Throwable T) {
						System.out.println("ele is not displayed as the alert is an normal  present");

					}

				}
			} catch (Throwable e1) {
				System.out.println("alert and Element both are not displayed to clicked so moved to further");
			}
		}
	}

	// Find Element
	public boolean findElement(WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Throwable e) {
			// System.out.println("Location not found: "+locatorName);
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully Found element at");

			} else {
				System.out.println("Unable to locate element at");
			}
		}
		return flag;
	}

	public boolean idDisplayed(WebElement ele) {
		boolean flag = false;
		try {
			if (ele.isDisplayed()) {
				flag = true;
				System.out.println("ele is displayed ");
			} else {
				flag = false;
				System.out.println("Not able to display or find");
			}
		} catch (Throwable e) {
			System.out.println(ele.getText() + "is not present");
		} finally {
			System.out.println("elemenet is not present");
		}
		return flag;

	}

	// is Displayed
	public boolean isDisplayed(WebElement ele) {
		boolean flag = false;
		flag = findElement(ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("The element is Displayed");
			} else {
				System.out.println("The element is not Displayed");

			}
		} else {
			System.out.println("Not displayed ");
		}
		return flag;
	}

	// Element is selected or not
	public boolean isSelected(WebElement ele) {
		boolean flag = false;
		flag = findElement(ele);
		if (flag) {
			flag = ele.isSelected();
			if (flag) {
				System.out.println("The element is Selected");
			} else {
				System.out.println("The element is not Selected");
			}
		} else {
			System.out.println("Not selected ");
		}
		return flag;
	}

	// Element is enabled or not
	public boolean isEnabled(WebElement ele) {
		boolean flag = false;
		flag = findElement(ele);
		if (flag) {
			flag = ele.isEnabled();
			if (flag) {
				System.out.println("The element is Enabled");
			} else {
				System.out.println("The element is not Enabled");
			}
		} else {
			System.out.println("Not Enabled ");
		}
		return flag;
	}

	// Type to enter Text
	public boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.click();
			ele.clear();
			ele.sendKeys(text);

			flag = true;
		} catch (Throwable e) {
			System.out.println("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value");
			}

		}
		return flag;
	}

	// type by sendkey
	public boolean typeBySendkeys(String value, WebElement ele) {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			Thread.sleep(2000);
			ele.sendKeys(Keys.ENTER);
			flag = true;
			return true;
		} catch (Throwable e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Select value from the DropDown");
			} else {
				System.out.println("Not Selected value from the DropDown");
				// throw new ElementNotFoundThrowable("", "", "")
			}
		}
	}

	/**
	 * select value from DropDown by using selectByIndex
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param index       : Index of value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 * 
	 */

	public boolean selectByIndex(WebElement element, int index) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Throwable e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Index");
			} else {
				System.out.println("Option not selected by Index");
			}
		}
	}

	// Deselect

	public boolean DeselectByIndex(WebElement element, int index) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.deselectByIndex(index);
			flag = true;
			return true;
		} catch (Throwable e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option Deselected by Index");
			} else {
				System.out.println("Option not Deselected by Index");
			}
		}
	}

	/**
	 * select value from DD by using value
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param value       : Value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */

	public boolean selectByValue(WebElement element, String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Throwable e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Value");
			} else {
				System.out.println("Option not selected by Value");
			}
		}
	}

	public boolean DeselectByValue(WebElement element, String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.deselectByValue(value);
			flag = true;
			return true;
		} catch (Throwable e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Option Deselected by Value");
			} else {
				System.out.println("Option not Deselected by Value");
			}
		}
	}

	/**
	 * select value from DropDown by using selectByVisibleText
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param visibletext : VisibleText wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */

	/*public void isSelected(WebElement ele, String value) {
		Select s = new Select(ele);
		 List<WebElement> val1 = s.getOptions();
		 
		if (val1.contains(value.is) {
			
			System.out.println("value is selected");
		}else 
		{
			System.out.println("value is not selected");
		}
	}	
	*/
	
	
	public boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Throwable e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by VisibleText " + " =====>  " + visibletext);
			} else {
				System.out.println("Option not selected by VisibleText" + " =====>  " + visibletext);
			}
		}
	}

	// Deselect By visible text

	public boolean DeselectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.deselectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Throwable e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option Deselected by VisibleText" + " =====>  " + visibletext);
			} else {
				System.out.println("Option not Deselected by VisibleText" + " =====>  " + visibletext);
			}
		}
	}

	// Mouse Hover
	public boolean mouseHoverByJavaScript(WebElement ele) {
		boolean flag = false;
		try {
			WebElement mo = ele;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
		}

		catch (Throwable e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("MouseOver Action is performed");
			} else {
				System.out.println("MouseOver Action is not performed");
			}
		}
	}

	// Java Script click
	public boolean JSClick(WebElement ele) {
		boolean flag = false;
		try {

			JavascriptExecutor executor = (JavascriptExecutor) BaseClass.driver;
			executor.executeScript("arguments[0].click();", ele);
			flag = true;
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				System.out.println("Click Action is performed");
			} else if (!flag) {
				System.out.println("Click Action is not performed");
			}
		}
		return flag;
	}

	// Switch frame
	public boolean switchToFrameByIndex(int index) {
		boolean flag = false;
		try {
			new WebDriverWait(BaseClass.driver, 15)
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			BaseClass.driver.switchTo().frame(index);
			flag = true;
			return true;
		} catch (Throwable e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with index \"" + index + "\" is selected");
			} else {
				System.out.println("Frame with index \"" + index + "\" is not selected");
			}
		}
	}

	/**
	 * This method switch the to frame using frame ID.
	 * 
	 * @param idValue : Frame ID wish to switch
	 * 
	 */

	public boolean switchToFrameById(String idValue) {
		boolean flag = false;
		try {
			BaseClass.driver.switchTo().frame(idValue);
			flag = true;
			return true;
		} catch (Throwable e) {

			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Id \"" + idValue + "\" is selected");
			} else {
				System.out.println("Frame with Id \"" + idValue + "\" is not selected");
			}
		}
	}

	/**
	 * This method switch the to frame using frame Name.
	 * 
	 * @param nameValue : Frame Name wish to switch
	 * 
	 */

	public boolean switchToFrameByName(String nameValue) {
		boolean flag = false;
		try {
			BaseClass.driver.switchTo().frame(nameValue);
			flag = true;
			return true;
		} catch (Throwable e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Name " + nameValue + " is selected");
			} else if (!flag) {
				System.out.println("Frame with Name " + nameValue + " is not selected");
			}
		}
	}

	public boolean switchToDefaultFrame() {
		boolean flag = false;
		try {
			BaseClass.driver.switchTo().defaultContent();
			flag = true;
			return true;
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				// SuccessReport("SelectFrame ","Frame with Name is selected");
			} else if (!flag) {
				// failureReport("SelectFrame ","The Frame is not selected");
			}
		}
	}

	// Switch to parentWindow

	public void Switchtoparent() throws Throwable {
		Set<String> ids = BaseClass.driver.getWindowHandles();
		Object[] id = ids.toArray();
		String id1 = id[0].toString();
		Thread.sleep(2000);
		System.out.println(BaseClass.driver.getWindowHandles());
		BaseClass.driver.switchTo().window(id1);
		BaseClass.driver.manage().window().maximize();
	}

	// Switch to Childwindow1

	public void SwitchtoChild1() throws Throwable {
		Set<String> ids = BaseClass.driver.getWindowHandles();
		Object[] id = ids.toArray();
		String id2 = id[1].toString();
		Thread.sleep(2000);
		System.out.println(BaseClass.driver.getWindowHandles());
		BaseClass.driver.switchTo().window(id2);
		BaseClass.driver.manage().window().maximize();
	}

	// Switch to Childwindow2
	public void SwitchtoChild2() throws Throwable {
		Set<String> ids = BaseClass.driver.getWindowHandles();
		Object[] id = ids.toArray();
		String id3 = id[2].toString();
		Thread.sleep(2000);
		System.out.println(BaseClass.driver.getWindowHandles());
		BaseClass.driver.switchTo().window(id3);
		BaseClass.driver.manage().window().maximize();
	}

	// Switch to Childwindow3
	public void SwitchtoChild3() throws Throwable {
		Set<String> ids = BaseClass.driver.getWindowHandles();
		Object[] id = ids.toArray();
		String id4 = id[3].toString();

		try {
			Thread.sleep(2000);
			System.out.println(BaseClass.driver.getWindowHandles());
			BaseClass.driver.switchTo().window(id4);
			BaseClass.driver.manage().window().maximize();
		} catch (Throwable e) {
			System.out.println("cannot switch at id3");
		}
	}

	public void SwitchtoChild4() throws Throwable {
		Set<String> ids = BaseClass.driver.getWindowHandles();
		Object[] id = ids.toArray();
		String id5 = id[4].toString();
		try {
			Thread.sleep(2000);
			System.out.println(BaseClass.driver.getWindowHandles());
			BaseClass.driver.switchTo().window(id5);
			BaseClass.driver.manage().window().maximize();
		} catch (Throwable e) {
			System.out.println("cannot switch to id4");
		}
	}

	public void SwitchtoChild5() throws Throwable {
		Set<String> ids = BaseClass.driver.getWindowHandles();
		Object[] id = ids.toArray();
		String id6 = id[5].toString();
		Thread.sleep(2000);
		System.out.println(BaseClass.driver.getWindowHandles());
		BaseClass.driver.switchTo().window(id6);
		BaseClass.driver.manage().window().maximize();
	}

	public void WindowsOpened(String windowtitle) {
		int i = 0;
		Set<String> allwindow = BaseClass.driver.getWindowHandles();
		for (String eachwindow : allwindow) {
			BaseClass.driver.switchTo().window(eachwindow);
			System.out.println(eachwindow);
			if (eachwindow.equalsIgnoreCase(windowtitle)) {
				BaseClass.driver.switchTo().window(eachwindow);
				i--;

			}

		}
		System.out.println(i + BaseClass.driver.getTitle());
	}

	public void mouseOverElement(WebElement element) {
		boolean flag = false;
		try {
			new Actions(BaseClass.driver).moveToElement(element).build().perform();
			flag = true;
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				System.out.println(" MouserOver Action is performed on ");
			} else {
				System.out.println("MouseOver action is not performed on");
			}
		}
	}

	public boolean moveToElement(WebElement ele) {
		boolean flag = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
			js.executeScript("arguments[0].scrollIntoView();", ele);
			System.out.println("we are in try1 block to move to element ");
			try {
				Actions actions = new Actions(BaseClass.driver);
				actions.moveToElement(ele).build().perform();
				flag = true;
				System.out.println("we are at try and try block to move to element method");
			} catch (Throwable e) {
				System.out.println("Actions class is not required or unable to move to element");
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void ScrollIntoView(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println("scrolled to element with java script ");

	}

	public void ScrollIntoViewByJS( WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println("scrolled to element with java script ");

	}

	public boolean mouseover(WebElement ele) {
		boolean flag = false;
		try {
			new Actions(BaseClass.driver).moveToElement(ele).build().perform();
			flag = true;
			System.out.println(flag);
			return true;
		} catch (Throwable e) {
			return false;
		}
	}

	public boolean draggable(WebElement source, int x, int y) {
		boolean flag = false;
		try {
			new Actions(BaseClass.driver).dragAndDropBy(source, x, y).build().perform();
			Thread.sleep(5000);
			flag = true;
			return true;

		} catch (Throwable e) {

			return false;

		} finally {
			if (flag) {
				System.out.println("Draggable Action is performed on " + source + "");
			} else if (!flag) {
				System.out.println("Draggable action is not performed on " + source + "");
			}
		}
	}

	public boolean draganddrop(WebElement source, WebElement target) {
		boolean flag = false;
		try {
			new Actions(BaseClass.driver).dragAndDrop(source, target).perform();
			flag = true;
			return true;
		} catch (Throwable e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("DragAndDrop Action is performed");
			} else if (!flag) {
				System.out.println("DragAndDrop Action is not performed");
			}
		}
	}

	public boolean slider(WebElement ele, int x, int y) {
		boolean flag = false;
		try {
			new Actions(BaseClass.driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
			Thread.sleep(5000);
			flag = true;
			return true;
		} catch (Throwable e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Slider Action is performed");
			} else {
				System.out.println("Slider Action is not performed");
			}
		}
	}

	public boolean rightclick(WebElement ele) {
		boolean flag = false;
		try {
			Actions clicker = new Actions(BaseClass.driver);
			clicker.contextClick(ele).perform();
			flag = true;
			return true;
			// BaseClass.driver.findElement(by1).sendKeys(Keys.DOWN);
		} catch (Throwable e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("RightClick Action is performed");
			} else {
				System.out.println("RightClick Action is not performed");
			}
		}
	}

	public boolean switchWindowByTitle(String windowTitle, int count) {
		boolean flag = false;
		try {
			Set<String> windowList = BaseClass.driver.getWindowHandles();

			String[] array = windowList.toArray(new String[0]);

			BaseClass.driver.switchTo().window(array[count - 1]);

			if (BaseClass.driver.getTitle().contains(windowTitle)) {
				flag = true;
				try {
					BaseClass.driver.manage().window().maximize();
				} catch (Exception e) {
					System.out.println("already maximixed");
				}
			} else {
				flag = false;
			}
			return flag;
		} catch (Throwable e) {
			// flag = true;
			return false;
		} finally {
			if (flag) {
				System.out.println("Navigated to the window with title");
			} else {
				System.out.println("The Window with title is not Selected");
			}
		}
	}

	public boolean switchToOldWindow() {
		boolean flag = false;
		try {

			Set<String> s = BaseClass.driver.getWindowHandles();
			Object popup[] = s.toArray();
			BaseClass.driver.switchTo().window(popup[0].toString());
			flag = true;
			return flag;
		} catch (Throwable e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				System.out.println("Focus navigated to the window with title");
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}

	/**
	 * Verify alert present or not
	 * 
	 * @return: Boolean (True: If alert preset, False: If no alert)
	 * @throws InterruptedThrowable
	 * 
	 */

	public boolean Alert() throws Exception {
		boolean presentFlag = false;
		Alert alert = null;

		try {
			alert = BaseClass.driver.switchTo().alert();
			String AlertText = alert.getText();
			System.out.println(AlertText + "It is the text at Alert");
			Thread.sleep(2000);
			alert.accept();
			presentFlag = true;
			System.err.println("Alert is handled succesfully");
		} catch (Throwable ex) {
			ex.printStackTrace();
			System.out.println("No such alert to handle");
		} finally {
			if (!presentFlag) {
				System.out.println("The Alert is handled successfully");
			} else {
				System.out.println("There was no alert to handle");
			}
		}

		return presentFlag;
	}

	public boolean AlertDismiss() throws Exception {
		boolean presentFlag = false;
		Alert alert = null;

		try {
			alert = BaseClass.driver.switchTo().alert();
			String AlertText = alert.getText();
			System.out.println(AlertText + "It is the text at Alert");
			Thread.sleep(2000);
			alert.dismiss();
			presentFlag = true;
			System.err.println("Alert is handled succesfully");
		} catch (Throwable ex) {
			ex.printStackTrace();
			System.out.println("No such alert to handle");
		} finally {
			if (!presentFlag) {
				System.out.println("The Alert is handled successfully");
			} else {
				System.out.println("There was no alert to handle");
			}
		}

		return presentFlag;
	}

	public boolean launchUrl(String url) {
		boolean flag = false;
		try {
			BaseClass.driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Throwable e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Successfully launched " + url + "");
			} else {
				System.out.println("Failed to launch " + url + "");
			}
		}
	}

	public boolean isAlertPresent() {
		try {
			BaseClass.driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}

	public String getTitle() {
		boolean flag = false;

		String text = BaseClass.driver.getTitle();
		if (flag) {
			System.out.println("Title of the page is:" + text + "");
		}
		return text;
	}

	public String getCurrentURL() {
		boolean flag = false;

		String text = BaseClass.driver.getCurrentUrl();
		if (flag) {
			System.out.println("Current URL is: " + text + "");
		}
		return text;
	}

	public String NaviagettoURL() {

		String text = BaseClass.driver.getCurrentUrl();
		BaseClass.driver.navigate().to(text);
		return text;
	}

	public void fluentWait(WebElement element, int timeOut) {
		Wait<WebDriver> wait = null;
		try {
			wait = new FluentWait<WebDriver>((WebDriver) BaseClass.driver).withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(Throwable.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Throwable e) {
		}
	}

	public void implicitWait(int timeOut) {
		BaseClass.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void explicitWait(WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// pageLoadTimeout
	public void pageLoadTimeOut(int timeOut) {
		BaseClass.driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}

	// SetScript Timeout
	public void setScriptTimeout(int timeOut) {
		BaseClass.driver.manage().timeouts().setScriptTimeout(timeOut, TimeUnit.SECONDS);
	}

	public String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}

	// Switch to a new tab
	public void SwitchtonewTab() {

		String currentWindowHandle = BaseClass.driver.getWindowHandle();
		ArrayList<String> windowHandles = new ArrayList<String>(BaseClass.driver.getWindowHandles());
		for (String window : windowHandles) {
			if (window != currentWindowHandle) {

				BaseClass.driver.switchTo().window(window);
			}
		}
		System.out.println("Moved to second Tab");
	}

	// Switch to new tab
	public void SwitchtoMainTab() {

		String currentWindowHandle = BaseClass.driver.getWindowHandle();
		ArrayList<String> windowHandles = new ArrayList<String>(BaseClass.driver.getWindowHandles());
		for (String window : windowHandles) {
			if (currentWindowHandle != window) {

				BaseClass.driver.switchTo().window(currentWindowHandle);
			}
		}
		System.out.println("Moved to Main Tab");
	}

	public void ListOflist(List<WebElement> list, String text) {

		for (int i = 0; i < list.size(); i++) {
			String Text = list.get(i).getText();
			int TextSize = list.size();
			System.out.println(TextSize);
			System.out.println(Text + "It is the text at List of list method");
			if (list.get(i).getText().contains(text))
				list.get(i).click();
			break;
		}

	}

	// depends on change colour method
	public static void flash(WebDriver driver, WebElement element) {

		// JavascriptExecutor js = (JavascriptExecutor)driver;
		String bgcolour = element.getCssValue("backgroundColor");
		System.out.println("the background colour of element is ::::: ----->>>   " + bgcolour);
		for (int i = 0; i < 10; i++) {
			changecolour(driver, "#000000", element);
			changecolour(driver, bgcolour, element);
		}

	}

	public static void changecolour(WebDriver driver, String color, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);

	}

	public static void DrawBorder(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);

	}

	public void WebTable_Text(WebElement ele, String rowtxt1, String rowtxt2) {
		List<WebElement> cols = BaseClass.driver.findElements(By.xpath("//tbody/tr/td"));
		List<WebElement> rows = BaseClass.driver.findElements(By.xpath("//tbody/tr"));
		for (int i = 0; i < rows.size(); i++) {
			for (int j = 0; j < rows.size(); j++) {
				String rowsText = rows.get(i).getText();
				String colsText = cols.get(i).getText();
				if (rowsText.contains(rowtxt1) && colsText.contains(rowtxt2)) {
					// rows.get(i).click();
					System.out.println(rowsText);
					ele.click();
					break;
				}
			}
		}
	}

}

