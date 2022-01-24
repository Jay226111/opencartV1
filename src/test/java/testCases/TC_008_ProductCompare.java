package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ProductComparePage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_008_ProductCompare extends BaseClass{
	
	@Test
	public void test_ProductCompare()
	{
		logger.info("Starting TC_008_ProductCompare");
		
		try
		{
			driver.get(rb.getString("appURL"));
		  HomePage hp=  new HomePage(driver);
			logger.info("Home Page Displayed ");
		
			driver.manage().window().maximize();	
		    
		  hp.productSearch("MacBook");
			 Thread.sleep(2000);
			 logger.info("Product Entered in searchbox");
			
		  hp.clkbtn();
			 Thread.sleep(2000);
			 logger.info("Clicked on search button");
			
			
		  ProductComparePage pc=new ProductComparePage(driver);
		    pc.product_btn1();
		    
		    Thread.sleep(2000);
		    logger.info("Clicked on desired product");
		    
		    String confmsg=pc.getConfirmationMsg1();
			logger.info(confmsg);
			
			if(confmsg.contains("Success: You have added MacBook to your product comparison!"))
			{
				logger.info("Confirmation msg1 is successful");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("No confirmation msg1");
				captureScreen(driver,"test_ProductCompare"); 
				
				Assert.assertTrue(false);
			}
		    
		    pc.product_btn2();
			Thread.sleep(3000);
			logger.info("Product2 clicked");
			
			String confmsg2=pc.getConfirmationMsg2();
			logger.info(confmsg2);
			Thread.sleep(2000);//
			
			if(confmsg2.contains("Success: You have added MacBook Air to your product comparison!"))
			{
				logger.info("Confirmation msg2 is successful");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("No confirmation msg2");
				captureScreen(driver,"test_ProductSearch"); 
				
				Assert.assertTrue(false);
			}
			
			pc.product_compare();
			Thread.sleep(2000);
			logger.info("ProductCompare clicked");
		}
		catch(Exception e)
		{
			logger.fatal("Fatal error:Product Compare Failed"); 
			  Assert.fail();
		}
		
			logger.info("TC_008_ProductCompare ended");

	}
}
