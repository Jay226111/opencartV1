package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReturnsPage {
	
	WebDriver driver;
	
	public ReturnsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Returns")
	WebElement returnstxt;
	
	@FindBy(xpath="//h1[normalize-space()='Product Returns']")
	WebElement productreturnpage;
	
	public void returns()
	{
		returnstxt.click();
	}
	
	public String product_returns()
	{
		try
		{
			return(productreturnpage.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
		
	}
	

}
