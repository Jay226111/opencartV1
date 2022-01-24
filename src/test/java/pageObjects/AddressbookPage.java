package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressbookPage {
	
	WebDriver driver;
	
	public AddressbookPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	/*@FindBy(xpath="//span[@class='caret']")
	WebElement myaccountbtn;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement registerbtn;*/
	
	@FindBy(linkText="Address Book")
	WebElement addressbook;

	/*@FindBy(xpath="//input[@id='input-email']")
	WebElement emailid;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwordtxt;

	@FindBy(xpath="//input[@value='Login']")
	WebElement loginclk;*/
	
	/*public void my_account()
	{
	    myaccountbtn.click();
	}
	
	public void register()
	{
		registerbtn.click();
	}*/
	
	public void address_book()
	{
		addressbook.click();
	}
	
	/*public void email_id(String txt)
	{
		emailid.sendKeys(txt);
	}
	
	public void password(String txt)
	{
		passwordtxt.sendKeys(txt);
	}	
	
	public void login()
	{
	  loginclk.click();
	}*/
	
}
