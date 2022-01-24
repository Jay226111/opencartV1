package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import java.io.IOException;

public class TC_001AccountRegistration extends BaseClass
{
	//Creating test cases in testNG style
	
	
@Test(groups= {"regression","master"})
	public void test_account_Registration() throws IOException
	{
	    logger.info("Starting TC_001AccountRegistration");	//info logger
try
{
	 
	//    logger.debug("Capturing debug logs...");  //debug logger
	    logger.info("Opening app URL..."); //this will log all info of application
	
	    //driver.get("https://demo.opencart.com/");
		  driver.get(rb.getString("appURL"));  //used this statement instead of above,as we mentioned data in 'config.properties file'
		                                       //No need to Hardcode the data
		driver.manage().window().maximize();

	//  created  object class for Homepage		
	HomePage hp=new HomePage(driver);   
	
		logger.info("Clicking in MyAccount link...");
		hp.clickMyAccount();
		
		logger.info("Clicking on Register link...");
		hp.clickRegister();

	//created object for AccountRegistrationPage class		
		logger.info("Providing user details...");
	AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
	
	//now,by using these objects will pass all data into field	
		regpage.setFirstName("John");
		logger.info("Provided first name");
		
		regpage.setLastName("Canedy");
		logger.info("Provided last name");
		
		String email_id=randomestring()+"@gmail.com";
		//regpage.setEmail("TdOCg@gmail.com"); // To Fail test case and capture screenshot
		regpage.setEmail(email_id);
		logger.info("Provided email: "+ email_id);
		
		regpage.setTelephone("65656565");
		logger.info("Provided telephone number");
		
		regpage.setPassword("abcxyz");
		logger.info("Provided password");
		
		regpage.setConfirmPassword("abcxyz");
		logger.info("Provided confirmed password");
		
		regpage.setPrivacyPolicy();
		logger.info("Set privacy policy");
		
		regpage.clickContinue();
		logger.info("Clicked on continue");
		
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		//if(confmsg.equals("Your Account Has Been Created!!!"))//...test case fails which gives screenshot in Test report
		{
			logger.info("Account Registration success");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.error("Account Registration Failed"); //error logger
			captureScreen(driver,"test_account_Registration");
			Assert.assertTrue(false);
		}
		
}
catch(Exception e)
    {  
	logger.fatal("Account Registration Failed");
	Assert.fail();
	}
		 logger.info("Finished TC_001_AccountRegistration");
	}
	
     
}
