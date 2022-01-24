package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
/*	@FindBy(name="search")
	 WebElement searchtxt;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement searchbutton;*/
	
	@FindBy(xpath="//span[normalize-space()='Add to Cart']")
	WebElement addcart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement confmsg;
	
	@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	WebElement viewcart;
	
	@FindBy(xpath="//strong[normalize-space()='Checkout']")
	WebElement checkout;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement msgconfirm;
	
/*	public void searchtxt(String text)
	{
	    searchtxt.sendKeys(text);
	}
	public void searchbutton() 
	{
		searchbutton.click();
	}*/
	public void addcart()
	{
		addcart.click();
	}
	
	public String addcartconfmsg()
	{
		try
		{
			return(confmsg.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	public void viewcart()
	{
		viewcart.click();
	}
	
	public void check_out()
	{
		checkout.click();
	}
	
	public boolean isPageExists()
	{
		try
		{
		return (msgconfirm.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}
}



