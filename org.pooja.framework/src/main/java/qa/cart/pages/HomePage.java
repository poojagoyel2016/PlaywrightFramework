package qa.cart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	private Page page;
	public HomePage(Page page) {
		this.page=page;
	}
	private String search="input[name='search']";
	private String searchIcon="span.input-group-btn";
	private String searchPageHeader="div#content h1";
	
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
}
