package Railway;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Common.Utilities;
import Constant.Constant;
import Constant.Messages;

public class ForgotPasswordTest extends TestBase {
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
	RegisterPage registerPage = new RegisterPage();
	String USERNAME;

	@BeforeMethod
	public void beforeMethod() {
		homePage.openTab(Constant.TabName.REGISTER);
		registerPage.registerAccount(Utilities.getValidEmail(), Constant.PASSWORD);
		registerPage.activateAccount();
		registerPage.openTab(Constant.TabName.LOGIN);
		loginPage.goToForgotPasswordPage();
	}

	@Test(description = "Errors display when password reset token is blank")
	public void TC12() {
		SoftAssert softAssert = new SoftAssert();
		forgotPasswordPage.goToResetPasswordPage(Utilities.createdEmail);
		softAssert.assertEquals(forgotPasswordPage.getResetPasswordFormHeader(), "Password Change Form");
		forgotPasswordPage.resetPassword(Constant.PASSWORD_CHANGED, Constant.PASSWORD_CHANGED,
				Constant.EMPTY);
		softAssert.assertEquals(forgotPasswordPage.getErrorMsg(), Messages.ERROR_RESET_PASSWORD_FORM_EMPTY_TOKEN);
		softAssert.assertEquals(forgotPasswordPage.getTokenErrorMsg(), Messages.ERROR_RESET_PASSWORD_EMPTY_TOKEN);
		softAssert.assertAll();
	}

	@Test(description = "Errors display if password and confirm password don't match when resetting password")
	public void TC13() {
		SoftAssert softAssert = new SoftAssert();
		forgotPasswordPage.goToResetPasswordPage(USERNAME);
		softAssert.assertEquals(forgotPasswordPage.getResetPasswordFormHeader(), "Password Change Form");
		forgotPasswordPage.resetPassword(Constant.PASSWORD_CHANGED, Constant.PASSWORD_CHANGED + "1");
		softAssert.assertEquals(forgotPasswordPage.getErrorMsg(), Messages.ERROR_RESET_PASSWORD_FORM_CONFIRM_PASSWORD_NOT_MATCH);
		softAssert.assertEquals(forgotPasswordPage.getConfirmPwdErrorMsg(), Messages.ERROR_RESET_PASSWORD_CONFIRM_PASSWORD_NOT_MATCH);
		softAssert.assertAll();
	}
}
