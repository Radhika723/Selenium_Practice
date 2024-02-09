package Automation;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InterFaces
{
	static WebDriver driver;
	//static WebDriverWait wait;
	
	@BeforeClass
	public void setup()
	{
	   	driver = new ChromeDriver();
	   //	driver.get("https://admin-demo.nopcommerce.com/admin/");
	   	driver.get("https://admin-demo.nopcommerce.com/login?returnurl=%2Fadmin%2F");
	   	driver.manage().window().maximize();
	   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   	driver.findElement(By.xpath("//*[@type='submit']")).click();

	}
	
  @Test(priority = 3)
	public void popup() throws AWTException, InterruptedException, IOException
	{

	 	/*driver.findElement(By.xpath("//*[@type='text']")).sendKeys("po");
	 	
	 	Robot r = new Robot();
	 	r.keyPress(KeyEvent.VK_DOWN);
	 	r.keyRelease(KeyEvent.VK_DOWN);
	 	
	 	r.keyPress(KeyEvent.VK_DOWN);
	 	r.keyRelease(KeyEvent.VK_DOWN); */
	 	
	 	TakesScreenshot ts = (TakesScreenshot)driver;
	 	File source = ts.getScreenshotAs(OutputType.FILE);
	 	File target=new File(".\\Screenshots\\page.png");
	 	FileUtils.copyFile(source, target);

	   /*Robot r = new Robot();
	   r.keyPress(KeyEvent.VK_ENTER);
	   r.keyRelease(KeyEvent.VK_ENTER); */
	}

  
 @Test(priority = 2)
  public void fileupload() throws InterruptedException, AWTException
  {
	 driver.findElement(By.xpath("//p[normalize-space()='Configuration']")).click();
     driver.findElement(By.xpath("//p[normalize-space()='Settings']")).click();
     driver.findElement(By.xpath("//p[normalize-space()='General settings']")).click();
     Thread.sleep(1000);
     //driver.findElement(By.id("picture1088074574"));
     driver.findElement(By.xpath("//*[@class='upload-image-button float-left px-md-1']")).click();
     
   /*  Robot rb = new Robot();
     //To copy the file cntr+c
     StringSelection ss = new StringSelection("‪‪C:\\Users\\User\\Downloads\\");
     Thread.sleep(1000);
     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
     
     rb.keyPress(KeyEvent.VK_CONTROL);
     rb.keyPress(KeyEvent.VK_V);
     
     rb.keyRelease(KeyEvent.VK_CONTROL);
     rb.keyRelease(KeyEvent.VK_V);
     //Thread.sleep(1000);
     rb.keyPress(KeyEvent.VK_ENTER);
     rb.keyRelease(KeyEvent.VK_ENTER); */
  }
  
  @Test(priority=1)
  public void froms() throws AWTException
  {
	  driver.findElement(By.xpath("//p[normalize-space()='Catalog']")).click();
	  driver.findElement(By.xpath("//p[normalize-space()='Products']")).click();
	  driver.findElement(By.id("SearchProductName")).sendKeys("Facebook");
	  
	  WebElement category = driver.findElement(By.name("SearchCategoryId"));
	  category.click();
	  Select ss = new Select(category);
	  ss.selectByValue("1");
	  
	  Actions tab = new Actions(driver);
	  tab.sendKeys(Keys.TAB).perform();
	    
	  WebElement checkbox = driver.findElement(By.className("check-box"));
	  checkbox.click();
	//  Actions check = new Actions(driver);
	 // check.click(checkbox).perform();
	  
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
    
   Assert.assertEquals(elementText,"data available in table","String not match" );
	
	
	  
	  
	
	  
	  
	  
  }
  
	    
       
	 @AfterClass
     public void close()
     {
  	   driver.close();
     }
	

}
