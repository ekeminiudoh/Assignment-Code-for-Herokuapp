package herokuapp;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class TC_002_VerifyInvalidLogin {
	//declare webdriver
		public static WebDriver driver;
		private String baseURL;
  @Test
  public void Invalidlogin() {
		//navigate to base url
		driver.get(baseURL);
		//manage synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//find Form Authentication link element and click on it.
		driver.findElement(By.xpath("//a[contains(text(),'Form Authentication')]")).click();
		//find username input field element and send invalid username.
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("thomas");
		//find password input field element and send invalid password.
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SecretPassword!");
		//find login button element and click on it.
		driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();		
		//find and store success message
		WebElement ExpectedFailureMessage = driver.findElement(By.xpath("//*[@class=\'flash error\']"));
		//instantiate soft assert object
		SoftAssert softassert = new SoftAssert(); 
		//assert unsuccessful login
		softassert.assertTrue(ExpectedFailureMessage.isDisplayed());
	}
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

  @AfterTest
  public void tearDown() {
		//driver.quit();
	}

}
