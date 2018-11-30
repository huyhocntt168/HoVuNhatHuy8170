package Constant;

public interface Messages {
	String welcome = "Welcome %s";
	String welcomeDefault = "Welcome guest";
	
	String loginError = "There was a problem with your login and/or errors exist in your form.";
	String loginWrongPwdSeveralTimes = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
	String loginAccountNotActive = "Invalid username or password. Please try again.";
	
	String changePwdSuccess = "Your password has been updated";
	
	String registerError = "There're errors in the form. Please correct the errors and try again.";
	String registerSuccess = "Thank you for registering your account";
	String registerPwdError = "Invalid password length.";
	String registerPidError = "Invalid ID length.";
	
	String resetPwdWrongToken = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
	String resetPwdFailMsg = "Could not reset password. Please correct the errors and try again.";
}
