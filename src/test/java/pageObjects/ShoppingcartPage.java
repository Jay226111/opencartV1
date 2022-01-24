package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingcartPage {
	
	WebDriver driver;
	
	public ShoppingcartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@id='content']//div[1]//div[1]//div[2]//div[2]//button[1]//i[1]")
	WebElement addtocart;
	
	@FindBy(xpath="//a[normalize-space()='shopping cart']")
	WebElement shoppingcart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successmsg;
	
	public void add_cart()
	{
	addtocart.click();
	}
	
	public void shopping_cart()
	{
	shoppingcart.click();
	}
	
	public String getConfirmationmsg()
	{
		try
		{
			return(successmsg.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
		
	}
	

}
