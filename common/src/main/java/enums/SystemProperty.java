package enums;

public enum SystemProperty {
	BASE_URL("baseUrl"), CHROME_DRIVER("webdriver.chrome.driver");

	public final String key;
	
	private SystemProperty(String key) {
		this.key = key;
	}
}
