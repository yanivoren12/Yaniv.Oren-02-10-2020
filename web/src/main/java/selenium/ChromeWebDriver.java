package selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static enums.SystemProperty.CHROME_DRIVER;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeWebDriver extends AbstractWebDriver{

	@Override
	protected void createDriver() throws Exception {
		try {
			System.setProperty(CHROME_DRIVER.key, "//path//to//chromedriver");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-infobars");
			options.addArguments("--start-maximized");
			this.driver = new ChromeDriver(options);
		} catch (Exception e) {
			throw new Exception("Failed to create chrome driver", e);
		}
	}

}
