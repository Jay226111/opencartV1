package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ReturnsPage;
import testBase.BaseClass;

public class TC_014_Returns extends BaseClass{
	
	@Test
	
	public void test_Returns()
	{
		logger.info("Starting TC_013_RewardPoints");
		
		try
		{
			driver.get(rb.getString("appURL"));
		 HomePage hp=  new HomePage(driver);
			logger.info("Home Page Displayed ");
				 
			driver.manage().window().maximize();
			
			hp.clickMyAccount();	
			logger.info("My account clicked");
				
			hp.clickRegister();
			logger.info("Register clicked");
			
			ReturnsPage rp=new ReturnsPage(driver);
			
			rp.returns();
			logger.info("Returns clicked");
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setEmail(rb.getString("email"));
			logger.info("Email id entered");
			
			lp.setPassword(rb.getString("password"));
			logger.info("Password entered");
			
			lp.clickLogin();
			logger.info("Login clicked");
			
			String productreturns=rp.product_returns();
			if(productreturns.equals("Product Returns"))
			{
				logger.info("Product Returns displayed");
			}
			else
			{
				logger.info("Product Returns not displayed");
				captureScreen(driver,"TC_014_Returns");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		
		{
		      logger.fatal(" fatal error:Page not displayed");
				   Assert.fail();
	     }
	
	logger.info("Finished TC_014_Returns");
	}

}
