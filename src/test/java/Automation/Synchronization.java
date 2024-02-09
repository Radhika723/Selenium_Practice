package Automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Synchronization
{
	static WebDriver driver;
	static WebDriverWait wait;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://admin-demo.nopcommerce.com/admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void explycit() throws InterruptedException
	{
	     WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
         submit.click();
         
	 	
         WebElement cate = driver.findElement(By.xpath("//*[@class='nav-icon fas fa-book']"));
	     cate.click();
	     
	     WebElement product = driver.findElement(By.xpath("//p[text()=' Products']"));
	     product.click();
	     
	     JavascriptExecutor scroll = (JavascriptExecutor)driver;
	     scroll.executeScript("window.scrollBy(0, 900);");
	     
	     //List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@name ='checkbox_products']"));
	     List<WebElement> checkboxes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@name ='checkbox_products']")));
	    
	     checkboxes.size();
	    /* for(WebElement check : checkboxes)
	     {
	    	 if(!check.isSelected())
	    	 {
	    		 check.click();
	    		 System.out.println("checkbox is selected");
	    		 Thread.sleep(2000);
	    
	    	 }
	    	
	       if(check.isSelected())
	       {
	    	   check.click();
	    	   System.out.println("checkbox is deselect");
	       } */
	    	 
	     // Select the check box by choice
	     {
	    	 for(WebElement check :checkboxes )
	    	 {
	    		 String selectcheck =	check.getAttribute("Value"); 
	    		 if(selectcheck.equals("1") || selectcheck.equals("3") || selectcheck.equals("5"))
	    		 {
	    			 check.click();
	    			 System.out.println("selected checkboxes are" +selectcheck);
	    		 }
	    	 }
	    	 
	    
	     }
	     
	     
	     
	   
	}
	

}
