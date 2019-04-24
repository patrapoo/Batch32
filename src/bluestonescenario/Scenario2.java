package bluestonescenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Scenario2 {
	String text;
	String a[];
	@Test
	public void scenario2()
	{
		WebDriver driver = new ChromeDriver();
		Actions act=new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://bluestone.com");
		driver.findElement(By.id("search_query_top_elastic_search")).sendKeys("rings");
		driver.findElement(By.xpath("//div//following-sibling::input[@name='submit_search']")).click();
		WebElement e=driver.findElement(By.xpath("//section[@id='Gender-form']/descendant::span[text()='Gender']"));
		act.moveToElement(e).perform();
		 text=driver.findElement(By.xpath("//section[@id='Gender-form']/descendant::span[text()=' Women ']")).getText();
		 System.out.println(text);
		 a=text.split(" ");
		 System.out.println("count of women is "+a[1]);
		 driver.close();
		 }

}
