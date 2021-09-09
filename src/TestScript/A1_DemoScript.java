/**
 * 
 */
package TestScript;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import GenericLibrary.BaseClass;
import GenericLibrary.RandomClass;

/**
 * @author KiranP
 *
 */
public class A1_DemoScript extends BaseClass
{
	
	@Test
	public void testDemo() throws InterruptedException
	{
		System.out.println("inside Demo Test");
		System.out.println("Random No is"+RandomClass.randomTradeNO());
		test.log(LogStatus.PASS, "inside Demo Test");
		Thread.sleep(3000);
		
	}
}
