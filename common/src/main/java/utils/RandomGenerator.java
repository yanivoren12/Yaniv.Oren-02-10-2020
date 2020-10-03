package utils;

import org.apache.commons.lang3.RandomStringUtils;
public class RandomGenerator {

	public static String getAlphabetic(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}
	
	public static String getAlphanumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}
	
	public static String getNumeric(int legnth) {
		return RandomStringUtils.randomNumeric(legnth);
	}
	
	public static String getEmail() {
		return getAlphanumeric(10) + "@test.com"; 
	}
	
	public static String getPhone() {
		return "052" + getNumeric(7);
	}
	
}
