package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddCart;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_006_AddCart extends BaseClass {
	
@Test
public void test_addcart()
{
	logger.info("Starting TC_006_AddCart");
	
	try
	{
		driver.get(rb.getString("appURL"));
	  HomePage hp=  new HomePage(driver);
		logger.info("Home Page Displayed ");
		 
		driver.manage().window().maximize();
		
	  AddCart ac=new AddCart(driver);
	    ac.search_txt("iMac");
	    
	    Thread.sleep(2000);
	    logger.info("Enter desired product");
	    
	    ac.search_button();
		Thread.sleep(3000);
		logger.info("Product displayed on HomePage");
		
		ac.addcart();
		logger.info("Product added to cart");
		Thread.sleep(2000);//
		
        String confmsg=ac.getConfirmationMsg();
		logger.info(confmsg);
		
		if(confmsg.contains("Success: You have added iMac to your shopping cart!"))
		{
			logger.info("Add cart is successful");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Add cart Page Failed ");
			captureScreen(driver,"test_addcart"); 
			
			Assert.assertTrue(false);
		}
		
		ac.view();
		Thread.sleep(3000);
		logger.info("Product added to view");
		
		ac.viewcart();
		Thread.sleep(3000);
		logger.info("Product added to viewcart");
		
	}
 
	catch(Exception e)
	{
	  logger.fatal("Fatal error:Add cart Failed"); 
	  Assert.fail();
	}
	logger.info("Finished TC_006_AddCart");
}
}


	
