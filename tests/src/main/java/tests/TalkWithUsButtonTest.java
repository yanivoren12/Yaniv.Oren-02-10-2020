package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HerloPage;
import utils.RandomGenerator;

public class TalkWithUsButtonTest extends AbstractWebTest{

	HerloPage herloPage;
	@BeforeMethod
	public void beforeTest() {
		herloPage =new HerloPage(webDriver);
		herloPage.scroll();
	}
	@Test(description = "Validate the functionality of the talk with us button")
	public void talkWithUsButtonTest() {
		herloPage.clickTalkWithUsAndStayOn()
				 .enterName(RandomGenerator.getAlphabetic(8))
				 .enterCompany(RandomGenerator.getAlphabetic(8))
				 .enterEmail(RandomGenerator.getEmail())
				  .enterPhone(RandomGenerator.getPhone())
				  .clickTalkWithUs();
	}
}
