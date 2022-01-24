package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	/*@FindBy(xpath="//input[@placeholder='Search']")
	WebElement search_box;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement search_bt;*/
	
	@FindBy(xpath="//img[@title='iMac']")
	WebElement product_img;
	
	/*public void productSearch()
	{
		search_box.sendKeys("pname");
	}
	
	public void clkbtn()
	{
		search_bt.click();
	}*/
	
	public boolean imgdisplayed()
	{
		try
		{
		  return(product_img.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}

}
