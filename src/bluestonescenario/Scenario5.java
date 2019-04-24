package bluestonescenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Scenario5 {
	String expDispAmount,expDispEmail,actDispEmail,actDispAmount;
	@Test
	public void scenario4()
	{
		 expDispAmount="Rs 4,500";
		 expDispEmail="patrapooja888@gmail.com";
		WebDriver driver = new ChromeDriver();
		Actions act=new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://bluestone.com");
		driver.findElement(By.xpath("//a[@title='Gold Mine 10+1 Monthly Scheme']")).click();
		driver.findElement(By.id("amount")).sendKeys("4500");
		driver.findElement(By.id("Email")).sendKeys("patrapooja888@gmail.com");
		driver.findElement(By.id("tahLpSubmit")).click();
		actDispEmail=driver.findElement(By.id("email")).getAttribute("value");
		actDispAmount=driver.findElement(By.name("subscriptionAmount")).getText();
		Assert.assertEquals(expDispAmount, actDispAmount);
		Assert.assertEquals(expDispEmail, actDispEmail);
		
}
}
