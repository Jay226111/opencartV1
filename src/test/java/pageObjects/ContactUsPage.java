package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	
	WebDriver driver;
	
	public ContactUsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-phone']")
	WebElement phoneicon;
	
	@FindBy(xpath="//input[@id='input-name']")
	WebElement urnamebox;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailidbox;
	
	@FindBy(xpath="//textarea[@id='input-enquiry']")
	WebElement enquirybox;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submitbtn;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement continuebtn;
	
	/*@FindBy(xpath="//a[normalize-space()='Your Store']")
	WebElement urstorehomepg;*/
	
    public void phone_icon()
    {
    	phoneicon.click();
    }
     
    public void your_name(String name)
    {
    	urnamebox.sendKeys(name);
    }
	public void setEmail(String email)
	{
		emailidbox.sendKeys(email);
	}
	public void enquiry_box(String text)
	{
		enquirybox.sendKeys(text);
	}
	 public void submit_btn()
	  {
		 submitbtn.click();
	  }
	 public void continue_btn()
	 {
		 continuebtn.click(); 
	 }
	 

	 }
	


