package TestScript;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import ModulerLibrary.WPO_SelectContractorPkgAction;
import ObjectRepository.AddContractor_Pkg_ViewCertificatePage;
import ObjectRepository.ContractorPackageModule;
import ObjectRepository.HomePage;

public class Generate_COI_Test extends BaseClass
{
	WebDriverCommonLib wb = new WebDriverCommonLib();
	String contractorPKGno="PC3524-P3524CONTRACTOR_PKG_NO34272";
	String tabName="";
	@Test
	public void testGenerateCOI() throws Throwable
	{
		HomePage.HomeMenuContractorPackage(driver).click();
		test.log(LogStatus.INFO, "Clicked On Contracotr Package Icon");
		WPO_SelectContractorPkgAction.selectContractorpkgOnly(contractorPKGno);
		
		Thread.sleep(10000);
		driver.switchTo().frame(0);
		ContractorPackageModule.CertificatePagePriviewP(driver).click();
		Thread.sleep(2000);
		wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("childID"));
		AddContractor_Pkg_ViewCertificatePage.btnAutoGenerateCertificate(driver).click();
		Thread.sleep(8000);
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));  
		String nowDate= dtf.format(now);
		
		
		String GLdate=AddContractor_Pkg_ViewCertificatePage.GL_PolicyDateTime(driver).getText();
		String[] dateSplit=GLdate.split(" ");
		for(int j=0;j<dateSplit.length;j++)
		{
			System.out.println(dateSplit[j]);
			if(dateSplit[j].contains(nowDate))
			{
				System.out.println("Date Matched");
			}
		}
		
		String str1=AddContractor_Pkg_ViewCertificatePage.GL_PolicyNo(driver).getText();
		System.out.println(AddContractor_Pkg_ViewCertificatePage.GL_PolicyNo(driver).getText());
		String polNo="POLP3524";
		String [] str2=str1.split(" ");
		for(int i=0 ; i<str2.length;i++)
		{
			if(str2[i].contains(polNo))
			{
				System.out.println("Policy No Matched");
				break;
			}
			System.out.println(str2[i]);
		}
		Thread.sleep(5000);
		driver.close();
	/*	Thread.sleep(1500);
		driver.switchTo().defaultContent();*/
		
		driver.switchTo().window(wb.map.get("parentID"));
		Thread.sleep(1500);
		driver.switchTo().frame(0);
		
		
		ContractorPackageModule.CertificateSeeMorePriviewP(driver).click();
		Thread.sleep(1500);
		
		String autoMobilePolNoActual=ContractorPackageModule.AutoMobileCertificateNoPriviewP(driver).getText();
		String autoMobilePolNoExpected="MASTER AUTO POL 545121";
		if(autoMobilePolNoActual.contains(autoMobilePolNoExpected))
		{
			System.out.println("Automobile policy matched");
		}
			
			
//		driver.switchTo().window(wb.map.get("parentID"));
	}
}
