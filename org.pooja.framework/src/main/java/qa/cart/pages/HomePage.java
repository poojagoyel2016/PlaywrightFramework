package qa.cart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	
	private String search="input[name='search']";
	private String searchIcon="span.input-group-btn";
	private String searchPageHeader="div#content h1";
	private String myAccount="//span[text()='My Account']";
	private String login="//li/a[text()='Login']";

	public HomePage(Page page) {
		this.page=page;
	}

	
	public String getHomePageTitle() {
		return page.title();
	}
	
	public String getHomePageURL() {
		return page.url();
	}
	
	public String doSearch(String productName) {
		page.locator(search).first().fill(productName);
		page.locator(searchIcon).click();
		return page.locator(searchPageHeader).textContent();
	}
	public LoginPage navigateToLogin() {
		page.locator(myAccount).click();
		page.locator(login).first().click();
		return new LoginPage(page);
		
	}
}
