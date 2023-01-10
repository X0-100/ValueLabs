package parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)
public class RegisterTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
	driver = new ChromeDriver();
	driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    public void register_happypath() {
	driver.findElement(By.linkText("Register")).click();
	driver.findElement(By.id("customer.firstName")).sendKeys("John");
	driver.findElement(By.id("customer.lastName")).sendKeys("Doe");
	driver.findElement(By.id("customer.address.street")).sendKeys("123 Main St");
	driver.findElement(By.id("customer.address.city")).sendKeys("Anytown");
	driver.findElement(By.id("customer.address.state")).sendKeys("CA");
	driver.findElement(By.id("customer.address.zipCode")).sendKeys("12345");
	driver.findElement(By.id("customer.phoneNumber")).sendKeys("555-555-5555");
	driver.findElement(By.id("customer.ssn")).sendKeys("123-45-6789");
	driver.findElement(By.id("customer.username")).sendKeys("johndoe");
	driver.findElement(By.id("customer.password")).sendKeys("password");
	driver.findElement(By.id("repeatedPassword")).sendKeys("password");
	driver.findElement(By.xpath("//input[@value='Register']")).click();
	String expectedTitle = "ParaBank | Account Created!";
	String actualTitle = driver.getTitle();
	Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void afterMethod() {
	driver.quit();
    }
}
