package qa.cart.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.microsoft.playwright.Page;

import qa.PlaywrightFactory.PlaywrightFactory;
import qa.cart.pages.HomePage;

public class BaseTest {
	PlaywrightFactory pf;
	Page page;
	protected HomePage homepage;
	
	
	@BeforeTest
	public void setup() {
		pf=new PlaywrightFactory();
		page=pf.init_browser("chrome");
		homepage=new HomePage(page);
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"ipad"},
			{"iphone"},
			{"macbook"}
		};
	}

}
