package Railway;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import Common.Messages;
import Common.Utilities;
import Constant.Constant;

public class LoginTest {

	Utilities utilities = new Utilities();
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();

	@BeforeClass
	public void beforeClass() {
		System.out.println("Pre-condition");
		utilities.openChrome();
		homePage.open();
		homePage.clickTab("Login");
	}

	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		String actualMsg = loginPage.getWelcomeMessage();
		String expectedMsg = Messages.welcomeMsg;
		utilities.AssertEqual(actualMsg, expectedMsg);
		loginPage.Logout();
	}

	@Test(description = "User can't login with blank \"Username\" textbox")
	public void TC02() {
		loginPage.login("", Constant.PASSWORD);
		String actualMsg = loginPage.getErrorMsg();
		String expectedMsg = Messages.loginErrorMsg;

		Assert.assertEquals(actualMsg, expectedMsg,
				String.format("Error message %s must be displayed", Messages.loginErrorMsg));
	}

	@Test(description = "User cannot log into Railway with invalid password")
	public void TC03() {
		loginPage.login(Constant.USERNAME, "invalidPwd");
		String actualMsg = loginPage.getErrorMsg();
		String expectedMsg = Messages.loginErrorMsg;

		Assert.assertEquals(actualMsg, expectedMsg,
				String.format("Error message %s must be displayed", Messages.loginErrorMsg));
	}

	@Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
	public void TC04() {
		homePage.clickTab("Book ticket");

		String actualContent = homePage.getPageContent();
		String expectedContent = "Login page";
		
		Assert.assertEquals(actualContent, expectedContent, "Login page is not displayed as expected");
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {
		loginPage.login(Constant.USERNAME, Constant.WRONG_PASSWORD, 4);
		String actualMsg = loginPage.getErrorMsg();
		String expectedMsg = Messages.loginWrongPwdSeveralTimesMsg;

		Assert.assertEquals(actualMsg, expectedMsg,
				String.format("Error message %s must be displayed", Messages.loginWrongPwdSeveralTimesMsg));
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}

}
