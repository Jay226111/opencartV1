package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.OrderHistoryPage;
import testBase.BaseClass;

public class TC_012_OrderHistory extends BaseClass{
	
	@Test
	
	public void test_Orderhistory()
	{
	   logger.info("Starting TC_012_Orderhistory");
		
		try
		{
			driver.get(rb.getString("appURL"));
		 HomePage hp=  new HomePage(driver);
			 logger.info("Home Page Displayed");
					
			 driver.manage().window().maximize();
			 
		hp.clickMyAccount();
		logger.info("My account clicked");
		
		OrderHistoryPage ordhis=new OrderHistoryPage(driver);
		
		ordhis.order_history();
		logger.info("Order history clicked");
		
		String orderhistorymsg=ordhis.order_historydisplayed();
		logger.info(orderhistorymsg);
		
		if(orderhistorymsg.equals("Order History"))
		{
			logger.info("Order History page displayed");
		}
		else
		{
			logger.info("Order history page not displayed");
			captureScreen(driver,"TC_012_OrderHistory");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		
			{
		      logger.fatal(" fatal error:Page not displayed");
				   Assert.fail();
		    }
		      	logger.info("Finished TC_012_OrderHistory");
		
		
		
	    }

}
