package bluestonescenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Scenario8 {
	@Test
	public void scenario1()
	{
		WebDriver driver = new FirefoxDriver();
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://bluestone.com");
		act.moveToElement(driver.findElement(By.xpath("//div[@class='container']/descendant::a[text()='Rings ']"))).perform();
		WebElement e=driver.findElement(By.xpath("//div[@class='container']/descendant::a[text()='Rings ']/following-sibling::div/descendant::a[text()='Diamond']"));
		act.moveToElement(e).perform();
		e.click();
		
		
	}

}
