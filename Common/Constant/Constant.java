package Constant;

import org.openqa.selenium.WebDriver;;

public class Constant {

	public static WebDriver WEBDRIVER;
//	public static final String RAILWAY_URL = "http://192.168.189.206:8888/Page/HomePage.cshtml";
	public static final String RAILWAY_URL = "https://dbdeec00.ngrok.io";
	public static final String USERNAME = "huy.ho@logigear.com";
	public static final String USERNAME_ACTIVATION = "fancuong22@gmail.com";
	public static final String USERNAME_INACTIVE = "huyhocntt168+1@gmail.com";
	public static final String PASSWORD_INACTIVE = "123456789";
	public static final String PASSWORD = "L0gigear1993";
	public static final String PASSWORD_CHANGED = "987654321";
	public static final String PASSWORD_ACTIVATION = "01203508910";
	public static final String PID = "123456789";
	public static final String EMPTY = "";
	public static final String INVALID_DATE = "12072018";
	
	public enum TabName {
		LOGOUT("Log out"),
		LOGIN("Login"),
		BOOKTICKET("Book ticket"),
		MYTICKET("My ticket"),
		CHANGEPASSWORD("Change password"),
		REGISTER("Register"),
		TIMETABLE("Timetable");
		
		private String tabName;
		TabName(String tabname) {
			this.tabName = tabname;
		}
		
		public String getName() {
			return tabName;
		}
	}
	
}

