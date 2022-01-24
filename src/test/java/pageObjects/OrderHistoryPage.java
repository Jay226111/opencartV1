package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
	
	WebDriver driver;
	
	public OrderHistoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//a[normalize-space()='Order History'])[1]")
	WebElement orderhistorytxt;
	
	@FindBy(linkText="Order History")
	WebElement orderhistorydislayed;
	
	public void order_history()
	{
		orderhistorytxt.click();
	}
	
	public String order_historydisplayed()
	{
	  try
	  {
		  return(orderhistorydislayed.getText());
	  }
	  catch(Exception e)
	  {
		  return(e.getMessage());
	  }
	}
	

}
