package Common;

import org.openqa.selenium.chrome.ChromeDriver;

import Constant.Constant;

public class Utilities {

	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

		public String validEmail() {
		String s = String.valueOf(System.currentTimeMillis());
		return String.format("huy%s@mailinator.com", s.substring(5, s.length()));
	}

}
