package bluestonescenario;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;





public class Scenario6 {

	int i, j;
	String priceAfterDiscount, priceBeforeDiscount;;
	String afterDiscount[], beforeDiscount[];

	public void scenario6(int off) {

		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://bluestone.com");
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Offers ']"))).perform();
		driver.findElement(By.xpath("//a[text()='Offers ']/following-sibling::div/descendant::span[text()='Flat " + off + "% Off']"))
				.click();
		List<WebElement> lstDiscount = driver.findElements(By.xpath("//ul[@id='product_list_ui']/descendant::span/descendant::span[@id='bst-discounted-price']"));
		for (i = 0; i < lstDiscount.size(); i++)
		{
		priceAfterDiscount = lstDiscount.get(i).getText();
		
		 afterDiscount=new String[lstDiscount.size()];
		 afterDiscount[i]=priceAfterDiscount;
		System.out.println(priceAfterDiscount);
		}
		List<WebElement> lstActual = driver.findElements(By.xpath("//ul[@id='product_list_ui']/descendant::span/descendant::span[@id='bst-actual-price']"));
		for (j = 0; j < lstActual.size(); j++) {
		priceBeforeDiscount = lstActual.get(j).getText();
		beforeDiscount=new String[lstDiscount.size()];
		System.out.println(priceBeforeDiscount);
		Assert.assertEquals(afterDiscount[j], beforeDiscount[j]);
		
		
		}
		/*
		 * Assert.assertEquals(beforeDiscount, afterDiscount); Assert.
		 */
	}
}


