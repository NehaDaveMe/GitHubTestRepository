/**
 * 
 */
package TestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import ModulerLibrary.WPO_SelectContractorPkgAction;
import ObjectRepository.ContractorPackageModule;
import ObjectRepository.HomePage;

/**
 * @author KiranP
 *
 */
public class ContractorPackagesPreviewPanelTest extends BaseClass {

	String contractorPKGno ="P7852-SPONSOR347 KP29";
	@Test
	public void testCP_CloseoutColor() throws Throwable 
	{
		HomePage.HomeMenuContractorPackage(driver).click();
		
		WPO_SelectContractorPkgAction.selectContractorpkgOnly(contractorPKGno);
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		System.out.println(ContractorPackageModule.fetchContractorPkgClosedOutStatusPriviewP(driver).getText());
		System.out.println(ContractorPackageModule.fetchContractorPkgClosedOutStatusPriviewP(driver).getCssValue("color"));
		System.out.println(	driver.findElement(By.xpath("//li[@id='liEnrolledClosedOutNotification']")).getCssValue("color"));
		driver.switchTo().defaultContent();
		
	}

}
