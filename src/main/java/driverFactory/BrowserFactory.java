package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {

	private static final ThreadLocal<WebDriver> driverHub = new ThreadLocal<>();

	public static synchronized void setDriver(String browser) {
		WebDriver driver;
		if (browser.equalsIgnoreCase("Chrome")) {
//           ChromeOptions options = new ChromeOptions ();
//           options.addArguments ("--disable-blink-features=AutomationControlled");
			driver = new ChromeDriver();
		} else {
			driver = new EdgeDriver();
		}
		driverHub.set(driver);
		System.out.println("Driver handed over to driverHub!");
	}

	public static synchronized WebDriver getDriver() {
		return driverHub.get();
	}

	public static synchronized void removeDriver() {
		driverHub.remove();
	}

}
