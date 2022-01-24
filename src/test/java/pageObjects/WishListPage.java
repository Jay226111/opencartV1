package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
	
	WebDriver driver;
	
	public WishListPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-heart']")
	WebElement addtowishtlist;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successmsg;
	
	@FindBy(xpath="//a[@id='wishlist-total']//i[@class='fa fa-heart']")
	WebElement checkwishlist;
	
	public void add_wishlist()
	{
		addtowishtlist.click();
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
	public void wishlist()
	{
	checkwishlist.click();
	}
	
}
