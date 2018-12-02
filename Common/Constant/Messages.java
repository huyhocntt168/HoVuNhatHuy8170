package Constant;

public class Messages {
	public static final String WELCOME = "Welcome %s";
	public static final String WELCOME_DEFAULT = "Welcome guest";

	public static final String ERROR_LOGIN_FORM = "There was a problem with your login and/or errors exist in your form.";
	public static final String ERROR_LOGIN_SEVERAL_TIMES = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
	public static final String ERROR_LOGIN_INACTIVE_ACCOUNT = "Invalid username or password. Please try again.";

	public static final String SUCCESS_CHANGE_PASSWORD = "Your password has been updated";

	public static final String ERROR_REGISTER_FORM = "There're errors in the form. Please correct the errors and try again.";
	public static final String SUCCESS_REGISTER = "Thank you for registering your account";
	public static final String ERROR_REGISTER_INVALID_PASSWORD = "Invalid password length.";
	public static final String ERROR_REGISTER_INVALID_PID = "Invalid ID length.";

	public static final String ERROR_RESET_PASSWORD_EMPTY_TOKEN = "The password reset token is invalid.";
	public static final String ERROR_RESET_PASSWORD_FORM_EMPTY_TOKEN = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
	public static final String ERROR_RESET_PASSWORD_FORM_CONFIRM_PASSWORD_NOT_MATCH = "Could not reset password. Please correct the errors and try again.";
	public static final String ERROR_RESET_PASSWORD_CONFIRM_PASSWORD_NOT_MATCH = "The password confirmation did not match the new password.";
}
