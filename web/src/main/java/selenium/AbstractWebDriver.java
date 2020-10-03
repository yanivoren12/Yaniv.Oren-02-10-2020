package selenium;

import org.openqa.selenium.WebDriver;

public abstract class AbstractWebDriver {

	protected WebDriver driver;
	
	protected abstract void createDriver() throws Exception;
	
	public WebDriver getInstance() throws Exception {
		if(driver == null)
			createDriver();
		return driver;
	}
}
