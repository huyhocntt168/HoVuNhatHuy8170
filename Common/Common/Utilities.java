package Common;

import org.openqa.selenium.chrome.ChromeDriver;

import Constant.Constant;
import utils.EmailUtils;

public class Utilities {

	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	public String getValidEmail() {
		String s = String.valueOf(System.currentTimeMillis());
		return String.format("fancuong22+%s@gmail.com", s.substring(5, s.length()));
	}
	
	
	public String getActiveLink() {
		return EmailUtils.getLinkWithinMail();
	}
	
	public void navigateToUrl(String url) {
		Constant.WEBDRIVER.navigate().to(url);
	}
}
