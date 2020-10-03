package pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import enums.Condition;
import selenium.WebDriverService;
import selenium.WebElementDetails;
import selenium.WebElementInstance;

public abstract class AbstractBase {

	protected WebDriverService webDriver;
	protected Logger logger;
	
	public AbstractBase(WebDriverService webDriver) {
		this.webDriver = webDriver;
		logger = LogManager.getLogger(this.getClass());
		assertOn();
	}
	
	public abstract void assertOn();
	
	public WebElementInstance waitForElement(WebElementDetails elementDetails, Condition condition) {
		return waitForElement(elementDetails, condition, -1);
	}
	
	public WebElementInstance waitForElement(WebElementDetails elementDetails, Condition condition, int timeout) {
        try {
        	logger.info("Waiting for element "+elementDetails.description+" is "+condition.name());
              WebElement we = null;
              switch(condition) {
              case VISIBLE:
                   we = webDriver.waitForElementCondition(elementDetails.locator, ExpectedConditions::visibilityOfElementLocated, timeout);
                   break;
              case CLICKABLE:
                   we =  webDriver.waitForElementCondition(elementDetails.locator, ExpectedConditions::elementToBeClickable, timeout);
                   break;
              default:
                   throw new RuntimeException(condition.name()+ " - is not condition for existing element");
              }
              return new WebElementInstance(we, elementDetails.description);
        } catch(TimeoutException e) {
             webDriver.findElement(elementDetails.locator);
              throw new TimeoutException("Waiting for element: "+elementDetails.description+". "+e.getMessage());
        }

   }
	
	protected void scroll(int num) {
		logger.info("Scroll down by:" +num);
		JavascriptExecutor jse = (JavascriptExecutor)webDriver.getDriver();
		jse.executeScript("window.scrollBy(0,"+num+")");
	}


}
