package testCases;

import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_005_ForgotPassword extends BaseClass{
	
	@Test
	public void test_forgotpassword()
	{
		logger.info("Starting TC_005_ForgotPassword");
		
		driver.get(rb.getString("appURL"));
		
		HomePage hp=new HomePage(driver);
		logger.info("Homepage is displayed");
		
		driver.manage().window().maximize();
		
		hp.clickMyAccount();
		logger.info("Clicked on My Account");
		
		hp.clickLogin();
		logger.info("Clicked on Login");
		
		ForgotPasswordPage fp=new ForgotPasswordPage(driver);
		fp.setEmail(rb.getString("email"));
		logger.info("Provided email");
		
		fp.forgotPassword();
		
		fp.femail("sel_auto_test123@gmail.com");
		logger.info("Provided confirmation email");
		
		fp.continuebtn();
		logger.info("Finished TC_005_ForgotPassword");
		
	}

	
}
