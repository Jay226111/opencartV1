package testBase;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
    public Logger logger;       //created variable for logger class,then initiate this variable inside setup() method
	public ResourceBundle rb;

	@BeforeClass(groups= {"master","sanity","regression"})
	@Parameters({"browser"}) //updated setup()method for parallel testing
	public void setup(String br)  //whtever parameter passing through XML file,setup() method receiving that in String br variable
	{
	//Load config.properties file      *properties file has data-->Base class code reads data this data--> data used in Test cases
		 
		  rb= ResourceBundle.getBundle("config");                               //this avoids hardcoding of data and reusability can be achived
		
		
	// initiate Logging
	      logger=LogManager.getLogger("this.getClass()"); //instead of hardcoding Test Case id, we specified class name of that TC
		                    //"this.getClass()" will dynamically give class name(TC_001AccountRegistration)
	
	   //Driver
	    if(br.equals("chrome"))
	    {
	        WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		    logger.info("Launched Chrome Browser");

	    }
	    else if(br.equals("firefox"))
	    {
	    	WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			logger.info("Launched firefox Browser");

	    }
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass(groups= {"master","sanity","regression"})
	public void tearDown()
	{
	driver.close();
	}
	
	
	public String randomestring() {    //when we call this method in TC,it returns unique email id,
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	
	public int randomeNumber() {   //to generate random numbers
		String generatedString2 = RandomStringUtils.randomNumeric(5);
		return (Integer.parseInt(generatedString2));//coverts String to integer
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"\\screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
	}

}
