package tests;


import static enums.SystemProperty.BASE_URL;
import static enums.SystemProperty.Log4J;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import selenium.WebDriverService;;

public abstract class AbstractWebTest{

	protected String baseUrl ="https://automation.herolo.co.il/";
	
	protected WebDriverService webDriver;
	
	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty(BASE_URL.key, baseUrl);
		System.setProperty(Log4J.key, "log4j2.properties");
	}
	
	@BeforeMethod
	public void beforeWebTest() throws Exception {
		webDriver = new WebDriverService();
		webDriver.open(baseUrl);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterWebTest() {
		webDriver.close();
	}
}
