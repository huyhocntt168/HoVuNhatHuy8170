package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Constant.Constant;
import Constant.Messages;
import Constant.TabName;

public class ChangePasswordTest extends TestBase {
	LoginPage loginPage = new LoginPage();
	ChangePasswordPage changePassword = new ChangePasswordPage();
	
	@Test(description = "User can change password")
	public void TC01() {
		homePage.goToPage(TabName.login);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		loginPage.goToPage(TabName.changePwd);
		changePassword.changePwd(Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
		assertEquals(changePassword.getChangePwdMsg(), Messages.changePwdSuccess, String.format("%s must be displayed", Messages.changePwdSuccess));
	}
}
