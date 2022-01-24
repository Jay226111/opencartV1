package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.WishListPage;
import testBase.BaseClass;

public class TC_009_WishList extends BaseClass {
	
	@Test
	public void test_Wishlist()
	{
		logger.info("Starting TC_009_WishList");
		
		try
		{
			driver.get(rb.getString("appURL"));
	  HomePage hp=  new HomePage(driver);
			 logger.info("Home Page Displayed ");
			
				driver.manage().window().maximize();
			  hp.clickMyAccount();
			  logger.info("Clicked Myaccount button");
			  
			  hp.clickLogin();
			   Thread.sleep(2000);
			   logger.info("Clicked Login button");
			   
	   LoginPage lp=new LoginPage(driver);
			   
			   lp.setEmail(rb.getString("email"));
				logger.info("Provided Email ");
				
				lp.setPassword(rb.getString("password"));
				logger.info("Provided Password ");
				
				lp.clickLogin();
				logger.info("Clicked on Login");
			    
			  hp.productSearch("iMac");
				Thread.sleep(2000);
				logger.info("Product Entered in searchbox");
				
			  hp.clkbtn();
				Thread.sleep(2000);
				logger.info("Clicked on search button");
				
		WishListPage wlp=new WishListPage(driver);
		
			wlp.add_wishlist();
			 Thread.sleep(2000);
			 logger.info("Clicked add wish to wish list");
			 
			 String confirmationmsg=wlp.getConfirmationmsg();
			 logger.info(confirmationmsg);
			 
			 if(confirmationmsg.contains("Success: You have added iMac to your wish list!"))
			    {
				 logger.info("Confirmation msg is successful");
					Assert.assertTrue(true);
				}
				else
				{
					logger.error("No confirmation msg");
					captureScreen(driver,"test_WishList"); 
					
					Assert.assertTrue(false);
				} 
			 
			 wlp.wishlist();
			 
			 logger.info("Wishlist displayed");
			 }
		catch(Exception e)
		{
			logger.fatal("Fatal error:Wish list is not diplayed"); 
			  Assert.fail();
		}
		
		logger.info("TC_009_WishList ended");
		}
	}


