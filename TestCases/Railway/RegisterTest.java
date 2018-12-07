package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Common.Utilities;
import Constant.Constant;
import Constant.Messages;

public class RegisterTest extends TestBase {
	HomePage homePage = new HomePage();
	RegisterPage registerPage = new RegisterPage();
	
	@BeforeMethod
	public void beforeMethod() {
		homePage.openTab(Constant.TabName.REGISTER);
	}
	
	@Test(description = "User can create new account")
	public void TC07() {
		registerPage.registerAccount(Utilities.getValidEmail(),Constant.PASSWORD);
		assertEquals(registerPage.getPageHeader(), Messages.SUCCESS_REGISTER);
	}
	
	@Test(description = "User can't create account with \"Confirm password\" is not the same with \"Password\"")
	public void TC10() {
		registerPage.registerAccount(Utilities.getValidEmail(),Constant.PASSWORD, Constant.PASSWORD + "1");
		assertEquals(registerPage.getErrorMsg(), Messages.ERROR_REGISTER_FORM);
	}
	
	@Test(description = "User can't create account while password and PID fields are empty")
	public void TC11() {
		SoftAssert softAssert = new SoftAssert();
		registerPage.registerAccount(Utilities.getValidEmail(), Constant.EMPTY, Constant.EMPTY, Constant.EMPTY);
		softAssert.assertEquals(registerPage.getErrorMsg(), Messages.ERROR_REGISTER_FORM);
		softAssert.assertEquals(registerPage.getPwdErrorMsg(), Messages.ERROR_REGISTER_INVALID_PASSWORD);
		softAssert.assertEquals(registerPage.getPidErrorMsg(), Messages.ERROR_REGISTER_INVALID_PID);
		softAssert.assertAll();
	}

}
