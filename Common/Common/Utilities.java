package Common;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;

import org.openqa.selenium.chrome.ChromeDriver;

import Constant.Constant;
import utils.EmailUtils;

public class Utilities {

	private EmailUtils emailUtils;

	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	public String validEmail() {
		String s = String.valueOf(System.currentTimeMillis());
		return String.format("fancuong22+%s@gmail.com", s.substring(5, s.length()));
	}

	public void connectMail() {
		try {
			emailUtils = new EmailUtils(Constant.USERNAMECHANGEPWD, Constant.PWDCHANGEPWD, "smtp.gmail.com", EmailUtils.EmailFolder.INBOX);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String goToLinkWithinMail() {
		try {
			Message email = emailUtils.getLatestMessage();
			String content = emailUtils.getMessageContent(email);
			return extractUrls(content).get(0);
//			Constant.WEBDRIVER.get(link);

		} catch (Exception e) {
			return null;
		}

	}
	
	 /**
	  * Returns a list with all links contained in the input
	  */
	 public static List<String> extractUrls(String text) {
	  List<String> containedUrls = new ArrayList<String>();
	  String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
	  Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
	  Matcher urlMatcher = pattern.matcher(text);

	  while (urlMatcher.find()) {
	   containedUrls.add(text.substring(urlMatcher.start(0), urlMatcher.end(0)));
	  }

	  return containedUrls;
	 }
}
