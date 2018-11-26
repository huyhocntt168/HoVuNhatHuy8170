package Constant;

import Constant.Constant;

public interface Messages {
	String welcome = String.format("Welcome %s", Constant.USERNAME);
	String welcomeDefault = "Welcome guest";
	String loginError = "There was a problem with your login and/or errors exist in your form.";
	String loginWrongPwdSeveralTimes = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
	String loginAccountNotActive = "Invalid username or password. Please try again.";
	String changePwdSuccess = "Your password has been updated";
	String registerError = "There're errors in the form. Please correct the errors and try again.";
	String registerSuccess = "Thank you for registering your account";
}
