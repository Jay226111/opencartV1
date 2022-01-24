package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ShoppingcartPage;
import testBase.BaseClass;

public class TC_010_ShoppingCart extends BaseClass {
	
	@Test
	public void test_Shoppingcart()
	{
		logger.info("Starting TC_010_ShoppingCart");
		
		try
		{
         driver.get(rb.getString("appURL"));
	  HomePage hp=  new HomePage(driver);
		 logger.info("Home Page Displayed ");
			
		 driver.manage().window().maximize();
		 
		 hp.productSearch("MacBook");
			logger.info("Seaching  product");
			
		 hp.clkbtn();
		 Thread.sleep(2000);
			logger.info("Clicked search button");
			
	  ShoppingcartPage sc=new ShoppingcartPage(driver);
	    
	     sc.add_cart();
	     logger.info("Product added to cart");
	     
	    String confirmmsg=sc.getConfirmationmsg();
	 
	    if(confirmmsg.contains("Success: You have added MacBook to your shopping cart!"))
	    {
	    	logger.info("Confirmation msg is successful");
		    Assert.assertTrue(true);
	     }
	else
	    {
		logger.error("No confirmation msg: " + confirmmsg);
		captureScreen(driver,"test_Shoppingcart"); 
		
		Assert.assertTrue(false);
	    } 
	    
	    sc.shopping_cart();
		logger.info("Shoping cart page displayed");
	}
		catch(Exception e)
		{
			logger.fatal("Fatal error:Shopping cart page not displayed"); 
			  Assert.fail();
		}
		logger.info("TC_010_ShoppingCart finished");
	}
}

