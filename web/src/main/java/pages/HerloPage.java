package pages;

import org.openqa.selenium.By;

import enums.Condition;
import selenium.WebDriverService;
import selenium.WebElementDetails;

public class HerloPage extends AbstractBase {

	private static final WebElementDetails pageContainer = new WebElementDetails(By.cssSelector(".introduction__Introduction-sc-1sqfjhg-0.gIuIWc"), "PAGE CONTINER"); 
	private static final WebElementDetails nameField = new WebElementDetails(By.id("name"), "NAME FIELD");
	private static final WebElementDetails companyField = new WebElementDetails(By.id("company"), "COMPANY FIELD");
	private static final WebElementDetails emailField = new WebElementDetails(By.id("email"), "EMAIL FIELD");
	private static final WebElementDetails phoneField = new WebElementDetails(By.id("telephone"), "phone FIELD");
	private static final WebElementDetails talkWithUsButton = new WebElementDetails(By.cssSelector(".commun__Button-mgrfny-0.commun__ButtonContact-mgrfny-1.form__ButtonContact-sc-1ju2h8q-1.gGWtQr"), "TALK WITH US BUTTON");
	
	public HerloPage(WebDriverService webDriver) {
		super(webDriver);
	}

	@Override
	public void assertOn() {
		waitForElement(pageContainer, Condition.VISIBLE);
	}

	public HerloPage enterName(String name) {
		logger.info("Enter Name");
		waitForElement(nameField, Condition.VISIBLE).enterText(name);
		return this;
	}
	
	public HerloPage enterCompany(String company) {
		logger.info("Enter Company");
		waitForElement(companyField, Condition.VISIBLE).enterText(company);
		return this;
	}
	
	public HerloPage enterEmail(String email) {
		logger.info("Enter Email");
		waitForElement(emailField, Condition.VISIBLE).enterText(email);
		return this;
	}
	
	public HerloPage enterPhone(String phone) {
		logger.info("Enter Phone");
		waitForElement(phoneField, Condition.VISIBLE).enterText(phone);
		return this;
	}
	
	public HerloPage clickTalkWithUsAndStayOn() {
		logger.info("Click "+ talkWithUsButton.description+" and stay on same page");
		waitForElement(talkWithUsButton, Condition.CLICKABLE).click();
		return new HerloPage(webDriver);
	}
	
	public ThankYouPage clickTalkWithUs() {
		logger.info("Click "+ talkWithUsButton.description);
		waitForElement(talkWithUsButton, Condition.CLICKABLE).click();
		return new ThankYouPage(webDriver);
	}
	
	public HerloPage scroll() {
		scroll(5000);
		return this;
	}
}
