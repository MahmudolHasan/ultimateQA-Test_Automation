package tests;

import driverFactory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest extends BrowserFactory {
	private WebDriver driver;

	@BeforeMethod
	public void BrowserInitialization() {
		setDriver("Chrome");
		driver = getDriver();
		driver.manage().window().maximize();
		driver.get("https://ultimateqa.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));

		// driver = TaddCookies(driver);
		// driver.navigate().refresh();
	}

	@AfterMethod
	public void QuiteBrowser() {
		driver.quit();
		removeDriver();

	}

	@AfterTest()
	public void confirmingTearDownAll() {
		if (driver != null) {
			driver.quit();
			removeDriver();
		}
	}

	//////////// Common Function////////////////

	public String getPageTitle() throws InterruptedException {
		Thread.sleep(1000);
		return driver.getTitle();
	}

	public String getPageUrl() throws InterruptedException {
		return driver.getCurrentUrl();
	}
}
