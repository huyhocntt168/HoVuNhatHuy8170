package Railway;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Constant.Constant;

import static org.testng.Assert.*;


import Constant.Messages;
import Common.ElementHelper;

public class RegisterTest extends TestBase {
	HomePage homePage = new HomePage();
	ElementHelper elementHelper = new ElementHelper();
	RegisterPage registerPage = new RegisterPage();
	SoftAssert softAssert = new SoftAssert();
	
	@Test(description = "User can create new account")
	public void TC01() {
		homePage.goToPage(Constant.TabName.REGISTER);
		registerPage.registerAccount(utilities.validEmail(),Constant.PASSWORD, Constant.PASSWORD,Constant.PID);
		assertEquals(registerPage.getPageContent(), Messages.registerSuccess);
	}
	
	@Test(description = "User can't create account with \"Confirm password\" is not the same with \"Password\"")
	public void TC02() {
		homePage.goToPage(Constant.TabName.REGISTER);
		registerPage.registerAccount(utilities.validEmail(),Constant.PASSWORD, Constant.PASSWORD + "1",Constant.PID);
		assertEquals(registerPage.getErrorMsg(), Messages.registerError);
	}
	
	@Test(description = "User can't create account while password and PID fields are empty")
	public void TC03() {
		homePage.goToPage(Constant.TabName.REGISTER);
		registerPage.registerAccount(utilities.validEmail(),"", "","");
		softAssert.assertEquals(registerPage.getErrorMsg(), Messages.registerError);
		softAssert.assertEquals(registerPage.getPwdErrorMsg(), Messages.registerPwdError);
		softAssert.assertEquals(registerPage.getPidErrorMsg(), Messages.registerPidError);
		softAssert.assertAll();
	}

}
