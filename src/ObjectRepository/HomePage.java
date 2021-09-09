package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	// WebDriver driver;
	private static WebElement element;
	private static List<WebElement> listElement;

	// All Home Page Objects Xpaths left side bar
	static String controlMenuHomeIcon = "//li[@id='ctl00_ctrlMenu_liHome']";
	static String controlMenuDashboard = "//li[@id='ctl00_ctrlMenu_liDashboard']";
	static String controlMenuOpenActionItem = "//li[@id='ctl00_ctrlMenu_liOpenActionItems']";
	static String controlMenuPreBidContractorPackage = "//li[@id='ctl00_ctrlMenu_liPreBidContracts']";
	static String controlMenuContractorPackage = "//li[@id='ctl00_ctrlMenu_liContracts']";
	static String controlMenuContractor = "//li[@id='ctl00_ctrlMenu_liUser']";
	static String controlMenuProgram = "//li[@id='ctl00_ctrlMenu_liProjects']";
	static String controlMenuProject = "//li[@id='ctl00_ctrlMenu_liWorksites']";
	static String controlMenuLossControl = "//li[@id='ctl00_ctrlMenu_liLossControl']";
	
	static String controlMenuClaimsDashboard = "//li[@id='ctl00_ctrlMenu_liClaim']";
	static String controlMenuClaims = "//li[@id='ctl00_ctrlMenu_liClaim']//li[1]//a[1]";
	static String controlMenuInbox = "//li[@id='ctl00_ctrlMenu_liInbox']";
	
	static String controlMenuNote = "//li[@id='ctl00_ctrlMenu_liNote']";
	static String controlMenuDocuments = "//li[@id='ctl00_ctrlMenu_liDocument']";
	static String controlMenuTask = "//li[@id='ctl00_ctrlMenu_liTask']";
	static String controlMenuReports = "//li[@id='ctl00_ctrlMenu_liReports']";
	
	static String controlMenuFax = "//li[@id='ctl00_ctrlMenu_liFax']";// now not present with new design 6/7/21
	static String controlMenuCalender = "//li[@id='ctl00_ctrlMenu_liCalendar']";// now not present with new design 6/7/21
	
	// main module icons central page update the xpath by kp on jun-7-2021
	static String HomeMenuSponsors = "//a[@id='ctl00_ContentPlaceHolder1_anchorLinkOwners']";//span[@id='ctl00_ContentPlaceHolder1_spnOwner']";
	static String HomeMenuPrograms = "//a[@href='../frmProject.aspx']";//span[@id='ctl00_ContentPlaceHolder1_spnProject']";
	static String HomeMenuProjects = "//a[@id='ctl00_ContentPlaceHolder1_anchorLinkWorksites']";//span[@id='ctl00_ContentPlaceHolder1_anchorLinkWorksite']";
	static String HomeMenuContractors = "//a[@id='ctl00_ContentPlaceHolder1_anchorLinkContractor']";//span[@id='ctl00_ContentPlaceHolder1_spnContractor']";
	//new name is no-cip compliance
	static String HomeMenuComplianceCategories = "//a[@id='ctl00_ContentPlaceHolder1_anchorLinkNonCIPCompliances']";//span[@id='ctl00_ContentPlaceHolder1_spnCC']";
	static String HomeMenuDocuments = "//a[@id='ctl00_ContentPlaceHolder1_anchorLinkDocuments']";//span[@id='ctl00_ContentPlaceHolder1_spnDocuments2']";
	static String HomeMenuCertificates = "//a[@id='ctl00_ContentPlaceHolder1_anchorLinkCIPCertificates']";//label[contains(text(),'Certificates')]/..";
	static String HomeMenuPayroll = "//a[@id='ctl00_ContentPlaceHolder1_anchorLinkPayroll']";//label[contains(text(),'Payroll')]/..";
	static String HomeMenuChangeOrders = "//a[@id='ctl00_ContentPlaceHolder1_anchorLinkChangeOrder']";//label[contains(text(),'Change Orders')]/..";
	static String HomeMenuClaims = "//a[@id='ctl00_ContentPlaceHolder1_anchorLinkClaims']";//label[contains(text(),'Claims')]/..";
	static String HomeMenuLossControl = "//a[@id='ctl00_ContentPlaceHolder1_anchorLinkLossControl']";//label[contains(text(),'Loss Control')]/..";
	static String HomeMenuCompletionNotice = "//a[@id='ctl00_ContentPlaceHolder1_anchorLinkCompletionNotice']";//span[@id='ctl00_ContentPlaceHolder1_spnCN']";
	static String HomeMenuReports = "//a[@id='ctl00_ContentPlaceHolder1_anchorLinkReport']";//label[contains(text(),'Reports')]/..";

	
	 static String HomeMenuHelp = "//a[text()='Help']";
	    static String HomeMenuSettings = "//a[text()='Settings']";//profile setting dropdown
	    static String userProfileIcon ="//img[@id='ctl00_ctrlHeader_imgUserProfileLogo']";
	    static String HomeMenuLogoutBtn = "//a[text()='Logout']";
	    

	
	
	//below module is not present with new design 7-jun-2021
	static String HomeMenuDistrict = "//span[@id='ctl00_ContentPlaceHolder1_spnDistrict']";
	static String HomeMenuContractDetails = "//label[contains(text(),'Contract Details')]/..";
	static String HomeMenuContractorPackage = "//a[@id='ctl00_ContentPlaceHolder1_anchorLinkContracts']";
	static String HomeMenuInsuranceEnrollment = "//a[@id='ctl00_ContentPlaceHolder1_anchorLinkInsuranceEnrollment']";
	static String HomeMenuTrade = "//a[@id='ctl00_ContentPlaceHolder1_aTrade']";
	static String HomeMenuWorkClass = "//a[@id='ctl00_ContentPlaceHolder1_aWorkClass']";
	static String HomeMenuTask = "//span[@id='ctl00_ContentPlaceHolder1_spnTasks']";
	static String HomeMenuNotes = "//span[@id='ctl00_ContentPlaceHolder1_spnNotes']";
	static String HomeMenuColorCategories = "//span[@id='ctl00_ContentPlaceHolder1_spnColor']";
	static String HomeMenuEmails ="//a[@id='ctl00_ContentPlaceHolder1_aEmails']//img";
	static String HomeMenuFaxes ="//a[@id='ctl00_ContentPlaceHolder1_aFaxs']";
	
	
	//Most Frequently Used Modules new feature xpath added by kp 07/jun/2021
	static String freqContractorPackage ="//a[@id='ctl00_ContentPlaceHolder1_mostFrequentlyUsedModuleContracts']";
	static String freqContractor ="//a[@id='ctl00_ContentPlaceHolder1_mostFrequentlyUsedModuleContractors']";
	static String freqReport ="//a[@id='ctl00_ContentPlaceHolder1_mostFrequentlyUsedModuleReports']";
	static String freqProgram ="//a[@id='ctl00_ContentPlaceHolder1_mostFrequentlyUsedModuleProjects']";
	static String freqProject ="//a[@id='ctl00_ContentPlaceHolder1_mostFrequentlyUsedModuleWorksites']";
	
	//Search bar functionality 06/07/2021
	static String mainsearchBar ="//input[@id='tags']";
	static String mainsearchBarDeleteIcon ="//i[@id='delete-icon']";
	static String mainsearchBarSearchIcon ="//i[@id='delete-icon']";
	static String mainsearchBarDropDownResultViaCP_ID ="//div[@class='advance-search-main']/div/div/a/div[2]/div[contains(text(),'pcode1234564-pcode1245454CONTRACTOR_PKG_NO27585')]";//list
	//filter by functionality 06/07/2021
	static String filterByContractorpkg ="//a[@id='Contracts']";
	static String filterByContractor ="//a[@id='Contractors']";
	static String filterByPrograms ="//span[@id='ctl00_ContentPlaceHolder1_lblProjects']";
	static String filterByProjects ="//span[@id='ctl00_ContentPlaceHolder1_lblWorksites']";

	//	static String HomeMenuProfileIcon = "//img[@id='ctl00_ctrlHeader_imgAvatars']";
