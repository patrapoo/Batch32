package bluestonescenario;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Scenario9 {
	List<String> ls;
	@Test
	public void priceSorting() throws Exception {
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://bluestone.com");
		driver.findElement(By.xpath("//a[text()='Rings ']")).click();
		act.moveToElement(driver.findElement(By.xpath("//span[text()=' Popular ']"))).perform();
		driver.findElement(By.xpath("//div[@id='view-sort-by']/descendant::a[text()='Price Low to High ']")).click();
		Thread.sleep(3000);
		List<WebElement> l = driver.findElements(By.xpath("//ul[@id='product_list_ui']/descendant::span[@class='new-price']"));
		Thread.sleep(3000);
		for (int i=0; i<l.size(); i++) {
			Thread.sleep(3000);
			System.out.println(l.get(i).getText());
			//String s=l.get(i).getText();
			ls = new ArrayList<String>();
			ls.add(i,l.get(i).getText());
			
			
		}
	
	TreeSet<String> ts=new TreeSet<String>(ls);
    	Assert.assertEquals(ls, ts);
	

}
}
