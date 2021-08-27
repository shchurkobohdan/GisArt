package ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;
import java.util.List;
import java.util.Objects;


public class WebDriverFactory {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return Objects.isNull(driver) ? createDriver() : driver;
	}

	private static WebDriver createDriver() {
		var browser = System.getProperty("browser", "chrome");

		switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				var options = new ChromeOptions();
				options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
				driver = new ChromeDriver(options);
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;

			default: throw new IllegalArgumentException(String.format("%s browser is not supported.", browser));
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		return driver;
	}
}
