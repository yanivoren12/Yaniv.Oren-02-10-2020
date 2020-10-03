package enums;

public enum SystemProperty {
	BASE_URL("baseUrl"), CHROME_DRIVER("webdriver.chrome.driver"),Log4J("log4j.configurationFile") ;

	public final String key;
	
	private SystemProperty(String key) {
		this.key = key;
	}
}
