package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddressbookPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_011_AddressBook extends BaseClass {
	
	@Test
	public void test_Addressbook()
	
		{
		logger.info("Starting TC_011_AddressBook");
		
		try
		{
			driver.get(rb.getString("appURL"));
		 HomePage hp=  new HomePage(driver);
			 logger.info("Home Page Displayed ");
					
			  driver.manage().window().maximize();
			hp.clickMyAccount();  
			logger.info("My account button clicked");
			
			hp.clickRegister();
			logger.info("Register button clicked");
			
		AddressbookPage addbk=new AddressbookPage(driver);
		
		    addbk.address_book();
		    logger.info("Address book clicked");
		
		LoginPage lp=new LoginPage(driver);

		    lp.setEmail(rb.getString("email"));
		    logger.info("Provided Email ");
		
		    lp.setPassword(rb.getString("password"));
		    logger.info("Provided Password ");
		
		    lp.clickLogin();
		    logger.info("Login clicked");
		
		}
		catch(Exception e)
		{
			logger.fatal("Login Failed ");
			Assert.fail();
		}
		
		logger.info(" Finished TC_011_AddressBook ");
		
		}
		
	}

