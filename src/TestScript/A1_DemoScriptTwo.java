/**
 * 
 */
package TestScript;

import java.util.Random;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import GenericLibrary.BaseClass;

/**
 * @author KiranP
 *
 */
public class A1_DemoScriptTwo extends BaseClass
{
	
	static Random ran = new Random();
	static int rNo = ran.nextInt(10000);//generating the random no from 1 to  10k
	
	@Test
	public void testDemo2() throws InterruptedException
	{
		System.out.println("Random No is"+randomTradeNO());
		System.out.println("inside Demo Test");
		test.log(LogStatus.PASS, "inside Demo Test");
		System.out.println("Random No is"+randomTradeNO());
		Thread.sleep(3000);
	}
	
	public String randomTradeNO() {
		String randomNo = "TRANO" + ran.nextInt(10000);
		return randomNo;

	}

}
