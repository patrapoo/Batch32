package bluestonescenario;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario4 {
	String expErrorAmount,expErrorEmail,actErrorAmount,actErrorEmail;
	@Test
	public void scenario4()
	{
		 expErrorAmount="Amount is required";
		 expErrorEmail="Email is required";
		WebDriver driver = new ChromeDriver();
		Actions act=new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://bluestone.com");
		driver.findElement(By.xpath("//a[@title='Gold Mine 10+1 Monthly Scheme']")).click();
		driver.findElement(By.id("tahLpSubmit")).click();
		actErrorAmount=driver.findElement(By.id("amount_error")).getText();
		System.out.println(actErrorAmount);
		actErrorEmail=driver.findElement(By.id("Email_error")).getText();
		System.out.println(actErrorEmail);
		
		Assert.assertEquals(expErrorAmount, actErrorAmount);
		Assert.assertEquals(expErrorEmail, actErrorEmail);
		//driver.close();
}
}
