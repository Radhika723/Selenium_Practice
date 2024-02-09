package Automation;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleMultipleWindow
{ 
WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
	     driver = new ChromeDriver();
	     driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	     
	}
	
	/* @Test
    public void login()
	{
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
	} */
     @Test
     public void multiplewindow() throws InterruptedException
     {
    	 driver.findElement(By.cssSelector("a[href='http://www.orangehrm.com']")).click();
    	 Thread.sleep(2000);
    	 
    	//getWindowHandle() for single window handle
    	 String wndid = driver.getWindowHandle();
    	 System.out.println(wndid);
    	 
    	//getWindowHandles() for multiple window handle
    	 Set<String> winid = driver.getWindowHandles();
    	 
    	 // To retrive the id's
    	 //1) iterator()
    	 Iterator <String> It = winid.iterator();
    	 String parentwindowid = It.next();
    	 String childwindowid = It.next();
    	 
    	 System.out.println("Parent ID" +parentwindowid);
    	 System.out.println("Child ID " +childwindowid);
    	 
	 
     }
	

}
