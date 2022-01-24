package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductComparePage {
	
	WebDriver driver;
	
	public ProductComparePage(WebDriver driver)
	{
		this.driver=driver;
  	    PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@id='content']//div[1]//div[1]//div[2]//div[2]//button[3]//i[1]")
	WebElement product1btn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successmsg1;
	
	@FindBy(xpath="//div[@class='row']//div[2]//div[1]//div[2]//div[2]//button[3]//i[1]")
	WebElement product2btn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successmsg2;
	
	@FindBy(xpath="//a[@id='compare-total']")
	WebElement productcompare;

	public void product_btn1()
	{
		product1btn.click();
	}
	
	public String getConfirmationMsg1()
	{
		try
		{
			return(successmsg1.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
		
	public void product_btn2()
		{
			product2btn.click();	
		}
	
	public String getConfirmationMsg2()
	{
		try
		{
			return(successmsg2.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
		
	public void product_compare()
	{
		productcompare.click();
	}
		
	}
		

