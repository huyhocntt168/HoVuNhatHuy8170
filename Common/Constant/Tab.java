package Constant;

public enum Tab {
	logout("Log out"),
	login("Login"),
	bookTicket("Book ticket"),
	myTicket("My ticket"),
	changePwd("Change password"),
	register("Register");
	
	private String tabName;
	Tab(String tabname) {
		this.tabName = tabname;
	}
	
	public String Name() {
		return tabName;
	}
}
