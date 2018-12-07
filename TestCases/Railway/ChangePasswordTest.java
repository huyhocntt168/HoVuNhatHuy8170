package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Constant.Messages;

public class ChangePasswordTest extends TestBase {
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage = new RegisterPage();
	ChangePasswordPage changePassword = new ChangePasswordPage();
	
	@Test(description = "User can change password")
	public void TC09() {
		homePage.openTab(Constant.TabName.REGISTER);
		registerPage.registerAccount(Utilities.getValidEmail(),Constant.PASSWORD);
		registerPage.activateAccount();
		registerPage.openTab(Constant.TabName.LOGIN);
		loginPage.login(Utilities.createdEmail, Constant.PASSWORD);
		loginPage.openTab(Constant.TabName.CHANGEPASSWORD);
		changePassword.changePassword(Constant.PASSWORD, Constant.PASSWORD_CHANGED, Constant.PASSWORD_CHANGED);
		assertEquals(changePassword.getChangePwdMsg(), Messages.SUCCESS_CHANGE_PASSWORD);
	}
}
