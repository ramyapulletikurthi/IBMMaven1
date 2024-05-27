package sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Crossbr {
	
	WebDriver driver;
	
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) throws Exception {
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell\\Downloads\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Downloads\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			throw new Exception("Browse is not correct");
		}
	}
	
	@Test
	public void petStore(){
		driver.get("https://petstore.octoperf.com/");
		driver.findElement(By.partialLinkText("Enter the Store")).click();
		driver.findElement(By.partialLinkText("Sign In")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("signon")).click();
	}
	
	

}
