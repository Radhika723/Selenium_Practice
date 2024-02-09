package Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SwitchToFrame 
{
	@Test
	public void performframes()
	{
	   WebDriver driver = new ChromeDriver();
	   driver.get("https://jqueryui.com/droppable/");	
	   driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
       // To find the how many iframe is present in the page
       // We can identify the iframe using the 1) index value and web element 
       // The index is starting from the 0,1,2-----
       driver.findElements(By.tagName("iframe")).size();
       driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));
      
       Actions a = new Actions (driver);
       WebElement source = driver.findElement(By.xpath("//*[@class='ui-widget-content ui-draggable ui-draggable-handle']"));
       WebElement target = driver.findElement(By.id("droppable"));
       a.dragAndDrop(source, target).build().perform();
       
       //once the action is done drag and drop in the frame we need to switch from the frame
       driver.switchTo().defaultContent();
    }

}
