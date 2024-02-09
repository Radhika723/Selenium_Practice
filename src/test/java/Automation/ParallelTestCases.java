package Automation;

import org.openqa.selenium.WebDriver;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class ParallelTestCases 
{
	
@Test(groups = {"sanity"})
	public void screenshot() throws AWTException, InterruptedException, IOException
	{
	   WebDriver driver = new ChromeDriver();
	 	driver.get("https://admin-demo.nopcommerce.com/login?returnurl=%2Fadmin%2F");
	   	driver.manage().window().maximize();
	   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   	driver.findElement(By.xpath("//*[@type='submit']")).click();
	   driver.findElement(By.xpath("//p[normalize-space()='Sales']")).click();
	   driver.close();

	}

@Test(groups= {"sanity"})
public void fileupload() throws InterruptedException, AWTException
{
	WebDriver driver = new ChromeDriver();
 	driver.get("https://admin-demo.nopcommerce.com/login?returnurl=%2Fadmin%2F");
   	driver.manage().window().maximize();
   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   	driver.findElement(By.xpath("//*[@type='submit']")).click();
	 driver.findElement(By.xpath("//p[normalize-space()='Configuration']")).click();
   driver.findElement(By.xpath("//p[normalize-space()='Settings']")).click();
   driver.findElement(By.xpath("//p[normalize-space()='General settings']")).click();
   driver.close();
   
   
}

@Test(groups= "smoke")
public void froms() throws AWTException
{
	WebDriver driver = new ChromeDriver();
 	driver.get("https://admin-demo.nopcommerce.com/login?returnurl=%2Fadmin%2F");
   	driver.manage().window().maximize();
   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   	driver.findElement(By.xpath("//*[@type='submit']")).click();
	
	  driver.findElement(By.xpath("//p[normalize-space()='Catalog']")).click();
	  driver.findElement(By.xpath("//p[normalize-space()='Products']")).click();
	  driver.findElement(By.id("SearchProductName")).sendKeys("Facebook");
	  
	  WebElement category = driver.findElement(By.name("SearchCategoryId"));
	  category.click();
	  Select ss = new Select(category);
	  ss.selectByValue("3");
	  
	  Actions tab = new Actions(driver);
	  tab.sendKeys(Keys.TAB).perform();
	    
	  WebElement checkbox = driver.findElement(By.className("check-box"));
	  checkbox.click();

	  Actions tab1 = new Actions(driver);
	  tab.sendKeys(Keys.TAB).perform();
	  
	  WebElement manufracture = driver.findElement(By.id("SearchManufacturerId"));
	  manufracture.click();
	  Select ssm = new Select(manufracture);
	  ssm.selectByValue("1");
	  
	  Robot rb = new Robot();
	  rb.keyPress(KeyEvent.VK_TAB);
	  rb.keyRelease(KeyEvent.VK_TAB);
	  
	 
	WebElement vendor = driver.findElement(By.name("SearchVendorId"));
	vendor.click();
	Select ssv = new Select(vendor);
	ssv.selectByValue("1");
	
	driver.findElement(By.id("search-products")).click();
	String xpathExpression = "//*[contains(@class, 'dataTables_empty')]";
  String elementText = driver.findElement(By.xpath(xpathExpression)).getText();
  System.out.println(elementText);
  Assert.assertEquals(elementText,"No data available in table","String not match" );
  driver.close();
}




}
