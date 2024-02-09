package Automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertClass 
{
	WebDriver driver;
	  @Test
	  public void alert() throws InterruptedException
	  {
		 driver = new ChromeDriver();
		 driver.get("https://omayo.blogspot.com/");
		 driver.manage().window().maximize();	
		 driver.findElement(By.id("alert1")).click();
		 
		 Alert al = driver.switchTo().alert();
		 String textalert = al.getText();
		 System.out.println(textalert);
		 Thread.sleep(1000);
		  //al.accept();
		 al.dismiss();
		 Thread.sleep(1000);
		  driver.close();		 
	  }

}
