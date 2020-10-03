package selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class WebElementInstance {

	Logger logger = LogManager.getLogger(WebElementInstance.class);
	
	WebElement element;
	String description;
	public WebElementInstance(WebElement element, String description) {
		this.element = element;
		this.description = description;
	}
	
	public void click() {
		logger.debug("Click on "+description);
		element.click();
	}
	
	public void enterText(String text) {
		logger.debug("Enter text: "+text+" to "+description);
		element.sendKeys(text);
	}
	
}
