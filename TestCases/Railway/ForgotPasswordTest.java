package Railway;

import javax.crypto.CipherInputStream;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Common.ElementHelper;
import Constant.Constant;
import Constant.Messages;

public class ForgotPasswordTest extends TestBase {
		HomePage homePage = new HomePage();
		ElementHelper elementHelper = new ElementHelper();
		LoginPage loginPage = new LoginPage();
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
		RegisterPage registerPage = new RegisterPage();
		SoftAssert softAssert = new SoftAssert();
		
		@Test(description = "User can change password")
		public void TC01(){
			homePage.goToPage(Constant.TabName.REGISTER);
			String email = utilities.validEmail();
			registerPage.registerAccount(email, Constant.PASSWORD, Constant.PASSWORD, Constant.PID);
			homePage.goToPage(Constant.TabName.LOGIN);
			loginPage.goToForgotPwdPage();
//			forgotPasswordPage.goToResetPassword("fancuong22@gmail.com");
			forgotPasswordPage.resetPasswordWithToken(email, Constant.PWDCHANGEPWD, Constant.PWDCHANGEPWD, "");
			Assert.assertEquals(forgotPasswordPage.getErrorMsg(), Messages.resetPwdWrongToken);
		}
	}
