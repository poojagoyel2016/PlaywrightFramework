package qa.cart.testPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import qa.cart.base.BaseTest;
import qa.cart.constants.Constants;

public class LoginPageTest extends BaseTest {
	@Test(priority=1)
	public void loginPageNavigationTest() {
		loginpage=homepage.navigateToLogin();	
	}
	
	@Test(priority=2)
	public void verifyTitle() {
		String actualTilte=loginpage.getLoginPageTitle();
		Assert.assertEquals(actualTilte, Constants.LOGIN_PAGE_TITLE);
	}
	@Test(priority=3)
	public void verifyForgotPasswordLinkTest() {
		boolean flag= loginpage.verifyForgotPasswordLink();
		Assert.assertTrue(flag);
		
	}
	@Test(priority=4)
	public void verifyLogin() {
		boolean flag=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		if(flag)
			System.out.println("login successful");
		else
			System.out.println("login failed");
	}
}
