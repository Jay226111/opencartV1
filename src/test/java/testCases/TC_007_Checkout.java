package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_007_Checkout extends BaseClass {
	
	@Test
	public void TC_007_Checkout()
	{
		logger.info("Starting TC_007_Checkout");
		try
		{
			driver.get(rb.getString("appURL"));
			
		HomePage hp=new HomePage(driver);
			logger.info("Home Page Displayed");
			
			driver.manage().window().maximize();
		CheckoutPage co=new CheckoutPage(driver);
		
		hp.productSearch("iMac");
		logger.info("Searched iMac");
		
		hp.clkbtn();
	    Thread.sleep(2000);
		logger.info("Clicked on search button");
		
		co.addcart();
	    Thread.sleep(2000);
		logger.info("Product added to cart");
		
		String confmsg=co.addcartconfmsg();
		Thread.sleep(2000);
		logger.info(confmsg);
		
		if(confmsg.contains("Success: You have added iMac to your shopping cart!"))
		{
			logger.info("Add cart is successful");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Add cart Page Failed ");
			captureScreen(driver,"TC_007_Checkout"); 
			
			Assert.assertTrue(false);
		}
		
		co.viewcart();
		 Thread.sleep(2000);
		logger.info("displayed cart");
		
		co.check_out();
		 Thread.sleep(2000);
		logger.info("clicked on checkout button");
		
	//	boolean checkoutpg=co.isPageExists();
		
		if(co.isPageExists())
		{
			logger.error("Checkout Success");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Checkout Failed");
			captureScreen(driver,"TC_007_Checkout");
			Assert.assertTrue(false);
			
		}
	}
		catch(Exception e)
	     {
		   logger.fatal(" fatal error:Checkout failed");
		   Assert.fail();
	     }
      	logger.info("Finished TC_007_Checkout");
	}
}
		
			
		
			
		

