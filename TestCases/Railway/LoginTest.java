package Railway;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import Common.Utilities;
import Constant.Constant;

public class LoginTest {

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Pre-condition");
	  
	  System.setProperty("webdriver.chrome.driver", Utilities.getProjactPath() + "\\Executables\\chromedriver.exe");
	  Constant.WEBDRIVER = new ChromeDriver();
	  Constant.WEBDRIVER.manage().window().maximize();
  }

  @Test
  public void TC01() {
	  System.out.println("TC01 - User can log into Railway with valid username and password");
	  HomePage homePage = new HomePage();
	  homePage.open();
	  
	  LoginPage loginPage = homePage.gotoLoginPage();
	  
	  String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
	  String expectedMsg = "Welcome " + Constant.USERNAME;
	  
	  Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
	  loginPage.Logout();
  }
  
  @Test
  public void TC02() {
	  System.out.println("TC02 - User can't login with blank \"Username\" textbox");
	  HomePage homePage = new HomePage();
	  homePage.open();
	  
	  LoginPage loginPage = homePage.gotoLoginPage();
	  
	  String actualMsg = loginPage.loginFail("", Constant.PASSWORD).getErrorMsg();
	  String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
	  
	  Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
  }
  
  @Test
  public void TC03() {
	  System.out.println("TC03 - User cannot log into Railway with invalid password");
	  HomePage homePage = new HomePage();
	  homePage.open();
	  
	  LoginPage loginPage = homePage.gotoLoginPage();
	  
	  String actualMsg = loginPage.loginFail(Constant.USERNAME, "invalidPwd").getErrorMsg();
	  String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
	  
	  Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
  }
  
  @Test
  public void TC04() {
	  System.out.println("TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab");
	  HomePage homePage = new HomePage();
	  homePage.open();
	  
	  BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
	  
	  String actualContent = bookTicketPage.getPageContent();
	  String expectedContent = "Login page";
	  
	  Assert.assertEquals(actualContent, expectedContent, "Login page is not displayed as expected");
  }
  
  @Test
  public void TC05() {
	  System.out.println("TC05 - System shows message when user enters wrong password several times");
	  HomePage homePage = new HomePage();
	  homePage.open();
	  
	  LoginPage loginPage = homePage.gotoLoginPage();
	  
	  loginPage.loginFail(Constant.USERNAME, Constant.WRONG_PASSWORD);
	  loginPage.loginFail(Constant.USERNAME, Constant.WRONG_PASSWORD);
	  loginPage.loginFail(Constant.USERNAME, Constant.WRONG_PASSWORD);
	  String actualMsg = loginPage.loginFail(Constant.USERNAME, Constant.WRONG_PASSWORD).getErrorMsg();
	  String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
	  
	  Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
  }
  
  @AfterClass
  public void afterClass() {
	  System.out.println("Post-condition");
	  
	  Constant.WEBDRIVER.quit();
  }

}
