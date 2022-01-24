package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RewardPointsPage;
import testBase.BaseClass;

public class TC_013_RewardPoints extends BaseClass{
	
	@Test
	
	public void test_Rewardpoints() throws IOException
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
				
				RewardPointsPage rewardpts=new RewardPointsPage(driver);
				
				rewardpts.reward_point();
				logger.info("Reward points clicked");
				
				LoginPage lp=new LoginPage(driver);
				
				lp.setEmail(rb.getString("email"));
				logger.info("Email id entered");
				
				lp.setPassword(rb.getString("password"));
				logger.info("Password entered");
				
				lp.clickLogin();
				logger.info("Login clicked");
				
				String repoints=rewardpts.your_rewardpoint();
				if(repoints.equals("Your Reward Points"))
				{
					logger.info("Your Reward points displayed");
				}
				else
				{
					logger.info("Your Reward points not displayed");
					captureScreen(driver,"TC_013_RewardPoints");
					Assert.assertTrue(false);	
				}
		}
		catch(Exception e)
		
			{
			      logger.fatal(" fatal error:Page not displayed");
					   Assert.fail();
			    }
		
		logger.info("Finished TC_013_RewardPoints");
				
		}
	

}
