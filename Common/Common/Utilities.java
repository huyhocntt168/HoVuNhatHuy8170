package Common;

import org.openqa.selenium.chrome.ChromeDriver;

import Constant.Constant;
import utils.EmailUtils;

public class Utilities {
	public static String createdEmail;

	public static void openChrome() {
		System.setProperty("webdriver.chrome.driver", "Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	public static String getValidEmail() {
		String s = String.valueOf(System.currentTimeMillis());
		return createdEmail =  String.format("fancuong22+%s@gmail.com", s.substring(5, s.length()));
	}
	
	public static String getActiveLink() {
		return EmailUtils.getLinkWithinMail();
	}
	
	public static void navigateToUrl(String url) {
		Constant.WEBDRIVER.navigate().to(url);
	}
	
	public static boolean isDateValid(String date) {
		String[] mdy = date.split("/");
		if(mdy.length == 3) {
			return true;
		}
		else
			return false;
	}
}
