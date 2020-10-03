package pages;

import org.openqa.selenium.By;

import enums.Condition;
import selenium.WebDriverService;
import selenium.WebElementDetails;

public class ThankYouPage extends AbstractBase{

	private static final WebElementDetails pageContainer = new WebElementDetails(By.cssSelector("[class^='thankYou__content']"), "PAGE CONTAINER"); 

	public ThankYouPage(WebDriverService webDriver) {
		super(webDriver);
	}

	@Override
	public void assertOn() {
		waitForElement(pageContainer, Condition.VISIBLE);
	}

}
