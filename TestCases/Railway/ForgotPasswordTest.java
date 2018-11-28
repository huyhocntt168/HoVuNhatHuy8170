package Railway;

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
		SoftAssert softAssert = new SoftAssert();
		
		@Test(description = "User can change password")
		public void TC01(){
			homePage.goToPage(Constant.TabName.LOGIN);
			loginPage.goToForgotPwdPage();
			forgotPasswordPage.resetPassword(Constant.USERNAMECHANGEPWD);
		}
	}
