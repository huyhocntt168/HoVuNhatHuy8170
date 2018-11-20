package Common;

import Constant.Constant;

public interface Messages {
	String welcomeMsg = String.format("Welcome %s ", Constant.USERNAME);
	String loginErrorMsg = "There was a problem with your login and/or errors exist in your form.";
	String loginWrongPwdSeveralTimesMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
}
