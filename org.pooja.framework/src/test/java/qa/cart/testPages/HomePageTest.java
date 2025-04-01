package qa.cart.testPages;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
	public void searchTest() {
		String actualSearchHeader=homepage.doSearch("macbook");
		Assert.assertEquals(actualSearchHeader, "Search - macbook");
		
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
	

}
