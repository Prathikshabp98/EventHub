package eventhub.testcases;

import org.testng.annotations.Test;

import eventhub.baseutility.BaseClass;
import eventhub.pageobjectmodel.FixedHeader;
import eventhub.pageobjectmodel.FixedWeb;

public class FixedWebTable extends BaseClass{
	
	
	/*@Test
	public void webTableTest() 
	{
		FixedWeb fixedWeb = new FixedWeb(driver);
		fixedWeb.webTablelaunchApplication();
		fixedWeb.calculateWebTableAmt();

	}*/
	
	
	@Test
	public void fixedHeader()
	{
		FixedHeader fixedHeader = new FixedHeader(driver);
		fixedHeader.webTablelaunchApplication();
		fixedHeader.calculateWebTableAmt();
	}
	
	

}
