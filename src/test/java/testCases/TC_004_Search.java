package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.*;//* it imports all classes of page obj
import testBase.BaseClass;


public class TC_004_Search extends BaseClass{
	
	@Test
	public void test_Search() throws IOException
	{
		logger.info("Starting TC_004_Search");
	
		try
		{
		driver.get(rb.getString("appURL"));
		logger.info("Home Page Displayed ");
		
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		hp.productSearch("imac");
		logger.info("Seaching  product");
		
		hp.clkbtn();
		logger.info("Clicked search button");
		
		SearchPage se=new SearchPage(driver);
				
		boolean display_res=se.imgdisplayed();
		
		if(display_res)
		{
			logger.info("Product displayed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Product not displayed");
			captureScreen(driver,"test_Search"); //Capturing screenshot
			Assert.assertTrue(false);
		}
	}
		catch(Exception e)
		{
			logger.fatal("Product not displayed");
			Assert.fail();
		}
	
	    logger.info("Finished TC_004_Search");

}
	}
