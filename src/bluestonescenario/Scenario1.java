package bluestonescenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Scenario1 {
	String text,a[];
	@Test
public void scenario1()
{
	WebDriver driver = new ChromeDriver();
	Actions act=new Actions(driver);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://bluestone.com");
	driver.findElement(By.xpath("//div[@class='container']/descendant::a[text()='Rings ']")).click();
	act.moveToElement(driver.findElement(By.xpath("//div[@id='top-filter']/descendant::section[@id='Gold Purity-form']/child::span"))).perform();
	text=driver.findElement(By.xpath("//div[@id='top-filter']/descendant::section[@id='Gold Purity-form']/child::span/following-sibling::div/descendant::span[text()=' 22k ']")).getText();
	System.out.println(text);
	 a=text.split(" ");
	 System.out.println("count of 22k is "+a[1]);
	 driver.close();
}
}
