package Railway;

import org.testng.annotations.Test;

import Constant.Constant;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.*;

import org.testng.annotations.AfterClass;

import Constant.Messages;
import Common.Utilities;
import Constant.TabName;

public class RegisterTest extends TestBase {
	RegisterPage registerPage = new RegisterPage();
	
	@Test(description = "User can create new account")
	public void TC01() {
		homePage.goToPage(TabName.register);
		registerPage.registerAccount(utilities.validEmail(),Constant.PASSWORD, Constant.PASSWORD,Constant.PID);
		String actualMsg = registerPage.getPageContent();
		String expectedMsg = Messages.registerSuccess;

		assertEquals(actualMsg, expectedMsg,
				String.format("Error message %s must be displayed", Messages.registerSuccess));
	}
	
	@Test(description = "User can't create account with \"Confirm password\" is not the same with \"Password\"")
	public void TC02() {
		homePage.goToPage(TabName.register);
		registerPage.registerAccount(utilities.validEmail(),Constant.PASSWORD, Constant.WRONG_PASSWORD,Constant.PID);
		String actualMsg = registerPage.getErrorMsg();
		String expectedMsg = Messages.registerError;

		assertEquals(actualMsg, expectedMsg,
				String.format("Error message %s must be displayed", Messages.registerError));
	}

}
