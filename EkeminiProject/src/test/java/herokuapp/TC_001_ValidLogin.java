package herokuapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_001_ValidLogin {
	//declare webdriver
	public static WebDriver driver;
	private String baseURL;
	
	@BeforeTest
	public void setUp() {
		//setup browser driver and path
		System.setProperty("webdriver.edge.driver", "EkeminiProject\\src\\test\\resources\\drivers\\edge\\msedgedriver.exe");
		//instantiate webdriver object
		driver=new EdgeDriver();
		//maximize browser
		driver.manage().window().maximize();
		baseURL = "https://the-internet.herokuapp.com/";
	}
	@Test()
	public void Validlogin() {
		//navigate to base url
		driver.get(baseURL);
		//manage synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//find Form Authentication link element and click on it.
		driver.findElement(By.xpath("//a[contains(text(),'Form Authentication')]")).click();
		//find username input field element and send valid username.
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		//find password input field element and send valid password.
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		//find login button element and click on it.
		driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();		
		//find and store success message
		WebElement ExpectedsuccessMessage = driver.findElement(By.xpath("//*[@class=\'flash success\']"));
		//instantiate soft assert object
		SoftAssert softassert = new SoftAssert(); 
		//assert successful login
		softassert.assertTrue(ExpectedsuccessMessage.isDisplayed());
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}

