package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Common.ElementHelper;
import Common.Utilities;
import Constant.Constant;
import Constant.Messages;

public class ChangePasswordTest extends TestBase {
	HomePage homePage = new HomePage();
	ElementHelper elementHelper = new ElementHelper();
	LoginPage loginPage = new LoginPage();
	ChangePasswordPage changePassword = new ChangePasswordPage();
	SoftAssert softAssert = new SoftAssert();
	
	@Test(description = "User can change password")
	public void TC01() {
		homePage.goToPage(Constant.TabName.LOGIN);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		loginPage.goToPage(Constant.TabName.CHANGEPWD);
		changePassword.changePwd(Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
		softAssert.assertEquals(changePassword.getChangePwdMsg(), Messages.changePwdSuccess);
//		changePassword.changePwd(Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
		softAssert.assertAll();
	}
}
