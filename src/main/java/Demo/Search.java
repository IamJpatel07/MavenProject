package Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Search {
	
static WebDriver  web = null;
	
	@BeforeTest
	public static void BT() {
		
		System.setProperty("webdriver.chrome.driver", "Driver//chromedriver.exe" );
		
		web = new ChromeDriver();
		web.get("https://www.selenium.dev/downloads/");
	}
	
	@AfterTest
	public static void FT() {
		web.close();
	}
	
	@Test(priority=1)
	public static void test() {
		
		web.findElement(By.id("gsc-i-id1")).sendKeys("Testing");
		web.findElement(By.id("gsc-i-id1")).sendKeys(Keys.ENTER);
		String expvalue = "Programmable Search Engine";
		String actvalue = web.getTitle();
		Assert.assertEquals(expvalue, actvalue);
	}
	
	@Test(priority=0)
	public static void PL() {
		web.findElement(By.className("releases-button")).click();
		web.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		web.findElement(By.className("close")).click();
	}

}
