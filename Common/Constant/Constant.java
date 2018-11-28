package Constant;

import org.openqa.selenium.WebDriver;;

public class Constant {

	public static WebDriver WEBDRIVER;
//	public static final String RAILWAY_URL = "http://192.168.189.206:8888/Page/HomePage.cshtml";
	public static final String RAILWAY_URL = "https://dbdeec00.ngrok.io";
	public static final String USERNAME = "huy.ho@logigear.com";
	public static final String USERNAMECHANGEPWD = "huy.ho1@mailinator.com";
	public static final String USERNAMENOTACTIVE = "huyhocntt168@gmail.com";
	public static final String PASSWORD = "L0gigear1993";
	public static final String PWDCHANGEPWD = "123456789";
	public static final String PID = "123456789";
	public static final String WRONG_PASSWORD = "wrongPwd";
	
	public static final String EMAILRESETPWD = "https://www.mailinator.com/v3/index.jsp?zone=public&query=huy.ho1#/#inboxpane";
	
	public enum TabName {
		LOGOUT("Log out"),
		LOGIN("Login"),
		BOOKTICKET("Book ticket"),
		MYTICKET("My ticket"),
		CHANGEPWD("Change password"),
		REGISTER("Register");
		
		private String tabName;
		TabName(String tabname) {
			this.tabName = tabname;
		}
		
		public String getName() {
			return tabName;
		}
	}
	
	public enum DepartStation {
		SAIGON("Sài Gòn"),
		PHANTHIET("Phan Thiết"),
		NHATRANG("Nha Trang"),
		DANANG("Đà Nẵng"),
		HUE("Huế"),
		QUANGNGAI("Quảng Ngãi");
		
		private String departStation;
		DepartStation(String departStation) {
			this.departStation = departStation;
		}
		
		public String getDepartStation() {
			return departStation;
		}
	}
	
	public enum ArriveStation {
		SAIGON("Sài Gòn"),
		PHANTHIET("Phan Thiết"),
		NHATRANG("Nha Trang"),
		DANANG("Đà Nẵng"),
		HUE("Huế"),
		QUANGNGAI("Quảng Ngãi");
		
		private String arriveStation;
		ArriveStation(String arriveStation) {
			this.arriveStation = arriveStation;
		}
		
		public String getArriveStation() {
			return arriveStation;
		}
	}
	
	public enum SeatType {
		HARDSEAT("Hard seat"),
		SOFTSEAT("Soft seat"),
		SOFTSEAT_AIR("Soft seat with air conditioner"),
		HARDBED("Hard bed"),
		SOFTBED("Soft bed"),
		SOFTBED_AIR("Soft bed with air conditioner");
		
		private String seatType;
		SeatType(String seatType) {
			this.seatType = seatType;
		}
		
		public String getSeatType() {
			return seatType;
		}
	}
	
}

