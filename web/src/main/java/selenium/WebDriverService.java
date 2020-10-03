package selenium;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverService {
	private WebDriver driver;
	public static WebDriverWait wait;
	final static int DEFAULT_TIMEOUT = 10;

	public WebDriverService() throws Exception {
		this.driver = ((AbstractWebDriver) new ChromeWebDriver()).getInstance();
		wait = new WebDriverWait(this.driver, DEFAULT_TIMEOUT);
	}

	public void open(String url) {
		driver.get(url);
		driver.manage().window().fullscreen();
	}

	public WebElement waitForElementCondition(By locator, Function<By, ExpectedCondition<WebElement>> condition,
			int timeout) {
		try {
			if (timeout >= 0 && timeout != DEFAULT_TIMEOUT)
				wait.withTimeout(Duration.ofSeconds(timeout));
			WebElement element = wait.until(condition.apply(locator));
			wait.withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT));
			return element;
		}
		catch (TimeoutException e) {
			throw new TimeoutException("Timeout waiting for element condition: " + e.getMessage());
		}
	}
	

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}


	public void close() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

}
