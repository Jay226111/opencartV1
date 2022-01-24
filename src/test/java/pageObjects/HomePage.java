package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver; 
	
	public HomePage(WebDriver driver)  //created constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
 @FindBy(xpath="//span[text()='My Account']")
 WebElement lnkMyaccount;
 
 @FindBy(linkText="Register")
 WebElement lnkRegister;
 
 @FindBy(linkText="Login")
 WebElement lnkLogin;
 
 @FindBy(xpath="//input[@placeholder='Search']")
	WebElement search_box;

 @FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement search_bt;

 
 
 public void clickMyAccount()
    {
	 lnkMyaccount.click();
    }
 
 public void clickRegister()
	{
		lnkRegister.click();
	}
	
 public void clickLogin()
	{
		lnkLogin.click();
	}
 public void productSearch(String productName)
	{
		search_box.sendKeys(productName);
	}
 public void clkbtn()
	{
		search_bt.click();
	}
 public String getPageTitle()
   {
	return(driver.getTitle()); 
   }
}
