package TestScript;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.RandomClass;
import ObjectRepository.AddSponsorPage;
import ObjectRepository.HomePage;
import ObjectRepository.SponsorsModule;

public class SponsorDefaultOwnerSelectTest extends BaseClass
{
	WebDriverCommonLib wb= new WebDriverCommonLib();
	String sponsorName=RandomClass.randomSponsorName();
	
	@Test
	public void verifyOwenrDefaultFinctionlity() throws InterruptedException
	{
		test.log(LogStatus.INFO, "========== Add Sponsors Section  ==========");
		HomePage.controlMenuHomeIcon(driver).click();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicked On Home Icon");
		HomePage.HomeMenuSponsors(driver).click();
		Thread.sleep(6000);
		test.log(LogStatus.INFO, "Clicked On Sponsor Module Icon");
		SponsorsModule.SponsorAddIcon(driver).click();
		test.log(LogStatus.INFO, "Clicked On Add Sponsor Icon");
		Thread.sleep(2000);
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		Thread.sleep(5000);
		AddSponsorPage.addSponsorCompanyNameField(driver).sendKeys(sponsorName);
		test.log(LogStatus.PASS, sponsorName+" Sponsor Company Added Successfully");
		AddSponsorPage.addSponsorFEINField(driver).sendKeys(RandomClass.randomFEIN());
		test.log(LogStatus.PASS, "Sponsor FEIN Added Successfully");
		wb.selectSingleValueByIndex(AddSponsorPage.addSponsorLegalStatus(driver), 2);
		test.log(LogStatus.PASS, "Sponsor Legal Status Selected Successfully");
		
		AddSponsorPage.addSponsorSponsorCodeField(driver).sendKeys(RandomClass.randomSponsorName());
		test.log(LogStatus.PASS, "Sponsor Code Added Successfully");
		
		AddSponsorPage.addSponsorDBAField(driver).sendKeys(RandomClass.randomDBA());
		test.log(LogStatus.PASS, "Sponsor DBA Added Successfully");
		
		AddSponsorPage.addSponsorLicenseNoField(driver).sendKeys(RandomClass.randomDBA());
		test.log(LogStatus.PASS, "Sponsor Licence No Added Successfully");
		
		System.out.println("User Group Owner Option is selected ?  =" +AddSponsorPage.userGroupOwnerOptionSelect(driver).isSelected());
		
		if(AddSponsorPage.userGroupOwnerOptionSelect(driver).isSelected()==true)
		{
			System.out.println("Owenr option bydefault selected");
			test.log(LogStatus.PASS, "Owenr option Bydefault selected");
		}else
		{
			System.out.println("Owenr option bydefault selected");
			test.log(LogStatus.FAIL, "Owenr option is not Bydefault selected");
		}
		wb.selectSingleValueByIndex(AddSponsorPage.addSponsorContactTypeField(driver), 2);
		test.log(LogStatus.PASS, "Sponsor Contact Type Selected Successfully");
		AddSponsorPage.addSponsorFirstNameField(driver).sendKeys("Jimmy");
		test.log(LogStatus.PASS, "Sponsor First Name Added Successfully");
		AddSponsorPage.addSponsorMiddleNameField(driver).sendKeys("BV");
		test.log(LogStatus.PASS, "Sponsor Middle Name Added Successfully");
		AddSponsorPage.addSponsorLastNameField(driver).sendKeys("Smith");
		test.log(LogStatus.PASS, "Sponsor Last Name Added Successfully");
		AddSponsorPage.addSponsorJobTitleField(driver).sendKeys("Admin");
		test.log(LogStatus.PASS, "Sponsor Job Title Added Successfully");
		AddSponsorPage.addSponsorPhoneNoField(driver).sendKeys(RandomClass.randomPhoneNo());
		test.log(LogStatus.PASS, "Sponsor Phone No Added Successfully");
		AddSponsorPage.addSponsorMobileNoField(driver).sendKeys(RandomClass.randomMobileNo());
		test.log(LogStatus.PASS, "Sponsor Mobile No Added Successfully");
		AddSponsorPage.addSponsorFaxField(driver).sendKeys("78454131");
		test.log(LogStatus.PASS, "Sponsor Fax No Added Successfully");
		AddSponsorPage.addSponsorEmailField(driver).sendKeys("kiran@nourtek.net");
		test.log(LogStatus.PASS, "Sponsor Email ID Added Successfully");
		AddSponsorPage.addSponsorSaveAndContinueBtn(driver).click();
		test.log(LogStatus.INFO, "Clicked On Save And Continue Button");
		AddSponsorPage.addSponsorAddAddressBtn(driver).click();
		test.log(LogStatus.INFO, "Clicked On Add Address Button");
		wb.getWindowID3();
		driver.switchTo().window(wb.map.get("subchildID"));
		AddSponsorPage.addSponsorAddAddressSelectAddressType(driver, "Mailing Address");
		test.log(LogStatus.PASS, "Address Type Selected Successfully");
		AddSponsorPage.addSponsorAddAddressAddress1Field(driver).sendKeys(RandomClass.randomAddress1Field());
		test.log(LogStatus.PASS, "Address 1 Added Successfully");
		AddSponsorPage.addSponsorAddAddressCityField(driver).sendKeys(RandomClass.randomState());
		test.log(LogStatus.PASS, "Address City Added Successfully");
		AddSponsorPage.addSponsorAddAddressSelectState(driver, RandomClass.randomState());
		test.log(LogStatus.PASS, "Address State Added Successfully");
		AddSponsorPage.addSponsorAddAddressZipCode(driver).sendKeys("789654123");
		test.log(LogStatus.PASS, "Address Zip Code Added Successfully");
		AddSponsorPage.addSponsorAddAddressSaveAndCloseBtn(driver).click();
		test.log(LogStatus.INFO, "Clicked On Save And Close Button");
		driver.switchTo().window(wb.map.get("childID"));
		AddSponsorPage.addSponsorAddressTabSaveAndContinueBtn(driver).click();
		test.log(LogStatus.INFO, "Clicked On Address Tab Save And Continue Button");
		AddSponsorPage.addSponsorContactsTabFinishAndCloseBtn(driver).click();
		test.log(LogStatus.PASS, "Clicked On Finish And Close Button");
		System.out.println("Sponsor Added Successfully"); 
		test.log(LogStatus.PASS,sponsorName+ " Sponosor Added Successfully");
		driver.switchTo().window(wb.map.get("parentID"));
		Thread.sleep(2000);
	}
}
