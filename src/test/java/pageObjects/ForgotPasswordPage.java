package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement lnkMyaccount;
    
    @FindBy(linkText="Login")
	WebElement linkLogin;
    
    @FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailAddress;
    
    @FindBy(xpath="//a[text()='Forgotten Password']")
    WebElement fpwd;
    	
    @FindBy(xpath="//input[@id='input-email']")
    WebElement email;
    	
    @FindBy(xpath="//input[@value='Continue']")
    WebElement con_tinue;
    
    public void clickLogin()
    {
    	linkLogin.click();
    }
    
    public void clickMyAccount()
    {
    	lnkMyaccount.click();
    }
    
    public void setEmail(String email)
    {
    	txtEmailAddress.sendKeys(email);
    }    	
    	
    public void forgotPassword()
    {
    	fpwd.click();
    }
    
    public void femail(String txt)
    {
    	email.sendKeys(txt);
    }
    
    public void continuebtn()
    {
    	con_tinue.click();
    }
    
	

}
