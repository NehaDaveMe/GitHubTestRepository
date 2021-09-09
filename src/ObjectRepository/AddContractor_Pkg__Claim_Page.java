package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddContractor_Pkg__Claim_Page {

	public static WebElement element;
	public static List<WebElement> listElement;

	// Contractore package Selection Xpaths

	static String ContractorPackage_ICon = "//span[@id='ctl00_ContentPlaceHolder1_spnCP']//a[@id='ctl00_ContentPlaceHolder1_aCP']";
	static String AdvancesearchICon = "//a/i[@class='fa fa-caret-down']"; // a[@class='tipB']//i[@class='fa
																			// fa-caret-down']";
	static String SelectProgramme = "//select[@id='ctl00_ContentPlaceHolder1_cntrlContractorList_ddlProject']";
	static String SelectTrade = "//input[@id='token-input-ctl00_ContentPlaceHolder1_cntrlContractorList_txtTradePackages']";
	static String SelectProject = "//select[@id='ctl00_ContentPlaceHolder1_cntrlContractorList_ddlWorkSite']";
	static String EnrollmentType = "//select[@id='ctl00_ContentPlaceHolder1_cntrlContractorList_ddlEnrollmentType']";
	static String SearchByContractor = "//input[@id='token-input-ctl00_ContentPlaceHolder1_cntrlContractorList_txt_Contractor']";
	static String EditBtn = "//a[@class='tipB']//i[@class='fa fa-pencil-square-o']";
	static String Advance_SearchBtn_DOwn = "//input[@id='btnAdvanceSearch']";
	static String Claim_frame = "//iframe[@id='ifrmPreview']"; // "ifrmPreview";
	static String Claims_Link = "//a[@id='aClaim']";
	static String ClaimFramePreviewBtn = "_iframe-ClaimSearch"; // iframe[@name='_iframe-ClaimSearch']";
	static String Radiobtn = "//input[@id='rptContractor_ctl00_rdoSelect']";

	// ClaimsInfo

	// static String ClaimInfo_ClaimDate =
	// "//input[@id='cntrlClaim_txtClaimDate']";
	// static String ClaimInfo_Claim_Number =
	// "//input[@id='cntrlClaim_txtClaimNumber']";
	// static String ClaimInfo_Policy_Number =
	// "//input[@id='cntrlClaim_txtPolicyNumber']";
	// static String ClaimInfo_Claim_Status =
	// "//select[@id='cntrlClaim_ddlClaimStatus']";
	// static String ClaimInfo_claim_Type =
	// "//select[@id='cntrlClaim_ddlClaimType']";
	// static String claimInfo_Claim_Specific_Class_code =
	// "//select[@id='cntrlClaim_ddlClassCode']";
	// static String ClaimInfo_ReportDate =
	// "//input[@id='cntrlClaim_txtReportDate']";
	// static String ClaimInfo_Closed_Date =
	// "//input[@id='cntrlClaim_txtClosedDate']";
	// static String ClaimInfo_Primary_Physician_Used =
	// "//input[@id='cntrlClaim_txtPrimaryPhysicianUsed']";
	// static String ClaimInfo_Loss_Date =
	// "//input[@id='cntrlClaim_txtLosDate']";
	// static String ClaimInfo_Loss_Time =
	// "//input[@id='cntrlClaim_txtLossTime']";
	// static String ClaimInfo_Loss_code =
	// "//input[@id='cntrlClaim_txtLossCode']";
	// static String ClaimInfo_Incident_Reported_by_Name =
	// "//input[@id='cntrlClaim_txtIncidentReportedByName']";
	// static String ClaimInfo_Incident_Reported_by_Email =
	// "//input[@id='cntrlClaim_txtIncidentReportedByEmail']";
	// static String ClaimInfo_Incident_Reported_by_phone =
	// "//input[@id='cntrlClaim_txtIncidentReportedByPhone']";
	// static String ClaimInfo_Loss_Days =
	// "//input[@id='cntrlClaim_txtLostDays']";
	// static String ClaimInfo_partofBody =
	// "//input[@id='cntrlClaim_txtPartOfBody']";
	// static String ClaimInfo_Nature_of_Injury =
	// "//input[@id='cntrlClaim_txtNatureInjury']";
	// static String ClaimInfo_MedicalAttention =
	// "//select[@id='cntrlClaim_ddlMedicalAttention']";
	// static String ClaimInfo_Weather_Condition =
	// "//span[contains(text(),'Weather Condition')]";
	// static String Claiminfo_Preventable_measures =
	// "//input[@id='cntrlClaim_txtPreventableMeasures']";
	// static String ClaimInfo_Claim_Description =
	// "//textarea[@id='cntrlClaim_txtClaimDescription']";
	// static String ClaimInfo_Cause = "//textarea[@id='cntrlClaim_txtCause']";

	// Claimant Information tabs

	// static String ClaimantInfo_Claimant_Name =
	// "//input[@id='cntrlClaim_txtClaimantName']";
	// static String ClaimantInfo_Job_Title =
	// "//input[@id='cntrlClaim_txtClaimantJobTitle']";
	// static String ClaimantInfo_Claimant_Social_Security_Number =
	// "//input[@id='cntrlClaim_txtSocialSecurityNumber']";
	// static String ClaimantInfo_ClaimantAddress_1 =
	// "//input[@id='cntrlClaim_txtClaimantAddress1']";
	// static String ClaimantInfo_ClaimantAddress_2 =
	// "//input[@id='cntrlClaim_txtClaimantAddress2']";
	// static String ClaimantInfo_ClaiamnatCity =
	// "//input[@id='cntrlClaim_txtClaimantCity']";
	// static String ClaiamantInfo_Claimant_Country =
	// "//select[@id='cntrlClaim_ddlCountry']";
	// static String ClaimantInfo_Claimant_State =
	// "//select[@id='cntrlClaim_ddlState']";
	// static String ClaimantInfo_Claimant_ZIP =
	// "//input[@id='cntrlClaim_txtClaimantZip']";
	// static String ClaimantInfo_Claimant_Date_Of_Birth =
	// "//input[@id='cntrlClaim_txtDateOfBirth']";
	// static String ClaimantInfo_Claimant_Date_Of_Hire =
	// "//input[@id='cntrlClaim_txtDateOfHire']";
	// static String ClaimantInfo_Claimant_Phone =
	// "//input[@id='cntrlClaim_txtClaimantPhone']";
	// static String ClaimantInfo_Claimant_Phone_PlusBtn =
	// "//button[@class='add_contact_button btn btn-success']";
	// static String ClaimantInfo_Claimant_Gender =
	// "//select[@id='cntrlClaim_ddlGender']";
	// static String ClaimantInfo_Claimant_Martial_Status =
	// "//select[@id='cntrlClaim_ddlMaritalStatus']";
	// static String ClaimantInfo_ClaimantPhone_HomeDropdown
	// ="//select[@id='ddlContactStaticTypeNew0']";
	// static String ClaimantInfo_ClaimantPhone_HomeDropdown_telephone
	// ="//input[@id='txtContact0']";
	// // Other Information tabs
	//
	// static String Other_Info_Prepared_by_First_Name =
	// "//input[@id='cntrlClaim_txtPreparedByFirstName']";
	// static String Other_Info_Prepared_by_Last_Name =
	// "//input[@id='cntrlClaim_txtPreparedByLastName']";
	// static String Other_Info_Prepared_by_Email =
	// "//input[@id='cntrlClaim_txtPreparedByEmail']";
	// static String Other_Info_Prepared_by_Telephone =
	// "//input[@id='cntrlClaim_txtPreparedByTelephone']";
	//
	// // Financial Data tabs
	//
	// static String Financial_Data_Insurer_OS_Medical_BI_Comp =
	// "//input[@id='cntrlClaim_txtIns_OS_Med_BI_Comp']";
	// static String Financial_Data_Insurer_Paid_Medical_BI_Comp =
	// "//input[@id='cntrlClaim_txtIns_Paid_Med_BI_Comp']";
	// static String Financial_Data_Recovery_Received_Medical_BI_Comp =
	// "//input[@id='cntrlClaim_txtRecovery_Rec_Med_BI_Comp']";
	// static String Financial_Data_Insurer_OS_Indemnity_PD_Collp =
	// "//input[@id='cntrlClaim_txtIns_OS_Indemnity_PD_Coll']";
	// static String Financial_Data_Insurer_Paid_Indemnity_PD_Coll =
	// "//input[@id='cntrlClaim_txtIns_Paid_Indemnity_PD_Coll']";
	// static String Financial_Data_Recovery_Received_Indemnity_PD_Coll =
	// "//input[@id='cntrlClaim_txtRecovery_Rec_Indemnity_PD_Coll']";
	// static String Financial_Data_Insurer_OS_Expense =
	// "//input[@id='cntrlClaim_txtIns_OS_Expense']";
	// static String Financial_Data_Insurer_paid_Expense =
	// "//input[@id='cntrlClaim_txtIns_Paid_Expense']";
	// static String Financial_Data_RecoveryReceived_Expense =
	// "//input[@id='cntrlClaim_txtRecovery_Rec_Expense']";
	// static String Financial_Data_Insurer_OS_Legal =
	// "//input[@id='cntrlClaim_txtIns_OS_Legal']";
	// static String Financial_Data_Insurer_paid_legal =
	// "//input[@id='cntrlClaim_txtIns_Paid_Legal']";
	// static String Financial_Data_Net_Paid_Total =
	// "//input[@id='cntrlClaim_txtNet_Insurred_Total']";
	// static String Financial_Data_Claim_Amount =
	// "//input[@id='cntrlClaim_txtClaimAmount']";

	// // Reviwe Admin tab
	//
	// static String Review_Admin_Markas_Confirm =
	// "//input[@id='cntrlClaim_chkConfirm']";
	// static String Review_Admin_Action_Notes =
	// "//textarea[@id='cntrlClaim_txtActionNotes']";
	//
	// // save ,save and close and close buttons
	//
	// static String SaveBtn_ClaimsTab = "//input[@id='cntrlClaim_btnSave']";
	// static String SaveandCloseBtn_ClaimsTab =
	// "//input[@id='cntrlClaim_btnSaveandClose']";
	// static String CloseBtn_ClaimsTab = "//button[@class='btn']";
	//
	//
	// // Alert Messages ----ClaimInfo
	//
	// static String ErrorMessage_ClaimInfo_ClaimDate =
	// "//label[contains(text(),'This field is required.')]";
	// static String ErrorMessage_ClaimInfo_Loss_Date
	// ="//label[@for='cntrlClaim_txtLosDate']";
	// static String ErrorMessage_ClaimInfo_ClaimDescription
	// ="//label[@for='cntrlClaim_txtClaimDescription']";
	//
	// // Alert Messages_ClaimantInfo
	//
	// static String ErrorMessage_ClaimantInfo_Claimant_Name
	// ="//label[@for='cntrlClaim_txtClaimantName']";
	//
	//// --------------------------------------------------------------------------------------------------------------------------------------------
	//
	// public static WebElement
	// ClaimantInfo_ClaimantPhone_HomeDropdown_telephone(WebDriver driver) {
	// element =
	// driver.findElement(By.id(ClaimantInfo_ClaimantPhone_HomeDropdown_telephone));
	// return element;
	// }
	// public static WebElement
	// ClaimantInfo_ClaimantPhone_HomeDropdown(WebDriver driver) {
	// element =
	// driver.findElement(By.id(ClaimantInfo_ClaimantPhone_HomeDropdown));
	// return element;
	// }
	//
	//
	// public static WebElement
	// ErrorMessage_ClaimantInfo_Claimant_Name(WebDriver driver) {
	// element =
	// driver.findElement(By.id(ErrorMessage_ClaimantInfo_Claimant_Name));
	// return element;
	// }
	// public static WebElement
	// ErrorMessage_ClaimInfo_ClaimDescription(WebDriver driver) {
	// element =
	// driver.findElement(By.id(ErrorMessage_ClaimInfo_ClaimDescription));
	// return element;
	// }
	// public static WebElement ErrorMessage_ClaimInfo_Loss_Date(WebDriver
	// driver) {
	// element = driver.findElement(By.id(ErrorMessage_ClaimInfo_Loss_Date));
	// return element;
	// }
	// public static WebElement ErrorMessage_ClaimInfo_ClaimDate(WebDriver
	// driver) {
	// element = driver.findElement(By.id(ErrorMessage_ClaimInfo_ClaimDate));
	// return element;
	// }

	public static WebElement Claims_Link(WebDriver driver) {
		element = driver.findElement(By.xpath(Claims_Link));
		return element;
	}

	public static WebElement Claim_frame(WebDriver driver) {
		element = driver.findElement(By.xpath(Claim_frame));
		return element;
	}

	public static WebElement ClaimFramePreviewBtn(WebDriver driver) {
		element = driver.findElement(By.name(ClaimFramePreviewBtn));
		return element;
	}

	public static WebElement EditBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(EditBtn));
		return element;
	}

	public static WebElement ContractorPackage_ICon(WebDriver driver) {
		element = driver.findElement(By.xpath(ContractorPackage_ICon));
		return element;
	}

	public static WebElement AdvancesearchICon(WebDriver driver) {
		element = driver.findElement(By.xpath(AdvancesearchICon));
		return element;
	}

	public static WebElement SelectProgramme(WebDriver driver) {
		element = driver.findElement(By.xpath(SelectProgramme));
		return element;
	}

	public static WebElement SelectTrade(WebDriver driver) {
		element = driver.findElement(By.xpath(SelectTrade));
		return element;
	}

	public static WebElement SelectProject(WebDriver driver) {
		element = driver.findElement(By.xpath(SelectProject));
		return element;
	}

	public static WebElement EnrollmentType(WebDriver driver) {
		element = driver.findElement(By.xpath(EnrollmentType));
		return element;
	}

	public static WebElement SearchByContractor(WebDriver driver) {
		element = driver.findElement(By.xpath(SearchByContractor));
		return element;
	}

	public static WebElement Advance_SearchBtn_DOwn(WebDriver driver) {
		element = driver.findElement(By.xpath(Advance_SearchBtn_DOwn));
		return element;
	}

	public static WebElement Radiobtn(WebDriver driver) {
		element = driver.findElement(By.xpath(Radiobtn));
		return element;
	}

	//
	// public static WebElement ClaimInfo_ClaimDate(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_ClaimDate));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_Claim_Number(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_Claim_Number));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_Policy_Number(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_Policy_Number));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_Claim_Status(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_Claim_Status));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_claim_Type(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_claim_Type));
	// return element;
	// }
	//
	// public static WebElement claimInfo_Claim_Specific_Class_code(WebDriver
	// driver) {
	// element =
	// driver.findElement(By.xpath(claimInfo_Claim_Specific_Class_code));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_ReportDate(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_ReportDate));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_Closed_Date(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_Closed_Date));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_Primary_Physician_Used(WebDriver
	// driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_Primary_Physician_Used));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_Loss_Date(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_Loss_Date));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_Loss_Time(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_Loss_Time));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_Loss_code(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_Loss_code));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_Incident_Reported_by_Name(WebDriver
	// driver) {
	// element =
	// driver.findElement(By.xpath(ClaimInfo_Incident_Reported_by_Name));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_Incident_Reported_by_Email(WebDriver
	// driver) {
	// element =
	// driver.findElement(By.xpath(ClaimInfo_Incident_Reported_by_Email));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_Incident_Reported_by_phone(WebDriver
	// driver) {
	// element =
	// driver.findElement(By.xpath(ClaimInfo_Incident_Reported_by_phone));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_Loss_Days(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_Loss_Days));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_partofBody(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_partofBody));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_Nature_of_Injury(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_Nature_of_Injury));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_MedicalAttention(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_MedicalAttention));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_Weather_Condition(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_Weather_Condition));
	// return element;
	// }
	//
	// public static WebElement Claiminfo_Preventable_measures(WebDriver driver)
	// {
	// element = driver.findElement(By.xpath(Claiminfo_Preventable_measures));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_Claim_Description(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_Claim_Description));
	// return element;
	// }
	//
	// public static WebElement ClaimInfo_Cause(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimInfo_Cause));
	// return element;
	// }
	//
	// public static WebElement ClaimantInfo_Claimant_Name(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimantInfo_Claimant_Name));
	// return element;
	// }
	//
	// public static WebElement ClaimantInfo_Job_Title(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimantInfo_Job_Title));
	// return element;
	// }
	//
	// public static WebElement
	// ClaimantInfo_Claimant_Social_Security_Number(WebDriver driver) {
	// element =
	// driver.findElement(By.xpath(ClaimantInfo_Claimant_Social_Security_Number));
	// return element;
	// }
	//
	// public static WebElement ClaimantInfo_ClaimantAddress_1(WebDriver driver)
	// {
	// element = driver.findElement(By.xpath(ClaimantInfo_ClaimantAddress_1));
	// return element;
	// }
	//
	// public static WebElement ClaimantInfo_ClaimantAddress_2(WebDriver driver)
	// {
	// element = driver.findElement(By.xpath(ClaimantInfo_ClaimantAddress_2));
	// return element;
	// }
	//
	// public static WebElement ClaimantInfo_ClaiamnatCity(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimantInfo_ClaiamnatCity));
	// return element;
	// }
	//
	// public static WebElement ClaiamantInfo_Claimant_Country(WebDriver driver)
	// {
	// element = driver.findElement(By.xpath(ClaiamantInfo_Claimant_Country));
	// return element;
	// }
	//
	// public static WebElement ClaimantInfo_Claimant_State(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimantInfo_Claimant_State));
	// return element;
	// }
	//
	// public static WebElement ClaimantInfo_Claimant_ZIP(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimantInfo_Claimant_ZIP));
	// return element;
	// }
	//
	// public static WebElement ClaimantInfo_Claimant_Date_Of_Birth(WebDriver
	// driver) {
	// element =
	// driver.findElement(By.xpath(ClaimantInfo_Claimant_Date_Of_Birth));
	// return element;
	// }
	//
	// public static WebElement ClaimantInfo_Claimant_Date_Of_Hire(WebDriver
	// driver) {
	// element =
	// driver.findElement(By.xpath(ClaimantInfo_Claimant_Date_Of_Hire));
	// return element;
	// }
	//
	// public static WebElement ClaimantInfo_Claimant_Phone(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimantInfo_Claimant_Phone));
	// return element;
	// }
	//
	// public static WebElement ClaimantInfo_Claimant_Phone_PlusBtn(WebDriver
	// driver) {
	// element =
	// driver.findElement(By.xpath(ClaimantInfo_Claimant_Phone_PlusBtn));
	// return element;
	// }
	//
	// public static WebElement ClaimantInfo_Claimant_Gender(WebDriver driver) {
	// element = driver.findElement(By.xpath(ClaimantInfo_Claimant_Gender));
	// return element;
	// }
	//
	// public static WebElement ClaimantInfo_Claimant_Martial_Status(WebDriver
	// driver) {
	// element =
	// driver.findElement(By.xpath(ClaimantInfo_Claimant_Martial_Status));
	// return element;
	// }
	//
	// public static WebElement Other_Info_Prepared_by_First_Name(WebDriver
	// driver) {
	// element =
	// driver.findElement(By.xpath(Other_Info_Prepared_by_First_Name));
	// return element;
	// }
	//
	// public static WebElement Other_Info_Prepared_by_Last_Name(WebDriver
	// driver) {
	// element = driver.findElement(By.xpath(Other_Info_Prepared_by_Last_Name));
	// return element;
	// }
	//
	// public static WebElement Other_Info_Prepared_by_Email(WebDriver driver) {
	// element = driver.findElement(By.xpath(Other_Info_Prepared_by_Email));
	// return element;
	// }
	//
	// public static WebElement Other_Info_Prepared_by_Telephone(WebDriver
	// driver) {
	// element = driver.findElement(By.xpath(Other_Info_Prepared_by_Telephone));
	// return element;
	// }
	//
	// public static WebElement
	// Financial_Data_Insurer_OS_Medical_BI_Comp(WebDriver driver) {
	// element =
	// driver.findElement(By.xpath(Financial_Data_Insurer_OS_Medical_BI_Comp));
	// return element;
	// }
	//
	// public static WebElement
	// Financial_Data_Insurer_Paid_Medical_BI_Comp(WebDriver driver) {
	// element =
	// driver.findElement(By.xpath(Financial_Data_Insurer_Paid_Medical_BI_Comp));
	// return element;
	// }
	//
	// public static WebElement
	// Financial_Data_Recovery_Received_Medical_BI_Comp(WebDriver driver) {
	// element =
	// driver.findElement(By.xpath(Financial_Data_Recovery_Received_Medical_BI_Comp));
	// return element;
	// }
	//
	// public static WebElement
	// Financial_Data_Insurer_OS_Indemnity_PD_Collp(WebDriver driver) {
	// element =
	// driver.findElement(By.xpath(Financial_Data_Insurer_OS_Indemnity_PD_Collp));
	// return element;
	// }
	//
	// public static WebElement
	// Financial_Data_Insurer_Paid_Indemnity_PD_Coll(WebDriver driver) {
	// element =
	// driver.findElement(By.xpath(Financial_Data_Insurer_Paid_Indemnity_PD_Coll));
	// return element;
	// }
	//
	// public static WebElement
	// Financial_Data_Recovery_Received_Indemnity_PD_Coll(WebDriver driver) {
	// element =
	// driver.findElement(By.xpath(Financial_Data_Recovery_Received_Indemnity_PD_Coll));
	// return element;
	// }
	//
	// public static WebElement Financial_Data_Insurer_OS_Expense(WebDriver
	// driver) {
	// element =
	// driver.findElement(By.xpath(Financial_Data_Insurer_OS_Expense));
	// return element;
	// }
	//
	// public static WebElement Financial_Data_Insurer_paid_Expense(WebDriver
	// driver) {
	// element =
	// driver.findElement(By.xpath(Financial_Data_Insurer_paid_Expense));
	// return element;
	// }
	//
	// public static WebElement
	// Financial_Data_RecoveryReceived_Expense(WebDriver driver) {
	// element =
	// driver.findElement(By.xpath(Financial_Data_RecoveryReceived_Expense));
	// return element;
	// }
	//
	// public static WebElement Financial_Data_Insurer_paid_legal(WebDriver
	// driver) {
	// element =
	// driver.findElement(By.xpath(Financial_Data_Insurer_paid_legal));
	// return element;
	// }
	//
	// public static WebElement Financial_Data_Net_Paid_Total(WebDriver driver)
	// {
	// element = driver.findElement(By.xpath(Financial_Data_Net_Paid_Total));
	// return element;
	// }
	//
	// public static WebElement Financial_Data_Claim_Amount(WebDriver driver) {
	// element = driver.findElement(By.xpath(Financial_Data_Claim_Amount));
	// return element;
	// }
	//
	// public static WebElement Review_Admin_Markas_Confirm(WebDriver driver) {
	// element = driver.findElement(By.xpath(Review_Admin_Markas_Confirm));
	// return element;
	// }
	//
	// public static WebElement Review_Admin_Action_Notes(WebDriver driver) {
	// element = driver.findElement(By.xpath(Review_Admin_Action_Notes));
	// return element;
	// }
	//
	// public static WebElement SaveBtn_ClaimsTab(WebDriver driver) {
	// element = driver.findElement(By.xpath(SaveBtn_ClaimsTab));
	// return element;
	// }
	//
	// public static WebElement SaveandCloseBtn_ClaimsTab(WebDriver driver) {
	// element = driver.findElement(By.xpath(SaveandCloseBtn_ClaimsTab));
	// return element;
	// }
	//
	// public static WebElement CloseBtn_ClaimsTab(WebDriver driver) {
	// element = driver.findElement(By.xpath(CloseBtn_ClaimsTab));
	// return element;
	// }
	// Raja Reddy copied this from Claims Module

	// claims icon
	static String ClaimModule_claimsICon = "//li[@id='ctl00_ctrlMenu_liClaim']";
	static String ClaimModule_AddBtn = "//ul/li[@id='ctl00_ContentPlaceHolder1_ucClaimList_liadd']";
	static String ClaimModule_EditBtn = "//li[@id='ctl00_ContentPlaceHolder1_ucClaimList_liedit']";
	static String ClaimModule_DeleteBtn = "//li[@id='ctl00_ContentPlaceHolder1_ucClaimList_lidelete']/a/i";
	static String ClaimModule_SearchBar = "//input[@id='ctl00_ContentPlaceHolder1_ucClaimList_txtSearch']";
	static String ClaimModule_AdvanceSearchbtn = "//div[@class='buttonGroup clearfix']//i[@class='fa fa-caret-down']";
	static String ClaimModule_RefreshBtn = "//div[@class='buttonGroup clearfix']//i[@class='fa fa-refresh']";

	// Addition of the claim
	static String AddClaimsViaCliamModuleTest_Search_the_Contractor_Package_for_which_you_want_to_add_a_Claim = "//input[@id='txtSearch']";
	static String AddClaimsViaCliamModuleTest_SearchBtn = "//input[@id='btnAdvanceSearch']";
	static String AddClaimsViaCliamModuleTest_AdvacneSearchBtn = "//a[@id='aAdvancedSearch']";
	static String AddClaimsViaCliamModuleTest_SelectProgramme = "//select[@id='ddlProject']";
	static String AddClaimsViaCliamModuleTest_Selectproject = "//select[@id='ddlWorkSite']";
	static String AddClaimsViaCliamModuleTest_SearchTrade = "//input[@id='token-input-txtTradePackages']";
	static String AddClaimsViaCliamModuleTest_SearchContractor = "//input[@id='token-input-txtGeneralContractor']";
	static String AddClaimsViaCliamModuleTest_SelectContractor = "//select[@id='ddlContractorType']";
	static String AddClaimsViaCliamModuleTest_Advacned_SearchBtnDown = "//input[@id='btnSearch']";
	static String AddClaimsViaCliamModuleTest_CloseBtn = "//button[@id='btnClose']";
	static String AddClaimsViaCliamModuleTest_AdvacneSearch_radioBtn = "//input[@id='rptContractor_ctl00_rdoSelect']";
	static String AddClaimsViaCliamModuleTest_NextBtn = "//input[@id='btnNext']";

	static String contractorPkgNoField = "//input[@id='txtContractNo']";
	static String searchBtn = "//input[@id='btnSearch']";
	static String selectFirstContractorPkg = "//div[@id='divContractorpackageList']/table/tbody/tr/td[1]/div";
	static String nextBtn = "//a[@id='aNextClaim']";

	public static WebElement contractorPkgNoField(WebDriver driver) {
		element = driver.findElement(By.xpath(contractorPkgNoField));
		return element;
	}

	public static WebElement searchBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(searchBtn));
		return element;
	}

	public static WebElement selectFirstContractorPkg(WebDriver driver) {
		element = driver.findElement(By.xpath(selectFirstContractorPkg));
		return element;
	}

	public static WebElement nextBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(nextBtn));
		return element;
	}

	// Claim Information page
	static String selectClaimType = "//select[@id='cntrlClaim_ddlClaimType']";
	static String reportedClaimDate = "//input[@id='cntrlClaim_txtReportedClaimDate']";
	static String lossDate = "//input[@id='cntrlClaim_txtLossDate']";
	static String claimNo = "//input[@id='cntrlClaim_txtClaimNumber']";
	static String claimDescription = "//textarea[@id='cntrlClaim_txtClaimDescription']";
	static String selectPolicyNo = "//select[@id='cntrlClaim_ddlPolicyNumber']";

	static String saveAndContinueBtn = "//input[@id='cntrlClaim_btnSaveAndContinue']";
	static String AlertOkBtn = "//button[@id='btnOkSave']";
	static String AlertCancelBtn = "//button[@id='btnCancelSave']";

	public static WebElement selectClaimType(WebDriver driver) {
		element = driver.findElement(By.xpath(selectClaimType));
		return element;
	}

	public static WebElement selectPolicyNo(WebDriver driver) {
		element = driver.findElement(By.xpath(selectPolicyNo));
		return element;
	}

	public static WebElement reportedClaimDate(WebDriver driver) {
		element = driver.findElement(By.xpath(reportedClaimDate));
		return element;
	}

	public static WebElement lossDate(WebDriver driver) {
		element = driver.findElement(By.xpath(lossDate));
		return element;
	}

	public static WebElement claimNo(WebDriver driver) {
		element = driver.findElement(By.xpath(claimNo));
		return element;
	}

	public static WebElement claimDescription(WebDriver driver) {
		element = driver.findElement(By.xpath(claimDescription));
		return element;
	}

	public static WebElement saveAndContinueBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(saveAndContinueBtn));
		return element;
	}

	public static WebElement AlertOkBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(AlertOkBtn));
		return element;
	}

	public static WebElement AlertCancelBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(AlertCancelBtn));
		return element;
	}

	// Injury Details
	static String selectMedicalAttensionProcided = "//select[@id='cntrlClaim_ddlMedicalAttention']";
	static String unspecifiedProviderOtherTax = "//input[@id='cntrlClaim_txtUnspecifiedProviderOtherText']";
	static String selectOccuredOnCompanyPremisesIndicator = "//select[@id='cntrlClaim_ddlOccuredOnCompanyPremisesIndicator']";
	static String provoiderFirstName = "//input[@id='cntrlClaim_txtProviderFirstName']";
	static String provoiderLastName = "//input[@id='cntrlClaim_txtProviderLastName']";
	static String injuryEventOtherText = "//input[@id='cntrlClaim_txtInjuryEventOtherText']";
	static String injuryExtentCategory = "//div[@id='cntrlClaim_divInjuryExtent']//div[@id='s2id_cntrlClaim_ddlInjuryExtentCode']";
	static String injuryExtentOtherText = "//input[@id='cntrlClaim_txtInjuryExtentOtherText']";
	static String injuryDetailPagesaveAndContineBtn = "//input[@id='cntrlClaim_btnSaveAndContinue']";

	public static WebElement selectMedicalAttensionProcided(WebDriver driver) {
		element = driver.findElement(By.xpath(selectMedicalAttensionProcided));
		return element;
	}
	public static WebElement unspecifiedProviderOtherTax(WebDriver driver) {
		element = driver.findElement(By.xpath(unspecifiedProviderOtherTax));
		return element;
	}
	public static WebElement selectOccuredOnCompanyPremisesIndicator(WebDriver driver) {
		element = driver.findElement(By.xpath(selectOccuredOnCompanyPremisesIndicator));
		return element;
	}
	public static WebElement provoiderFirstName(WebDriver driver) {
		element = driver.findElement(By.xpath(provoiderFirstName));
		return element;
	}
	public static WebElement provoiderLastName(WebDriver driver) {
		element = driver.findElement(By.xpath(provoiderLastName));
		return element;
	}
	public static WebElement injuryEventOtherText(WebDriver driver) {
		element = driver.findElement(By.xpath(injuryEventOtherText));
		return element;
	}
	
	public static WebElement injuryExtentCategory(WebDriver driver) {
		element = driver.findElement(By.xpath(injuryExtentCategory));
		return element;
	}public static WebElement injuryExtentOtherText(WebDriver driver) {
		element = driver.findElement(By.xpath(injuryExtentOtherText));
		return element;
	}public static WebElement injuryDetailPagesaveAndContineBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(injuryDetailPagesaveAndContineBtn));
		return element;
	}
	
	
	static String radioBtnIndividual ="//input[@id='cntrlClaim_rdoIndividual']";
	static String radioBtnBusinessEntity ="//input[@id='cntrlClaim_rdoBusinessEntity']";
	static String claimantFirstName ="//input[@id='cntrlClaim_txtClaimantFirstName']";
	static String claimantLastName ="//input[@id='cntrlClaim_txtClaimantLastName']";
	static String claimantPhoneNo ="//input[@id='cntrlClaim_txtClaimantPhone']";
	static String claimantJobTitle ="//input[@id='cntrlClaim_txtClaimantJobTitle']";
	static String selectGender ="//select[@id='cntrlClaim_ddlClaimantGender']";
	static String selectMaritalStatus ="//select[@id='cntrlClaim_ddlClaimantMaritalStatus']";
	static String addressLine1 ="//input[@id='cntrlClaim_txtClaimantAddress1']";
	static String city ="//input[@id='cntrlClaim_txtClaimantCity']";
	static String selectState ="//select[@id='cntrlClaim_ddlState']";
	static String zip ="//input[@id='cntrlClaim_txtClaimantZip']";
	static String additionalEntities ="//textarea[@id='cntrlClaim_txtNamedEntities']";
	static String ClaimantInformationSaveAndContinueBtn ="//input[@id='cntrlClaim_btnSaveAndContinue']";
	
	public static WebElement radioBtnIndividual(WebDriver driver) {
		element = driver.findElement(By.xpath(radioBtnIndividual));
		return element;
	}
	public static WebElement radioBtnBusinessEntity(WebDriver driver) {
		element = driver.findElement(By.xpath(radioBtnBusinessEntity));
		return element;
	}
	public static WebElement claimantFirstName(WebDriver driver) {
		element = driver.findElement(By.xpath(claimantFirstName));
		return element;
	}
	public static WebElement claimantLastName(WebDriver driver) {
		element = driver.findElement(By.xpath(claimantLastName));
		return element;
	}
	public static WebElement claimantPhoneNo(WebDriver driver) {
		element = driver.findElement(By.xpath(claimantPhoneNo));
		return element;
	}
	public static WebElement claimantJobTitle(WebDriver driver) {
		element = driver.findElement(By.xpath(claimantJobTitle));
		return element;
	}
	public static WebElement selectGender(WebDriver driver) {
		element = driver.findElement(By.xpath(selectGender));
		return element;
	}
	public static WebElement selectMaritalStatus(WebDriver driver) {
		element = driver.findElement(By.xpath(selectMaritalStatus));
		return element;
	}
	public static WebElement addressLine1(WebDriver driver) {
		element = driver.findElement(By.xpath(addressLine1));
		return element;
	}public static WebElement city(WebDriver driver) {
		element = driver.findElement(By.xpath(city));
		return element;
	}public static WebElement selectState(WebDriver driver) {
		element = driver.findElement(By.xpath(selectState));
		return element;
	}public static WebElement zip(WebDriver driver) {
		element = driver.findElement(By.xpath(zip));
		return element;
	}public static WebElement additionalEntities(WebDriver driver) {
		element = driver.findElement(By.xpath(additionalEntities));
		return element;
	}
	
	public static WebElement ClaimantInformationSaveAndContinueBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInformationSaveAndContinueBtn));
		return element;
	}
	
