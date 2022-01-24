package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RewardPointsPage {
	
	WebDriver driver;

	public RewardPointsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Reward Points")
	WebElement rewardpt;
	
	@FindBy(xpath="//h1[normalize-space()='Your Reward Points']")
	WebElement yourrewardptspg;
	
	public void reward_point()
	{
		rewardpt.click();
	}
	public String your_rewardpoint()
	{
		try
		{
			return(yourrewardptspg.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
		
	}
	
}
