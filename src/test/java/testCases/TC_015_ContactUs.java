package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_015_ContactUs extends BaseClass{
	
	@Test
	public void test_Baseclass()
	{
		logger.info("Starting TC_015_ContactUs");
		
		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("Home Page Displayed ");
			
			driver.manage().window().maximize();
			
			ContactUsPage cu=new ContactUsPage(driver);
			
			cu.phone_icon();
			logger.info("Clicked on phone icon");
			
			cu.your_name("ABC1");
			logger.info("Entered Your name");
			
			cu.setEmail("sel_auto_test123@gmail.com");
			logger.info("Entered email id");
			
			cu.enquiry_box("iMac details");
			logger.info("Enquiry enterd");
			
			cu.submit_btn();
			logger.info("Enquiry submitted");
			
			cu.continue_btn();
			logger.info("Clicked on contibue button");
			
			HomePage hp=new HomePage(driver);
			
			String pagetitle=hp.getPageTitle();
			
			if(pagetitle.equals("Your Store"))
				{
				 logger.info("Home page displayed");
				 Assert.assertTrue(true);
				}
			else
				{
					logger.info("Home Page not displayed: " +pagetitle);
					captureScreen(driver,"test_ContactUs");
					Assert.assertTrue(false);
				}
			}
		catch(Exception e)
		{
			logger.fatal("Product not displayed");
			Assert.fail();
		}
		logger.info("TC_015_ContactUs finished");
		
	}

}
