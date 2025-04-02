package qa.cart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	Page page;
	public LoginPage(Page page) {
		this.page=page;
	}
	
	private String userName="E-Mail Address";
	private String password="Password";
	private String loginButton="//input[@value='Login']";
	private String forgotPassword="//a[text()='Forgotten Password']";
	private String logout="//a[text()='Logout']";
	
	public String getLoginPageTitle() {
		return page.title();
		
	}
	
	public boolean verifyForgotPasswordLink() {
		return page.isVisible(forgotPassword);
	}
	
	public boolean login(String username, String pass) {
		page.getByPlaceholder(userName).fill(username);
		page.getByPlaceholder(password).fill(pass);
		page.locator(loginButton).click();
		if(page.locator(logout).last().isVisible())
			return true;
		else 
			return false;
		
		
	}
	
	
}
