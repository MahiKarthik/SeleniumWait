package org.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.By;

import java.time.Duration;
public class FluentWaitClassPrac {
public static void main(String [] arg) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\FluentWaitPract\\Driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	
	driver.navigate().to(" https://www.facebook.com/");
	driver.manage().window().maximize();
	WebElement btnCreate=driver.findElement(By.xpath("(//a[@role='button'])[2]"));
	btnCreate.click();
	//WebDriverWait
	
	/*WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
	WebElement txtFirstName=driver.findElement(By.name("firstname"));
    txtFirstName.sendKeys("mahi");
	*/
	Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).
			pollingEvery(Duration.ofMillis(400)).ignoring(Exception.class);
WebElement txtFirstName=	wait.until(new Function<WebDriver,WebElement>(){
		
		public WebElement apply(WebDriver driver) {
			return driver.findElement(By.name("firstname"));
			
		}
		
	});
	txtFirstName.sendKeys("mhi");
}
}