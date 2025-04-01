package qa.cart.testPages;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import qa.PlaywrightFactory.PlaywrightFactory;
import qa.cart.pages.HomePage;

public class HomePageTest {
	PlaywrightFactory pf;
	Page page;
	HomePage homepage;
	
	
	@BeforeTest
	public void setup() {
		pf=new PlaywrightFactory();
		page=pf.init_browser("chrome");
		homepage=new HomePage(page);
	}
	
	@Test
	public void homePageTitleTest() {
		String actualTitle=homepage.getHomePageTitle();
		Assert.assertEquals(actualTitle, "Your Store");
	
	}
	@Test
	public void homePageURLTest() {
		String actualURL=homepage.getHomePageURL();
		Assert.assertEquals(actualURL, "https://naveenautomationlabs.com/opencart/");
	
	}
	@Test(dataProvider="getProductData")
	public void searchTest(String product) {
		String actualSearchHeader=homepage.doSearch(product);
		Assert.assertEquals(actualSearchHeader, "Search - "+ product);
		
	}
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"ipad"},
			{"iphone"},
			{"macbook"}
		};
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
	

}
