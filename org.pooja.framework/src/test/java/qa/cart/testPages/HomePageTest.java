package qa.cart.testPages;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.cart.base.BaseTest;
import qa.cart.constants.Constants;


public class HomePageTest extends BaseTest {
	
	
	@Test
	public void homePageTitleTest() {
		String actualTitle=homepage.getHomePageTitle();
		Assert.assertEquals(actualTitle, Constants.HOME_PAGE_TITLE);
	
	}
	@Test
	public void homePageURLTest() {
		String actualURL=homepage.getHomePageURL();
		Assert.assertEquals(actualURL, prop.getProperty("url"));
	
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
}