//	static String HomeMenuLogoutBtn = "//a[text()='Logout']";
	static String HomePageAllToolTips ="//*[@data-original-title]";//new design option not present
	
	
	//-----------------------------Neha start----------------------------
			static String HomeMenuEmail_Sent ="//li/a[contains(text(),'Sent')]";
			static String SearchEmailFeild ="//input[@id='ctl00_ContentPlaceHolder1_ctrlEmailList_txtSearch']";
			static String SearchBtn ="//i[@class='fa fa-search']";
			static String AdvanceSearchBtn ="//i[@class='fa fa-caret-down']";
			static String EmailPreviewPanelFrame ="//iframe[@id='ifrmPreview']";
			static String EmailPreviewPanelToFeild ="//table/tbody/tr/td/a[@target='_blank']";
			static String controlMenuEmailIcon = "//a[@onclick='GetInboxFolderDetails(1);']";
			static String PreBidContractorPackageIcon= "//a[@id='ctl00_ctrlMenu_aPostCP']//span[@class='icon']";
			static String ClaimsIcon = "//a[@href='../frmClaimList.aspx']//span[@class='icon']";
			static String NotesIcon = "//a[@href='../frmNote.aspx']//span[@class='icon']";
			static String DocumentsIcon = "//a[@href='../frmDocument.aspx']//span[@class='icon']";
			static String TradesIcon = "//img[@src='images/map/trades.png']";
			static String DistrictIcon = "//img[@src='images/map/division.png']";
			
			static String ContractorPackagePreviewPanelFrame= "//iframe[@id='ifrmPreview']";
			//static String TrackCompliance="//div[@class='contractorstep1 clearfix']//div//a[contains(text()";

			
			 public static WebElement TradesIcon(WebDriver driver) {
			element = driver.findElement(By.xpath(TradesIcon));
			return element;
			}
			 
			 public static WebElement DistrictIcon(WebDriver driver) {
			element = driver.findElement(By.xpath(DistrictIcon));
			return element;
			}
			
			 public static WebElement PreBidContractorPackageIcon(WebDriver driver) {
			element = driver.findElement(By.xpath(PreBidContractorPackageIcon));
			return element;
			}
			 
			 public static WebElement DocumentsIcon(WebDriver driver) {
			element = driver.findElement(By.xpath(DocumentsIcon));
			return element;
			}
			 
			 public static WebElement NotesIcon(WebDriver driver) {
			element = driver.findElement(By.xpath(NotesIcon));
			return element;
			}
			 
			 public static WebElement ClaimsIcon(WebDriver driver) {
			element = driver.findElement(By.xpath(ClaimsIcon));
			return element;
			}
			
			public static WebElement controlMenuEmailIcon(WebDriver driver) {
			element = driver.findElement(By.xpath(controlMenuEmailIcon));
			return element;
			}
			
			public static WebElement HomeMenuEmail_Sent(WebDriver driver) {
				element = driver.findElement(By.xpath(HomeMenuEmail_Sent));
				return element;
			}
			
			public static WebElement SearchEmailFeild(WebDriver driver) {
				element = driver.findElement(By.xpath(SearchEmailFeild));
				return element;
			}
			public static WebElement AdvanceSearchBtn(WebDriver driver) {
				element = driver.findElement(By.xpath(AdvanceSearchBtn));
				return element;
			}
			
			public static WebElement EmailPreviewPanelFrame(WebDriver driver) {
				element = driver.findElement(By.xpath(EmailPreviewPanelFrame));
				return element;
			}
			public static WebElement EmailPreviewPanelToFeild(WebDriver driver) {
				element = driver.findElement(By.xpath(EmailPreviewPanelToFeild));
				return element;
			}

			
			public static WebElement ContractorPackagePreviewPanelFrame(WebDriver driver) {
				element = driver.findElement(By.xpath(ContractorPackagePreviewPanelFrame));
				return element;
			}
			



			
			//----------------------------------Neha End------------------------------------------------
		    public static WebElement HomeMenuLogoutBtn(WebDriver driver) {
				element = driver.findElement(By.xpath(HomeMenuLogoutBtn));
				return element;
				}	
	
	public static WebElement userProfileIcon(WebDriver driver) {
		element = driver.findElement(By.xpath(userProfileIcon));
		return element;
	}
	
	
	public static WebElement freqContractorPackage(WebDriver driver) {
		element = driver.findElement(By.xpath(freqContractorPackage));
		return element;
	}

	public static WebElement freqContractor(WebDriver driver) {
		element = driver.findElement(By.xpath(freqContractor));
		return element;
	}

	public static WebElement freqReport(WebDriver driver) {
		element = driver.findElement(By.xpath(freqReport));
		return element;
	}

	public static WebElement freqProgram(WebDriver driver) {
		element = driver.findElement(By.xpath(freqProgram));
		return element;
	}

	public static WebElement freqProject(WebDriver driver) {
		element = driver.findElement(By.xpath(freqProject));
		return element;
	}

	public static WebElement mainsearchBar(WebDriver driver) {
		element = driver.findElement(By.xpath(mainsearchBar));
		return element;
	}

	public static WebElement mainsearchBarDeleteIcon(WebDriver driver) {
		element = driver.findElement(By.xpath(mainsearchBarDeleteIcon));
		return element;
	}

	public static WebElement mainsearchBarSearchIcon(WebDriver driver) {
		element = driver.findElement(By.xpath(mainsearchBarSearchIcon));
		return element;
	}

	public static WebElement mainsearchBarDropDownResultViaCP_ID(WebDriver driver, String contractorPkgID) {
		element = driver.findElement(By.xpath("//div[@class='advance-search-main']/div/div/a/div[2]/div[contains(text(),'"+contractorPkgID+"')]"));
		return element;
		//you will get only one value or some time you will get two cp id if duplicate is present that time need to go with list 
	}

	public static WebElement filterByContractorpkg(WebDriver driver) {
		element = driver.findElement(By.xpath(filterByContractorpkg));
		return element;
	}

	public static WebElement filterByContractor(WebDriver driver) {
		element = driver.findElement(By.xpath(filterByContractor));
		return element;
	}

	public static WebElement filterByPrograms(WebDriver driver) {
		element = driver.findElement(By.xpath(filterByPrograms));
		return element;
	}

	public static WebElement filterByProjects(WebDriver driver) {
		element = driver.findElement(By.xpath(filterByProjects));
		return element;
	}
	
	
	
	
	
	
	
	
	
	
	public static List<WebElement> HomePageAllToolTips(WebDriver driver) {
		listElement = driver.findElements(By.xpath(HomePageAllToolTips));
		return listElement;
	}
	
	public static WebElement HomeMenuFaxes(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuFaxes));
		return element;
	}
	public static WebElement HomeMenuEmails(WebDriver driver) 
	{
		element = driver.findElement(By.xpath(HomeMenuEmails));
		return element;
	}
	
	public static WebElement controlMenuHomeIcon(WebDriver driver)// left side Home icon
	{
		element = driver.findElement(By.xpath(controlMenuHomeIcon));
		return element;
	}

	public static WebElement controlMenuDashboard(WebDriver driver)// left side
																	// Dashboard
																	// icon
	{
		element = driver.findElement(By.xpath(controlMenuDashboard));
		return element;
	}

	public static WebElement controlMenuOpenActionItem(WebDriver driver)// left
																		// side
																		// Open
																		// Action
																		// Item
																		// icon/
	{
		element = driver.findElement(By.xpath(controlMenuOpenActionItem));
		return element;
	}

	public static WebElement controlMenuPreBidContractorPackage(WebDriver driver)// left
																					// side
																					// Open
																					// Action
																					// Item
																					// icon
	{
		element = driver.findElement(By.xpath(controlMenuPreBidContractorPackage));
		return element;
	}

	public static WebElement controlMenuContractorPackage(WebDriver driver) {
		element = driver.findElement(By.xpath(controlMenuContractorPackage));
		return element;
	}

	public static WebElement controlMenuContractor(WebDriver driver) {
		element = driver.findElement(By.xpath(controlMenuContractor));
		return element;
	}

	public static WebElement controlMenuProgram(WebDriver driver) {
		element = driver.findElement(By.xpath(controlMenuProgram));
		return element;
	}

	public static WebElement controlMenuProject(WebDriver driver) {
		element = driver.findElement(By.xpath(controlMenuProject));
		return element;
	}

	public static WebElement controlMenuLossControl(WebDriver driver) {
		element = driver.findElement(By.xpath(controlMenuLossControl));
		return element;
	}

	public static WebElement controlMenuClaimsDashboard(WebDriver driver) {
		element = driver.findElement(By.xpath(controlMenuClaimsDashboard));
		return element;
	}

	public static WebElement controlMenuClaims(WebDriver driver) {
		element = driver.findElement(By.xpath(controlMenuClaims));
		return element;
	}

	public static WebElement controlMenuInbox(WebDriver driver) {
		element = driver.findElement(By.xpath(controlMenuInbox));
		return element;
	}

	public static WebElement controlMenuFax(WebDriver driver) {
		element = driver.findElement(By.xpath(controlMenuFax));
		return element;
	}

	public static WebElement controlMenuNote(WebDriver driver) {
		element = driver.findElement(By.xpath(controlMenuNote));
		return element;
	}

	public static WebElement controlMenuDocuments(WebDriver driver) {
		element = driver.findElement(By.xpath(controlMenuDocuments));
		return element;
	}

	public static WebElement controlMenuTask(WebDriver driver) {
		element = driver.findElement(By.xpath(controlMenuTask));
		return element;
	}

	public static WebElement controlMenuCalender(WebDriver driver) {
		element = driver.findElement(By.xpath(controlMenuCalender));
		return element;
	}

	public static WebElement controlMenuReports(WebDriver driver) {
		element = driver.findElement(By.xpath(controlMenuReports));
		return element;
	}

	public static WebElement HomeMenuSponsors(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuSponsors));
		return element;
	}

	public static WebElement HomeMenuPrograms(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuPrograms));
		return element;
	}

	public static WebElement HomeMenuProjects(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuProjects));
		return element;
	}

	public static WebElement HomeMenuContractors(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuContractors));
		return element;
	}

	public static WebElement HomeMenuHelp(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuHelp));
		return element;
	}

	public static WebElement HomeMenuSettings(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuSettings));
		return element;
	}

	public static WebElement HomeMenuDistrict(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuDistrict));
		return element;
	}

	public static WebElement HomeMenuContractorPackage(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuContractorPackage));
		return element;
	}

	public static WebElement HomeMenuInsuranceEnrollment(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuInsuranceEnrollment));
		return element;
	}

	public static WebElement HomeMenuContractDetails(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuContractDetails));
		return element;
	}

	public static WebElement HomeMenuDocuments(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuDocuments));
		return element;
	}

	public static WebElement HomeMenuPayroll(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuPayroll));
		return element;
	}

	public static WebElement HomeMenuCertificates(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuCertificates));
		return element;
	}

	public static WebElement HomeMenuChangeOrders(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuChangeOrders));
		return element;
	}

	public static WebElement HomeMenuClaims(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuClaims));
		return element;
	}

	public static WebElement HomeMenuLossControl(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuLossControl));
		return element;
	}

	public static WebElement HomeMenuCompletionNotice(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuCompletionNotice));
		return element;
	}

	public static WebElement HomeMenuReports(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuReports));
		return element;
	}

	public static WebElement HomeMenuWorkClass(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuWorkClass));
		return element;
	}

	public static WebElement HomeMenuTrade(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuTrade));
		return element;
	}

	public static WebElement HomeMenuComplianceCategories(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuComplianceCategories));
		return element;
	}

	public static WebElement HomeMenuTask(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuTask));
		return element;
	}

	public static WebElement HomeMenuNotes(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuNotes));
		return element;
	}

	public static WebElement HomeMenuColorCategories(WebDriver driver) {
		element = driver.findElement(By.xpath(HomeMenuColorCategories));
		return element;
	}

}