//Finacial Data	
	
	static String insurerBICom ="//input[@id='cntrlClaim_txtInsOSMedBIComp']";
	static String insurerOsPdCall ="//input[@id='cntrlClaim_txtInsOSIndemnityPDColl']";
	static String insurerOsExpense ="//input[@id='cntrlClaim_txtInsOSExpense']";
	static String insurerOsLegal ="//input[@id='cntrlClaim_txtInsOSLegal']";
	static String netOsTotal ="//input[@id='cntrlClaim_txtNetOSTotal']";

	static String insurerPaidComp ="//input[@id='cntrlClaim_txtInsPaidMedBIComp']";
	static String insurerPaidColl ="//input[@id='cntrlClaim_txtInsPaidIndemnityPDColl']";
	static String insurerPaidExpense ="//input[@id='cntrlClaim_txtInsPaidExpense']";
	static String insurerPaidLegal ="//input[@id='cntrlClaim_txtInsPaidLegal']";
	static String netPaidTotal ="//input[@id='cntrlClaim_txtNetPaidTotal']";
	

	static String RecoveryReceivedComp ="//input[@id='cntrlClaim_txtRecoveryRecMedBIComp']";
	static String RecoveryReceivedColl ="//input[@id='cntrlClaim_txtRecoveryRecIndemnityPDColl']";
	static String RecoveryReceivedExpense ="//input[@id='cntrlClaim_txtRecoveryRecExpense']";
	static String RecoveryReceivedTotal ="//input[@id='cntrlClaim_txtNetRecoveryTotal']";

	static String claimAmount ="//input[@id='cntrlClaim_txtClaimAmount']";
	static String actionNoteTextArea ="//textarea[@id='cntrlClaim_txtActionNotes']";
	
	static String finacialDataBackButton ="//input[@id='cntrlClaim_btnBack']";
	static String finacialDataSaveButton ="//input[@id='cntrlClaim_btnSave']";
	static String finacialDataSaveAndCloseButton ="//input[@id='cntrlClaim_btnSaveAndClose']";
	static String finacialDataSaveAndContinueButton ="//input[@id='cntrlClaim_btnSaveAndContinue']";

	public static WebElement finacialDataBackButton(WebDriver driver) {
		element = driver.findElement(By.xpath(finacialDataBackButton));
		return element;
	}
	public static WebElement finacialDataSaveButton(WebDriver driver) {
		element = driver.findElement(By.xpath(finacialDataSaveButton));
		return element;
	}
	public static WebElement finacialDataSaveAndCloseButton(WebDriver driver) {
		element = driver.findElement(By.xpath(finacialDataSaveAndCloseButton));
		return element;
	}
	public static WebElement finacialDataSaveAndContinueButton(WebDriver driver) {
		element = driver.findElement(By.xpath(finacialDataSaveAndContinueButton));
		return element;
	}
	
	
	public static WebElement insurerBICom(WebDriver driver) {
		element = driver.findElement(By.xpath(insurerBICom));
		return element;
	}public static WebElement insurerOsPdCall(WebDriver driver) {
		element = driver.findElement(By.xpath(insurerOsPdCall));
		return element;
	}public static WebElement insurerOsExpense(WebDriver driver) {
		element = driver.findElement(By.xpath(insurerOsExpense));
		return element;
	}public static WebElement insurerOsLegal(WebDriver driver) {
		element = driver.findElement(By.xpath(insurerOsLegal));
		return element;
	}public static WebElement netOsTotal(WebDriver driver) {
		element = driver.findElement(By.xpath(netOsTotal));
		return element;
	}public static WebElement insurerPaidComp(WebDriver driver) {
		element = driver.findElement(By.xpath(insurerPaidComp));
		return element;
	}public static WebElement insurerPaidColl(WebDriver driver) {
		element = driver.findElement(By.xpath(insurerPaidColl));
		return element;
	}public static WebElement insurerPaidExpense(WebDriver driver) {
		element = driver.findElement(By.xpath(insurerPaidExpense));
		return element;
	}public static WebElement insurerPaidLegal(WebDriver driver) {
		element = driver.findElement(By.xpath(insurerPaidLegal));
		return element;
	}public static WebElement netPaidTotal(WebDriver driver) {
		element = driver.findElement(By.xpath(netPaidTotal));
		return element;
	}public static WebElement RecoveryReceivedComp(WebDriver driver) {
		element = driver.findElement(By.xpath(RecoveryReceivedComp));
		return element;
	}public static WebElement RecoveryReceivedColl(WebDriver driver) {
		element = driver.findElement(By.xpath(RecoveryReceivedColl));
		return element;
	}public static WebElement RecoveryReceivedExpense(WebDriver driver) {
		element = driver.findElement(By.xpath(RecoveryReceivedExpense));
		return element;
	}public static WebElement RecoveryReceivedTotal(WebDriver driver) {
		element = driver.findElement(By.xpath(RecoveryReceivedTotal));
		return element;
	}public static WebElement claimAmount(WebDriver driver) {
		element = driver.findElement(By.xpath(claimAmount));
		return element;
	}public static WebElement actionNoteTextArea(WebDriver driver) {
		element = driver.findElement(By.xpath(actionNoteTextArea));
		return element;
	}
	
	
	//Other Information and document
	
	
	static String prepairedByTitle ="//input[@id='cntrlClaim_txtPreparedByTitle']";
	static String prepairedByEmail ="//input[@id='cntrlClaim_txtPreparedByEmail']";
	static String prepairedByFirstName ="//input[@id='cntrlClaim_txtPreparedByFirstName']";
	static String prepairedByTelephone ="//input[@id='cntrlClaim_txtPreparedByTelephone']";
	static String prepairedByLastName ="//input[@id='cntrlClaim_txtPreparedByLastName']";
	static String uploadDocumentLink ="//div[contains(text(),'Drop files here or click to upload.')]";
	static String otherInfoActionNoteTextArea ="//textarea[@id='cntrlClaim_txtActionNotes']";
	
	static String otherInfoAndDocBackButton ="//input[@id='cntrlClaim_btnBack']";
	static String otherInfoAndDocSaveButton ="//input[@id='cntrlClaim_btnSave']";
	static String otherInfoAndDocSaveAndCloseButton ="//input[@id='cntrlClaim_btnSaveAndClose']";
	static String otherInfoAndDocSaveAndSendEmailButton ="//input[@id='cntrlClaim_btnSaveAndSendEmail']";
	
	
	public static WebElement prepairedByTitle(WebDriver driver) {
		element = driver.findElement(By.xpath(prepairedByTitle));
		return element;
	}
	
	public static WebElement prepairedByEmail(WebDriver driver) {
		element = driver.findElement(By.xpath(prepairedByEmail));
		return element;
	}
	
	public static WebElement prepairedByFirstName(WebDriver driver) {
		element = driver.findElement(By.xpath(prepairedByFirstName));
		return element;
	}
	
	public static WebElement prepairedByTelephone(WebDriver driver) {
		element = driver.findElement(By.xpath(prepairedByTelephone));
		return element;
	}
	
	public static WebElement prepairedByLastName(WebDriver driver) {
		element = driver.findElement(By.xpath(prepairedByLastName));
		return element;
	}
	public static WebElement uploadDocumentLink(WebDriver driver) {
		element = driver.findElement(By.xpath(uploadDocumentLink));
		return element;
	}
	public static WebElement otherInfoActionNoteTextArea(WebDriver driver) {
		element = driver.findElement(By.xpath(otherInfoActionNoteTextArea));
		return element;
	}
	public static WebElement otherInfoAndDocBackButton(WebDriver driver) {
		element = driver.findElement(By.xpath(otherInfoAndDocBackButton));
		return element;
	}
	public static WebElement otherInfoAndDocSaveButton(WebDriver driver) {
		element = driver.findElement(By.xpath(otherInfoAndDocSaveButton));
		return element;
	}
	public static WebElement otherInfoAndDocSaveAndCloseButton(WebDriver driver) {
		element = driver.findElement(By.xpath(otherInfoAndDocSaveAndCloseButton));
		return element;
	}
	public static WebElement otherInfoAndDocSaveAndSendEmailButton(WebDriver driver) {
		element = driver.findElement(By.xpath(otherInfoAndDocSaveAndSendEmailButton));
		return element;
	}
	
	
	
	// --------------------------------------------------------------------------------------------------------

	// ClaimsInfo

	static String ClaimInfo_ClaimDate = "//input[@id='cntrlClaim_txtClaimDate']";
	static String ClaimInfo_Claim_Number = "//input[@id='cntrlClaim_txtClaimNumber']";
	static String ClaimInfo_Policy_Number = "//input[@id='cntrlClaim_txtPolicyNumber']";
	static String ClaimInfo_Claim_Status = "//select[@id='cntrlClaim_ddlClaimStatus']";
	static String ClaimInfo_claim_Type = "//select[@id='cntrlClaim_ddlClaimType']";
	static String claimInfo_Claim_Specific_Class_code = "//select[@id='cntrlClaim_ddlClassCode']";
	static String ClaimInfo_ReportDate = "//input[@id='cntrlClaim_txtReportDate']";
	static String ClaimInfo_Closed_Date = "//input[@id='cntrlClaim_txtClosedDate']";
	static String ClaimInfo_Primary_Physician_Used = "//input[@id='cntrlClaim_txtPrimaryPhysicianUsed']";
	static String ClaimInfo_Loss_Date = "//input[@id='cntrlClaim_txtLosDate']";
	static String ClaimInfo_Loss_Time = "//input[@id='cntrlClaim_txtLossTime']";
	static String ClaimInfo_Loss_code = "//input[@id='cntrlClaim_txtLossCode']";
	static String ClaimInfo_Incident_Reported_by_Name = "//input[@id='cntrlClaim_txtIncidentReportedByName']";
	static String ClaimInfo_Incident_Reported_by_Email = "//input[@id='cntrlClaim_txtIncidentReportedByEmail']";
	static String ClaimInfo_Incident_Reported_by_phone = "//input[@id='cntrlClaim_txtIncidentReportedByPhone']";
	static String ClaimInfo_Loss_Days = "//input[@id='cntrlClaim_txtLostDays']";
	static String ClaimInfo_partofBody = "//input[@id='cntrlClaim_txtPartOfBody']";
	static String ClaimInfo_Nature_of_Injury = "//input[@id='cntrlClaim_txtNatureInjury']";
	static String ClaimInfo_MedicalAttention = "//select[@id='cntrlClaim_ddlMedicalAttention']";
	static String ClaimInfo_Weather_Condition = "//span[contains(text(),'Weather Condition')]";
	static String Claiminfo_Preventable_measures = "//input[@id='cntrlClaim_txtPreventableMeasures']";
	static String ClaimInfo_Claim_Description = "//textarea[@id='cntrlClaim_txtClaimDescription']";
	static String ClaimInfo_Cause = "//textarea[@id='cntrlClaim_txtCause']";

	// Claimant Information tabs

	static String ClaimantInfo_Claimant_Name = "//input[@id='cntrlClaim_txtClaimantName']";
	static String ClaimantInfo_Job_Title = "//input[@id='cntrlClaim_txtClaimantJobTitle']";
	static String ClaimantInfo_Claimant_Social_Security_Number = "//input[@id='cntrlClaim_txtSocialSecurityNumber']";
	static String ClaimantInfo_ClaimantAddress_1 = "//input[@id='cntrlClaim_txtClaimantAddress1']";
	static String ClaimantInfo_ClaimantAddress_2 = "//input[@id='cntrlClaim_txtClaimantAddress2']";
	static String ClaimantInfo_ClaiamnatCity = "//input[@id='cntrlClaim_txtClaimantCity']";
	static String ClaiamantInfo_Claimant_Country = "//select[@id='cntrlClaim_ddlCountry']";
	static String ClaimantInfo_Claimant_State = "//select[@id='cntrlClaim_ddlState']";
	static String ClaimantInfo_Claimant_ZIP = "//input[@id='cntrlClaim_txtClaimantZip']";
	static String ClaimantInfo_Claimant_Date_Of_Birth = "//input[@id='cntrlClaim_txtDateOfBirth']";
	static String ClaimantInfo_Claimant_Date_Of_Hire = "//input[@id='cntrlClaim_txtDateOfHire']";
	static String ClaimantInfo_Claimant_Phone = "//input[@id='cntrlClaim_txtClaimantPhone']";
	static String ClaimantInfo_Claimant_Phone_PlusBtn = "//button[@class='add_contact_button btn btn-success']";
	static String ClaimantInfo_Claimant_Gender = "//select[@id='cntrlClaim_ddlGender']";
	static String ClaimantInfo_Claimant_Martial_Status = "//select[@id='cntrlClaim_ddlMaritalStatus']";
	static String ClaimantInfo_ClaimantPhone_HomeDropdown = "//select[@id='ddlContactStaticTypeNew0']";
	static String ClaimantInfo_ClaimantPhone_HomeDropdown_telephone = "//input[@id='txtContact0']";
	// Other Information tabs

	static String Other_Info_Prepared_by_First_Name = "//input[@id='cntrlClaim_txtPreparedByFirstName']";
	static String Other_Info_Prepared_by_Last_Name = "//input[@id='cntrlClaim_txtPreparedByLastName']";
	static String Other_Info_Prepared_by_Email = "//input[@id='cntrlClaim_txtPreparedByEmail']";
	static String Other_Info_Prepared_by_Telephone = "//input[@id='cntrlClaim_txtPreparedByTelephone']";

	// Financial Data tabs

	static String Financial_Data_Insurer_OS_Medical_BI_Comp = "//input[@id='cntrlClaim_txtIns_OS_Med_BI_Comp']";
	static String Financial_Data_Insurer_Paid_Medical_BI_Comp = "//input[@id='cntrlClaim_txtIns_Paid_Med_BI_Comp']";
	static String Financial_Data_Recovery_Received_Medical_BI_Comp = "//input[@id='cntrlClaim_txtRecovery_Rec_Med_BI_Comp']";
	static String Financial_Data_Insurer_OS_Indemnity_PD_Collp = "//input[@id='cntrlClaim_txtIns_OS_Indemnity_PD_Coll']";
	static String Financial_Data_Insurer_Paid_Indemnity_PD_Coll = "//input[@id='cntrlClaim_txtIns_Paid_Indemnity_PD_Coll']";
	static String Financial_Data_Recovery_Received_Indemnity_PD_Coll = "//input[@id='cntrlClaim_txtRecovery_Rec_Indemnity_PD_Coll']";
	static String Financial_Data_Insurer_OS_Expense = "//input[@id='cntrlClaim_txtIns_OS_Expense']";
	static String Financial_Data_Insurer_paid_Expense = "//input[@id='cntrlClaim_txtIns_Paid_Expense']";
	static String Financial_Data_RecoveryReceived_Expense = "//input[@id='cntrlClaim_txtRecovery_Rec_Expense']";
	static String Financial_Data_Insurer_OS_Legal = "//input[@id='cntrlClaim_txtIns_OS_Legal']";
	static String Financial_Data_Insurer_paid_legal = "//input[@id='cntrlClaim_txtIns_Paid_Legal']";
	static String Financial_Data_Net_Paid_Total = "//input[@id='cntrlClaim_txtNet_Insurred_Total']";
	static String Financial_Data_Claim_Amount = "//input[@id='cntrlClaim_txtClaimAmount']";

	// Reviwe Admin tab

	static String Review_Admin_Markas_Confirm = "//input[@id='cntrlClaim_chkConfirm']";
	static String Review_Admin_Action_Notes = "//textarea[@id='cntrlClaim_txtActionNotes']";

	// save ,save and close and close buttons

	static String SaveBtn_ClaimsTab = "//input[@id='cntrlClaim_btnSave']";
	static String SaveandCloseBtn_ClaimsTab = "//input[@id='cntrlClaim_btnSaveandClose']";
	static String CloseBtn_ClaimsTab = "//button[@class='btn']";

	// Alert Messages ----ClaimInfo

	static String ErrorMessage_ClaimInfo_ClaimDate = "//label[@for='cntrlClaim_txtClaimDate' and @class='error']";
	static String ErrorMessage_ClaimInfo_Loss_Date = "//label[@for='cntrlClaim_txtLosDate'and @class='error']";
	static String ErrorMessage_ClaimInfo_ClaimDescription = "//label[@for='cntrlClaim_txtClaimDescription' and @class='error']";

	// Alert Messages_ClaimantInfo

	static String ErrorMessage_ClaimantInfo_Claimant_Name = "//label[@for='cntrlClaim_txtClaimantName'and @class='error']";

	// Advance searchbar for claims search

	static String ClaimSearch_SelectPrograme_ = "//select[@id='ctl00_ContentPlaceHolder1_ucClaimList_ddlProject']";
	static String ClaimsSerach_Advancesearch_Btn_Downn = "//input[@id='btnAdvanceSearch']";

	// ------------------------------------------------------------------------------------------------------------------------------
	public static WebElement ClaimsSerach_Advancesearch_Btn_Downn(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimsSerach_Advancesearch_Btn_Downn));
		return element;
	}

	public static WebElement ClaimSearch_SelectPrograme_(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimSearch_SelectPrograme_));
		return element;
	}

	public static WebElement AddClaimsViaCliamModuleTest_NextBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(AddClaimsViaCliamModuleTest_NextBtn));
		return element;
	}

	public static WebElement AddClaimsViaCliamModuleTest_AdvacneSearch_radioBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(AddClaimsViaCliamModuleTest_AdvacneSearch_radioBtn));
		return element;
	}

	public static WebElement AddClaimsViaCliamModuleTest_CloseBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(AddClaimsViaCliamModuleTest_CloseBtn));
		return element;
	}

	public static WebElement AddClaimsViaCliamModuleTest_Advacned_SearchBtnDown(WebDriver driver) {
		element = driver.findElement(By.xpath(AddClaimsViaCliamModuleTest_Advacned_SearchBtnDown));
		return element;
	}

	public static WebElement AddClaimsViaCliamModuleTest_SelectContractor(WebDriver driver) {
		element = driver.findElement(By.xpath(AddClaimsViaCliamModuleTest_SelectContractor));
		return element;
	}

	public static WebElement AddClaimsViaCliamModuleTest_SearchContractor(WebDriver driver) {
		element = driver.findElement(By.xpath(AddClaimsViaCliamModuleTest_SearchContractor));
		return element;
	}

	public static WebElement AddClaimsViaCliamModuleTest_SearchTrade(WebDriver driver) {
		element = driver.findElement(By.xpath(AddClaimsViaCliamModuleTest_SearchTrade));
		return element;
	}

	public static WebElement AddClaimsViaCliamModuleTest_Selectproject(WebDriver driver) {
		element = driver.findElement(By.xpath(AddClaimsViaCliamModuleTest_Selectproject));
		return element;
	}

	public static WebElement AddClaimsViaCliamModuleTest_SelectProgramme(WebDriver driver) {
		element = driver.findElement(By.xpath(AddClaimsViaCliamModuleTest_SelectProgramme));
		return element;
	}

	public static WebElement AddClaimsViaCliamModuleTest_AdvacneSearchBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(AddClaimsViaCliamModuleTest_AdvacneSearchBtn));
		return element;
	}

	public static WebElement AddClaimsViaCliamModuleTest_SearchBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(AddClaimsViaCliamModuleTest_SearchBtn));
		return element;
	}

	public static WebElement AddClaimsViaCliamModuleTest_Search_the_Contractor_Package_for_which_you_want_to_add_a_Claim(
			WebDriver driver) {
		element = driver.findElement(
				By.xpath(AddClaimsViaCliamModuleTest_Search_the_Contractor_Package_for_which_you_want_to_add_a_Claim));
		return element;
	}

	public static WebElement ClaimModule_RefreshBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimModule_RefreshBtn));
		return element;
	}

	public static WebElement ClaimModule_AdvanceSearchbtn(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimModule_AdvanceSearchbtn));
		return element;
	}

	public static WebElement ClaimModule_SearchBar(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimModule_SearchBar));
		return element;
	}

	public static WebElement ClaimModule_DeleteBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimModule_DeleteBtn));
		return element;
	}

	public static WebElement ClaimModule_EditBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimModule_EditBtn));
		return element;
	}

	public static WebElement ClaimModule_AddBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimModule_AddBtn));
		return element;
	}

	public static WebElement ClaimModule_claimsICon(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimModule_claimsICon));
		return element;
	}

	public static WebElement ClaimantInfo_ClaimantPhone_HomeDropdown_telephone(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInfo_ClaimantPhone_HomeDropdown_telephone));
		return element;
	}

	public static WebElement ClaimantInfo_ClaimantPhone_HomeDropdown(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInfo_ClaimantPhone_HomeDropdown));
		return element;
	}

	public static WebElement ErrorMessage_ClaimantInfo_Claimant_Name(WebDriver driver) {
		element = driver.findElement(By.xpath(ErrorMessage_ClaimantInfo_Claimant_Name));
		return element;
	}

	public static WebElement ErrorMessage_ClaimInfo_ClaimDescription(WebDriver driver) {
		element = driver.findElement(By.xpath(ErrorMessage_ClaimInfo_ClaimDescription));
		return element;
	}

	public static WebElement ErrorMessage_ClaimInfo_Loss_Date(WebDriver driver) {
		element = driver.findElement(By.xpath(ErrorMessage_ClaimInfo_Loss_Date));
		return element;
	}

	public static WebElement ErrorMessage_ClaimInfo_ClaimDate(WebDriver driver) {
		element = driver.findElement(By.xpath(ErrorMessage_ClaimInfo_ClaimDate));
		return element;
	}

	public static WebElement ClaimInfo_ClaimDate(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_ClaimDate));
		return element;
	}

	public static WebElement ClaimInfo_Claim_Number(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_Claim_Number));
		return element;
	}

	public static WebElement ClaimInfo_Policy_Number(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_Policy_Number));
		return element;
	}

	public static WebElement ClaimInfo_Claim_Status(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_Claim_Status));
		return element;
	}

	public static WebElement ClaimInfo_claim_Type(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_claim_Type));
		return element;
	}

	public static WebElement claimInfo_Claim_Specific_Class_code(WebDriver driver) {
		element = driver.findElement(By.xpath(claimInfo_Claim_Specific_Class_code));
		return element;
	}

	public static WebElement ClaimInfo_ReportDate(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_ReportDate));
		return element;
	}

	public static WebElement ClaimInfo_Closed_Date(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_Closed_Date));
		return element;
	}

	public static WebElement ClaimInfo_Primary_Physician_Used(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_Primary_Physician_Used));
		return element;
	}

	public static WebElement ClaimInfo_Loss_Date(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_Loss_Date));
		return element;
	}

	public static WebElement ClaimInfo_Loss_Time(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_Loss_Time));
		return element;
	}

	public static WebElement ClaimInfo_Loss_code(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_Loss_code));
		return element;
	}

	public static WebElement ClaimInfo_Incident_Reported_by_Name(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_Incident_Reported_by_Name));
		return element;
	}

	public static WebElement ClaimInfo_Incident_Reported_by_Email(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_Incident_Reported_by_Email));
		return element;
	}

	public static WebElement ClaimInfo_Incident_Reported_by_phone(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_Incident_Reported_by_phone));
		return element;
	}

	public static WebElement ClaimInfo_Loss_Days(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_Loss_Days));
		return element;
	}

	public static WebElement ClaimInfo_partofBody(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_partofBody));
		return element;
	}

	public static WebElement ClaimInfo_Nature_of_Injury(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_Nature_of_Injury));
		return element;
	}

	public static WebElement ClaimInfo_MedicalAttention(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_MedicalAttention));
		return element;
	}

	public static WebElement ClaimInfo_Weather_Condition(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_Weather_Condition));
		return element;
	}

	public static WebElement Claiminfo_Preventable_measures(WebDriver driver) {
		element = driver.findElement(By.xpath(Claiminfo_Preventable_measures));
		return element;
	}

	public static WebElement ClaimInfo_Claim_Description(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_Claim_Description));
		return element;
	}

	public static WebElement ClaimInfo_Cause(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimInfo_Cause));
		return element;
	}

	public static WebElement ClaimantInfo_Claimant_Name(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInfo_Claimant_Name));
		return element;
	}

	public static WebElement ClaimantInfo_Job_Title(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInfo_Job_Title));
		return element;
	}

	public static WebElement ClaimantInfo_Claimant_Social_Security_Number(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInfo_Claimant_Social_Security_Number));
		return element;
	}

	public static WebElement ClaimantInfo_ClaimantAddress_1(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInfo_ClaimantAddress_1));
		return element;
	}

	public static WebElement ClaimantInfo_ClaimantAddress_2(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInfo_ClaimantAddress_2));
		return element;
	}

	public static WebElement ClaimantInfo_ClaiamnatCity(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInfo_ClaiamnatCity));
		return element;
	}

	public static WebElement ClaiamantInfo_Claimant_Country(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaiamantInfo_Claimant_Country));
		return element;
	}

	public static WebElement ClaimantInfo_Claimant_State(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInfo_Claimant_State));
		return element;
	}

	public static WebElement ClaimantInfo_Claimant_ZIP(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInfo_Claimant_ZIP));
		return element;
	}

	public static WebElement ClaimantInfo_Claimant_Date_Of_Birth(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInfo_Claimant_Date_Of_Birth));
		return element;
	}

	public static WebElement ClaimantInfo_Claimant_Date_Of_Hire(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInfo_Claimant_Date_Of_Hire));
		return element;
	}

	public static WebElement ClaimantInfo_Claimant_Phone(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInfo_Claimant_Phone));
		return element;
	}

	public static WebElement ClaimantInfo_Claimant_Phone_PlusBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInfo_Claimant_Phone_PlusBtn));
		return element;
	}

	public static WebElement ClaimantInfo_Claimant_Gender(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInfo_Claimant_Gender));
		return element;
	}

	public static WebElement ClaimantInfo_Claimant_Martial_Status(WebDriver driver) {
		element = driver.findElement(By.xpath(ClaimantInfo_Claimant_Martial_Status));
		return element;
	}

	public static WebElement Other_Info_Prepared_by_First_Name(WebDriver driver) {
		element = driver.findElement(By.xpath(Other_Info_Prepared_by_First_Name));
		return element;
	}

	public static WebElement Other_Info_Prepared_by_Last_Name(WebDriver driver) {
		element = driver.findElement(By.xpath(Other_Info_Prepared_by_Last_Name));
		return element;
	}

	public static WebElement Other_Info_Prepared_by_Email(WebDriver driver) {
		element = driver.findElement(By.xpath(Other_Info_Prepared_by_Email));
		return element;
	}

	public static WebElement Other_Info_Prepared_by_Telephone(WebDriver driver) {
		element = driver.findElement(By.xpath(Other_Info_Prepared_by_Telephone));
		return element;
	}

	public static WebElement Financial_Data_Insurer_OS_Medical_BI_Comp(WebDriver driver) {
		element = driver.findElement(By.xpath(Financial_Data_Insurer_OS_Medical_BI_Comp));
		return element;
	}

	public static WebElement Financial_Data_Insurer_Paid_Medical_BI_Comp(WebDriver driver) {
		element = driver.findElement(By.xpath(Financial_Data_Insurer_Paid_Medical_BI_Comp));
		return element;
	}

	public static WebElement Financial_Data_Recovery_Received_Medical_BI_Comp(WebDriver driver) {
		element = driver.findElement(By.xpath(Financial_Data_Recovery_Received_Medical_BI_Comp));
		return element;
	}

	public static WebElement Financial_Data_Insurer_OS_Indemnity_PD_Collp(WebDriver driver) {
		element = driver.findElement(By.xpath(Financial_Data_Insurer_OS_Indemnity_PD_Collp));
		return element;
	}

	public static WebElement Financial_Data_Insurer_Paid_Indemnity_PD_Coll(WebDriver driver) {
		element = driver.findElement(By.xpath(Financial_Data_Insurer_Paid_Indemnity_PD_Coll));
		return element;
	}

	public static WebElement Financial_Data_Recovery_Received_Indemnity_PD_Coll(WebDriver driver) {
		element = driver.findElement(By.xpath(Financial_Data_Recovery_Received_Indemnity_PD_Coll));
		return element;
	}

	public static WebElement Financial_Data_Insurer_OS_Expense(WebDriver driver) {
		element = driver.findElement(By.xpath(Financial_Data_Insurer_OS_Expense));
		return element;
	}

	public static WebElement Financial_Data_Insurer_paid_Expense(WebDriver driver) {
		element = driver.findElement(By.xpath(Financial_Data_Insurer_paid_Expense));
		return element;
	}

	public static WebElement Financial_Data_RecoveryReceived_Expense(WebDriver driver) {
		element = driver.findElement(By.xpath(Financial_Data_RecoveryReceived_Expense));
		return element;
	}

	public static WebElement Financial_Data_Insurer_paid_legal(WebDriver driver) {
		element = driver.findElement(By.xpath(Financial_Data_Insurer_paid_legal));
		return element;
	}

	public static WebElement Financial_Data_Net_Paid_Total(WebDriver driver) {
		element = driver.findElement(By.xpath(Financial_Data_Net_Paid_Total));
		return element;
	}

	public static WebElement Financial_Data_Claim_Amount(WebDriver driver) {
		element = driver.findElement(By.xpath(Financial_Data_Claim_Amount));
		return element;
	}

	public static WebElement Review_Admin_Markas_Confirm(WebDriver driver) {
		element = driver.findElement(By.xpath(Review_Admin_Markas_Confirm));
		return element;
	}

	public static WebElement Review_Admin_Action_Notes(WebDriver driver) {
		element = driver.findElement(By.xpath(Review_Admin_Action_Notes));
		return element;
	}

	public static WebElement SaveBtn_ClaimsTab(WebDriver driver) {
		element = driver.findElement(By.xpath(SaveBtn_ClaimsTab));
		return element;
	}

	public static WebElement SaveandCloseBtn_ClaimsTab(WebDriver driver) {
		element = driver.findElement(By.xpath(SaveandCloseBtn_ClaimsTab));
		return element;
	}

	public static WebElement CloseBtn_ClaimsTab(WebDriver driver) {
		element = driver.findElement(By.xpath(CloseBtn_ClaimsTab));
		return element;
	}

}
